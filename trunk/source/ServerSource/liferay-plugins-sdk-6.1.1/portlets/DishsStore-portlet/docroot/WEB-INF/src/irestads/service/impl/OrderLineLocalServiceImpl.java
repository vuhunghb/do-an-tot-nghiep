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
		try {
			OrderLine orderLineModel = OrderLineUtil.create(orderLineId);
			orderLineModel.setNumOfDish(numOfDish);
			orderLineModel.setStatusDish(statusDish);
			orderLineModel.setDishId(dishId);
			orderLineModel.setOrderId(orderId);
			orderLineModel.setNumOfFinishDish(0);
			orderLineModel.setOrderDate(new Date(orderDate));
			// check
			// neu ma vươt qua nuOfDish thì set orderlienid=-1 và nuofdish là so
			// món ăn hienj có
			MenuLine menuLine = MenuLineUtil.findByDishId(dishId);
			int available = menuLine.getCapacity() - menuLine.getNumOfDish();
			if (available < numOfDish) {
				orderLineModel.setOrderId(-1);
				orderLineModel.setNumOfDish(available);
			}
			orderLineModel = OrderLineUtil.update(orderLineModel, true);
			// tang so luong o truong NumOfDish cua Menuline khi tao thanh cong
			// OrderLine
			int temp = menuLine.getNumOfDish() + orderLineModel.getNumOfDish();
			if (orderLineModel != null) {

				menuLine.setNumOfDish(temp);
				MenuLineUtil.update(menuLine, true);
			}

			return orderLineModel;
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (NoSuchMenuLineException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public OrderLine updateOrderLine(long orderLineId, int numOfFinishDish,
			int status) {
		try {
			OrderLine orderLine = OrderLineUtil.fetchByPrimaryKey(orderLineId);
			if (orderLine != null && orderLineId == orderLine.getOrderLineId()) {
				orderLine.setNumOfFinishDish(numOfFinishDish);
				orderLine.setStatusDish(status);
				orderLine = OrderLineUtil.update(orderLine, true);
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
			OrderLineUtil.remove(orderLineId);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	public List<OrderLine> getOrderLineByOrder(long orderId) {
		try {

			return OrderLineUtil.findByOrderId(orderId);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ArrayList<OrderLine>();
	}

	public OrderLine synchStatusOrderLine(OrderLine ol) {
		try {
			OrderLine orderLine = OrderLineUtil.fetchByPrimaryKey(ol
					.getOrderLineId());
			int numFinish = ol.getNumOfFinishDish();

			int capacity = ol.getNumOfDish();
			// if(numFinish==0){
			// orderLine.setStatusDish(0);// moi goi mon
			// }
			if (numFinish == capacity) {
				orderLine.setStatusDish(2);// da hoan thanh
			}
//			 else if(numFinish<capacity){
//			 orderLine.setStatusDish(1);// dang lam
//			 }
			orderLine = OrderLineUtil.update(orderLine, true);
			return orderLine;
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}
}