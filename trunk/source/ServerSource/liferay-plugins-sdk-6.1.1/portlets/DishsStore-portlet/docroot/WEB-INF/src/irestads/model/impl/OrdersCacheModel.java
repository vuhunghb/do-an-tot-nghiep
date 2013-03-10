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

import irestads.model.Orders;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing Orders in entity cache.
 *
 * @author Be
 * @see Orders
 * @generated
 */
public class OrdersCacheModel implements CacheModel<Orders>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{orderId=");
		sb.append(orderId);
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
		sb.append(", charge=");
		sb.append(charge);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append(", isPayMent=");
		sb.append(isPayMent);
		sb.append(", flag=");
		sb.append(flag);
		sb.append(", numOfDinner=");
		sb.append(numOfDinner);
		sb.append(", dishTableId=");
		sb.append(dishTableId);
		sb.append("}");

		return sb.toString();
	}

	public Orders toEntityModel() {
		OrdersImpl ordersImpl = new OrdersImpl();

		ordersImpl.setOrderId(orderId);
		ordersImpl.setCompanyId(companyId);
		ordersImpl.setUserId(userId);

		if (userName == null) {
			ordersImpl.setUserName(StringPool.BLANK);
		}
		else {
			ordersImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			ordersImpl.setCreateDate(null);
		}
		else {
			ordersImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			ordersImpl.setModifiedDate(null);
		}
		else {
			ordersImpl.setModifiedDate(new Date(modifiedDate));
		}

		ordersImpl.setCharge(charge);

		if (createdDate == Long.MIN_VALUE) {
			ordersImpl.setCreatedDate(null);
		}
		else {
			ordersImpl.setCreatedDate(new Date(createdDate));
		}

		ordersImpl.setIsPayMent(isPayMent);
		ordersImpl.setFlag(flag);
		ordersImpl.setNumOfDinner(numOfDinner);

		if (dishTableId == null) {
			ordersImpl.setDishTableId(StringPool.BLANK);
		}
		else {
			ordersImpl.setDishTableId(dishTableId);
		}

		ordersImpl.resetOriginalValues();

		return ordersImpl;
	}

	public long orderId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public int charge;
	public long createdDate;
	public int isPayMent;
	public boolean flag;
	public int numOfDinner;
	public String dishTableId;
}