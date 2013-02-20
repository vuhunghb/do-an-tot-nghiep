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
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import irestads.model.Dish;
import irestads.model.DishModel;
import irestads.model.DishSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the Dish service. Represents a row in the &quot;dishsstore_Dish&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link irestads.model.DishModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link DishImpl}.
 * </p>
 *
 * @author Be
 * @see DishImpl
 * @see irestads.model.Dish
 * @see irestads.model.DishModel
 * @generated
 */
@JSON(strict = true)
public class DishModelImpl extends BaseModelImpl<Dish> implements DishModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a dish model instance should use the {@link irestads.model.Dish} interface instead.
	 */
	public static final String TABLE_NAME = "dishsstore_Dish";
	public static final Object[][] TABLE_COLUMNS = {
			{ "dishId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "dishName", Types.VARCHAR },
			{ "decription", Types.VARCHAR },
			{ "avatarImg", Types.VARCHAR },
			{ "avatarBaseCode", Types.CLOB },
			{ "detailImg", Types.VARCHAR },
			{ "detailBaseCode", Types.CLOB },
			{ "detail", Types.VARCHAR },
			{ "referPrice", Types.INTEGER },
			{ "numOfDiner", Types.INTEGER },
			{ "categoryId", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table dishsstore_Dish (dishId LONG not null primary key,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,dishName VARCHAR(75) null,decription VARCHAR(75) null,avatarImg VARCHAR(75) null,avatarBaseCode TEXT null,detailImg VARCHAR(75) null,detailBaseCode TEXT null,detail VARCHAR(75) null,referPrice INTEGER,numOfDiner INTEGER,categoryId LONG)";
	public static final String TABLE_SQL_DROP = "drop table dishsstore_Dish";
	public static final String ORDER_BY_JPQL = " ORDER BY dish.dishName ASC";
	public static final String ORDER_BY_SQL = " ORDER BY dishsstore_Dish.dishName ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.irestads.model.Dish"), true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.irestads.model.Dish"), true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.irestads.model.Dish"), true);
	public static long DISHNAME_COLUMN_BITMASK = 1L;
	public static long REFERPRICE_COLUMN_BITMASK = 2L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Dish toModel(DishSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Dish model = new DishImpl();

		model.setDishId(soapModel.getDishId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setDishName(soapModel.getDishName());
		model.setDecription(soapModel.getDecription());
		model.setAvatarImg(soapModel.getAvatarImg());
		model.setAvatarBaseCode(soapModel.getAvatarBaseCode());
		model.setDetailImg(soapModel.getDetailImg());
		model.setDetailBaseCode(soapModel.getDetailBaseCode());
		model.setDetail(soapModel.getDetail());
		model.setReferPrice(soapModel.getReferPrice());
		model.setNumOfDiner(soapModel.getNumOfDiner());
		model.setCategoryId(soapModel.getCategoryId());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Dish> toModels(DishSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Dish> models = new ArrayList<Dish>(soapModels.length);

		for (DishSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.irestads.model.Dish"));

	public DishModelImpl() {
	}

	public long getPrimaryKey() {
		return _dishId;
	}

	public void setPrimaryKey(long primaryKey) {
		setDishId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_dishId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public Class<?> getModelClass() {
		return Dish.class;
	}

	public String getModelClassName() {
		return Dish.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("dishId", getDishId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("dishName", getDishName());
		attributes.put("decription", getDecription());
		attributes.put("avatarImg", getAvatarImg());
		attributes.put("avatarBaseCode", getAvatarBaseCode());
		attributes.put("detailImg", getDetailImg());
		attributes.put("detailBaseCode", getDetailBaseCode());
		attributes.put("detail", getDetail());
		attributes.put("referPrice", getReferPrice());
		attributes.put("numOfDiner", getNumOfDiner());
		attributes.put("categoryId", getCategoryId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long dishId = (Long)attributes.get("dishId");

		if (dishId != null) {
			setDishId(dishId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String dishName = (String)attributes.get("dishName");

		if (dishName != null) {
			setDishName(dishName);
		}

		String decription = (String)attributes.get("decription");

		if (decription != null) {
			setDecription(decription);
		}

		String avatarImg = (String)attributes.get("avatarImg");

		if (avatarImg != null) {
			setAvatarImg(avatarImg);
		}

		String avatarBaseCode = (String)attributes.get("avatarBaseCode");

		if (avatarBaseCode != null) {
			setAvatarBaseCode(avatarBaseCode);
		}

		String detailImg = (String)attributes.get("detailImg");

		if (detailImg != null) {
			setDetailImg(detailImg);
		}

		String detailBaseCode = (String)attributes.get("detailBaseCode");

		if (detailBaseCode != null) {
			setDetailBaseCode(detailBaseCode);
		}

		String detail = (String)attributes.get("detail");

		if (detail != null) {
			setDetail(detail);
		}

		Integer referPrice = (Integer)attributes.get("referPrice");

		if (referPrice != null) {
			setReferPrice(referPrice);
		}

		Integer numOfDiner = (Integer)attributes.get("numOfDiner");

		if (numOfDiner != null) {
			setNumOfDiner(numOfDiner);
		}

		Long categoryId = (Long)attributes.get("categoryId");

		if (categoryId != null) {
			setCategoryId(categoryId);
		}
	}

	@JSON
	public long getDishId() {
		return _dishId;
	}

	public void setDishId(long dishId) {
		_dishId = dishId;
	}

	@JSON
	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@JSON
	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@JSON
	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	@JSON
	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	@JSON
	public String getDishName() {
		if (_dishName == null) {
			return StringPool.BLANK;
		}
		else {
			return _dishName;
		}
	}

	public void setDishName(String dishName) {
		_columnBitmask = -1L;

		if (_originalDishName == null) {
			_originalDishName = _dishName;
		}

		_dishName = dishName;
	}

	public String getOriginalDishName() {
		return GetterUtil.getString(_originalDishName);
	}

	@JSON
	public String getDecription() {
		if (_decription == null) {
			return StringPool.BLANK;
		}
		else {
			return _decription;
		}
	}

	public void setDecription(String decription) {
		_decription = decription;
	}

	@JSON
	public String getAvatarImg() {
		if (_avatarImg == null) {
			return StringPool.BLANK;
		}
		else {
			return _avatarImg;
		}
	}

	public void setAvatarImg(String avatarImg) {
		_avatarImg = avatarImg;
	}

	@JSON
	public String getAvatarBaseCode() {
		if (_avatarBaseCode == null) {
			return StringPool.BLANK;
		}
		else {
			return _avatarBaseCode;
		}
	}

	public void setAvatarBaseCode(String avatarBaseCode) {
		_avatarBaseCode = avatarBaseCode;
	}

	@JSON
	public String getDetailImg() {
		if (_detailImg == null) {
			return StringPool.BLANK;
		}
		else {
			return _detailImg;
		}
	}

	public void setDetailImg(String detailImg) {
		_detailImg = detailImg;
	}

	@JSON
	public String getDetailBaseCode() {
		if (_detailBaseCode == null) {
			return StringPool.BLANK;
		}
		else {
			return _detailBaseCode;
		}
	}

	public void setDetailBaseCode(String detailBaseCode) {
		_detailBaseCode = detailBaseCode;
	}

	@JSON
	public String getDetail() {
		if (_detail == null) {
			return StringPool.BLANK;
		}
		else {
			return _detail;
		}
	}

	public void setDetail(String detail) {
		_detail = detail;
	}

	@JSON
	public int getReferPrice() {
		return _referPrice;
	}

	public void setReferPrice(int referPrice) {
		_columnBitmask |= REFERPRICE_COLUMN_BITMASK;

		if (!_setOriginalReferPrice) {
			_setOriginalReferPrice = true;

			_originalReferPrice = _referPrice;
		}

		_referPrice = referPrice;
	}

	public int getOriginalReferPrice() {
		return _originalReferPrice;
	}

	@JSON
	public int getNumOfDiner() {
		return _numOfDiner;
	}

	public void setNumOfDiner(int numOfDiner) {
		_numOfDiner = numOfDiner;
	}

	@JSON
	public long getCategoryId() {
		return _categoryId;
	}

	public void setCategoryId(long categoryId) {
		_categoryId = categoryId;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			Dish.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Dish toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (Dish)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public Object clone() {
		DishImpl dishImpl = new DishImpl();

		dishImpl.setDishId(getDishId());
		dishImpl.setCompanyId(getCompanyId());
		dishImpl.setUserId(getUserId());
		dishImpl.setUserName(getUserName());
		dishImpl.setCreateDate(getCreateDate());
		dishImpl.setModifiedDate(getModifiedDate());
		dishImpl.setDishName(getDishName());
		dishImpl.setDecription(getDecription());
		dishImpl.setAvatarImg(getAvatarImg());
		dishImpl.setAvatarBaseCode(getAvatarBaseCode());
		dishImpl.setDetailImg(getDetailImg());
		dishImpl.setDetailBaseCode(getDetailBaseCode());
		dishImpl.setDetail(getDetail());
		dishImpl.setReferPrice(getReferPrice());
		dishImpl.setNumOfDiner(getNumOfDiner());
		dishImpl.setCategoryId(getCategoryId());

		dishImpl.resetOriginalValues();

		return dishImpl;
	}

	public int compareTo(Dish dish) {
		int value = 0;

		value = getDishName().compareTo(dish.getDishName());

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

		Dish dish = null;

		try {
			dish = (Dish)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = dish.getPrimaryKey();

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
		DishModelImpl dishModelImpl = this;

		dishModelImpl._originalDishName = dishModelImpl._dishName;

		dishModelImpl._originalReferPrice = dishModelImpl._referPrice;

		dishModelImpl._setOriginalReferPrice = false;

		dishModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Dish> toCacheModel() {
		DishCacheModel dishCacheModel = new DishCacheModel();

		dishCacheModel.dishId = getDishId();

		dishCacheModel.companyId = getCompanyId();

		dishCacheModel.userId = getUserId();

		dishCacheModel.userName = getUserName();

		String userName = dishCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			dishCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			dishCacheModel.createDate = createDate.getTime();
		}
		else {
			dishCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			dishCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			dishCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		dishCacheModel.dishName = getDishName();

		String dishName = dishCacheModel.dishName;

		if ((dishName != null) && (dishName.length() == 0)) {
			dishCacheModel.dishName = null;
		}

		dishCacheModel.decription = getDecription();

		String decription = dishCacheModel.decription;

		if ((decription != null) && (decription.length() == 0)) {
			dishCacheModel.decription = null;
		}

		dishCacheModel.avatarImg = getAvatarImg();

		String avatarImg = dishCacheModel.avatarImg;

		if ((avatarImg != null) && (avatarImg.length() == 0)) {
			dishCacheModel.avatarImg = null;
		}

		dishCacheModel.avatarBaseCode = getAvatarBaseCode();

		String avatarBaseCode = dishCacheModel.avatarBaseCode;

		if ((avatarBaseCode != null) && (avatarBaseCode.length() == 0)) {
			dishCacheModel.avatarBaseCode = null;
		}

		dishCacheModel.detailImg = getDetailImg();

		String detailImg = dishCacheModel.detailImg;

		if ((detailImg != null) && (detailImg.length() == 0)) {
			dishCacheModel.detailImg = null;
		}

		dishCacheModel.detailBaseCode = getDetailBaseCode();

		String detailBaseCode = dishCacheModel.detailBaseCode;

		if ((detailBaseCode != null) && (detailBaseCode.length() == 0)) {
			dishCacheModel.detailBaseCode = null;
		}

		dishCacheModel.detail = getDetail();

		String detail = dishCacheModel.detail;

		if ((detail != null) && (detail.length() == 0)) {
			dishCacheModel.detail = null;
		}

		dishCacheModel.referPrice = getReferPrice();

		dishCacheModel.numOfDiner = getNumOfDiner();

		dishCacheModel.categoryId = getCategoryId();

		return dishCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{dishId=");
		sb.append(getDishId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", dishName=");
		sb.append(getDishName());
		sb.append(", decription=");
		sb.append(getDecription());
		sb.append(", avatarImg=");
		sb.append(getAvatarImg());
		sb.append(", avatarBaseCode=");
		sb.append(getAvatarBaseCode());
		sb.append(", detailImg=");
		sb.append(getDetailImg());
		sb.append(", detailBaseCode=");
		sb.append(getDetailBaseCode());
		sb.append(", detail=");
		sb.append(getDetail());
		sb.append(", referPrice=");
		sb.append(getReferPrice());
		sb.append(", numOfDiner=");
		sb.append(getNumOfDiner());
		sb.append(", categoryId=");
		sb.append(getCategoryId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(52);

		sb.append("<model><model-name>");
		sb.append("irestads.model.Dish");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>dishId</column-name><column-value><![CDATA[");
		sb.append(getDishId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dishName</column-name><column-value><![CDATA[");
		sb.append(getDishName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>decription</column-name><column-value><![CDATA[");
		sb.append(getDecription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>avatarImg</column-name><column-value><![CDATA[");
		sb.append(getAvatarImg());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>avatarBaseCode</column-name><column-value><![CDATA[");
		sb.append(getAvatarBaseCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>detailImg</column-name><column-value><![CDATA[");
		sb.append(getDetailImg());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>detailBaseCode</column-name><column-value><![CDATA[");
		sb.append(getDetailBaseCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>detail</column-name><column-value><![CDATA[");
		sb.append(getDetail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>referPrice</column-name><column-value><![CDATA[");
		sb.append(getReferPrice());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>numOfDiner</column-name><column-value><![CDATA[");
		sb.append(getNumOfDiner());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>categoryId</column-name><column-value><![CDATA[");
		sb.append(getCategoryId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = Dish.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			Dish.class
		};
	private long _dishId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _dishName;
	private String _originalDishName;
	private String _decription;
	private String _avatarImg;
	private String _avatarBaseCode;
	private String _detailImg;
	private String _detailBaseCode;
	private String _detail;
	private int _referPrice;
	private int _originalReferPrice;
	private boolean _setOriginalReferPrice;
	private int _numOfDiner;
	private long _categoryId;
	private long _columnBitmask;
	private Dish _escapedModelProxy;
}