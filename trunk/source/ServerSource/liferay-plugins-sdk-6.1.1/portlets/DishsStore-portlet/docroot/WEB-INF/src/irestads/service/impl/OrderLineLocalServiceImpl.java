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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;

import irestads.NoSuchMenuLineException;
import irestads.defination.LogTypeEnum;
import irestads.model.Dish;
import irestads.model.MenuLine;
import irestads.model.OrderLine;
import irestads.model.Orders;
import irestads.service.DishServiceUtil;
import irestads.service.UVersionServiceUtil;
import irestads.service.base.OrderLineLocalServiceBaseImpl;
import irestads.service.persistence.DishUtil;
import irestads.service.persistence.MenuLineUtil;
import irestads.service.persistence.OrderLineUtil;
import irestads.service.persistence.OrdersUtil;

/**
 * The implementation of the order line local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link irestads.service.OrderLineLocalService} interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author Be
 * @see irestads.service.base.OrderLineLocalServiceBaseImpl
 * @see irestads.service.OrderLineLocalServiceUtil
 */
public class OrderLineLocalServiceImpl extends OrderLineLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * irestads.service.OrderLineLocalServiceUtil} to access the order line
	 * local service.
	 */
	public OrderLine createOrderLine(Long orderLineId, int numOfDish,
			int statusDish, long dishId, long orderId, long orderDate) {

		OrderLine orderLineModel;
		try {
			orderLineModel = OrderLineUtil.fetchByPrimaryKey(orderLineId);
			MenuLine menuLine = MenuLineUtil.findByDishId(dishId);

			if (orderLineModel == null) {
				orderLineModel = OrderLineUtil.create(orderLineId);
				orderLineModel.setNumOfDish(0);
				orderLineModel.setNumOfFinishDish(0);
				orderLineModel.setStatusDish(statusDish);
				orderLineModel.setDishId(dishId);
				orderLineModel.setOrderId(orderId);
				orderLineModel.setOrderDate(new Date(orderDate));
			}

			int increase = numOfDish - orderLineModel.getNumOfDish();
			if (increase > menuLine.getNumOfDish()) {
				orderLineModel.setOrderLineId(-1);
				orderLineModel.setNumOfDish(menuLine.getNumOfDish());
			} else {
				orderLineModel.setNumOfDish(numOfDish);
				if (numOfDish > orderLineModel.getNumOfFinishDish() && orderLineModel.getStatusDish()==3) {
					orderLineModel.setStatusDish(2);// dang thuc hien
				}
				menuLine.setNumOfDish(menuLine.getNumOfDish() - increase);

				orderLineModel = OrderLineUtil.update(orderLineModel, true);
				MenuLineUtil.update(menuLine, true);
				// up date flag=true khi co bat ky thay doi nao ve orderline
				Orders orders = OrdersUtil.fetchByPrimaryKey(orderId);
				orders.setFlag(true);
				OrdersUtil.update(orders, true);
			}
			
			
			return orderLineModel;
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMenuLineException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public OrderLine updateOrderLine(long orderLineId, int numOfFinishDish,
			int status) {
		try {
			OrderLine orderLine = OrderLineUtil.fetchByPrimaryKey(orderLineId);
			if (orderLine != null && orderLineId == orderLine.getOrderLineId()) {
				orderLine.setNumOfFinishDish(numOfFinishDish);
				orderLine.setStatusDish(status);
				orderLine = OrderLineUtil.update(orderLine, true);
				// up date flag=true khi co bat ky thay doi nao ve orderline
				Orders orders = OrdersUtil.fetchByPrimaryKey(orderLine
						.getOrderId());
				orders.setFlag(true);
				OrdersUtil.update(orders, true);
				return orderLine;
			}

		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public boolean deleteOrderLineById(long orderLineId) {
		try {
			OrderLine orderLine = OrderLineUtil.fetchByPrimaryKey(orderLineId);
			if(orderLine.getStatusDish()!=2 && orderLine.getStatusDish()!=3){
				
			MenuLine menuLine = MenuLineUtil
					.findByDishId(orderLine.getDishId());

			orderLine = OrderLineUtil.remove(orderLineId);
			if (orderLine != null) {
				menuLine.setNumOfDish(orderLine.getNumOfDish()
						+ menuLine.getNumOfDish());
				MenuLineUtil.update(menuLine, true);
			}
			// up date flag=true khi co bat ky thay doi nao ve orderline
			Orders orders = OrdersUtil
					.fetchByPrimaryKey(orderLine.getOrderId());
			orders.setFlag(true);
			OrdersUtil.update(orders, true);

			return true;
			}else{
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	public List<OrderLine> getOrderLineByOrder(long orderId) {
		List<OrderLine> orderLines = new ArrayList<OrderLine>();
		try {
			orderLines = OrderLineUtil.findByOrderId(orderId);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orderLines;
	}

	public OrderLine synchStatusOrderLine(OrderLine ol) {
		try {
			OrderLine orderLine = OrderLineUtil.fetchByPrimaryKey(ol
					.getOrderLineId());
			int numFinish = ol.getNumOfFinishDish();

			int numOfDish = ol.getNumOfDish();
			// if(numFinish==0){
			// orderLine.setStatusDish(0);// moi goi mon
			// }
			if (numFinish == numOfDish) {
				orderLine.setStatusDish(3);// da hoan thanh
			}
			// else if(numFinish<capacity){
			// orderLine.setStatusDish(1);// dang lam
			// }
			orderLine = OrderLineUtil.update(orderLine, true);
			return orderLine;
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	public int getCharge(OrderLine orderLine) {
		int result = 0;
		Dish d = DishServiceUtil.findDishsById(orderLine.getDishId());
		result = d.getReferPrice() * orderLine.getNumOfDish();// cho nay lay
																// numofDihs hay
																// numOfFinish
																// day
		return result;
	}
}