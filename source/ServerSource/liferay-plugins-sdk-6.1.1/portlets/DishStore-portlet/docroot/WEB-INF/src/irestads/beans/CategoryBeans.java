package irestads.beans;

import irestads.model.Category;
import irestads.service.CategoryServiceUtil;

import java.util.ArrayList;
import java.util.List;

public class CategoryBeans {
	private String categoryName;
	private List<Category> categorys;
	
	public CategoryBeans(){
		this.categorys=new ArrayList<Category>();
	}
	public void addCategory(){
		CategoryServiceUtil.createCategory(categoryName);
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public List<Category> getCategorys() {
		this.categorys=CategoryServiceUtil.getAllCategorys() ;
		return this.categorys;
	}
	public void setCategorys(List<Category> categorys) {
		this.categorys = categorys;
	}
	public String getCategoryNameByID(long categoryId){
		System.out.println("Category ID "+categoryId);
		Category c=CategoryServiceUtil.findByID(categoryId);
		return c.getCategoryName();
	}
	
	
	
}
