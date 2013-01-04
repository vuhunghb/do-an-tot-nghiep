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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import irestads.model.SinhVien;
import irestads.model.SinhVienModel;
import irestads.model.SinhVienSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the SinhVien service. Represents a row in the &quot;testprimeface_SinhVien&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link irestads.model.SinhVienModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link SinhVienImpl}.
 * </p>
 *
 * @author ADMIN
 * @see SinhVienImpl
 * @see irestads.model.SinhVien
 * @see irestads.model.SinhVienModel
 * @generated
 */
@JSON(strict = true)
public class SinhVienModelImpl extends BaseModelImpl<SinhVien>
	implements SinhVienModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a sinh vien model instance should use the {@link irestads.model.SinhVien} interface instead.
	 */
	public static final String TABLE_NAME = "testprimeface_SinhVien";
	public static final Object[][] TABLE_COLUMNS = {
			{ "sinhVienId", Types.BIGINT },
			{ "mssv", Types.VARCHAR },
			{ "ten", Types.VARCHAR },
			{ "diaChi", Types.VARCHAR },
			{ "diem", Types.DOUBLE },
			{ "lopId", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table testprimeface_SinhVien (sinhVienId LONG not null primary key,mssv VARCHAR(75) null,ten VARCHAR(75) null,diaChi VARCHAR(75) null,diem DOUBLE,lopId VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table testprimeface_SinhVien";
	public static final String ORDER_BY_JPQL = " ORDER BY sinhVien.lopId ASC, sinhVien.mssv ASC";
	public static final String ORDER_BY_SQL = " ORDER BY testprimeface_SinhVien.lopId ASC, testprimeface_SinhVien.mssv ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.irestads.model.SinhVien"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.irestads.model.SinhVien"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static SinhVien toModel(SinhVienSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		SinhVien model = new SinhVienImpl();

		model.setSinhVienId(soapModel.getSinhVienId());
		model.setMssv(soapModel.getMssv());
		model.setTen(soapModel.getTen());
		model.setDiaChi(soapModel.getDiaChi());
		model.setDiem(soapModel.getDiem());
		model.setLopId(soapModel.getLopId());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<SinhVien> toModels(SinhVienSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<SinhVien> models = new ArrayList<SinhVien>(soapModels.length);

		for (SinhVienSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.irestads.model.SinhVien"));

	public SinhVienModelImpl() {
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

	public Class<?> getModelClass() {
		return SinhVien.class;
	}

	public String getModelClassName() {
		return SinhVien.class.getName();
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

	@JSON
	public long getSinhVienId() {
		return _sinhVienId;
	}

	public void setSinhVienId(long sinhVienId) {
		_sinhVienId = sinhVienId;
	}

	@JSON
	public String getMssv() {
		if (_mssv == null) {
			return StringPool.BLANK;
		}
		else {
			return _mssv;
		}
	}

	public void setMssv(String mssv) {
		_mssv = mssv;
	}

	@JSON
	public String getTen() {
		if (_ten == null) {
			return StringPool.BLANK;
		}
		else {
			return _ten;
		}
	}

	public void setTen(String ten) {
		_ten = ten;
	}

	@JSON
	public String getDiaChi() {
		if (_diaChi == null) {
			return StringPool.BLANK;
		}
		else {
			return _diaChi;
		}
	}

	public void setDiaChi(String diaChi) {
		_diaChi = diaChi;
	}

	@JSON
	public double getDiem() {
		return _diem;
	}

	public void setDiem(double diem) {
		_diem = diem;
	}

	@JSON
	public String getLopId() {
		if (_lopId == null) {
			return StringPool.BLANK;
		}
		else {
			return _lopId;
		}
	}

	public void setLopId(String lopId) {
		_lopId = lopId;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			SinhVien.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public SinhVien toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (SinhVien)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public Object clone() {
		SinhVienImpl sinhVienImpl = new SinhVienImpl();

		sinhVienImpl.setSinhVienId(getSinhVienId());
		sinhVienImpl.setMssv(getMssv());
		sinhVienImpl.setTen(getTen());
		sinhVienImpl.setDiaChi(getDiaChi());
		sinhVienImpl.setDiem(getDiem());
		sinhVienImpl.setLopId(getLopId());

		sinhVienImpl.resetOriginalValues();

		return sinhVienImpl;
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

		SinhVien sinhVien = null;

		try {
			sinhVien = (SinhVien)obj;
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
	public void resetOriginalValues() {
	}

	@Override
	public CacheModel<SinhVien> toCacheModel() {
		SinhVienCacheModel sinhVienCacheModel = new SinhVienCacheModel();

		sinhVienCacheModel.sinhVienId = getSinhVienId();

		sinhVienCacheModel.mssv = getMssv();

		String mssv = sinhVienCacheModel.mssv;

		if ((mssv != null) && (mssv.length() == 0)) {
			sinhVienCacheModel.mssv = null;
		}

		sinhVienCacheModel.ten = getTen();

		String ten = sinhVienCacheModel.ten;

		if ((ten != null) && (ten.length() == 0)) {
			sinhVienCacheModel.ten = null;
		}

		sinhVienCacheModel.diaChi = getDiaChi();

		String diaChi = sinhVienCacheModel.diaChi;

		if ((diaChi != null) && (diaChi.length() == 0)) {
			sinhVienCacheModel.diaChi = null;
		}

		sinhVienCacheModel.diem = getDiem();

		sinhVienCacheModel.lopId = getLopId();

		String lopId = sinhVienCacheModel.lopId;

		if ((lopId != null) && (lopId.length() == 0)) {
			sinhVienCacheModel.lopId = null;
		}

		return sinhVienCacheModel;
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

	private static ClassLoader _classLoader = SinhVien.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			SinhVien.class
		};
	private long _sinhVienId;
	private String _mssv;
	private String _ten;
	private String _diaChi;
	private double _diem;
	private String _lopId;
	private SinhVien _escapedModelProxy;
}