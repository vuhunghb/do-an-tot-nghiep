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

package irestads.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author Be
 */
public class DishFinderUtil {
	public static java.util.List<irestads.model.Dish> findDishNotInMenu() {
		return getFinder().findDishNotInMenu();
	}

	public static java.util.List<irestads.model.Dish> findDishsByName(
		java.lang.String dishName) {
		return getFinder().findDishsByName(dishName);
	}

	public static java.util.List<irestads.model.Dish> findDishsByDecription(
		java.lang.String decription) {
		return getFinder().findDishsByDecription(decription);
	}

	public static java.util.List<irestads.model.Dish> findDishsByAvatarImg(
		java.lang.String avatarImg) {
		return getFinder().findDishsByAvatarImg(avatarImg);
	}

	public static java.util.List<irestads.model.Dish> findDishsByDetailImg(
		java.lang.String detailImg) {
		return getFinder().findDishsByDetailImg(detailImg);
	}

	public static java.util.List<irestads.model.Dish> findDishsByDetail(
		java.lang.String detail) {
		return getFinder().findDishsByDetail(detail);
	}

	public static java.util.List<irestads.model.Dish> findDishsByCategoryName(
		java.lang.String categoryName) {
		return getFinder().findDishsByCategoryName(categoryName);
	}

	public static java.util.List<irestads.model.Dish> findDishsByProperty(
		java.lang.String field, java.lang.String idQuery) {
		return getFinder().findDishsByProperty(field, idQuery);
	}

	public static java.util.List<irestads.model.Dish> findDishsBySomeField(
		long dishId, int referPrice, java.lang.String dishName,
		java.lang.String decription, java.lang.String avatarImg,
		java.lang.String detailImg, java.lang.String detail) {
		return getFinder()
				   .findDishsBySomeField(dishId, referPrice, dishName,
			decription, avatarImg, detailImg, detail);
	}

	public static DishFinder getFinder() {
		if (_finder == null) {
			_finder = (DishFinder)PortletBeanLocatorUtil.locate(irestads.service.ClpSerializer.getServletContextName(),
					DishFinder.class.getName());

			ReferenceRegistry.registerReference(DishFinderUtil.class, "_finder");
		}

		return _finder;
	}

	public void setFinder(DishFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(DishFinderUtil.class, "_finder");
	}

	private static DishFinder _finder;
}