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
 * This class is used by SOAP remote services, specifically {@link irestads.service.http.AdsItemServiceSoap}.
 *
 * @author    Be
 * @see       irestads.service.http.AdsItemServiceSoap
 * @generated
 */
public class AdsItemSoap implements Serializable {
	public static AdsItemSoap toSoapModel(AdsItem model) {
		AdsItemSoap soapModel = new AdsItemSoap();

		soapModel.setAdsItemId(model.getAdsItemId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCompanyName(model.getCompanyName());
		soapModel.setProductName(model.getProductName());
		soapModel.setNumberPhone(model.getNumberPhone());
		soapModel.setEmail(model.getEmail());
		soapModel.setAddress(model.getAddress());
		soapModel.setFacebook(model.getFacebook());
		soapModel.setTwitter(model.getTwitter());
		soapModel.setDescription(model.getDescription());
		soapModel.setImageContent(model.getImageContent());
		soapModel.setTimeDuring(model.getTimeDuring());
		soapModel.setTags(model.getTags());
		soapModel.setItemType(model.getItemType());
		soapModel.setCategoryAdsId(model.getCategoryAdsId());

		return soapModel;
	}

	public static AdsItemSoap[] toSoapModels(AdsItem[] models) {
		AdsItemSoap[] soapModels = new AdsItemSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AdsItemSoap[][] toSoapModels(AdsItem[][] models) {
		AdsItemSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AdsItemSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AdsItemSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AdsItemSoap[] toSoapModels(List<AdsItem> models) {
		List<AdsItemSoap> soapModels = new ArrayList<AdsItemSoap>(models.size());

		for (AdsItem model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AdsItemSoap[soapModels.size()]);
	}

	public AdsItemSoap() {
	}

	public long getPrimaryKey() {
		return _adsItemId;
	}

	public void setPrimaryKey(long pk) {
		setAdsItemId(pk);
	}

	public long getAdsItemId() {
		return _adsItemId;
	}

	public void setAdsItemId(long adsItemId) {
		_adsItemId = adsItemId;
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

	public String getCompanyName() {
		return _companyName;
	}

	public void setCompanyName(String companyName) {
		_companyName = companyName;
	}

	public String getProductName() {
		return _productName;
	}

	public void setProductName(String productName) {
		_productName = productName;
	}

	public String getNumberPhone() {
		return _numberPhone;
	}

	public void setNumberPhone(String numberPhone) {
		_numberPhone = numberPhone;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public String getAddress() {
		return _address;
	}

	public void setAddress(String address) {
		_address = address;
	}

	public String getFacebook() {
		return _facebook;
	}

	public void setFacebook(String facebook) {
		_facebook = facebook;
	}

	public String getTwitter() {
		return _twitter;
	}

	public void setTwitter(String twitter) {
		_twitter = twitter;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getImageContent() {
		return _imageContent;
	}

	public void setImageContent(String imageContent) {
		_imageContent = imageContent;
	}

	public int getTimeDuring() {
		return _timeDuring;
	}

	public void setTimeDuring(int timeDuring) {
		_timeDuring = timeDuring;
	}

	public String getTags() {
		return _tags;
	}

	public void setTags(String tags) {
		_tags = tags;
	}

	public String getItemType() {
		return _itemType;
	}

	public void setItemType(String itemType) {
		_itemType = itemType;
	}

	public long getCategoryAdsId() {
		return _categoryAdsId;
	}

	public void setCategoryAdsId(long categoryAdsId) {
		_categoryAdsId = categoryAdsId;
	}

	private long _adsItemId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _companyName;
	private String _productName;
	private String _numberPhone;
	private String _email;
	private String _address;
	private String _facebook;
	private String _twitter;
	private String _description;
	private String _imageContent;
	private int _timeDuring;
	private String _tags;
	private String _itemType;
	private long _categoryAdsId;
}