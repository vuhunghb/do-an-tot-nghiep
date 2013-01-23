package irestads.beans.dishs_store;

import irestads.model.Category;
import irestads.service.CategoryServiceUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CategoryBeans implements Serializable {
	private String categoryName;
	private List<Category> categorys;

	public String getCategoryNameByID(long categoryId) {
		System.out.println("Category ID " + categoryId);
		int count = CategoryServiceUtil.countCategoryById(categoryId);
		if (count != 0) {
			System.out.println("co category");
			Category c = CategoryServiceUtil.findByID(categoryId);
			return c.getCategoryName();
		}
		return "";
		// if(this.dishs.size()>0){
		// Category c = CategoryServiceUtil.findByID(categoryId);
		// return c.getCategoryName();
		// }
		// return "";
	}

	public CategoryBeans() {
		this.categorys = new ArrayList<Category>();
	}

	public void addCategory() {
		CategoryServiceUtil.createCategory(categoryName);
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<Category> getCategorys() {
		this.categorys = CategoryServiceUtil.getAllCategorys();
		return this.categorys;
	}

	public void setCategorys(List<Category> categorys) {
		this.categorys = categorys;
	}

}