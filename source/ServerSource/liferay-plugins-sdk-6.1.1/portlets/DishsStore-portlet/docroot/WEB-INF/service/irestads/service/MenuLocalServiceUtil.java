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
 * The utility for the menu local service. This utility wraps {@link irestads.service.impl.MenuLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Be
 * @see MenuLocalService
 * @see irestads.service.base.MenuLocalServiceBaseImpl
 * @see irestads.service.impl.MenuLocalServiceImpl
 * @generated
 */
public class MenuLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link irestads.service.impl.MenuLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the menu to the database. Also notifies the appropriate model listeners.
	*
	* @param menu the menu
	* @return the menu that was added
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.Menu addMenu(irestads.model.Menu menu)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addMenu(menu);
	}

	/**
	* Creates a new menu with the primary key. Does not add the menu to the database.
	*
	* @param menuId the primary key for the new menu
	* @return the new menu
	*/
	public static irestads.model.Menu createMenu(long menuId) {
		return getService().createMenu(menuId);
	}

	/**
	* Deletes the menu with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param menuId the primary key of the menu
	* @return the menu that was removed
	* @throws PortalException if a menu with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.Menu deleteMenu(long menuId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteMenu(menuId);
	}

	/**
	* Deletes the menu from the database. Also notifies the appropriate model listeners.
	*
	* @param menu the menu
	* @return the menu that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.Menu deleteMenu(irestads.model.Menu menu)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteMenu(menu);
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

	public static irestads.model.Menu fetchMenu(long menuId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchMenu(menuId);
	}

	/**
	* Returns the menu with the primary key.
	*
	* @param menuId the primary key of the menu
	* @return the menu
	* @throws PortalException if a menu with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.Menu getMenu(long menuId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getMenu(menuId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the menus.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of menus
	* @param end the upper bound of the range of menus (not inclusive)
	* @return the range of menus
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<irestads.model.Menu> getMenus(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getMenus(start, end);
	}

	/**
	* Returns the number of menus.
	*
	* @return the number of menus
	* @throws SystemException if a system exception occurred
	*/
	public static int getMenusCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getMenusCount();
	}

	/**
	* Updates the menu in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param menu the menu
	* @return the menu that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.Menu updateMenu(irestads.model.Menu menu)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateMenu(menu);
	}

	/**
	* Updates the menu in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param menu the menu
	* @param merge whether to merge the menu with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the menu that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.Menu updateMenu(irestads.model.Menu menu,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateMenu(menu, merge);
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

	public static void clearService() {
		_service = null;
	}

	public static MenuLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					MenuLocalService.class.getName());

			if (invokableLocalService instanceof MenuLocalService) {
				_service = (MenuLocalService)invokableLocalService;
			}
			else {
				_service = new MenuLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(MenuLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(MenuLocalService service) {
	}

	private static MenuLocalService _service;
}