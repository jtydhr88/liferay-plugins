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

package com.liferay.oauthlogin.display.portlet;

import com.liferay.oauthlogin.model.OAuthConnection;
import com.liferay.oauthlogin.service.OAuthConnectionLocalServiceUtil;
import com.liferay.oauthlogin.util.WebKeys;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.oauth.OAuthConstants;
import com.liferay.portal.kernel.oauth.OAuthFactoryUtil;
import com.liferay.portal.kernel.oauth.OAuthManager;
import com.liferay.portal.kernel.oauth.Token;
import com.liferay.portal.kernel.oauth.Verb;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.PortletKeys;
import com.liferay.portlet.PortletURLFactoryUtil;
import com.liferay.portlet.expando.model.ExpandoTableConstants;
import com.liferay.portlet.expando.service.ExpandoValueLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletMode;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author Terry Jia
 */
public class DisplayPortlet extends MVCPortlet {

	public void getAuthorizeURL(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		long oAuthConnectionId = ParamUtil.getLong(
			actionRequest, "oAuthConnectionId");

		OAuthConnection oAuthConnection =
			OAuthConnectionLocalServiceUtil.getOAuthConnection(
				oAuthConnectionId);

		String authorizeURL = oAuthConnection.getAuthorizeURL();

		String accessTokenURL = oAuthConnection.getAccessTokenURL();

		Verb accessTokenVerb = Verb.GET;

		if (oAuthConnection.getAccessTokenVerb() == OAuthConstants.POST) {
			accessTokenVerb = Verb.POST;
		}

		OAuthManager oAuthManager = null;

		Token requestToken = null;

		String redirectURL =  oAuthConnection.getRedirectURL();

		PortletURL loginRedirectURL = PortletURLFactoryUtil.create(
			actionRequest, PortletKeys.LOGIN, themeDisplay.getPlid(),
			PortletRequest.RENDER_PHASE);

		loginRedirectURL.setPortletMode(PortletMode.VIEW);
		loginRedirectURL.setParameter(
			"struts_action", "/login/login_redirect");
		loginRedirectURL.setParameter(
			"anonymousUser", Boolean.FALSE.toString());

		redirectURL = HttpUtil.addParameter(
			redirectURL, "redirect", loginRedirectURL.toString());

		redirectURL = HttpUtil.addParameter(
			redirectURL, "oAuthConnectionId", String.valueOf(
				oAuthConnectionId));

		if (oAuthConnection.getOAuthVersion() == OAuthConstants.OAUTH_10A) {
			authorizeURL = authorizeURL + "?oauth_token=%s";

			String requestTokenURL = oAuthConnection.getRequestTokenURL();

			oAuthManager = OAuthFactoryUtil.createOAuthManager(
				oAuthConnection.getKey(), oAuthConnection.getSecret(),
				accessTokenURL, authorizeURL, requestTokenURL,
				redirectURL, oAuthConnection.getScope());

			requestToken = oAuthManager.getRequestToken();

			HttpServletRequest request = PortalUtil.getHttpServletRequest(
				actionRequest);

			HttpSession session = request.getSession();

			session.setAttribute("requestToken", requestToken);
		}
		else {
			authorizeURL = authorizeURL +
				"?client_id=%s&redirect_uri=%s&response_type=code";

			accessTokenURL = oAuthConnection.getAccessTokenURL() +
				"?grant_type=authorization_code";

			if (Validator.isNotNull(oAuthConnection.getScope())) {
				authorizeURL = authorizeURL + "&scope=%s";
			}

			oAuthManager = OAuthFactoryUtil.createOAuthManager(
				oAuthConnection.getKey(), oAuthConnection.getSecret(),
				accessTokenURL, authorizeURL, redirectURL,
				oAuthConnection.getScope(), accessTokenVerb,
				oAuthConnection.getAccessTokenExtractorType());
		}

		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

		jsonObject.put(
			"authorizeURL", oAuthManager.getAuthorizeURL(requestToken));

		writeJSON(actionRequest, actionResponse, jsonObject);
	}

	public void unbindSocialAccount(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		long userId = themeDisplay.getUserId();

		long companyId = themeDisplay.getCompanyId();

		String oAuthConnectionId = ParamUtil.getString(
			actionRequest, "oAuthConnectionId");

		String expandoColumnName = oAuthConnectionId + "_social_account_id";

		ExpandoValueLocalServiceUtil.deleteValue(
			companyId, User.class.getName(),
			ExpandoTableConstants.DEFAULT_TABLE_NAME, expandoColumnName,
			userId);
	}

}