package com.irestads.model;

import java.util.List;

public class AdsItemNormalModel extends AdsItemModel {

	public AdsItemNormalModel(long adsItemId, String companyName, String numberPhone, String email, String address,
			String facebook, String twitter, String description, byte[] imageContent, int timeDuring,
			String productName, String tags, long categoryAdsId ) {
		// TODO Auto-generated constructor stub
		super(adsItemId, companyName, numberPhone, email, address, facebook, twitter, description, imageContent,
				timeDuring, productName, tags, AdsItemNormalModel.class.toString(), categoryAdsId);
	}

	@Override
	public List<AdsItemModel> getAdsItemTags() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setAdsItemTags(List<AdsItemModel> adsItemTags) {
		// TODO Auto-generated method stub

	}

}
