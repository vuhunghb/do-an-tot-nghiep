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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link irestads.service.http.CategoryAdsServiceSoap}.
 *
 * @author    Be
 * @see       irestads.service.http.CategoryAdsServiceSoap
 * @generated
 */
public class CategoryAdsSoap implements Serializable {
	public static CategoryAdsSoap toSoapModel(CategoryAds model) {
		CategoryAdsSoap soapModel = new CategoryAdsSoap();

		soapModel.setCategoryAdsId(model.getCategoryAdsId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCategoryAdsName(model.getCategoryAdsName());

		return soapModel;
	}

	public static CategoryAdsSoap[] toSoapModels(CategoryAds[] models) {
		CategoryAdsSoap[] soapModels = new CategoryAdsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CategoryAdsSoap[][] toSoapModels(CategoryAds[][] models) {
		CategoryAdsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CategoryAdsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CategoryAdsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CategoryAdsSoap[] toSoapModels(List<CategoryAds> models) {
		List<CategoryAdsSoap> soapModels = new ArrayList<CategoryAdsSoap>(models.size());

		for (CategoryAds model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CategoryAdsSoap[soapModels.size()]);
	}

	public CategoryAdsSoap() {
	}

	public long getPrimaryKey() {
		return _categoryAdsId;
	}

	public void setPrimaryKey(long pk) {
		setCategoryAdsId(pk);
	}

	public long getCategoryAdsId() {
		return _categoryAdsId;
	}

	public void setCategoryAdsId(long categoryAdsId) {
		_categoryAdsId = categoryAdsId;
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

	public String getCategoryAdsName() {
		return _categoryAdsName;
	}

	public void setCategoryAdsName(String categoryAdsName) {
		_categoryAdsName = categoryAdsName;
	}

	private long _categoryAdsId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _categoryAdsName;
}