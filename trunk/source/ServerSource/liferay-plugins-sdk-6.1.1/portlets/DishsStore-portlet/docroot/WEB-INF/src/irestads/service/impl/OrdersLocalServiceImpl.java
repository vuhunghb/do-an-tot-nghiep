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

import com.liferay.portal.kernel.exception.SystemException;

import irestads.model.OrderLine;
import irestads.model.Orders;
import irestads.service.base.OrdersLocalServiceBaseImpl;
import irestads.service.persistence.OrdersUtil;

/**
 * The implementation of the orders local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link irestads.service.OrdersLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
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
	 * Never reference this interface directly. Always use {@link irestads.service.OrdersLocalServiceUtil} to access the orders local service.
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
	public Orders findCurrentOrder(boolean isPayMent, String dishTableId){
		try {
			return OrdersUtil.fetchBycurentOrder(isPayMent, dishTableId);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public Orders createOrders(long orderId, int charge, boolean isPayment,int numOfDinner, String dishTableId ){
		Orders o= OrdersUtil.create(orderId);
		o.setCharge(charge);
		o.setIsPayMent(isPayment);
		o.setNumOfDinner(numOfDinner);
		o.setDishTableId(dishTableId);
	   
		try {
			o=OrdersUtil.update(o, true);
			return o;
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
//	public List<OrderLine> getOrderLines(long pk){
//	try {
//		return 	OrdersUtil.getOrderLines(pk);
//	} catch (SystemException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//		return null;
//	}
//	}
}