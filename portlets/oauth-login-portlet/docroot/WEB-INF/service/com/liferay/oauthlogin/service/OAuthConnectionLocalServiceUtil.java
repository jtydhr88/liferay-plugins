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

package com.liferay.oauthlogin.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for OAuthConnection. This utility wraps
 * {@link com.liferay.oauthlogin.service.impl.OAuthConnectionLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Andy Yang
 * @see OAuthConnectionLocalService
 * @see com.liferay.oauthlogin.service.base.OAuthConnectionLocalServiceBaseImpl
 * @see com.liferay.oauthlogin.service.impl.OAuthConnectionLocalServiceImpl
 * @generated
 */
public class OAuthConnectionLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.oauthlogin.service.impl.OAuthConnectionLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the o auth connection to the database. Also notifies the appropriate model listeners.
	*
	* @param oAuthConnection the o auth connection
	* @return the o auth connection that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.oauthlogin.model.OAuthConnection addOAuthConnection(
		com.liferay.oauthlogin.model.OAuthConnection oAuthConnection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addOAuthConnection(oAuthConnection);
	}

	/**
	* Creates a new o auth connection with the primary key. Does not add the o auth connection to the database.
	*
	* @param oAuthConnectionId the primary key for the new o auth connection
	* @return the new o auth connection
	*/
	public static com.liferay.oauthlogin.model.OAuthConnection createOAuthConnection(
		long oAuthConnectionId) {
		return getService().createOAuthConnection(oAuthConnectionId);
	}

	/**
	* Deletes the o auth connection with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param oAuthConnectionId the primary key of the o auth connection
	* @return the o auth connection that was removed
	* @throws PortalException if a o auth connection with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.oauthlogin.model.OAuthConnection deleteOAuthConnection(
		long oAuthConnectionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteOAuthConnection(oAuthConnectionId);
	}

	/**
	* Deletes the o auth connection from the database. Also notifies the appropriate model listeners.
	*
	* @param oAuthConnection the o auth connection
	* @return the o auth connection that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.oauthlogin.model.OAuthConnection deleteOAuthConnection(
		com.liferay.oauthlogin.model.OAuthConnection oAuthConnection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteOAuthConnection(oAuthConnection);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.oauthlogin.model.impl.OAuthConnectionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.oauthlogin.model.impl.OAuthConnectionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.liferay.oauthlogin.model.OAuthConnection fetchOAuthConnection(
		long oAuthConnectionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchOAuthConnection(oAuthConnectionId);
	}

	/**
	* Returns the o auth connection with the primary key.
	*
	* @param oAuthConnectionId the primary key of the o auth connection
	* @return the o auth connection
	* @throws PortalException if a o auth connection with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.oauthlogin.model.OAuthConnection getOAuthConnection(
		long oAuthConnectionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getOAuthConnection(oAuthConnectionId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the o auth connections.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.oauthlogin.model.impl.OAuthConnectionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of o auth connections
	* @param end the upper bound of the range of o auth connections (not inclusive)
	* @return the range of o auth connections
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.oauthlogin.model.OAuthConnection> getOAuthConnections(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getOAuthConnections(start, end);
	}

	/**
	* Returns the number of o auth connections.
	*
	* @return the number of o auth connections
	* @throws SystemException if a system exception occurred
	*/
	public static int getOAuthConnectionsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getOAuthConnectionsCount();
	}

	/**
	* Updates the o auth connection in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param oAuthConnection the o auth connection
	* @return the o auth connection that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.oauthlogin.model.OAuthConnection updateOAuthConnection(
		com.liferay.oauthlogin.model.OAuthConnection oAuthConnection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateOAuthConnection(oAuthConnection);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static com.liferay.oauthlogin.model.OAuthConnection addOAuthConnection(
		boolean enabled, java.lang.String name, java.lang.String description,
		int oAuthVersion, java.lang.String key, java.lang.String secret,
		java.lang.String scope, java.lang.String graphURL,
		java.lang.String authorizeURL, java.lang.String accessTokenURL,
		int accessTokenVerb, int accessTokenExtratorType,
		java.lang.String accessTokenExtratorScript,
		java.lang.String requestTokenURL, int requestTokenVerb,
		java.lang.String redirectURL, java.lang.String socialAccountIdURL,
		int socialAccountIdURLVerb, java.lang.String socialAccountIdField,
		int socialAccountIdType, java.lang.String socialAccountIdScript,
		java.io.File icon,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addOAuthConnection(enabled, name, description,
			oAuthVersion, key, secret, scope, graphURL, authorizeURL,
			accessTokenURL, accessTokenVerb, accessTokenExtratorType,
			accessTokenExtratorScript, requestTokenURL, requestTokenVerb,
			redirectURL, socialAccountIdURL, socialAccountIdURLVerb,
			socialAccountIdField, socialAccountIdType, socialAccountIdScript,
			icon, serviceContext);
	}

	public static void deleteOAuthConnectionIcon(long oAuthConnectionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteOAuthConnectionIcon(oAuthConnectionId);
	}

	public static java.util.List<com.liferay.oauthlogin.model.OAuthConnection> getOAuthConnectionsEnabled(
		boolean enabled)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getOAuthConnectionsEnabled(enabled);
	}

	public static com.liferay.oauthlogin.model.OAuthConnection updateOAuthConnection(
		long oAuthConnectionId, boolean enabled, java.lang.String name,
		java.lang.String description, int oAuthVersion, java.lang.String key,
		java.lang.String secret, java.lang.String scope,
		java.lang.String graphURL, java.lang.String authorizeURL,
		java.lang.String accessTokenURL, int accessTokenVerb,
		int accessTokenExtratorType,
		java.lang.String accessTokenExtratorScript,
		java.lang.String requestTokenURL, int requestTokenVerb,
		java.lang.String redirectURL, java.lang.String socialAccountIdURL,
		int socialAccountIdURLVerb, java.lang.String socialAccountIdField,
		int socialAccountIdType, java.lang.String socialAccountIdScript,
		java.io.File icon,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws java.lang.Exception {
		return getService()
				   .updateOAuthConnection(oAuthConnectionId, enabled, name,
			description, oAuthVersion, key, secret, scope, graphURL,
			authorizeURL, accessTokenURL, accessTokenVerb,
			accessTokenExtratorType, accessTokenExtratorScript,
			requestTokenURL, requestTokenVerb, redirectURL, socialAccountIdURL,
			socialAccountIdURLVerb, socialAccountIdField, socialAccountIdType,
			socialAccountIdScript, icon, serviceContext);
	}

	public static void clearService() {
		_service = null;
	}

	public static OAuthConnectionLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					OAuthConnectionLocalService.class.getName());

			if (invokableLocalService instanceof OAuthConnectionLocalService) {
				_service = (OAuthConnectionLocalService)invokableLocalService;
			}
			else {
				_service = new OAuthConnectionLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(OAuthConnectionLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(OAuthConnectionLocalService service) {
	}

	private static OAuthConnectionLocalService _service;
}