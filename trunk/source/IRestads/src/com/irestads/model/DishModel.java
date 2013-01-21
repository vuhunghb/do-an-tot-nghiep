package com.irestads.model;

import java.util.ArrayList;

public class DishModel {
	String dishName, decription, detail, detailImg;

	int referPrice, numOfDiner;
	long dishID, categoryId;
	byte[] avatarImg;
	CategoryModel category;

	public DishModel() {
		super();
	}

	public DishModel(long dishId,String dishName, String decription, String detail,
			byte[] avatarImg, String detailImg, int referPrice,int numOfDiners , long categoryId) {
		super();
		this.dishID = dishId;
		this.dishName = dishName;
		this.decription = decription;
		this.detail = detail;
		this.avatarImg = avatarImg;
		this.detailImg = detailImg;
		this.referPrice = referPrice;
		this.numOfDiner = numOfDiners;
		this.categoryId = categoryId;
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

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public byte[] getAvatarImg() {
		return avatarImg;
	}

	public void setAvatarImg(byte[] avatarImg) {
		this.avatarImg = avatarImg;
	}

	public String getDetailImg() {
		return detailImg;
	}

	public void setDetailImg(String detailImg) {
		this.detailImg = detailImg;
	}

	public int getReferPrice() {
		return referPrice;
	}

	public void setReferPrice(int referPrice) {
		this.referPrice = referPrice;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public long getDishID() {
		return dishID;
	}

	public void setDishID(long dishID) {
		this.dishID = dishID;
	}

	public CategoryModel getCategory() {
		return category;
	}

	public void setCategory(CategoryModel category) {
		this.category = category;
	}

	public int getNumOfDiner() {
		return numOfDiner;
	}

	public void setNumOfDiner(int numOfDiner) {
		this.numOfDiner = numOfDiner;
	}
	

}
