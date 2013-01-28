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

import irestads.NoSuchCategoryException;
import irestads.model.Category;
import irestads.service.base.CategoryLocalServiceBaseImpl;
import irestads.service.persistence.CategoryFinder;
import irestads.service.persistence.CategoryFinderUtil;
import irestads.service.persistence.CategoryUtil;

import java.util.List;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;


/**
 * The implementation of the category local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link iRestads.service.CategoryLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Be
 * @see iRestads.service.base.CategoryLocalServiceBaseImpl
 * @see iRestads.service.CategoryLocalServiceUtil
 */
public class CategoryLocalServiceImpl extends CategoryLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link iRestads.service.CategoryLocalServiceUtil} to access the category local service.
	 */
	public Category createCategory(String categoryName){
		try {
			long id= CounterLocalServiceUtil.increment(Category.class.getName());
			Category category=CategoryUtil.create(id);
			category.setCategoryName(categoryName);
			category=CategoryUtil.update(category, true);
			
			
			
		//	categoryPersistence.getDishs(pk)
			
			return category;
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	public int countCategoryById(long categoryId) {
		return CategoryFinderUtil.countCategoryById(categoryId);
	}
	
	public List<Category> getAllCategorys(){
		try {
			return CategoryUtil.findAll();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public Category findByID(long categoryId){
			try {
				return CategoryUtil.fetchByPrimaryKey(categoryId);
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
	}
}