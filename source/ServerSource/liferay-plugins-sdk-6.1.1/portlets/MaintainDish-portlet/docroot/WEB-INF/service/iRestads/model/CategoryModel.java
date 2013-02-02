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
 * The base model interface for the Category service. Represents a row in the &quot;dishstore_Category&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link iRestads.model.impl.CategoryModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link iRestads.model.impl.CategoryImpl}.
 * </p>
 *
 * @author Be
 * @see Category
 * @see iRestads.model.impl.CategoryImpl
 * @see iRestads.model.impl.CategoryModelImpl
 * @generated
 */
public interface CategoryModel extends AuditedModel, BaseModel<Category> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a category model instance should use the {@link Category} interface instead.
	 */

	/**
	 * Returns the primary key of this category.
	 *
	 * @return the primary key of this category
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this category.
	 *
	 * @param primaryKey the primary key of this category
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the category ID of this category.
	 *
	 * @return the category ID of this category
	 */
	public long getCategoryId();

	/**
	 * Sets the category ID of this category.
	 *
	 * @param categoryId the category ID of this category
	 */
	public void setCategoryId(long categoryId);

	/**
	 * Returns the company ID of this category.
	 *
	 * @return the company ID of this category
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this category.
	 *
	 * @param companyId the company ID of this category
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this category.
	 *
	 * @return the user ID of this category
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this category.
	 *
	 * @param userId the user ID of this category
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this category.
	 *
	 * @return the user uuid of this category
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this category.
	 *
	 * @param userUuid the user uuid of this category
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this category.
	 *
	 * @return the user name of this category
	 */
	@AutoEscape
	public String getUserName();

	/**
	 * Sets the user name of this category.
	 *
	 * @param userName the user name of this category
	 */
	public void setUserName(String userName);

	/**
	 * Returns the create date of this category.
	 *
	 * @return the create date of this category
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this category.
	 *
	 * @param createDate the create date of this category
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this category.
	 *
	 * @return the modified date of this category
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this category.
	 *
	 * @param modifiedDate the modified date of this category
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the category name of this category.
	 *
	 * @return the category name of this category
	 */
	@AutoEscape
	public String getCategoryName();

	/**
	 * Sets the category name of this category.
	 *
	 * @param categoryName the category name of this category
	 */
	public void setCategoryName(String categoryName);

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

	public int compareTo(Category category);

	public int hashCode();

	public CacheModel<Category> toCacheModel();

	public Category toEscapedModel();

	public String toString();

	public String toXmlString();
}