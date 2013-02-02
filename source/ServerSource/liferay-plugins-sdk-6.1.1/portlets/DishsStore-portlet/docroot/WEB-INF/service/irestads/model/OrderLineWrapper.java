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
 * This class is a wrapper for {@link OrderLine}.
 * </p>
 *
 * @author    Be
 * @see       OrderLine
 * @generated
 */
public class OrderLineWrapper implements OrderLine, ModelWrapper<OrderLine> {
	public OrderLineWrapper(OrderLine orderLine) {
		_orderLine = orderLine;
	}

	public Class<?> getModelClass() {
		return OrderLine.class;
	}

	public String getModelClassName() {
		return OrderLine.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("orderLineId", getOrderLineId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("numOfDish", getNumOfDish());
		attributes.put("statusDish", getStatusDish());
		attributes.put("dishId", getDishId());
		attributes.put("orderId", getOrderId());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long orderLineId = (Long)attributes.get("orderLineId");

		if (orderLineId != null) {
			setOrderLineId(orderLineId);
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

		Integer numOfDish = (Integer)attributes.get("numOfDish");

		if (numOfDish != null) {
			setNumOfDish(numOfDish);
		}

		Integer statusDish = (Integer)attributes.get("statusDish");

		if (statusDish != null) {
			setStatusDish(statusDish);
		}

		Long dishId = (Long)attributes.get("dishId");

		if (dishId != null) {
			setDishId(dishId);
		}

		Long orderId = (Long)attributes.get("orderId");

		if (orderId != null) {
			setOrderId(orderId);
		}
	}

	/**
	* Returns the primary key of this order line.
	*
	* @return the primary key of this order line
	*/
	public long getPrimaryKey() {
		return _orderLine.getPrimaryKey();
	}

	/**
	* Sets the primary key of this order line.
	*
	* @param primaryKey the primary key of this order line
	*/
	public void setPrimaryKey(long primaryKey) {
		_orderLine.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the order line ID of this order line.
	*
	* @return the order line ID of this order line
	*/
	public long getOrderLineId() {
		return _orderLine.getOrderLineId();
	}

	/**
	* Sets the order line ID of this order line.
	*
	* @param orderLineId the order line ID of this order line
	*/
	public void setOrderLineId(long orderLineId) {
		_orderLine.setOrderLineId(orderLineId);
	}

	/**
	* Returns the company ID of this order line.
	*
	* @return the company ID of this order line
	*/
	public long getCompanyId() {
		return _orderLine.getCompanyId();
	}

	/**
	* Sets the company ID of this order line.
	*
	* @param companyId the company ID of this order line
	*/
	public void setCompanyId(long companyId) {
		_orderLine.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this order line.
	*
	* @return the user ID of this order line
	*/
	public long getUserId() {
		return _orderLine.getUserId();
	}

	/**
	* Sets the user ID of this order line.
	*
	* @param userId the user ID of this order line
	*/
	public void setUserId(long userId) {
		_orderLine.setUserId(userId);
	}

	/**
	* Returns the user uuid of this order line.
	*
	* @return the user uuid of this order line
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _orderLine.getUserUuid();
	}

	/**
	* Sets the user uuid of this order line.
	*
	* @param userUuid the user uuid of this order line
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_orderLine.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this order line.
	*
	* @return the user name of this order line
	*/
	public java.lang.String getUserName() {
		return _orderLine.getUserName();
	}

	/**
	* Sets the user name of this order line.
	*
	* @param userName the user name of this order line
	*/
	public void setUserName(java.lang.String userName) {
		_orderLine.setUserName(userName);
	}

	/**
	* Returns the create date of this order line.
	*
	* @return the create date of this order line
	*/
	public java.util.Date getCreateDate() {
		return _orderLine.getCreateDate();
	}

	/**
	* Sets the create date of this order line.
	*
	* @param createDate the create date of this order line
	*/
	public void setCreateDate(java.util.Date createDate) {
		_orderLine.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this order line.
	*
	* @return the modified date of this order line
	*/
	public java.util.Date getModifiedDate() {
		return _orderLine.getModifiedDate();
	}

	/**
	* Sets the modified date of this order line.
	*
	* @param modifiedDate the modified date of this order line
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_orderLine.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the num of dish of this order line.
	*
	* @return the num of dish of this order line
	*/
	public int getNumOfDish() {
		return _orderLine.getNumOfDish();
	}

	/**
	* Sets the num of dish of this order line.
	*
	* @param numOfDish the num of dish of this order line
	*/
	public void setNumOfDish(int numOfDish) {
		_orderLine.setNumOfDish(numOfDish);
	}

	/**
	* Returns the status dish of this order line.
	*
	* @return the status dish of this order line
	*/
	public int getStatusDish() {
		return _orderLine.getStatusDish();
	}

	/**
	* Sets the status dish of this order line.
	*
	* @param statusDish the status dish of this order line
	*/
	public void setStatusDish(int statusDish) {
		_orderLine.setStatusDish(statusDish);
	}

	/**
	* Returns the dish ID of this order line.
	*
	* @return the dish ID of this order line
	*/
	public long getDishId() {
		return _orderLine.getDishId();
	}

	/**
	* Sets the dish ID of this order line.
	*
	* @param dishId the dish ID of this order line
	*/
	public void setDishId(long dishId) {
		_orderLine.setDishId(dishId);
	}

	/**
	* Returns the order ID of this order line.
	*
	* @return the order ID of this order line
	*/
	public long getOrderId() {
		return _orderLine.getOrderId();
	}

	/**
	* Sets the order ID of this order line.
	*
	* @param orderId the order ID of this order line
	*/
	public void setOrderId(long orderId) {
		_orderLine.setOrderId(orderId);
	}

	public boolean isNew() {
		return _orderLine.isNew();
	}

	public void setNew(boolean n) {
		_orderLine.setNew(n);
	}

	public boolean isCachedModel() {
		return _orderLine.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_orderLine.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _orderLine.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _orderLine.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_orderLine.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _orderLine.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_orderLine.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new OrderLineWrapper((OrderLine)_orderLine.clone());
	}

	public int compareTo(irestads.model.OrderLine orderLine) {
		return _orderLine.compareTo(orderLine);
	}

	@Override
	public int hashCode() {
		return _orderLine.hashCode();
	}

	public com.liferay.portal.model.CacheModel<irestads.model.OrderLine> toCacheModel() {
		return _orderLine.toCacheModel();
	}

	public irestads.model.OrderLine toEscapedModel() {
		return new OrderLineWrapper(_orderLine.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _orderLine.toString();
	}

	public java.lang.String toXmlString() {
		return _orderLine.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_orderLine.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public OrderLine getWrappedOrderLine() {
		return _orderLine;
	}

	public OrderLine getWrappedModel() {
		return _orderLine;
	}

	public void resetOriginalValues() {
		_orderLine.resetOriginalValues();
	}

	private OrderLine _orderLine;
}