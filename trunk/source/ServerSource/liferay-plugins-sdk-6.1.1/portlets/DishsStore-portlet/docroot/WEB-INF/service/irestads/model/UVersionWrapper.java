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

import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link UVersion}.
 * </p>
 *
 * @author    Be
 * @see       UVersion
 * @generated
 */
public class UVersionWrapper implements UVersion, ModelWrapper<UVersion> {
	public UVersionWrapper(UVersion uVersion) {
		_uVersion = uVersion;
	}

	public Class<?> getModelClass() {
		return UVersion.class;
	}

	public String getModelClassName() {
		return UVersion.class.getName();
	}

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

	/**
	* Returns the primary key of this u version.
	*
	* @return the primary key of this u version
	*/
	public long getPrimaryKey() {
		return _uVersion.getPrimaryKey();
	}

	/**
	* Sets the primary key of this u version.
	*
	* @param primaryKey the primary key of this u version
	*/
	public void setPrimaryKey(long primaryKey) {
		_uVersion.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the version ID of this u version.
	*
	* @return the version ID of this u version
	*/
	public long getVersionId() {
		return _uVersion.getVersionId();
	}

	/**
	* Sets the version ID of this u version.
	*
	* @param versionId the version ID of this u version
	*/
	public void setVersionId(long versionId) {
		_uVersion.setVersionId(versionId);
	}

	/**
	* Returns the company ID of this u version.
	*
	* @return the company ID of this u version
	*/
	public long getCompanyId() {
		return _uVersion.getCompanyId();
	}

	/**
	* Sets the company ID of this u version.
	*
	* @param companyId the company ID of this u version
	*/
	public void setCompanyId(long companyId) {
		_uVersion.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this u version.
	*
	* @return the user ID of this u version
	*/
	public long getUserId() {
		return _uVersion.getUserId();
	}

	/**
	* Sets the user ID of this u version.
	*
	* @param userId the user ID of this u version
	*/
	public void setUserId(long userId) {
		_uVersion.setUserId(userId);
	}

	/**
	* Returns the user uuid of this u version.
	*
	* @return the user uuid of this u version
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _uVersion.getUserUuid();
	}

	/**
	* Sets the user uuid of this u version.
	*
	* @param userUuid the user uuid of this u version
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_uVersion.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this u version.
	*
	* @return the user name of this u version
	*/
	public java.lang.String getUserName() {
		return _uVersion.getUserName();
	}

	/**
	* Sets the user name of this u version.
	*
	* @param userName the user name of this u version
	*/
	public void setUserName(java.lang.String userName) {
		_uVersion.setUserName(userName);
	}

	/**
	* Returns the create date of this u version.
	*
	* @return the create date of this u version
	*/
	public java.util.Date getCreateDate() {
		return _uVersion.getCreateDate();
	}

	/**
	* Sets the create date of this u version.
	*
	* @param createDate the create date of this u version
	*/
	public void setCreateDate(java.util.Date createDate) {
		_uVersion.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this u version.
	*
	* @return the modified date of this u version
	*/
	public java.util.Date getModifiedDate() {
		return _uVersion.getModifiedDate();
	}

	/**
	* Sets the modified date of this u version.
	*
	* @param modifiedDate the modified date of this u version
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_uVersion.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the log obj name of this u version.
	*
	* @return the log obj name of this u version
	*/
	public java.lang.String getLogObjName() {
		return _uVersion.getLogObjName();
	}

	/**
	* Sets the log obj name of this u version.
	*
	* @param logObjName the log obj name of this u version
	*/
	public void setLogObjName(java.lang.String logObjName) {
		_uVersion.setLogObjName(logObjName);
	}

	/**
	* Returns the log obj ID of this u version.
	*
	* @return the log obj ID of this u version
	*/
	public long getLogObjId() {
		return _uVersion.getLogObjId();
	}

	/**
	* Sets the log obj ID of this u version.
	*
	* @param logObjId the log obj ID of this u version
	*/
	public void setLogObjId(long logObjId) {
		_uVersion.setLogObjId(logObjId);
	}

	/**
	* Returns the log type of this u version.
	*
	* @return the log type of this u version
	*/
	public int getLogType() {
		return _uVersion.getLogType();
	}

	/**
	* Sets the log type of this u version.
	*
	* @param logType the log type of this u version
	*/
	public void setLogType(int logType) {
		_uVersion.setLogType(logType);
	}

	/**
	* Returns the log date of this u version.
	*
	* @return the log date of this u version
	*/
	public java.util.Date getLogDate() {
		return _uVersion.getLogDate();
	}

	/**
	* Sets the log date of this u version.
	*
	* @param logDate the log date of this u version
	*/
	public void setLogDate(java.util.Date logDate) {
		_uVersion.setLogDate(logDate);
	}

	public boolean isNew() {
		return _uVersion.isNew();
	}

	public void setNew(boolean n) {
		_uVersion.setNew(n);
	}

	public boolean isCachedModel() {
		return _uVersion.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_uVersion.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _uVersion.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _uVersion.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_uVersion.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _uVersion.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_uVersion.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new UVersionWrapper((UVersion)_uVersion.clone());
	}

	public int compareTo(irestads.model.UVersion uVersion) {
		return _uVersion.compareTo(uVersion);
	}

	@Override
	public int hashCode() {
		return _uVersion.hashCode();
	}

	public com.liferay.portal.model.CacheModel<irestads.model.UVersion> toCacheModel() {
		return _uVersion.toCacheModel();
	}

	public irestads.model.UVersion toEscapedModel() {
		return new UVersionWrapper(_uVersion.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _uVersion.toString();
	}

	public java.lang.String toXmlString() {
		return _uVersion.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_uVersion.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public UVersion getWrappedUVersion() {
		return _uVersion;
	}

	public UVersion getWrappedModel() {
		return _uVersion;
	}

	public void resetOriginalValues() {
		_uVersion.resetOriginalValues();
	}

	private UVersion _uVersion;
}