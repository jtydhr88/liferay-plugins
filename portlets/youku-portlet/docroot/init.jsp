<%--
/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
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

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page import="com.liferay.portal.kernel.util.Constants" %><%@
page import="com.liferay.portal.kernel.util.GetterUtil" %><%@
page import="com.liferay.portal.kernel.util.HtmlUtil" %><%@
page import="com.liferay.portal.kernel.util.ParamUtil" %><%@
page import="com.liferay.portal.kernel.util.StringBundler" %><%@
page import="com.liferay.portal.kernel.util.StringPool" %><%@
page import="com.liferay.portal.kernel.util.Validator" %><%@
page import="com.liferay.portlet.PortletPreferencesFactoryUtil" %>

<%@ page import="javax.portlet.PortletPreferences" %>

<portlet:defineObjects />

<%
PortletPreferences preferences = renderRequest.getPreferences();

String portletResource = ParamUtil.getString(request, "portletResource");

if (Validator.isNotNull(portletResource)) {
	preferences = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource);
}

String url = preferences.getValue("url", StringPool.BLANK);
int height = GetterUtil.getInteger(preferences.getValue("height", "400"));
int width = GetterUtil.getInteger(preferences.getValue("width", "480"));
boolean autoPlay = GetterUtil.getBoolean(preferences.getValue("autoPlay", "false"));
boolean enableFullscreen = GetterUtil.getBoolean(preferences.getValue("enableFullscreen", "true"));
boolean enableRelatedVideos = GetterUtil.getBoolean(preferences.getValue("enableRelatedVideos", "true"));
String presetSize = width + "x" + height;

String id = url.replaceAll("^.*/v_show/id_([a-zA-Z0-9_-]+).*$", "$1");
%>

<%!
private static final String _SWF_URL_PREFIX = "http://static.youku.com/v1.0.0257/v/swf/loader.swf?VideoIDS=";

private static final String _SWF_URL_SUFFIX = "/v.swf";
%>