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
import java.util.List;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;

import irestads.NoSuchDishException;
import irestads.NoSuchMenuLineException;
import irestads.model.Dish;
import irestads.model.DishModel;
import irestads.model.MenuLine;
import irestads.model.UVersion;
import irestads.service.DishLocalServiceUtil;
import irestads.service.DishServiceUtil;
import irestads.service.MenuLineLocalServiceUtil;
import irestads.service.base.MenuLineLocalServiceBaseImpl;
import irestads.service.persistence.DishUtil;
import irestads.service.persistence.MenuLineFinder;
import irestads.service.persistence.MenuLineFinderUtil;
import irestads.service.persistence.MenuLineUtil;
import irestads.service.persistence.UVersionUtil;

/**
 * The implementation of the menu line local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link irestads.service.MenuLineLocalService} interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author Be
 * @see irestads.service.base.MenuLineLocalServiceBaseImpl
 * @see irestads.service.MenuLineLocalServiceUtil
 */
public class MenuLineLocalServiceImpl extends MenuLineLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * irestads.service.MenuLineLocalServiceUtil} to access the menu line local
	 * service.
	 */
	public List<MenuLine> getAllMenuLines() {
		try {
			List<MenuLine> menuLines = MenuLineUtil.findAll();

			for (int i = 0; i < menuLines.size(); i++) {
				MenuLine menuLine = menuLines.get(i);
				DishModel dish = DishServiceUtil.findDishsById(menuLine
						.getDishId());
				menuLine.setDish(dish);
			}

			System.out.println("dish id "
					+ DishServiceUtil.findDishsById(1601).getDishId());
			return menuLines;

		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public MenuLine createMenuLine(String dishName, String decription,
			String avatarImg, String detailImg, String detail, int referPrice,
			String avatarBaseCode, String detailBaseCode, long categoryId,
			int numOfDish, boolean status) {
		// cap nhat lại cai nay sau nha

		try {
			// create Dish
			long dishId = CounterLocalServiceUtil.increment(Dish.class
					.getName());
			Dish dishModel = DishUtil.create(dishId);
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
			// create MenuLine
			long menuLineId = CounterLocalServiceUtil.increment(MenuLine.class
					.getName());
			MenuLine menuLine = MenuLineUtil.create(menuLineId);
			menuLine.setNumOfDish(numOfDish);
			menuLine.setStatus(status);
			menuLine.setDishId(dishId);
			menuLine.setDish(dishModel);
			menuLine = MenuLineUtil.update(menuLine, true);

			return menuLine;
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public MenuLine createMenuLineDish(MenuLine ml) {
		// cap nhat lại cai nay sau nha

		
			// create Dish
		
		Dish d=	DishLocalServiceUtil.createDish((Dish) ml.getDish());
			// create MenuLine
		ml.setDishId(d.getDishId());
		
		MenuLine menuLine=	this.createMenuLine(ml);

			return menuLine;
		
	}

	public MenuLine createMenuLine(long dishId, int numOfDish, boolean status) {
		long menuLineId;
		try {
			menuLineId = CounterLocalServiceUtil.increment(MenuLine.class
					.getName());
			MenuLine menuLine = MenuLineUtil.create(menuLineId);
			menuLine.setNumOfDish(numOfDish);
			menuLine.setStatus(status);
			menuLine.setDishId(dishId);
			menuLine = MenuLineUtil.update(menuLine, true);
			// create version
			UVersion uVersion =UVersionUtil.create(0);
			uVersion 
			return menuLine;
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public MenuLine createMenuLine(MenuLine ml) {
		return this.createMenuLine(ml.getDishId(), ml.getNumOfDish(), ml.getStatus());
	}

	public List<MenuLine> createMenuLine(List<MenuLine> mls) {
		List<MenuLine> mlcreateds = new ArrayList<MenuLine>();
		MenuLine m;
		MenuLine created;
		for (int i = 0; i < mls.size(); i++) {
			m = mls.get(i);
			created = this.createMenuLine(m);
			mlcreateds.add(created);
		}
		return mlcreateds;
	}

	public MenuLine updateMenuLine(MenuLine ml) {
		try {
			MenuLine menuLine = MenuLineUtil.fetchByPrimaryKey(ml
					.getPrimaryKey());
			if (menuLine != null
					&& menuLine.getMenuLineId() == menuLine.getMenuLineId()) {
				menuLine.setStatus(ml.getStatus());
				menuLine.setNumOfDish(ml.getNumOfDish());
				return MenuLineUtil.update(menuLine, true);
			}
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public MenuLine deleteMenuLine(MenuLine ml) {
		MenuLine menuLine = null;
		try {
			menuLine = MenuLineUtil.remove(ml.getPrimaryKey());
		} catch (NoSuchMenuLineException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return menuLine;
	}

	public MenuLine findMenuLineById(long menuLineId) {
		try {
			return MenuLineUtil.fetchByPrimaryKey(menuLineId);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// public List<Dish> findDishNotInMenu() {
	// return MenuLineFinderUtil.findDishNotInMenu();
	// }
	public MenuLine setDishForMenuLine(MenuLine menuLine) {
		DishModel dish = DishServiceUtil.findDishsById(menuLine.getDishId());
		menuLine.setDish(dish);
		return menuLine;
	}

	public List<MenuLine> setDishForMenuLine(List<MenuLine> menuLines) {
		for (int i = 0; i < menuLines.size(); i++) {
			this.setDishForMenuLine(menuLines.get(i));
		}
		return menuLines;
	}

	public List<MenuLine> findMenuLinesByDishId(long dishId) {
		List<MenuLine> menuLines = null;
		try {
			menuLines = MenuLineUtil.findByDishId(dishId);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setDishForMenuLine(menuLines);
		return menuLines;
	}

	public List<MenuLine> findMenuLinesByDReferPrice(int price) {
		List<MenuLine> menuLines = MenuLineFinderUtil
				.findMenuLinesByDReferPrice(price);
		this.setDishForMenuLine(menuLines);
		return menuLines;
	}

	public List<MenuLine> findMenuLinesByDName(String dishName) {
		List<MenuLine> menuLines = MenuLineFinderUtil
				.findMenuLinesByDName(dishName);
		this.setDishForMenuLine(menuLines);
		return menuLines;
	}

	public List<MenuLine> findMenuLinesByDDecription(String decription) {
		List<MenuLine> menuLines = MenuLineFinderUtil
				.findMenuLinesByDDecription(decription);
		this.setDishForMenuLine(menuLines);
		return menuLines;
	}

	public List<MenuLine> findMenuLinesByDAvatarImg(String avartarImg) {
		List<MenuLine> menuLines = MenuLineFinderUtil
				.findMenuLinesByDAvatarImg(avartarImg);
		this.setDishForMenuLine(menuLines);
		return menuLines;
	}

	public List<MenuLine> findMenuLinesByDDetailImg(String detailImg) {
		List<MenuLine> menuLines = MenuLineFinderUtil
				.findMenuLinesByDDetailImg(detailImg);
		this.setDishForMenuLine(menuLines);
		return menuLines;
	}

	public List<MenuLine> findMenuLinesByDDetail(String detail) {
		List<MenuLine> menuLines = MenuLineFinderUtil
				.findMenuLinesByDDetail(detail);
		this.setDishForMenuLine(menuLines);
		return menuLines;
	}

	public List<MenuLine> findMenuLinesByDCategoryName(String categoryName) {
		List<MenuLine> menuLines = MenuLineFinderUtil
				.findMenuLinesByDCategoryName(categoryName);
		this.setDishForMenuLine(menuLines);
		return menuLines;
	}

	public List<MenuLine> findMenuLinesByNumOfDish(int numOfDish) {
		List<MenuLine> menuLines = null;
		try {
			menuLines = MenuLineUtil.findByNumOfDish(numOfDish);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setDishForMenuLine(menuLines);
		return menuLines;
	}

	public List<MenuLine> findMenuLinesByStatus(boolean status) {
		List<MenuLine> menuLines = null;

		try {
			menuLines = MenuLineUtil.findByStatus(status);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setDishForMenuLine(menuLines);
		return menuLines;
	}

	public String parseBooleanToShow(boolean value, String TValue, String Fvalue) {
		if (value == true) {
			return TValue;
		} else {
			return Fvalue;
		}
	}
}