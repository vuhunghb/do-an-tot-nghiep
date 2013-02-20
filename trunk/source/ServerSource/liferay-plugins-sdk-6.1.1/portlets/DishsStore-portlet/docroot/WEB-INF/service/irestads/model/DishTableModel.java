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
 * The base model interface for the DishTable service. Represents a row in the &quot;dishsstore_DishTable&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link irestads.model.impl.DishTableModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link irestads.model.impl.DishTableImpl}.
 * </p>
 *
 * @author Be
 * @see DishTable
 * @see irestads.model.impl.DishTableImpl
 * @see irestads.model.impl.DishTableModelImpl
 * @generated
 */
public interface DishTableModel extends AuditedModel, BaseModel<DishTable> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a dish table model instance should use the {@link DishTable} interface instead.
	 */

	/**
	 * Returns the primary key of this dish table.
	 *
	 * @return the primary key of this dish table
	 */
	public String getPrimaryKey();

	/**
	 * Sets the primary key of this dish table.
	 *
	 * @param primaryKey the primary key of this dish table
	 */
	public void setPrimaryKey(String primaryKey);

	/**
	 * Returns the dish table ID of this dish table.
	 *
	 * @return the dish table ID of this dish table
	 */
	@AutoEscape
	public String getDishTableId();

	/**
	 * Sets the dish table ID of this dish table.
	 *
	 * @param dishTableId the dish table ID of this dish table
	 */
	public void setDishTableId(String dishTableId);

	/**
	 * Returns the company ID of this dish table.
	 *
	 * @return the company ID of this dish table
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this dish table.
	 *
	 * @param companyId the company ID of this dish table
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this dish table.
	 *
	 * @return the user ID of this dish table
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this dish table.
	 *
	 * @param userId the user ID of this dish table
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this dish table.
	 *
	 * @return the user uuid of this dish table
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this dish table.
	 *
	 * @param userUuid the user uuid of this dish table
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this dish table.
	 *
	 * @return the user name of this dish table
	 */
	@AutoEscape
	public String getUserName();

	/**
	 * Sets the user name of this dish table.
	 *
	 * @param userName the user name of this dish table
	 */
	public void setUserName(String userName);

	/**
	 * Returns the create date of this dish table.
	 *
	 * @return the create date of this dish table
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this dish table.
	 *
	 * @param createDate the create date of this dish table
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this dish table.
	 *
	 * @return the modified date of this dish table
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this dish table.
	 *
	 * @param modifiedDate the modified date of this dish table
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the table name of this dish table.
	 *
	 * @return the table name of this dish table
	 */
	@AutoEscape
	public String getTableName();

	/**
	 * Sets the table name of this dish table.
	 *
	 * @param tableName the table name of this dish table
	 */
	public void setTableName(String tableName);

	/**
	 * Returns the is avalable of this dish table.
	 *
	 * @return the is avalable of this dish table
	 */
	public boolean getIsAvalable();

	/**
	 * Returns <code>true</code> if this dish table is is avalable.
	 *
	 * @return <code>true</code> if this dish table is is avalable; <code>false</code> otherwise
	 */
	public boolean isIsAvalable();

	/**
	 * Sets whether this dish table is is avalable.
	 *
	 * @param isAvalable the is avalable of this dish table
	 */
	public void setIsAvalable(boolean isAvalable);

	/**
	 * Returns the num chair of this dish table.
	 *
	 * @return the num chair of this dish table
	 */
	public int getNumChair();

	/**
	 * Sets the num chair of this dish table.
	 *
	 * @param numChair the num chair of this dish table
	 */
	public void setNumChair(int numChair);

	/**
	 * Returns the current order ID of this dish table.
	 *
	 * @return the current order ID of this dish table
	 */
	public long getCurrentOrderId();

	/**
	 * Sets the current order ID of this dish table.
	 *
	 * @param currentOrderId the current order ID of this dish table
	 */
	public void setCurrentOrderId(long currentOrderId);

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

	public int compareTo(DishTable dishTable);

	public int hashCode();

	public CacheModel<DishTable> toCacheModel();

	public DishTable toEscapedModel();

	public String toString();

	public String toXmlString();
}