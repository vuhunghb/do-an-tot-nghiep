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

import irestads.model.Category;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing Category in entity cache.
 *
 * @author Be
 * @see Category
 * @generated
 */
public class CategoryCacheModel implements CacheModel<Category>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{categoryId=");
		sb.append(categoryId);
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
		sb.append(", categoryName=");
		sb.append(categoryName);
		sb.append("}");

		return sb.toString();
	}

	public Category toEntityModel() {
		CategoryImpl categoryImpl = new CategoryImpl();

		categoryImpl.setCategoryId(categoryId);
		categoryImpl.setCompanyId(companyId);
		categoryImpl.setUserId(userId);

		if (userName == null) {
			categoryImpl.setUserName(StringPool.BLANK);
		}
		else {
			categoryImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			categoryImpl.setCreateDate(null);
		}
		else {
			categoryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			categoryImpl.setModifiedDate(null);
		}
		else {
			categoryImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (categoryName == null) {
			categoryImpl.setCategoryName(StringPool.BLANK);
		}
		else {
			categoryImpl.setCategoryName(categoryName);
		}

		categoryImpl.resetOriginalValues();

		return categoryImpl;
	}

	public long categoryId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String categoryName;
}