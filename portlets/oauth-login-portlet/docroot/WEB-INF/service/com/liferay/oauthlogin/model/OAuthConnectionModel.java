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

package com.liferay.oauthlogin.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the OAuthConnection service. Represents a row in the &quot;OAuthLogin_OAuthConnection&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.oauthlogin.model.impl.OAuthConnectionModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.oauthlogin.model.impl.OAuthConnectionImpl}.
 * </p>
 *
 * @author Andy Yang
 * @see OAuthConnection
 * @see com.liferay.oauthlogin.model.impl.OAuthConnectionImpl
 * @see com.liferay.oauthlogin.model.impl.OAuthConnectionModelImpl
 * @generated
 */
public interface OAuthConnectionModel extends BaseModel<OAuthConnection> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a o auth connection model instance should use the {@link OAuthConnection} interface instead.
	 */

	/**
	 * Returns the primary key of this o auth connection.
	 *
	 * @return the primary key of this o auth connection
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this o auth connection.
	 *
	 * @param primaryKey the primary key of this o auth connection
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the o auth connection ID of this o auth connection.
	 *
	 * @return the o auth connection ID of this o auth connection
	 */
	public long getOAuthConnectionId();

	/**
	 * Sets the o auth connection ID of this o auth connection.
	 *
	 * @param oAuthConnectionId the o auth connection ID of this o auth connection
	 */
	public void setOAuthConnectionId(long oAuthConnectionId);

	/**
	 * Returns the company ID of this o auth connection.
	 *
	 * @return the company ID of this o auth connection
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this o auth connection.
	 *
	 * @param companyId the company ID of this o auth connection
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this o auth connection.
	 *
	 * @return the user ID of this o auth connection
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this o auth connection.
	 *
	 * @param userId the user ID of this o auth connection
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this o auth connection.
	 *
	 * @return the user uuid of this o auth connection
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this o auth connection.
	 *
	 * @param userUuid the user uuid of this o auth connection
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the create date of this o auth connection.
	 *
	 * @return the create date of this o auth connection
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this o auth connection.
	 *
	 * @param createDate the create date of this o auth connection
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this o auth connection.
	 *
	 * @return the modified date of this o auth connection
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this o auth connection.
	 *
	 * @param modifiedDate the modified date of this o auth connection
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the enabled of this o auth connection.
	 *
	 * @return the enabled of this o auth connection
	 */
	public boolean getEnabled();

	/**
	 * Returns <code>true</code> if this o auth connection is enabled.
	 *
	 * @return <code>true</code> if this o auth connection is enabled; <code>false</code> otherwise
	 */
	public boolean isEnabled();

	/**
	 * Sets whether this o auth connection is enabled.
	 *
	 * @param enabled the enabled of this o auth connection
	 */
	public void setEnabled(boolean enabled);

	/**
	 * Returns the name of this o auth connection.
	 *
	 * @return the name of this o auth connection
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this o auth connection.
	 *
	 * @param name the name of this o auth connection
	 */
	public void setName(String name);

	/**
	 * Returns the description of this o auth connection.
	 *
	 * @return the description of this o auth connection
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this o auth connection.
	 *
	 * @param description the description of this o auth connection
	 */
	public void setDescription(String description);

	/**
	 * Returns the icon ID of this o auth connection.
	 *
	 * @return the icon ID of this o auth connection
	 */
	public long getIconId();

	/**
	 * Sets the icon ID of this o auth connection.
	 *
	 * @param iconId the icon ID of this o auth connection
	 */
	public void setIconId(long iconId);

	/**
	 * Returns the o auth version of this o auth connection.
	 *
	 * @return the o auth version of this o auth connection
	 */
	public int getOAuthVersion();

	/**
	 * Sets the o auth version of this o auth connection.
	 *
	 * @param oAuthVersion the o auth version of this o auth connection
	 */
	public void setOAuthVersion(int oAuthVersion);

	/**
	 * Returns the key of this o auth connection.
	 *
	 * @return the key of this o auth connection
	 */
	@AutoEscape
	public String getKey();

	/**
	 * Sets the key of this o auth connection.
	 *
	 * @param key the key of this o auth connection
	 */
	public void setKey(String key);

	/**
	 * Returns the secret of this o auth connection.
	 *
	 * @return the secret of this o auth connection
	 */
	@AutoEscape
	public String getSecret();

	/**
	 * Sets the secret of this o auth connection.
	 *
	 * @param secret the secret of this o auth connection
	 */
	public void setSecret(String secret);

	/**
	 * Returns the scope of this o auth connection.
	 *
	 * @return the scope of this o auth connection
	 */
	@AutoEscape
	public String getScope();

	/**
	 * Sets the scope of this o auth connection.
	 *
	 * @param scope the scope of this o auth connection
	 */
	public void setScope(String scope);

	/**
	 * Returns the graph u r l of this o auth connection.
	 *
	 * @return the graph u r l of this o auth connection
	 */
	@AutoEscape
	public String getGraphURL();

	/**
	 * Sets the graph u r l of this o auth connection.
	 *
	 * @param graphURL the graph u r l of this o auth connection
	 */
	public void setGraphURL(String graphURL);

	/**
	 * Returns the authorize u r l of this o auth connection.
	 *
	 * @return the authorize u r l of this o auth connection
	 */
	@AutoEscape
	public String getAuthorizeURL();

	/**
	 * Sets the authorize u r l of this o auth connection.
	 *
	 * @param authorizeURL the authorize u r l of this o auth connection
	 */
	public void setAuthorizeURL(String authorizeURL);

	/**
	 * Returns the access token u r l of this o auth connection.
	 *
	 * @return the access token u r l of this o auth connection
	 */
	@AutoEscape
	public String getAccessTokenURL();

	/**
	 * Sets the access token u r l of this o auth connection.
	 *
	 * @param accessTokenURL the access token u r l of this o auth connection
	 */
	public void setAccessTokenURL(String accessTokenURL);

	/**
	 * Returns the access token verb of this o auth connection.
	 *
	 * @return the access token verb of this o auth connection
	 */
	public int getAccessTokenVerb();

	/**
	 * Sets the access token verb of this o auth connection.
	 *
	 * @param accessTokenVerb the access token verb of this o auth connection
	 */
	public void setAccessTokenVerb(int accessTokenVerb);

	/**
	 * Returns the access token extrator type of this o auth connection.
	 *
	 * @return the access token extrator type of this o auth connection
	 */
	public int getAccessTokenExtratorType();

	/**
	 * Sets the access token extrator type of this o auth connection.
	 *
	 * @param accessTokenExtratorType the access token extrator type of this o auth connection
	 */
	public void setAccessTokenExtratorType(int accessTokenExtratorType);

	/**
	 * Returns the access token extrator script of this o auth connection.
	 *
	 * @return the access token extrator script of this o auth connection
	 */
	@AutoEscape
	public String getAccessTokenExtratorScript();

	/**
	 * Sets the access token extrator script of this o auth connection.
	 *
	 * @param accessTokenExtratorScript the access token extrator script of this o auth connection
	 */
	public void setAccessTokenExtratorScript(String accessTokenExtratorScript);

	/**
	 * Returns the request token u r l of this o auth connection.
	 *
	 * @return the request token u r l of this o auth connection
	 */
	@AutoEscape
	public String getRequestTokenURL();

	/**
	 * Sets the request token u r l of this o auth connection.
	 *
	 * @param requestTokenURL the request token u r l of this o auth connection
	 */
	public void setRequestTokenURL(String requestTokenURL);

	/**
	 * Returns the request token verb of this o auth connection.
	 *
	 * @return the request token verb of this o auth connection
	 */
	public int getRequestTokenVerb();

	/**
	 * Sets the request token verb of this o auth connection.
	 *
	 * @param requestTokenVerb the request token verb of this o auth connection
	 */
	public void setRequestTokenVerb(int requestTokenVerb);

	/**
	 * Returns the redirect u r l of this o auth connection.
	 *
	 * @return the redirect u r l of this o auth connection
	 */
	@AutoEscape
	public String getRedirectURL();

	/**
	 * Sets the redirect u r l of this o auth connection.
	 *
	 * @param redirectURL the redirect u r l of this o auth connection
	 */
	public void setRedirectURL(String redirectURL);

	/**
	 * Returns the social account ID u r l of this o auth connection.
	 *
	 * @return the social account ID u r l of this o auth connection
	 */
	@AutoEscape
	public String getSocialAccountIdURL();

	/**
	 * Sets the social account ID u r l of this o auth connection.
	 *
	 * @param socialAccountIdURL the social account ID u r l of this o auth connection
	 */
	public void setSocialAccountIdURL(String socialAccountIdURL);

	/**
	 * Returns the social account ID u r l verb of this o auth connection.
	 *
	 * @return the social account ID u r l verb of this o auth connection
	 */
	public int getSocialAccountIdURLVerb();

	/**
	 * Sets the social account ID u r l verb of this o auth connection.
	 *
	 * @param socialAccountIdURLVerb the social account ID u r l verb of this o auth connection
	 */
	public void setSocialAccountIdURLVerb(int socialAccountIdURLVerb);

	/**
	 * Returns the social account ID field of this o auth connection.
	 *
	 * @return the social account ID field of this o auth connection
	 */
	@AutoEscape
	public String getSocialAccountIdField();

	/**
	 * Sets the social account ID field of this o auth connection.
	 *
	 * @param socialAccountIdField the social account ID field of this o auth connection
	 */
	public void setSocialAccountIdField(String socialAccountIdField);

	/**
	 * Returns the social account ID type of this o auth connection.
	 *
	 * @return the social account ID type of this o auth connection
	 */
	public int getSocialAccountIdType();

	/**
	 * Sets the social account ID type of this o auth connection.
	 *
	 * @param socialAccountIdType the social account ID type of this o auth connection
	 */
	public void setSocialAccountIdType(int socialAccountIdType);

	/**
	 * Returns the social account ID script of this o auth connection.
	 *
	 * @return the social account ID script of this o auth connection
	 */
	@AutoEscape
	public String getSocialAccountIdScript();

	/**
	 * Sets the social account ID script of this o auth connection.
	 *
	 * @param socialAccountIdScript the social account ID script of this o auth connection
	 */
	public void setSocialAccountIdScript(String socialAccountIdScript);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(OAuthConnection oAuthConnection);

	@Override
	public int hashCode();

	@Override
	public CacheModel<OAuthConnection> toCacheModel();

	@Override
	public OAuthConnection toEscapedModel();

	@Override
	public OAuthConnection toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}