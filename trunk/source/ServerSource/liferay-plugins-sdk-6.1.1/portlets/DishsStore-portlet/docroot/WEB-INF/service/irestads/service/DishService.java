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

package irestads.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.BaseService;
import com.liferay.portal.service.InvokableService;

/**
 * The interface for the dish remote service.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Be
 * @see DishServiceUtil
 * @see irestads.service.base.DishServiceBaseImpl
 * @see irestads.service.impl.DishServiceImpl
 * @generated
 */
@JSONWebService
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface DishService extends BaseService, InvokableService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DishServiceUtil} to access the dish remote service. Add custom service methods to {@link irestads.service.impl.DishServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier();

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier);

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable;

	public irestads.model.Dish createDish(java.lang.String dishName,
		java.lang.String decription, java.lang.String avatarImg,
		java.lang.String detailImg, java.lang.String detail, int referPrice,
		long categoryId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<irestads.model.Dish> getAllDishs();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<irestads.model.Dish> getDishsByCategory(
		long categoryId);

	public irestads.model.Dish updateDish(irestads.model.Dish dish);

	public irestads.model.Dish deleteDish(irestads.model.Dish dish);

	public irestads.model.Dish findDishsById(long dishId);

	public java.util.List<irestads.model.Dish> findDishsByReferPrice(
		int referPrice);

	public java.util.List<irestads.model.Dish> findDishsByName(
		java.lang.String dishName);

	public java.util.List<irestads.model.Dish> findDishsByDecription(
		java.lang.String decription);

	public java.util.List<irestads.model.Dish> findDishsByAvatarImg(
		java.lang.String avatarImg);

	public java.util.List<irestads.model.Dish> findDishsByDetailImg(
		java.lang.String detailImg);

	public java.util.List<irestads.model.Dish> findDishsByDetail(
		java.lang.String detail);

	public java.util.List<irestads.model.Dish> findDishsByCategoryName(
		java.lang.String categoryName);

	public java.util.List<irestads.model.Dish> findDishsBySomeField(
		long dishId, int referPrice, java.lang.String dishName,
		java.lang.String decription, java.lang.String avatarImg,
		java.lang.String detailImg, java.lang.String detail);
}