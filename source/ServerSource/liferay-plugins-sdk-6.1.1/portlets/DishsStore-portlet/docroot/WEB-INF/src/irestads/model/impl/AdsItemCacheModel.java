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

package irestads.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import irestads.model.AdsItem;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing AdsItem in entity cache.
 *
 * @author Be
 * @see AdsItem
 * @generated
 */
public class AdsItemCacheModel implements CacheModel<AdsItem>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(39);

		sb.append("{adsItemId=");
		sb.append(adsItemId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", companyName=");
		sb.append(companyName);
		sb.append(", productName=");
		sb.append(productName);
		sb.append(", numberPhone=");
		sb.append(numberPhone);
		sb.append(", email=");
		sb.append(email);
		sb.append(", address=");
		sb.append(address);
		sb.append(", facebook=");
		sb.append(facebook);
		sb.append(", twitter=");
		sb.append(twitter);
		sb.append(", description=");
		sb.append(description);
		sb.append(", imageContent=");
		sb.append(imageContent);
		sb.append(", timeDuring=");
		sb.append(timeDuring);
		sb.append(", tags=");
		sb.append(tags);
		sb.append(", itemType=");
		sb.append(itemType);
		sb.append(", categoryAdsId=");
		sb.append(categoryAdsId);
		sb.append("}");

		return sb.toString();
	}

	public AdsItem toEntityModel() {
		AdsItemImpl adsItemImpl = new AdsItemImpl();

		adsItemImpl.setAdsItemId(adsItemId);
		adsItemImpl.setCompanyId(companyId);
		adsItemImpl.setUserId(userId);

		if (userName == null) {
			adsItemImpl.setUserName(StringPool.BLANK);
		}
		else {
			adsItemImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			adsItemImpl.setCreateDate(null);
		}
		else {
			adsItemImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			adsItemImpl.setModifiedDate(null);
		}
		else {
			adsItemImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (companyName == null) {
			adsItemImpl.setCompanyName(StringPool.BLANK);
		}
		else {
			adsItemImpl.setCompanyName(companyName);
		}

		if (productName == null) {
			adsItemImpl.setProductName(StringPool.BLANK);
		}
		else {
			adsItemImpl.setProductName(productName);
		}

		if (numberPhone == null) {
			adsItemImpl.setNumberPhone(StringPool.BLANK);
		}
		else {
			adsItemImpl.setNumberPhone(numberPhone);
		}

		if (email == null) {
			adsItemImpl.setEmail(StringPool.BLANK);
		}
		else {
			adsItemImpl.setEmail(email);
		}

		if (address == null) {
			adsItemImpl.setAddress(StringPool.BLANK);
		}
		else {
			adsItemImpl.setAddress(address);
		}

		if (facebook == null) {
			adsItemImpl.setFacebook(StringPool.BLANK);
		}
		else {
			adsItemImpl.setFacebook(facebook);
		}

		if (twitter == null) {
			adsItemImpl.setTwitter(StringPool.BLANK);
		}
		else {
			adsItemImpl.setTwitter(twitter);
		}

		if (description == null) {
			adsItemImpl.setDescription(StringPool.BLANK);
		}
		else {
			adsItemImpl.setDescription(description);
		}

		if (imageContent == null) {
			adsItemImpl.setImageContent(StringPool.BLANK);
		}
		else {
			adsItemImpl.setImageContent(imageContent);
		}

		adsItemImpl.setTimeDuring(timeDuring);

		if (tags == null) {
			adsItemImpl.setTags(StringPool.BLANK);
		}
		else {
			adsItemImpl.setTags(tags);
		}

		if (itemType == null) {
			adsItemImpl.setItemType(StringPool.BLANK);
		}
		else {
			adsItemImpl.setItemType(itemType);
		}

		adsItemImpl.setCategoryAdsId(categoryAdsId);

		adsItemImpl.resetOriginalValues();

		return adsItemImpl;
	}

	public long adsItemId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String companyName;
	public String productName;
	public String numberPhone;
	public String email;
	public String address;
	public String facebook;
	public String twitter;
	public String description;
	public String imageContent;
	public int timeDuring;
	public String tags;
	public String itemType;
	public long categoryAdsId;
}