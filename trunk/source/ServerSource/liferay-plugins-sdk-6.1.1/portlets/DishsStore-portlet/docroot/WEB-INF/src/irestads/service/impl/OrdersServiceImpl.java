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

import java.util.List;

import irestads.model.OrderLine;
import irestads.model.Orders;
import irestads.service.MenuLineLocalServiceUtil;
import irestads.service.OrdersLocalServiceUtil;
import irestads.service.base.OrdersServiceBaseImpl;

/**
 * The implementation of the orders remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link irestads.service.OrdersService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Be
 * @see irestads.service.base.OrdersServiceBaseImpl
 * @see irestads.service.OrdersServiceUtil
 */
public class OrdersServiceImpl extends OrdersServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link irestads.service.OrdersServiceUtil} to access the orders remote service.
	 */
	public Orders findCurrentOrder(boolean isPayMent, String dishTableId){
		return OrdersLocalServiceUtil.findCurrentOrder(isPayMent, dishTableId);
		
	}
	public Orders createOrders(long orderId, int charge, boolean isPayment,int numOfDinner, String dishTableId ){
		return OrdersLocalServiceUtil.createOrders(orderId, charge, isPayment, numOfDinner, dishTableId);
	}
//	public List<OrderLine> getOrderLines(long pk){
//	return OrdersLocalServiceUtil.getOrderLines(pk);
//	}
}