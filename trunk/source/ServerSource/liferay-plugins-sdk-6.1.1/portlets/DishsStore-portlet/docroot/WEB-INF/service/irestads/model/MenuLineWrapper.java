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
 * This class is a wrapper for {@link MenuLine}.
 * </p>
 *
 * @author    Be
 * @see       MenuLine
 * @generated
 */
public class MenuLineWrapper implements MenuLine, ModelWrapper<MenuLine> {
	public MenuLineWrapper(MenuLine menuLine) {
		_menuLine = menuLine;
	}

	public Class<?> getModelClass() {
		return MenuLine.class;
	}

	public String getModelClassName() {
		return MenuLine.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("menuLineId", getMenuLineId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("numOfDish", getNumOfDish());
		attributes.put("status", getStatus());
		attributes.put("dishId", getDishId());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long menuLineId = (Long)attributes.get("menuLineId");

		if (menuLineId != null) {
			setMenuLineId(menuLineId);
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

		Boolean status = (Boolean)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long dishId = (Long)attributes.get("dishId");

		if (dishId != null) {
			setDishId(dishId);
		}
	}

	/**
	* Returns the primary key of this menu line.
	*
	* @return the primary key of this menu line
	*/
	public long getPrimaryKey() {
		return _menuLine.getPrimaryKey();
	}

	/**
	* Sets the primary key of this menu line.
	*
	* @param primaryKey the primary key of this menu line
	*/
	public void setPrimaryKey(long primaryKey) {
		_menuLine.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the menu line ID of this menu line.
	*
	* @return the menu line ID of this menu line
	*/
	public long getMenuLineId() {
		return _menuLine.getMenuLineId();
	}

	/**
	* Sets the menu line ID of this menu line.
	*
	* @param menuLineId the menu line ID of this menu line
	*/
	public void setMenuLineId(long menuLineId) {
		_menuLine.setMenuLineId(menuLineId);
	}

	/**
	* Returns the company ID of this menu line.
	*
	* @return the company ID of this menu line
	*/
	public long getCompanyId() {
		return _menuLine.getCompanyId();
	}

	/**
	* Sets the company ID of this menu line.
	*
	* @param companyId the company ID of this menu line
	*/
	public void setCompanyId(long companyId) {
		_menuLine.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this menu line.
	*
	* @return the user ID of this menu line
	*/
	public long getUserId() {
		return _menuLine.getUserId();
	}

	/**
	* Sets the user ID of this menu line.
	*
	* @param userId the user ID of this menu line
	*/
	public void setUserId(long userId) {
		_menuLine.setUserId(userId);
	}

	/**
	* Returns the user uuid of this menu line.
	*
	* @return the user uuid of this menu line
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _menuLine.getUserUuid();
	}

	/**
	* Sets the user uuid of this menu line.
	*
	* @param userUuid the user uuid of this menu line
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_menuLine.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this menu line.
	*
	* @return the user name of this menu line
	*/
	public java.lang.String getUserName() {
		return _menuLine.getUserName();
	}

	/**
	* Sets the user name of this menu line.
	*
	* @param userName the user name of this menu line
	*/
	public void setUserName(java.lang.String userName) {
		_menuLine.setUserName(userName);
	}

	/**
	* Returns the create date of this menu line.
	*
	* @return the create date of this menu line
	*/
	public java.util.Date getCreateDate() {
		return _menuLine.getCreateDate();
	}

	/**
	* Sets the create date of this menu line.
	*
	* @param createDate the create date of this menu line
	*/
	public void setCreateDate(java.util.Date createDate) {
		_menuLine.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this menu line.
	*
	* @return the modified date of this menu line
	*/
	public java.util.Date getModifiedDate() {
		return _menuLine.getModifiedDate();
	}

	/**
	* Sets the modified date of this menu line.
	*
	* @param modifiedDate the modified date of this menu line
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_menuLine.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the num of dish of this menu line.
	*
	* @return the num of dish of this menu line
	*/
	public int getNumOfDish() {
		return _menuLine.getNumOfDish();
	}

	/**
	* Sets the num of dish of this menu line.
	*
	* @param numOfDish the num of dish of this menu line
	*/
	public void setNumOfDish(int numOfDish) {
		_menuLine.setNumOfDish(numOfDish);
	}

	/**
	* Returns the status of this menu line.
	*
	* @return the status of this menu line
	*/
	public boolean getStatus() {
		return _menuLine.getStatus();
	}

	/**
	* Returns <code>true</code> if this menu line is status.
	*
	* @return <code>true</code> if this menu line is status; <code>false</code> otherwise
	*/
	public boolean isStatus() {
		return _menuLine.isStatus();
	}

	/**
	* Sets whether this menu line is status.
	*
	* @param status the status of this menu line
	*/
	public void setStatus(boolean status) {
		_menuLine.setStatus(status);
	}

	/**
	* Returns the dish ID of this menu line.
	*
	* @return the dish ID of this menu line
	*/
	public long getDishId() {
		return _menuLine.getDishId();
	}

	/**
	* Sets the dish ID of this menu line.
	*
	* @param dishId the dish ID of this menu line
	*/
	public void setDishId(long dishId) {
		_menuLine.setDishId(dishId);
	}

	public boolean isNew() {
		return _menuLine.isNew();
	}

	public void setNew(boolean n) {
		_menuLine.setNew(n);
	}

	public boolean isCachedModel() {
		return _menuLine.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_menuLine.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _menuLine.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _menuLine.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_menuLine.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _menuLine.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_menuLine.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new MenuLineWrapper((MenuLine)_menuLine.clone());
	}

	public int compareTo(irestads.model.MenuLine menuLine) {
		return _menuLine.compareTo(menuLine);
	}

	@Override
	public int hashCode() {
		return _menuLine.hashCode();
	}

	public com.liferay.portal.model.CacheModel<irestads.model.MenuLine> toCacheModel() {
		return _menuLine.toCacheModel();
	}

	public irestads.model.MenuLine toEscapedModel() {
		return new MenuLineWrapper(_menuLine.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _menuLine.toString();
	}

	public java.lang.String toXmlString() {
		return _menuLine.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_menuLine.persist();
	}

	public irestads.model.DishModel getDish() {
		return _menuLine.getDish();
	}

	public void setDish(irestads.model.DishModel dish) {
		_menuLine.setDish(dish);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public MenuLine getWrappedMenuLine() {
		return _menuLine;
	}

	public MenuLine getWrappedModel() {
		return _menuLine;
	}

	public void resetOriginalValues() {
		_menuLine.resetOriginalValues();
	}

	private MenuLine _menuLine;
}