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
 * The interface for the menu line remote service.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Be
 * @see MenuLineServiceUtil
 * @see irestads.service.base.MenuLineServiceBaseImpl
 * @see irestads.service.impl.MenuLineServiceImpl
 * @generated
 */
@JSONWebService
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface MenuLineService extends BaseService, InvokableService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MenuLineServiceUtil} to access the menu line remote service. Add custom service methods to {@link irestads.service.impl.MenuLineServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
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

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<irestads.model.MenuLine> getAllMenuLine();

	public irestads.model.MenuLine createMenuLine(java.lang.String dishName,
		java.lang.String decription, java.lang.String avatarImg,
		java.lang.String detailImg, java.lang.String detail, int referPrice,
		java.lang.String avatarBaseCode, java.lang.String detailBaseCode,
		long categoryId, int numOfDish, boolean status);

	public irestads.model.MenuLine createMenuLineDish(
		irestads.model.MenuLine ml);

	public irestads.model.MenuLine createMenuLine(irestads.model.MenuLine ml);

	public irestads.model.MenuLine createMenuLine(long dishId, int numOfDish,
		boolean status);

	public java.util.List<irestads.model.MenuLine> createMenuLine(
		java.util.List<irestads.model.MenuLine> mls);

	public irestads.model.MenuLine updateMenuLine(irestads.model.MenuLine ml);

	public irestads.model.MenuLine deleteMenuLine(irestads.model.MenuLine ml);

	public irestads.model.MenuLine findMenuLineById(long menuLineId);

	public java.util.List<irestads.model.MenuLine> findMenuLinesByDReferPrice(
		int price);

	public irestads.model.MenuLine setDishForMenuLine(
		irestads.model.MenuLine menuLine);

	public java.util.List<irestads.model.MenuLine> findMenuLinesByDishId(
		long dishId);

	public java.util.List<irestads.model.MenuLine> findMenuLinesByDName(
		java.lang.String dishName);

	public java.util.List<irestads.model.MenuLine> findMenuLinesByDDecription(
		java.lang.String decription);

	public java.util.List<irestads.model.MenuLine> findMenuLinesByDAvatarImg(
		java.lang.String avartarImg);

	public java.util.List<irestads.model.MenuLine> findMenuLinesByDDetailImg(
		java.lang.String detailImg);

	public java.util.List<irestads.model.MenuLine> findMenuLinesByDDetail(
		java.lang.String detail);

	public java.util.List<irestads.model.MenuLine> findMenuLinesByDCategoryName(
		java.lang.String categoryName);

	public java.util.List<irestads.model.MenuLine> findMenuLinesByNumOfDish(
		int numOfDish);

	public java.util.List<irestads.model.MenuLine> findMenuLinesByStatus(
		boolean status);

	public java.lang.String parseBooleanToShow(boolean value,
		java.lang.String TValue, java.lang.String Fvalue);
}