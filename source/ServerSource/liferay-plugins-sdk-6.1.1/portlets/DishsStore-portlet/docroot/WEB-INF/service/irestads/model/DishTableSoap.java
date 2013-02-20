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
 * This class is used by SOAP remote services, specifically {@link irestads.service.http.DishTableServiceSoap}.
 *
 * @author    Be
 * @see       irestads.service.http.DishTableServiceSoap
 * @generated
 */
public class DishTableSoap implements Serializable {
	public static DishTableSoap toSoapModel(DishTable model) {
		DishTableSoap soapModel = new DishTableSoap();

		soapModel.setDishTableId(model.getDishTableId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setTableName(model.getTableName());
		soapModel.setIsAvalable(model.getIsAvalable());
		soapModel.setNumChair(model.getNumChair());
		soapModel.setCurrentOrderId(model.getCurrentOrderId());

		return soapModel;
	}

	public static DishTableSoap[] toSoapModels(DishTable[] models) {
		DishTableSoap[] soapModels = new DishTableSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DishTableSoap[][] toSoapModels(DishTable[][] models) {
		DishTableSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DishTableSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DishTableSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DishTableSoap[] toSoapModels(List<DishTable> models) {
		List<DishTableSoap> soapModels = new ArrayList<DishTableSoap>(models.size());

		for (DishTable model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DishTableSoap[soapModels.size()]);
	}

	public DishTableSoap() {
	}

	public String getPrimaryKey() {
		return _dishTableId;
	}

	public void setPrimaryKey(String pk) {
		setDishTableId(pk);
	}

	public String getDishTableId() {
		return _dishTableId;
	}

	public void setDishTableId(String dishTableId) {
		_dishTableId = dishTableId;
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

	public String getTableName() {
		return _tableName;
	}

	public void setTableName(String tableName) {
		_tableName = tableName;
	}

	public boolean getIsAvalable() {
		return _isAvalable;
	}

	public boolean isIsAvalable() {
		return _isAvalable;
	}

	public void setIsAvalable(boolean isAvalable) {
		_isAvalable = isAvalable;
	}

	public int getNumChair() {
		return _numChair;
	}

	public void setNumChair(int numChair) {
		_numChair = numChair;
	}

	public long getCurrentOrderId() {
		return _currentOrderId;
	}

	public void setCurrentOrderId(long currentOrderId) {
		_currentOrderId = currentOrderId;
	}

	private String _dishTableId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _tableName;
	private boolean _isAvalable;
	private int _numChair;
	private long _currentOrderId;
}