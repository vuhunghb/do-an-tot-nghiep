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
public interface MenuLineFinder {
	public java.util.List<irestads.model.MenuLine> findMenuLinesByDName(
		java.lang.String dishName);

	public java.util.List<irestads.model.MenuLine> findMenuLinesByDDecription(
		java.lang.String decription);

	public java.util.List<irestads.model.MenuLine> findMenuLinesByDAvatarImg(
		java.lang.String avartarImg);

	public java.util.List<irestads.model.MenuLine> findMenuLinesByDDetailImg(
		java.lang.String detailImg);

	public java.util.List<irestads.model.MenuLine> findMenuLinesByDDetail(
		java.lang.String detail);

	public java.util.List<irestads.model.MenuLine> findMenuLinesByDCategoryName(
		java.lang.String categoryName);

	public java.util.List<irestads.model.MenuLine> findMenuLinesByDReferPrice(
		int price);

	public java.util.List<irestads.model.MenuLine> findMenuLinesByDish(
		java.lang.String field, java.lang.String idQuery);
}