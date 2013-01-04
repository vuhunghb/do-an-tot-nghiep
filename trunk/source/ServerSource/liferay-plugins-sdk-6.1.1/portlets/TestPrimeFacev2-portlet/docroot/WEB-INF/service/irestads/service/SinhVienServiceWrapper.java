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
 * This class is a wrapper for {@link SinhVienService}.
 * </p>
 *
 * @author    ADMIN
 * @see       SinhVienService
 * @generated
 */
public class SinhVienServiceWrapper implements SinhVienService,
	ServiceWrapper<SinhVienService> {
	public SinhVienServiceWrapper(SinhVienService sinhVienService) {
		_sinhVienService = sinhVienService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _sinhVienService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_sinhVienService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _sinhVienService.invokeMethod(name, parameterTypes, arguments);
	}

	public java.util.List<irestads.model.SinhVien> getSinhVienByLop(long lopId) {
		return _sinhVienService.getSinhVienByLop(lopId);
	}

	public java.util.List<irestads.model.SinhVien> getAllSinhVien() {
		return _sinhVienService.getAllSinhVien();
	}

	public irestads.model.SinhVien updateSinhVien(irestads.model.SinhVien sv) {
		return _sinhVienService.updateSinhVien(sv);
	}

	public irestads.model.SinhVien deleteSinhVien(irestads.model.SinhVien sv) {
		return _sinhVienService.deleteSinhVien(sv);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public SinhVienService getWrappedSinhVienService() {
		return _sinhVienService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedSinhVienService(SinhVienService sinhVienService) {
		_sinhVienService = sinhVienService;
	}

	public SinhVienService getWrappedService() {
		return _sinhVienService;
	}

	public void setWrappedService(SinhVienService sinhVienService) {
		_sinhVienService = sinhVienService;
	}

	private SinhVienService _sinhVienService;
}