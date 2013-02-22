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

import irestads.model.TestEntity;
import irestads.model.TestEntityModel;
import irestads.model.TestEntitySoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the TestEntity service. Represents a row in the &quot;testws_TestEntity&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link irestads.model.TestEntityModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link TestEntityImpl}.
 * </p>
 *
 * @author ADMIN
 * @see TestEntityImpl
 * @see irestads.model.TestEntity
 * @see irestads.model.TestEntityModel
 * @generated
 */
@JSON(strict = true)
public class TestEntityModelImpl extends BaseModelImpl<TestEntity>
	implements TestEntityModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a test entity model instance should use the {@link irestads.model.TestEntity} interface instead.
	 */
	public static final String TABLE_NAME = "testws_TestEntity";
	public static final Object[][] TABLE_COLUMNS = {
			{ "entityId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "name", Types.VARCHAR },
			{ "pass", Types.VARCHAR },
			{ "email", Types.VARCHAR },
			{ "loginDate", Types.TIMESTAMP }
		};
	public static final String TABLE_SQL_CREATE = "create table testws_TestEntity (entityId LONG not null primary key,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,name VARCHAR(75) null,pass VARCHAR(75) null,email VARCHAR(75) null,loginDate DATE null)";
	public static final String TABLE_SQL_DROP = "drop table testws_TestEntity";
	public static final String ORDER_BY_JPQL = " ORDER BY testEntity.name ASC";
	public static final String ORDER_BY_SQL = " ORDER BY testws_TestEntity.name ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.irestads.model.TestEntity"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.irestads.model.TestEntity"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.irestads.model.TestEntity"),
			true);
	public static long NAME_COLUMN_BITMASK = 1L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static TestEntity toModel(TestEntitySoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		TestEntity model = new TestEntityImpl();

		model.setEntityId(soapModel.getEntityId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setName(soapModel.getName());
		model.setPass(soapModel.getPass());
		model.setEmail(soapModel.getEmail());
		model.setLoginDate(soapModel.getLoginDate());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<TestEntity> toModels(TestEntitySoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<TestEntity> models = new ArrayList<TestEntity>(soapModels.length);

		for (TestEntitySoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.irestads.model.TestEntity"));

	public TestEntityModelImpl() {
	}

	public long getPrimaryKey() {
		return _entityId;
	}

	public void setPrimaryKey(long primaryKey) {
		setEntityId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_entityId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public Class<?> getModelClass() {
		return TestEntity.class;
	}

	public String getModelClassName() {
		return TestEntity.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("entityId", getEntityId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("pass", getPass());
		attributes.put("email", getEmail());
		attributes.put("loginDate", getLoginDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long entityId = (Long)attributes.get("entityId");

		if (entityId != null) {
			setEntityId(entityId);
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

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String pass = (String)attributes.get("pass");

		if (pass != null) {
			setPass(pass);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		Date loginDate = (Date)attributes.get("loginDate");

		if (loginDate != null) {
			setLoginDate(loginDate);
		}
	}

	@JSON
	public long getEntityId() {
		return _entityId;
	}

	public void setEntityId(long entityId) {
		_entityId = entityId;
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
	public String getName() {
		if (_name == null) {
			return StringPool.BLANK;
		}
		else {
			return _name;
		}
	}

	public void setName(String name) {
		_columnBitmask = -1L;

		if (_originalName == null) {
			_originalName = _name;
		}

		_name = name;
	}

	public String getOriginalName() {
		return GetterUtil.getString(_originalName);
	}

	@JSON
	public String getPass() {
		if (_pass == null) {
			return StringPool.BLANK;
		}
		else {
			return _pass;
		}
	}

	public void setPass(String pass) {
		_pass = pass;
	}

	@JSON
	public String getEmail() {
		if (_email == null) {
			return StringPool.BLANK;
		}
		else {
			return _email;
		}
	}

	public void setEmail(String email) {
		_email = email;
	}

	@JSON
	public Date getLoginDate() {
		return _loginDate;
	}

	public void setLoginDate(Date loginDate) {
		_loginDate = loginDate;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			TestEntity.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public TestEntity toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (TestEntity)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public Object clone() {
		TestEntityImpl testEntityImpl = new TestEntityImpl();

		testEntityImpl.setEntityId(getEntityId());
		testEntityImpl.setCompanyId(getCompanyId());
		testEntityImpl.setUserId(getUserId());
		testEntityImpl.setUserName(getUserName());
		testEntityImpl.setCreateDate(getCreateDate());
		testEntityImpl.setModifiedDate(getModifiedDate());
		testEntityImpl.setName(getName());
		testEntityImpl.setPass(getPass());
		testEntityImpl.setEmail(getEmail());
		testEntityImpl.setLoginDate(getLoginDate());

		testEntityImpl.resetOriginalValues();

		return testEntityImpl;
	}

	public int compareTo(TestEntity testEntity) {
		int value = 0;

		value = getName().compareTo(testEntity.getName());

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

		TestEntity testEntity = null;

		try {
			testEntity = (TestEntity)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = testEntity.getPrimaryKey();

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
		TestEntityModelImpl testEntityModelImpl = this;

		testEntityModelImpl._originalName = testEntityModelImpl._name;

		testEntityModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<TestEntity> toCacheModel() {
		TestEntityCacheModel testEntityCacheModel = new TestEntityCacheModel();

		testEntityCacheModel.entityId = getEntityId();

		testEntityCacheModel.companyId = getCompanyId();

		testEntityCacheModel.userId = getUserId();

		testEntityCacheModel.userName = getUserName();

		String userName = testEntityCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			testEntityCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			testEntityCacheModel.createDate = createDate.getTime();
		}
		else {
			testEntityCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			testEntityCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			testEntityCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		testEntityCacheModel.name = getName();

		String name = testEntityCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			testEntityCacheModel.name = null;
		}

		testEntityCacheModel.pass = getPass();

		String pass = testEntityCacheModel.pass;

		if ((pass != null) && (pass.length() == 0)) {
			testEntityCacheModel.pass = null;
		}

		testEntityCacheModel.email = getEmail();

		String email = testEntityCacheModel.email;

		if ((email != null) && (email.length() == 0)) {
			testEntityCacheModel.email = null;
		}

		Date loginDate = getLoginDate();

		if (loginDate != null) {
			testEntityCacheModel.loginDate = loginDate.getTime();
		}
		else {
			testEntityCacheModel.loginDate = Long.MIN_VALUE;
		}

		return testEntityCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{entityId=");
		sb.append(getEntityId());
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
		sb.append(", name=");
		sb.append(getName());
		sb.append(", pass=");
		sb.append(getPass());
		sb.append(", email=");
		sb.append(getEmail());
		sb.append(", loginDate=");
		sb.append(getLoginDate());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("irestads.model.TestEntity");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>entityId</column-name><column-value><![CDATA[");
		sb.append(getEntityId());
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
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pass</column-name><column-value><![CDATA[");
		sb.append(getPass());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>email</column-name><column-value><![CDATA[");
		sb.append(getEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>loginDate</column-name><column-value><![CDATA[");
		sb.append(getLoginDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = TestEntity.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			TestEntity.class
		};
	private long _entityId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _name;
	private String _originalName;
	private String _pass;
	private String _email;
	private Date _loginDate;
	private long _columnBitmask;
	private TestEntity _escapedModelProxy;
}