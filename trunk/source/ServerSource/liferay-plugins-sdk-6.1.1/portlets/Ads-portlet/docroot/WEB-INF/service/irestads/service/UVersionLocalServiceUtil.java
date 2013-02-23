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

package irestads.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the u version local service. This utility wraps {@link irestads.service.impl.UVersionLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Be
 * @see UVersionLocalService
 * @see irestads.service.base.UVersionLocalServiceBaseImpl
 * @see irestads.service.impl.UVersionLocalServiceImpl
 * @generated
 */
public class UVersionLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link irestads.service.impl.UVersionLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the u version to the database. Also notifies the appropriate model listeners.
	*
	* @param uVersion the u version
	* @return the u version that was added
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.UVersion addUVersion(
		irestads.model.UVersion uVersion)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addUVersion(uVersion);
	}

	/**
	* Creates a new u version with the primary key. Does not add the u version to the database.
	*
	* @param versionId the primary key for the new u version
	* @return the new u version
	*/
	public static irestads.model.UVersion createUVersion(long versionId) {
		return getService().createUVersion(versionId);
	}

	/**
	* Deletes the u version with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param versionId the primary key of the u version
	* @return the u version that was removed
	* @throws PortalException if a u version with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.UVersion deleteUVersion(long versionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteUVersion(versionId);
	}

	/**
	* Deletes the u version from the database. Also notifies the appropriate model listeners.
	*
	* @param uVersion the u version
	* @return the u version that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.UVersion deleteUVersion(
		irestads.model.UVersion uVersion)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteUVersion(uVersion);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
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

	public static irestads.model.UVersion fetchUVersion(long versionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchUVersion(versionId);
	}

	/**
	* Returns the u version with the primary key.
	*
	* @param versionId the primary key of the u version
	* @return the u version
	* @throws PortalException if a u version with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.UVersion getUVersion(long versionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getUVersion(versionId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the u versions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of u versions
	* @param end the upper bound of the range of u versions (not inclusive)
	* @return the range of u versions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<irestads.model.UVersion> getUVersions(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getUVersions(start, end);
	}

	/**
	* Returns the number of u versions.
	*
	* @return the number of u versions
	* @throws SystemException if a system exception occurred
	*/
	public static int getUVersionsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getUVersionsCount();
	}

	/**
	* Updates the u version in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param uVersion the u version
	* @return the u version that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.UVersion updateUVersion(
		irestads.model.UVersion uVersion)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateUVersion(uVersion);
	}

	/**
	* Updates the u version in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param uVersion the u version
	* @param merge whether to merge the u version with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the u version that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.UVersion updateUVersion(
		irestads.model.UVersion uVersion, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateUVersion(uVersion, merge);
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

	public static irestads.model.UVersion createVersion(
		irestads.model.UVersion v) {
		return getService().createVersion(v);
	}

	public static irestads.model.UVersion createVersion(long idObj,
		java.lang.String nameObj, java.lang.String type) {
		return getService().createVersion(idObj, nameObj, type);
	}

	public static void checkDelete(long idObj) {
		getService().checkDelete(idObj);
	}

	public static java.util.List<irestads.model.UVersion> findNextVersions(
		long uversionId) {
		return getService().findNextVersions(uversionId);
	}

	public static void clearService() {
		_service = null;
	}

	public static UVersionLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					UVersionLocalService.class.getName());

			if (invokableLocalService instanceof UVersionLocalService) {
				_service = (UVersionLocalService)invokableLocalService;
			}
			else {
				_service = new UVersionLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(UVersionLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(UVersionLocalService service) {
	}

	private static UVersionLocalService _service;
}