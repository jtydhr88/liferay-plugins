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

<%@ include file="/display/init.jsp" %>

<%
long userId = themeDisplay.getUserId();

List<OAuthConnection> oAuthConnections = OAuthConnectionLocalServiceUtil.getOAuthConnectionsEnabled(true);

for (OAuthConnection oAuthConnection : oAuthConnections) {

String expandoColumnName = String.valueOf(oAuthConnection.getOAuthConnectionId()) + "_social_account_id";

String socailAccountId = ExpandoValueLocalServiceUtil.getData(company.getCompanyId(), User.class.getName(), ExpandoTableConstants.DEFAULT_TABLE_NAME, expandoColumnName, userId, StringPool.BLANK);
%>

	<c:choose>
		<c:when test="<%= Validator.isNull(socailAccountId) %>">

			<a href="javascript:;" onClick="getAuthorizeURL(<%= oAuthConnection.getOAuthConnectionId() %>);">bind your <%= oAuthConnection.getName() %> account</a>

			<br />
		</c:when>
		<c:otherwise>
			<portlet:actionURL name="unbindSocialAccount" var="unbindSocialAccountURL">
				<portlet:param name="oAuthConnectionId" value="<%= String.valueOf(oAuthConnection.getOAuthConnectionId()) %>" />
			</portlet:actionURL>

			you-have-bound-your <%= oAuthConnection.getName() %> accout <aui:a href="<%= unbindSocialAccountURL.toString() %>" label="unbind-your-account" />

			<br />
		</c:otherwise>
</c:choose>
<%
}
%>

<portlet:actionURL name="getAuthorizeURL" var="getAuthorizeURL" />

<aui:script use="aui-io-request">
	Liferay.provide(
		window,
		"getAuthorizeURL",
		function(oAuthConnectionId) {
			var A = AUI();

			A.io.request(
				"<%= getAuthorizeURL %>",
				{
					dataType: 'json',
					data: {
						<portlet:namespace />oAuthConnectionId: oAuthConnectionId
					},
					after: {
						success: function(event, id, obj) {
							var jsonObject = this.get('responseData');

							window.location.href = jsonObject.authorizeURL;
						}
					}
				}
			);
		}
	);
</aui:script>