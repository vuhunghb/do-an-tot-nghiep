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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link irestads.service.http.SinhVienServiceSoap}.
 *
 * @author    ADMIN
 * @see       irestads.service.http.SinhVienServiceSoap
 * @generated
 */
public class SinhVienSoap implements Serializable {
	public static SinhVienSoap toSoapModel(SinhVien model) {
		SinhVienSoap soapModel = new SinhVienSoap();

		soapModel.setSinhVienId(model.getSinhVienId());
		soapModel.setMssv(model.getMssv());
		soapModel.setTen(model.getTen());
		soapModel.setDiaChi(model.getDiaChi());
		soapModel.setDiem(model.getDiem());
		soapModel.setLopId(model.getLopId());

		return soapModel;
	}

	public static SinhVienSoap[] toSoapModels(SinhVien[] models) {
		SinhVienSoap[] soapModels = new SinhVienSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SinhVienSoap[][] toSoapModels(SinhVien[][] models) {
		SinhVienSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SinhVienSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SinhVienSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SinhVienSoap[] toSoapModels(List<SinhVien> models) {
		List<SinhVienSoap> soapModels = new ArrayList<SinhVienSoap>(models.size());

		for (SinhVien model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SinhVienSoap[soapModels.size()]);
	}

	public SinhVienSoap() {
	}

	public long getPrimaryKey() {
		return _sinhVienId;
	}

	public void setPrimaryKey(long pk) {
		setSinhVienId(pk);
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

	private long _sinhVienId;
	private String _mssv;
	private String _ten;
	private String _diaChi;
	private double _diem;
	private String _lopId;
}