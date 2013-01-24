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
 * This class is used by SOAP remote services, specifically {@link irestads.service.http.UVersionServiceSoap}.
 *
 * @author    Be
 * @see       irestads.service.http.UVersionServiceSoap
 * @generated
 */
public class UVersionSoap implements Serializable {
	public static UVersionSoap toSoapModel(UVersion model) {
		UVersionSoap soapModel = new UVersionSoap();

		soapModel.setVersionId(model.getVersionId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setLogObjName(model.getLogObjName());
		soapModel.setLogObjId(model.getLogObjId());
		soapModel.setLogType(model.getLogType());
		soapModel.setLogDate(model.getLogDate());

		return soapModel;
	}

	public static UVersionSoap[] toSoapModels(UVersion[] models) {
		UVersionSoap[] soapModels = new UVersionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static UVersionSoap[][] toSoapModels(UVersion[][] models) {
		UVersionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new UVersionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new UVersionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static UVersionSoap[] toSoapModels(List<UVersion> models) {
		List<UVersionSoap> soapModels = new ArrayList<UVersionSoap>(models.size());

		for (UVersion model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new UVersionSoap[soapModels.size()]);
	}

	public UVersionSoap() {
	}

	public long getPrimaryKey() {
		return _versionId;
	}

	public void setPrimaryKey(long pk) {
		setVersionId(pk);
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

	public String getLogType() {
		return _logType;
	}

	public void setLogType(String logType) {
		_logType = logType;
	}

	public Date getLogDate() {
		return _logDate;
	}

	public void setLogDate(Date logDate) {
		_logDate = logDate;
	}

	private long _versionId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _logObjName;
	private long _logObjId;
	private String _logType;
	private Date _logDate;
}