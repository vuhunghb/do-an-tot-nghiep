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
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import irestads.service.CategoryAdsLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Be
 */
public class CategoryAdsClp extends BaseModelImpl<CategoryAds>
	implements CategoryAds {
	public CategoryAdsClp() {
	}

	public Class<?> getModelClass() {
		return CategoryAds.class;
	}

	public String getModelClassName() {
		return CategoryAds.class.getName();
	}

	public long getPrimaryKey() {
		return _categoryAdsId;
	}

	public void setPrimaryKey(long primaryKey) {
		setCategoryAdsId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_categoryAdsId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("categoryAdsId", getCategoryAdsId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("categoryAdsName", getCategoryAdsName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long categoryAdsId = (Long)attributes.get("categoryAdsId");

		if (categoryAdsId != null) {
			setCategoryAdsId(categoryAdsId);
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

		String categoryAdsName = (String)attributes.get("categoryAdsName");

		if (categoryAdsName != null) {
			setCategoryAdsName(categoryAdsName);
		}
	}

	public long getCategoryAdsId() {
		return _categoryAdsId;
	}

	public void setCategoryAdsId(long categoryAdsId) {
		_categoryAdsId = categoryAdsId;
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

	public String getCategoryAdsName() {
		return _categoryAdsName;
	}

	public void setCategoryAdsName(String categoryAdsName) {
		_categoryAdsName = categoryAdsName;
	}

	public BaseModel<?> getCategoryAdsRemoteModel() {
		return _categoryAdsRemoteModel;
	}

	public void setCategoryAdsRemoteModel(BaseModel<?> categoryAdsRemoteModel) {
		_categoryAdsRemoteModel = categoryAdsRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			CategoryAdsLocalServiceUtil.addCategoryAds(this);
		}
		else {
			CategoryAdsLocalServiceUtil.updateCategoryAds(this);
		}
	}

	@Override
	public CategoryAds toEscapedModel() {
		return (CategoryAds)Proxy.newProxyInstance(CategoryAds.class.getClassLoader(),
			new Class[] { CategoryAds.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		CategoryAdsClp clone = new CategoryAdsClp();

		clone.setCategoryAdsId(getCategoryAdsId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setCategoryAdsName(getCategoryAdsName());

		return clone;
	}

	public int compareTo(CategoryAds categoryAds) {
		int value = 0;

		value = getCategoryAdsName().compareTo(categoryAds.getCategoryAdsName());

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

		CategoryAdsClp categoryAds = null;

		try {
			categoryAds = (CategoryAdsClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = categoryAds.getPrimaryKey();

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
		StringBundler sb = new StringBundler(15);

		sb.append("{categoryAdsId=");
		sb.append(getCategoryAdsId());
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
		sb.append(", categoryAdsName=");
		sb.append(getCategoryAdsName());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("irestads.model.CategoryAds");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>categoryAdsId</column-name><column-value><![CDATA[");
		sb.append(getCategoryAdsId());
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
			"<column><column-name>categoryAdsName</column-name><column-value><![CDATA[");
		sb.append(getCategoryAdsName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _categoryAdsId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _categoryAdsName;
	private BaseModel<?> _categoryAdsRemoteModel;
}