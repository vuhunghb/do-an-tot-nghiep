package com.irestads.model;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.irestads.R;
import com.irestads.util.ImageUtils;

public abstract class AdsItemModel {
	long adsItemId;
	String companyName, productName;
	String numberPhone, email, address, facebook, twitter;
	String description;
	byte[] imageContent;
	int timeDuring;
	String tags;
	String itemType;
	long categoryAdsId;
	
	public AdsItemModel(long adsItemId, String companyName, String numberPhone, String email, String address,
			String facebook, String twitter, String description, byte[] imageContent, int timeDuring,
			String productName, String tags, String itemType, long categoryAdsId) {
		super();
		this.adsItemId = adsItemId;
		this.companyName = companyName;
		this.numberPhone = numberPhone;
		this.email = email;
		this.address = address;
		this.facebook = facebook;
		this.twitter = twitter;
		this.description = description;
		this.imageContent = imageContent;
		this.productName = productName;
		this.timeDuring = timeDuring;
		this.tags = tags;
		this.itemType = itemType;
		this.categoryAdsId = categoryAdsId;
	}

	public long getCategoryAdsId() {
		return categoryAdsId;
	}

	public void setCategoryAdsId(long categoryAdsId) {
		this.categoryAdsId = categoryAdsId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getTimeDuring() {
		return timeDuring;
	}

	public void setTimeDuring(int timeDuring) {
		this.timeDuring = timeDuring;
	}

	public AdsItemModel() {
		super();
	}

	public long getAdsItemId() {
		return adsItemId;
	}

	public void setAdsItemId(long adsItemId) {
		this.adsItemId = adsItemId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getNumberPhone() {
		return numberPhone;
	}

	public void setNumberPhone(String numberPhone) {
		this.numberPhone = numberPhone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getTwitter() {
		return twitter;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte[] getImageContent() {
		return imageContent;
	}

	public void setImageContent(byte[] imageContent) {
		this.imageContent = imageContent;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public abstract List<AdsItemModel> getAdsItemTags();

	public abstract void setAdsItemTags(List<AdsItemModel> adsItemTags);

}
