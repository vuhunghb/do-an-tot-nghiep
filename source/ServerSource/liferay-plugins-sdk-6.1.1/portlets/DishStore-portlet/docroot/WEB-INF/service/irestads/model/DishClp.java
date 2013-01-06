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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import irestads.service.DishLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Be
 */
public class DishClp extends BaseModelImpl<Dish> implements Dish {
	public DishClp() {
	}

	public Class<?> getModelClass() {
		return Dish.class;
	}

	public String getModelClassName() {
		return Dish.class.getName();
	}

	public long getPrimaryKey() {
		return _dishId;
	}

	public void setPrimaryKey(long primaryKey) {
		setDishId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_dishId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
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
		attributes.put("detailImg", getDetailImg());
		attributes.put("detail", getDetail());
		attributes.put("referPrice", getReferPrice());
		attributes.put("numOfDiner", getNumOfDiner());
		attributes.put("categoryId", getCategoryId());

		return attributes;
	}

	@Override
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

		String detailImg = (String)attributes.get("detailImg");

		if (detailImg != null) {
			setDetailImg(detailImg);
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

	public long getDishId() {
		return _dishId;
	}

	public void setDishId(long dishId) {
		_dishId = dishId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getDishName() {
		return _dishName;
	}

	public void setDishName(String dishName) {
		_dishName = dishName;
	}

	public String getDecription() {
		return _decription;
	}

	public void setDecription(String decription) {
		_decription = decription;
	}

	public String getAvatarImg() {
		return _avatarImg;
	}

	public void setAvatarImg(String avatarImg) {
		_avatarImg = avatarImg;
	}

	public String getDetailImg() {
		return _detailImg;
	}

	public void setDetailImg(String detailImg) {
		_detailImg = detailImg;
	}

	public String getDetail() {
		return _detail;
	}

	public void setDetail(String detail) {
		_detail = detail;
	}

	public int getReferPrice() {
		return _referPrice;
	}

	public void setReferPrice(int referPrice) {
		_referPrice = referPrice;
	}

	public int getNumOfDiner() {
		return _numOfDiner;
	}

	public void setNumOfDiner(int numOfDiner) {
		_numOfDiner = numOfDiner;
	}

	public long getCategoryId() {
		return _categoryId;
	}

	public void setCategoryId(long categoryId) {
		_categoryId = categoryId;
	}

	public BaseModel<?> getDishRemoteModel() {
		return _dishRemoteModel;
	}

	public void setDishRemoteModel(BaseModel<?> dishRemoteModel) {
		_dishRemoteModel = dishRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			DishLocalServiceUtil.addDish(this);
		}
		else {
			DishLocalServiceUtil.updateDish(this);
		}
	}

	@Override
	public Dish toEscapedModel() {
		return (Dish)Proxy.newProxyInstance(Dish.class.getClassLoader(),
			new Class[] { Dish.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		DishClp clone = new DishClp();

		clone.setDishId(getDishId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setDishName(getDishName());
		clone.setDecription(getDecription());
		clone.setAvatarImg(getAvatarImg());
		clone.setDetailImg(getDetailImg());
		clone.setDetail(getDetail());
		clone.setReferPrice(getReferPrice());
		clone.setNumOfDiner(getNumOfDiner());
		clone.setCategoryId(getCategoryId());

		return clone;
	}

	public int compareTo(Dish dish) {
		int value = 0;

		value = getDishName().compareTo(dish.getDishName());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		DishClp dish = null;

		try {
			dish = (DishClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = dish.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{dishId=");
		sb.append(getDishId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", dishName=");
		sb.append(getDishName());
		sb.append(", decription=");
		sb.append(getDecription());
		sb.append(", avatarImg=");
		sb.append(getAvatarImg());
		sb.append(", detailImg=");
		sb.append(getDetailImg());
		sb.append(", detail=");
		sb.append(getDetail());
		sb.append(", referPrice=");
		sb.append(getReferPrice());
		sb.append(", numOfDiner=");
		sb.append(getNumOfDiner());
		sb.append(", categoryId=");
		sb.append(getCategoryId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(46);

		sb.append("<model><model-name>");
		sb.append("irestads.model.Dish");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>dishId</column-name><column-value><![CDATA[");
		sb.append(getDishId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dishName</column-name><column-value><![CDATA[");
		sb.append(getDishName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>decription</column-name><column-value><![CDATA[");
		sb.append(getDecription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>avatarImg</column-name><column-value><![CDATA[");
		sb.append(getAvatarImg());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>detailImg</column-name><column-value><![CDATA[");
		sb.append(getDetailImg());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>detail</column-name><column-value><![CDATA[");
		sb.append(getDetail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>referPrice</column-name><column-value><![CDATA[");
		sb.append(getReferPrice());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>numOfDiner</column-name><column-value><![CDATA[");
		sb.append(getNumOfDiner());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>categoryId</column-name><column-value><![CDATA[");
		sb.append(getCategoryId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _dishId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _dishName;
	private String _decription;
	private String _avatarImg;
	private String _detailImg;
	private String _detail;
	private int _referPrice;
	private int _numOfDiner;
	private long _categoryId;
	private BaseModel<?> _dishRemoteModel;
}