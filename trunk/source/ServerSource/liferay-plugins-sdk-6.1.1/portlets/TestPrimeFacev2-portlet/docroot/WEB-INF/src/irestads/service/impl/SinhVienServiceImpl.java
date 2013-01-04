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

import irestads.NoSuchSinhVienException;
import irestads.model.SinhVien;
import irestads.service.SinhVienLocalServiceUtil;
import irestads.service.base.SinhVienServiceBaseImpl;
import irestads.service.persistence.LopUtil;
import irestads.service.persistence.SinhVienUtil;

/**
 * The implementation of the sinh vien remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link irestads.service.SinhVienService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author ADMIN
 * @see irestads.service.base.SinhVienServiceBaseImpl
 * @see irestads.service.SinhVienServiceUtil
 */
public class SinhVienServiceImpl extends SinhVienServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link irestads.service.SinhVienServiceUtil} to access the sinh vien remote service.
	 */
	public List<SinhVien> getSinhVienByLop(long lopId){
	
		return SinhVienLocalServiceUtil.getSinhVienByLop(lopId);
	}
	public List<SinhVien> getAllSinhVien() {
		return SinhVienLocalServiceUtil.getAllSinhVien();
	}
	
	public SinhVien updateSinhVien(SinhVien sv){
		try {
			return SinhVienLocalServiceUtil.updateSinhVien(sv);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public SinhVien deleteSinhVien(SinhVien sv) {
		try {
			return SinhVienLocalServiceUtil.deleteSinhVien(sv);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}