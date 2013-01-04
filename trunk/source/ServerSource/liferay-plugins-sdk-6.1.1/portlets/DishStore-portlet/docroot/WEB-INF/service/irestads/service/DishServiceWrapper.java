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
		java.lang.String detailImg, java.lang.String detail, double referPrice,
		long categoryId) {
		return _dishService.createDish(dishName, decription, avatarImg,
			detailImg, detail, referPrice, categoryId);
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