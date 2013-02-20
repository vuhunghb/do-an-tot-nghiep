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
 * This class is a wrapper for {@link DishTable}.
 * </p>
 *
 * @author    Be
 * @see       DishTable
 * @generated
 */
public class DishTableWrapper implements DishTable, ModelWrapper<DishTable> {
	public DishTableWrapper(DishTable dishTable) {
		_dishTable = dishTable;
	}

	public Class<?> getModelClass() {
		return DishTable.class;
	}

	public String getModelClassName() {
		return DishTable.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("dishTableId", getDishTableId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("tableName", getTableName());
		attributes.put("isAvalable", getIsAvalable());
		attributes.put("numChair", getNumChair());
		attributes.put("currentOrderId", getCurrentOrderId());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		String dishTableId = (String)attributes.get("dishTableId");

		if (dishTableId != null) {
			setDishTableId(dishTableId);
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

		String tableName = (String)attributes.get("tableName");

		if (tableName != null) {
			setTableName(tableName);
		}

		Boolean isAvalable = (Boolean)attributes.get("isAvalable");

		if (isAvalable != null) {
			setIsAvalable(isAvalable);
		}

		Integer numChair = (Integer)attributes.get("numChair");

		if (numChair != null) {
			setNumChair(numChair);
		}

		Long currentOrderId = (Long)attributes.get("currentOrderId");

		if (currentOrderId != null) {
			setCurrentOrderId(currentOrderId);
		}
	}

	/**
	* Returns the primary key of this dish table.
	*
	* @return the primary key of this dish table
	*/
	public java.lang.String getPrimaryKey() {
		return _dishTable.getPrimaryKey();
	}

	/**
	* Sets the primary key of this dish table.
	*
	* @param primaryKey the primary key of this dish table
	*/
	public void setPrimaryKey(java.lang.String primaryKey) {
		_dishTable.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the dish table ID of this dish table.
	*
	* @return the dish table ID of this dish table
	*/
	public java.lang.String getDishTableId() {
		return _dishTable.getDishTableId();
	}

	/**
	* Sets the dish table ID of this dish table.
	*
	* @param dishTableId the dish table ID of this dish table
	*/
	public void setDishTableId(java.lang.String dishTableId) {
		_dishTable.setDishTableId(dishTableId);
	}

	/**
	* Returns the company ID of this dish table.
	*
	* @return the company ID of this dish table
	*/
	public long getCompanyId() {
		return _dishTable.getCompanyId();
	}

	/**
	* Sets the company ID of this dish table.
	*
	* @param companyId the company ID of this dish table
	*/
	public void setCompanyId(long companyId) {
		_dishTable.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this dish table.
	*
	* @return the user ID of this dish table
	*/
	public long getUserId() {
		return _dishTable.getUserId();
	}

	/**
	* Sets the user ID of this dish table.
	*
	* @param userId the user ID of this dish table
	*/
	public void setUserId(long userId) {
		_dishTable.setUserId(userId);
	}

	/**
	* Returns the user uuid of this dish table.
	*
	* @return the user uuid of this dish table
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dishTable.getUserUuid();
	}

	/**
	* Sets the user uuid of this dish table.
	*
	* @param userUuid the user uuid of this dish table
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_dishTable.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this dish table.
	*
	* @return the user name of this dish table
	*/
	public java.lang.String getUserName() {
		return _dishTable.getUserName();
	}

	/**
	* Sets the user name of this dish table.
	*
	* @param userName the user name of this dish table
	*/
	public void setUserName(java.lang.String userName) {
		_dishTable.setUserName(userName);
	}

	/**
	* Returns the create date of this dish table.
	*
	* @return the create date of this dish table
	*/
	public java.util.Date getCreateDate() {
		return _dishTable.getCreateDate();
	}

	/**
	* Sets the create date of this dish table.
	*
	* @param createDate the create date of this dish table
	*/
	public void setCreateDate(java.util.Date createDate) {
		_dishTable.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this dish table.
	*
	* @return the modified date of this dish table
	*/
	public java.util.Date getModifiedDate() {
		return _dishTable.getModifiedDate();
	}

	/**
	* Sets the modified date of this dish table.
	*
	* @param modifiedDate the modified date of this dish table
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_dishTable.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the table name of this dish table.
	*
	* @return the table name of this dish table
	*/
	public java.lang.String getTableName() {
		return _dishTable.getTableName();
	}

	/**
	* Sets the table name of this dish table.
	*
	* @param tableName the table name of this dish table
	*/
	public void setTableName(java.lang.String tableName) {
		_dishTable.setTableName(tableName);
	}

	/**
	* Returns the is avalable of this dish table.
	*
	* @return the is avalable of this dish table
	*/
	public boolean getIsAvalable() {
		return _dishTable.getIsAvalable();
	}

	/**
	* Returns <code>true</code> if this dish table is is avalable.
	*
	* @return <code>true</code> if this dish table is is avalable; <code>false</code> otherwise
	*/
	public boolean isIsAvalable() {
		return _dishTable.isIsAvalable();
	}

	/**
	* Sets whether this dish table is is avalable.
	*
	* @param isAvalable the is avalable of this dish table
	*/
	public void setIsAvalable(boolean isAvalable) {
		_dishTable.setIsAvalable(isAvalable);
	}

	/**
	* Returns the num chair of this dish table.
	*
	* @return the num chair of this dish table
	*/
	public int getNumChair() {
		return _dishTable.getNumChair();
	}

	/**
	* Sets the num chair of this dish table.
	*
	* @param numChair the num chair of this dish table
	*/
	public void setNumChair(int numChair) {
		_dishTable.setNumChair(numChair);
	}

	/**
	* Returns the current order ID of this dish table.
	*
	* @return the current order ID of this dish table
	*/
	public long getCurrentOrderId() {
		return _dishTable.getCurrentOrderId();
	}

	/**
	* Sets the current order ID of this dish table.
	*
	* @param currentOrderId the current order ID of this dish table
	*/
	public void setCurrentOrderId(long currentOrderId) {
		_dishTable.setCurrentOrderId(currentOrderId);
	}

	public boolean isNew() {
		return _dishTable.isNew();
	}

	public void setNew(boolean n) {
		_dishTable.setNew(n);
	}

	public boolean isCachedModel() {
		return _dishTable.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_dishTable.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _dishTable.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _dishTable.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_dishTable.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _dishTable.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_dishTable.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new DishTableWrapper((DishTable)_dishTable.clone());
	}

	public int compareTo(irestads.model.DishTable dishTable) {
		return _dishTable.compareTo(dishTable);
	}

	@Override
	public int hashCode() {
		return _dishTable.hashCode();
	}

	public com.liferay.portal.model.CacheModel<irestads.model.DishTable> toCacheModel() {
		return _dishTable.toCacheModel();
	}

	public irestads.model.DishTable toEscapedModel() {
		return new DishTableWrapper(_dishTable.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _dishTable.toString();
	}

	public java.lang.String toXmlString() {
		return _dishTable.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_dishTable.persist();
	}

	public irestads.model.Orders getCurentOrder() {
		return _dishTable.getCurentOrder();
	}

	public void setCurentOrder(irestads.model.Orders curentOrder) {
		_dishTable.setCurentOrder(curentOrder);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public DishTable getWrappedDishTable() {
		return _dishTable;
	}

	public DishTable getWrappedModel() {
		return _dishTable;
	}

	public void resetOriginalValues() {
		_dishTable.resetOriginalValues();
	}

	private DishTable _dishTable;
}