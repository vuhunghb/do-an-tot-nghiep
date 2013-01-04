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
 * This class is used by SOAP remote services, specifically {@link irestads.service.http.TestEntityServiceSoap}.
 *
 * @author    ADMIN
 * @see       irestads.service.http.TestEntityServiceSoap
 * @generated
 */
public class TestEntitySoap implements Serializable {
	public static TestEntitySoap toSoapModel(TestEntity model) {
		TestEntitySoap soapModel = new TestEntitySoap();

		soapModel.setEntityId(model.getEntityId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setName(model.getName());
		soapModel.setPass(model.getPass());
		soapModel.setEmail(model.getEmail());
		soapModel.setLoginDate(model.getLoginDate());

		return soapModel;
	}

	public static TestEntitySoap[] toSoapModels(TestEntity[] models) {
		TestEntitySoap[] soapModels = new TestEntitySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TestEntitySoap[][] toSoapModels(TestEntity[][] models) {
		TestEntitySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TestEntitySoap[models.length][models[0].length];
		}
		else {
			soapModels = new TestEntitySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TestEntitySoap[] toSoapModels(List<TestEntity> models) {
		List<TestEntitySoap> soapModels = new ArrayList<TestEntitySoap>(models.size());

		for (TestEntity model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TestEntitySoap[soapModels.size()]);
	}

	public TestEntitySoap() {
	}

	public long getPrimaryKey() {
		return _entityId;
	}

	public void setPrimaryKey(long pk) {
		setEntityId(pk);
	}

	public long getEntityId() {
		return _entityId;
	}

	public void setEntityId(long entityId) {
		_entityId = entityId;
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

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getPass() {
		return _pass;
	}

	public void setPass(String pass) {
		_pass = pass;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public Date getLoginDate() {
		return _loginDate;
	}

	public void setLoginDate(Date loginDate) {
		_loginDate = loginDate;
	}

	private long _entityId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _name;
	private String _pass;
	private String _email;
	private Date _loginDate;
}