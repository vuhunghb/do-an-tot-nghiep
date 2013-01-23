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

import irestads.model.UVersion;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing UVersion in entity cache.
 *
 * @author Be
 * @see UVersion
 * @generated
 */
public class UVersionCacheModel implements CacheModel<UVersion>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{versionId=");
		sb.append(versionId);
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
		sb.append(", logObjName=");
		sb.append(logObjName);
		sb.append(", logObjId=");
		sb.append(logObjId);
		sb.append(", logType=");
		sb.append(logType);
		sb.append(", logDate=");
		sb.append(logDate);
		sb.append("}");

		return sb.toString();
	}

	public UVersion toEntityModel() {
		UVersionImpl uVersionImpl = new UVersionImpl();

		uVersionImpl.setVersionId(versionId);
		uVersionImpl.setCompanyId(companyId);
		uVersionImpl.setUserId(userId);

		if (userName == null) {
			uVersionImpl.setUserName(StringPool.BLANK);
		}
		else {
			uVersionImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			uVersionImpl.setCreateDate(null);
		}
		else {
			uVersionImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			uVersionImpl.setModifiedDate(null);
		}
		else {
			uVersionImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (logObjName == null) {
			uVersionImpl.setLogObjName(StringPool.BLANK);
		}
		else {
			uVersionImpl.setLogObjName(logObjName);
		}

		uVersionImpl.setLogObjId(logObjId);
		uVersionImpl.setLogType(logType);

		if (logDate == Long.MIN_VALUE) {
			uVersionImpl.setLogDate(null);
		}
		else {
			uVersionImpl.setLogDate(new Date(logDate));
		}

		uVersionImpl.resetOriginalValues();

		return uVersionImpl;
	}

	public long versionId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String logObjName;
	public long logObjId;
	public int logType;
	public long logDate;
}