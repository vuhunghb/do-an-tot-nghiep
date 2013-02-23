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

import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;

import irestads.NoSuchCategoryAdsException;
import irestads.model.AdsItem;
import irestads.model.CategoryAds;
import irestads.service.base.CategoryAdsLocalServiceBaseImpl;
import irestads.service.persistence.AdsItemUtil;
import irestads.service.persistence.CategoryAdsUtil;

/**
 * The implementation of the category ads local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link irestads.service.CategoryAdsLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Be
 * @see irestads.service.base.CategoryAdsLocalServiceBaseImpl
 * @see irestads.service.CategoryAdsLocalServiceUtil
 */
public class CategoryAdsLocalServiceImpl extends CategoryAdsLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link irestads.service.CategoryAdsLocalServiceUtil} to access the category ads local service.
	 */
	public List<CategoryAds> getAddCategoryAds(){
		try {
			return CategoryAdsUtil.findAll();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public CategoryAds findById(long id){
		
			try {
				return CategoryAdsUtil.fetchByPrimaryKey(id);
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return null;
	}
}