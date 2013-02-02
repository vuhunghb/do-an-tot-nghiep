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

import irestads.model.OrderLine;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing OrderLine in entity cache.
 *
 * @author Be
 * @see OrderLine
 * @generated
 */
public class OrderLineCacheModel implements CacheModel<OrderLine>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{orderLineId=");
		sb.append(orderLineId);
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
		sb.append(", statusDish=");
		sb.append(statusDish);
		sb.append(", dishId=");
		sb.append(dishId);
		sb.append(", orderId=");
		sb.append(orderId);
		sb.append("}");

		return sb.toString();
	}

	public OrderLine toEntityModel() {
		OrderLineImpl orderLineImpl = new OrderLineImpl();

		orderLineImpl.setOrderLineId(orderLineId);
		orderLineImpl.setCompanyId(companyId);
		orderLineImpl.setUserId(userId);

		if (userName == null) {
			orderLineImpl.setUserName(StringPool.BLANK);
		}
		else {
			orderLineImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			orderLineImpl.setCreateDate(null);
		}
		else {
			orderLineImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			orderLineImpl.setModifiedDate(null);
		}
		else {
			orderLineImpl.setModifiedDate(new Date(modifiedDate));
		}

		orderLineImpl.setNumOfDish(numOfDish);
		orderLineImpl.setStatusDish(statusDish);
		orderLineImpl.setDishId(dishId);
		orderLineImpl.setOrderId(orderId);

		orderLineImpl.resetOriginalValues();

		return orderLineImpl;
	}

	public long orderLineId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public int numOfDish;
	public int statusDish;
	public long dishId;
	public long orderId;
}