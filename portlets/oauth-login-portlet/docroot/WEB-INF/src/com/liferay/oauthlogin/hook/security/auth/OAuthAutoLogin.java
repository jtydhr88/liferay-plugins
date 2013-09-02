/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.oauthlogin.hook.security.auth;

import com.liferay.oauthlogin.model.OAuthConnection;
import com.liferay.oauthlogin.service.OAuthConnectionLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.BaseAutoLogin;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.expando.model.ExpandoTableConstants;
import com.liferay.portlet.expando.model.ExpandoValue;
import com.liferay.portlet.expando.service.ExpandoValueLocalServiceUtil;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Terry Jia
 */
public class OAuthAutoLogin extends BaseAutoLogin {

	@Override
	protected String[] doLogin(
			HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		HttpSession session = request.getSession();

		Object socialAccountIdObj = session.getAttribute("socialAccountId");

		Object oAuthConnectionIdObj = session.getAttribute("oAuthConnectionId");

		long companyId = PortalUtil.getCompanyId(request);

		if ((socialAccountIdObj == null) || (oAuthConnectionIdObj == null)) {
			return null;
		}

		session.removeAttribute("socialAccountId");

		session.removeAttribute("oAuthConnectionId");

		String socialAccountId = String.valueOf(socialAccountIdObj);

		long oAuthConnectionId = (Long)oAuthConnectionIdObj;

		OAuthConnection oAuthConnection =
			OAuthConnectionLocalServiceUtil.getOAuthConnection(
				oAuthConnectionId);

		if (!oAuthConnection.isEnabled()) {
			return null;
		}

		User user = getUser(companyId, oAuthConnectionId, socialAccountId);

		if (user == null) {
			return null;
		}

		String[] credentials = new String[3];

		credentials[0] = String.valueOf(user.getUserId());
		credentials[1] = user.getPassword();
		credentials[2] = Boolean.FALSE.toString();

		return credentials;
	}

	protected User getUser(
		long companyId, long oAuthConnectionId, String socialAccountId) {

		User user = null;

		try {
			List<ExpandoValue> expandoValues =
				ExpandoValueLocalServiceUtil.getColumnValues(
					companyId, User.class.getName(),
					ExpandoTableConstants.DEFAULT_TABLE_NAME,
					oAuthConnectionId + "_social_account_id", socialAccountId,
					QueryUtil.ALL_POS, QueryUtil.ALL_POS);

			if (expandoValues.size() > 0) {
				long userId = expandoValues.get(0).getClassPK();

				user = UserLocalServiceUtil.getUser(userId);
			}
		}
		catch (PortalException pe) {
		}
		catch (SystemException pe) {
		}

		return user;
	}

}