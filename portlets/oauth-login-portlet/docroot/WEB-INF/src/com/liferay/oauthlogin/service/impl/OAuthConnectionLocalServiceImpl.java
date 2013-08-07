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

package com.liferay.oauthlogin.service.impl;

import com.liferay.oauthlogin.model.OAuthConnection;
import com.liferay.oauthlogin.service.base.OAuthConnectionLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.service.ServiceContext;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * @author Andy Yang
 */
public class OAuthConnectionLocalServiceImpl
	extends OAuthConnectionLocalServiceBaseImpl {

	public OAuthConnection addOAuthConnection(boolean enabled, String name,
			String description, int oAuthVersion, String key, String secret,
			String scope, String graphURL, String authorizeURL,
			String accessTokenURL, int accessTokenVerb,
			int accessTokenExtractorType, String accessTokenExtractorScript,
			String requestTokenURL, int requestTokenVerb, String redirectURL,
			String socialAccountIdURL, int socialAccountIdURLVerb,
			String socialAccountIdField, int socialAccountIdType,
			String socialAccountIdScript, File icon,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

		long OAuthConnectionId = counterLocalService.increment();

		byte[] iconBytes = null;

		try {
			iconBytes = FileUtil.getBytes(icon);
		}
		catch(IOException ioe) {
		}

		Date now = new Date();

		OAuthConnection oAuthConnection = oAuthConnectionPersistence.create(
			OAuthConnectionId);

		oAuthConnection.setUserId(serviceContext.getUserId());
		oAuthConnection.setCompanyId(serviceContext.getCompanyId());
		oAuthConnection.setCreateDate(serviceContext.getCreateDate(now));
		oAuthConnection.setModifiedDate(serviceContext.getModifiedDate(now));
		oAuthConnection.setEnabled(enabled);
		oAuthConnection.setName(name);
		oAuthConnection.setDescription(description);
		oAuthConnection.setOAuthVersion(oAuthVersion);
		oAuthConnection.setKey(key);
		oAuthConnection.setSecret(secret);
		oAuthConnection.setScope(scope);
		oAuthConnection.setAuthorizeURL(authorizeURL);
		oAuthConnection.setAccessTokenURL(accessTokenURL);
		oAuthConnection.setAccessTokenVerb(accessTokenVerb);
		oAuthConnection.setAccessTokenExtractorType(accessTokenExtractorType);
		oAuthConnection.setAccessTokenExtractorScript(accessTokenExtractorScript);
		oAuthConnection.setRequestTokenURL(requestTokenURL);
		oAuthConnection.setRequestTokenVerb(requestTokenVerb);
		oAuthConnection.setRedirectURL(redirectURL);
		oAuthConnection.setSocialAccountIdURL(socialAccountIdURL);
		oAuthConnection.setSocialAccountIdURLVerb(socialAccountIdURLVerb);
		oAuthConnection.setSocialAccountIdField(socialAccountIdField);
		oAuthConnection.setSocialAccountIdType(socialAccountIdType);
		oAuthConnection.setSocialAccountIdScript(socialAccountIdScript);

		if (iconBytes != null) {
			oAuthConnection.setIconId(counterLocalService.increment());
		}

		saveIcon(oAuthConnection.getIconId(), iconBytes);

		return oAuthConnectionPersistence.update(oAuthConnection);
	}

	public OAuthConnection deleteOAuthConnection (long oAuthConnectionId)
		throws PortalException, SystemException {

		deleteOAuthConnectionIcon(oAuthConnectionId);

		return super.deleteOAuthConnection(oAuthConnectionId);
	}

	public void deleteOAuthConnectionIcon(long oAuthConnectionId)
		throws PortalException, SystemException {

		OAuthConnection oAuthConnection =
			oAuthConnectionPersistence.findByPrimaryKey(oAuthConnectionId);

		long iconId = oAuthConnection.getIconId();

		imageLocalService.deleteImage(iconId);
	}

	public List<OAuthConnection> getOAuthConnectionsEnabled(boolean enabled)
		throws SystemException {

		return oAuthConnectionPersistence.findByEnabled(enabled);
	}

	public OAuthConnection updateOAuthConnection(
			long oAuthConnectionId, boolean enabled, String name,
			String description, int oAuthVersion, String key, String secret,
			String scope, String graphURL, String authorizeURL,
			String accessTokenURL, int accessTokenVerb,
			int accessTokenExtractorType, String accessTokenExtractorScript,
			String requestTokenURL, int requestTokenVerb, String redirectURL,
			String socialAccountIdURL, int socialAccountIdURLVerb,
			String socialAccountIdField, int socialAccountIdType,
			String socialAccountIdScript, File icon,
			ServiceContext serviceContext)
		throws Exception {

		OAuthConnection oAuthConnection =
			oAuthConnectionPersistence.findByPrimaryKey(oAuthConnectionId);

		oAuthConnection.setUserId(serviceContext.getUserId());
		oAuthConnection.setModifiedDate(serviceContext.getModifiedDate(null));
		oAuthConnection.setEnabled(enabled);
		oAuthConnection.setName(name);
		oAuthConnection.setDescription(description);
		oAuthConnection.setOAuthVersion(oAuthVersion);
		oAuthConnection.setKey(key);
		oAuthConnection.setSecret(secret);
		oAuthConnection.setScope(scope);
		oAuthConnection.setAuthorizeURL(authorizeURL);
		oAuthConnection.setAccessTokenURL(accessTokenURL);
		oAuthConnection.setAccessTokenVerb(accessTokenVerb);
		oAuthConnection.setAccessTokenExtractorType(accessTokenExtractorType);
		oAuthConnection.setAccessTokenExtractorScript(accessTokenExtractorScript);
		oAuthConnection.setRequestTokenURL(requestTokenURL);
		oAuthConnection.setRequestTokenVerb(requestTokenVerb);
		oAuthConnection.setRedirectURL(redirectURL);
		oAuthConnection.setSocialAccountIdURL(socialAccountIdURL);
		oAuthConnection.setSocialAccountIdURLVerb(socialAccountIdURLVerb);
		oAuthConnection.setSocialAccountIdField(socialAccountIdField);
		oAuthConnection.setSocialAccountIdType(socialAccountIdType);
		oAuthConnection.setSocialAccountIdScript(socialAccountIdScript);

		updateOAuthConnection(oAuthConnection);

		oAuthConnectionPersistence.updateImpl(oAuthConnection);

		return oAuthConnection;

	}

	protected void saveIcon(long iconId, byte[] iconBytes)
		throws PortalException, SystemException{

		if ((iconId > 0) && (iconBytes != null)) {
			imageLocalService.updateImage(iconId, iconBytes);
		}
	}

}