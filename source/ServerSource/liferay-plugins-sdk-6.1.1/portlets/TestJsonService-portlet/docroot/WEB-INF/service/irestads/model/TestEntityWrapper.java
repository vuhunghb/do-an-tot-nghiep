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
 * This class is a wrapper for {@link TestEntity}.
 * </p>
 *
 * @author    ADMIN
 * @see       TestEntity
 * @generated
 */
public class TestEntityWrapper implements TestEntity, ModelWrapper<TestEntity> {
	public TestEntityWrapper(TestEntity testEntity) {
		_testEntity = testEntity;
	}

	public Class<?> getModelClass() {
		return TestEntity.class;
	}

	public String getModelClassName() {
		return TestEntity.class.getName();
	}

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

	/**
	* Returns the primary key of this test entity.
	*
	* @return the primary key of this test entity
	*/
	public long getPrimaryKey() {
		return _testEntity.getPrimaryKey();
	}

	/**
	* Sets the primary key of this test entity.
	*
	* @param primaryKey the primary key of this test entity
	*/
	public void setPrimaryKey(long primaryKey) {
		_testEntity.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the entity ID of this test entity.
	*
	* @return the entity ID of this test entity
	*/
	public long getEntityId() {
		return _testEntity.getEntityId();
	}

	/**
	* Sets the entity ID of this test entity.
	*
	* @param entityId the entity ID of this test entity
	*/
	public void setEntityId(long entityId) {
		_testEntity.setEntityId(entityId);
	}

	/**
	* Returns the company ID of this test entity.
	*
	* @return the company ID of this test entity
	*/
	public long getCompanyId() {
		return _testEntity.getCompanyId();
	}

	/**
	* Sets the company ID of this test entity.
	*
	* @param companyId the company ID of this test entity
	*/
	public void setCompanyId(long companyId) {
		_testEntity.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this test entity.
	*
	* @return the user ID of this test entity
	*/
	public long getUserId() {
		return _testEntity.getUserId();
	}

	/**
	* Sets the user ID of this test entity.
	*
	* @param userId the user ID of this test entity
	*/
	public void setUserId(long userId) {
		_testEntity.setUserId(userId);
	}

	/**
	* Returns the user uuid of this test entity.
	*
	* @return the user uuid of this test entity
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _testEntity.getUserUuid();
	}

	/**
	* Sets the user uuid of this test entity.
	*
	* @param userUuid the user uuid of this test entity
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_testEntity.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this test entity.
	*
	* @return the user name of this test entity
	*/
	public java.lang.String getUserName() {
		return _testEntity.getUserName();
	}

	/**
	* Sets the user name of this test entity.
	*
	* @param userName the user name of this test entity
	*/
	public void setUserName(java.lang.String userName) {
		_testEntity.setUserName(userName);
	}

	/**
	* Returns the create date of this test entity.
	*
	* @return the create date of this test entity
	*/
	public java.util.Date getCreateDate() {
		return _testEntity.getCreateDate();
	}

	/**
	* Sets the create date of this test entity.
	*
	* @param createDate the create date of this test entity
	*/
	public void setCreateDate(java.util.Date createDate) {
		_testEntity.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this test entity.
	*
	* @return the modified date of this test entity
	*/
	public java.util.Date getModifiedDate() {
		return _testEntity.getModifiedDate();
	}

	/**
	* Sets the modified date of this test entity.
	*
	* @param modifiedDate the modified date of this test entity
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_testEntity.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the name of this test entity.
	*
	* @return the name of this test entity
	*/
	public java.lang.String getName() {
		return _testEntity.getName();
	}

	/**
	* Sets the name of this test entity.
	*
	* @param name the name of this test entity
	*/
	public void setName(java.lang.String name) {
		_testEntity.setName(name);
	}

	/**
	* Returns the pass of this test entity.
	*
	* @return the pass of this test entity
	*/
	public java.lang.String getPass() {
		return _testEntity.getPass();
	}

	/**
	* Sets the pass of this test entity.
	*
	* @param pass the pass of this test entity
	*/
	public void setPass(java.lang.String pass) {
		_testEntity.setPass(pass);
	}

	/**
	* Returns the email of this test entity.
	*
	* @return the email of this test entity
	*/
	public java.lang.String getEmail() {
		return _testEntity.getEmail();
	}

	/**
	* Sets the email of this test entity.
	*
	* @param email the email of this test entity
	*/
	public void setEmail(java.lang.String email) {
		_testEntity.setEmail(email);
	}

	/**
	* Returns the login date of this test entity.
	*
	* @return the login date of this test entity
	*/
	public java.util.Date getLoginDate() {
		return _testEntity.getLoginDate();
	}

	/**
	* Sets the login date of this test entity.
	*
	* @param loginDate the login date of this test entity
	*/
	public void setLoginDate(java.util.Date loginDate) {
		_testEntity.setLoginDate(loginDate);
	}

	public boolean isNew() {
		return _testEntity.isNew();
	}

	public void setNew(boolean n) {
		_testEntity.setNew(n);
	}

	public boolean isCachedModel() {
		return _testEntity.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_testEntity.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _testEntity.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _testEntity.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_testEntity.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _testEntity.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_testEntity.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new TestEntityWrapper((TestEntity)_testEntity.clone());
	}

	public int compareTo(irestads.model.TestEntity testEntity) {
		return _testEntity.compareTo(testEntity);
	}

	@Override
	public int hashCode() {
		return _testEntity.hashCode();
	}

	public com.liferay.portal.model.CacheModel<irestads.model.TestEntity> toCacheModel() {
		return _testEntity.toCacheModel();
	}

	public irestads.model.TestEntity toEscapedModel() {
		return new TestEntityWrapper(_testEntity.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _testEntity.toString();
	}

	public java.lang.String toXmlString() {
		return _testEntity.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_testEntity.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public TestEntity getWrappedTestEntity() {
		return _testEntity;
	}

	public TestEntity getWrappedModel() {
		return _testEntity;
	}

	public void resetOriginalValues() {
		_testEntity.resetOriginalValues();
	}

	private TestEntity _testEntity;
}