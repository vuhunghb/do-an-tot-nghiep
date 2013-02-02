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
 * This class is a wrapper for {@link Orders}.
 * </p>
 *
 * @author    Be
 * @see       Orders
 * @generated
 */
public class OrdersWrapper implements Orders, ModelWrapper<Orders> {
	public OrdersWrapper(Orders orders) {
		_orders = orders;
	}

	public Class<?> getModelClass() {
		return Orders.class;
	}

	public String getModelClassName() {
		return Orders.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("orderId", getOrderId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("charge", getCharge());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("isPayMent", getIsPayMent());
		attributes.put("numOfDinner", getNumOfDinner());
		attributes.put("dishTableId", getDishTableId());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long orderId = (Long)attributes.get("orderId");

		if (orderId != null) {
			setOrderId(orderId);
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

		Integer charge = (Integer)attributes.get("charge");

		if (charge != null) {
			setCharge(charge);
		}

		Date createdDate = (Date)attributes.get("createdDate");

		if (createdDate != null) {
			setCreatedDate(createdDate);
		}

		Boolean isPayMent = (Boolean)attributes.get("isPayMent");

		if (isPayMent != null) {
			setIsPayMent(isPayMent);
		}

		Integer numOfDinner = (Integer)attributes.get("numOfDinner");

		if (numOfDinner != null) {
			setNumOfDinner(numOfDinner);
		}

		String dishTableId = (String)attributes.get("dishTableId");

		if (dishTableId != null) {
			setDishTableId(dishTableId);
		}
	}

	/**
	* Returns the primary key of this orders.
	*
	* @return the primary key of this orders
	*/
	public long getPrimaryKey() {
		return _orders.getPrimaryKey();
	}

	/**
	* Sets the primary key of this orders.
	*
	* @param primaryKey the primary key of this orders
	*/
	public void setPrimaryKey(long primaryKey) {
		_orders.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the order ID of this orders.
	*
	* @return the order ID of this orders
	*/
	public long getOrderId() {
		return _orders.getOrderId();
	}

	/**
	* Sets the order ID of this orders.
	*
	* @param orderId the order ID of this orders
	*/
	public void setOrderId(long orderId) {
		_orders.setOrderId(orderId);
	}

	/**
	* Returns the company ID of this orders.
	*
	* @return the company ID of this orders
	*/
	public long getCompanyId() {
		return _orders.getCompanyId();
	}

	/**
	* Sets the company ID of this orders.
	*
	* @param companyId the company ID of this orders
	*/
	public void setCompanyId(long companyId) {
		_orders.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this orders.
	*
	* @return the user ID of this orders
	*/
	public long getUserId() {
		return _orders.getUserId();
	}

	/**
	* Sets the user ID of this orders.
	*
	* @param userId the user ID of this orders
	*/
	public void setUserId(long userId) {
		_orders.setUserId(userId);
	}

	/**
	* Returns the user uuid of this orders.
	*
	* @return the user uuid of this orders
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _orders.getUserUuid();
	}

	/**
	* Sets the user uuid of this orders.
	*
	* @param userUuid the user uuid of this orders
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_orders.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this orders.
	*
	* @return the user name of this orders
	*/
	public java.lang.String getUserName() {
		return _orders.getUserName();
	}

	/**
	* Sets the user name of this orders.
	*
	* @param userName the user name of this orders
	*/
	public void setUserName(java.lang.String userName) {
		_orders.setUserName(userName);
	}

	/**
	* Returns the create date of this orders.
	*
	* @return the create date of this orders
	*/
	public java.util.Date getCreateDate() {
		return _orders.getCreateDate();
	}

	/**
	* Sets the create date of this orders.
	*
	* @param createDate the create date of this orders
	*/
	public void setCreateDate(java.util.Date createDate) {
		_orders.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this orders.
	*
	* @return the modified date of this orders
	*/
	public java.util.Date getModifiedDate() {
		return _orders.getModifiedDate();
	}

	/**
	* Sets the modified date of this orders.
	*
	* @param modifiedDate the modified date of this orders
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_orders.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the charge of this orders.
	*
	* @return the charge of this orders
	*/
	public int getCharge() {
		return _orders.getCharge();
	}

	/**
	* Sets the charge of this orders.
	*
	* @param charge the charge of this orders
	*/
	public void setCharge(int charge) {
		_orders.setCharge(charge);
	}

	/**
	* Returns the created date of this orders.
	*
	* @return the created date of this orders
	*/
	public java.util.Date getCreatedDate() {
		return _orders.getCreatedDate();
	}

	/**
	* Sets the created date of this orders.
	*
	* @param createdDate the created date of this orders
	*/
	public void setCreatedDate(java.util.Date createdDate) {
		_orders.setCreatedDate(createdDate);
	}

	/**
	* Returns the is pay ment of this orders.
	*
	* @return the is pay ment of this orders
	*/
	public boolean getIsPayMent() {
		return _orders.getIsPayMent();
	}

	/**
	* Returns <code>true</code> if this orders is is pay ment.
	*
	* @return <code>true</code> if this orders is is pay ment; <code>false</code> otherwise
	*/
	public boolean isIsPayMent() {
		return _orders.isIsPayMent();
	}

	/**
	* Sets whether this orders is is pay ment.
	*
	* @param isPayMent the is pay ment of this orders
	*/
	public void setIsPayMent(boolean isPayMent) {
		_orders.setIsPayMent(isPayMent);
	}

	/**
	* Returns the num of dinner of this orders.
	*
	* @return the num of dinner of this orders
	*/
	public int getNumOfDinner() {
		return _orders.getNumOfDinner();
	}

	/**
	* Sets the num of dinner of this orders.
	*
	* @param numOfDinner the num of dinner of this orders
	*/
	public void setNumOfDinner(int numOfDinner) {
		_orders.setNumOfDinner(numOfDinner);
	}

	/**
	* Returns the dish table ID of this orders.
	*
	* @return the dish table ID of this orders
	*/
	public java.lang.String getDishTableId() {
		return _orders.getDishTableId();
	}

	/**
	* Sets the dish table ID of this orders.
	*
	* @param dishTableId the dish table ID of this orders
	*/
	public void setDishTableId(java.lang.String dishTableId) {
		_orders.setDishTableId(dishTableId);
	}

	public boolean isNew() {
		return _orders.isNew();
	}

	public void setNew(boolean n) {
		_orders.setNew(n);
	}

	public boolean isCachedModel() {
		return _orders.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_orders.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _orders.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _orders.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_orders.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _orders.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_orders.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new OrdersWrapper((Orders)_orders.clone());
	}

	public int compareTo(irestads.model.Orders orders) {
		return _orders.compareTo(orders);
	}

	@Override
	public int hashCode() {
		return _orders.hashCode();
	}

	public com.liferay.portal.model.CacheModel<irestads.model.Orders> toCacheModel() {
		return _orders.toCacheModel();
	}

	public irestads.model.Orders toEscapedModel() {
		return new OrdersWrapper(_orders.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _orders.toString();
	}

	public java.lang.String toXmlString() {
		return _orders.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_orders.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Orders getWrappedOrders() {
		return _orders;
	}

	public Orders getWrappedModel() {
		return _orders;
	}

	public void resetOriginalValues() {
		_orders.resetOriginalValues();
	}

	private Orders _orders;
}