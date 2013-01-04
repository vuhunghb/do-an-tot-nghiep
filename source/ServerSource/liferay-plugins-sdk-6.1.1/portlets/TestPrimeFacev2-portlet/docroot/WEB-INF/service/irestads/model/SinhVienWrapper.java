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

import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SinhVien}.
 * </p>
 *
 * @author    ADMIN
 * @see       SinhVien
 * @generated
 */
public class SinhVienWrapper implements SinhVien, ModelWrapper<SinhVien> {
	public SinhVienWrapper(SinhVien sinhVien) {
		_sinhVien = sinhVien;
	}

	public Class<?> getModelClass() {
		return SinhVien.class;
	}

	public String getModelClassName() {
		return SinhVien.class.getName();
	}

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

	/**
	* Returns the primary key of this sinh vien.
	*
	* @return the primary key of this sinh vien
	*/
	public long getPrimaryKey() {
		return _sinhVien.getPrimaryKey();
	}

	/**
	* Sets the primary key of this sinh vien.
	*
	* @param primaryKey the primary key of this sinh vien
	*/
	public void setPrimaryKey(long primaryKey) {
		_sinhVien.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the sinh vien ID of this sinh vien.
	*
	* @return the sinh vien ID of this sinh vien
	*/
	public long getSinhVienId() {
		return _sinhVien.getSinhVienId();
	}

	/**
	* Sets the sinh vien ID of this sinh vien.
	*
	* @param sinhVienId the sinh vien ID of this sinh vien
	*/
	public void setSinhVienId(long sinhVienId) {
		_sinhVien.setSinhVienId(sinhVienId);
	}

	/**
	* Returns the mssv of this sinh vien.
	*
	* @return the mssv of this sinh vien
	*/
	public java.lang.String getMssv() {
		return _sinhVien.getMssv();
	}

	/**
	* Sets the mssv of this sinh vien.
	*
	* @param mssv the mssv of this sinh vien
	*/
	public void setMssv(java.lang.String mssv) {
		_sinhVien.setMssv(mssv);
	}

	/**
	* Returns the ten of this sinh vien.
	*
	* @return the ten of this sinh vien
	*/
	public java.lang.String getTen() {
		return _sinhVien.getTen();
	}

	/**
	* Sets the ten of this sinh vien.
	*
	* @param ten the ten of this sinh vien
	*/
	public void setTen(java.lang.String ten) {
		_sinhVien.setTen(ten);
	}

	/**
	* Returns the dia chi of this sinh vien.
	*
	* @return the dia chi of this sinh vien
	*/
	public java.lang.String getDiaChi() {
		return _sinhVien.getDiaChi();
	}

	/**
	* Sets the dia chi of this sinh vien.
	*
	* @param diaChi the dia chi of this sinh vien
	*/
	public void setDiaChi(java.lang.String diaChi) {
		_sinhVien.setDiaChi(diaChi);
	}

	/**
	* Returns the diem of this sinh vien.
	*
	* @return the diem of this sinh vien
	*/
	public double getDiem() {
		return _sinhVien.getDiem();
	}

	/**
	* Sets the diem of this sinh vien.
	*
	* @param diem the diem of this sinh vien
	*/
	public void setDiem(double diem) {
		_sinhVien.setDiem(diem);
	}

	/**
	* Returns the lop ID of this sinh vien.
	*
	* @return the lop ID of this sinh vien
	*/
	public java.lang.String getLopId() {
		return _sinhVien.getLopId();
	}

	/**
	* Sets the lop ID of this sinh vien.
	*
	* @param lopId the lop ID of this sinh vien
	*/
	public void setLopId(java.lang.String lopId) {
		_sinhVien.setLopId(lopId);
	}

	public boolean isNew() {
		return _sinhVien.isNew();
	}

	public void setNew(boolean n) {
		_sinhVien.setNew(n);
	}

	public boolean isCachedModel() {
		return _sinhVien.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_sinhVien.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _sinhVien.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _sinhVien.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_sinhVien.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _sinhVien.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_sinhVien.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SinhVienWrapper((SinhVien)_sinhVien.clone());
	}

	public int compareTo(irestads.model.SinhVien sinhVien) {
		return _sinhVien.compareTo(sinhVien);
	}

	@Override
	public int hashCode() {
		return _sinhVien.hashCode();
	}

	public com.liferay.portal.model.CacheModel<irestads.model.SinhVien> toCacheModel() {
		return _sinhVien.toCacheModel();
	}

	public irestads.model.SinhVien toEscapedModel() {
		return new SinhVienWrapper(_sinhVien.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _sinhVien.toString();
	}

	public java.lang.String toXmlString() {
		return _sinhVien.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_sinhVien.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public SinhVien getWrappedSinhVien() {
		return _sinhVien;
	}

	public SinhVien getWrappedModel() {
		return _sinhVien;
	}

	public void resetOriginalValues() {
		_sinhVien.resetOriginalValues();
	}

	private SinhVien _sinhVien;
}