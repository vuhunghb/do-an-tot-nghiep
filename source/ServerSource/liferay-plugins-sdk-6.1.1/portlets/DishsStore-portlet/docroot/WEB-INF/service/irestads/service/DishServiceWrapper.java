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
 * This class is a wrapper for {@link DishService}.
 * </p>
 *
 * @author    Be
 * @see       DishService
 * @generated
 */
public class DishServiceWrapper implements DishService,
	ServiceWrapper<DishService> {
	public DishServiceWrapper(DishService dishService) {
		_dishService = dishService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _dishService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_dishService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _dishService.invokeMethod(name, parameterTypes, arguments);
	}

	public irestads.model.Dish createDish(java.lang.String dishName,
		java.lang.String decription, java.lang.String avatarImg,
		java.lang.String detailImg, java.lang.String detail, int referPrice,
		java.lang.String avatarBaseCode, java.lang.String detailBaseCode,
		long categoryId) {
		return _dishService.createDish(dishName, decription, avatarImg,
			detailImg, detail, referPrice, avatarBaseCode, detailBaseCode,
			categoryId);
	}

	public irestads.model.Dish createDish(irestads.model.Dish d) {
		return _dishService.createDish(d);
	}

	public java.util.List<irestads.model.Dish> findDishNotInMenu() {
		return _dishService.findDishNotInMenu();
	}

	public java.util.List<irestads.model.Dish> getAllDishs() {
		return _dishService.getAllDishs();
	}

	public java.util.List<irestads.model.Dish> getDishsByCategory(
		long categoryId) {
		return _dishService.getDishsByCategory(categoryId);
	}

	public irestads.model.Dish updateDish(irestads.model.Dish dish) {
		return _dishService.updateDish(dish);
	}

	public irestads.model.Dish deleteDish(irestads.model.Dish dish) {
		return _dishService.deleteDish(dish);
	}

	public irestads.model.Dish findDishsById(long dishId) {
		return _dishService.findDishsById(dishId);
	}

	public java.util.List<irestads.model.Dish> findDishsByReferPrice(
		int referPrice) {
		return _dishService.findDishsByReferPrice(referPrice);
	}

	public java.util.List<irestads.model.Dish> findDishsByName(
		java.lang.String dishName) {
		return _dishService.findDishsByName(dishName);
	}

	public java.util.List<irestads.model.Dish> findDishsByDecription(
		java.lang.String decription) {
		return _dishService.findDishsByDecription(decription);
	}

	public java.util.List<irestads.model.Dish> findDishsByAvatarImg(
		java.lang.String avatarImg) {
		return _dishService.findDishsByAvatarImg(avatarImg);
	}

	public java.util.List<irestads.model.Dish> findDishsByDetailImg(
		java.lang.String detailImg) {
		return _dishService.findDishsByDetailImg(detailImg);
	}

	public java.util.List<irestads.model.Dish> findDishsByDetail(
		java.lang.String detail) {
		return _dishService.findDishsByDetail(detail);
	}

	public java.util.List<irestads.model.Dish> findDishsByCategoryName(
		java.lang.String categoryName) {
		return _dishService.findDishsByCategoryName(categoryName);
	}

	public java.util.List<irestads.model.Dish> findDishsBySomeField(
		long dishId, int referPrice, java.lang.String dishName,
		java.lang.String decription, java.lang.String avatarImg,
		java.lang.String detailImg, java.lang.String detail) {
		return _dishService.findDishsBySomeField(dishId, referPrice, dishName,
			decription, avatarImg, detailImg, detail);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public DishService getWrappedDishService() {
		return _dishService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedDishService(DishService dishService) {
		_dishService = dishService;
	}

	public DishService getWrappedService() {
		return _dishService;
	}

	public void setWrappedService(DishService dishService) {
		_dishService = dishService;
	}

	private DishService _dishService;
}