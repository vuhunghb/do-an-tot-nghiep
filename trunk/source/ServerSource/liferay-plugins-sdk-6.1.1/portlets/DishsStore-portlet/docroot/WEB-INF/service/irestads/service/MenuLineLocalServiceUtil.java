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
 * The utility for the menu line local service. This utility wraps {@link irestads.service.impl.MenuLineLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Be
 * @see MenuLineLocalService
 * @see irestads.service.base.MenuLineLocalServiceBaseImpl
 * @see irestads.service.impl.MenuLineLocalServiceImpl
 * @generated
 */
public class MenuLineLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link irestads.service.impl.MenuLineLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the menu line to the database. Also notifies the appropriate model listeners.
	*
	* @param menuLine the menu line
	* @return the menu line that was added
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.MenuLine addMenuLine(
		irestads.model.MenuLine menuLine)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addMenuLine(menuLine);
	}

	/**
	* Creates a new menu line with the primary key. Does not add the menu line to the database.
	*
	* @param menuLineId the primary key for the new menu line
	* @return the new menu line
	*/
	public static irestads.model.MenuLine createMenuLine(long menuLineId) {
		return getService().createMenuLine(menuLineId);
	}

	/**
	* Deletes the menu line with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param menuLineId the primary key of the menu line
	* @return the menu line that was removed
	* @throws PortalException if a menu line with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.MenuLine deleteMenuLine(long menuLineId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteMenuLine(menuLineId);
	}

	/**
	* Deletes the menu line from the database. Also notifies the appropriate model listeners.
	*
	* @param menuLine the menu line
	* @return the menu line that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.MenuLine deleteMenuLine(
		irestads.model.MenuLine menuLine)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteMenuLine(menuLine);
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

	public static irestads.model.MenuLine fetchMenuLine(long menuLineId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchMenuLine(menuLineId);
	}

	/**
	* Returns the menu line with the primary key.
	*
	* @param menuLineId the primary key of the menu line
	* @return the menu line
	* @throws PortalException if a menu line with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.MenuLine getMenuLine(long menuLineId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getMenuLine(menuLineId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the menu lines.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of menu lines
	* @param end the upper bound of the range of menu lines (not inclusive)
	* @return the range of menu lines
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<irestads.model.MenuLine> getMenuLines(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getMenuLines(start, end);
	}

	/**
	* Returns the number of menu lines.
	*
	* @return the number of menu lines
	* @throws SystemException if a system exception occurred
	*/
	public static int getMenuLinesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getMenuLinesCount();
	}

	/**
	* Updates the menu line in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param menuLine the menu line
	* @return the menu line that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.MenuLine updateMenuLine(
		irestads.model.MenuLine menuLine)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateMenuLine(menuLine);
	}

	/**
	* Updates the menu line in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param menuLine the menu line
	* @param merge whether to merge the menu line with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the menu line that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.MenuLine updateMenuLine(
		irestads.model.MenuLine menuLine, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateMenuLine(menuLine, merge);
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

	public static java.util.List<irestads.model.MenuLine> getAllMenuLines() {
		return getService().getAllMenuLines();
	}

	public static irestads.model.MenuLine createMenuLine(
		java.lang.String dishName, java.lang.String decription,
		java.lang.String avatarImg, java.lang.String detailImg,
		java.lang.String detail, int referPrice,
		java.lang.String avatarBaseCode, java.lang.String detailBaseCode,
		int numOfDiner, long categoryId, int numOfDish, boolean status) {
		return getService()
				   .createMenuLine(dishName, decription, avatarImg, detailImg,
			detail, referPrice, avatarBaseCode, detailBaseCode, numOfDiner,
			categoryId, numOfDish, status);
	}

	public static irestads.model.MenuLine createMenuLineDish(
		irestads.model.MenuLine ml) {
		return getService().createMenuLineDish(ml);
	}

	public static irestads.model.MenuLine createMenuLine(long dishId,
		int numOfDish, boolean status) {
		return getService().createMenuLine(dishId, numOfDish, status);
	}

	public static irestads.model.MenuLine createMenuLine(
		irestads.model.MenuLine ml) {
		return getService().createMenuLine(ml);
	}

	public static java.util.List<irestads.model.MenuLine> createMenuLine(
		java.util.List<irestads.model.MenuLine> mls) {
		return getService().createMenuLine(mls);
	}

	public static irestads.model.MenuLine findMenuLineById(long menuLineId) {
		return getService().findMenuLineById(menuLineId);
	}

	public static irestads.model.MenuLine setDishForMenuLine(
		irestads.model.MenuLine menuLine) {
		return getService().setDishForMenuLine(menuLine);
	}

	public static java.util.List<irestads.model.MenuLine> setDishForMenuLine(
		java.util.List<irestads.model.MenuLine> menuLines) {
		return getService().setDishForMenuLine(menuLines);
	}

	public static irestads.model.MenuLine findMenuLinesByDishId(long dishId) {
		return getService().findMenuLinesByDishId(dishId);
	}

	public static java.util.List<irestads.model.MenuLine> findMenuLinesByDReferPrice(
		int price) {
		return getService().findMenuLinesByDReferPrice(price);
	}

	public static java.util.List<irestads.model.MenuLine> findMenuLinesByDName(
		java.lang.String dishName) {
		return getService().findMenuLinesByDName(dishName);
	}

	public static java.util.List<irestads.model.MenuLine> findMenuLinesByDDecription(
		java.lang.String decription) {
		return getService().findMenuLinesByDDecription(decription);
	}

	public static java.util.List<irestads.model.MenuLine> findMenuLinesByDAvatarImg(
		java.lang.String avartarImg) {
		return getService().findMenuLinesByDAvatarImg(avartarImg);
	}

	public static java.util.List<irestads.model.MenuLine> findMenuLinesByDDetailImg(
		java.lang.String detailImg) {
		return getService().findMenuLinesByDDetailImg(detailImg);
	}

	public static java.util.List<irestads.model.MenuLine> findMenuLinesByDDetail(
		java.lang.String detail) {
		return getService().findMenuLinesByDDetail(detail);
	}

	public static java.util.List<irestads.model.MenuLine> findMenuLinesByDCategoryName(
		java.lang.String categoryName) {
		return getService().findMenuLinesByDCategoryName(categoryName);
	}

	public static java.util.List<irestads.model.MenuLine> findMenuLinesByNumOfDish(
		int numOfDish) {
		return getService().findMenuLinesByNumOfDish(numOfDish);
	}

	public static java.util.List<irestads.model.MenuLine> findMenuLinesByStatus(
		boolean status) {
		return getService().findMenuLinesByStatus(status);
	}

	public static java.lang.String parseBooleanToShow(boolean value,
		java.lang.String TValue, java.lang.String Fvalue) {
		return getService().parseBooleanToShow(value, TValue, Fvalue);
	}

	public static void clearService() {
		_service = null;
	}

	public static MenuLineLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					MenuLineLocalService.class.getName());

			if (invokableLocalService instanceof MenuLineLocalService) {
				_service = (MenuLineLocalService)invokableLocalService;
			}
			else {
				_service = new MenuLineLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(MenuLineLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(MenuLineLocalService service) {
	}

	private static MenuLineLocalService _service;
}