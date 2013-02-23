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
import com.liferay.portal.kernel.dao.jdbc.MappingSqlQuery;
import com.liferay.portal.kernel.dao.jdbc.MappingSqlQueryFactoryUtil;
import com.liferay.portal.kernel.dao.jdbc.RowMapper;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
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

import irestads.NoSuchCategoryAdsException;

import irestads.model.CategoryAds;

import irestads.model.impl.CategoryAdsImpl;
import irestads.model.impl.CategoryAdsModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the category ads service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Be
 * @see CategoryAdsPersistence
 * @see CategoryAdsUtil
 * @generated
 */
public class CategoryAdsPersistenceImpl extends BasePersistenceImpl<CategoryAds>
	implements CategoryAdsPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CategoryAdsUtil} to access the category ads persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CategoryAdsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORYADSNAME =
		new FinderPath(CategoryAdsModelImpl.ENTITY_CACHE_ENABLED,
			CategoryAdsModelImpl.FINDER_CACHE_ENABLED, CategoryAdsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCategoryAdsName",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYADSNAME =
		new FinderPath(CategoryAdsModelImpl.ENTITY_CACHE_ENABLED,
			CategoryAdsModelImpl.FINDER_CACHE_ENABLED, CategoryAdsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCategoryAdsName",
			new String[] { String.class.getName() },
			CategoryAdsModelImpl.CATEGORYADSNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CATEGORYADSNAME = new FinderPath(CategoryAdsModelImpl.ENTITY_CACHE_ENABLED,
			CategoryAdsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCategoryAdsName", new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CategoryAdsModelImpl.ENTITY_CACHE_ENABLED,
			CategoryAdsModelImpl.FINDER_CACHE_ENABLED, CategoryAdsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CategoryAdsModelImpl.ENTITY_CACHE_ENABLED,
			CategoryAdsModelImpl.FINDER_CACHE_ENABLED, CategoryAdsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CategoryAdsModelImpl.ENTITY_CACHE_ENABLED,
			CategoryAdsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the category ads in the entity cache if it is enabled.
	 *
	 * @param categoryAds the category ads
	 */
	public void cacheResult(CategoryAds categoryAds) {
		EntityCacheUtil.putResult(CategoryAdsModelImpl.ENTITY_CACHE_ENABLED,
			CategoryAdsImpl.class, categoryAds.getPrimaryKey(), categoryAds);

		categoryAds.resetOriginalValues();
	}

	/**
	 * Caches the category adses in the entity cache if it is enabled.
	 *
	 * @param categoryAdses the category adses
	 */
	public void cacheResult(List<CategoryAds> categoryAdses) {
		for (CategoryAds categoryAds : categoryAdses) {
			if (EntityCacheUtil.getResult(
						CategoryAdsModelImpl.ENTITY_CACHE_ENABLED,
						CategoryAdsImpl.class, categoryAds.getPrimaryKey()) == null) {
				cacheResult(categoryAds);
			}
			else {
				categoryAds.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all category adses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CategoryAdsImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CategoryAdsImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the category ads.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CategoryAds categoryAds) {
		EntityCacheUtil.removeResult(CategoryAdsModelImpl.ENTITY_CACHE_ENABLED,
			CategoryAdsImpl.class, categoryAds.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<CategoryAds> categoryAdses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CategoryAds categoryAds : categoryAdses) {
			EntityCacheUtil.removeResult(CategoryAdsModelImpl.ENTITY_CACHE_ENABLED,
				CategoryAdsImpl.class, categoryAds.getPrimaryKey());
		}
	}

	/**
	 * Creates a new category ads with the primary key. Does not add the category ads to the database.
	 *
	 * @param categoryAdsId the primary key for the new category ads
	 * @return the new category ads
	 */
	public CategoryAds create(long categoryAdsId) {
		CategoryAds categoryAds = new CategoryAdsImpl();

		categoryAds.setNew(true);
		categoryAds.setPrimaryKey(categoryAdsId);

		return categoryAds;
	}

	/**
	 * Removes the category ads with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param categoryAdsId the primary key of the category ads
	 * @return the category ads that was removed
	 * @throws irestads.NoSuchCategoryAdsException if a category ads with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CategoryAds remove(long categoryAdsId)
		throws NoSuchCategoryAdsException, SystemException {
		return remove(Long.valueOf(categoryAdsId));
	}

	/**
	 * Removes the category ads with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the category ads
	 * @return the category ads that was removed
	 * @throws irestads.NoSuchCategoryAdsException if a category ads with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CategoryAds remove(Serializable primaryKey)
		throws NoSuchCategoryAdsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CategoryAds categoryAds = (CategoryAds)session.get(CategoryAdsImpl.class,
					primaryKey);

			if (categoryAds == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCategoryAdsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(categoryAds);
		}
		catch (NoSuchCategoryAdsException nsee) {
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
	protected CategoryAds removeImpl(CategoryAds categoryAds)
		throws SystemException {
		categoryAds = toUnwrappedModel(categoryAds);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, categoryAds);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(categoryAds);

		return categoryAds;
	}

	@Override
	public CategoryAds updateImpl(irestads.model.CategoryAds categoryAds,
		boolean merge) throws SystemException {
		categoryAds = toUnwrappedModel(categoryAds);

		boolean isNew = categoryAds.isNew();

		CategoryAdsModelImpl categoryAdsModelImpl = (CategoryAdsModelImpl)categoryAds;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, categoryAds, merge);

			categoryAds.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CategoryAdsModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((categoryAdsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYADSNAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						categoryAdsModelImpl.getOriginalCategoryAdsName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORYADSNAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYADSNAME,
					args);

				args = new Object[] { categoryAdsModelImpl.getCategoryAdsName() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORYADSNAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYADSNAME,
					args);
			}
		}

		EntityCacheUtil.putResult(CategoryAdsModelImpl.ENTITY_CACHE_ENABLED,
			CategoryAdsImpl.class, categoryAds.getPrimaryKey(), categoryAds);

		return categoryAds;
	}

	protected CategoryAds toUnwrappedModel(CategoryAds categoryAds) {
		if (categoryAds instanceof CategoryAdsImpl) {
			return categoryAds;
		}

		CategoryAdsImpl categoryAdsImpl = new CategoryAdsImpl();

		categoryAdsImpl.setNew(categoryAds.isNew());
		categoryAdsImpl.setPrimaryKey(categoryAds.getPrimaryKey());

		categoryAdsImpl.setCategoryAdsId(categoryAds.getCategoryAdsId());
		categoryAdsImpl.setCompanyId(categoryAds.getCompanyId());
		categoryAdsImpl.setUserId(categoryAds.getUserId());
		categoryAdsImpl.setUserName(categoryAds.getUserName());
		categoryAdsImpl.setCreateDate(categoryAds.getCreateDate());
		categoryAdsImpl.setModifiedDate(categoryAds.getModifiedDate());
		categoryAdsImpl.setCategoryAdsName(categoryAds.getCategoryAdsName());

		return categoryAdsImpl;
	}

	/**
	 * Returns the category ads with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the category ads
	 * @return the category ads
	 * @throws com.liferay.portal.NoSuchModelException if a category ads with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CategoryAds findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the category ads with the primary key or throws a {@link irestads.NoSuchCategoryAdsException} if it could not be found.
	 *
	 * @param categoryAdsId the primary key of the category ads
	 * @return the category ads
	 * @throws irestads.NoSuchCategoryAdsException if a category ads with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CategoryAds findByPrimaryKey(long categoryAdsId)
		throws NoSuchCategoryAdsException, SystemException {
		CategoryAds categoryAds = fetchByPrimaryKey(categoryAdsId);

		if (categoryAds == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + categoryAdsId);
			}

			throw new NoSuchCategoryAdsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				categoryAdsId);
		}

		return categoryAds;
	}

	/**
	 * Returns the category ads with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the category ads
	 * @return the category ads, or <code>null</code> if a category ads with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CategoryAds fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the category ads with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param categoryAdsId the primary key of the category ads
	 * @return the category ads, or <code>null</code> if a category ads with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CategoryAds fetchByPrimaryKey(long categoryAdsId)
		throws SystemException {
		CategoryAds categoryAds = (CategoryAds)EntityCacheUtil.getResult(CategoryAdsModelImpl.ENTITY_CACHE_ENABLED,
				CategoryAdsImpl.class, categoryAdsId);

		if (categoryAds == _nullCategoryAds) {
			return null;
		}

		if (categoryAds == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				categoryAds = (CategoryAds)session.get(CategoryAdsImpl.class,
						Long.valueOf(categoryAdsId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (categoryAds != null) {
					cacheResult(categoryAds);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(CategoryAdsModelImpl.ENTITY_CACHE_ENABLED,
						CategoryAdsImpl.class, categoryAdsId, _nullCategoryAds);
				}

				closeSession(session);
			}
		}

		return categoryAds;
	}

	/**
	 * Returns all the category adses where categoryAdsName = &#63;.
	 *
	 * @param categoryAdsName the category ads name
	 * @return the matching category adses
	 * @throws SystemException if a system exception occurred
	 */
	public List<CategoryAds> findByCategoryAdsName(String categoryAdsName)
		throws SystemException {
		return findByCategoryAdsName(categoryAdsName, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the category adses where categoryAdsName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param categoryAdsName the category ads name
	 * @param start the lower bound of the range of category adses
	 * @param end the upper bound of the range of category adses (not inclusive)
	 * @return the range of matching category adses
	 * @throws SystemException if a system exception occurred
	 */
	public List<CategoryAds> findByCategoryAdsName(String categoryAdsName,
		int start, int end) throws SystemException {
		return findByCategoryAdsName(categoryAdsName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the category adses where categoryAdsName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param categoryAdsName the category ads name
	 * @param start the lower bound of the range of category adses
	 * @param end the upper bound of the range of category adses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching category adses
	 * @throws SystemException if a system exception occurred
	 */
	public List<CategoryAds> findByCategoryAdsName(String categoryAdsName,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYADSNAME;
			finderArgs = new Object[] { categoryAdsName };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORYADSNAME;
			finderArgs = new Object[] {
					categoryAdsName,
					
					start, end, orderByComparator
				};
		}

		List<CategoryAds> list = (List<CategoryAds>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CategoryAds categoryAds : list) {
				if (!Validator.equals(categoryAdsName,
							categoryAds.getCategoryAdsName())) {
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

			query.append(_SQL_SELECT_CATEGORYADS_WHERE);

			if (categoryAdsName == null) {
				query.append(_FINDER_COLUMN_CATEGORYADSNAME_CATEGORYADSNAME_1);
			}
			else {
				if (categoryAdsName.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_CATEGORYADSNAME_CATEGORYADSNAME_3);
				}
				else {
					query.append(_FINDER_COLUMN_CATEGORYADSNAME_CATEGORYADSNAME_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(CategoryAdsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (categoryAdsName != null) {
					qPos.add(categoryAdsName);
				}

				list = (List<CategoryAds>)QueryUtil.list(q, getDialect(),
						start, end);
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
	 * Returns the first category ads in the ordered set where categoryAdsName = &#63;.
	 *
	 * @param categoryAdsName the category ads name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching category ads
	 * @throws irestads.NoSuchCategoryAdsException if a matching category ads could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CategoryAds findByCategoryAdsName_First(String categoryAdsName,
		OrderByComparator orderByComparator)
		throws NoSuchCategoryAdsException, SystemException {
		CategoryAds categoryAds = fetchByCategoryAdsName_First(categoryAdsName,
				orderByComparator);

		if (categoryAds != null) {
			return categoryAds;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("categoryAdsName=");
		msg.append(categoryAdsName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCategoryAdsException(msg.toString());
	}

	/**
	 * Returns the first category ads in the ordered set where categoryAdsName = &#63;.
	 *
	 * @param categoryAdsName the category ads name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching category ads, or <code>null</code> if a matching category ads could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CategoryAds fetchByCategoryAdsName_First(String categoryAdsName,
		OrderByComparator orderByComparator) throws SystemException {
		List<CategoryAds> list = findByCategoryAdsName(categoryAdsName, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last category ads in the ordered set where categoryAdsName = &#63;.
	 *
	 * @param categoryAdsName the category ads name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching category ads
	 * @throws irestads.NoSuchCategoryAdsException if a matching category ads could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CategoryAds findByCategoryAdsName_Last(String categoryAdsName,
		OrderByComparator orderByComparator)
		throws NoSuchCategoryAdsException, SystemException {
		CategoryAds categoryAds = fetchByCategoryAdsName_Last(categoryAdsName,
				orderByComparator);

		if (categoryAds != null) {
			return categoryAds;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("categoryAdsName=");
		msg.append(categoryAdsName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCategoryAdsException(msg.toString());
	}

	/**
	 * Returns the last category ads in the ordered set where categoryAdsName = &#63;.
	 *
	 * @param categoryAdsName the category ads name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching category ads, or <code>null</code> if a matching category ads could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CategoryAds fetchByCategoryAdsName_Last(String categoryAdsName,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCategoryAdsName(categoryAdsName);

		List<CategoryAds> list = findByCategoryAdsName(categoryAdsName,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the category adses before and after the current category ads in the ordered set where categoryAdsName = &#63;.
	 *
	 * @param categoryAdsId the primary key of the current category ads
	 * @param categoryAdsName the category ads name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next category ads
	 * @throws irestads.NoSuchCategoryAdsException if a category ads with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CategoryAds[] findByCategoryAdsName_PrevAndNext(long categoryAdsId,
		String categoryAdsName, OrderByComparator orderByComparator)
		throws NoSuchCategoryAdsException, SystemException {
		CategoryAds categoryAds = findByPrimaryKey(categoryAdsId);

		Session session = null;

		try {
			session = openSession();

			CategoryAds[] array = new CategoryAdsImpl[3];

			array[0] = getByCategoryAdsName_PrevAndNext(session, categoryAds,
					categoryAdsName, orderByComparator, true);

			array[1] = categoryAds;

			array[2] = getByCategoryAdsName_PrevAndNext(session, categoryAds,
					categoryAdsName, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CategoryAds getByCategoryAdsName_PrevAndNext(Session session,
		CategoryAds categoryAds, String categoryAdsName,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CATEGORYADS_WHERE);

		if (categoryAdsName == null) {
			query.append(_FINDER_COLUMN_CATEGORYADSNAME_CATEGORYADSNAME_1);
		}
		else {
			if (categoryAdsName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CATEGORYADSNAME_CATEGORYADSNAME_3);
			}
			else {
				query.append(_FINDER_COLUMN_CATEGORYADSNAME_CATEGORYADSNAME_2);
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
			query.append(CategoryAdsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (categoryAdsName != null) {
			qPos.add(categoryAdsName);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(categoryAds);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CategoryAds> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the category adses.
	 *
	 * @return the category adses
	 * @throws SystemException if a system exception occurred
	 */
	public List<CategoryAds> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the category adses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of category adses
	 * @param end the upper bound of the range of category adses (not inclusive)
	 * @return the range of category adses
	 * @throws SystemException if a system exception occurred
	 */
	public List<CategoryAds> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the category adses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of category adses
	 * @param end the upper bound of the range of category adses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of category adses
	 * @throws SystemException if a system exception occurred
	 */
	public List<CategoryAds> findAll(int start, int end,
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

		List<CategoryAds> list = (List<CategoryAds>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CATEGORYADS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CATEGORYADS.concat(CategoryAdsModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<CategoryAds>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<CategoryAds>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the category adses where categoryAdsName = &#63; from the database.
	 *
	 * @param categoryAdsName the category ads name
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCategoryAdsName(String categoryAdsName)
		throws SystemException {
		for (CategoryAds categoryAds : findByCategoryAdsName(categoryAdsName)) {
			remove(categoryAds);
		}
	}

	/**
	 * Removes all the category adses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (CategoryAds categoryAds : findAll()) {
			remove(categoryAds);
		}
	}

	/**
	 * Returns the number of category adses where categoryAdsName = &#63;.
	 *
	 * @param categoryAdsName the category ads name
	 * @return the number of matching category adses
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCategoryAdsName(String categoryAdsName)
		throws SystemException {
		Object[] finderArgs = new Object[] { categoryAdsName };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CATEGORYADSNAME,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CATEGORYADS_WHERE);

			if (categoryAdsName == null) {
				query.append(_FINDER_COLUMN_CATEGORYADSNAME_CATEGORYADSNAME_1);
			}
			else {
				if (categoryAdsName.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_CATEGORYADSNAME_CATEGORYADSNAME_3);
				}
				else {
					query.append(_FINDER_COLUMN_CATEGORYADSNAME_CATEGORYADSNAME_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (categoryAdsName != null) {
					qPos.add(categoryAdsName);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CATEGORYADSNAME,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of category adses.
	 *
	 * @return the number of category adses
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CATEGORYADS);

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
	 * Returns all the ads items associated with the category ads.
	 *
	 * @param pk the primary key of the category ads
	 * @return the ads items associated with the category ads
	 * @throws SystemException if a system exception occurred
	 */
	public List<irestads.model.AdsItem> getAdsItems(long pk)
		throws SystemException {
		return getAdsItems(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	/**
	 * Returns a range of all the ads items associated with the category ads.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param pk the primary key of the category ads
	 * @param start the lower bound of the range of category adses
	 * @param end the upper bound of the range of category adses (not inclusive)
	 * @return the range of ads items associated with the category ads
	 * @throws SystemException if a system exception occurred
	 */
	public List<irestads.model.AdsItem> getAdsItems(long pk, int start, int end)
		throws SystemException {
		return getAdsItems(pk, start, end, null);
	}

	public static final FinderPath FINDER_PATH_GET_ADSITEMS = new FinderPath(irestads.model.impl.AdsItemModelImpl.ENTITY_CACHE_ENABLED,
			irestads.model.impl.AdsItemModelImpl.FINDER_CACHE_ENABLED,
			irestads.model.impl.AdsItemImpl.class,
			irestads.service.persistence.AdsItemPersistenceImpl.FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"getAdsItems",
			new String[] {
				Long.class.getName(), "java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});

	static {
		FINDER_PATH_GET_ADSITEMS.setCacheKeyGeneratorCacheName(null);
	}

	/**
	 * Returns an ordered range of all the ads items associated with the category ads.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param pk the primary key of the category ads
	 * @param start the lower bound of the range of category adses
	 * @param end the upper bound of the range of category adses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ads items associated with the category ads
	 * @throws SystemException if a system exception occurred
	 */
	public List<irestads.model.AdsItem> getAdsItems(long pk, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] { pk, start, end, orderByComparator };

		List<irestads.model.AdsItem> list = (List<irestads.model.AdsItem>)FinderCacheUtil.getResult(FINDER_PATH_GET_ADSITEMS,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				String sql = null;

				if (orderByComparator != null) {
					sql = _SQL_GETADSITEMS.concat(ORDER_BY_CLAUSE)
										  .concat(orderByComparator.getOrderBy());
				}
				else {
					sql = _SQL_GETADSITEMS.concat(irestads.model.impl.AdsItemModelImpl.ORDER_BY_SQL);
				}

				SQLQuery q = session.createSQLQuery(sql);

				q.addEntity("Ads_AdsItem", irestads.model.impl.AdsItemImpl.class);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(pk);

				list = (List<irestads.model.AdsItem>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_GET_ADSITEMS,
						finderArgs);
				}
				else {
					adsItemPersistence.cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_GET_ADSITEMS,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	public static final FinderPath FINDER_PATH_GET_ADSITEMS_SIZE = new FinderPath(irestads.model.impl.AdsItemModelImpl.ENTITY_CACHE_ENABLED,
			irestads.model.impl.AdsItemModelImpl.FINDER_CACHE_ENABLED,
			irestads.model.impl.AdsItemImpl.class,
			irestads.service.persistence.AdsItemPersistenceImpl.FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"getAdsItemsSize", new String[] { Long.class.getName() });

	static {
		FINDER_PATH_GET_ADSITEMS_SIZE.setCacheKeyGeneratorCacheName(null);
	}

	/**
	 * Returns the number of ads items associated with the category ads.
	 *
	 * @param pk the primary key of the category ads
	 * @return the number of ads items associated with the category ads
	 * @throws SystemException if a system exception occurred
	 */
	public int getAdsItemsSize(long pk) throws SystemException {
		Object[] finderArgs = new Object[] { pk };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_GET_ADSITEMS_SIZE,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				SQLQuery q = session.createSQLQuery(_SQL_GETADSITEMSSIZE);

				q.addScalar(COUNT_COLUMN_NAME,
					com.liferay.portal.kernel.dao.orm.Type.LONG);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(pk);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_GET_ADSITEMS_SIZE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public static final FinderPath FINDER_PATH_CONTAINS_ADSITEM = new FinderPath(irestads.model.impl.AdsItemModelImpl.ENTITY_CACHE_ENABLED,
			irestads.model.impl.AdsItemModelImpl.FINDER_CACHE_ENABLED,
			irestads.model.impl.AdsItemImpl.class,
			irestads.service.persistence.AdsItemPersistenceImpl.FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"containsAdsItem",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns <code>true</code> if the ads item is associated with the category ads.
	 *
	 * @param pk the primary key of the category ads
	 * @param adsItemPK the primary key of the ads item
	 * @return <code>true</code> if the ads item is associated with the category ads; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	public boolean containsAdsItem(long pk, long adsItemPK)
		throws SystemException {
		Object[] finderArgs = new Object[] { pk, adsItemPK };

		Boolean value = (Boolean)FinderCacheUtil.getResult(FINDER_PATH_CONTAINS_ADSITEM,
				finderArgs, this);

		if (value == null) {
			try {
				value = Boolean.valueOf(containsAdsItem.contains(pk, adsItemPK));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (value == null) {
					value = Boolean.FALSE;
				}

				FinderCacheUtil.putResult(FINDER_PATH_CONTAINS_ADSITEM,
					finderArgs, value);
			}
		}

		return value.booleanValue();
	}

	/**
	 * Returns <code>true</code> if the category ads has any ads items associated with it.
	 *
	 * @param pk the primary key of the category ads to check for associations with ads items
	 * @return <code>true</code> if the category ads has any ads items associated with it; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	public boolean containsAdsItems(long pk) throws SystemException {
		if (getAdsItemsSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Initializes the category ads persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.irestads.model.CategoryAds")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CategoryAds>> listenersList = new ArrayList<ModelListener<CategoryAds>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CategoryAds>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}

		containsAdsItem = new ContainsAdsItem();
	}

	public void destroy() {
		EntityCacheUtil.removeCache(CategoryAdsImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = AdsItemPersistence.class)
	protected AdsItemPersistence adsItemPersistence;
	@BeanReference(type = CategoryAdsPersistence.class)
	protected CategoryAdsPersistence categoryAdsPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	protected ContainsAdsItem containsAdsItem;

	protected class ContainsAdsItem {
		protected ContainsAdsItem() {
			_mappingSqlQuery = MappingSqlQueryFactoryUtil.getMappingSqlQuery(getDataSource(),
					_SQL_CONTAINSADSITEM,
					new int[] { java.sql.Types.BIGINT, java.sql.Types.BIGINT },
					RowMapper.COUNT);
		}

		protected boolean contains(long categoryAdsId, long adsItemId) {
			List<Integer> results = _mappingSqlQuery.execute(new Object[] {
						new Long(categoryAdsId), new Long(adsItemId)
					});

			if (results.size() > 0) {
				Integer count = results.get(0);

				if (count.intValue() > 0) {
					return true;
				}
			}

			return false;
		}

		private MappingSqlQuery<Integer> _mappingSqlQuery;
	}

	private static final String _SQL_SELECT_CATEGORYADS = "SELECT categoryAds FROM CategoryAds categoryAds";
	private static final String _SQL_SELECT_CATEGORYADS_WHERE = "SELECT categoryAds FROM CategoryAds categoryAds WHERE ";
	private static final String _SQL_COUNT_CATEGORYADS = "SELECT COUNT(categoryAds) FROM CategoryAds categoryAds";
	private static final String _SQL_COUNT_CATEGORYADS_WHERE = "SELECT COUNT(categoryAds) FROM CategoryAds categoryAds WHERE ";
	private static final String _SQL_GETADSITEMS = "SELECT {Ads_AdsItem.*} FROM Ads_AdsItem INNER JOIN Ads_CategoryAds ON (Ads_CategoryAds.categoryAdsId = Ads_AdsItem.categoryAdsId) WHERE (Ads_CategoryAds.categoryAdsId = ?)";
	private static final String _SQL_GETADSITEMSSIZE = "SELECT COUNT(*) AS COUNT_VALUE FROM Ads_AdsItem WHERE categoryAdsId = ?";
	private static final String _SQL_CONTAINSADSITEM = "SELECT COUNT(*) AS COUNT_VALUE FROM Ads_AdsItem WHERE categoryAdsId = ? AND adsItemId = ?";
	private static final String _FINDER_COLUMN_CATEGORYADSNAME_CATEGORYADSNAME_1 =
		"categoryAds.categoryAdsName IS NULL";
	private static final String _FINDER_COLUMN_CATEGORYADSNAME_CATEGORYADSNAME_2 =
		"categoryAds.categoryAdsName = ?";
	private static final String _FINDER_COLUMN_CATEGORYADSNAME_CATEGORYADSNAME_3 =
		"(categoryAds.categoryAdsName IS NULL OR categoryAds.categoryAdsName = ?)";
	private static final String _ORDER_BY_ENTITY_ALIAS = "categoryAds.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CategoryAds exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No CategoryAds exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CategoryAdsPersistenceImpl.class);
	private static CategoryAds _nullCategoryAds = new CategoryAdsImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<CategoryAds> toCacheModel() {
				return _nullCategoryAdsCacheModel;
			}
		};

	private static CacheModel<CategoryAds> _nullCategoryAdsCacheModel = new CacheModel<CategoryAds>() {
			public CategoryAds toEntityModel() {
				return _nullCategoryAds;
			}
		};
}