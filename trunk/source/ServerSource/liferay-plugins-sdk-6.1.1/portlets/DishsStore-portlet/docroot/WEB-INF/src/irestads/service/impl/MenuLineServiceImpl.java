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

import irestads.model.Dish;
import irestads.model.MenuLine;
import irestads.service.MenuLineLocalServiceUtil;
import irestads.service.base.MenuLineServiceBaseImpl;

/**
 * The implementation of the menu line remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link irestads.service.MenuLineService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Be
 * @see irestads.service.base.MenuLineServiceBaseImpl
 * @see irestads.service.MenuLineServiceUtil
 */
public class MenuLineServiceImpl extends MenuLineServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link irestads.service.MenuLineServiceUtil} to access the menu line remote service.
	 */
	public List<MenuLine> getAllMenuLine(){
	return 	MenuLineLocalServiceUtil.getAllMenuLines();
	}
	public MenuLine createMenuLine(String dishName, String decription,
			String avatarImg, String detailImg, String detail, int referPrice,String avatarBaseCode,String detailBaseCode,
			int numOfDiner,long categoryId,int numOfDish, boolean status) {
		return MenuLineLocalServiceUtil.createMenuLine(dishName, decription, avatarImg, detailImg, detail, referPrice, avatarBaseCode, detailBaseCode,  numOfDiner,categoryId, numOfDish, status);
	}
	public MenuLine createMenuLineDish(MenuLine ml) {
		return MenuLineLocalServiceUtil.createMenuLineDish(ml);
	}
	public MenuLine createMenuLine(MenuLine ml) {
		return MenuLineLocalServiceUtil.createMenuLine(ml);
	}
	public MenuLine createMenuLine(long dishId, int numOfDish, boolean status){
		return MenuLineLocalServiceUtil.createMenuLine(dishId, numOfDish, status);
	}
	public List<MenuLine> createMenuLine(List<MenuLine> mls) {
		return MenuLineLocalServiceUtil.createMenuLine(mls);
	}
	public MenuLine updateMenuLine(MenuLine ml) {
		try {
			return MenuLineLocalServiceUtil.updateMenuLine(ml);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
		
	public MenuLine deleteMenuLine(MenuLine ml) {
		try {
			return MenuLineLocalServiceUtil.deleteMenuLine(ml);
		} catch (SystemException e) {
			// TODO Auto-generated catch blockpublic MenuLine findMenuLineById(long menuLineId){
		return null;
	}
	}
//	public List<Dish> findDishNotInMenu() {
//		return MenuLineLocalServiceUtil.findDishNotInMenu();
//	}
	public MenuLine findMenuLineById(long menuLineId){
		return MenuLineLocalServiceUtil.findMenuLineById(menuLineId);
	}
	public List<MenuLine> findMenuLinesByDReferPrice(int price) {
		return MenuLineLocalServiceUtil.findMenuLinesByDReferPrice(price);
	}
	public MenuLine setDishForMenuLine(MenuLine menuLine){
		return MenuLineLocalServiceUtil.setDishForMenuLine(menuLine);
	}
	public MenuLine findMenuLinesByDishId(long dishId) {
		return MenuLineLocalServiceUtil.findMenuLinesByDishId(dishId);
	}
	public List<MenuLine> findMenuLinesByDName(String dishName) {
		return MenuLineLocalServiceUtil.findMenuLinesByDName(dishName);
	}
	public List<MenuLine> findMenuLinesByDDecription(String decription) {
		return MenuLineLocalServiceUtil.findMenuLinesByDDecription(decription);
	}
	public List<MenuLine> findMenuLinesByDAvatarImg(String avartarImg) {
		return MenuLineLocalServiceUtil.findMenuLinesByDAvatarImg(avartarImg);
	}
	public List<MenuLine> findMenuLinesByDDetailImg(String detailImg) {
		return MenuLineLocalServiceUtil.findMenuLinesByDDetailImg(detailImg);
	}
	public List<MenuLine> findMenuLinesByDDetail(String detail) {
		return MenuLineLocalServiceUtil.findMenuLinesByDDetail(detail);
	}
	public List<MenuLine> findMenuLinesByDCategoryName(String categoryName) {
		return MenuLineLocalServiceUtil.findMenuLinesByDCategoryName(categoryName);
	}
	public List<MenuLine> findMenuLinesByNumOfDish(int numOfDish) {
		return MenuLineLocalServiceUtil.findMenuLinesByNumOfDish(numOfDish);
	}
	public List<MenuLine> findMenuLinesByStatus(boolean status) {
		return MenuLineLocalServiceUtil.findMenuLinesByStatus(status);
	}
	public String parseBooleanToShow(boolean value,String TValue, String Fvalue){
		return MenuLineLocalServiceUtil.parseBooleanToShow(value, TValue, Fvalue);
	}
}