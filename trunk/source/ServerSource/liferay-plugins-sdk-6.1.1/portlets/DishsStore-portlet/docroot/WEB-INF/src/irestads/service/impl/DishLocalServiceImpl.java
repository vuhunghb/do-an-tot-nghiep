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

import irestads.NoSuchDishException;
import irestads.NoSuchMenuLineException;
import irestads.defination.LogTypeEnum;
import irestads.model.Dish;
import irestads.model.MenuLine;

import irestads.service.UVersionServiceUtil;
import irestads.service.base.DishLocalServiceBaseImpl;
import irestads.service.persistence.CategoryUtil;
import irestads.service.persistence.DishFinderUtil;
import irestads.service.persistence.DishUtil;
import irestads.service.persistence.MenuLineUtil;

import java.util.List;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DatabaseUtil;

/**
 * The implementation of the dish local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link iRestads.service.DishLocalService} interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
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
	 * Never reference this interface directly. Always use {@link
	 * iRestads.service.DishLocalServiceUtil} to access the dish local service.
	 */

	public Dish createDish(String dishName, String decription,
			String avatarImg, String detailImg, String detail, int referPrice,String avatarBaseCode,String detailBaseCode,
			long categoryId) {
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
			dishModel.setAvatarBaseCode(avatarBaseCode);
			dishModel.setDetailBaseCode(detailBaseCode);

			// System.out.println("categoryId--------------------------------"+categoryId);
			dishModel = DishUtil.update(dishModel, true);

			return dishModel;
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}
	public Dish createDish(Dish dishAdd) {
		return createDish(dishAdd.getDishName(),
				dishAdd.getDecription(), dishAdd.getAvatarImg(),
				dishAdd.getDetailImg(), dishAdd.getDetail(),
				dishAdd.getReferPrice(),dishAdd.getAvatarBaseCode(),dishAdd.getDetailBaseCode(), dishAdd.getCategoryId());
	}
	public List<Dish> findDishNotInMenu() {
		return DishFinderUtil.findDishNotInMenu();
	}

	public List<Dish> getAllDishs() {
		try {
			return DishUtil.findAll();
		} catch (SystemException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
			return null;
		}

	}

	public List<Dish> getDishsByCategory(long categoryId) {
		try {
			return CategoryUtil.getDishs(categoryId);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public Dish updateDish(Dish dish) {
		try {
			Dish d = DishUtil.fetchByPrimaryKey(dish.getPrimaryKey());
			if (d != null && d.getDishId() == dish.getDishId()) {
				d.setDishName(dish.getDishName());
				d.setAvatarImg(dish.getAvatarImg());
				d.setDecription(dish.getDecription());
				d.setDetail(dish.getDetail());
				d.setDetailImg(dish.getDetailImg());
				d.setReferPrice(dish.getReferPrice());
				d.setCategoryId(dish.getCategoryId());
				
				d= DishUtil.update(d, true);
				if(d!=null){
				UVersionServiceUtil.createVersion(d.getDishId(), Dish.class.getName(), LogTypeEnum.UPDATE.toString());
				}
				return d;
			}

		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public Dish deleteDish(Dish dish) {
		Dish d = null;
		try {
			d = DishUtil.remove(dish.getPrimaryKey());
		} catch (NoSuchDishException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return d;
	}
	public Dish findDishsById(long dishId) {
			try {
				return DishUtil.fetchByPrimaryKey(dishId);
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
	}
	public List<Dish> findDishsByReferPrice(int referPrice){
		try {
			return DishUtil.findByReferPrice(referPrice);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public List<Dish> findDishsByCategoryName(String categoryName){
			return DishFinderUtil.findDishsByCategoryName("%"+categoryName+"%");
	}


	public List<Dish> findDishsByName(String dishName) {
		return DishFinderUtil.findDishsByName("%" + dishName + "%");
	}

	public List<Dish> findDishsByDecription(String decription) {
		return DishFinderUtil.findDishsByDecription("%" + decription + "%");
	}

	public List<Dish> findDishsByAvatarImg(String avatarImg) {
		return DishFinderUtil.findDishsByAvatarImg("%" + avatarImg + "%");
	}

	public List<Dish> findDishsByDetailImg(String detailImg) {
		return DishFinderUtil.findDishsByDetailImg("%" + detailImg + "%");
	}

	public List<Dish> findDishsByDetail(String detail) {
		return DishFinderUtil.findDishsByDetail("%" + detail + "%");
	}
	public List<Dish> findDishsBySomeField(long dishId,int referPrice,String dishName, String decription, String avatarImg,String detailImg, String detail) {
		return DishFinderUtil.findDishsBySomeField(dishId, referPrice, dishName, decription, avatarImg, detailImg, detail);
	}
	public boolean isDeleteDish(long dishId){
		MenuLine menuLine;
		try {
			menuLine = MenuLineUtil.fetchByDishId(dishId);
			if(menuLine==null){
				return true;
			}
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
		
	}

}