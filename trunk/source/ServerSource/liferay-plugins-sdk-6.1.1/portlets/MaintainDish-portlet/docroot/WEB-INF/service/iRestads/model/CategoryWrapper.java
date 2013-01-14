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

package iRestads.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Category}.
 * </p>
 *
 * @author    Be
 * @see       Category
 * @generated
 */
public class CategoryWrapper implements Category, ModelWrapper<Category> {
	public CategoryWrapper(Category category) {
		_category = category;
	}

	public Class<?> getModelClass() {
		return Category.class;
	}

	public String getModelClassName() {
		return Category.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("categoryId", getCategoryId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("categoryName", getCategoryName());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long categoryId = (Long)attributes.get("categoryId");

		if (categoryId != null) {
			setCategoryId(categoryId);
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

		String categoryName = (String)attributes.get("categoryName");

		if (categoryName != null) {
			setCategoryName(categoryName);
		}
	}

	/**
	* Returns the primary key of this category.
	*
	* @return the primary key of this category
	*/
	public long getPrimaryKey() {
		return _category.getPrimaryKey();
	}

	/**
	* Sets the primary key of this category.
	*
	* @param primaryKey the primary key of this category
	*/
	public void setPrimaryKey(long primaryKey) {
		_category.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the category ID of this category.
	*
	* @return the category ID of this category
	*/
	public long getCategoryId() {
		return _category.getCategoryId();
	}

	/**
	* Sets the category ID of this category.
	*
	* @param categoryId the category ID of this category
	*/
	public void setCategoryId(long categoryId) {
		_category.setCategoryId(categoryId);
	}

	/**
	* Returns the company ID of this category.
	*
	* @return the company ID of this category
	*/
	public long getCompanyId() {
		return _category.getCompanyId();
	}

	/**
	* Sets the company ID of this category.
	*
	* @param companyId the company ID of this category
	*/
	public void setCompanyId(long companyId) {
		_category.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this category.
	*
	* @return the user ID of this category
	*/
	public long getUserId() {
		return _category.getUserId();
	}

	/**
	* Sets the user ID of this category.
	*
	* @param userId the user ID of this category
	*/
	public void setUserId(long userId) {
		_category.setUserId(userId);
	}

	/**
	* Returns the user uuid of this category.
	*
	* @return the user uuid of this category
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _category.getUserUuid();
	}

	/**
	* Sets the user uuid of this category.
	*
	* @param userUuid the user uuid of this category
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_category.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this category.
	*
	* @return the user name of this category
	*/
	public java.lang.String getUserName() {
		return _category.getUserName();
	}

	/**
	* Sets the user name of this category.
	*
	* @param userName the user name of this category
	*/
	public void setUserName(java.lang.String userName) {
		_category.setUserName(userName);
	}

	/**
	* Returns the create date of this category.
	*
	* @return the create date of this category
	*/
	public java.util.Date getCreateDate() {
		return _category.getCreateDate();
	}

	/**
	* Sets the create date of this category.
	*
	* @param createDate the create date of this category
	*/
	public void setCreateDate(java.util.Date createDate) {
		_category.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this category.
	*
	* @return the modified date of this category
	*/
	public java.util.Date getModifiedDate() {
		return _category.getModifiedDate();
	}

	/**
	* Sets the modified date of this category.
	*
	* @param modifiedDate the modified date of this category
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_category.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the category name of this category.
	*
	* @return the category name of this category
	*/
	public java.lang.String getCategoryName() {
		return _category.getCategoryName();
	}

	/**
	* Sets the category name of this category.
	*
	* @param categoryName the category name of this category
	*/
	public void setCategoryName(java.lang.String categoryName) {
		_category.setCategoryName(categoryName);
	}

	public boolean isNew() {
		return _category.isNew();
	}

	public void setNew(boolean n) {
		_category.setNew(n);
	}

	public boolean isCachedModel() {
		return _category.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_category.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _category.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _category.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_category.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _category.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_category.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CategoryWrapper((Category)_category.clone());
	}

	public int compareTo(iRestads.model.Category category) {
		return _category.compareTo(category);
	}

	@Override
	public int hashCode() {
		return _category.hashCode();
	}

	public com.liferay.portal.model.CacheModel<iRestads.model.Category> toCacheModel() {
		return _category.toCacheModel();
	}

	public iRestads.model.Category toEscapedModel() {
		return new CategoryWrapper(_category.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _category.toString();
	}

	public java.lang.String toXmlString() {
		return _category.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_category.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Category getWrappedCategory() {
		return _category;
	}

	public Category getWrappedModel() {
		return _category;
	}

	public void resetOriginalValues() {
		_category.resetOriginalValues();
	}

	private Category _category;
}