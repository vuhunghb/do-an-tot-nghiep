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
public class UVersionFinderUtil {
	public static java.util.List<irestads.model.UVersion> findNextVersions(
		long uversionId) {
		return getFinder().findNextVersions(uversionId);
	}

	public static UVersionFinder getFinder() {
		if (_finder == null) {
			_finder = (UVersionFinder)PortletBeanLocatorUtil.locate(irestads.service.ClpSerializer.getServletContextName(),
					UVersionFinder.class.getName());

			ReferenceRegistry.registerReference(UVersionFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(UVersionFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(UVersionFinderUtil.class, "_finder");
	}

	private static UVersionFinder _finder;
}