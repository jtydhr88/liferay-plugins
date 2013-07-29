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

package com.liferay.oauthlogin.hook.action;

import com.liferay.oauthlogin.model.OAuthConnection;
import com.liferay.oauthlogin.service.OAuthConnectionLocalServiceUtil;
import com.liferay.oauthlogin.util.WebKeys;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.oauth.OAuthConstants;
import com.liferay.portal.kernel.oauth.OAuthFactoryUtil;
import com.liferay.portal.kernel.oauth.OAuthManager;
import com.liferay.portal.kernel.oauth.OAuthRequest;
import com.liferay.portal.kernel.oauth.OAuthResponse;
import com.liferay.portal.kernel.oauth.Token;
import com.liferay.portal.kernel.oauth.Verb;
import com.liferay.portal.kernel.oauth.Verifier;
import com.liferay.portal.kernel.struts.BaseStrutsAction;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.expando.model.ExpandoTableConstants;
import com.liferay.portlet.expando.model.ExpandoValue;
import com.liferay.portlet.expando.service.ExpandoValueLocalServiceUtil;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Terry Jia
 */
public class OAuthConnectAction extends BaseStrutsAction {

	@Override
	public String execute(
			HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
			WebKeys.THEME_DISPLAY);

		long companyId = themeDisplay.getCompanyId();

		HttpSession session = request.getSession();

		long oAuthConnectionId = (Long)session.getAttribute(
			"LIFERAY_SHARED_oAuthConnectionId");

		OAuthConnection oAuthConnection =
			OAuthConnectionLocalServiceUtil.getOAuthConnection(
				oAuthConnectionId);

		String redirectURL = PortalUtil.getHomeURL(request);

		session.removeAttribute("LIFERAY_SHARED_oAuthConnectionId");

		if (!oAuthConnection.isEnabled()) {
			throw new PrincipalException();
		}

		String code = ParamUtil.getString(request, "code");

		if (Validator.isNotNull(code)) {
			String accessTokenURL = oAuthConnection.getAccessTokenURL() +
				"?grant_type=authorization_code";

			Verifier verifier = OAuthFactoryUtil.createVerifier(code);

			Verb accessTokenVerb = Verb.GET;

			if (oAuthConnection.getAccessTokenVerb() == OAuthConstants.POST) {
				accessTokenVerb = Verb.POST;
			}

			OAuthManager oAuthManager = OAuthFactoryUtil.createOAuthManager(
				oAuthConnection.getKey(), oAuthConnection.getSecret(),
				accessTokenURL, oAuthConnection.getAuthorizeURL(),
				oAuthConnection.getRedirectURL(), oAuthConnection.getScope(),
				accessTokenVerb, oAuthConnection.getAccessTokenExtratorType());

			Token requestToken = OAuthFactoryUtil.createToken(
				oAuthConnection.getKey(), oAuthConnection.getSecret());

			Token accessToken = oAuthManager.getAccessToken(
				requestToken, verifier);

			String socialAccountIdURL = oAuthConnection.getSocialAccountIdURL();

			Verb socialAccountIdURLVerb = Verb.GET;

			if (oAuthConnection.getSocialAccountIdURLVerb() ==
				OAuthConstants.POST) {

				socialAccountIdURLVerb = Verb.POST;
			}

			OAuthRequest meRequest = OAuthFactoryUtil.createOAuthRequest(
				socialAccountIdURLVerb, socialAccountIdURL);

			oAuthManager.signRequest(accessToken, meRequest);

			OAuthResponse oAuthResponse = meRequest.send();

			if (oAuthResponse.getStatus() == 200) {
				String socialAccountId = StringPool.BLANK;

				if (oAuthConnection.getSocialAccountIdType() ==
					OAuthConstants.EXTRATOR_JSON_OBJECT) {

					try {
						JSONObject jsonObject =
							JSONFactoryUtil.createJSONObject(
								oAuthResponse.getBody());

						socialAccountId = jsonObject.getString(
							oAuthConnection.getSocialAccountIdField());
						}
					catch (Exception e) {
					}
				}
				else {
					String script = oAuthConnection.getSocialAccountIdScript();

					Matcher matcher = Pattern.compile(script).matcher(
						oAuthResponse.getBody());

					if (matcher.find())
						socialAccountId = matcher.group(1);
					else {
					}
				}

				long userId = themeDisplay.getUserId();

				List<ExpandoValue> expandoValues =
					ExpandoValueLocalServiceUtil.getColumnValues(
						companyId, User.class.getName(),
						ExpandoTableConstants.DEFAULT_TABLE_NAME,
						oAuthConnectionId + "_social_account_id",
						socialAccountId, QueryUtil.ALL_POS,
						QueryUtil.ALL_POS);

				session.setAttribute(
					"LIFERAY_SHARED_socialAccountId", socialAccountId);

				session.setAttribute(
					"LIFERAY_SHARED_oAuthConnectionId", oAuthConnectionId);

				if (expandoValues.size() == 0) {
					if (userId == themeDisplay.getDefaultUserId()) {
						redirectURL = PortalUtil.getCreateAccountURL(
							request, themeDisplay);
					}
					else {
						ExpandoValueLocalServiceUtil.addValue(
							companyId, User.class.getName(),
							ExpandoTableConstants.DEFAULT_TABLE_NAME,
							oAuthConnectionId + "_social_account_id", userId,
							socialAccountId);
					}
				}
			}
		}

		response.sendRedirect(redirectURL);

		return null;
	}

}