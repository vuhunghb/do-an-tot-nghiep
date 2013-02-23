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

import irestads.service.AdsItemLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Be
 */
public class AdsItemClp extends BaseModelImpl<AdsItem> implements AdsItem {
	public AdsItemClp() {
	}

	public Class<?> getModelClass() {
		return AdsItem.class;
	}

	public String getModelClassName() {
		return AdsItem.class.getName();
	}

	public long getPrimaryKey() {
		return _adsItemId;
	}

	public void setPrimaryKey(long primaryKey) {
		setAdsItemId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_adsItemId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("adsItemId", getAdsItemId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("companyName", getCompanyName());
		attributes.put("productName", getProductName());
		attributes.put("numberPhone", getNumberPhone());
		attributes.put("email", getEmail());
		attributes.put("address", getAddress());
		attributes.put("facebook", getFacebook());
		attributes.put("twitter", getTwitter());
		attributes.put("description", getDescription());
		attributes.put("imageContent", getImageContent());
		attributes.put("timeDuring", getTimeDuring());
		attributes.put("tags", getTags());
		attributes.put("itemType", getItemType());
		attributes.put("categoryAdsId", getCategoryAdsId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long adsItemId = (Long)attributes.get("adsItemId");

		if (adsItemId != null) {
			setAdsItemId(adsItemId);
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

		String companyName = (String)attributes.get("companyName");

		if (companyName != null) {
			setCompanyName(companyName);
		}

		String productName = (String)attributes.get("productName");

		if (productName != null) {
			setProductName(productName);
		}

		String numberPhone = (String)attributes.get("numberPhone");

		if (numberPhone != null) {
			setNumberPhone(numberPhone);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String address = (String)attributes.get("address");

		if (address != null) {
			setAddress(address);
		}

		String facebook = (String)attributes.get("facebook");

		if (facebook != null) {
			setFacebook(facebook);
		}

		String twitter = (String)attributes.get("twitter");

		if (twitter != null) {
			setTwitter(twitter);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String imageContent = (String)attributes.get("imageContent");

		if (imageContent != null) {
			setImageContent(imageContent);
		}

		Integer timeDuring = (Integer)attributes.get("timeDuring");

		if (timeDuring != null) {
			setTimeDuring(timeDuring);
		}

		String tags = (String)attributes.get("tags");

		if (tags != null) {
			setTags(tags);
		}

		String itemType = (String)attributes.get("itemType");

		if (itemType != null) {
			setItemType(itemType);
		}

		Long categoryAdsId = (Long)attributes.get("categoryAdsId");

		if (categoryAdsId != null) {
			setCategoryAdsId(categoryAdsId);
		}
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

	public BaseModel<?> getAdsItemRemoteModel() {
		return _adsItemRemoteModel;
	}

	public void setAdsItemRemoteModel(BaseModel<?> adsItemRemoteModel) {
		_adsItemRemoteModel = adsItemRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			AdsItemLocalServiceUtil.addAdsItem(this);
		}
		else {
			AdsItemLocalServiceUtil.updateAdsItem(this);
		}
	}

	@Override
	public AdsItem toEscapedModel() {
		return (AdsItem)Proxy.newProxyInstance(AdsItem.class.getClassLoader(),
			new Class[] { AdsItem.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		AdsItemClp clone = new AdsItemClp();

		clone.setAdsItemId(getAdsItemId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setCompanyName(getCompanyName());
		clone.setProductName(getProductName());
		clone.setNumberPhone(getNumberPhone());
		clone.setEmail(getEmail());
		clone.setAddress(getAddress());
		clone.setFacebook(getFacebook());
		clone.setTwitter(getTwitter());
		clone.setDescription(getDescription());
		clone.setImageContent(getImageContent());
		clone.setTimeDuring(getTimeDuring());
		clone.setTags(getTags());
		clone.setItemType(getItemType());
		clone.setCategoryAdsId(getCategoryAdsId());

		return clone;
	}

	public int compareTo(AdsItem adsItem) {
		int value = 0;

		value = getProductName().compareTo(adsItem.getProductName());

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

		AdsItemClp adsItem = null;

		try {
			adsItem = (AdsItemClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = adsItem.getPrimaryKey();

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
		StringBundler sb = new StringBundler(39);

		sb.append("{adsItemId=");
		sb.append(getAdsItemId());
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
		sb.append(", companyName=");
		sb.append(getCompanyName());
		sb.append(", productName=");
		sb.append(getProductName());
		sb.append(", numberPhone=");
		sb.append(getNumberPhone());
		sb.append(", email=");
		sb.append(getEmail());
		sb.append(", address=");
		sb.append(getAddress());
		sb.append(", facebook=");
		sb.append(getFacebook());
		sb.append(", twitter=");
		sb.append(getTwitter());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", imageContent=");
		sb.append(getImageContent());
		sb.append(", timeDuring=");
		sb.append(getTimeDuring());
		sb.append(", tags=");
		sb.append(getTags());
		sb.append(", itemType=");
		sb.append(getItemType());
		sb.append(", categoryAdsId=");
		sb.append(getCategoryAdsId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(61);

		sb.append("<model><model-name>");
		sb.append("irestads.model.AdsItem");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>adsItemId</column-name><column-value><![CDATA[");
		sb.append(getAdsItemId());
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
			"<column><column-name>companyName</column-name><column-value><![CDATA[");
		sb.append(getCompanyName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>productName</column-name><column-value><![CDATA[");
		sb.append(getProductName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>numberPhone</column-name><column-value><![CDATA[");
		sb.append(getNumberPhone());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>email</column-name><column-value><![CDATA[");
		sb.append(getEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>address</column-name><column-value><![CDATA[");
		sb.append(getAddress());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>facebook</column-name><column-value><![CDATA[");
		sb.append(getFacebook());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>twitter</column-name><column-value><![CDATA[");
		sb.append(getTwitter());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>imageContent</column-name><column-value><![CDATA[");
		sb.append(getImageContent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>timeDuring</column-name><column-value><![CDATA[");
		sb.append(getTimeDuring());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tags</column-name><column-value><![CDATA[");
		sb.append(getTags());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>itemType</column-name><column-value><![CDATA[");
		sb.append(getItemType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>categoryAdsId</column-name><column-value><![CDATA[");
		sb.append(getCategoryAdsId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _adsItemId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
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
	private BaseModel<?> _adsItemRemoteModel;
}