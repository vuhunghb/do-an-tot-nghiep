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

package irestads.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import irestads.model.SinhVien;

import java.io.Serializable;

/**
 * The cache model class for representing SinhVien in entity cache.
 *
 * @author ADMIN
 * @see SinhVien
 * @generated
 */
public class SinhVienCacheModel implements CacheModel<SinhVien>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{sinhVienId=");
		sb.append(sinhVienId);
		sb.append(", mssv=");
		sb.append(mssv);
		sb.append(", ten=");
		sb.append(ten);
		sb.append(", diaChi=");
		sb.append(diaChi);
		sb.append(", diem=");
		sb.append(diem);
		sb.append(", lopId=");
		sb.append(lopId);
		sb.append("}");

		return sb.toString();
	}

	public SinhVien toEntityModel() {
		SinhVienImpl sinhVienImpl = new SinhVienImpl();

		sinhVienImpl.setSinhVienId(sinhVienId);

		if (mssv == null) {
			sinhVienImpl.setMssv(StringPool.BLANK);
		}
		else {
			sinhVienImpl.setMssv(mssv);
		}

		if (ten == null) {
			sinhVienImpl.setTen(StringPool.BLANK);
		}
		else {
			sinhVienImpl.setTen(ten);
		}

		if (diaChi == null) {
			sinhVienImpl.setDiaChi(StringPool.BLANK);
		}
		else {
			sinhVienImpl.setDiaChi(diaChi);
		}

		sinhVienImpl.setDiem(diem);

		if (lopId == null) {
			sinhVienImpl.setLopId(StringPool.BLANK);
		}
		else {
			sinhVienImpl.setLopId(lopId);
		}

		sinhVienImpl.resetOriginalValues();

		return sinhVienImpl;
	}

	public long sinhVienId;
	public String mssv;
	public String ten;
	public String diaChi;
	public double diem;
	public String lopId;
}