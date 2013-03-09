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

import irestads.defination.LogTypeEnum;
import irestads.model.Dish;
import irestads.model.DishTable;
import irestads.model.Orders;
import irestads.service.OrderLineServiceUtil;
import irestads.service.OrdersLocalServiceUtil;
import irestads.service.OrdersServiceUtil;
import irestads.service.UVersionServiceUtil;
import irestads.service.base.DishTableLocalServiceBaseImpl;
import irestads.service.persistence.DishTableUtil;
import irestads.service.persistence.DishUtil;

/**
 * The implementation of the dish table local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link irestads.service.DishTableLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Be
 * @see irestads.service.base.DishTableLocalServiceBaseImpl
 * @see irestads.service.DishTableLocalServiceUtil
 */
public class DishTableLocalServiceImpl extends DishTableLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link irestads.service.DishTableLocalServiceUtil} to access the dish table local service.
	 */
	public List<DishTable> getAllDishTables(){
		try {
			
		List<DishTable> dishTables=	DishTableUtil.findAll();
		for (int i = 0; i < dishTables.size(); i++) {
			Orders o =OrdersServiceUtil.findOrderById(dishTables.get(i).getCurrentOrderId());
			dishTables.get(i).setCurentOrder(o);
		}
			return dishTables;
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	public DishTable updateDishTable(DishTable dt) {
		try {
			DishTable dishTable = DishTableUtil.fetchByPrimaryKey(dt.getDishTableId());
			if (dishTable != null && dishTable.getDishTableId() == dt.getDishTableId()) {
				dishTable.setCurentOrder(dt.getCurentOrder());
				dishTable.setCurrentOrderId(dt.getCurrentOrderId());
				dishTable.setIsAvalable(dt.getIsAvalable());
				dishTable.setNumChair(dt.getNumChair());
				dishTable.setTableName(dt.getTableName());
				
				dishTable=DishTableUtil.update(dishTable, true);
				
				return dishTable;
			}

		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public DishTable updateTableStatus(String idTable, boolean value, long orderId) {
		try {
			DishTable dishTable = DishTableUtil.fetchByPrimaryKey(idTable);
			if (dishTable != null && dishTable.getDishTableId().equals(idTable)) {
				dishTable.setIsAvalable(value);
				dishTable.setCurrentOrderId(orderId);
				dishTable=DishTableUtil.update(dishTable, true);
				return dishTable;
			}

		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}