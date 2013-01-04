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

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import irestads.model.TestEntity;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing TestEntity in entity cache.
 *
 * @author ADMIN
 * @see TestEntity
 * @generated
 */
public class TestEntityCacheModel implements CacheModel<TestEntity>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{entityId=");
		sb.append(entityId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", name=");
		sb.append(name);
		sb.append(", pass=");
		sb.append(pass);
		sb.append(", email=");
		sb.append(email);
		sb.append(", loginDate=");
		sb.append(loginDate);
		sb.append("}");

		return sb.toString();
	}

	public TestEntity toEntityModel() {
		TestEntityImpl testEntityImpl = new TestEntityImpl();

		testEntityImpl.setEntityId(entityId);
		testEntityImpl.setCompanyId(companyId);
		testEntityImpl.setUserId(userId);

		if (userName == null) {
			testEntityImpl.setUserName(StringPool.BLANK);
		}
		else {
			testEntityImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			testEntityImpl.setCreateDate(null);
		}
		else {
			testEntityImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			testEntityImpl.setModifiedDate(null);
		}
		else {
			testEntityImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			testEntityImpl.setName(StringPool.BLANK);
		}
		else {
			testEntityImpl.setName(name);
		}

		if (pass == null) {
			testEntityImpl.setPass(StringPool.BLANK);
		}
		else {
			testEntityImpl.setPass(pass);
		}

		if (email == null) {
			testEntityImpl.setEmail(StringPool.BLANK);
		}
		else {
			testEntityImpl.setEmail(email);
		}

		if (loginDate == Long.MIN_VALUE) {
			testEntityImpl.setLoginDate(null);
		}
		else {
			testEntityImpl.setLoginDate(new Date(loginDate));
		}

		testEntityImpl.resetOriginalValues();

		return testEntityImpl;
	}

	public long entityId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String name;
	public String pass;
	public String email;
	public long loginDate;
}