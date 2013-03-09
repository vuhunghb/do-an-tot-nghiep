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
 * The utility for the dish table local service. This utility wraps {@link irestads.service.impl.DishTableLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Be
 * @see DishTableLocalService
 * @see irestads.service.base.DishTableLocalServiceBaseImpl
 * @see irestads.service.impl.DishTableLocalServiceImpl
 * @generated
 */
public class DishTableLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link irestads.service.impl.DishTableLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the dish table to the database. Also notifies the appropriate model listeners.
	*
	* @param dishTable the dish table
	* @return the dish table that was added
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.DishTable addDishTable(
		irestads.model.DishTable dishTable)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addDishTable(dishTable);
	}

	/**
	* Creates a new dish table with the primary key. Does not add the dish table to the database.
	*
	* @param dishTableId the primary key for the new dish table
	* @return the new dish table
	*/
	public static irestads.model.DishTable createDishTable(
		java.lang.String dishTableId) {
		return getService().createDishTable(dishTableId);
	}

	/**
	* Deletes the dish table with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param dishTableId the primary key of the dish table
	* @return the dish table that was removed
	* @throws PortalException if a dish table with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.DishTable deleteDishTable(
		java.lang.String dishTableId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteDishTable(dishTableId);
	}

	/**
	* Deletes the dish table from the database. Also notifies the appropriate model listeners.
	*
	* @param dishTable the dish table
	* @return the dish table that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.DishTable deleteDishTable(
		irestads.model.DishTable dishTable)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteDishTable(dishTable);
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

	public static irestads.model.DishTable fetchDishTable(
		java.lang.String dishTableId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchDishTable(dishTableId);
	}

	/**
	* Returns the dish table with the primary key.
	*
	* @param dishTableId the primary key of the dish table
	* @return the dish table
	* @throws PortalException if a dish table with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.DishTable getDishTable(
		java.lang.String dishTableId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getDishTable(dishTableId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the dish tables.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of dish tables
	* @param end the upper bound of the range of dish tables (not inclusive)
	* @return the range of dish tables
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<irestads.model.DishTable> getDishTables(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getDishTables(start, end);
	}

	/**
	* Returns the number of dish tables.
	*
	* @return the number of dish tables
	* @throws SystemException if a system exception occurred
	*/
	public static int getDishTablesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getDishTablesCount();
	}

	/**
	* Updates the dish table in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param dishTable the dish table
	* @return the dish table that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.DishTable updateDishTable(
		irestads.model.DishTable dishTable)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateDishTable(dishTable);
	}

	/**
	* Updates the dish table in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param dishTable the dish table
	* @param merge whether to merge the dish table with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the dish table that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.DishTable updateDishTable(
		irestads.model.DishTable dishTable, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateDishTable(dishTable, merge);
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

	public static java.util.List<irestads.model.DishTable> getAllDishTables() {
		return getService().getAllDishTables();
	}

	public static irestads.model.DishTable updateTableStatus(
		java.lang.String idTable, boolean value, long orderId) {
		return getService().updateTableStatus(idTable, value, orderId);
	}

	public static void clearService() {
		_service = null;
	}

	public static DishTableLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					DishTableLocalService.class.getName());

			if (invokableLocalService instanceof DishTableLocalService) {
				_service = (DishTableLocalService)invokableLocalService;
			}
			else {
				_service = new DishTableLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(DishTableLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(DishTableLocalService service) {
	}

	private static DishTableLocalService _service;
}