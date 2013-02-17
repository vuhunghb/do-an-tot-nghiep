package com.irestads.model;

import java.util.ArrayList;
import java.util.List;

public class AdsItemContextModel extends AdsItemModel {

	List<AdsItemModel> adsItemTags;

	public AdsItemContextModel(long adsItemId, String companyName, String numberPhone, String email, String address,
			String facebook, String twitter, String description, byte[] imageContent, int timeDuring,
			String productName, String tags,long categoryAdsId ) {
		// TODO Auto-generated constructor stub
		super(adsItemId, companyName, numberPhone, email, address, facebook, twitter, description, imageContent,
				timeDuring, productName, tags, AdsItemContextModel.class.toString(),categoryAdsId);
		adsItemTags = new ArrayList<AdsItemModel>();
	}

	@Override
	public List<AdsItemModel> getAdsItemTags() {
		// TODO Auto-generated method stub
		return adsItemTags;
	}

	@Override
	public void setAdsItemTags(List<AdsItemModel> adsItemTags) {
		// TODO Auto-generated method stub
		this.adsItemTags = adsItemTags;
	}

}
