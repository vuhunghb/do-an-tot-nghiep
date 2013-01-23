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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * The utility for the menu line remote service. This utility wraps {@link irestads.service.impl.MenuLineServiceImpl} and is the primary access point for service operations in application layer code running on a remote server.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Be
 * @see MenuLineService
 * @see irestads.service.base.MenuLineServiceBaseImpl
 * @see irestads.service.impl.MenuLineServiceImpl
 * @generated
 */
public class MenuLineServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link irestads.service.impl.MenuLineServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static java.util.List<irestads.model.MenuLine> getAllMenuLine() {
		return getService().getAllMenuLine();
	}

	public static irestads.model.MenuLine createMenuLine(
		java.lang.String dishName, java.lang.String decription,
		java.lang.String avatarImg, java.lang.String detailImg,
		java.lang.String detail, int referPrice,
		java.lang.String avatarBaseCode, java.lang.String detailBaseCode,
		long categoryId, int numOfDish, boolean status) {
		return getService()
				   .createMenuLine(dishName, decription, avatarImg, detailImg,
			detail, referPrice, avatarBaseCode, detailBaseCode, categoryId,
			numOfDish, status);
	}

	public static irestads.model.MenuLine createMenuLineDish(
		irestads.model.MenuLine ml) {
		return getService().createMenuLineDish(ml);
	}

	public static irestads.model.MenuLine createMenuLine(
		irestads.model.MenuLine ml) {
		return getService().createMenuLine(ml);
	}

	public static irestads.model.MenuLine createMenuLine(long dishId,
		int numOfDish, boolean status) {
		return getService().createMenuLine(dishId, numOfDish, status);
	}

	public static java.util.List<irestads.model.MenuLine> createMenuLine(
		java.util.List<irestads.model.MenuLine> mls) {
		return getService().createMenuLine(mls);
	}

	public static irestads.model.MenuLine updateMenuLine(
		irestads.model.MenuLine ml) {
		return getService().updateMenuLine(ml);
	}

	public static irestads.model.MenuLine deleteMenuLine(
		irestads.model.MenuLine ml) {
		return getService().deleteMenuLine(ml);
	}

	public static irestads.model.MenuLine findMenuLineById(long menuLineId) {
		return getService().findMenuLineById(menuLineId);
	}

	public static java.util.List<irestads.model.MenuLine> findMenuLinesByDReferPrice(
		int price) {
		return getService().findMenuLinesByDReferPrice(price);
	}

	public static irestads.model.MenuLine setDishForMenuLine(
		irestads.model.MenuLine menuLine) {
		return getService().setDishForMenuLine(menuLine);
	}

	public static java.util.List<irestads.model.MenuLine> findMenuLinesByDishId(
		long dishId) {
		return getService().findMenuLinesByDishId(dishId);
	}

	public static java.util.List<irestads.model.MenuLine> findMenuLinesByDName(
		java.lang.String dishName) {
		return getService().findMenuLinesByDName(dishName);
	}

	public static java.util.List<irestads.model.MenuLine> findMenuLinesByDDecription(
		java.lang.String decription) {
		return getService().findMenuLinesByDDecription(decription);
	}

	public static java.util.List<irestads.model.MenuLine> findMenuLinesByDAvatarImg(
		java.lang.String avartarImg) {
		return getService().findMenuLinesByDAvatarImg(avartarImg);
	}

	public static java.util.List<irestads.model.MenuLine> findMenuLinesByDDetailImg(
		java.lang.String detailImg) {
		return getService().findMenuLinesByDDetailImg(detailImg);
	}

	public static java.util.List<irestads.model.MenuLine> findMenuLinesByDDetail(
		java.lang.String detail) {
		return getService().findMenuLinesByDDetail(detail);
	}

	public static java.util.List<irestads.model.MenuLine> findMenuLinesByDCategoryName(
		java.lang.String categoryName) {
		return getService().findMenuLinesByDCategoryName(categoryName);
	}

	public static java.util.List<irestads.model.MenuLine> findMenuLinesByNumOfDish(
		int numOfDish) {
		return getService().findMenuLinesByNumOfDish(numOfDish);
	}

	public static java.util.List<irestads.model.MenuLine> findMenuLinesByStatus(
		boolean status) {
		return getService().findMenuLinesByStatus(status);
	}

	public static java.lang.String parseBooleanToShow(boolean value,
		java.lang.String TValue, java.lang.String Fvalue) {
		return getService().parseBooleanToShow(value, TValue, Fvalue);
	}

	public static void clearService() {
		_service = null;
	}

	public static MenuLineService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					MenuLineService.class.getName());

			if (invokableService instanceof MenuLineService) {
				_service = (MenuLineService)invokableService;
			}
			else {
				_service = new MenuLineServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(MenuLineServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(MenuLineService service) {
	}

	private static MenuLineService _service;
}