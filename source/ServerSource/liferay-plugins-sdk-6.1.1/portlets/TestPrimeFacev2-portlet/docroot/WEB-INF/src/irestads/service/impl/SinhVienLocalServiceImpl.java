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
import irestads.service.base.SinhVienLocalServiceBaseImpl;
import irestads.service.persistence.LopUtil;
import irestads.service.persistence.SinhVienUtil;

/**
 * The implementation of the sinh vien local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link irestads.service.SinhVienLocalService} interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author ADMIN
 * @see irestads.service.base.SinhVienLocalServiceBaseImpl
 * @see irestads.service.SinhVienLocalServiceUtil
 */
public class SinhVienLocalServiceImpl extends SinhVienLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * irestads.service.SinhVienLocalServiceUtil} to access the sinh vien local
	 * service.
	 */

	public List<SinhVien> getSinhVienByLop(long lopId) {
		try {
			return LopUtil.getSinhViens(lopId);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<SinhVien> getAllSinhVien() {

		try {
			return SinhVienUtil.findAll();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public SinhVien updateSinhVien(SinhVien sv) {
		try {
			SinhVien sinhVien = SinhVienUtil.fetchByPrimaryKey(sv
					.getPrimaryKey());
			if (sinhVien != null && sinhVien.getMssv() == sv.getMssv()) {
				sinhVien.setTen(sv.getTen());
				sinhVien.setDiaChi(sv.getDiaChi());
				sinhVien.setLopId(sv.getLopId());
				return SinhVienUtil.update(sinhVien, true);
			}

		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public SinhVien deleteSinhVien(SinhVien sv) {
		SinhVien sinhVien = null;
		try {
			sinhVien = SinhVienUtil.remove(sv.getPrimaryKey());
		} catch (NoSuchSinhVienException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sinhVien;
	}
}