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
 * This class is a wrapper for {@link CategoryService}.
 * </p>
 *
 * @author    Be
 * @see       CategoryService
 * @generated
 */
public class CategoryServiceWrapper implements CategoryService,
	ServiceWrapper<CategoryService> {
	public CategoryServiceWrapper(CategoryService categoryService) {
		_categoryService = categoryService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _categoryService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_categoryService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _categoryService.invokeMethod(name, parameterTypes, arguments);
	}

	public int countCategoryById(long categoryId) {
		return _categoryService.countCategoryById(categoryId);
	}

	public irestads.model.Category createCategory(java.lang.String categoryName) {
		return _categoryService.createCategory(categoryName);
	}

	public java.util.List<irestads.model.Category> getAllCategorys() {
		return _categoryService.getAllCategorys();
	}

	public irestads.model.Category findByID(long categoryId) {
		return _categoryService.findByID(categoryId);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public CategoryService getWrappedCategoryService() {
		return _categoryService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedCategoryService(CategoryService categoryService) {
		_categoryService = categoryService;
	}

	public CategoryService getWrappedService() {
		return _categoryService;
	}

	public void setWrappedService(CategoryService categoryService) {
		_categoryService = categoryService;
	}

	private CategoryService _categoryService;
}