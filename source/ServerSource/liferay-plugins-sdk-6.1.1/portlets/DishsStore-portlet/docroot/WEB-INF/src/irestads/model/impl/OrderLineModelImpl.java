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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import irestads.model.OrderLine;
import irestads.model.OrderLineModel;
import irestads.model.OrderLineSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the OrderLine service. Represents a row in the &quot;dishsstore_OrderLine&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link irestads.model.OrderLineModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link OrderLineImpl}.
 * </p>
 *
 * @author Be
 * @see OrderLineImpl
 * @see irestads.model.OrderLine
 * @see irestads.model.OrderLineModel
 * @generated
 */
@JSON(strict = true)
public class OrderLineModelImpl extends BaseModelImpl<OrderLine>
	implements OrderLineModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a order line model instance should use the {@link irestads.model.OrderLine} interface instead.
	 */
	public static final String TABLE_NAME = "dishsstore_OrderLine";
	public static final Object[][] TABLE_COLUMNS = {
			{ "orderLineId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "numOfDish", Types.INTEGER },
			{ "numOfFinishDish", Types.INTEGER },
			{ "statusDish", Types.INTEGER },
			{ "dishId", Types.BIGINT },
			{ "orderDate", Types.TIMESTAMP },
			{ "orderId", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table dishsstore_OrderLine (orderLineId LONG not null primary key,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,numOfDish INTEGER,numOfFinishDish INTEGER,statusDish INTEGER,dishId LONG,orderDate DATE null,orderId LONG)";
	public static final String TABLE_SQL_DROP = "drop table dishsstore_OrderLine";
	public static final String ORDER_BY_JPQL = " ORDER BY orderLine.orderLineId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY dishsstore_OrderLine.orderLineId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.irestads.model.OrderLine"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.irestads.model.OrderLine"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.irestads.model.OrderLine"),
			true);
	public static long ORDERID_COLUMN_BITMASK = 1L;
	public static long STATUSDISH_COLUMN_BITMASK = 2L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static OrderLine toModel(OrderLineSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		OrderLine model = new OrderLineImpl();

		model.setOrderLineId(soapModel.getOrderLineId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setNumOfDish(soapModel.getNumOfDish());
		model.setNumOfFinishDish(soapModel.getNumOfFinishDish());
		model.setStatusDish(soapModel.getStatusDish());
		model.setDishId(soapModel.getDishId());
		model.setOrderDate(soapModel.getOrderDate());
		model.setOrderId(soapModel.getOrderId());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<OrderLine> toModels(OrderLineSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<OrderLine> models = new ArrayList<OrderLine>(soapModels.length);

		for (OrderLineSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.irestads.model.OrderLine"));

	public OrderLineModelImpl() {
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

	public Class<?> getModelClass() {
		return OrderLine.class;
	}

	public String getModelClassName() {
		return OrderLine.class.getName();
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

	@JSON
	public long getOrderLineId() {
		return _orderLineId;
	}

	public void setOrderLineId(long orderLineId) {
		_columnBitmask = -1L;

		_orderLineId = orderLineId;
	}

	@JSON
	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@JSON
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

	@JSON
	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	@JSON
	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	@JSON
	public int getNumOfDish() {
		return _numOfDish;
	}

	public void setNumOfDish(int numOfDish) {
		_numOfDish = numOfDish;
	}

	@JSON
	public int getNumOfFinishDish() {
		return _numOfFinishDish;
	}

	public void setNumOfFinishDish(int numOfFinishDish) {
		_numOfFinishDish = numOfFinishDish;
	}

	@JSON
	public int getStatusDish() {
		return _statusDish;
	}

	public void setStatusDish(int statusDish) {
		_columnBitmask |= STATUSDISH_COLUMN_BITMASK;

		if (!_setOriginalStatusDish) {
			_setOriginalStatusDish = true;

			_originalStatusDish = _statusDish;
		}

		_statusDish = statusDish;
	}

	public int getOriginalStatusDish() {
		return _originalStatusDish;
	}

	@JSON
	public long getDishId() {
		return _dishId;
	}

	public void setDishId(long dishId) {
		_dishId = dishId;
	}

	@JSON
	public Date getOrderDate() {
		return _orderDate;
	}

	public void setOrderDate(Date orderDate) {
		_orderDate = orderDate;
	}

	@JSON
	public long getOrderId() {
		return _orderId;
	}

	public void setOrderId(long orderId) {
		_columnBitmask |= ORDERID_COLUMN_BITMASK;

		if (!_setOriginalOrderId) {
			_setOriginalOrderId = true;

			_originalOrderId = _orderId;
		}

		_orderId = orderId;
	}

	public long getOriginalOrderId() {
		return _originalOrderId;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			OrderLine.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public OrderLine toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (OrderLine)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public Object clone() {
		OrderLineImpl orderLineImpl = new OrderLineImpl();

		orderLineImpl.setOrderLineId(getOrderLineId());
		orderLineImpl.setCompanyId(getCompanyId());
		orderLineImpl.setUserId(getUserId());
		orderLineImpl.setUserName(getUserName());
		orderLineImpl.setCreateDate(getCreateDate());
		orderLineImpl.setModifiedDate(getModifiedDate());
		orderLineImpl.setNumOfDish(getNumOfDish());
		orderLineImpl.setNumOfFinishDish(getNumOfFinishDish());
		orderLineImpl.setStatusDish(getStatusDish());
		orderLineImpl.setDishId(getDishId());
		orderLineImpl.setOrderDate(getOrderDate());
		orderLineImpl.setOrderId(getOrderId());

		orderLineImpl.resetOriginalValues();

		return orderLineImpl;
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

		OrderLine orderLine = null;

		try {
			orderLine = (OrderLine)obj;
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
	public void resetOriginalValues() {
		OrderLineModelImpl orderLineModelImpl = this;

		orderLineModelImpl._originalStatusDish = orderLineModelImpl._statusDish;

		orderLineModelImpl._setOriginalStatusDish = false;

		orderLineModelImpl._originalOrderId = orderLineModelImpl._orderId;

		orderLineModelImpl._setOriginalOrderId = false;

		orderLineModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<OrderLine> toCacheModel() {
		OrderLineCacheModel orderLineCacheModel = new OrderLineCacheModel();

		orderLineCacheModel.orderLineId = getOrderLineId();

		orderLineCacheModel.companyId = getCompanyId();

		orderLineCacheModel.userId = getUserId();

		orderLineCacheModel.userName = getUserName();

		String userName = orderLineCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			orderLineCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			orderLineCacheModel.createDate = createDate.getTime();
		}
		else {
			orderLineCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			orderLineCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			orderLineCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		orderLineCacheModel.numOfDish = getNumOfDish();

		orderLineCacheModel.numOfFinishDish = getNumOfFinishDish();

		orderLineCacheModel.statusDish = getStatusDish();

		orderLineCacheModel.dishId = getDishId();

		Date orderDate = getOrderDate();

		if (orderDate != null) {
			orderLineCacheModel.orderDate = orderDate.getTime();
		}
		else {
			orderLineCacheModel.orderDate = Long.MIN_VALUE;
		}

		orderLineCacheModel.orderId = getOrderId();

		return orderLineCacheModel;
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

	private static ClassLoader _classLoader = OrderLine.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			OrderLine.class
		};
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
	private int _originalStatusDish;
	private boolean _setOriginalStatusDish;
	private long _dishId;
	private Date _orderDate;
	private long _orderId;
	private long _originalOrderId;
	private boolean _setOriginalOrderId;
	private long _columnBitmask;
	private OrderLine _escapedModelProxy;
}