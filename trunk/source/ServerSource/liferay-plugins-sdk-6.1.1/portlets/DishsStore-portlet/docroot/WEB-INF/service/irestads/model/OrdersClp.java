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

import irestads.service.OrdersLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Be
 */
public class OrdersClp extends BaseModelImpl<Orders> implements Orders {
	public OrdersClp() {
	}

	public Class<?> getModelClass() {
		return Orders.class;
	}

	public String getModelClassName() {
		return Orders.class.getName();
	}

	public long getPrimaryKey() {
		return _orderId;
	}

	public void setPrimaryKey(long primaryKey) {
		setOrderId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_orderId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("orderId", getOrderId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("charge", getCharge());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("isPayMent", getIsPayMent());
		attributes.put("numOfDinner", getNumOfDinner());
		attributes.put("dishTableId", getDishTableId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long orderId = (Long)attributes.get("orderId");

		if (orderId != null) {
			setOrderId(orderId);
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

		Integer charge = (Integer)attributes.get("charge");

		if (charge != null) {
			setCharge(charge);
		}

		Date createdDate = (Date)attributes.get("createdDate");

		if (createdDate != null) {
			setCreatedDate(createdDate);
		}

		Boolean isPayMent = (Boolean)attributes.get("isPayMent");

		if (isPayMent != null) {
			setIsPayMent(isPayMent);
		}

		Integer numOfDinner = (Integer)attributes.get("numOfDinner");

		if (numOfDinner != null) {
			setNumOfDinner(numOfDinner);
		}

		Long dishTableId = (Long)attributes.get("dishTableId");

		if (dishTableId != null) {
			setDishTableId(dishTableId);
		}
	}

	public long getOrderId() {
		return _orderId;
	}

	public void setOrderId(long orderId) {
		_orderId = orderId;
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

	public int getCharge() {
		return _charge;
	}

	public void setCharge(int charge) {
		_charge = charge;
	}

	public Date getCreatedDate() {
		return _createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		_createdDate = createdDate;
	}

	public boolean getIsPayMent() {
		return _isPayMent;
	}

	public boolean isIsPayMent() {
		return _isPayMent;
	}

	public void setIsPayMent(boolean isPayMent) {
		_isPayMent = isPayMent;
	}

	public int getNumOfDinner() {
		return _numOfDinner;
	}

	public void setNumOfDinner(int numOfDinner) {
		_numOfDinner = numOfDinner;
	}

	public long getDishTableId() {
		return _dishTableId;
	}

	public void setDishTableId(long dishTableId) {
		_dishTableId = dishTableId;
	}

	public BaseModel<?> getOrdersRemoteModel() {
		return _ordersRemoteModel;
	}

	public void setOrdersRemoteModel(BaseModel<?> ordersRemoteModel) {
		_ordersRemoteModel = ordersRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			OrdersLocalServiceUtil.addOrders(this);
		}
		else {
			OrdersLocalServiceUtil.updateOrders(this);
		}
	}

	@Override
	public Orders toEscapedModel() {
		return (Orders)Proxy.newProxyInstance(Orders.class.getClassLoader(),
			new Class[] { Orders.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		OrdersClp clone = new OrdersClp();

		clone.setOrderId(getOrderId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setCharge(getCharge());
		clone.setCreatedDate(getCreatedDate());
		clone.setIsPayMent(getIsPayMent());
		clone.setNumOfDinner(getNumOfDinner());
		clone.setDishTableId(getDishTableId());

		return clone;
	}

	public int compareTo(Orders orders) {
		long primaryKey = orders.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		OrdersClp orders = null;

		try {
			orders = (OrdersClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = orders.getPrimaryKey();

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
		StringBundler sb = new StringBundler(23);

		sb.append("{orderId=");
		sb.append(getOrderId());
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
		sb.append(", charge=");
		sb.append(getCharge());
		sb.append(", createdDate=");
		sb.append(getCreatedDate());
		sb.append(", isPayMent=");
		sb.append(getIsPayMent());
		sb.append(", numOfDinner=");
		sb.append(getNumOfDinner());
		sb.append(", dishTableId=");
		sb.append(getDishTableId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("irestads.model.Orders");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>orderId</column-name><column-value><![CDATA[");
		sb.append(getOrderId());
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
			"<column><column-name>charge</column-name><column-value><![CDATA[");
		sb.append(getCharge());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createdDate</column-name><column-value><![CDATA[");
		sb.append(getCreatedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isPayMent</column-name><column-value><![CDATA[");
		sb.append(getIsPayMent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>numOfDinner</column-name><column-value><![CDATA[");
		sb.append(getNumOfDinner());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dishTableId</column-name><column-value><![CDATA[");
		sb.append(getDishTableId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _orderId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private int _charge;
	private Date _createdDate;
	private boolean _isPayMent;
	private int _numOfDinner;
	private long _dishTableId;
	private BaseModel<?> _ordersRemoteModel;
}