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
 * This class is a wrapper for {@link CategoryAdsService}.
 * </p>
 *
 * @author    Be
 * @see       CategoryAdsService
 * @generated
 */
public class CategoryAdsServiceWrapper implements CategoryAdsService,
	ServiceWrapper<CategoryAdsService> {
	public CategoryAdsServiceWrapper(CategoryAdsService categoryAdsService) {
		_categoryAdsService = categoryAdsService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _categoryAdsService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_categoryAdsService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _categoryAdsService.invokeMethod(name, parameterTypes, arguments);
	}

	public java.util.List<irestads.model.CategoryAds> getAddCategoryAds() {
		return _categoryAdsService.getAddCategoryAds();
	}

	public irestads.model.CategoryAds findById(long id) {
		return _categoryAdsService.findById(id);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public CategoryAdsService getWrappedCategoryAdsService() {
		return _categoryAdsService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedCategoryAdsService(
		CategoryAdsService categoryAdsService) {
		_categoryAdsService = categoryAdsService;
	}

	public CategoryAdsService getWrappedService() {
		return _categoryAdsService;
	}

	public void setWrappedService(CategoryAdsService categoryAdsService) {
		_categoryAdsService = categoryAdsService;
	}

	private CategoryAdsService _categoryAdsService;
}