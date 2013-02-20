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

package irestads.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import irestads.service.OrderLineLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Be
 */
public class OrderLineClp extends BaseModelImpl<OrderLine> implements OrderLine {
	public OrderLineClp() {
	}

	public Class<?> getModelClass() {
		return OrderLine.class;
	}

	public String getModelClassName() {
		return OrderLine.class.getName();
	}

	public long getPrimaryKey() {
		return _orderLineId;
	}

	public void setPrimaryKey(long primaryKey) {
		setOrderLineId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_orderLineId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("orderLineId", getOrderLineId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("numOfDish", getNumOfDish());
		attributes.put("numOfFinishDish", getNumOfFinishDish());
		attributes.put("statusDish", getStatusDish());
		attributes.put("dishId", getDishId());
		attributes.put("orderDate", getOrderDate());
		attributes.put("orderId", getOrderId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long orderLineId = (Long)attributes.get("orderLineId");

		if (orderLineId != null) {
			setOrderLineId(orderLineId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Integer numOfDish = (Integer)attributes.get("numOfDish");

		if (numOfDish != null) {
			setNumOfDish(numOfDish);
		}

		Integer numOfFinishDish = (Integer)attributes.get("numOfFinishDish");

		if (numOfFinishDish != null) {
			setNumOfFinishDish(numOfFinishDish);
		}

		Integer statusDish = (Integer)attributes.get("statusDish");

		if (statusDish != null) {
			setStatusDish(statusDish);
		}

		Long dishId = (Long)attributes.get("dishId");

		if (dishId != null) {
			setDishId(dishId);
		}

		Date orderDate = (Date)attributes.get("orderDate");

		if (orderDate != null) {
			setOrderDate(orderDate);
		}

		Long orderId = (Long)attributes.get("orderId");

		if (orderId != null) {
			setOrderId(orderId);
		}
	}

	public long getOrderLineId() {
		return _orderLineId;
	}

	public void setOrderLineId(long orderLineId) {
		_orderLineId = orderLineId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public int getNumOfDish() {
		return _numOfDish;
	}

	public void setNumOfDish(int numOfDish) {
		_numOfDish = numOfDish;
	}

	public int getNumOfFinishDish() {
		return _numOfFinishDish;
	}

	public void setNumOfFinishDish(int numOfFinishDish) {
		_numOfFinishDish = numOfFinishDish;
	}

	public int getStatusDish() {
		return _statusDish;
	}

	public void setStatusDish(int statusDish) {
		_statusDish = statusDish;
	}

	public long getDishId() {
		return _dishId;
	}

	public void setDishId(long dishId) {
		_dishId = dishId;
	}

	public Date getOrderDate() {
		return _orderDate;
	}

	public void setOrderDate(Date orderDate) {
		_orderDate = orderDate;
	}

	public long getOrderId() {
		return _orderId;
	}

	public void setOrderId(long orderId) {
		_orderId = orderId;
	}

	public BaseModel<?> getOrderLineRemoteModel() {
		return _orderLineRemoteModel;
	}

	public void setOrderLineRemoteModel(BaseModel<?> orderLineRemoteModel) {
		_orderLineRemoteModel = orderLineRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			OrderLineLocalServiceUtil.addOrderLine(this);
		}
		else {
			OrderLineLocalServiceUtil.updateOrderLine(this);
		}
	}

	@Override
	public OrderLine toEscapedModel() {
		return (OrderLine)Proxy.newProxyInstance(OrderLine.class.getClassLoader(),
			new Class[] { OrderLine.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		OrderLineClp clone = new OrderLineClp();

		clone.setOrderLineId(getOrderLineId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setNumOfDish(getNumOfDish());
		clone.setNumOfFinishDish(getNumOfFinishDish());
		clone.setStatusDish(getStatusDish());
		clone.setDishId(getDishId());
		clone.setOrderDate(getOrderDate());
		clone.setOrderId(getOrderId());

		return clone;
	}

	public int compareTo(OrderLine orderLine) {
		int value = 0;

		if (getOrderLineId() < orderLine.getOrderLineId()) {
			value = -1;
		}
		else if (getOrderLineId() > orderLine.getOrderLineId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		OrderLineClp orderLine = null;

		try {
			orderLine = (OrderLineClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = orderLine.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{orderLineId=");
		sb.append(getOrderLineId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", numOfDish=");
		sb.append(getNumOfDish());
		sb.append(", numOfFinishDish=");
		sb.append(getNumOfFinishDish());
		sb.append(", statusDish=");
		sb.append(getStatusDish());
		sb.append(", dishId=");
		sb.append(getDishId());
		sb.append(", orderDate=");
		sb.append(getOrderDate());
		sb.append(", orderId=");
		sb.append(getOrderId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("irestads.model.OrderLine");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>orderLineId</column-name><column-value><![CDATA[");
		sb.append(getOrderLineId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>numOfDish</column-name><column-value><![CDATA[");
		sb.append(getNumOfDish());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>numOfFinishDish</column-name><column-value><![CDATA[");
		sb.append(getNumOfFinishDish());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusDish</column-name><column-value><![CDATA[");
		sb.append(getStatusDish());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dishId</column-name><column-value><![CDATA[");
		sb.append(getDishId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>orderDate</column-name><column-value><![CDATA[");
		sb.append(getOrderDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>orderId</column-name><column-value><![CDATA[");
		sb.append(getOrderId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _orderLineId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private int _numOfDish;
	private int _numOfFinishDish;
	private int _statusDish;
	private long _dishId;
	private Date _orderDate;
	private long _orderId;
	private BaseModel<?> _orderLineRemoteModel;
}