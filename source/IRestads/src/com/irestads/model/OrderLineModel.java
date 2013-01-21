package com.irestads.model;

import java.util.Date;

public class OrderLineModel {
	DishModel dish;
	int numOfDish, numOfFinishDish;
	Date orderDate;
	int status; 
	/*0 = not yet order
	 *1 = orderring
	 *2 = finish
	 **/
	long orderLineId;
	
	public OrderLineModel(DishModel dish, int numOfDish, int numOfFinishDish,
			Date orderDate, int status) {
		super();
		this.dish = dish;
		this.numOfDish = numOfDish;
		this.numOfFinishDish = numOfFinishDish;
		this.orderDate = orderDate;
		this.status = status;
	}
	
	public DishModel getDish() {
		return dish;
	}
	public void setDish(DishModel dish) {
		this.dish = dish;
	}
	public int getNumOfDish() {
		return numOfDish;
	}
	public void setNumOfDish(int numOfDish) {
		this.numOfDish = numOfDish;
	}
	public int getNumOfFinishDish() {
		return numOfFinishDish;
	}
	public void setNumOfFinishDish(int numOfFinishDish) {
		this.numOfFinishDish = numOfFinishDish;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}

	public long getOrderLineId() {
		return orderLineId;
	}

	public void setOrderLineId(long orderLineId) {
		this.orderLineId = orderLineId;
	}
	
	public int getOrderLinePrice(){
		return this.getDish().getReferPrice() * numOfDish;
	}
}
