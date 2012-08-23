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

<%@ include file="/init.jsp" %>

<%
StringBundler sb = new StringBundler();

sb.append(_SWF_URL_PREFIX);
sb.append(id);
sb.append(_SWF_URL_SUFFIX);

if (autoPlay) {
	sb.append("&isAutoPlay=true");
}

if (!enableRelatedVideos) {
	sb.append("&isShowRelatedVideo=false");
}
%>

<embed
	allowFullScreen="<%= enableFullscreen %>"
	allowScriptAccess="always"
	height="<%= height %>"
	src="<%= HtmlUtil.escape(sb.toString()) %>"
	type="application/x-shockwave-flash"
	width="<%= width %>"
/>