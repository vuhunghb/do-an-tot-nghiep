/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package irestads.service.impl;

import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;

import irestads.NoSuchOrdersException;
import irestads.defination.LogTypeEnum;
import irestads.model.Dish;
import irestads.model.OrderLine;
import irestads.model.Orders;
import irestads.model.OrdersModel;
import irestads.service.OrderLineServiceUtil;
import irestads.service.OrdersLocalServiceUtil;
import irestads.service.OrdersServiceUtil;
import irestads.service.UVersionServiceUtil;
import irestads.service.base.OrdersLocalServiceBaseImpl;
import irestads.service.persistence.DishUtil;
import irestads.service.persistence.OrdersUtil;

/**
 * The implementation of the orders local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link irestads.service.OrdersLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Be
 * @see irestads.service.base.OrdersLocalServiceBaseImpl
 * @see irestads.service.OrdersLocalServiceUtil
 */
public class OrdersLocalServiceImpl extends OrdersLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link
	 * irestads.service.OrdersLocalServiceUtil} to access the orders local
	 * service.
	 */
//	public List<Orders> findByIsPayment(boolean isPayMent){
//		try {
//			return OrdersUtil.findByIsPayMent(isPayMent);
//		} catch (SystemException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return null;
//	}
	
	public Orders findOrderById(long orderId) {
		Orders ordersModel = null;
		try {
			ordersModel =  OrdersUtil.fetchByPrimaryKey(orderId);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ordersModel;
	}

	public Orders createOrders(long orderId, int charge, int isPayment, int numOfDinner, String dishTableId,
			long createdDate) {
		Orders o= OrdersUtil.create(orderId);
		o.setCharge(charge);
		o.setIsPayMent(isPayment);
		o.setNumOfDinner(numOfDinner);
		o.setDishTableId(dishTableId);
		o.setCreatedDate(new Date(createdDate));
		//o.setIsWaiting(false);
		try {
			o=OrdersUtil.update(o, true);
			return o;
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	public Orders updateOrder(Orders o) {
		try {
			Orders order = OrdersUtil.fetchByPrimaryKey(o.getOrderId());
			if (order != null && order.getOrderId() == o.getOrderId()) {
				order.setCharge(o.getCharge());
				order.setDishTableId(o.getDishTableId());
				order.setIsPayMent(o.getIsPayMent());
				order.setNumOfDinner(o.getNumOfDinner());
				
				order= OrdersUtil.update(order, true);
				
				return order;
			}

		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public boolean deleteOrderById(long orderId) {
	try {
			Orders orders = OrdersUtil.remove(orderId);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
	}
}

	public boolean setWaitingStatus(long orderId) {
		try {
			Orders orders = OrdersUtil.findByPrimaryKey(orderId);
			boolean updateValue;
//			if (orders.isIsWaiting() == true) {
//				updateValue = false;
//			} else {
//				updateValue = true;
//			}
//			orders.setIsWaiting(updateValue);
			if(orders.getIsPayMent()!=2){
				orders.setIsPayMent(1);
			}
			OrdersUtil.update(orders, true);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	// public List<OrderLine> getOrderLines(long pk){
	// try {
	// return OrdersUtil.getOrderLines(pk);
	// } catch (SystemException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// return null;
	// }
	// }
public int calCharge(long orderId){
		int charge=0;
		try {
			List<OrderLine> orderLines =OrdersUtil.getOrderLines(orderId);
		   for (int i = 0; i < orderLines.size(); i++) {
			charge+=OrderLineServiceUtil.getCharge(orderLines.get(i));
		}
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return charge;
		
	}
public Orders payment(long orderId){
	try {
		Orders order= OrdersUtil.findByPrimaryKey(orderId);
		int charge =this.calCharge(orderId);
		order.setCharge(charge);
		order=	OrdersUtil.update(order, true);
		return order;
	} catch (NoSuchOrdersException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SystemException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
	
}
}