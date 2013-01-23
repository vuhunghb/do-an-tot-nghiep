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

/**
 * @author Be
 */
public interface DishFinder {
	public java.util.List<irestads.model.Dish> findDishNotInMenu();

	public java.util.List<irestads.model.Dish> findDishsByName(
		java.lang.String dishName);

	public java.util.List<irestads.model.Dish> findDishsByDecription(
		java.lang.String decription);

	public java.util.List<irestads.model.Dish> findDishsByAvatarImg(
		java.lang.String avatarImg);

	public java.util.List<irestads.model.Dish> findDishsByDetailImg(
		java.lang.String detailImg);

	public java.util.List<irestads.model.Dish> findDishsByDetail(
		java.lang.String detail);

	public java.util.List<irestads.model.Dish> findDishsByCategoryName(
		java.lang.String categoryName);

	public java.util.List<irestads.model.Dish> findDishsByProperty(
		java.lang.String field, java.lang.String idQuery);

	public java.util.List<irestads.model.Dish> findDishsBySomeField(
		long dishId, int referPrice, java.lang.String dishName,
		java.lang.String decription, java.lang.String avatarImg,
		java.lang.String detailImg, java.lang.String detail);
}