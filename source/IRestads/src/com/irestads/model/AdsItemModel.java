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

	public static List<AdsItemModel> createTestData(Activity activity) {
		List<AdsItemModel> adsItemModels = new ArrayList<AdsItemModel>();

		Bitmap bitmap1 = BitmapFactory.decodeResource(activity.getResources(), R.drawable.img1);

		Bitmap bitmap2 = BitmapFactory.decodeResource(activity.getResources(), R.drawable.img2);

		Bitmap bitmap3 = BitmapFactory.decodeResource(activity.getResources(), R.drawable.img3);

		Bitmap bitmap4 = BitmapFactory.decodeResource(activity.getResources(), R.drawable.img4);

		Bitmap bitmap5 = BitmapFactory.decodeResource(activity.getResources(), R.drawable.img5);

		AdsItemModel adsItemModel = new AdsItemNormalModel(
				0,
				"ABC 0",
				"0808080808",
				"hoangtuan877@gmail.com",
				"7/77 KP1 BH DN",
				"http://www.facebook.com/ABC0",
				"https://twitter.com/ABC0",
				"chúc mọi người luôn vui, sớm chính thức trở thành kỹ sư và tìm đc việc tốt ! cảm ơn lời chúc của mọi người",
				ImageUtils.convertBitmapToArrayBite(bitmap1), 30, "San Pham 1", "A,B,C,D,E,F,G", 3);
		AdsItemModel adsItemModel1 = new AdsItemNormalModel(
				1,
				"ABC 1",
				"0808080808",
				"ABCDEF@gmail.com",
				"7/77 KP1 BH DN 1",
				"http://www.facebook.com/ABC1",
				"https://twitter.com/ABC1",
				"chúc mọi người luôn vui, sớm chính thức trở thành kỹ sư và tìm đc việc tốt ! cảm ơn lời chúc của mọi người",
				ImageUtils.convertBitmapToArrayBite(bitmap2), 10, "San Pham 2", "A,B,C,D,E,F,G", 4);
		AdsItemModel adsItemModel2 = new AdsItemContextModel(
				2,
				"ABC 2",
				"0808080808",
				"ABCDEF@gmail.com",
				"7/77 KP1 BH DN 2",
				"http://www.facebook.com/ABC2",
				"https://twitter.com/ABC2",
				"chúc mọi người luôn vui, sớm chính thức trở thành kỹ sư và tìm đc việc tốt ! cảm ơn lời chúc của mọi người",
				ImageUtils.convertBitmapToArrayBite(bitmap3), 60, "San Pham 3", "A,B,C,D,E,F,G", 3);
		AdsItemModel adsItemModel3 = new AdsItemNormalModel(
				3,
				"ABC 3",
				"0808080808",
				"ABCDEF@gmail.com",
				"7/77 KP1 BH DN 3",
				"http://www.facebook.com/ABC3",
				"https://twitter.com/ABC3",
				"chúc mọi người luôn vui, sớm chính thức trở thành kỹ sư và tìm đc việc tốt ! cảm ơn lời chúc của mọi người",
				ImageUtils.convertBitmapToArrayBite(bitmap4), 30, "San Pham 4", "A,B,C,D,E,F,G", 3);
		AdsItemModel adsItemModel4 = new AdsItemContextModel(
				4,
				"ABC 4",
				"0808080808",
				"ABCDEF@gmail.com",
				"7/77 KP1 BH DN 4",
				"http://www.facebook.com/ABC4",
				"https://twitter.com/ABC4",
				"chúc mọi người luôn vui, sớm chính thức trở thành kỹ sư và tìm đc việc tốt ! cảm ơn lời chúc của mọi người",
				ImageUtils.convertBitmapToArrayBite(bitmap5), 20, "San Pham 5", "A,B,C,D,E,F,G", 2);
		adsItemModels.add(adsItemModel);
		adsItemModels.add(adsItemModel1);
		adsItemModels.add(adsItemModel2);
		adsItemModels.add(adsItemModel3);
		adsItemModels.add(adsItemModel4);

		return adsItemModels;
	}
}
