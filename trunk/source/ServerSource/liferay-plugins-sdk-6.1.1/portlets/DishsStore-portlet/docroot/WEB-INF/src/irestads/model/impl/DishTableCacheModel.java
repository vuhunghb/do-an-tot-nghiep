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

import irestads.model.DishTable;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing DishTable in entity cache.
 *
 * @author Be
 * @see DishTable
 * @generated
 */
public class DishTableCacheModel implements CacheModel<DishTable>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{dishTableId=");
		sb.append(dishTableId);
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
		sb.append(", isAvalable=");
		sb.append(isAvalable);
		sb.append(", numChair=");
		sb.append(numChair);
		sb.append("}");

		return sb.toString();
	}

	public DishTable toEntityModel() {
		DishTableImpl dishTableImpl = new DishTableImpl();

		dishTableImpl.setDishTableId(dishTableId);
		dishTableImpl.setCompanyId(companyId);
		dishTableImpl.setUserId(userId);

		if (userName == null) {
			dishTableImpl.setUserName(StringPool.BLANK);
		}
		else {
			dishTableImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			dishTableImpl.setCreateDate(null);
		}
		else {
			dishTableImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			dishTableImpl.setModifiedDate(null);
		}
		else {
			dishTableImpl.setModifiedDate(new Date(modifiedDate));
		}

		dishTableImpl.setIsAvalable(isAvalable);
		dishTableImpl.setNumChair(numChair);

		dishTableImpl.resetOriginalValues();

		return dishTableImpl;
	}

	public long dishTableId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public boolean isAvalable;
	public int numChair;
}