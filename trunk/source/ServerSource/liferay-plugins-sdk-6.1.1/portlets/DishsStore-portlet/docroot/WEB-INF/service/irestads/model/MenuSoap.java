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
 * This class is used by SOAP remote services, specifically {@link irestads.service.http.MenuServiceSoap}.
 *
 * @author    Be
 * @see       irestads.service.http.MenuServiceSoap
 * @generated
 */
public class MenuSoap implements Serializable {
	public static MenuSoap toSoapModel(Menu model) {
		MenuSoap soapModel = new MenuSoap();

		soapModel.setMenuId(model.getMenuId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setMenuName(model.getMenuName());

		return soapModel;
	}

	public static MenuSoap[] toSoapModels(Menu[] models) {
		MenuSoap[] soapModels = new MenuSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static MenuSoap[][] toSoapModels(Menu[][] models) {
		MenuSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new MenuSoap[models.length][models[0].length];
		}
		else {
			soapModels = new MenuSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static MenuSoap[] toSoapModels(List<Menu> models) {
		List<MenuSoap> soapModels = new ArrayList<MenuSoap>(models.size());

		for (Menu model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new MenuSoap[soapModels.size()]);
	}

	public MenuSoap() {
	}

	public long getPrimaryKey() {
		return _menuId;
	}

	public void setPrimaryKey(long pk) {
		setMenuId(pk);
	}

	public long getMenuId() {
		return _menuId;
	}

	public void setMenuId(long menuId) {
		_menuId = menuId;
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

	public String getMenuName() {
		return _menuName;
	}

	public void setMenuName(String menuName) {
		_menuName = menuName;
	}

	private long _menuId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _menuName;
}