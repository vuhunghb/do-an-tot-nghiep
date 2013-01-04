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
 * This class is a wrapper for {@link LopService}.
 * </p>
 *
 * @author    ADMIN
 * @see       LopService
 * @generated
 */
public class LopServiceWrapper implements LopService,
	ServiceWrapper<LopService> {
	public LopServiceWrapper(LopService lopService) {
		_lopService = lopService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _lopService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_lopService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _lopService.invokeMethod(name, parameterTypes, arguments);
	}

	public java.util.List<irestads.model.Lop> getAllLop() {
		return _lopService.getAllLop();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public LopService getWrappedLopService() {
		return _lopService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedLopService(LopService lopService) {
		_lopService = lopService;
	}

	public LopService getWrappedService() {
		return _lopService;
	}

	public void setWrappedService(LopService lopService) {
		_lopService = lopService;
	}

	private LopService _lopService;
}