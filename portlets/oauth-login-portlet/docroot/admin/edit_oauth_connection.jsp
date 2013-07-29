<%--
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
--%>

<%@ include file="/admin/init.jsp" %>

<%
String backURL = ParamUtil.getString(request, "backURL");

OAuthConnection oAuthConnection = (OAuthConnection)request.getAttribute(WebKeys.OAUTH_CONNECTION);
%>

<liferay-ui:header 
	backURL="<%= backURL %>"
	title='<%= (oAuthConnection == null) ? "new-oauth-connection" : oAuthConnection.getName() %>'
/>

<portlet:actionURL name="updateOAuthConnection" var="updateOAuthConnectionURL" />

<aui:form action="<%= updateOAuthConnectionURL %>" enctype="multipart/form-data" method="post" name="fm">
	<aui:model-context bean="<%= oAuthConnection %>" model="<%= OAuthConnection.class %>" />

	<aui:input name="oAuthConnectionId" type="hidden" value="<%= (oAuthConnection != null) ? oAuthConnection.getOAuthConnectionId():0 %>" />

	<liferay-ui:panel-container extended="<%= true %>" id="oAuthConnectionPanelContainer" persistState="<%= true %>">

		<aui:fieldset>
			<aui:input name="enabled" type="checkbox" value="<%= (oAuthConnection != null) && (oAuthConnection.getEnabled()) %>" />

			<aui:input name="name" />

			<aui:input name="description" type="textarea" />

			<aui:input name="icon" type="file" />
		</aui:fieldset>

		<liferay-ui:panel collapsible="<%= true %>" extended="<%= true %>" id="oAuthConnectionOAuthInfo" persistState="<%= true %>" title="oAuthConnection-OAuth-info">
			<aui:fieldset>
				<aui:select label="oAuthVersion" name="oAuthVersion">
					<aui:option label="<%= OAuthConstants.LABEL_OAUTH_20 %>" selected="<%= (oAuthConnection != null) && (oAuthConnection.getOAuthVersion() == OAuthConstants.OAUTH_20) %>" value="<%= OAuthConstants.OAUTH_20 %>" />
					<aui:option label="<%= OAuthConstants.LABEL_OAUTH_10A %>" selected="<%= (oAuthConnection != null) && (oAuthConnection.getOAuthVersion() == OAuthConstants.OAUTH_10A) %>" value="<%= OAuthConstants.OAUTH_10A %>" />
				</aui:select>

				<aui:input name="key" />

				<aui:input name="secret" />

				<aui:input label="graph-url" name="graphURL" />

				<aui:input name="scope" />

				<aui:input label="authorize-url" name="authorizeURL" />

				<div id="<portlet:namespace />accessTokenDiv">
					<aui:input label="access-token-url" name="accessTokenURL" />

					<aui:select name="accessTokenVerb">
						<aui:option label="<%= OAuthConstants.LABEL_GET %>" selected="<%= (oAuthConnection != null) && (oAuthConnection.getAccessTokenVerb() == OAuthConstants.GET) %>" value="<%= OAuthConstants.GET %>" />
						<aui:option label="<%= OAuthConstants.LABEL_POST %>" selected="<%= (oAuthConnection != null) && (oAuthConnection.getAccessTokenVerb() == OAuthConstants.POST) %>" value="<%= OAuthConstants.POST %>" />
					</aui:select>
				</div>

				<div id="<portlet:namespace />accessTokenExtratorTypeDiv">
					<aui:select name="accessTokenExtratorType">
						<aui:option label="<%= OAuthConstants.LABEL_EXTRATOR_DEFAULT %>" selected="<%= (oAuthConnection != null) && (oAuthConnection.getAccessTokenExtratorType() == OAuthConstants.EXTRATOR_DEFAULT) %>" value="<%= OAuthConstants.EXTRATOR_DEFAULT %>" />
						<aui:option label="<%= OAuthConstants.LABEL_EXTRATOR_JSON_OBJECT %>" selected="<%= (oAuthConnection != null) && (oAuthConnection.getAccessTokenExtratorType() == OAuthConstants.EXTRATOR_JSON_OBJECT) %>" value="<%= OAuthConstants.EXTRATOR_JSON_OBJECT %>" />
						<aui:option label="<%= OAuthConstants.LABEL_EXTRATOR_CUSTOM %>" selected="<%= (oAuthConnection != null) && (oAuthConnection.getAccessTokenExtratorType() == OAuthConstants.EXTRATOR_CUSTOM) %>" value="<%= OAuthConstants.EXTRATOR_CUSTOM %>" />
					</aui:select>
				</div>

				<div id="<portlet:namespace />accessTokenExtratorScriptDiv">
					<aui:input name="accessTokenExtratorScript" type="textarea" />
				</div>

				<div id="<portlet:namespace />requestTokenDiv">
					<aui:input label="request-token-url" name="requestTokenURL" />

					<aui:select name="requestTokenVerb">
						<aui:option label="<%= OAuthConstants.LABEL_GET %>" selected="<%= (oAuthConnection != null) && (oAuthConnection.getRequestTokenVerb() == OAuthConstants.GET) %>" value="<%= OAuthConstants.GET %>" />
						<aui:option label="<%= OAuthConstants.LABEL_POST %>" selected="<%= (oAuthConnection != null) && (oAuthConnection.getRequestTokenVerb() == OAuthConstants.POST) %>" value="<%= OAuthConstants.POST %>" />
					</aui:select>
				</div>

				<aui:input label="redirect-url" name="redirectURL" />
			</aui:fieldset>
		</liferay-ui:panel>

		<liferay-ui:panel collapsible="<%= true %>" extended="<%= true %>" id="oAuthConnectionSocialAccountIdInfo" persistState="<%= true %>" title="oAuthConnection-social-account-id-info">
			<aui:fieldset>
				<aui:input label="social-account-id-url" name="socialAccountIdURL" />

				<aui:select label="social-account-id-url-verb" name="socialAccountIdURLVerb">
					<aui:option label="<%= OAuthConstants.LABEL_GET %>" selected="<%= (oAuthConnection != null) && (oAuthConnection.getSocialAccountIdURLVerb() == OAuthConstants.GET) %>" value="<%= OAuthConstants.GET %>" />
					<aui:option label="<%= OAuthConstants.LABEL_POST %>" selected="<%= (oAuthConnection != null) && (oAuthConnection.getSocialAccountIdURLVerb() == OAuthConstants.POST) %>" value="<%= OAuthConstants.POST %>" />
				</aui:select>

				<aui:input label="social-account--id-field" name="socialAccountIdField" />

				<div id="<portlet:namespace />socialAccountIdTypeDiv">
					<aui:select name="socialAccountIdType">
						<aui:option label="<%= OAuthConstants.LABEL_EXTRATOR_JSON_OBJECT %>" selected="<%= (oAuthConnection != null) && (oAuthConnection.getSocialAccountIdType() == OAuthConstants.EXTRATOR_JSON_OBJECT) %>" value="<%= OAuthConstants.EXTRATOR_JSON_OBJECT %>" />
						<aui:option label="<%= OAuthConstants.EXTRATOR_CUSTOM %>" selected="<%= (oAuthConnection != null) && (oAuthConnection.getSocialAccountIdType() == OAuthConstants.EXTRATOR_CUSTOM) %>" value="<%= OAuthConstants.EXTRATOR_CUSTOM %>" />
					</aui:select>
				</div>

				<div id="<portlet:namespace />socialAccountIdScriptDiv">
					<aui:input name="socialAccountIdScript" type="textarea" />
				</div>
			</aui:fieldset>
		</liferay-ui:panel>
	</liferay-ui:panel-container>
	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>

<aui:script use="aui:base">
	var oauthVersion = A.one('#<portlet:namespace />oAuthVersion');
	var accessTokenDiv = A.one('#<portlet:namespace />accessTokenDiv');
	var requestTokenDiv = A.one('#<portlet:namespace />requestTokenDiv');

	var accessTokenExtratorType = A.one('#<portlet:namespace />accessTokenExtratorType');
	var accessTokenExtratorTypeDiv = A.one('#<portlet:namespace />accessTokenExtratorTypeDiv');
	var accessTokenExtratorScriptDiv = A.one('#<portlet:namespace />accessTokenExtratorScriptDiv');

	var socialAccountIdType = A.one('#<portlet:namespace />socialAccountIdType');
	var socialAccountIdTypeDiv = A.one('#<portlet:namespace />socialAccountIdTypeDiv');
	var socialAccountIdScriptDiv = A.one('#<portlet:namespace />socialAccountIdScriptDiv');

	if (document.getElementById("<portlet:namespace />oAuthVersion").value == <%= OAuthConstants.OAUTH_20 %> && requestTokenDiv) {
		requestTokenDiv.hide();
	}

	if (!(document.getElementById("<portlet:namespace />accessTokenExtratorType").value == <%= OAuthConstants.EXTRATOR_CUSTOM %>) && accessTokenExtratorScriptDiv) {
		accessTokenExtratorScriptDiv.hide();
	}

	if (!(document.getElementById("<portlet:namespace />socialAccountIdType").value == <%= OAuthConstants.EXTRATOR_CUSTOM %>) && socialAccountIdScriptDiv) {
		socialAccountIdScriptDiv.hide();
	}

	if (oauthVersion) {
		oauthVersion.on(
			'change',
			function(event) {
				if (document.getElementById("<portlet:namespace />oAuthVersion").value == <%= OAuthConstants.OAUTH_20 %> && requestTokenDiv) {
					accessTokenDiv.show();
					requestTokenDiv.hide();
				}
				else {
					requestTokenDiv.show();
				}
			}
		)
	}

	if (accessTokenExtratorType) {
		accessTokenExtratorType.on(
			'change',
			function(event) {
				if ((document.getElementById("<portlet:namespace />accessTokenExtratorType").value == <%= OAuthConstants.EXTRATOR_CUSTOM %>) && accessTokenExtratorScriptDiv) {
					accessTokenExtratorScriptDiv.show();
				}
				else {
					accessTokenExtratorScriptDiv.hide();
				}
			}
		)
	}

	if (socialAccountIdType) {
		socialAccountIdType.on(
			'change',
			function(event) {
				if ((document.getElementById("<portlet:namespace />socialAccountIdType").value == <%= OAuthConstants.EXTRATOR_CUSTOM %>) && socialAccountIdScriptDiv) {
					socialAccountIdScriptDiv.show();
				}
				else {
					socialAccountIdScriptDiv.hide();
				}
			}
		)
	}
</aui:script>