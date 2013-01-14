package mybean;

import iRestads.service.CategoryServiceUtil;

public class CategoryBean {
	private String categoryName;
	
	
	public void addCategory(){
		CategoryServiceUtil.createCategory(categoryName);
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	

}
