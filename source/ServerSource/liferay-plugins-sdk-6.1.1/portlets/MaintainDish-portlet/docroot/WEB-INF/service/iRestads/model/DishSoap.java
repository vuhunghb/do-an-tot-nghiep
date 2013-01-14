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

package iRestads.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link iRestads.service.http.DishServiceSoap}.
 *
 * @author    Be
 * @see       iRestads.service.http.DishServiceSoap
 * @generated
 */
public class DishSoap implements Serializable {
	public static DishSoap toSoapModel(Dish model) {
		DishSoap soapModel = new DishSoap();

		soapModel.setDishId(model.getDishId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setDishName(model.getDishName());
		soapModel.setDecription(model.getDecription());
		soapModel.setAvatarImg(model.getAvatarImg());
		soapModel.setDetailImg(model.getDetailImg());
		soapModel.setDetail(model.getDetail());
		soapModel.setReferPrice(model.getReferPrice());
		soapModel.setCategoryId(model.getCategoryId());
		soapModel.setEditTable(model.getEditTable());

		return soapModel;
	}

	public static DishSoap[] toSoapModels(Dish[] models) {
		DishSoap[] soapModels = new DishSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DishSoap[][] toSoapModels(Dish[][] models) {
		DishSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DishSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DishSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DishSoap[] toSoapModels(List<Dish> models) {
		List<DishSoap> soapModels = new ArrayList<DishSoap>(models.size());

		for (Dish model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DishSoap[soapModels.size()]);
	}

	public DishSoap() {
	}

	public long getPrimaryKey() {
		return _dishId;
	}

	public void setPrimaryKey(long pk) {
		setDishId(pk);
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

	public double getReferPrice() {
		return _referPrice;
	}

	public void setReferPrice(double referPrice) {
		_referPrice = referPrice;
	}

	public long getCategoryId() {
		return _categoryId;
	}

	public void setCategoryId(long categoryId) {
		_categoryId = categoryId;
	}

	public boolean getEditTable() {
		return _editTable;
	}

	public boolean isEditTable() {
		return _editTable;
	}

	public void setEditTable(boolean editTable) {
		_editTable = editTable;
	}

	private long _dishId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _dishName;
	private String _decription;
	private String _avatarImg;
	private String _detailImg;
	private String _detail;
	private double _referPrice;
	private long _categoryId;
	private boolean _editTable;
}