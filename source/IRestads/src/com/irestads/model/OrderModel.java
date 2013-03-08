package com.irestads.model;

import java.util.Date;
import java.util.List;

public class OrderModel {
	int charge;
	Date createDate;
	int isPayment;
	List<OrderLineModel> listOrderLine;
	long orderId, userSession;

	
	public OrderModel() {
		super();
		orderId = 0;
	}

	public OrderModel(int charge, Date createDate, int isPayment,
			List<OrderLineModel> listOrderLine, long orderID) {
		super();
		this.charge = charge;
		this.createDate = createDate;
		this.isPayment = isPayment;
		this.listOrderLine = listOrderLine;
		this.orderId = orderID;
	}

	public int getCharge() {
		return charge;
	}

	public void setCharge(int charge) {
		this.charge = charge;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}


	public int getIsPayment() {
		return isPayment;
	}

	public void setIsPayment(int isPayment) {
		this.isPayment = isPayment;
	}

	public List<OrderLineModel> getListOrderLine() {
		return listOrderLine;
	}

	public void setListOrderLine(List<OrderLineModel> listOrderLine) {
		this.listOrderLine = listOrderLine;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public long getUserSession() {
		return userSession;
	}

	public void setUserSession(long userSession) {
		this.userSession = userSession;
	}
	
	public int getTotalCharge(){
		int charge = 0;
		for (OrderLineModel order : this.getListOrderLine()) {
			charge = charge + (order.getDish().getReferPrice()*order.getNumOfDish());
		}
		this.setCharge(charge);
		return this.getCharge();
	}
}
