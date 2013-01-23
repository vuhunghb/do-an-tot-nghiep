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
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import irestads.service.UVersionLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Be
 */
public class UVersionClp extends BaseModelImpl<UVersion> implements UVersion {
	public UVersionClp() {
	}

	public Class<?> getModelClass() {
		return UVersion.class;
	}

	public String getModelClassName() {
		return UVersion.class.getName();
	}

	public long getPrimaryKey() {
		return _versionId;
	}

	public void setPrimaryKey(long primaryKey) {
		setVersionId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_versionId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("versionId", getVersionId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("logObjName", getLogObjName());
		attributes.put("logObjId", getLogObjId());
		attributes.put("logType", getLogType());
		attributes.put("logDate", getLogDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long versionId = (Long)attributes.get("versionId");

		if (versionId != null) {
			setVersionId(versionId);
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

		String logObjName = (String)attributes.get("logObjName");

		if (logObjName != null) {
			setLogObjName(logObjName);
		}

		Long logObjId = (Long)attributes.get("logObjId");

		if (logObjId != null) {
			setLogObjId(logObjId);
		}

		Integer logType = (Integer)attributes.get("logType");

		if (logType != null) {
			setLogType(logType);
		}

		Date logDate = (Date)attributes.get("logDate");

		if (logDate != null) {
			setLogDate(logDate);
		}
	}

	public long getVersionId() {
		return _versionId;
	}

	public void setVersionId(long versionId) {
		_versionId = versionId;
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

	public String getLogObjName() {
		return _logObjName;
	}

	public void setLogObjName(String logObjName) {
		_logObjName = logObjName;
	}

	public long getLogObjId() {
		return _logObjId;
	}

	public void setLogObjId(long logObjId) {
		_logObjId = logObjId;
	}

	public int getLogType() {
		return _logType;
	}

	public void setLogType(int logType) {
		_logType = logType;
	}

	public Date getLogDate() {
		return _logDate;
	}

	public void setLogDate(Date logDate) {
		_logDate = logDate;
	}

	public BaseModel<?> getUVersionRemoteModel() {
		return _uVersionRemoteModel;
	}

	public void setUVersionRemoteModel(BaseModel<?> uVersionRemoteModel) {
		_uVersionRemoteModel = uVersionRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			UVersionLocalServiceUtil.addUVersion(this);
		}
		else {
			UVersionLocalServiceUtil.updateUVersion(this);
		}
	}

	@Override
	public UVersion toEscapedModel() {
		return (UVersion)Proxy.newProxyInstance(UVersion.class.getClassLoader(),
			new Class[] { UVersion.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		UVersionClp clone = new UVersionClp();

		clone.setVersionId(getVersionId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setLogObjName(getLogObjName());
		clone.setLogObjId(getLogObjId());
		clone.setLogType(getLogType());
		clone.setLogDate(getLogDate());

		return clone;
	}

	public int compareTo(UVersion uVersion) {
		int value = 0;

		value = DateUtil.compareTo(getLogDate(), uVersion.getLogDate());

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

		UVersionClp uVersion = null;

		try {
			uVersion = (UVersionClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = uVersion.getPrimaryKey();

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

		sb.append("{versionId=");
		sb.append(getVersionId());
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
		sb.append(", logObjName=");
		sb.append(getLogObjName());
		sb.append(", logObjId=");
		sb.append(getLogObjId());
		sb.append(", logType=");
		sb.append(getLogType());
		sb.append(", logDate=");
		sb.append(getLogDate());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("irestads.model.UVersion");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>versionId</column-name><column-value><![CDATA[");
		sb.append(getVersionId());
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
			"<column><column-name>logObjName</column-name><column-value><![CDATA[");
		sb.append(getLogObjName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>logObjId</column-name><column-value><![CDATA[");
		sb.append(getLogObjId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>logType</column-name><column-value><![CDATA[");
		sb.append(getLogType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>logDate</column-name><column-value><![CDATA[");
		sb.append(getLogDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _versionId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _logObjName;
	private long _logObjId;
	private int _logType;
	private Date _logDate;
	private BaseModel<?> _uVersionRemoteModel;
}