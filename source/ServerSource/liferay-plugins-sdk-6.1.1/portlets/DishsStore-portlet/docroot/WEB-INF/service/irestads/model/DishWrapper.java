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
 * This class is a wrapper for {@link Dish}.
 * </p>
 *
 * @author    Be
 * @see       Dish
 * @generated
 */
public class DishWrapper implements Dish, ModelWrapper<Dish> {
	public DishWrapper(Dish dish) {
		_dish = dish;
	}

	public Class<?> getModelClass() {
		return Dish.class;
	}

	public String getModelClassName() {
		return Dish.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("dishId", getDishId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("dishName", getDishName());
		attributes.put("decription", getDecription());
		attributes.put("avatarImg", getAvatarImg());
		attributes.put("avatarBaseCode", getAvatarBaseCode());
		attributes.put("detailImg", getDetailImg());
		attributes.put("detailBaseCode", getDetailBaseCode());
		attributes.put("detail", getDetail());
		attributes.put("referPrice", getReferPrice());
		attributes.put("numOfDiner", getNumOfDiner());
		attributes.put("categoryId", getCategoryId());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long dishId = (Long)attributes.get("dishId");

		if (dishId != null) {
			setDishId(dishId);
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

		String dishName = (String)attributes.get("dishName");

		if (dishName != null) {
			setDishName(dishName);
		}

		String decription = (String)attributes.get("decription");

		if (decription != null) {
			setDecription(decription);
		}

		String avatarImg = (String)attributes.get("avatarImg");

		if (avatarImg != null) {
			setAvatarImg(avatarImg);
		}

		String avatarBaseCode = (String)attributes.get("avatarBaseCode");

		if (avatarBaseCode != null) {
			setAvatarBaseCode(avatarBaseCode);
		}

		String detailImg = (String)attributes.get("detailImg");

		if (detailImg != null) {
			setDetailImg(detailImg);
		}

		String detailBaseCode = (String)attributes.get("detailBaseCode");

		if (detailBaseCode != null) {
			setDetailBaseCode(detailBaseCode);
		}

		String detail = (String)attributes.get("detail");

		if (detail != null) {
			setDetail(detail);
		}

		Integer referPrice = (Integer)attributes.get("referPrice");

		if (referPrice != null) {
			setReferPrice(referPrice);
		}

		Integer numOfDiner = (Integer)attributes.get("numOfDiner");

		if (numOfDiner != null) {
			setNumOfDiner(numOfDiner);
		}

		Long categoryId = (Long)attributes.get("categoryId");

		if (categoryId != null) {
			setCategoryId(categoryId);
		}
	}

	/**
	* Returns the primary key of this dish.
	*
	* @return the primary key of this dish
	*/
	public long getPrimaryKey() {
		return _dish.getPrimaryKey();
	}

	/**
	* Sets the primary key of this dish.
	*
	* @param primaryKey the primary key of this dish
	*/
	public void setPrimaryKey(long primaryKey) {
		_dish.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the dish ID of this dish.
	*
	* @return the dish ID of this dish
	*/
	public long getDishId() {
		return _dish.getDishId();
	}

	/**
	* Sets the dish ID of this dish.
	*
	* @param dishId the dish ID of this dish
	*/
	public void setDishId(long dishId) {
		_dish.setDishId(dishId);
	}

	/**
	* Returns the company ID of this dish.
	*
	* @return the company ID of this dish
	*/
	public long getCompanyId() {
		return _dish.getCompanyId();
	}

	/**
	* Sets the company ID of this dish.
	*
	* @param companyId the company ID of this dish
	*/
	public void setCompanyId(long companyId) {
		_dish.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this dish.
	*
	* @return the user ID of this dish
	*/
	public long getUserId() {
		return _dish.getUserId();
	}

	/**
	* Sets the user ID of this dish.
	*
	* @param userId the user ID of this dish
	*/
	public void setUserId(long userId) {
		_dish.setUserId(userId);
	}

	/**
	* Returns the user uuid of this dish.
	*
	* @return the user uuid of this dish
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dish.getUserUuid();
	}

	/**
	* Sets the user uuid of this dish.
	*
	* @param userUuid the user uuid of this dish
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_dish.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this dish.
	*
	* @return the user name of this dish
	*/
	public java.lang.String getUserName() {
		return _dish.getUserName();
	}

	/**
	* Sets the user name of this dish.
	*
	* @param userName the user name of this dish
	*/
	public void setUserName(java.lang.String userName) {
		_dish.setUserName(userName);
	}

	/**
	* Returns the create date of this dish.
	*
	* @return the create date of this dish
	*/
	public java.util.Date getCreateDate() {
		return _dish.getCreateDate();
	}

	/**
	* Sets the create date of this dish.
	*
	* @param createDate the create date of this dish
	*/
	public void setCreateDate(java.util.Date createDate) {
		_dish.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this dish.
	*
	* @return the modified date of this dish
	*/
	public java.util.Date getModifiedDate() {
		return _dish.getModifiedDate();
	}

	/**
	* Sets the modified date of this dish.
	*
	* @param modifiedDate the modified date of this dish
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_dish.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the dish name of this dish.
	*
	* @return the dish name of this dish
	*/
	public java.lang.String getDishName() {
		return _dish.getDishName();
	}

	/**
	* Sets the dish name of this dish.
	*
	* @param dishName the dish name of this dish
	*/
	public void setDishName(java.lang.String dishName) {
		_dish.setDishName(dishName);
	}

	/**
	* Returns the decription of this dish.
	*
	* @return the decription of this dish
	*/
	public java.lang.String getDecription() {
		return _dish.getDecription();
	}

	/**
	* Sets the decription of this dish.
	*
	* @param decription the decription of this dish
	*/
	public void setDecription(java.lang.String decription) {
		_dish.setDecription(decription);
	}

	/**
	* Returns the avatar img of this dish.
	*
	* @return the avatar img of this dish
	*/
	public java.lang.String getAvatarImg() {
		return _dish.getAvatarImg();
	}

	/**
	* Sets the avatar img of this dish.
	*
	* @param avatarImg the avatar img of this dish
	*/
	public void setAvatarImg(java.lang.String avatarImg) {
		_dish.setAvatarImg(avatarImg);
	}

	/**
	* Returns the avatar base code of this dish.
	*
	* @return the avatar base code of this dish
	*/
	public java.lang.String getAvatarBaseCode() {
		return _dish.getAvatarBaseCode();
	}

	/**
	* Sets the avatar base code of this dish.
	*
	* @param avatarBaseCode the avatar base code of this dish
	*/
	public void setAvatarBaseCode(java.lang.String avatarBaseCode) {
		_dish.setAvatarBaseCode(avatarBaseCode);
	}

	/**
	* Returns the detail img of this dish.
	*
	* @return the detail img of this dish
	*/
	public java.lang.String getDetailImg() {
		return _dish.getDetailImg();
	}

	/**
	* Sets the detail img of this dish.
	*
	* @param detailImg the detail img of this dish
	*/
	public void setDetailImg(java.lang.String detailImg) {
		_dish.setDetailImg(detailImg);
	}

	/**
	* Returns the detail base code of this dish.
	*
	* @return the detail base code of this dish
	*/
	public java.lang.String getDetailBaseCode() {
		return _dish.getDetailBaseCode();
	}

	/**
	* Sets the detail base code of this dish.
	*
	* @param detailBaseCode the detail base code of this dish
	*/
	public void setDetailBaseCode(java.lang.String detailBaseCode) {
		_dish.setDetailBaseCode(detailBaseCode);
	}

	/**
	* Returns the detail of this dish.
	*
	* @return the detail of this dish
	*/
	public java.lang.String getDetail() {
		return _dish.getDetail();
	}

	/**
	* Sets the detail of this dish.
	*
	* @param detail the detail of this dish
	*/
	public void setDetail(java.lang.String detail) {
		_dish.setDetail(detail);
	}

	/**
	* Returns the refer price of this dish.
	*
	* @return the refer price of this dish
	*/
	public int getReferPrice() {
		return _dish.getReferPrice();
	}

	/**
	* Sets the refer price of this dish.
	*
	* @param referPrice the refer price of this dish
	*/
	public void setReferPrice(int referPrice) {
		_dish.setReferPrice(referPrice);
	}

	/**
	* Returns the num of diner of this dish.
	*
	* @return the num of diner of this dish
	*/
	public int getNumOfDiner() {
		return _dish.getNumOfDiner();
	}

	/**
	* Sets the num of diner of this dish.
	*
	* @param numOfDiner the num of diner of this dish
	*/
	public void setNumOfDiner(int numOfDiner) {
		_dish.setNumOfDiner(numOfDiner);
	}

	/**
	* Returns the category ID of this dish.
	*
	* @return the category ID of this dish
	*/
	public long getCategoryId() {
		return _dish.getCategoryId();
	}

	/**
	* Sets the category ID of this dish.
	*
	* @param categoryId the category ID of this dish
	*/
	public void setCategoryId(long categoryId) {
		_dish.setCategoryId(categoryId);
	}

	public boolean isNew() {
		return _dish.isNew();
	}

	public void setNew(boolean n) {
		_dish.setNew(n);
	}

	public boolean isCachedModel() {
		return _dish.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_dish.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _dish.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _dish.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_dish.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _dish.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_dish.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new DishWrapper((Dish)_dish.clone());
	}

	public int compareTo(irestads.model.Dish dish) {
		return _dish.compareTo(dish);
	}

	@Override
	public int hashCode() {
		return _dish.hashCode();
	}

	public com.liferay.portal.model.CacheModel<irestads.model.Dish> toCacheModel() {
		return _dish.toCacheModel();
	}

	public irestads.model.Dish toEscapedModel() {
		return new DishWrapper(_dish.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _dish.toString();
	}

	public java.lang.String toXmlString() {
		return _dish.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_dish.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Dish getWrappedDish() {
		return _dish;
	}

	public Dish getWrappedModel() {
		return _dish;
	}

	public void resetOriginalValues() {
		_dish.resetOriginalValues();
	}

	private Dish _dish;
}