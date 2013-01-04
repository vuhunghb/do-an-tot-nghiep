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

import irestads.model.Dish;
import irestads.service.DishLocalServiceUtil;
import irestads.service.base.DishServiceBaseImpl;

import java.util.List;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;


/**
 * The implementation of the dish remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link iRestads.service.DishService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Be
 * @see iRestads.service.base.DishServiceBaseImpl
 * @see iRestads.service.DishServiceUtil
 */
public class DishServiceImpl extends DishServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link iRestads.service.DishServiceUtil} to access the dish remote service.
	 */
	// day la lop ServiceImpl trong file doc
	// tao lai phuong thuc y chang local nhung chi cac phuong thuc can de goi tu xa (Remote calling)
	//ko viet gi ca chi goi phuong thuc tu ServiceLocal
//	
	public Dish createDish(String dishName,String decription, String avatarImg, String detailImg, String detail, double referPrice,long categoryId){
		
		// sau nay cho nay se de kiem tra authentication..sau nay thoi
		// vay thi DisLocalServiceUtil dc sinh ra tu DishLocalServiceImpl.
		// ServiceImpl chi xai kieu nay thoi nha.. ok ?ok
		return DishLocalServiceUtil.createDish(dishName, decription, avatarImg, detailImg, detail, referPrice,categoryId);
	}
	public List<Dish> getAllDishs(){
		return DishLocalServiceUtil.getAllDishs();
	}
	public List<Dish> getDishsByCategory(long categoryId) {
		return DishLocalServiceUtil.getDishsByCategory(categoryId);
	}
	public Dish updateDish(Dish dish) {
		try {
			return DishLocalServiceUtil.updateDish(dish);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public Dish deleteDish(Dish dish) {
		try {
			return DishLocalServiceUtil.deleteDish(dish);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}