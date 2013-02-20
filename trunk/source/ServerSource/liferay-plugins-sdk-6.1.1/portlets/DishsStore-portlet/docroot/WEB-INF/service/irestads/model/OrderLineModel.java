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
 * The base model interface for the OrderLine service. Represents a row in the &quot;dishsstore_OrderLine&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link irestads.model.impl.OrderLineModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link irestads.model.impl.OrderLineImpl}.
 * </p>
 *
 * @author Be
 * @see OrderLine
 * @see irestads.model.impl.OrderLineImpl
 * @see irestads.model.impl.OrderLineModelImpl
 * @generated
 */
public interface OrderLineModel extends AuditedModel, BaseModel<OrderLine> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a order line model instance should use the {@link OrderLine} interface instead.
	 */

	/**
	 * Returns the primary key of this order line.
	 *
	 * @return the primary key of this order line
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this order line.
	 *
	 * @param primaryKey the primary key of this order line
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the order line ID of this order line.
	 *
	 * @return the order line ID of this order line
	 */
	public long getOrderLineId();

	/**
	 * Sets the order line ID of this order line.
	 *
	 * @param orderLineId the order line ID of this order line
	 */
	public void setOrderLineId(long orderLineId);

	/**
	 * Returns the company ID of this order line.
	 *
	 * @return the company ID of this order line
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this order line.
	 *
	 * @param companyId the company ID of this order line
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this order line.
	 *
	 * @return the user ID of this order line
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this order line.
	 *
	 * @param userId the user ID of this order line
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this order line.
	 *
	 * @return the user uuid of this order line
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this order line.
	 *
	 * @param userUuid the user uuid of this order line
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this order line.
	 *
	 * @return the user name of this order line
	 */
	@AutoEscape
	public String getUserName();

	/**
	 * Sets the user name of this order line.
	 *
	 * @param userName the user name of this order line
	 */
	public void setUserName(String userName);

	/**
	 * Returns the create date of this order line.
	 *
	 * @return the create date of this order line
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this order line.
	 *
	 * @param createDate the create date of this order line
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this order line.
	 *
	 * @return the modified date of this order line
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this order line.
	 *
	 * @param modifiedDate the modified date of this order line
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the num of dish of this order line.
	 *
	 * @return the num of dish of this order line
	 */
	public int getNumOfDish();

	/**
	 * Sets the num of dish of this order line.
	 *
	 * @param numOfDish the num of dish of this order line
	 */
	public void setNumOfDish(int numOfDish);

	/**
	 * Returns the num of finish dish of this order line.
	 *
	 * @return the num of finish dish of this order line
	 */
	public int getNumOfFinishDish();

	/**
	 * Sets the num of finish dish of this order line.
	 *
	 * @param numOfFinishDish the num of finish dish of this order line
	 */
	public void setNumOfFinishDish(int numOfFinishDish);

	/**
	 * Returns the status dish of this order line.
	 *
	 * @return the status dish of this order line
	 */
	public int getStatusDish();

	/**
	 * Sets the status dish of this order line.
	 *
	 * @param statusDish the status dish of this order line
	 */
	public void setStatusDish(int statusDish);

	/**
	 * Returns the dish ID of this order line.
	 *
	 * @return the dish ID of this order line
	 */
	public long getDishId();

	/**
	 * Sets the dish ID of this order line.
	 *
	 * @param dishId the dish ID of this order line
	 */
	public void setDishId(long dishId);

	/**
	 * Returns the order date of this order line.
	 *
	 * @return the order date of this order line
	 */
	public Date getOrderDate();

	/**
	 * Sets the order date of this order line.
	 *
	 * @param orderDate the order date of this order line
	 */
	public void setOrderDate(Date orderDate);

	/**
	 * Returns the order ID of this order line.
	 *
	 * @return the order ID of this order line
	 */
	public long getOrderId();

	/**
	 * Sets the order ID of this order line.
	 *
	 * @param orderId the order ID of this order line
	 */
	public void setOrderId(long orderId);

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

	public int compareTo(OrderLine orderLine);

	public int hashCode();

	public CacheModel<OrderLine> toCacheModel();

	public OrderLine toEscapedModel();

	public String toString();

	public String toXmlString();
}