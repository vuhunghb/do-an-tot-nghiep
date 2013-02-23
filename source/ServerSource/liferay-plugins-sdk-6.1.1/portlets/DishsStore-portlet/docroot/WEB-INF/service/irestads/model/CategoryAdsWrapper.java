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
 * This class is a wrapper for {@link CategoryAds}.
 * </p>
 *
 * @author    Be
 * @see       CategoryAds
 * @generated
 */
public class CategoryAdsWrapper implements CategoryAds,
	ModelWrapper<CategoryAds> {
	public CategoryAdsWrapper(CategoryAds categoryAds) {
		_categoryAds = categoryAds;
	}

	public Class<?> getModelClass() {
		return CategoryAds.class;
	}

	public String getModelClassName() {
		return CategoryAds.class.getName();
	}

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

	/**
	* Returns the primary key of this category ads.
	*
	* @return the primary key of this category ads
	*/
	public long getPrimaryKey() {
		return _categoryAds.getPrimaryKey();
	}

	/**
	* Sets the primary key of this category ads.
	*
	* @param primaryKey the primary key of this category ads
	*/
	public void setPrimaryKey(long primaryKey) {
		_categoryAds.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the category ads ID of this category ads.
	*
	* @return the category ads ID of this category ads
	*/
	public long getCategoryAdsId() {
		return _categoryAds.getCategoryAdsId();
	}

	/**
	* Sets the category ads ID of this category ads.
	*
	* @param categoryAdsId the category ads ID of this category ads
	*/
	public void setCategoryAdsId(long categoryAdsId) {
		_categoryAds.setCategoryAdsId(categoryAdsId);
	}

	/**
	* Returns the company ID of this category ads.
	*
	* @return the company ID of this category ads
	*/
	public long getCompanyId() {
		return _categoryAds.getCompanyId();
	}

	/**
	* Sets the company ID of this category ads.
	*
	* @param companyId the company ID of this category ads
	*/
	public void setCompanyId(long companyId) {
		_categoryAds.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this category ads.
	*
	* @return the user ID of this category ads
	*/
	public long getUserId() {
		return _categoryAds.getUserId();
	}

	/**
	* Sets the user ID of this category ads.
	*
	* @param userId the user ID of this category ads
	*/
	public void setUserId(long userId) {
		_categoryAds.setUserId(userId);
	}

	/**
	* Returns the user uuid of this category ads.
	*
	* @return the user uuid of this category ads
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _categoryAds.getUserUuid();
	}

	/**
	* Sets the user uuid of this category ads.
	*
	* @param userUuid the user uuid of this category ads
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_categoryAds.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this category ads.
	*
	* @return the user name of this category ads
	*/
	public java.lang.String getUserName() {
		return _categoryAds.getUserName();
	}

	/**
	* Sets the user name of this category ads.
	*
	* @param userName the user name of this category ads
	*/
	public void setUserName(java.lang.String userName) {
		_categoryAds.setUserName(userName);
	}

	/**
	* Returns the create date of this category ads.
	*
	* @return the create date of this category ads
	*/
	public java.util.Date getCreateDate() {
		return _categoryAds.getCreateDate();
	}

	/**
	* Sets the create date of this category ads.
	*
	* @param createDate the create date of this category ads
	*/
	public void setCreateDate(java.util.Date createDate) {
		_categoryAds.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this category ads.
	*
	* @return the modified date of this category ads
	*/
	public java.util.Date getModifiedDate() {
		return _categoryAds.getModifiedDate();
	}

	/**
	* Sets the modified date of this category ads.
	*
	* @param modifiedDate the modified date of this category ads
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_categoryAds.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the category ads name of this category ads.
	*
	* @return the category ads name of this category ads
	*/
	public java.lang.String getCategoryAdsName() {
		return _categoryAds.getCategoryAdsName();
	}

	/**
	* Sets the category ads name of this category ads.
	*
	* @param categoryAdsName the category ads name of this category ads
	*/
	public void setCategoryAdsName(java.lang.String categoryAdsName) {
		_categoryAds.setCategoryAdsName(categoryAdsName);
	}

	public boolean isNew() {
		return _categoryAds.isNew();
	}

	public void setNew(boolean n) {
		_categoryAds.setNew(n);
	}

	public boolean isCachedModel() {
		return _categoryAds.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_categoryAds.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _categoryAds.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _categoryAds.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_categoryAds.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _categoryAds.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_categoryAds.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CategoryAdsWrapper((CategoryAds)_categoryAds.clone());
	}

	public int compareTo(irestads.model.CategoryAds categoryAds) {
		return _categoryAds.compareTo(categoryAds);
	}

	@Override
	public int hashCode() {
		return _categoryAds.hashCode();
	}

	public com.liferay.portal.model.CacheModel<irestads.model.CategoryAds> toCacheModel() {
		return _categoryAds.toCacheModel();
	}

	public irestads.model.CategoryAds toEscapedModel() {
		return new CategoryAdsWrapper(_categoryAds.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _categoryAds.toString();
	}

	public java.lang.String toXmlString() {
		return _categoryAds.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_categoryAds.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public CategoryAds getWrappedCategoryAds() {
		return _categoryAds;
	}

	public CategoryAds getWrappedModel() {
		return _categoryAds;
	}

	public void resetOriginalValues() {
		_categoryAds.resetOriginalValues();
	}

	private CategoryAds _categoryAds;
}