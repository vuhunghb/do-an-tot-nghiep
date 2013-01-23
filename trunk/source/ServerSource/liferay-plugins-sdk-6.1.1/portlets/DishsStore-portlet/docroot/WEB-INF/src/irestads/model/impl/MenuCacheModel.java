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

import irestads.model.Menu;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing Menu in entity cache.
 *
 * @author Be
 * @see Menu
 * @generated
 */
public class MenuCacheModel implements CacheModel<Menu>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{menuId=");
		sb.append(menuId);
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
		sb.append(", menuName=");
		sb.append(menuName);
		sb.append("}");

		return sb.toString();
	}

	public Menu toEntityModel() {
		MenuImpl menuImpl = new MenuImpl();

		menuImpl.setMenuId(menuId);
		menuImpl.setCompanyId(companyId);
		menuImpl.setUserId(userId);

		if (userName == null) {
			menuImpl.setUserName(StringPool.BLANK);
		}
		else {
			menuImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			menuImpl.setCreateDate(null);
		}
		else {
			menuImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			menuImpl.setModifiedDate(null);
		}
		else {
			menuImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (menuName == null) {
			menuImpl.setMenuName(StringPool.BLANK);
		}
		else {
			menuImpl.setMenuName(menuName);
		}

		menuImpl.resetOriginalValues();

		return menuImpl;
	}

	public long menuId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String menuName;
}