package com.irestads.model;

public class MenuLineModel {
	long menuLineId;
	int numOfDish;
	boolean status;
	long dishId;
	DishModel dish;

	public long getMenuLineId() {
		return menuLineId;
	}

	public void setMenuLineId(long menuLineId) {
		this.menuLineId = menuLineId;
	}

	public int getNumOfDish() {
		return numOfDish;
	}

	public void setNumOfDish(int numOfDish) {
		this.numOfDish = numOfDish;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public long getDishId() {
		return dishId;
	}

	public void setDishId(long dishId) {
		this.dishId = dishId;
	}

	public DishModel getDish() {
		return dish;
	}

	public void setDish(DishModel dish) {
		this.dish = dish;
	}

	public MenuLineModel(long menuLineId, int numOfDish, boolean status, long dishId, DishModel dish) {
		super();
		this.menuLineId = menuLineId;
		this.numOfDish = numOfDish;
		this.status = status;
		this.dishId = dishId;
		this.dish = dish;
	}

	public MenuLineModel() {
		super();
	}

	public MenuLineModel(long menuLineId, int numOfDish, boolean status, long dishId) {
		super();
		this.menuLineId = menuLineId;
		this.numOfDish = numOfDish;
		this.status = status;
		this.dishId = dishId;
	}

}
