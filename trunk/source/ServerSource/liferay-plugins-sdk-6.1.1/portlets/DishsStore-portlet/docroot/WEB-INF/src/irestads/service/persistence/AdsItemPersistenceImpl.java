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

package irestads.service.persistence;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import irestads.NoSuchAdsItemException;

import irestads.model.AdsItem;

import irestads.model.impl.AdsItemImpl;
import irestads.model.impl.AdsItemModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the ads item service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Be
 * @see AdsItemPersistence
 * @see AdsItemUtil
 * @generated
 */
public class AdsItemPersistenceImpl extends BasePersistenceImpl<AdsItem>
	implements AdsItemPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link AdsItemUtil} to access the ads item persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = AdsItemImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PRODUCTNAME =
		new FinderPath(AdsItemModelImpl.ENTITY_CACHE_ENABLED,
			AdsItemModelImpl.FINDER_CACHE_ENABLED, AdsItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByProductName",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRODUCTNAME =
		new FinderPath(AdsItemModelImpl.ENTITY_CACHE_ENABLED,
			AdsItemModelImpl.FINDER_CACHE_ENABLED, AdsItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByProductName",
			new String[] { String.class.getName() },
			AdsItemModelImpl.PRODUCTNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PRODUCTNAME = new FinderPath(AdsItemModelImpl.ENTITY_CACHE_ENABLED,
			AdsItemModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByProductName",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TIMEDURING =
		new FinderPath(AdsItemModelImpl.ENTITY_CACHE_ENABLED,
			AdsItemModelImpl.FINDER_CACHE_ENABLED, AdsItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTimeDuring",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TIMEDURING =
		new FinderPath(AdsItemModelImpl.ENTITY_CACHE_ENABLED,
			AdsItemModelImpl.FINDER_CACHE_ENABLED, AdsItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTimeDuring",
			new String[] { Integer.class.getName() },
			AdsItemModelImpl.TIMEDURING_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TIMEDURING = new FinderPath(AdsItemModelImpl.ENTITY_CACHE_ENABLED,
			AdsItemModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTimeDuring",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AdsItemModelImpl.ENTITY_CACHE_ENABLED,
			AdsItemModelImpl.FINDER_CACHE_ENABLED, AdsItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AdsItemModelImpl.ENTITY_CACHE_ENABLED,
			AdsItemModelImpl.FINDER_CACHE_ENABLED, AdsItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AdsItemModelImpl.ENTITY_CACHE_ENABLED,
			AdsItemModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the ads item in the entity cache if it is enabled.
	 *
	 * @param adsItem the ads item
	 */
	public void cacheResult(AdsItem adsItem) {
		EntityCacheUtil.putResult(AdsItemModelImpl.ENTITY_CACHE_ENABLED,
			AdsItemImpl.class, adsItem.getPrimaryKey(), adsItem);

		adsItem.resetOriginalValues();
	}

	/**
	 * Caches the ads items in the entity cache if it is enabled.
	 *
	 * @param adsItems the ads items
	 */
	public void cacheResult(List<AdsItem> adsItems) {
		for (AdsItem adsItem : adsItems) {
			if (EntityCacheUtil.getResult(
						AdsItemModelImpl.ENTITY_CACHE_ENABLED,
						AdsItemImpl.class, adsItem.getPrimaryKey()) == null) {
				cacheResult(adsItem);
			}
			else {
				adsItem.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all ads items.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(AdsItemImpl.class.getName());
		}

		EntityCacheUtil.clearCache(AdsItemImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the ads item.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AdsItem adsItem) {
		EntityCacheUtil.removeResult(AdsItemModelImpl.ENTITY_CACHE_ENABLED,
			AdsItemImpl.class, adsItem.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<AdsItem> adsItems) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (AdsItem adsItem : adsItems) {
			EntityCacheUtil.removeResult(AdsItemModelImpl.ENTITY_CACHE_ENABLED,
				AdsItemImpl.class, adsItem.getPrimaryKey());
		}
	}

	/**
	 * Creates a new ads item with the primary key. Does not add the ads item to the database.
	 *
	 * @param adsItemId the primary key for the new ads item
	 * @return the new ads item
	 */
	public AdsItem create(long adsItemId) {
		AdsItem adsItem = new AdsItemImpl();

		adsItem.setNew(true);
		adsItem.setPrimaryKey(adsItemId);

		return adsItem;
	}

	/**
	 * Removes the ads item with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param adsItemId the primary key of the ads item
	 * @return the ads item that was removed
	 * @throws irestads.NoSuchAdsItemException if a ads item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AdsItem remove(long adsItemId)
		throws NoSuchAdsItemException, SystemException {
		return remove(Long.valueOf(adsItemId));
	}

	/**
	 * Removes the ads item with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the ads item
	 * @return the ads item that was removed
	 * @throws irestads.NoSuchAdsItemException if a ads item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdsItem remove(Serializable primaryKey)
		throws NoSuchAdsItemException, SystemException {
		Session session = null;

		try {
			session = openSession();

			AdsItem adsItem = (AdsItem)session.get(AdsItemImpl.class, primaryKey);

			if (adsItem == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAdsItemException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(adsItem);
		}
		catch (NoSuchAdsItemException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected AdsItem removeImpl(AdsItem adsItem) throws SystemException {
		adsItem = toUnwrappedModel(adsItem);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, adsItem);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(adsItem);

		return adsItem;
	}

	@Override
	public AdsItem updateImpl(irestads.model.AdsItem adsItem, boolean merge)
		throws SystemException {
		adsItem = toUnwrappedModel(adsItem);

		boolean isNew = adsItem.isNew();

		AdsItemModelImpl adsItemModelImpl = (AdsItemModelImpl)adsItem;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, adsItem, merge);

			adsItem.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !AdsItemModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((adsItemModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRODUCTNAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						adsItemModelImpl.getOriginalProductName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PRODUCTNAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRODUCTNAME,
					args);

				args = new Object[] { adsItemModelImpl.getProductName() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PRODUCTNAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRODUCTNAME,
					args);
			}

			if ((adsItemModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TIMEDURING.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Integer.valueOf(adsItemModelImpl.getOriginalTimeDuring())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TIMEDURING,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TIMEDURING,
					args);

				args = new Object[] {
						Integer.valueOf(adsItemModelImpl.getTimeDuring())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TIMEDURING,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TIMEDURING,
					args);
			}
		}

		EntityCacheUtil.putResult(AdsItemModelImpl.ENTITY_CACHE_ENABLED,
			AdsItemImpl.class, adsItem.getPrimaryKey(), adsItem);

		return adsItem;
	}

	protected AdsItem toUnwrappedModel(AdsItem adsItem) {
		if (adsItem instanceof AdsItemImpl) {
			return adsItem;
		}

		AdsItemImpl adsItemImpl = new AdsItemImpl();

		adsItemImpl.setNew(adsItem.isNew());
		adsItemImpl.setPrimaryKey(adsItem.getPrimaryKey());

		adsItemImpl.setAdsItemId(adsItem.getAdsItemId());
		adsItemImpl.setCompanyId(adsItem.getCompanyId());
		adsItemImpl.setUserId(adsItem.getUserId());
		adsItemImpl.setUserName(adsItem.getUserName());
		adsItemImpl.setCreateDate(adsItem.getCreateDate());
		adsItemImpl.setModifiedDate(adsItem.getModifiedDate());
		adsItemImpl.setCompanyName(adsItem.getCompanyName());
		adsItemImpl.setProductName(adsItem.getProductName());
		adsItemImpl.setNumberPhone(adsItem.getNumberPhone());
		adsItemImpl.setEmail(adsItem.getEmail());
		adsItemImpl.setAddress(adsItem.getAddress());
		adsItemImpl.setFacebook(adsItem.getFacebook());
		adsItemImpl.setTwitter(adsItem.getTwitter());
		adsItemImpl.setDescription(adsItem.getDescription());
		adsItemImpl.setImageContent(adsItem.getImageContent());
		adsItemImpl.setTimeDuring(adsItem.getTimeDuring());
		adsItemImpl.setTags(adsItem.getTags());
		adsItemImpl.setItemType(adsItem.getItemType());
		adsItemImpl.setCategoryAdsId(adsItem.getCategoryAdsId());

		return adsItemImpl;
	}

	/**
	 * Returns the ads item with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the ads item
	 * @return the ads item
	 * @throws com.liferay.portal.NoSuchModelException if a ads item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdsItem findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the ads item with the primary key or throws a {@link irestads.NoSuchAdsItemException} if it could not be found.
	 *
	 * @param adsItemId the primary key of the ads item
	 * @return the ads item
	 * @throws irestads.NoSuchAdsItemException if a ads item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AdsItem findByPrimaryKey(long adsItemId)
		throws NoSuchAdsItemException, SystemException {
		AdsItem adsItem = fetchByPrimaryKey(adsItemId);

		if (adsItem == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + adsItemId);
			}

			throw new NoSuchAdsItemException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				adsItemId);
		}

		return adsItem;
	}

	/**
	 * Returns the ads item with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the ads item
	 * @return the ads item, or <code>null</code> if a ads item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdsItem fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the ads item with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param adsItemId the primary key of the ads item
	 * @return the ads item, or <code>null</code> if a ads item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AdsItem fetchByPrimaryKey(long adsItemId) throws SystemException {
		AdsItem adsItem = (AdsItem)EntityCacheUtil.getResult(AdsItemModelImpl.ENTITY_CACHE_ENABLED,
				AdsItemImpl.class, adsItemId);

		if (adsItem == _nullAdsItem) {
			return null;
		}

		if (adsItem == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				adsItem = (AdsItem)session.get(AdsItemImpl.class,
						Long.valueOf(adsItemId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (adsItem != null) {
					cacheResult(adsItem);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(AdsItemModelImpl.ENTITY_CACHE_ENABLED,
						AdsItemImpl.class, adsItemId, _nullAdsItem);
				}

				closeSession(session);
			}
		}

		return adsItem;
	}

	/**
	 * Returns all the ads items where productName = &#63;.
	 *
	 * @param productName the product name
	 * @return the matching ads items
	 * @throws SystemException if a system exception occurred
	 */
	public List<AdsItem> findByProductName(String productName)
		throws SystemException {
		return findByProductName(productName, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ads items where productName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param productName the product name
	 * @param start the lower bound of the range of ads items
	 * @param end the upper bound of the range of ads items (not inclusive)
	 * @return the range of matching ads items
	 * @throws SystemException if a system exception occurred
	 */
	public List<AdsItem> findByProductName(String productName, int start,
		int end) throws SystemException {
		return findByProductName(productName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ads items where productName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param productName the product name
	 * @param start the lower bound of the range of ads items
	 * @param end the upper bound of the range of ads items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ads items
	 * @throws SystemException if a system exception occurred
	 */
	public List<AdsItem> findByProductName(String productName, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRODUCTNAME;
			finderArgs = new Object[] { productName };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PRODUCTNAME;
			finderArgs = new Object[] { productName, start, end, orderByComparator };
		}

		List<AdsItem> list = (List<AdsItem>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (AdsItem adsItem : list) {
				if (!Validator.equals(productName, adsItem.getProductName())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_ADSITEM_WHERE);

			if (productName == null) {
				query.append(_FINDER_COLUMN_PRODUCTNAME_PRODUCTNAME_1);
			}
			else {
				if (productName.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_PRODUCTNAME_PRODUCTNAME_3);
				}
				else {
					query.append(_FINDER_COLUMN_PRODUCTNAME_PRODUCTNAME_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(AdsItemModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (productName != null) {
					qPos.add(productName);
				}

				list = (List<AdsItem>)QueryUtil.list(q, getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first ads item in the ordered set where productName = &#63;.
	 *
	 * @param productName the product name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ads item
	 * @throws irestads.NoSuchAdsItemException if a matching ads item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AdsItem findByProductName_First(String productName,
		OrderByComparator orderByComparator)
		throws NoSuchAdsItemException, SystemException {
		AdsItem adsItem = fetchByProductName_First(productName,
				orderByComparator);

		if (adsItem != null) {
			return adsItem;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("productName=");
		msg.append(productName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAdsItemException(msg.toString());
	}

	/**
	 * Returns the first ads item in the ordered set where productName = &#63;.
	 *
	 * @param productName the product name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ads item, or <code>null</code> if a matching ads item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AdsItem fetchByProductName_First(String productName,
		OrderByComparator orderByComparator) throws SystemException {
		List<AdsItem> list = findByProductName(productName, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ads item in the ordered set where productName = &#63;.
	 *
	 * @param productName the product name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ads item
	 * @throws irestads.NoSuchAdsItemException if a matching ads item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AdsItem findByProductName_Last(String productName,
		OrderByComparator orderByComparator)
		throws NoSuchAdsItemException, SystemException {
		AdsItem adsItem = fetchByProductName_Last(productName, orderByComparator);

		if (adsItem != null) {
			return adsItem;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("productName=");
		msg.append(productName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAdsItemException(msg.toString());
	}

	/**
	 * Returns the last ads item in the ordered set where productName = &#63;.
	 *
	 * @param productName the product name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ads item, or <code>null</code> if a matching ads item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AdsItem fetchByProductName_Last(String productName,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByProductName(productName);

		List<AdsItem> list = findByProductName(productName, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the ads items before and after the current ads item in the ordered set where productName = &#63;.
	 *
	 * @param adsItemId the primary key of the current ads item
	 * @param productName the product name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ads item
	 * @throws irestads.NoSuchAdsItemException if a ads item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AdsItem[] findByProductName_PrevAndNext(long adsItemId,
		String productName, OrderByComparator orderByComparator)
		throws NoSuchAdsItemException, SystemException {
		AdsItem adsItem = findByPrimaryKey(adsItemId);

		Session session = null;

		try {
			session = openSession();

			AdsItem[] array = new AdsItemImpl[3];

			array[0] = getByProductName_PrevAndNext(session, adsItem,
					productName, orderByComparator, true);

			array[1] = adsItem;

			array[2] = getByProductName_PrevAndNext(session, adsItem,
					productName, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected AdsItem getByProductName_PrevAndNext(Session session,
		AdsItem adsItem, String productName,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ADSITEM_WHERE);

		if (productName == null) {
			query.append(_FINDER_COLUMN_PRODUCTNAME_PRODUCTNAME_1);
		}
		else {
			if (productName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PRODUCTNAME_PRODUCTNAME_3);
			}
			else {
				query.append(_FINDER_COLUMN_PRODUCTNAME_PRODUCTNAME_2);
			}
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(AdsItemModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (productName != null) {
			qPos.add(productName);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(adsItem);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AdsItem> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the ads items where timeDuring = &#63;.
	 *
	 * @param timeDuring the time during
	 * @return the matching ads items
	 * @throws SystemException if a system exception occurred
	 */
	public List<AdsItem> findByTimeDuring(int timeDuring)
		throws SystemException {
		return findByTimeDuring(timeDuring, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ads items where timeDuring = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param timeDuring the time during
	 * @param start the lower bound of the range of ads items
	 * @param end the upper bound of the range of ads items (not inclusive)
	 * @return the range of matching ads items
	 * @throws SystemException if a system exception occurred
	 */
	public List<AdsItem> findByTimeDuring(int timeDuring, int start, int end)
		throws SystemException {
		return findByTimeDuring(timeDuring, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ads items where timeDuring = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param timeDuring the time during
	 * @param start the lower bound of the range of ads items
	 * @param end the upper bound of the range of ads items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ads items
	 * @throws SystemException if a system exception occurred
	 */
	public List<AdsItem> findByTimeDuring(int timeDuring, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TIMEDURING;
			finderArgs = new Object[] { timeDuring };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TIMEDURING;
			finderArgs = new Object[] { timeDuring, start, end, orderByComparator };
		}

		List<AdsItem> list = (List<AdsItem>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (AdsItem adsItem : list) {
				if ((timeDuring != adsItem.getTimeDuring())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_ADSITEM_WHERE);

			query.append(_FINDER_COLUMN_TIMEDURING_TIMEDURING_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(AdsItemModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(timeDuring);

				list = (List<AdsItem>)QueryUtil.list(q, getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first ads item in the ordered set where timeDuring = &#63;.
	 *
	 * @param timeDuring the time during
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ads item
	 * @throws irestads.NoSuchAdsItemException if a matching ads item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AdsItem findByTimeDuring_First(int timeDuring,
		OrderByComparator orderByComparator)
		throws NoSuchAdsItemException, SystemException {
		AdsItem adsItem = fetchByTimeDuring_First(timeDuring, orderByComparator);

		if (adsItem != null) {
			return adsItem;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("timeDuring=");
		msg.append(timeDuring);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAdsItemException(msg.toString());
	}

	/**
	 * Returns the first ads item in the ordered set where timeDuring = &#63;.
	 *
	 * @param timeDuring the time during
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ads item, or <code>null</code> if a matching ads item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AdsItem fetchByTimeDuring_First(int timeDuring,
		OrderByComparator orderByComparator) throws SystemException {
		List<AdsItem> list = findByTimeDuring(timeDuring, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ads item in the ordered set where timeDuring = &#63;.
	 *
	 * @param timeDuring the time during
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ads item
	 * @throws irestads.NoSuchAdsItemException if a matching ads item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AdsItem findByTimeDuring_Last(int timeDuring,
		OrderByComparator orderByComparator)
		throws NoSuchAdsItemException, SystemException {
		AdsItem adsItem = fetchByTimeDuring_Last(timeDuring, orderByComparator);

		if (adsItem != null) {
			return adsItem;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("timeDuring=");
		msg.append(timeDuring);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAdsItemException(msg.toString());
	}

	/**
	 * Returns the last ads item in the ordered set where timeDuring = &#63;.
	 *
	 * @param timeDuring the time during
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ads item, or <code>null</code> if a matching ads item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AdsItem fetchByTimeDuring_Last(int timeDuring,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByTimeDuring(timeDuring);

		List<AdsItem> list = findByTimeDuring(timeDuring, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the ads items before and after the current ads item in the ordered set where timeDuring = &#63;.
	 *
	 * @param adsItemId the primary key of the current ads item
	 * @param timeDuring the time during
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ads item
	 * @throws irestads.NoSuchAdsItemException if a ads item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AdsItem[] findByTimeDuring_PrevAndNext(long adsItemId,
		int timeDuring, OrderByComparator orderByComparator)
		throws NoSuchAdsItemException, SystemException {
		AdsItem adsItem = findByPrimaryKey(adsItemId);

		Session session = null;

		try {
			session = openSession();

			AdsItem[] array = new AdsItemImpl[3];

			array[0] = getByTimeDuring_PrevAndNext(session, adsItem,
					timeDuring, orderByComparator, true);

			array[1] = adsItem;

			array[2] = getByTimeDuring_PrevAndNext(session, adsItem,
					timeDuring, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected AdsItem getByTimeDuring_PrevAndNext(Session session,
		AdsItem adsItem, int timeDuring, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ADSITEM_WHERE);

		query.append(_FINDER_COLUMN_TIMEDURING_TIMEDURING_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(AdsItemModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(timeDuring);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(adsItem);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AdsItem> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the ads items.
	 *
	 * @return the ads items
	 * @throws SystemException if a system exception occurred
	 */
	public List<AdsItem> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ads items.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of ads items
	 * @param end the upper bound of the range of ads items (not inclusive)
	 * @return the range of ads items
	 * @throws SystemException if a system exception occurred
	 */
	public List<AdsItem> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the ads items.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of ads items
	 * @param end the upper bound of the range of ads items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ads items
	 * @throws SystemException if a system exception occurred
	 */
	public List<AdsItem> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = new Object[] { start, end, orderByComparator };

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<AdsItem> list = (List<AdsItem>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ADSITEM);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ADSITEM.concat(AdsItemModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<AdsItem>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<AdsItem>)QueryUtil.list(q, getDialect(),
							start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the ads items where productName = &#63; from the database.
	 *
	 * @param productName the product name
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByProductName(String productName)
		throws SystemException {
		for (AdsItem adsItem : findByProductName(productName)) {
			remove(adsItem);
		}
	}

	/**
	 * Removes all the ads items where timeDuring = &#63; from the database.
	 *
	 * @param timeDuring the time during
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByTimeDuring(int timeDuring) throws SystemException {
		for (AdsItem adsItem : findByTimeDuring(timeDuring)) {
			remove(adsItem);
		}
	}

	/**
	 * Removes all the ads items from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (AdsItem adsItem : findAll()) {
			remove(adsItem);
		}
	}

	/**
	 * Returns the number of ads items where productName = &#63;.
	 *
	 * @param productName the product name
	 * @return the number of matching ads items
	 * @throws SystemException if a system exception occurred
	 */
	public int countByProductName(String productName) throws SystemException {
		Object[] finderArgs = new Object[] { productName };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PRODUCTNAME,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ADSITEM_WHERE);

			if (productName == null) {
				query.append(_FINDER_COLUMN_PRODUCTNAME_PRODUCTNAME_1);
			}
			else {
				if (productName.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_PRODUCTNAME_PRODUCTNAME_3);
				}
				else {
					query.append(_FINDER_COLUMN_PRODUCTNAME_PRODUCTNAME_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (productName != null) {
					qPos.add(productName);
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PRODUCTNAME,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of ads items where timeDuring = &#63;.
	 *
	 * @param timeDuring the time during
	 * @return the number of matching ads items
	 * @throws SystemException if a system exception occurred
	 */
	public int countByTimeDuring(int timeDuring) throws SystemException {
		Object[] finderArgs = new Object[] { timeDuring };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TIMEDURING,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ADSITEM_WHERE);

			query.append(_FINDER_COLUMN_TIMEDURING_TIMEDURING_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(timeDuring);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TIMEDURING,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of ads items.
	 *
	 * @return the number of ads items
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_ADSITEM);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the ads item persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.irestads.model.AdsItem")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<AdsItem>> listenersList = new ArrayList<ModelListener<AdsItem>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<AdsItem>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(AdsItemImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = AdsItemPersistence.class)
	protected AdsItemPersistence adsItemPersistence;
	@BeanReference(type = CategoryPersistence.class)
	protected CategoryPersistence categoryPersistence;
	@BeanReference(type = CategoryAdsPersistence.class)
	protected CategoryAdsPersistence categoryAdsPersistence;
	@BeanReference(type = DishPersistence.class)
	protected DishPersistence dishPersistence;
	@BeanReference(type = DishTablePersistence.class)
	protected DishTablePersistence dishTablePersistence;
	@BeanReference(type = MenuPersistence.class)
	protected MenuPersistence menuPersistence;
	@BeanReference(type = MenuLinePersistence.class)
	protected MenuLinePersistence menuLinePersistence;
	@BeanReference(type = OrderLinePersistence.class)
	protected OrderLinePersistence orderLinePersistence;
	@BeanReference(type = OrdersPersistence.class)
	protected OrdersPersistence ordersPersistence;
	@BeanReference(type = UVersionPersistence.class)
	protected UVersionPersistence uVersionPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_ADSITEM = "SELECT adsItem FROM AdsItem adsItem";
	private static final String _SQL_SELECT_ADSITEM_WHERE = "SELECT adsItem FROM AdsItem adsItem WHERE ";
	private static final String _SQL_COUNT_ADSITEM = "SELECT COUNT(adsItem) FROM AdsItem adsItem";
	private static final String _SQL_COUNT_ADSITEM_WHERE = "SELECT COUNT(adsItem) FROM AdsItem adsItem WHERE ";
	private static final String _FINDER_COLUMN_PRODUCTNAME_PRODUCTNAME_1 = "adsItem.productName IS NULL";
	private static final String _FINDER_COLUMN_PRODUCTNAME_PRODUCTNAME_2 = "adsItem.productName = ?";
	private static final String _FINDER_COLUMN_PRODUCTNAME_PRODUCTNAME_3 = "(adsItem.productName IS NULL OR adsItem.productName = ?)";
	private static final String _FINDER_COLUMN_TIMEDURING_TIMEDURING_2 = "adsItem.timeDuring = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "adsItem.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No AdsItem exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No AdsItem exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(AdsItemPersistenceImpl.class);
	private static AdsItem _nullAdsItem = new AdsItemImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<AdsItem> toCacheModel() {
				return _nullAdsItemCacheModel;
			}
		};

	private static CacheModel<AdsItem> _nullAdsItemCacheModel = new CacheModel<AdsItem>() {
			public AdsItem toEntityModel() {
				return _nullAdsItem;
			}
		};
}