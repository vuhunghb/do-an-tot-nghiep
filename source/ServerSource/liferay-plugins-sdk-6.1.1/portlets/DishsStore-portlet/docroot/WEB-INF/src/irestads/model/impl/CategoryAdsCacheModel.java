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

package irestads.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import irestads.model.CategoryAds;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing CategoryAds in entity cache.
 *
 * @author Be
 * @see CategoryAds
 * @generated
 */
public class CategoryAdsCacheModel implements CacheModel<CategoryAds>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{categoryAdsId=");
		sb.append(categoryAdsId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", categoryAdsName=");
		sb.append(categoryAdsName);
		sb.append("}");

		return sb.toString();
	}

	public CategoryAds toEntityModel() {
		CategoryAdsImpl categoryAdsImpl = new CategoryAdsImpl();

		categoryAdsImpl.setCategoryAdsId(categoryAdsId);
		categoryAdsImpl.setCompanyId(companyId);
		categoryAdsImpl.setUserId(userId);

		if (userName == null) {
			categoryAdsImpl.setUserName(StringPool.BLANK);
		}
		else {
			categoryAdsImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			categoryAdsImpl.setCreateDate(null);
		}
		else {
			categoryAdsImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			categoryAdsImpl.setModifiedDate(null);
		}
		else {
			categoryAdsImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (categoryAdsName == null) {
			categoryAdsImpl.setCategoryAdsName(StringPool.BLANK);
		}
		else {
			categoryAdsImpl.setCategoryAdsName(categoryAdsName);
		}

		categoryAdsImpl.resetOriginalValues();

		return categoryAdsImpl;
	}

	public long categoryAdsId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String categoryAdsName;
}