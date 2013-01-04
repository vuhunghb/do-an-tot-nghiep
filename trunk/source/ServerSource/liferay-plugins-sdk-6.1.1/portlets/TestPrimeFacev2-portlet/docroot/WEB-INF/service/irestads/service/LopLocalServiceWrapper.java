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
 * This class is a wrapper for {@link LopLocalService}.
 * </p>
 *
 * @author    ADMIN
 * @see       LopLocalService
 * @generated
 */
public class LopLocalServiceWrapper implements LopLocalService,
	ServiceWrapper<LopLocalService> {
	public LopLocalServiceWrapper(LopLocalService lopLocalService) {
		_lopLocalService = lopLocalService;
	}

	/**
	* Adds the lop to the database. Also notifies the appropriate model listeners.
	*
	* @param lop the lop
	* @return the lop that was added
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.Lop addLop(irestads.model.Lop lop)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lopLocalService.addLop(lop);
	}

	/**
	* Creates a new lop with the primary key. Does not add the lop to the database.
	*
	* @param lopId the primary key for the new lop
	* @return the new lop
	*/
	public irestads.model.Lop createLop(long lopId) {
		return _lopLocalService.createLop(lopId);
	}

	/**
	* Deletes the lop with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param lopId the primary key of the lop
	* @return the lop that was removed
	* @throws PortalException if a lop with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.Lop deleteLop(long lopId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _lopLocalService.deleteLop(lopId);
	}

	/**
	* Deletes the lop from the database. Also notifies the appropriate model listeners.
	*
	* @param lop the lop
	* @return the lop that was removed
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.Lop deleteLop(irestads.model.Lop lop)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lopLocalService.deleteLop(lop);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _lopLocalService.dynamicQuery();
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
		return _lopLocalService.dynamicQuery(dynamicQuery);
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
		return _lopLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _lopLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _lopLocalService.dynamicQueryCount(dynamicQuery);
	}

	public irestads.model.Lop fetchLop(long lopId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lopLocalService.fetchLop(lopId);
	}

	/**
	* Returns the lop with the primary key.
	*
	* @param lopId the primary key of the lop
	* @return the lop
	* @throws PortalException if a lop with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.Lop getLop(long lopId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _lopLocalService.getLop(lopId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _lopLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the lops.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of lops
	* @param end the upper bound of the range of lops (not inclusive)
	* @return the range of lops
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<irestads.model.Lop> getLops(int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lopLocalService.getLops(start, end);
	}

	/**
	* Returns the number of lops.
	*
	* @return the number of lops
	* @throws SystemException if a system exception occurred
	*/
	public int getLopsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lopLocalService.getLopsCount();
	}

	/**
	* Updates the lop in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param lop the lop
	* @return the lop that was updated
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.Lop updateLop(irestads.model.Lop lop)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lopLocalService.updateLop(lop);
	}

	/**
	* Updates the lop in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param lop the lop
	* @param merge whether to merge the lop with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the lop that was updated
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.Lop updateLop(irestads.model.Lop lop, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lopLocalService.updateLop(lop, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _lopLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_lopLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _lopLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	public java.util.List<irestads.model.Lop> getAllLop() {
		return _lopLocalService.getAllLop();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public LopLocalService getWrappedLopLocalService() {
		return _lopLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedLopLocalService(LopLocalService lopLocalService) {
		_lopLocalService = lopLocalService;
	}

	public LopLocalService getWrappedService() {
		return _lopLocalService;
	}

	public void setWrappedService(LopLocalService lopLocalService) {
		_lopLocalService = lopLocalService;
	}

	private LopLocalService _lopLocalService;
}