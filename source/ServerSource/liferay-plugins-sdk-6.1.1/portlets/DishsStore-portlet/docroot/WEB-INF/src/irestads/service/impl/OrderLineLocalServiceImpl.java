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

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;

import irestads.model.Dish;
import irestads.model.OrderLine;
import irestads.model.Orders;
import irestads.service.base.OrderLineLocalServiceBaseImpl;
import irestads.service.persistence.DishUtil;
import irestads.service.persistence.OrderLineUtil;
import irestads.service.persistence.OrdersUtil;

/**
 * The implementation of the order line local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link irestads.service.OrderLineLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
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
	 * Never reference this interface directly. Always use {@link irestads.service.OrderLineLocalServiceUtil} to access the order line local service.
	 */
	public OrderLine createOrderLine(Long orderLineId, int numOfDish,int capacity, boolean statusDish, long dishId, long orderId) {
		try {
			OrderLine orderLineModel=OrderLineUtil.create(0);
			orderLineModel.setNumOfDish(numOfDish);
			orderLineModel.setStatusDish(statusDish);
			orderLineModel.setDishId(dishId);
			orderLineModel.setOrderId(orderId);
			orderLineModel.setCapacity(capacity);
			//orderModel.set

			// System.out.println("categoryId--------------------------------"+categoryId);
			orderLineModel = OrderLineUtil.update(orderLineModel, true);

			return orderLineModel;
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		
	}
		
}