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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.AuditedModel;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the UVersion service. Represents a row in the &quot;dishsstore_UVersion&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link irestads.model.impl.UVersionModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link irestads.model.impl.UVersionImpl}.
 * </p>
 *
 * @author Be
 * @see UVersion
 * @see irestads.model.impl.UVersionImpl
 * @see irestads.model.impl.UVersionModelImpl
 * @generated
 */
public interface UVersionModel extends AuditedModel, BaseModel<UVersion> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a u version model instance should use the {@link UVersion} interface instead.
	 */

	/**
	 * Returns the primary key of this u version.
	 *
	 * @return the primary key of this u version
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this u version.
	 *
	 * @param primaryKey the primary key of this u version
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the version ID of this u version.
	 *
	 * @return the version ID of this u version
	 */
	public long getVersionId();

	/**
	 * Sets the version ID of this u version.
	 *
	 * @param versionId the version ID of this u version
	 */
	public void setVersionId(long versionId);

	/**
	 * Returns the company ID of this u version.
	 *
	 * @return the company ID of this u version
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this u version.
	 *
	 * @param companyId the company ID of this u version
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this u version.
	 *
	 * @return the user ID of this u version
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this u version.
	 *
	 * @param userId the user ID of this u version
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this u version.
	 *
	 * @return the user uuid of this u version
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this u version.
	 *
	 * @param userUuid the user uuid of this u version
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this u version.
	 *
	 * @return the user name of this u version
	 */
	@AutoEscape
	public String getUserName();

	/**
	 * Sets the user name of this u version.
	 *
	 * @param userName the user name of this u version
	 */
	public void setUserName(String userName);

	/**
	 * Returns the create date of this u version.
	 *
	 * @return the create date of this u version
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this u version.
	 *
	 * @param createDate the create date of this u version
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this u version.
	 *
	 * @return the modified date of this u version
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this u version.
	 *
	 * @param modifiedDate the modified date of this u version
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the log obj name of this u version.
	 *
	 * @return the log obj name of this u version
	 */
	@AutoEscape
	public String getLogObjName();

	/**
	 * Sets the log obj name of this u version.
	 *
	 * @param logObjName the log obj name of this u version
	 */
	public void setLogObjName(String logObjName);

	/**
	 * Returns the log obj ID of this u version.
	 *
	 * @return the log obj ID of this u version
	 */
	public long getLogObjId();

	/**
	 * Sets the log obj ID of this u version.
	 *
	 * @param logObjId the log obj ID of this u version
	 */
	public void setLogObjId(long logObjId);

	/**
	 * Returns the log type of this u version.
	 *
	 * @return the log type of this u version
	 */
	@AutoEscape
	public String getLogType();

	/**
	 * Sets the log type of this u version.
	 *
	 * @param logType the log type of this u version
	 */
	public void setLogType(String logType);

	/**
	 * Returns the log date of this u version.
	 *
	 * @return the log date of this u version
	 */
	public Date getLogDate();

	/**
	 * Sets the log date of this u version.
	 *
	 * @param logDate the log date of this u version
	 */
	public void setLogDate(Date logDate);

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public Serializable getPrimaryKeyObj();

	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(UVersion uVersion);

	public int hashCode();

	public CacheModel<UVersion> toCacheModel();

	public UVersion toEscapedModel();

	public String toString();

	public String toXmlString();
}