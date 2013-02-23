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
public class AdsItemFinderUtil {
	public static java.util.List<irestads.model.AdsItem> findAdsByCompName(
		java.lang.String keyword) {
		return getFinder().findAdsByCompName(keyword);
	}

	public static java.util.List<irestads.model.AdsItem> findAdsByTags(
		java.lang.String keyword) {
		return getFinder().findAdsByTags(keyword);
	}

	public static java.util.List<irestads.model.AdsItem> findAdsByProductName(
		java.lang.String keyword) {
		return getFinder().findAdsByProductName(keyword);
	}

	public static java.util.List<irestads.model.AdsItem> findAdsByItemType(
		java.lang.String keyword) {
		return getFinder().findAdsByItemType(keyword);
	}

	public static java.util.List<irestads.model.AdsItem> findAdsByCategoryName(
		java.lang.String keyword) {
		return getFinder().findAdsByCategoryName(keyword);
	}

	public static java.util.List<irestads.model.AdsItem> findAdsItemByProperty(
		java.lang.String field, java.lang.String idQuery) {
		return getFinder().findAdsItemByProperty(field, idQuery);
	}

	public static AdsItemFinder getFinder() {
		if (_finder == null) {
			_finder = (AdsItemFinder)PortletBeanLocatorUtil.locate(irestads.service.ClpSerializer.getServletContextName(),
					AdsItemFinder.class.getName());

			ReferenceRegistry.registerReference(AdsItemFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(AdsItemFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(AdsItemFinderUtil.class, "_finder");
	}

	private static AdsItemFinder _finder;
}