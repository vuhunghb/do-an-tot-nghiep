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
import irestads.model.OrderLine;
import irestads.model.Orders;
import irestads.service.MenuLineLocalServiceUtil;
import irestads.service.OrdersLocalServiceUtil;
import irestads.service.base.OrdersServiceBaseImpl;
import irestads.service.persistence.OrdersUtil;

/**
 * The implementation of the orders remote service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link irestads.service.OrdersService} interface.
 * 
 * <p>
 * This is a remote service. Methods of this service are expected to have
 * security checks based on the propagated JAAS credentials because this service
 * can be accessed remotely.
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
	 * Never reference this interface directly. Always use {@link
	 * irestads.service.OrdersServiceUtil} to access the orders remote service.
	 */
	

	public Orders findOrderById(long orderId) {
		return OrdersLocalServiceUtil.findOrderById(orderId);
	}

	public Orders createOrders(long orderId, int charge, int isPayment, int numOfDinner, String dishTableId,
			long createdDate) {
		return OrdersLocalServiceUtil.createOrders(orderId, charge, isPayment, numOfDinner, dishTableId, createdDate);
	}

	public boolean deleteOrderById(long orderId) {
		return OrdersLocalServiceUtil.deleteOrderById(orderId);
	}
	public boolean setWaitingStatus(long orderId) {
		return OrdersLocalServiceUtil.setWaitingStatus(orderId);
	}
	public Orders updateOrder(Orders o) {
		try {
			return OrdersLocalServiceUtil.updateOrders(o);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public Orders payment(long orderId){
		return OrdersLocalServiceUtil.payment(orderId);
		
	}
	public int calCharge(long orderId){
		return OrdersLocalServiceUtil.calCharge(orderId);
	}
	// public List<OrderLine> getOrderLines(long pk){
	// return OrdersLocalServiceUtil.getOrderLines(pk);
	// }
}