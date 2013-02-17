package com.irestads.model;

import java.util.ArrayList;
import java.util.List;

public class CategoryAdsModel {
	long categoryAdsId;
	String categoryAdsName;
	List<AdsItemModel> adsItemModels;

	public CategoryAdsModel(long categoryAdsId, String categoryAdsName, List<AdsItemModel> adsItemModels) {
		super();
		this.categoryAdsId = categoryAdsId;
		this.categoryAdsName = categoryAdsName;
		this.adsItemModels = adsItemModels;
	}

	public CategoryAdsModel() {
		super();
	}

	public long getCategoryAdsId() {
		return categoryAdsId;
	}

	public void setCategoryAdsId(long categoryAdsId) {
		this.categoryAdsId = categoryAdsId;
	}

	public String getCategoryAdsName() {
		return categoryAdsName;
	}

	public void setCategoryAdsName(String categoryAdsName) {
		this.categoryAdsName = categoryAdsName;
	}

	public List<AdsItemModel> getAdsItemModels() {
		return adsItemModels;
	}

	public void setAdsItemModels(List<AdsItemModel> adsItemModels) {
		this.adsItemModels = adsItemModels;
	}

	public static List<CategoryAdsModel> createTest() {
		List<CategoryAdsModel> adsModels = new ArrayList<CategoryAdsModel>();
		CategoryAdsModel adsModel = new CategoryAdsModel(1, "Nhà hàng & Khách sạn", new ArrayList<AdsItemModel>());
		CategoryAdsModel adsModel1 = new CategoryAdsModel(2, "Du lịch", new ArrayList<AdsItemModel>());
		CategoryAdsModel adsModel2 = new CategoryAdsModel(3, "Thời trang", new ArrayList<AdsItemModel>());
		CategoryAdsModel adsModel3 = new CategoryAdsModel(4, "Nội thất", new ArrayList<AdsItemModel>());
		CategoryAdsModel adsModel4 = new CategoryAdsModel(5, "Đồ gia dụng", new ArrayList<AdsItemModel>());
		CategoryAdsModel adsModel5 = new CategoryAdsModel(6, "Giải trí", new ArrayList<AdsItemModel>());
		CategoryAdsModel adsModel6 = new CategoryAdsModel(7, "Đồ công nghệ cao", new ArrayList<AdsItemModel>());
		CategoryAdsModel adsModel7 = new CategoryAdsModel(8, "Khác", new ArrayList<AdsItemModel>());

		adsModels.add(adsModel);
		adsModels.add(adsModel1);
		adsModels.add(adsModel2);
		adsModels.add(adsModel3);
		adsModels.add(adsModel4);
		adsModels.add(adsModel5);
		adsModels.add(adsModel6);
		adsModels.add(adsModel7);
		return adsModels;
	}
}
