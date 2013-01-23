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
public class CategoryFinderUtil {
	public static int countCategoryById(long categoryId) {
		return getFinder().countCategoryById(categoryId);
	}

	public static CategoryFinder getFinder() {
		if (_finder == null) {
			_finder = (CategoryFinder)PortletBeanLocatorUtil.locate(irestads.service.ClpSerializer.getServletContextName(),
					CategoryFinder.class.getName());

			ReferenceRegistry.registerReference(CategoryFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(CategoryFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(CategoryFinderUtil.class, "_finder");
	}

	private static CategoryFinder _finder;
}