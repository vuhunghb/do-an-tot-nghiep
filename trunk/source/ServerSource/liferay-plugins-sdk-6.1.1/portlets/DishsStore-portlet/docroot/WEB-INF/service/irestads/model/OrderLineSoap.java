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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link irestads.service.http.OrderLineServiceSoap}.
 *
 * @author    Be
 * @see       irestads.service.http.OrderLineServiceSoap
 * @generated
 */
public class OrderLineSoap implements Serializable {
	public static OrderLineSoap toSoapModel(OrderLine model) {
		OrderLineSoap soapModel = new OrderLineSoap();

		soapModel.setOrderLineId(model.getOrderLineId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setNumOfDish(model.getNumOfDish());
		soapModel.setCapacity(model.getCapacity());
		soapModel.setStatusDish(model.getStatusDish());
		soapModel.setDishId(model.getDishId());
		soapModel.setOrderId(model.getOrderId());

		return soapModel;
	}

	public static OrderLineSoap[] toSoapModels(OrderLine[] models) {
		OrderLineSoap[] soapModels = new OrderLineSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static OrderLineSoap[][] toSoapModels(OrderLine[][] models) {
		OrderLineSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new OrderLineSoap[models.length][models[0].length];
		}
		else {
			soapModels = new OrderLineSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static OrderLineSoap[] toSoapModels(List<OrderLine> models) {
		List<OrderLineSoap> soapModels = new ArrayList<OrderLineSoap>(models.size());

		for (OrderLine model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new OrderLineSoap[soapModels.size()]);
	}

	public OrderLineSoap() {
	}

	public long getPrimaryKey() {
		return _orderLineId;
	}

	public void setPrimaryKey(long pk) {
		setOrderLineId(pk);
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

	public int getCapacity() {
		return _capacity;
	}

	public void setCapacity(int capacity) {
		_capacity = capacity;
	}

	public boolean getStatusDish() {
		return _statusDish;
	}

	public boolean isStatusDish() {
		return _statusDish;
	}

	public void setStatusDish(boolean statusDish) {
		_statusDish = statusDish;
	}

	public long getDishId() {
		return _dishId;
	}

	public void setDishId(long dishId) {
		_dishId = dishId;
	}

	public long getOrderId() {
		return _orderId;
	}

	public void setOrderId(long orderId) {
		_orderId = orderId;
	}

	private long _orderLineId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private int _numOfDish;
	private int _capacity;
	private boolean _statusDish;
	private long _dishId;
	private long _orderId;
}