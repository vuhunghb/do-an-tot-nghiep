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

package irestads.service.impl;

import irestads.model.Category;
import irestads.service.CategoryLocalServiceUtil;
import irestads.service.base.CategoryServiceBaseImpl;

import java.util.List;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;



/**
 * The implementation of the category remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link iRestads.service.CategoryService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Be
 * @see iRestads.service.base.CategoryServiceBaseImpl
 * @see iRestads.service.CategoryServiceUtil
 */
public class CategoryServiceImpl extends CategoryServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link iRestads.service.CategoryServiceUtil} to access the category remote service.
	 */
	public int countCategoryById(long categoryId) {
		return CategoryLocalServiceUtil.countCategoryById(categoryId);
	}
	public Category createCategory(String categoryName){
		return CategoryLocalServiceUtil.createCategory(categoryName);
	}
	public List<Category> getAllCategorys(){
		return CategoryLocalServiceUtil.getAllCategorys();
	}
	public Category findByID(long categoryId){
		return CategoryLocalServiceUtil.findByID(categoryId);
	}
		
	
}