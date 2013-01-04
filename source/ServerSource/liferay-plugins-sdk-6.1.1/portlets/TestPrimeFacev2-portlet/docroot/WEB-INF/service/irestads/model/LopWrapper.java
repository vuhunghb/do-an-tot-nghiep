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
 * This class is a wrapper for {@link Lop}.
 * </p>
 *
 * @author    ADMIN
 * @see       Lop
 * @generated
 */
public class LopWrapper implements Lop, ModelWrapper<Lop> {
	public LopWrapper(Lop lop) {
		_lop = lop;
	}

	public Class<?> getModelClass() {
		return Lop.class;
	}

	public String getModelClassName() {
		return Lop.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("lopId", getLopId());
		attributes.put("tenLop", getTenLop());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long lopId = (Long)attributes.get("lopId");

		if (lopId != null) {
			setLopId(lopId);
		}

		String tenLop = (String)attributes.get("tenLop");

		if (tenLop != null) {
			setTenLop(tenLop);
		}
	}

	/**
	* Returns the primary key of this lop.
	*
	* @return the primary key of this lop
	*/
	public long getPrimaryKey() {
		return _lop.getPrimaryKey();
	}

	/**
	* Sets the primary key of this lop.
	*
	* @param primaryKey the primary key of this lop
	*/
	public void setPrimaryKey(long primaryKey) {
		_lop.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the lop ID of this lop.
	*
	* @return the lop ID of this lop
	*/
	public long getLopId() {
		return _lop.getLopId();
	}

	/**
	* Sets the lop ID of this lop.
	*
	* @param lopId the lop ID of this lop
	*/
	public void setLopId(long lopId) {
		_lop.setLopId(lopId);
	}

	/**
	* Returns the ten lop of this lop.
	*
	* @return the ten lop of this lop
	*/
	public java.lang.String getTenLop() {
		return _lop.getTenLop();
	}

	/**
	* Sets the ten lop of this lop.
	*
	* @param tenLop the ten lop of this lop
	*/
	public void setTenLop(java.lang.String tenLop) {
		_lop.setTenLop(tenLop);
	}

	public boolean isNew() {
		return _lop.isNew();
	}

	public void setNew(boolean n) {
		_lop.setNew(n);
	}

	public boolean isCachedModel() {
		return _lop.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_lop.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _lop.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _lop.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_lop.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _lop.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_lop.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LopWrapper((Lop)_lop.clone());
	}

	public int compareTo(irestads.model.Lop lop) {
		return _lop.compareTo(lop);
	}

	@Override
	public int hashCode() {
		return _lop.hashCode();
	}

	public com.liferay.portal.model.CacheModel<irestads.model.Lop> toCacheModel() {
		return _lop.toCacheModel();
	}

	public irestads.model.Lop toEscapedModel() {
		return new LopWrapper(_lop.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _lop.toString();
	}

	public java.lang.String toXmlString() {
		return _lop.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_lop.persist();
	}

	public java.util.List<irestads.model.SinhVien> getDssv() {
		return _lop.getDssv();
	}

	public void setDssv(java.util.List<irestads.model.SinhVien> dssv) {
		_lop.setDssv(dssv);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Lop getWrappedLop() {
		return _lop;
	}

	public Lop getWrappedModel() {
		return _lop;
	}

	public void resetOriginalValues() {
		_lop.resetOriginalValues();
	}

	private Lop _lop;
}