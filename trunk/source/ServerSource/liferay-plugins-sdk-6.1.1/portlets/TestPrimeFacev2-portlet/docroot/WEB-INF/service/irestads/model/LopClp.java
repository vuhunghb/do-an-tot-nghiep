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

import irestads.service.LopLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ADMIN
 */
public class LopClp extends BaseModelImpl<Lop> implements Lop {
	public LopClp() {
	}

	public Class<?> getModelClass() {
		return Lop.class;
	}

	public String getModelClassName() {
		return Lop.class.getName();
	}

	public long getPrimaryKey() {
		return _lopId;
	}

	public void setPrimaryKey(long primaryKey) {
		setLopId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_lopId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("lopId", getLopId());
		attributes.put("tenLop", getTenLop());

		return attributes;
	}

	@Override
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

	public long getLopId() {
		return _lopId;
	}

	public void setLopId(long lopId) {
		_lopId = lopId;
	}

	public String getTenLop() {
		return _tenLop;
	}

	public void setTenLop(String tenLop) {
		_tenLop = tenLop;
	}

	public void setDssv(java.util.List<irestads.model.SinhVien> dssv) {
		throw new UnsupportedOperationException();
	}

	public java.util.List<irestads.model.SinhVien> getDssv() {
		throw new UnsupportedOperationException();
	}

	public BaseModel<?> getLopRemoteModel() {
		return _lopRemoteModel;
	}

	public void setLopRemoteModel(BaseModel<?> lopRemoteModel) {
		_lopRemoteModel = lopRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			LopLocalServiceUtil.addLop(this);
		}
		else {
			LopLocalServiceUtil.updateLop(this);
		}
	}

	@Override
	public Lop toEscapedModel() {
		return (Lop)Proxy.newProxyInstance(Lop.class.getClassLoader(),
			new Class[] { Lop.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		LopClp clone = new LopClp();

		clone.setLopId(getLopId());
		clone.setTenLop(getTenLop());

		return clone;
	}

	public int compareTo(Lop lop) {
		int value = 0;

		if (getLopId() < lop.getLopId()) {
			value = -1;
		}
		else if (getLopId() > lop.getLopId()) {
			value = 1;
		}
		else {
			value = 0;
		}

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

		LopClp lop = null;

		try {
			lop = (LopClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = lop.getPrimaryKey();

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
		StringBundler sb = new StringBundler(5);

		sb.append("{lopId=");
		sb.append(getLopId());
		sb.append(", tenLop=");
		sb.append(getTenLop());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append("irestads.model.Lop");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>lopId</column-name><column-value><![CDATA[");
		sb.append(getLopId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tenLop</column-name><column-value><![CDATA[");
		sb.append(getTenLop());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _lopId;
	private String _tenLop;
	private BaseModel<?> _lopRemoteModel;
}