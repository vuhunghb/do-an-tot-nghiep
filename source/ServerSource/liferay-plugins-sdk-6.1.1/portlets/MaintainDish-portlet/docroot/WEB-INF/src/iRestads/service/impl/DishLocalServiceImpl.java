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

package iRestads.service.impl;

import java.util.List;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;

import iRestads.model.Dish;
import iRestads.service.persistence.DishUtil;
import iRestads.service.base.DishLocalServiceBaseImpl;

/**
 * The implementation of the dish local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link iRestads.service.DishLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Be
 * @see iRestads.service.base.DishLocalServiceBaseImpl
 * @see iRestads.service.DishLocalServiceUtil
 */

public class DishLocalServiceImpl extends DishLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link iRestads.service.DishLocalServiceUtil} to access the dish local service.
	 */
	// day la lop ServiceLocalImpl trong file doc
	// chi thuc hien code o day, ko goi truc tiep. ma chi goi qua SẻviceLocalUtils
	
	public Dish createDish(String dishName,String decription, String avatarImg, String detailImg, String detail, double referPrice,long categoryId){
		try {
			long id = CounterLocalServiceUtil.increment(Dish.class.getName());
			Dish dishModel = DishUtil.create(id);
			dishModel.setDishName(dishName);
			dishModel.setDecription(decription);
			dishModel.setAvatarImg(avatarImg);
			dishModel.setDetailImg(detailImg);
			dishModel.setDetail(detail);
			dishModel.setReferPrice(referPrice);
			dishModel.setCategoryId(categoryId);
			
			
			
		//	System.out.println("categoryId--------------------------------"+categoryId);
			dishModel = DishUtil.update(dishModel, true);
			
			return dishModel;
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
public List<Dish> getAllDishs(){
	try {
		return DishUtil.findAll();
	} catch (SystemException e) {
		// TODO Auto-generated catch block
		
		e.printStackTrace();
		return null;
	}
	
}
}