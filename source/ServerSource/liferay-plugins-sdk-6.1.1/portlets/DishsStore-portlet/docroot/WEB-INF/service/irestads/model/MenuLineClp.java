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

import irestads.service.MenuLineLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Be
 */
public class MenuLineClp extends BaseModelImpl<MenuLine> implements MenuLine {
	public MenuLineClp() {
	}

	public Class<?> getModelClass() {
		return MenuLine.class;
	}

	public String getModelClassName() {
		return MenuLine.class.getName();
	}

	public long getPrimaryKey() {
		return _menuLineId;
	}

	public void setPrimaryKey(long primaryKey) {
		setMenuLineId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_menuLineId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("menuLineId", getMenuLineId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("numOfDish", getNumOfDish());
		attributes.put("capacity", getCapacity());
		attributes.put("status", getStatus());
		attributes.put("dishId", getDishId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long menuLineId = (Long)attributes.get("menuLineId");

		if (menuLineId != null) {
			setMenuLineId(menuLineId);
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

		Integer capacity = (Integer)attributes.get("capacity");

		if (capacity != null) {
			setCapacity(capacity);
		}

		Boolean status = (Boolean)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long dishId = (Long)attributes.get("dishId");

		if (dishId != null) {
			setDishId(dishId);
		}
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

	public void setDish(irestads.model.DishModel dish) {
		throw new UnsupportedOperationException();
	}

	public irestads.model.DishModel getDish() {
		throw new UnsupportedOperationException();
	}

	public BaseModel<?> getMenuLineRemoteModel() {
		return _menuLineRemoteModel;
	}

	public void setMenuLineRemoteModel(BaseModel<?> menuLineRemoteModel) {
		_menuLineRemoteModel = menuLineRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			MenuLineLocalServiceUtil.addMenuLine(this);
		}
		else {
			MenuLineLocalServiceUtil.updateMenuLine(this);
		}
	}

	@Override
	public MenuLine toEscapedModel() {
		return (MenuLine)Proxy.newProxyInstance(MenuLine.class.getClassLoader(),
			new Class[] { MenuLine.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		MenuLineClp clone = new MenuLineClp();

		clone.setMenuLineId(getMenuLineId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setNumOfDish(getNumOfDish());
		clone.setCapacity(getCapacity());
		clone.setStatus(getStatus());
		clone.setDishId(getDishId());

		return clone;
	}

	public int compareTo(MenuLine menuLine) {
		int value = 0;

		if (getMenuLineId() < menuLine.getMenuLineId()) {
			value = -1;
		}
		else if (getMenuLineId() > menuLine.getMenuLineId()) {
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

		MenuLineClp menuLine = null;

		try {
			menuLine = (MenuLineClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = menuLine.getPrimaryKey();

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
		StringBundler sb = new StringBundler(21);

		sb.append("{menuLineId=");
		sb.append(getMenuLineId());
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
		sb.append(", capacity=");
		sb.append(getCapacity());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", dishId=");
		sb.append(getDishId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("irestads.model.MenuLine");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>menuLineId</column-name><column-value><![CDATA[");
		sb.append(getMenuLineId());
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
			"<column><column-name>capacity</column-name><column-value><![CDATA[");
		sb.append(getCapacity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dishId</column-name><column-value><![CDATA[");
		sb.append(getDishId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _menuLineId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private int _numOfDish;
	private int _capacity;
	private boolean _status;
	private long _dishId;
	private BaseModel<?> _menuLineRemoteModel;
}