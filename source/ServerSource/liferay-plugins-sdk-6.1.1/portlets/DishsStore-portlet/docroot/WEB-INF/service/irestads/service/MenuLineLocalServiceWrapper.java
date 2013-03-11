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
 * This class is a wrapper for {@link MenuLineLocalService}.
 * </p>
 *
 * @author    Be
 * @see       MenuLineLocalService
 * @generated
 */
public class MenuLineLocalServiceWrapper implements MenuLineLocalService,
	ServiceWrapper<MenuLineLocalService> {
	public MenuLineLocalServiceWrapper(
		MenuLineLocalService menuLineLocalService) {
		_menuLineLocalService = menuLineLocalService;
	}

	/**
	* Adds the menu line to the database. Also notifies the appropriate model listeners.
	*
	* @param menuLine the menu line
	* @return the menu line that was added
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.MenuLine addMenuLine(irestads.model.MenuLine menuLine)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _menuLineLocalService.addMenuLine(menuLine);
	}

	/**
	* Creates a new menu line with the primary key. Does not add the menu line to the database.
	*
	* @param menuLineId the primary key for the new menu line
	* @return the new menu line
	*/
	public irestads.model.MenuLine createMenuLine(long menuLineId) {
		return _menuLineLocalService.createMenuLine(menuLineId);
	}

	/**
	* Deletes the menu line with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param menuLineId the primary key of the menu line
	* @return the menu line that was removed
	* @throws PortalException if a menu line with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.MenuLine deleteMenuLine(long menuLineId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _menuLineLocalService.deleteMenuLine(menuLineId);
	}

	/**
	* Deletes the menu line from the database. Also notifies the appropriate model listeners.
	*
	* @param menuLine the menu line
	* @return the menu line that was removed
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.MenuLine deleteMenuLine(
		irestads.model.MenuLine menuLine)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _menuLineLocalService.deleteMenuLine(menuLine);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _menuLineLocalService.dynamicQuery();
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
		return _menuLineLocalService.dynamicQuery(dynamicQuery);
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
		return _menuLineLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _menuLineLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _menuLineLocalService.dynamicQueryCount(dynamicQuery);
	}

	public irestads.model.MenuLine fetchMenuLine(long menuLineId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _menuLineLocalService.fetchMenuLine(menuLineId);
	}

	/**
	* Returns the menu line with the primary key.
	*
	* @param menuLineId the primary key of the menu line
	* @return the menu line
	* @throws PortalException if a menu line with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.MenuLine getMenuLine(long menuLineId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _menuLineLocalService.getMenuLine(menuLineId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _menuLineLocalService.getPersistedModel(primaryKeyObj);
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
	public java.util.List<irestads.model.MenuLine> getMenuLines(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _menuLineLocalService.getMenuLines(start, end);
	}

	/**
	* Returns the number of menu lines.
	*
	* @return the number of menu lines
	* @throws SystemException if a system exception occurred
	*/
	public int getMenuLinesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _menuLineLocalService.getMenuLinesCount();
	}

	/**
	* Updates the menu line in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param menuLine the menu line
	* @return the menu line that was updated
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.MenuLine updateMenuLine(
		irestads.model.MenuLine menuLine)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _menuLineLocalService.updateMenuLine(menuLine);
	}

	/**
	* Updates the menu line in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param menuLine the menu line
	* @param merge whether to merge the menu line with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the menu line that was updated
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.MenuLine updateMenuLine(
		irestads.model.MenuLine menuLine, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _menuLineLocalService.updateMenuLine(menuLine, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _menuLineLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_menuLineLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _menuLineLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	public java.util.List<irestads.model.MenuLine> getAllMenuLines() {
		return _menuLineLocalService.getAllMenuLines();
	}

	public irestads.model.MenuLine createMenuLine(java.lang.String dishName,
		java.lang.String decription, java.lang.String avatarImg,
		java.lang.String detailImg, java.lang.String detail, int referPrice,
		java.lang.String avatarBaseCode, java.lang.String detailBaseCode,
		int numOfDiner, long categoryId, int numOfDish, boolean status) {
		return _menuLineLocalService.createMenuLine(dishName, decription,
			avatarImg, detailImg, detail, referPrice, avatarBaseCode,
			detailBaseCode, numOfDiner, categoryId, numOfDish, status);
	}

	public irestads.model.MenuLine createMenuLineDish(
		irestads.model.MenuLine ml) {
		return _menuLineLocalService.createMenuLineDish(ml);
	}

	public irestads.model.MenuLine createMenuLine(long dishId, int numOfDish,
		boolean status) {
		return _menuLineLocalService.createMenuLine(dishId, numOfDish, status);
	}

	public irestads.model.MenuLine createMenuLine(irestads.model.MenuLine ml) {
		return _menuLineLocalService.createMenuLine(ml);
	}

	public java.util.List<irestads.model.MenuLine> createMenuLine(
		java.util.List<irestads.model.MenuLine> mls) {
		return _menuLineLocalService.createMenuLine(mls);
	}

	public irestads.model.MenuLine findMenuLineById(long menuLineId) {
		return _menuLineLocalService.findMenuLineById(menuLineId);
	}

	public irestads.model.MenuLine setDishForMenuLine(
		irestads.model.MenuLine menuLine) {
		return _menuLineLocalService.setDishForMenuLine(menuLine);
	}

	public java.util.List<irestads.model.MenuLine> setDishForMenuLine(
		java.util.List<irestads.model.MenuLine> menuLines) {
		return _menuLineLocalService.setDishForMenuLine(menuLines);
	}

	public irestads.model.MenuLine findMenuLinesByDishId(long dishId) {
		return _menuLineLocalService.findMenuLinesByDishId(dishId);
	}

	public java.util.List<irestads.model.MenuLine> findMenuLinesByDReferPrice(
		int price) {
		return _menuLineLocalService.findMenuLinesByDReferPrice(price);
	}

	public java.util.List<irestads.model.MenuLine> findMenuLinesByDName(
		java.lang.String dishName) {
		return _menuLineLocalService.findMenuLinesByDName(dishName);
	}

	public java.util.List<irestads.model.MenuLine> findMenuLinesByDDecription(
		java.lang.String decription) {
		return _menuLineLocalService.findMenuLinesByDDecription(decription);
	}

	public java.util.List<irestads.model.MenuLine> findMenuLinesByDAvatarImg(
		java.lang.String avartarImg) {
		return _menuLineLocalService.findMenuLinesByDAvatarImg(avartarImg);
	}

	public java.util.List<irestads.model.MenuLine> findMenuLinesByDDetailImg(
		java.lang.String detailImg) {
		return _menuLineLocalService.findMenuLinesByDDetailImg(detailImg);
	}

	public java.util.List<irestads.model.MenuLine> findMenuLinesByDDetail(
		java.lang.String detail) {
		return _menuLineLocalService.findMenuLinesByDDetail(detail);
	}

	public java.util.List<irestads.model.MenuLine> findMenuLinesByDCategoryName(
		java.lang.String categoryName) {
		return _menuLineLocalService.findMenuLinesByDCategoryName(categoryName);
	}

	public java.util.List<irestads.model.MenuLine> findMenuLinesByNumOfDish(
		int numOfDish) {
		return _menuLineLocalService.findMenuLinesByNumOfDish(numOfDish);
	}

	public java.util.List<irestads.model.MenuLine> findMenuLinesByStatus(
		boolean status) {
		return _menuLineLocalService.findMenuLinesByStatus(status);
	}

	public java.lang.String parseBooleanToShow(boolean value,
		java.lang.String TValue, java.lang.String Fvalue) {
		return _menuLineLocalService.parseBooleanToShow(value, TValue, Fvalue);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public MenuLineLocalService getWrappedMenuLineLocalService() {
		return _menuLineLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedMenuLineLocalService(
		MenuLineLocalService menuLineLocalService) {
		_menuLineLocalService = menuLineLocalService;
	}

	public MenuLineLocalService getWrappedService() {
		return _menuLineLocalService;
	}

	public void setWrappedService(MenuLineLocalService menuLineLocalService) {
		_menuLineLocalService = menuLineLocalService;
	}

	private MenuLineLocalService _menuLineLocalService;
}