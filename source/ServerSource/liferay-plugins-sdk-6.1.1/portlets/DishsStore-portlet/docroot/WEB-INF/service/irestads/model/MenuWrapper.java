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
 * This class is a wrapper for {@link Menu}.
 * </p>
 *
 * @author    Be
 * @see       Menu
 * @generated
 */
public class MenuWrapper implements Menu, ModelWrapper<Menu> {
	public MenuWrapper(Menu menu) {
		_menu = menu;
	}

	public Class<?> getModelClass() {
		return Menu.class;
	}

	public String getModelClassName() {
		return Menu.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("menuId", getMenuId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("menuName", getMenuName());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long menuId = (Long)attributes.get("menuId");

		if (menuId != null) {
			setMenuId(menuId);
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

		String menuName = (String)attributes.get("menuName");

		if (menuName != null) {
			setMenuName(menuName);
		}
	}

	/**
	* Returns the primary key of this menu.
	*
	* @return the primary key of this menu
	*/
	public long getPrimaryKey() {
		return _menu.getPrimaryKey();
	}

	/**
	* Sets the primary key of this menu.
	*
	* @param primaryKey the primary key of this menu
	*/
	public void setPrimaryKey(long primaryKey) {
		_menu.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the menu ID of this menu.
	*
	* @return the menu ID of this menu
	*/
	public long getMenuId() {
		return _menu.getMenuId();
	}

	/**
	* Sets the menu ID of this menu.
	*
	* @param menuId the menu ID of this menu
	*/
	public void setMenuId(long menuId) {
		_menu.setMenuId(menuId);
	}

	/**
	* Returns the company ID of this menu.
	*
	* @return the company ID of this menu
	*/
	public long getCompanyId() {
		return _menu.getCompanyId();
	}

	/**
	* Sets the company ID of this menu.
	*
	* @param companyId the company ID of this menu
	*/
	public void setCompanyId(long companyId) {
		_menu.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this menu.
	*
	* @return the user ID of this menu
	*/
	public long getUserId() {
		return _menu.getUserId();
	}

	/**
	* Sets the user ID of this menu.
	*
	* @param userId the user ID of this menu
	*/
	public void setUserId(long userId) {
		_menu.setUserId(userId);
	}

	/**
	* Returns the user uuid of this menu.
	*
	* @return the user uuid of this menu
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _menu.getUserUuid();
	}

	/**
	* Sets the user uuid of this menu.
	*
	* @param userUuid the user uuid of this menu
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_menu.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this menu.
	*
	* @return the user name of this menu
	*/
	public java.lang.String getUserName() {
		return _menu.getUserName();
	}

	/**
	* Sets the user name of this menu.
	*
	* @param userName the user name of this menu
	*/
	public void setUserName(java.lang.String userName) {
		_menu.setUserName(userName);
	}

	/**
	* Returns the create date of this menu.
	*
	* @return the create date of this menu
	*/
	public java.util.Date getCreateDate() {
		return _menu.getCreateDate();
	}

	/**
	* Sets the create date of this menu.
	*
	* @param createDate the create date of this menu
	*/
	public void setCreateDate(java.util.Date createDate) {
		_menu.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this menu.
	*
	* @return the modified date of this menu
	*/
	public java.util.Date getModifiedDate() {
		return _menu.getModifiedDate();
	}

	/**
	* Sets the modified date of this menu.
	*
	* @param modifiedDate the modified date of this menu
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_menu.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the menu name of this menu.
	*
	* @return the menu name of this menu
	*/
	public java.lang.String getMenuName() {
		return _menu.getMenuName();
	}

	/**
	* Sets the menu name of this menu.
	*
	* @param menuName the menu name of this menu
	*/
	public void setMenuName(java.lang.String menuName) {
		_menu.setMenuName(menuName);
	}

	public boolean isNew() {
		return _menu.isNew();
	}

	public void setNew(boolean n) {
		_menu.setNew(n);
	}

	public boolean isCachedModel() {
		return _menu.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_menu.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _menu.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _menu.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_menu.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _menu.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_menu.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new MenuWrapper((Menu)_menu.clone());
	}

	public int compareTo(irestads.model.Menu menu) {
		return _menu.compareTo(menu);
	}

	@Override
	public int hashCode() {
		return _menu.hashCode();
	}

	public com.liferay.portal.model.CacheModel<irestads.model.Menu> toCacheModel() {
		return _menu.toCacheModel();
	}

	public irestads.model.Menu toEscapedModel() {
		return new MenuWrapper(_menu.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _menu.toString();
	}

	public java.lang.String toXmlString() {
		return _menu.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_menu.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Menu getWrappedMenu() {
		return _menu;
	}

	public Menu getWrappedModel() {
		return _menu;
	}

	public void resetOriginalValues() {
		_menu.resetOriginalValues();
	}

	private Menu _menu;
}