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
List<OAuthConnection> oAuthConnections = OAuthConnectionLocalServiceUtil.getOAuthConnectionsEnabled(true);

for (OAuthConnection oAuthConnection : oAuthConnections) {
%>

	<a href="javascript:;" onClick="getAuthorizeURL(<%= oAuthConnection.getOAuthConnectionId() %>);"><%= oAuthConnection.getName() %></a>

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