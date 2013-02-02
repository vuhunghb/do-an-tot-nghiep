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

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link UVersionLocalService}.
 * </p>
 *
 * @author    Be
 * @see       UVersionLocalService
 * @generated
 */
public class UVersionLocalServiceWrapper implements UVersionLocalService,
	ServiceWrapper<UVersionLocalService> {
	public UVersionLocalServiceWrapper(
		UVersionLocalService uVersionLocalService) {
		_uVersionLocalService = uVersionLocalService;
	}

	/**
	* Adds the u version to the database. Also notifies the appropriate model listeners.
	*
	* @param uVersion the u version
	* @return the u version that was added
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.UVersion addUVersion(irestads.model.UVersion uVersion)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _uVersionLocalService.addUVersion(uVersion);
	}

	/**
	* Creates a new u version with the primary key. Does not add the u version to the database.
	*
	* @param versionId the primary key for the new u version
	* @return the new u version
	*/
	public irestads.model.UVersion createUVersion(long versionId) {
		return _uVersionLocalService.createUVersion(versionId);
	}

	/**
	* Deletes the u version with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param versionId the primary key of the u version
	* @return the u version that was removed
	* @throws PortalException if a u version with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.UVersion deleteUVersion(long versionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _uVersionLocalService.deleteUVersion(versionId);
	}

	/**
	* Deletes the u version from the database. Also notifies the appropriate model listeners.
	*
	* @param uVersion the u version
	* @return the u version that was removed
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.UVersion deleteUVersion(
		irestads.model.UVersion uVersion)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _uVersionLocalService.deleteUVersion(uVersion);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _uVersionLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _uVersionLocalService.dynamicQuery(dynamicQuery);
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _uVersionLocalService.dynamicQuery(dynamicQuery, start, end);
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _uVersionLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _uVersionLocalService.dynamicQueryCount(dynamicQuery);
	}

	public irestads.model.UVersion fetchUVersion(long versionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _uVersionLocalService.fetchUVersion(versionId);
	}

	/**
	* Returns the u version with the primary key.
	*
	* @param versionId the primary key of the u version
	* @return the u version
	* @throws PortalException if a u version with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.UVersion getUVersion(long versionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _uVersionLocalService.getUVersion(versionId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _uVersionLocalService.getPersistedModel(primaryKeyObj);
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
	public java.util.List<irestads.model.UVersion> getUVersions(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _uVersionLocalService.getUVersions(start, end);
	}

	/**
	* Returns the number of u versions.
	*
	* @return the number of u versions
	* @throws SystemException if a system exception occurred
	*/
	public int getUVersionsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _uVersionLocalService.getUVersionsCount();
	}

	/**
	* Updates the u version in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param uVersion the u version
	* @return the u version that was updated
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.UVersion updateUVersion(
		irestads.model.UVersion uVersion)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _uVersionLocalService.updateUVersion(uVersion);
	}

	/**
	* Updates the u version in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param uVersion the u version
	* @param merge whether to merge the u version with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the u version that was updated
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.UVersion updateUVersion(
		irestads.model.UVersion uVersion, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _uVersionLocalService.updateUVersion(uVersion, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _uVersionLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_uVersionLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _uVersionLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	public irestads.model.UVersion createVersion(irestads.model.UVersion v) {
		return _uVersionLocalService.createVersion(v);
	}

	public irestads.model.UVersion createVersion(long idObj,
		java.lang.String nameObj, java.lang.String type) {
		return _uVersionLocalService.createVersion(idObj, nameObj, type);
	}

	public void checkDelete(long idObj) {
		_uVersionLocalService.checkDelete(idObj);
	}

	public java.util.List<irestads.model.UVersion> findNextVersions(
		long uversionId) {
		return _uVersionLocalService.findNextVersions(uversionId);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public UVersionLocalService getWrappedUVersionLocalService() {
		return _uVersionLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedUVersionLocalService(
		UVersionLocalService uVersionLocalService) {
		_uVersionLocalService = uVersionLocalService;
	}

	public UVersionLocalService getWrappedService() {
		return _uVersionLocalService;
	}

	public void setWrappedService(UVersionLocalService uVersionLocalService) {
		_uVersionLocalService = uVersionLocalService;
	}

	private UVersionLocalService _uVersionLocalService;
}