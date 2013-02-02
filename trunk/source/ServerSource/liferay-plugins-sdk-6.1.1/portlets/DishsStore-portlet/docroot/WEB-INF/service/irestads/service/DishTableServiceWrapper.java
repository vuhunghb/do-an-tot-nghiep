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

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link DishTableService}.
 * </p>
 *
 * @author    Be
 * @see       DishTableService
 * @generated
 */
public class DishTableServiceWrapper implements DishTableService,
	ServiceWrapper<DishTableService> {
	public DishTableServiceWrapper(DishTableService dishTableService) {
		_dishTableService = dishTableService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _dishTableService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_dishTableService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _dishTableService.invokeMethod(name, parameterTypes, arguments);
	}

	public java.util.List<irestads.model.DishTable> getAllDishTables() {
		return _dishTableService.getAllDishTables();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public DishTableService getWrappedDishTableService() {
		return _dishTableService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedDishTableService(DishTableService dishTableService) {
		_dishTableService = dishTableService;
	}

	public DishTableService getWrappedService() {
		return _dishTableService;
	}

	public void setWrappedService(DishTableService dishTableService) {
		_dishTableService = dishTableService;
	}

	private DishTableService _dishTableService;
}