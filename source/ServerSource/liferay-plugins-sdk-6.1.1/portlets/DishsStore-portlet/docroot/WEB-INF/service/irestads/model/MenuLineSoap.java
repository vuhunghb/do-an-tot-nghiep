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
 * This class is used by SOAP remote services, specifically {@link irestads.service.http.MenuLineServiceSoap}.
 *
 * @author    Be
 * @see       irestads.service.http.MenuLineServiceSoap
 * @generated
 */
public class MenuLineSoap implements Serializable {
	public static MenuLineSoap toSoapModel(MenuLine model) {
		MenuLineSoap soapModel = new MenuLineSoap();

		soapModel.setMenuLineId(model.getMenuLineId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setNumOfDish(model.getNumOfDish());
		soapModel.setCapacity(model.getCapacity());
		soapModel.setStatus(model.getStatus());
		soapModel.setDishId(model.getDishId());

		return soapModel;
	}

	public static MenuLineSoap[] toSoapModels(MenuLine[] models) {
		MenuLineSoap[] soapModels = new MenuLineSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static MenuLineSoap[][] toSoapModels(MenuLine[][] models) {
		MenuLineSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new MenuLineSoap[models.length][models[0].length];
		}
		else {
			soapModels = new MenuLineSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static MenuLineSoap[] toSoapModels(List<MenuLine> models) {
		List<MenuLineSoap> soapModels = new ArrayList<MenuLineSoap>(models.size());

		for (MenuLine model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new MenuLineSoap[soapModels.size()]);
	}

	public MenuLineSoap() {
	}

	public long getPrimaryKey() {
		return _menuLineId;
	}

	public void setPrimaryKey(long pk) {
		setMenuLineId(pk);
	}

	public long getMenuLineId() {
		return _menuLineId;
	}

	public void setMenuLineId(long menuLineId) {
		_menuLineId = menuLineId;
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

	public boolean getStatus() {
		return _status;
	}

	public boolean isStatus() {
		return _status;
	}

	public void setStatus(boolean status) {
		_status = status;
	}

	public long getDishId() {
		return _dishId;
	}

	public void setDishId(long dishId) {
		_dishId = dishId;
	}

	private long _menuLineId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private int _numOfDish;
	private int _capacity;
	private boolean _status;
	private long _dishId;
}