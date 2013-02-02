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

import irestads.service.DishTableLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Be
 */
public class DishTableClp extends BaseModelImpl<DishTable> implements DishTable {
	public DishTableClp() {
	}

	public Class<?> getModelClass() {
		return DishTable.class;
	}

	public String getModelClassName() {
		return DishTable.class.getName();
	}

	public String getPrimaryKey() {
		return _dishTableId;
	}

	public void setPrimaryKey(String primaryKey) {
		setDishTableId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return _dishTableId;
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((String)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("dishTableId", getDishTableId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("tableName", getTableName());
		attributes.put("isAvalable", getIsAvalable());
		attributes.put("numChair", getNumChair());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String dishTableId = (String)attributes.get("dishTableId");

		if (dishTableId != null) {
			setDishTableId(dishTableId);
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

		String tableName = (String)attributes.get("tableName");

		if (tableName != null) {
			setTableName(tableName);
		}

		Boolean isAvalable = (Boolean)attributes.get("isAvalable");

		if (isAvalable != null) {
			setIsAvalable(isAvalable);
		}

		Integer numChair = (Integer)attributes.get("numChair");

		if (numChair != null) {
			setNumChair(numChair);
		}
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

	public BaseModel<?> getDishTableRemoteModel() {
		return _dishTableRemoteModel;
	}

	public void setDishTableRemoteModel(BaseModel<?> dishTableRemoteModel) {
		_dishTableRemoteModel = dishTableRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			DishTableLocalServiceUtil.addDishTable(this);
		}
		else {
			DishTableLocalServiceUtil.updateDishTable(this);
		}
	}

	@Override
	public DishTable toEscapedModel() {
		return (DishTable)Proxy.newProxyInstance(DishTable.class.getClassLoader(),
			new Class[] { DishTable.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		DishTableClp clone = new DishTableClp();

		clone.setDishTableId(getDishTableId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setTableName(getTableName());
		clone.setIsAvalable(getIsAvalable());
		clone.setNumChair(getNumChair());

		return clone;
	}

	public int compareTo(DishTable dishTable) {
		int value = 0;

		if (getIsAvalable() == dishTable.getIsAvalable()) {
			value = -1;
		}
		else if (getIsAvalable() != dishTable.getIsAvalable()) {
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

		DishTableClp dishTable = null;

		try {
			dishTable = (DishTableClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		String primaryKey = dishTable.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{dishTableId=");
		sb.append(getDishTableId());
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
		sb.append(", tableName=");
		sb.append(getTableName());
		sb.append(", isAvalable=");
		sb.append(getIsAvalable());
		sb.append(", numChair=");
		sb.append(getNumChair());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("irestads.model.DishTable");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>dishTableId</column-name><column-value><![CDATA[");
		sb.append(getDishTableId());
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
			"<column><column-name>tableName</column-name><column-value><![CDATA[");
		sb.append(getTableName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isAvalable</column-name><column-value><![CDATA[");
		sb.append(getIsAvalable());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>numChair</column-name><column-value><![CDATA[");
		sb.append(getNumChair());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _dishTableId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _tableName;
	private boolean _isAvalable;
	private int _numChair;
	private BaseModel<?> _dishTableRemoteModel;
}