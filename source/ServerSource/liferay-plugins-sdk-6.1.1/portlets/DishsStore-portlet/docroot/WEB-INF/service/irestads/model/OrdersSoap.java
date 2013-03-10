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
 * This class is used by SOAP remote services, specifically {@link irestads.service.http.OrdersServiceSoap}.
 *
 * @author    Be
 * @see       irestads.service.http.OrdersServiceSoap
 * @generated
 */
public class OrdersSoap implements Serializable {
	public static OrdersSoap toSoapModel(Orders model) {
		OrdersSoap soapModel = new OrdersSoap();

		soapModel.setOrderId(model.getOrderId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCharge(model.getCharge());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setIsPayMent(model.getIsPayMent());
		soapModel.setFlag(model.getFlag());
		soapModel.setNumOfDinner(model.getNumOfDinner());
		soapModel.setDishTableId(model.getDishTableId());

		return soapModel;
	}

	public static OrdersSoap[] toSoapModels(Orders[] models) {
		OrdersSoap[] soapModels = new OrdersSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static OrdersSoap[][] toSoapModels(Orders[][] models) {
		OrdersSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new OrdersSoap[models.length][models[0].length];
		}
		else {
			soapModels = new OrdersSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static OrdersSoap[] toSoapModels(List<Orders> models) {
		List<OrdersSoap> soapModels = new ArrayList<OrdersSoap>(models.size());

		for (Orders model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new OrdersSoap[soapModels.size()]);
	}

	public OrdersSoap() {
	}

	public long getPrimaryKey() {
		return _orderId;
	}

	public void setPrimaryKey(long pk) {
		setOrderId(pk);
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

	public int getIsPayMent() {
		return _isPayMent;
	}

	public void setIsPayMent(int isPayMent) {
		_isPayMent = isPayMent;
	}

	public boolean getFlag() {
		return _flag;
	}

	public boolean isFlag() {
		return _flag;
	}

	public void setFlag(boolean flag) {
		_flag = flag;
	}

	public int getNumOfDinner() {
		return _numOfDinner;
	}

	public void setNumOfDinner(int numOfDinner) {
		_numOfDinner = numOfDinner;
	}

	public String getDishTableId() {
		return _dishTableId;
	}

	public void setDishTableId(String dishTableId) {
		_dishTableId = dishTableId;
	}

	private long _orderId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private int _charge;
	private Date _createdDate;
	private int _isPayMent;
	private boolean _flag;
	private int _numOfDinner;
	private String _dishTableId;
}