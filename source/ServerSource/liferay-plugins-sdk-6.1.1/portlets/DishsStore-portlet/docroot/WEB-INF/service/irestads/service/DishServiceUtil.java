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
import com.liferay.portal.service.InvokableService;

/**
 * The utility for the dish remote service. This utility wraps {@link irestads.service.impl.DishServiceImpl} and is the primary access point for service operations in application layer code running on a remote server.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Be
 * @see DishService
 * @see irestads.service.base.DishServiceBaseImpl
 * @see irestads.service.impl.DishServiceImpl
 * @generated
 */
public class DishServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link irestads.service.impl.DishServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

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

	public static irestads.model.Dish createDish(java.lang.String dishName,
		java.lang.String decription, java.lang.String avatarImg,
		java.lang.String detailImg, java.lang.String detail, int referPrice,
		java.lang.String avatarBaseCode, java.lang.String detailBaseCode,
		int numOfDiner, long categoryId) {
		return getService()
				   .createDish(dishName, decription, avatarImg, detailImg,
			detail, referPrice, avatarBaseCode, detailBaseCode, numOfDiner,
			categoryId);
	}

	public static irestads.model.Dish createDish(irestads.model.Dish d) {
		return getService().createDish(d);
	}

	public static java.util.List<irestads.model.Dish> findDishNotInMenu() {
		return getService().findDishNotInMenu();
	}

	public static java.util.List<irestads.model.Dish> getAllDishs() {
		return getService().getAllDishs();
	}

	public static java.util.List<irestads.model.Dish> getDishsByCategory(
		long categoryId) {
		return getService().getDishsByCategory(categoryId);
	}

	public static irestads.model.Dish updateDish(irestads.model.Dish dish) {
		return getService().updateDish(dish);
	}

	public static irestads.model.Dish deleteDish(irestads.model.Dish dish) {
		return getService().deleteDish(dish);
	}

	public static irestads.model.Dish findDishsById(long dishId) {
		return getService().findDishsById(dishId);
	}

	public static java.util.List<irestads.model.Dish> findDishsByReferPrice(
		int referPrice) {
		return getService().findDishsByReferPrice(referPrice);
	}

	public static java.util.List<irestads.model.Dish> findDishsByName(
		java.lang.String dishName) {
		return getService().findDishsByName(dishName);
	}

	public static java.util.List<irestads.model.Dish> findDishsByDecription(
		java.lang.String decription) {
		return getService().findDishsByDecription(decription);
	}

	public static java.util.List<irestads.model.Dish> findDishsByAvatarImg(
		java.lang.String avatarImg) {
		return getService().findDishsByAvatarImg(avatarImg);
	}

	public static java.util.List<irestads.model.Dish> findDishsByDetailImg(
		java.lang.String detailImg) {
		return getService().findDishsByDetailImg(detailImg);
	}

	public static java.util.List<irestads.model.Dish> findDishsByDetail(
		java.lang.String detail) {
		return getService().findDishsByDetail(detail);
	}

	public static java.util.List<irestads.model.Dish> findDishsByCategoryName(
		java.lang.String categoryName) {
		return getService().findDishsByCategoryName(categoryName);
	}

	public static java.util.List<irestads.model.Dish> findDishsBySomeField(
		long dishId, int referPrice, java.lang.String dishName,
		java.lang.String decription, java.lang.String avatarImg,
		java.lang.String detailImg, java.lang.String detail) {
		return getService()
				   .findDishsBySomeField(dishId, referPrice, dishName,
			decription, avatarImg, detailImg, detail);
	}

	public static boolean isDeleteDish(long dishId) {
		return getService().isDeleteDish(dishId);
	}

	public static void clearService() {
		_service = null;
	}

	public static DishService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					DishService.class.getName());

			if (invokableService instanceof DishService) {
				_service = (DishService)invokableService;
			}
			else {
				_service = new DishServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(DishServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(DishService service) {
	}

	private static DishService _service;
}