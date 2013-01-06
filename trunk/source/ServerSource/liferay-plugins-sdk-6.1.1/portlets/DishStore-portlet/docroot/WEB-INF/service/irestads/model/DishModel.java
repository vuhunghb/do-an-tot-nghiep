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
 * The base model interface for the Dish service. Represents a row in the &quot;DishStore_Dish&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link irestads.model.impl.DishModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link irestads.model.impl.DishImpl}.
 * </p>
 *
 * @author Be
 * @see Dish
 * @see irestads.model.impl.DishImpl
 * @see irestads.model.impl.DishModelImpl
 * @generated
 */
public interface DishModel extends AuditedModel, BaseModel<Dish> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a dish model instance should use the {@link Dish} interface instead.
	 */

	/**
	 * Returns the primary key of this dish.
	 *
	 * @return the primary key of this dish
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this dish.
	 *
	 * @param primaryKey the primary key of this dish
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the dish ID of this dish.
	 *
	 * @return the dish ID of this dish
	 */
	public long getDishId();

	/**
	 * Sets the dish ID of this dish.
	 *
	 * @param dishId the dish ID of this dish
	 */
	public void setDishId(long dishId);

	/**
	 * Returns the company ID of this dish.
	 *
	 * @return the company ID of this dish
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this dish.
	 *
	 * @param companyId the company ID of this dish
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this dish.
	 *
	 * @return the user ID of this dish
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this dish.
	 *
	 * @param userId the user ID of this dish
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this dish.
	 *
	 * @return the user uuid of this dish
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this dish.
	 *
	 * @param userUuid the user uuid of this dish
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this dish.
	 *
	 * @return the user name of this dish
	 */
	@AutoEscape
	public String getUserName();

	/**
	 * Sets the user name of this dish.
	 *
	 * @param userName the user name of this dish
	 */
	public void setUserName(String userName);

	/**
	 * Returns the create date of this dish.
	 *
	 * @return the create date of this dish
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this dish.
	 *
	 * @param createDate the create date of this dish
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this dish.
	 *
	 * @return the modified date of this dish
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this dish.
	 *
	 * @param modifiedDate the modified date of this dish
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the dish name of this dish.
	 *
	 * @return the dish name of this dish
	 */
	@AutoEscape
	public String getDishName();

	/**
	 * Sets the dish name of this dish.
	 *
	 * @param dishName the dish name of this dish
	 */
	public void setDishName(String dishName);

	/**
	 * Returns the decription of this dish.
	 *
	 * @return the decription of this dish
	 */
	@AutoEscape
	public String getDecription();

	/**
	 * Sets the decription of this dish.
	 *
	 * @param decription the decription of this dish
	 */
	public void setDecription(String decription);

	/**
	 * Returns the avatar img of this dish.
	 *
	 * @return the avatar img of this dish
	 */
	@AutoEscape
	public String getAvatarImg();

	/**
	 * Sets the avatar img of this dish.
	 *
	 * @param avatarImg the avatar img of this dish
	 */
	public void setAvatarImg(String avatarImg);

	/**
	 * Returns the detail img of this dish.
	 *
	 * @return the detail img of this dish
	 */
	@AutoEscape
	public String getDetailImg();

	/**
	 * Sets the detail img of this dish.
	 *
	 * @param detailImg the detail img of this dish
	 */
	public void setDetailImg(String detailImg);

	/**
	 * Returns the detail of this dish.
	 *
	 * @return the detail of this dish
	 */
	@AutoEscape
	public String getDetail();

	/**
	 * Sets the detail of this dish.
	 *
	 * @param detail the detail of this dish
	 */
	public void setDetail(String detail);

	/**
	 * Returns the refer price of this dish.
	 *
	 * @return the refer price of this dish
	 */
	public int getReferPrice();

	/**
	 * Sets the refer price of this dish.
	 *
	 * @param referPrice the refer price of this dish
	 */
	public void setReferPrice(int referPrice);

	/**
	 * Returns the num of diner of this dish.
	 *
	 * @return the num of diner of this dish
	 */
	public int getNumOfDiner();

	/**
	 * Sets the num of diner of this dish.
	 *
	 * @param numOfDiner the num of diner of this dish
	 */
	public void setNumOfDiner(int numOfDiner);

	/**
	 * Returns the category ID of this dish.
	 *
	 * @return the category ID of this dish
	 */
	public long getCategoryId();

	/**
	 * Sets the category ID of this dish.
	 *
	 * @param categoryId the category ID of this dish
	 */
	public void setCategoryId(long categoryId);

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

	public int compareTo(Dish dish);

	public int hashCode();

	public CacheModel<Dish> toCacheModel();

	public Dish toEscapedModel();

	public String toString();

	public String toXmlString();
}