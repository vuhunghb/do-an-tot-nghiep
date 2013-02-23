package irestads.beans.ads;


import irestads.model.CategoryAds;
import irestads.service.CategoryAdsServiceUtil;

import java.io.Serializable;

import java.util.List;

public class CategoryAdsBeans implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public List<CategoryAds> getCategoryAds() {
		return categoryAds;
	}

	public void setCategoryAds(List<CategoryAds> categoryAds) {
		this.categoryAds = categoryAds;
	}
	private List<CategoryAds> categoryAds;
	public CategoryAdsBeans() {
		this.getAllCategoryAds();
		System.out.println("ca"+categoryAds.size());
	}

	public String getCategoryAdsNameByID(long categoryId) {
		CategoryAds c = CategoryAdsServiceUtil.findById(categoryId);
		 if(c!=null){
		 return c.getCategoryAdsName();
		 }
		 return "";
	}
	public void getAllCategoryAds(){
		this.categoryAds=CategoryAdsServiceUtil.getAddCategoryAds();
	}


}

