package com.irestads.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.irestads.util.ImageUtils;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class CategoryModel {
	long categoryId;
	String categoryName;
	List<DishModel> dishs;

	public CategoryModel(long categoryId, String categoryName, List<DishModel> dishs) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.dishs = dishs;
	}

	public CategoryModel() {
		super();
		this.dishs = new ArrayList<DishModel>();
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<DishModel> getDishs() {
		return dishs;
	}

	public void setDishs(List<DishModel> dishs) {
		this.dishs = dishs;
	}

	public void addDish(DishModel dish) {
		this.dishs.add(dish);
		dish.setCategory(this);
	}

	public void removeDish(DishModel dish) {
		this.dishs.remove(dish);
		dish.setCategory(null);
	}

	public static List<CategoryModel> testData() {
		List<CategoryModel> categories = new ArrayList<CategoryModel>();
		CategoryModel categoryModel = new CategoryModel(1, "Khai vị", new ArrayList<DishModel>());
		CategoryModel categoryModel1 = new CategoryModel(2, "Món chính", new ArrayList<DishModel>());
		CategoryModel categoryModel2 = new CategoryModel(3, "Nước uống", new ArrayList<DishModel>());
		CategoryModel categoryModel3 = new CategoryModel(4, "Món ăn nhanh", new ArrayList<DishModel>());
		CategoryModel categoryModel4 = new CategoryModel(5, "Điểm tâm", new ArrayList<DishModel>());
		CategoryModel categoryModel5 = new CategoryModel(5, "Món chiên", new ArrayList<DishModel>());
		categories.add(categoryModel);
		categories.add(categoryModel1);
		categories.add(categoryModel2);
		categories.add(categoryModel3);
		categories.add(categoryModel4);
		categories.add(categoryModel5);
		return categories;
	}

	public static Map<Long, CategoryModel> groupingDishInCategory(List<DishModel> dishs) {
		Map<Long, CategoryModel> categories = new HashMap<Long, CategoryModel>();
		CategoryModel category;
		DishModel dish;
		String[] categoryName = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q" };
		for (int i = 0; i < dishs.size(); i++) {
			dish = dishs.get(i);
			long categoryId = dish.getCategoryId();
			if (categories.containsKey(dish.getCategoryId()) != true) {
				/*--- will get from database --*/
				category = new CategoryModel(categoryId, categoryName[Integer.parseInt(categoryId + "")],
						new ArrayList<DishModel>());
				/*--- will get from database --*/
				categories.put(categoryId, category);
			}
			categories.get(categoryId).addDish(dish);
		}
		return categories;
	}

	public static void main(String[] args) {
		List<CategoryModel> categories = CategoryModel.testData();
		System.out.println("AAA");
	}

}
