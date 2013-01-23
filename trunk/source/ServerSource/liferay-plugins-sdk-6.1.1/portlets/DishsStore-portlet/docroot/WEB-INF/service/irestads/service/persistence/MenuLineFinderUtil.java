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
public class MenuLineFinderUtil {
	public static java.util.List<irestads.model.MenuLine> findMenuLinesByDName(
		java.lang.String dishName) {
		return getFinder().findMenuLinesByDName(dishName);
	}

	public static java.util.List<irestads.model.MenuLine> findMenuLinesByDDecription(
		java.lang.String decription) {
		return getFinder().findMenuLinesByDDecription(decription);
	}

	public static java.util.List<irestads.model.MenuLine> findMenuLinesByDAvatarImg(
		java.lang.String avartarImg) {
		return getFinder().findMenuLinesByDAvatarImg(avartarImg);
	}

	public static java.util.List<irestads.model.MenuLine> findMenuLinesByDDetailImg(
		java.lang.String detailImg) {
		return getFinder().findMenuLinesByDDetailImg(detailImg);
	}

	public static java.util.List<irestads.model.MenuLine> findMenuLinesByDDetail(
		java.lang.String detail) {
		return getFinder().findMenuLinesByDDetail(detail);
	}

	public static java.util.List<irestads.model.MenuLine> findMenuLinesByDCategoryName(
		java.lang.String categoryName) {
		return getFinder().findMenuLinesByDCategoryName(categoryName);
	}

	public static java.util.List<irestads.model.MenuLine> findMenuLinesByDReferPrice(
		int price) {
		return getFinder().findMenuLinesByDReferPrice(price);
	}

	public static java.util.List<irestads.model.MenuLine> findMenuLinesByDish(
		java.lang.String field, java.lang.String idQuery) {
		return getFinder().findMenuLinesByDish(field, idQuery);
	}

	public static MenuLineFinder getFinder() {
		if (_finder == null) {
			_finder = (MenuLineFinder)PortletBeanLocatorUtil.locate(irestads.service.ClpSerializer.getServletContextName(),
					MenuLineFinder.class.getName());

			ReferenceRegistry.registerReference(MenuLineFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(MenuLineFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(MenuLineFinderUtil.class, "_finder");
	}

	private static MenuLineFinder _finder;
}