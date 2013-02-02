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
 * The base model interface for the MenuLine service. Represents a row in the &quot;dishsstore_MenuLine&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link irestads.model.impl.MenuLineModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link irestads.model.impl.MenuLineImpl}.
 * </p>
 *
 * @author Be
 * @see MenuLine
 * @see irestads.model.impl.MenuLineImpl
 * @see irestads.model.impl.MenuLineModelImpl
 * @generated
 */
public interface MenuLineModel extends AuditedModel, BaseModel<MenuLine> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a menu line model instance should use the {@link MenuLine} interface instead.
	 */

	/**
	 * Returns the primary key of this menu line.
	 *
	 * @return the primary key of this menu line
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this menu line.
	 *
	 * @param primaryKey the primary key of this menu line
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the menu line ID of this menu line.
	 *
	 * @return the menu line ID of this menu line
	 */
	public long getMenuLineId();

	/**
	 * Sets the menu line ID of this menu line.
	 *
	 * @param menuLineId the menu line ID of this menu line
	 */
	public void setMenuLineId(long menuLineId);

	/**
	 * Returns the company ID of this menu line.
	 *
	 * @return the company ID of this menu line
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this menu line.
	 *
	 * @param companyId the company ID of this menu line
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this menu line.
	 *
	 * @return the user ID of this menu line
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this menu line.
	 *
	 * @param userId the user ID of this menu line
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this menu line.
	 *
	 * @return the user uuid of this menu line
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this menu line.
	 *
	 * @param userUuid the user uuid of this menu line
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this menu line.
	 *
	 * @return the user name of this menu line
	 */
	@AutoEscape
	public String getUserName();

	/**
	 * Sets the user name of this menu line.
	 *
	 * @param userName the user name of this menu line
	 */
	public void setUserName(String userName);

	/**
	 * Returns the create date of this menu line.
	 *
	 * @return the create date of this menu line
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this menu line.
	 *
	 * @param createDate the create date of this menu line
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this menu line.
	 *
	 * @return the modified date of this menu line
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this menu line.
	 *
	 * @param modifiedDate the modified date of this menu line
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the num of dish of this menu line.
	 *
	 * @return the num of dish of this menu line
	 */
	public int getNumOfDish();

	/**
	 * Sets the num of dish of this menu line.
	 *
	 * @param numOfDish the num of dish of this menu line
	 */
	public void setNumOfDish(int numOfDish);

	/**
	 * Returns the status of this menu line.
	 *
	 * @return the status of this menu line
	 */
	public boolean getStatus();

	/**
	 * Returns <code>true</code> if this menu line is status.
	 *
	 * @return <code>true</code> if this menu line is status; <code>false</code> otherwise
	 */
	public boolean isStatus();

	/**
	 * Sets whether this menu line is status.
	 *
	 * @param status the status of this menu line
	 */
	public void setStatus(boolean status);

	/**
	 * Returns the dish ID of this menu line.
	 *
	 * @return the dish ID of this menu line
	 */
	public long getDishId();

	/**
	 * Sets the dish ID of this menu line.
	 *
	 * @param dishId the dish ID of this menu line
	 */
	public void setDishId(long dishId);

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

	public int compareTo(MenuLine menuLine);

	public int hashCode();

	public CacheModel<MenuLine> toCacheModel();

	public MenuLine toEscapedModel();

	public String toString();

	public String toXmlString();
}