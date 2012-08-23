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

<liferay-portlet:actionURL portletConfiguration="true" var="configurationURL" />

<aui:form action="<%= configurationURL %>" method="post">
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />

	<div class="aui-field-row">
		<aui:input cssClass="url" inlineField="true" name="preferences--url--" type="text"  value="<%= url %>" />
	</div>

	<div class="aui-field-row">
		<aui:select cssClass="preset-size" inlineField="true" label="preset-frame-size" name="preferences--presetSize--">
			<aui:option label="custom" value="custom" />
			<aui:option label="standard-360-4-3" selected='<%= presetSize.equals("480x360") %>' value="480x360" />
			<aui:option label="standard-360-16-9" selected='<%= presetSize.equals("640x360") %>' value="640x360" />
			<aui:option label="enhanced-480-4-3" selected='<%= presetSize.equals("640x480") %>' value="640x480" />
			<aui:option label="enhanced-480-16-9" selected='<%= presetSize.equals("854x480") %>' value="854x480" />
			<aui:option label="hd-720-4-3" selected='<%= presetSize.equals("960x720") %>' value="960x720" />
			<aui:option label="hd-720-16-9" selected='<%= presetSize.equals("1280x720") %>' value="1280x720" />
			<aui:option label="full-hd-1080-4-3" selected='<%= presetSize.equals("1440x1080") %>' value="1440x1080" />
			<aui:option label="full-hd-1080-16-9" selected='<%= presetSize.equals("1920x1080") %>' value="1920x1080" />
		</aui:select>

		<aui:input cssClass="width invisible" inlineField="true" label="frame-width" name="preferences--width--" value="<%= width %>" />

		<aui:input cssClass="height invisible" inlineField="true" label="frame-height" name="preferences--height--" value="<%= height %>" />
	</div>


	<liferay-ui:panel-container extended="false" persistState="true">
		<liferay-ui:panel collapsible="true" defaultState="closed" extended="false" persistState="true" title="advanced-options">
			<div class="aui-field-row">
				<aui:input inlineField="true" name="preferences--autoPlay--" type="checkbox" value="<%= autoPlay %>" />

				<aui:input inlineField="true" name="preferences--enableFullscreen--" type="checkbox" value="<%= enableFullscreen %>" />

				<aui:input inlineField="true" name="preferences--enableRelatedVideos--" type="checkbox" value="<%= enableRelatedVideos %>" />
			</div>
		</liferay-ui:panel>
	</liferay-ui:panel-container>

	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>

<aui:script use="aui">
	var presetSizeNode = A.one('#<portlet:namespace />presetSize');
	var heightNode = A.one('#<portlet:namespace />height');
	var widthNode = A.one('#<portlet:namespace />width');

	var presetChange = function(e) {
		if (this.val().indexOf('x') < 0) {
			A.one('.aui-field.height').removeClass('invisible');
			A.one('.aui-field.width').removeClass('invisible');

			return;
		}
		var dimensions = this.val().split('x');

		heightNode.val(dimensions[1]);
		widthNode.val(dimensions[0]);
	};

	presetSizeNode.on(
		{
			change: presetChange,
			keypress: presetChange
		}
	);

	if (presetSizeNode.val() == 'custom') {
		A.one('.aui-field.height').removeClass('invisible');
		A.one('.aui-field.width').removeClass('invisible');
	}
</aui:script>