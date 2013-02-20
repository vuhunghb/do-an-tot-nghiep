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
 * This class is a wrapper for {@link MenuLineService}.
 * </p>
 *
 * @author    Be
 * @see       MenuLineService
 * @generated
 */
public class MenuLineServiceWrapper implements MenuLineService,
	ServiceWrapper<MenuLineService> {
	public MenuLineServiceWrapper(MenuLineService menuLineService) {
		_menuLineService = menuLineService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _menuLineService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_menuLineService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _menuLineService.invokeMethod(name, parameterTypes, arguments);
	}

	public java.util.List<irestads.model.MenuLine> getAllMenuLine() {
		return _menuLineService.getAllMenuLine();
	}

	public irestads.model.MenuLine createMenuLine(java.lang.String dishName,
		java.lang.String decription, java.lang.String avatarImg,
		java.lang.String detailImg, java.lang.String detail, int referPrice,
		java.lang.String avatarBaseCode, java.lang.String detailBaseCode,
		long categoryId, int numOfDish, boolean status) {
		return _menuLineService.createMenuLine(dishName, decription, avatarImg,
			detailImg, detail, referPrice, avatarBaseCode, detailBaseCode,
			categoryId, numOfDish, status);
	}

	public irestads.model.MenuLine createMenuLineDish(
		irestads.model.MenuLine ml) {
		return _menuLineService.createMenuLineDish(ml);
	}

	public irestads.model.MenuLine createMenuLine(irestads.model.MenuLine ml) {
		return _menuLineService.createMenuLine(ml);
	}

	public irestads.model.MenuLine createMenuLine(long dishId, int numOfDish,
		boolean status) {
		return _menuLineService.createMenuLine(dishId, numOfDish, status);
	}

	public java.util.List<irestads.model.MenuLine> createMenuLine(
		java.util.List<irestads.model.MenuLine> mls) {
		return _menuLineService.createMenuLine(mls);
	}

	public irestads.model.MenuLine updateMenuLine(irestads.model.MenuLine ml) {
		return _menuLineService.updateMenuLine(ml);
	}

	public irestads.model.MenuLine deleteMenuLine(irestads.model.MenuLine ml) {
		return _menuLineService.deleteMenuLine(ml);
	}

	public irestads.model.MenuLine findMenuLineById(long menuLineId) {
		return _menuLineService.findMenuLineById(menuLineId);
	}

	public java.util.List<irestads.model.MenuLine> findMenuLinesByDReferPrice(
		int price) {
		return _menuLineService.findMenuLinesByDReferPrice(price);
	}

	public irestads.model.MenuLine setDishForMenuLine(
		irestads.model.MenuLine menuLine) {
		return _menuLineService.setDishForMenuLine(menuLine);
	}

	public irestads.model.MenuLine findMenuLinesByDishId(long dishId) {
		return _menuLineService.findMenuLinesByDishId(dishId);
	}

	public java.util.List<irestads.model.MenuLine> findMenuLinesByDName(
		java.lang.String dishName) {
		return _menuLineService.findMenuLinesByDName(dishName);
	}

	public java.util.List<irestads.model.MenuLine> findMenuLinesByDDecription(
		java.lang.String decription) {
		return _menuLineService.findMenuLinesByDDecription(decription);
	}

	public java.util.List<irestads.model.MenuLine> findMenuLinesByDAvatarImg(
		java.lang.String avartarImg) {
		return _menuLineService.findMenuLinesByDAvatarImg(avartarImg);
	}

	public java.util.List<irestads.model.MenuLine> findMenuLinesByDDetailImg(
		java.lang.String detailImg) {
		return _menuLineService.findMenuLinesByDDetailImg(detailImg);
	}

	public java.util.List<irestads.model.MenuLine> findMenuLinesByDDetail(
		java.lang.String detail) {
		return _menuLineService.findMenuLinesByDDetail(detail);
	}

	public java.util.List<irestads.model.MenuLine> findMenuLinesByDCategoryName(
		java.lang.String categoryName) {
		return _menuLineService.findMenuLinesByDCategoryName(categoryName);
	}

	public java.util.List<irestads.model.MenuLine> findMenuLinesByNumOfDish(
		int numOfDish) {
		return _menuLineService.findMenuLinesByNumOfDish(numOfDish);
	}

	public java.util.List<irestads.model.MenuLine> findMenuLinesByStatus(
		boolean status) {
		return _menuLineService.findMenuLinesByStatus(status);
	}

	public java.lang.String parseBooleanToShow(boolean value,
		java.lang.String TValue, java.lang.String Fvalue) {
		return _menuLineService.parseBooleanToShow(value, TValue, Fvalue);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public MenuLineService getWrappedMenuLineService() {
		return _menuLineService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedMenuLineService(MenuLineService menuLineService) {
		_menuLineService = menuLineService;
	}

	public MenuLineService getWrappedService() {
		return _menuLineService;
	}

	public void setWrappedService(MenuLineService menuLineService) {
		_menuLineService = menuLineService;
	}

	private MenuLineService _menuLineService;
}