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

import irestads.model.Dish;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing Dish in entity cache.
 *
 * @author Be
 * @see Dish
 * @generated
 */
public class DishCacheModel implements CacheModel<Dish>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{dishId=");
		sb.append(dishId);
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
		sb.append(", dishName=");
		sb.append(dishName);
		sb.append(", decription=");
		sb.append(decription);
		sb.append(", avatarImg=");
		sb.append(avatarImg);
		sb.append(", avatarBaseCode=");
		sb.append(avatarBaseCode);
		sb.append(", detailImg=");
		sb.append(detailImg);
		sb.append(", detailBaseCode=");
		sb.append(detailBaseCode);
		sb.append(", detail=");
		sb.append(detail);
		sb.append(", referPrice=");
		sb.append(referPrice);
		sb.append(", numOfDiner=");
		sb.append(numOfDiner);
		sb.append(", categoryId=");
		sb.append(categoryId);
		sb.append("}");

		return sb.toString();
	}

	public Dish toEntityModel() {
		DishImpl dishImpl = new DishImpl();

		dishImpl.setDishId(dishId);
		dishImpl.setCompanyId(companyId);
		dishImpl.setUserId(userId);

		if (userName == null) {
			dishImpl.setUserName(StringPool.BLANK);
		}
		else {
			dishImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			dishImpl.setCreateDate(null);
		}
		else {
			dishImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			dishImpl.setModifiedDate(null);
		}
		else {
			dishImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (dishName == null) {
			dishImpl.setDishName(StringPool.BLANK);
		}
		else {
			dishImpl.setDishName(dishName);
		}

		if (decription == null) {
			dishImpl.setDecription(StringPool.BLANK);
		}
		else {
			dishImpl.setDecription(decription);
		}

		if (avatarImg == null) {
			dishImpl.setAvatarImg(StringPool.BLANK);
		}
		else {
			dishImpl.setAvatarImg(avatarImg);
		}

		if (avatarBaseCode == null) {
			dishImpl.setAvatarBaseCode(StringPool.BLANK);
		}
		else {
			dishImpl.setAvatarBaseCode(avatarBaseCode);
		}

		if (detailImg == null) {
			dishImpl.setDetailImg(StringPool.BLANK);
		}
		else {
			dishImpl.setDetailImg(detailImg);
		}

		if (detailBaseCode == null) {
			dishImpl.setDetailBaseCode(StringPool.BLANK);
		}
		else {
			dishImpl.setDetailBaseCode(detailBaseCode);
		}

		if (detail == null) {
			dishImpl.setDetail(StringPool.BLANK);
		}
		else {
			dishImpl.setDetail(detail);
		}

		dishImpl.setReferPrice(referPrice);
		dishImpl.setNumOfDiner(numOfDiner);
		dishImpl.setCategoryId(categoryId);

		dishImpl.resetOriginalValues();

		return dishImpl;
	}

	public long dishId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String dishName;
	public String decription;
	public String avatarImg;
	public String avatarBaseCode;
	public String detailImg;
	public String detailBaseCode;
	public String detail;
	public int referPrice;
	public int numOfDiner;
	public long categoryId;
}