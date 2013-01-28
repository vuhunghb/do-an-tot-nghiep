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
 * The base model interface for the Orders service. Represents a row in the &quot;dishsstore_Orders&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link irestads.model.impl.OrdersModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link irestads.model.impl.OrdersImpl}.
 * </p>
 *
 * @author Be
 * @see Orders
 * @see irestads.model.impl.OrdersImpl
 * @see irestads.model.impl.OrdersModelImpl
 * @generated
 */
public interface OrdersModel extends AuditedModel, BaseModel<Orders> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a orders model instance should use the {@link Orders} interface instead.
	 */

	/**
	 * Returns the primary key of this orders.
	 *
	 * @return the primary key of this orders
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this orders.
	 *
	 * @param primaryKey the primary key of this orders
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the order ID of this orders.
	 *
	 * @return the order ID of this orders
	 */
	public long getOrderId();

	/**
	 * Sets the order ID of this orders.
	 *
	 * @param orderId the order ID of this orders
	 */
	public void setOrderId(long orderId);

	/**
	 * Returns the company ID of this orders.
	 *
	 * @return the company ID of this orders
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this orders.
	 *
	 * @param companyId the company ID of this orders
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this orders.
	 *
	 * @return the user ID of this orders
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this orders.
	 *
	 * @param userId the user ID of this orders
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this orders.
	 *
	 * @return the user uuid of this orders
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this orders.
	 *
	 * @param userUuid the user uuid of this orders
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this orders.
	 *
	 * @return the user name of this orders
	 */
	@AutoEscape
	public String getUserName();

	/**
	 * Sets the user name of this orders.
	 *
	 * @param userName the user name of this orders
	 */
	public void setUserName(String userName);

	/**
	 * Returns the create date of this orders.
	 *
	 * @return the create date of this orders
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this orders.
	 *
	 * @param createDate the create date of this orders
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this orders.
	 *
	 * @return the modified date of this orders
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this orders.
	 *
	 * @param modifiedDate the modified date of this orders
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the charge of this orders.
	 *
	 * @return the charge of this orders
	 */
	public int getCharge();

	/**
	 * Sets the charge of this orders.
	 *
	 * @param charge the charge of this orders
	 */
	public void setCharge(int charge);

	/**
	 * Returns the created date of this orders.
	 *
	 * @return the created date of this orders
	 */
	public Date getCreatedDate();

	/**
	 * Sets the created date of this orders.
	 *
	 * @param createdDate the created date of this orders
	 */
	public void setCreatedDate(Date createdDate);

	/**
	 * Returns the is pay ment of this orders.
	 *
	 * @return the is pay ment of this orders
	 */
	public boolean getIsPayMent();

	/**
	 * Returns <code>true</code> if this orders is is pay ment.
	 *
	 * @return <code>true</code> if this orders is is pay ment; <code>false</code> otherwise
	 */
	public boolean isIsPayMent();

	/**
	 * Sets whether this orders is is pay ment.
	 *
	 * @param isPayMent the is pay ment of this orders
	 */
	public void setIsPayMent(boolean isPayMent);

	/**
	 * Returns the num of dinner of this orders.
	 *
	 * @return the num of dinner of this orders
	 */
	public int getNumOfDinner();

	/**
	 * Sets the num of dinner of this orders.
	 *
	 * @param numOfDinner the num of dinner of this orders
	 */
	public void setNumOfDinner(int numOfDinner);

	/**
	 * Returns the dish table ID of this orders.
	 *
	 * @return the dish table ID of this orders
	 */
	public long getDishTableId();

	/**
	 * Sets the dish table ID of this orders.
	 *
	 * @param dishTableId the dish table ID of this orders
	 */
	public void setDishTableId(long dishTableId);

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

	public int compareTo(Orders orders);

	public int hashCode();

	public CacheModel<Orders> toCacheModel();

	public Orders toEscapedModel();

	public String toString();

	public String toXmlString();
}