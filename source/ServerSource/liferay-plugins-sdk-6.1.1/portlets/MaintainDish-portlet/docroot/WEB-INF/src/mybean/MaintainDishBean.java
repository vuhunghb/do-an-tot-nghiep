package mybean;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import iRestads.model.Category;
import iRestads.model.Dish;
import iRestads.service.CategoryServiceUtil;
import iRestads.service.DishServiceUtil;

public class MaintainDishBean {
	private Dish dish;
	private String dishId;
	private String dishName;
	private String decription;
	private String avatarImg;
	private String detailImg;
	private String catagory;
	private String detail;
	private double referPrice;
	private long categoryId;
	private String searchTypeProperty;
	private String searchTypes;
	private String contentSearch;
	
	public Dish addDish(){
		System.out.println("cate bean====================="+categoryId);
		Dish dish=	DishServiceUtil.createDish(dishName, decription, avatarImg, detailImg, detail, referPrice,categoryId);
			return null;
		}
	public Map<String, Object> getAllCategoryValues() {
		List<Category> categorys= CategoryServiceUtil.getAllCategorys();
		Map<String, Object> categoryValue = new LinkedHashMap<String, Object>();
		
		for (Category c : categorys) {
			categoryValue.put(c.getCategoryName(), c.getCategoryId());
		}

		return categoryValue;
	}
	public List<Dish> getAllDishs() {
		List<Dish> dishs= DishServiceUtil.getAllDishs();
		return dishs;
	}
	
	public Dish getDish() {
	
		return dish;
	}

	public void setDish(Dish dish) {
		this.dish = dish;
	}
	
	public String getDishId() {
		return dishId;
	}

	public void setDishId(String dishId) {
		this.dishId = dishId;
	}

	public String getDishName() {
		return dishName;
	}

	public void setDishName(String dishName) {
		this.dishName = dishName;
	}

	public String getDecription() {
		return decription;
	}

	public void setDecription(String decription) {
		this.decription = decription;
	}

	public String getAvatarImg() {
		return avatarImg;
	}

	public void setAvatarImg(String avatarImg) {
		this.avatarImg = avatarImg;
	}

	public String getDetailImg() {
		return detailImg;
	}

	public void setDetailImg(String detailImg) {
		this.detailImg = detailImg;
	}

	public String getCatagory() {
		return catagory;
	}

	public void setCatagory(String catagory) {
		this.catagory = catagory;
	}

	public double getReferPrice() {
		return referPrice;
	}

	public void setReferPrice(double referPrice) {
		this.referPrice = referPrice;
	}
	

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}
	public String getSearchTypeProperty() {
		return searchTypeProperty;
	}
	public void setSearchTypeProperty(String searchTypeProperty) {
		this.searchTypeProperty = searchTypeProperty;
	}
	public String getSearchTypes() {
		return searchTypes;
	}
	public void setSearchTypes(String searchTypes) {
		this.searchTypes = searchTypes;
	}
	public String getContentSearch() {
		return contentSearch;
	}
	public void setContentSearch(String contentSearch) {
		this.contentSearch = contentSearch;
	}

	
}
