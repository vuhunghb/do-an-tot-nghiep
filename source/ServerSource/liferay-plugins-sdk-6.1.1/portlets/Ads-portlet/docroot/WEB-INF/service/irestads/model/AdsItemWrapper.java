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
 * This class is a wrapper for {@link AdsItem}.
 * </p>
 *
 * @author    Be
 * @see       AdsItem
 * @generated
 */
public class AdsItemWrapper implements AdsItem, ModelWrapper<AdsItem> {
	public AdsItemWrapper(AdsItem adsItem) {
		_adsItem = adsItem;
	}

	public Class<?> getModelClass() {
		return AdsItem.class;
	}

	public String getModelClassName() {
		return AdsItem.class.getName();
	}

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

	/**
	* Returns the primary key of this ads item.
	*
	* @return the primary key of this ads item
	*/
	public long getPrimaryKey() {
		return _adsItem.getPrimaryKey();
	}

	/**
	* Sets the primary key of this ads item.
	*
	* @param primaryKey the primary key of this ads item
	*/
	public void setPrimaryKey(long primaryKey) {
		_adsItem.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ads item ID of this ads item.
	*
	* @return the ads item ID of this ads item
	*/
	public long getAdsItemId() {
		return _adsItem.getAdsItemId();
	}

	/**
	* Sets the ads item ID of this ads item.
	*
	* @param adsItemId the ads item ID of this ads item
	*/
	public void setAdsItemId(long adsItemId) {
		_adsItem.setAdsItemId(adsItemId);
	}

	/**
	* Returns the company ID of this ads item.
	*
	* @return the company ID of this ads item
	*/
	public long getCompanyId() {
		return _adsItem.getCompanyId();
	}

	/**
	* Sets the company ID of this ads item.
	*
	* @param companyId the company ID of this ads item
	*/
	public void setCompanyId(long companyId) {
		_adsItem.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this ads item.
	*
	* @return the user ID of this ads item
	*/
	public long getUserId() {
		return _adsItem.getUserId();
	}

	/**
	* Sets the user ID of this ads item.
	*
	* @param userId the user ID of this ads item
	*/
	public void setUserId(long userId) {
		_adsItem.setUserId(userId);
	}

	/**
	* Returns the user uuid of this ads item.
	*
	* @return the user uuid of this ads item
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _adsItem.getUserUuid();
	}

	/**
	* Sets the user uuid of this ads item.
	*
	* @param userUuid the user uuid of this ads item
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_adsItem.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this ads item.
	*
	* @return the user name of this ads item
	*/
	public java.lang.String getUserName() {
		return _adsItem.getUserName();
	}

	/**
	* Sets the user name of this ads item.
	*
	* @param userName the user name of this ads item
	*/
	public void setUserName(java.lang.String userName) {
		_adsItem.setUserName(userName);
	}

	/**
	* Returns the create date of this ads item.
	*
	* @return the create date of this ads item
	*/
	public java.util.Date getCreateDate() {
		return _adsItem.getCreateDate();
	}

	/**
	* Sets the create date of this ads item.
	*
	* @param createDate the create date of this ads item
	*/
	public void setCreateDate(java.util.Date createDate) {
		_adsItem.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this ads item.
	*
	* @return the modified date of this ads item
	*/
	public java.util.Date getModifiedDate() {
		return _adsItem.getModifiedDate();
	}

	/**
	* Sets the modified date of this ads item.
	*
	* @param modifiedDate the modified date of this ads item
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_adsItem.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the company name of this ads item.
	*
	* @return the company name of this ads item
	*/
	public java.lang.String getCompanyName() {
		return _adsItem.getCompanyName();
	}

	/**
	* Sets the company name of this ads item.
	*
	* @param companyName the company name of this ads item
	*/
	public void setCompanyName(java.lang.String companyName) {
		_adsItem.setCompanyName(companyName);
	}

	/**
	* Returns the product name of this ads item.
	*
	* @return the product name of this ads item
	*/
	public java.lang.String getProductName() {
		return _adsItem.getProductName();
	}

	/**
	* Sets the product name of this ads item.
	*
	* @param productName the product name of this ads item
	*/
	public void setProductName(java.lang.String productName) {
		_adsItem.setProductName(productName);
	}

	/**
	* Returns the number phone of this ads item.
	*
	* @return the number phone of this ads item
	*/
	public java.lang.String getNumberPhone() {
		return _adsItem.getNumberPhone();
	}

	/**
	* Sets the number phone of this ads item.
	*
	* @param numberPhone the number phone of this ads item
	*/
	public void setNumberPhone(java.lang.String numberPhone) {
		_adsItem.setNumberPhone(numberPhone);
	}

	/**
	* Returns the email of this ads item.
	*
	* @return the email of this ads item
	*/
	public java.lang.String getEmail() {
		return _adsItem.getEmail();
	}

	/**
	* Sets the email of this ads item.
	*
	* @param email the email of this ads item
	*/
	public void setEmail(java.lang.String email) {
		_adsItem.setEmail(email);
	}

	/**
	* Returns the address of this ads item.
	*
	* @return the address of this ads item
	*/
	public java.lang.String getAddress() {
		return _adsItem.getAddress();
	}

	/**
	* Sets the address of this ads item.
	*
	* @param address the address of this ads item
	*/
	public void setAddress(java.lang.String address) {
		_adsItem.setAddress(address);
	}

	/**
	* Returns the facebook of this ads item.
	*
	* @return the facebook of this ads item
	*/
	public java.lang.String getFacebook() {
		return _adsItem.getFacebook();
	}

	/**
	* Sets the facebook of this ads item.
	*
	* @param facebook the facebook of this ads item
	*/
	public void setFacebook(java.lang.String facebook) {
		_adsItem.setFacebook(facebook);
	}

	/**
	* Returns the twitter of this ads item.
	*
	* @return the twitter of this ads item
	*/
	public java.lang.String getTwitter() {
		return _adsItem.getTwitter();
	}

	/**
	* Sets the twitter of this ads item.
	*
	* @param twitter the twitter of this ads item
	*/
	public void setTwitter(java.lang.String twitter) {
		_adsItem.setTwitter(twitter);
	}

	/**
	* Returns the description of this ads item.
	*
	* @return the description of this ads item
	*/
	public java.lang.String getDescription() {
		return _adsItem.getDescription();
	}

	/**
	* Sets the description of this ads item.
	*
	* @param description the description of this ads item
	*/
	public void setDescription(java.lang.String description) {
		_adsItem.setDescription(description);
	}

	/**
	* Returns the image content of this ads item.
	*
	* @return the image content of this ads item
	*/
	public java.lang.String getImageContent() {
		return _adsItem.getImageContent();
	}

	/**
	* Sets the image content of this ads item.
	*
	* @param imageContent the image content of this ads item
	*/
	public void setImageContent(java.lang.String imageContent) {
		_adsItem.setImageContent(imageContent);
	}

	/**
	* Returns the time during of this ads item.
	*
	* @return the time during of this ads item
	*/
	public int getTimeDuring() {
		return _adsItem.getTimeDuring();
	}

	/**
	* Sets the time during of this ads item.
	*
	* @param timeDuring the time during of this ads item
	*/
	public void setTimeDuring(int timeDuring) {
		_adsItem.setTimeDuring(timeDuring);
	}

	/**
	* Returns the tags of this ads item.
	*
	* @return the tags of this ads item
	*/
	public java.lang.String getTags() {
		return _adsItem.getTags();
	}

	/**
	* Sets the tags of this ads item.
	*
	* @param tags the tags of this ads item
	*/
	public void setTags(java.lang.String tags) {
		_adsItem.setTags(tags);
	}

	/**
	* Returns the item type of this ads item.
	*
	* @return the item type of this ads item
	*/
	public java.lang.String getItemType() {
		return _adsItem.getItemType();
	}

	/**
	* Sets the item type of this ads item.
	*
	* @param itemType the item type of this ads item
	*/
	public void setItemType(java.lang.String itemType) {
		_adsItem.setItemType(itemType);
	}

	/**
	* Returns the category ads ID of this ads item.
	*
	* @return the category ads ID of this ads item
	*/
	public long getCategoryAdsId() {
		return _adsItem.getCategoryAdsId();
	}

	/**
	* Sets the category ads ID of this ads item.
	*
	* @param categoryAdsId the category ads ID of this ads item
	*/
	public void setCategoryAdsId(long categoryAdsId) {
		_adsItem.setCategoryAdsId(categoryAdsId);
	}

	public boolean isNew() {
		return _adsItem.isNew();
	}

	public void setNew(boolean n) {
		_adsItem.setNew(n);
	}

	public boolean isCachedModel() {
		return _adsItem.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_adsItem.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _adsItem.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _adsItem.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_adsItem.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _adsItem.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_adsItem.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new AdsItemWrapper((AdsItem)_adsItem.clone());
	}

	public int compareTo(irestads.model.AdsItem adsItem) {
		return _adsItem.compareTo(adsItem);
	}

	@Override
	public int hashCode() {
		return _adsItem.hashCode();
	}

	public com.liferay.portal.model.CacheModel<irestads.model.AdsItem> toCacheModel() {
		return _adsItem.toCacheModel();
	}

	public irestads.model.AdsItem toEscapedModel() {
		return new AdsItemWrapper(_adsItem.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _adsItem.toString();
	}

	public java.lang.String toXmlString() {
		return _adsItem.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_adsItem.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public AdsItem getWrappedAdsItem() {
		return _adsItem;
	}

	public AdsItem getWrappedModel() {
		return _adsItem;
	}

	public void resetOriginalValues() {
		_adsItem.resetOriginalValues();
	}

	private AdsItem _adsItem;
}