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

import irestads.model.CategoryAds;
import irestads.service.CategoryAdsLocalServiceUtil;
import irestads.service.base.CategoryAdsServiceBaseImpl;
import irestads.service.persistence.CategoryAdsUtil;

/**
 * The implementation of the category ads remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link irestads.service.CategoryAdsService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Be
 * @see irestads.service.base.CategoryAdsServiceBaseImpl
 * @see irestads.service.CategoryAdsServiceUtil
 */
public class CategoryAdsServiceImpl extends CategoryAdsServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link irestads.service.CategoryAdsServiceUtil} to access the category ads remote service.
	 */
	public List<CategoryAds> getAddCategoryAds(){
		return CategoryAdsLocalServiceUtil.getAddCategoryAds();
	}
	public CategoryAds findById(long id){
		return CategoryAdsLocalServiceUtil.findById(id);
	}
}