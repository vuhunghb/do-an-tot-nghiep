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
import com.liferay.portal.kernel.util.DateUtil;
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

import irestads.model.UVersion;
import irestads.model.UVersionModel;
import irestads.model.UVersionSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the UVersion service. Represents a row in the &quot;dishsstore_UVersion&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link irestads.model.UVersionModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link UVersionImpl}.
 * </p>
 *
 * @author Be
 * @see UVersionImpl
 * @see irestads.model.UVersion
 * @see irestads.model.UVersionModel
 * @generated
 */
@JSON(strict = true)
public class UVersionModelImpl extends BaseModelImpl<UVersion>
	implements UVersionModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a u version model instance should use the {@link irestads.model.UVersion} interface instead.
	 */
	public static final String TABLE_NAME = "dishsstore_UVersion";
	public static final Object[][] TABLE_COLUMNS = {
			{ "versionId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "logObjName", Types.VARCHAR },
			{ "logObjId", Types.BIGINT },
			{ "logType", Types.VARCHAR },
			{ "logDate", Types.TIMESTAMP }
		};
	public static final String TABLE_SQL_CREATE = "create table dishsstore_UVersion (versionId LONG not null primary key,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,logObjName VARCHAR(75) null,logObjId LONG,logType VARCHAR(75) null,logDate DATE null)";
	public static final String TABLE_SQL_DROP = "drop table dishsstore_UVersion";
	public static final String ORDER_BY_JPQL = " ORDER BY uVersion.logDate ASC";
	public static final String ORDER_BY_SQL = " ORDER BY dishsstore_UVersion.logDate ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.irestads.model.UVersion"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.irestads.model.UVersion"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.irestads.model.UVersion"),
			true);
	public static long LOGDATE_COLUMN_BITMASK = 1L;
	public static long LOGOBJID_COLUMN_BITMASK = 2L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static UVersion toModel(UVersionSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		UVersion model = new UVersionImpl();

		model.setVersionId(soapModel.getVersionId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setLogObjName(soapModel.getLogObjName());
		model.setLogObjId(soapModel.getLogObjId());
		model.setLogType(soapModel.getLogType());
		model.setLogDate(soapModel.getLogDate());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<UVersion> toModels(UVersionSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<UVersion> models = new ArrayList<UVersion>(soapModels.length);

		for (UVersionSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.irestads.model.UVersion"));

	public UVersionModelImpl() {
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

	public Class<?> getModelClass() {
		return UVersion.class;
	}

	public String getModelClassName() {
		return UVersion.class.getName();
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

		String logType = (String)attributes.get("logType");

		if (logType != null) {
			setLogType(logType);
		}

		Date logDate = (Date)attributes.get("logDate");

		if (logDate != null) {
			setLogDate(logDate);
		}
	}

	@JSON
	public long getVersionId() {
		return _versionId;
	}

	public void setVersionId(long versionId) {
		_versionId = versionId;
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
	public String getLogObjName() {
		if (_logObjName == null) {
			return StringPool.BLANK;
		}
		else {
			return _logObjName;
		}
	}

	public void setLogObjName(String logObjName) {
		_logObjName = logObjName;
	}

	@JSON
	public long getLogObjId() {
		return _logObjId;
	}

	public void setLogObjId(long logObjId) {
		_columnBitmask |= LOGOBJID_COLUMN_BITMASK;

		if (!_setOriginalLogObjId) {
			_setOriginalLogObjId = true;

			_originalLogObjId = _logObjId;
		}

		_logObjId = logObjId;
	}

	public long getOriginalLogObjId() {
		return _originalLogObjId;
	}

	@JSON
	public String getLogType() {
		if (_logType == null) {
			return StringPool.BLANK;
		}
		else {
			return _logType;
		}
	}

	public void setLogType(String logType) {
		_logType = logType;
	}

	@JSON
	public Date getLogDate() {
		return _logDate;
	}

	public void setLogDate(Date logDate) {
		_columnBitmask = -1L;

		if (_originalLogDate == null) {
			_originalLogDate = _logDate;
		}

		_logDate = logDate;
	}

	public Date getOriginalLogDate() {
		return _originalLogDate;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			UVersion.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public UVersion toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (UVersion)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public Object clone() {
		UVersionImpl uVersionImpl = new UVersionImpl();

		uVersionImpl.setVersionId(getVersionId());
		uVersionImpl.setCompanyId(getCompanyId());
		uVersionImpl.setUserId(getUserId());
		uVersionImpl.setUserName(getUserName());
		uVersionImpl.setCreateDate(getCreateDate());
		uVersionImpl.setModifiedDate(getModifiedDate());
		uVersionImpl.setLogObjName(getLogObjName());
		uVersionImpl.setLogObjId(getLogObjId());
		uVersionImpl.setLogType(getLogType());
		uVersionImpl.setLogDate(getLogDate());

		uVersionImpl.resetOriginalValues();

		return uVersionImpl;
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

		UVersion uVersion = null;

		try {
			uVersion = (UVersion)obj;
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
	public void resetOriginalValues() {
		UVersionModelImpl uVersionModelImpl = this;

		uVersionModelImpl._originalLogObjId = uVersionModelImpl._logObjId;

		uVersionModelImpl._setOriginalLogObjId = false;

		uVersionModelImpl._originalLogDate = uVersionModelImpl._logDate;

		uVersionModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<UVersion> toCacheModel() {
		UVersionCacheModel uVersionCacheModel = new UVersionCacheModel();

		uVersionCacheModel.versionId = getVersionId();

		uVersionCacheModel.companyId = getCompanyId();

		uVersionCacheModel.userId = getUserId();

		uVersionCacheModel.userName = getUserName();

		String userName = uVersionCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			uVersionCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			uVersionCacheModel.createDate = createDate.getTime();
		}
		else {
			uVersionCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			uVersionCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			uVersionCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		uVersionCacheModel.logObjName = getLogObjName();

		String logObjName = uVersionCacheModel.logObjName;

		if ((logObjName != null) && (logObjName.length() == 0)) {
			uVersionCacheModel.logObjName = null;
		}

		uVersionCacheModel.logObjId = getLogObjId();

		uVersionCacheModel.logType = getLogType();

		String logType = uVersionCacheModel.logType;

		if ((logType != null) && (logType.length() == 0)) {
			uVersionCacheModel.logType = null;
		}

		Date logDate = getLogDate();

		if (logDate != null) {
			uVersionCacheModel.logDate = logDate.getTime();
		}
		else {
			uVersionCacheModel.logDate = Long.MIN_VALUE;
		}

		return uVersionCacheModel;
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

	private static ClassLoader _classLoader = UVersion.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			UVersion.class
		};
	private long _versionId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _logObjName;
	private long _logObjId;
	private long _originalLogObjId;
	private boolean _setOriginalLogObjId;
	private String _logType;
	private Date _logDate;
	private Date _originalLogDate;
	private long _columnBitmask;
	private UVersion _escapedModelProxy;
}