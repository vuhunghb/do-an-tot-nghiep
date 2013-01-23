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

import irestads.model.MenuLine;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing MenuLine in entity cache.
 *
 * @author Be
 * @see MenuLine
 * @generated
 */
public class MenuLineCacheModel implements CacheModel<MenuLine>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{menuLineId=");
		sb.append(menuLineId);
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
		sb.append(", numOfDish=");
		sb.append(numOfDish);
		sb.append(", status=");
		sb.append(status);
		sb.append(", dishId=");
		sb.append(dishId);
		sb.append("}");

		return sb.toString();
	}

	public MenuLine toEntityModel() {
		MenuLineImpl menuLineImpl = new MenuLineImpl();

		menuLineImpl.setMenuLineId(menuLineId);
		menuLineImpl.setCompanyId(companyId);
		menuLineImpl.setUserId(userId);

		if (userName == null) {
			menuLineImpl.setUserName(StringPool.BLANK);
		}
		else {
			menuLineImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			menuLineImpl.setCreateDate(null);
		}
		else {
			menuLineImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			menuLineImpl.setModifiedDate(null);
		}
		else {
			menuLineImpl.setModifiedDate(new Date(modifiedDate));
		}

		menuLineImpl.setNumOfDish(numOfDish);
		menuLineImpl.setStatus(status);
		menuLineImpl.setDishId(dishId);

		menuLineImpl.resetOriginalValues();

		return menuLineImpl;
	}

	public long menuLineId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public int numOfDish;
	public boolean status;
	public long dishId;
}