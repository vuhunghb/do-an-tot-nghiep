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

package irestads.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import irestads.service.SinhVienLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ADMIN
 */
public class SinhVienClp extends BaseModelImpl<SinhVien> implements SinhVien {
	public SinhVienClp() {
	}

	public Class<?> getModelClass() {
		return SinhVien.class;
	}

	public String getModelClassName() {
		return SinhVien.class.getName();
	}

	public long getPrimaryKey() {
		return _sinhVienId;
	}

	public void setPrimaryKey(long primaryKey) {
		setSinhVienId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_sinhVienId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("sinhVienId", getSinhVienId());
		attributes.put("mssv", getMssv());
		attributes.put("ten", getTen());
		attributes.put("diaChi", getDiaChi());
		attributes.put("diem", getDiem());
		attributes.put("lopId", getLopId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long sinhVienId = (Long)attributes.get("sinhVienId");

		if (sinhVienId != null) {
			setSinhVienId(sinhVienId);
		}

		String mssv = (String)attributes.get("mssv");

		if (mssv != null) {
			setMssv(mssv);
		}

		String ten = (String)attributes.get("ten");

		if (ten != null) {
			setTen(ten);
		}

		String diaChi = (String)attributes.get("diaChi");

		if (diaChi != null) {
			setDiaChi(diaChi);
		}

		Double diem = (Double)attributes.get("diem");

		if (diem != null) {
			setDiem(diem);
		}

		String lopId = (String)attributes.get("lopId");

		if (lopId != null) {
			setLopId(lopId);
		}
	}

	public long getSinhVienId() {
		return _sinhVienId;
	}

	public void setSinhVienId(long sinhVienId) {
		_sinhVienId = sinhVienId;
	}

	public String getMssv() {
		return _mssv;
	}

	public void setMssv(String mssv) {
		_mssv = mssv;
	}

	public String getTen() {
		return _ten;
	}

	public void setTen(String ten) {
		_ten = ten;
	}

	public String getDiaChi() {
		return _diaChi;
	}

	public void setDiaChi(String diaChi) {
		_diaChi = diaChi;
	}

	public double getDiem() {
		return _diem;
	}

	public void setDiem(double diem) {
		_diem = diem;
	}

	public String getLopId() {
		return _lopId;
	}

	public void setLopId(String lopId) {
		_lopId = lopId;
	}

	public BaseModel<?> getSinhVienRemoteModel() {
		return _sinhVienRemoteModel;
	}

	public void setSinhVienRemoteModel(BaseModel<?> sinhVienRemoteModel) {
		_sinhVienRemoteModel = sinhVienRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			SinhVienLocalServiceUtil.addSinhVien(this);
		}
		else {
			SinhVienLocalServiceUtil.updateSinhVien(this);
		}
	}

	@Override
	public SinhVien toEscapedModel() {
		return (SinhVien)Proxy.newProxyInstance(SinhVien.class.getClassLoader(),
			new Class[] { SinhVien.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SinhVienClp clone = new SinhVienClp();

		clone.setSinhVienId(getSinhVienId());
		clone.setMssv(getMssv());
		clone.setTen(getTen());
		clone.setDiaChi(getDiaChi());
		clone.setDiem(getDiem());
		clone.setLopId(getLopId());

		return clone;
	}

	public int compareTo(SinhVien sinhVien) {
		int value = 0;

		value = getLopId().compareTo(sinhVien.getLopId());

		if (value != 0) {
			return value;
		}

		value = getMssv().compareTo(sinhVien.getMssv());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		SinhVienClp sinhVien = null;

		try {
			sinhVien = (SinhVienClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = sinhVien.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{sinhVienId=");
		sb.append(getSinhVienId());
		sb.append(", mssv=");
		sb.append(getMssv());
		sb.append(", ten=");
		sb.append(getTen());
		sb.append(", diaChi=");
		sb.append(getDiaChi());
		sb.append(", diem=");
		sb.append(getDiem());
		sb.append(", lopId=");
		sb.append(getLopId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("irestads.model.SinhVien");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>sinhVienId</column-name><column-value><![CDATA[");
		sb.append(getSinhVienId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mssv</column-name><column-value><![CDATA[");
		sb.append(getMssv());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ten</column-name><column-value><![CDATA[");
		sb.append(getTen());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>diaChi</column-name><column-value><![CDATA[");
		sb.append(getDiaChi());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>diem</column-name><column-value><![CDATA[");
		sb.append(getDiem());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lopId</column-name><column-value><![CDATA[");
		sb.append(getLopId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _sinhVienId;
	private String _mssv;
	private String _ten;
	private String _diaChi;
	private double _diem;
	private String _lopId;
	private BaseModel<?> _sinhVienRemoteModel;
}