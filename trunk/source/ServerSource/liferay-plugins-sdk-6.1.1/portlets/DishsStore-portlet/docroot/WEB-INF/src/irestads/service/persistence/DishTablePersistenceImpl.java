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
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import irestads.NoSuchDishTableException;

import irestads.model.DishTable;

import irestads.model.impl.DishTableImpl;
import irestads.model.impl.DishTableModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the dish table service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Be
 * @see DishTablePersistence
 * @see DishTableUtil
 * @generated
 */
public class DishTablePersistenceImpl extends BasePersistenceImpl<DishTable>
	implements DishTablePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DishTableUtil} to access the dish table persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DishTableImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ISAVALABLE =
		new FinderPath(DishTableModelImpl.ENTITY_CACHE_ENABLED,
			DishTableModelImpl.FINDER_CACHE_ENABLED, DishTableImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByIsAvalable",
			new String[] {
				Boolean.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISAVALABLE =
		new FinderPath(DishTableModelImpl.ENTITY_CACHE_ENABLED,
			DishTableModelImpl.FINDER_CACHE_ENABLED, DishTableImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByIsAvalable",
			new String[] { Boolean.class.getName() },
			DishTableModelImpl.ISAVALABLE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ISAVALABLE = new FinderPath(DishTableModelImpl.ENTITY_CACHE_ENABLED,
			DishTableModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByIsAvalable",
			new String[] { Boolean.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DishTableModelImpl.ENTITY_CACHE_ENABLED,
			DishTableModelImpl.FINDER_CACHE_ENABLED, DishTableImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DishTableModelImpl.ENTITY_CACHE_ENABLED,
			DishTableModelImpl.FINDER_CACHE_ENABLED, DishTableImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DishTableModelImpl.ENTITY_CACHE_ENABLED,
			DishTableModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the dish table in the entity cache if it is enabled.
	 *
	 * @param dishTable the dish table
	 */
	public void cacheResult(DishTable dishTable) {
		EntityCacheUtil.putResult(DishTableModelImpl.ENTITY_CACHE_ENABLED,
			DishTableImpl.class, dishTable.getPrimaryKey(), dishTable);

		dishTable.resetOriginalValues();
	}

	/**
	 * Caches the dish tables in the entity cache if it is enabled.
	 *
	 * @param dishTables the dish tables
	 */
	public void cacheResult(List<DishTable> dishTables) {
		for (DishTable dishTable : dishTables) {
			if (EntityCacheUtil.getResult(
						DishTableModelImpl.ENTITY_CACHE_ENABLED,
						DishTableImpl.class, dishTable.getPrimaryKey()) == null) {
				cacheResult(dishTable);
			}
			else {
				dishTable.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all dish tables.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(DishTableImpl.class.getName());
		}

		EntityCacheUtil.clearCache(DishTableImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the dish table.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DishTable dishTable) {
		EntityCacheUtil.removeResult(DishTableModelImpl.ENTITY_CACHE_ENABLED,
			DishTableImpl.class, dishTable.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<DishTable> dishTables) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (DishTable dishTable : dishTables) {
			EntityCacheUtil.removeResult(DishTableModelImpl.ENTITY_CACHE_ENABLED,
				DishTableImpl.class, dishTable.getPrimaryKey());
		}
	}

	/**
	 * Creates a new dish table with the primary key. Does not add the dish table to the database.
	 *
	 * @param dishTableId the primary key for the new dish table
	 * @return the new dish table
	 */
	public DishTable create(String dishTableId) {
		DishTable dishTable = new DishTableImpl();

		dishTable.setNew(true);
		dishTable.setPrimaryKey(dishTableId);

		return dishTable;
	}

	/**
	 * Removes the dish table with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dishTableId the primary key of the dish table
	 * @return the dish table that was removed
	 * @throws irestads.NoSuchDishTableException if a dish table with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DishTable remove(String dishTableId)
		throws NoSuchDishTableException, SystemException {
		return remove((Serializable)dishTableId);
	}

	/**
	 * Removes the dish table with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the dish table
	 * @return the dish table that was removed
	 * @throws irestads.NoSuchDishTableException if a dish table with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DishTable remove(Serializable primaryKey)
		throws NoSuchDishTableException, SystemException {
		Session session = null;

		try {
			session = openSession();

			DishTable dishTable = (DishTable)session.get(DishTableImpl.class,
					primaryKey);

			if (dishTable == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDishTableException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(dishTable);
		}
		catch (NoSuchDishTableException nsee) {
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
	protected DishTable removeImpl(DishTable dishTable)
		throws SystemException {
		dishTable = toUnwrappedModel(dishTable);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, dishTable);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(dishTable);

		return dishTable;
	}

	@Override
	public DishTable updateImpl(irestads.model.DishTable dishTable,
		boolean merge) throws SystemException {
		dishTable = toUnwrappedModel(dishTable);

		boolean isNew = dishTable.isNew();

		DishTableModelImpl dishTableModelImpl = (DishTableModelImpl)dishTable;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, dishTable, merge);

			dishTable.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !DishTableModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((dishTableModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISAVALABLE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Boolean.valueOf(dishTableModelImpl.getOriginalIsAvalable())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ISAVALABLE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISAVALABLE,
					args);

				args = new Object[] {
						Boolean.valueOf(dishTableModelImpl.getIsAvalable())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ISAVALABLE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISAVALABLE,
					args);
			}
		}

		EntityCacheUtil.putResult(DishTableModelImpl.ENTITY_CACHE_ENABLED,
			DishTableImpl.class, dishTable.getPrimaryKey(), dishTable);

		return dishTable;
	}

	protected DishTable toUnwrappedModel(DishTable dishTable) {
		if (dishTable instanceof DishTableImpl) {
			return dishTable;
		}

		DishTableImpl dishTableImpl = new DishTableImpl();

		dishTableImpl.setNew(dishTable.isNew());
		dishTableImpl.setPrimaryKey(dishTable.getPrimaryKey());

		dishTableImpl.setDishTableId(dishTable.getDishTableId());
		dishTableImpl.setCompanyId(dishTable.getCompanyId());
		dishTableImpl.setUserId(dishTable.getUserId());
		dishTableImpl.setUserName(dishTable.getUserName());
		dishTableImpl.setCreateDate(dishTable.getCreateDate());
		dishTableImpl.setModifiedDate(dishTable.getModifiedDate());
		dishTableImpl.setTableName(dishTable.getTableName());
		dishTableImpl.setIsAvalable(dishTable.isIsAvalable());
		dishTableImpl.setNumChair(dishTable.getNumChair());

		return dishTableImpl;
	}

	/**
	 * Returns the dish table with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the dish table
	 * @return the dish table
	 * @throws com.liferay.portal.NoSuchModelException if a dish table with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DishTable findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey((String)primaryKey);
	}

	/**
	 * Returns the dish table with the primary key or throws a {@link irestads.NoSuchDishTableException} if it could not be found.
	 *
	 * @param dishTableId the primary key of the dish table
	 * @return the dish table
	 * @throws irestads.NoSuchDishTableException if a dish table with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DishTable findByPrimaryKey(String dishTableId)
		throws NoSuchDishTableException, SystemException {
		DishTable dishTable = fetchByPrimaryKey(dishTableId);

		if (dishTable == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + dishTableId);
			}

			throw new NoSuchDishTableException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				dishTableId);
		}

		return dishTable;
	}

	/**
	 * Returns the dish table with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the dish table
	 * @return the dish table, or <code>null</code> if a dish table with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DishTable fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey((String)primaryKey);
	}

	/**
	 * Returns the dish table with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dishTableId the primary key of the dish table
	 * @return the dish table, or <code>null</code> if a dish table with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DishTable fetchByPrimaryKey(String dishTableId)
		throws SystemException {
		DishTable dishTable = (DishTable)EntityCacheUtil.getResult(DishTableModelImpl.ENTITY_CACHE_ENABLED,
				DishTableImpl.class, dishTableId);

		if (dishTable == _nullDishTable) {
			return null;
		}

		if (dishTable == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				dishTable = (DishTable)session.get(DishTableImpl.class,
						dishTableId);
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (dishTable != null) {
					cacheResult(dishTable);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(DishTableModelImpl.ENTITY_CACHE_ENABLED,
						DishTableImpl.class, dishTableId, _nullDishTable);
				}

				closeSession(session);
			}
		}

		return dishTable;
	}

	/**
	 * Returns all the dish tables where isAvalable = &#63;.
	 *
	 * @param isAvalable the is avalable
	 * @return the matching dish tables
	 * @throws SystemException if a system exception occurred
	 */
	public List<DishTable> findByIsAvalable(boolean isAvalable)
		throws SystemException {
		return findByIsAvalable(isAvalable, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dish tables where isAvalable = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param isAvalable the is avalable
	 * @param start the lower bound of the range of dish tables
	 * @param end the upper bound of the range of dish tables (not inclusive)
	 * @return the range of matching dish tables
	 * @throws SystemException if a system exception occurred
	 */
	public List<DishTable> findByIsAvalable(boolean isAvalable, int start,
		int end) throws SystemException {
		return findByIsAvalable(isAvalable, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dish tables where isAvalable = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param isAvalable the is avalable
	 * @param start the lower bound of the range of dish tables
	 * @param end the upper bound of the range of dish tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dish tables
	 * @throws SystemException if a system exception occurred
	 */
	public List<DishTable> findByIsAvalable(boolean isAvalable, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISAVALABLE;
			finderArgs = new Object[] { isAvalable };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ISAVALABLE;
			finderArgs = new Object[] { isAvalable, start, end, orderByComparator };
		}

		List<DishTable> list = (List<DishTable>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (DishTable dishTable : list) {
				if ((isAvalable != dishTable.getIsAvalable())) {
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

			query.append(_SQL_SELECT_DISHTABLE_WHERE);

			query.append(_FINDER_COLUMN_ISAVALABLE_ISAVALABLE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(DishTableModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(isAvalable);

				list = (List<DishTable>)QueryUtil.list(q, getDialect(), start,
						end);
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
	 * Returns the first dish table in the ordered set where isAvalable = &#63;.
	 *
	 * @param isAvalable the is avalable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dish table
	 * @throws irestads.NoSuchDishTableException if a matching dish table could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DishTable findByIsAvalable_First(boolean isAvalable,
		OrderByComparator orderByComparator)
		throws NoSuchDishTableException, SystemException {
		DishTable dishTable = fetchByIsAvalable_First(isAvalable,
				orderByComparator);

		if (dishTable != null) {
			return dishTable;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("isAvalable=");
		msg.append(isAvalable);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDishTableException(msg.toString());
	}

	/**
	 * Returns the first dish table in the ordered set where isAvalable = &#63;.
	 *
	 * @param isAvalable the is avalable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dish table, or <code>null</code> if a matching dish table could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DishTable fetchByIsAvalable_First(boolean isAvalable,
		OrderByComparator orderByComparator) throws SystemException {
		List<DishTable> list = findByIsAvalable(isAvalable, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dish table in the ordered set where isAvalable = &#63;.
	 *
	 * @param isAvalable the is avalable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dish table
	 * @throws irestads.NoSuchDishTableException if a matching dish table could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DishTable findByIsAvalable_Last(boolean isAvalable,
		OrderByComparator orderByComparator)
		throws NoSuchDishTableException, SystemException {
		DishTable dishTable = fetchByIsAvalable_Last(isAvalable,
				orderByComparator);

		if (dishTable != null) {
			return dishTable;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("isAvalable=");
		msg.append(isAvalable);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDishTableException(msg.toString());
	}

	/**
	 * Returns the last dish table in the ordered set where isAvalable = &#63;.
	 *
	 * @param isAvalable the is avalable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dish table, or <code>null</code> if a matching dish table could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DishTable fetchByIsAvalable_Last(boolean isAvalable,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByIsAvalable(isAvalable);

		List<DishTable> list = findByIsAvalable(isAvalable, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dish tables before and after the current dish table in the ordered set where isAvalable = &#63;.
	 *
	 * @param dishTableId the primary key of the current dish table
	 * @param isAvalable the is avalable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dish table
	 * @throws irestads.NoSuchDishTableException if a dish table with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DishTable[] findByIsAvalable_PrevAndNext(String dishTableId,
		boolean isAvalable, OrderByComparator orderByComparator)
		throws NoSuchDishTableException, SystemException {
		DishTable dishTable = findByPrimaryKey(dishTableId);

		Session session = null;

		try {
			session = openSession();

			DishTable[] array = new DishTableImpl[3];

			array[0] = getByIsAvalable_PrevAndNext(session, dishTable,
					isAvalable, orderByComparator, true);

			array[1] = dishTable;

			array[2] = getByIsAvalable_PrevAndNext(session, dishTable,
					isAvalable, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected DishTable getByIsAvalable_PrevAndNext(Session session,
		DishTable dishTable, boolean isAvalable,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DISHTABLE_WHERE);

		query.append(_FINDER_COLUMN_ISAVALABLE_ISAVALABLE_2);

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
			query.append(DishTableModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(isAvalable);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(dishTable);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DishTable> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the dish tables.
	 *
	 * @return the dish tables
	 * @throws SystemException if a system exception occurred
	 */
	public List<DishTable> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dish tables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of dish tables
	 * @param end the upper bound of the range of dish tables (not inclusive)
	 * @return the range of dish tables
	 * @throws SystemException if a system exception occurred
	 */
	public List<DishTable> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the dish tables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of dish tables
	 * @param end the upper bound of the range of dish tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dish tables
	 * @throws SystemException if a system exception occurred
	 */
	public List<DishTable> findAll(int start, int end,
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

		List<DishTable> list = (List<DishTable>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_DISHTABLE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DISHTABLE.concat(DishTableModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<DishTable>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<DishTable>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the dish tables where isAvalable = &#63; from the database.
	 *
	 * @param isAvalable the is avalable
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByIsAvalable(boolean isAvalable)
		throws SystemException {
		for (DishTable dishTable : findByIsAvalable(isAvalable)) {
			remove(dishTable);
		}
	}

	/**
	 * Removes all the dish tables from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (DishTable dishTable : findAll()) {
			remove(dishTable);
		}
	}

	/**
	 * Returns the number of dish tables where isAvalable = &#63;.
	 *
	 * @param isAvalable the is avalable
	 * @return the number of matching dish tables
	 * @throws SystemException if a system exception occurred
	 */
	public int countByIsAvalable(boolean isAvalable) throws SystemException {
		Object[] finderArgs = new Object[] { isAvalable };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ISAVALABLE,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DISHTABLE_WHERE);

			query.append(_FINDER_COLUMN_ISAVALABLE_ISAVALABLE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(isAvalable);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ISAVALABLE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of dish tables.
	 *
	 * @return the number of dish tables
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_DISHTABLE);

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
	 * Returns all the orderses associated with the dish table.
	 *
	 * @param pk the primary key of the dish table
	 * @return the orderses associated with the dish table
	 * @throws SystemException if a system exception occurred
	 */
	public List<irestads.model.Orders> getOrderses(String pk)
		throws SystemException {
		return getOrderses(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	/**
	 * Returns a range of all the orderses associated with the dish table.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param pk the primary key of the dish table
	 * @param start the lower bound of the range of dish tables
	 * @param end the upper bound of the range of dish tables (not inclusive)
	 * @return the range of orderses associated with the dish table
	 * @throws SystemException if a system exception occurred
	 */
	public List<irestads.model.Orders> getOrderses(String pk, int start, int end)
		throws SystemException {
		return getOrderses(pk, start, end, null);
	}

	public static final FinderPath FINDER_PATH_GET_ORDERSES = new FinderPath(irestads.model.impl.OrdersModelImpl.ENTITY_CACHE_ENABLED,
			irestads.model.impl.OrdersModelImpl.FINDER_CACHE_ENABLED,
			irestads.model.impl.OrdersImpl.class,
			irestads.service.persistence.OrdersPersistenceImpl.FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"getOrderses",
			new String[] {
				String.class.getName(), "java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});

	static {
		FINDER_PATH_GET_ORDERSES.setCacheKeyGeneratorCacheName(null);
	}

	/**
	 * Returns an ordered range of all the orderses associated with the dish table.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param pk the primary key of the dish table
	 * @param start the lower bound of the range of dish tables
	 * @param end the upper bound of the range of dish tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of orderses associated with the dish table
	 * @throws SystemException if a system exception occurred
	 */
	public List<irestads.model.Orders> getOrderses(String pk, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] { pk, start, end, orderByComparator };

		List<irestads.model.Orders> list = (List<irestads.model.Orders>)FinderCacheUtil.getResult(FINDER_PATH_GET_ORDERSES,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				String sql = null;

				if (orderByComparator != null) {
					sql = _SQL_GETORDERSES.concat(ORDER_BY_CLAUSE)
										  .concat(orderByComparator.getOrderBy());
				}
				else {
					sql = _SQL_GETORDERSES;
				}

				SQLQuery q = session.createSQLQuery(sql);

				q.addEntity("dishsstore_Orders",
					irestads.model.impl.OrdersImpl.class);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(pk);

				list = (List<irestads.model.Orders>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_GET_ORDERSES,
						finderArgs);
				}
				else {
					ordersPersistence.cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_GET_ORDERSES,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	public static final FinderPath FINDER_PATH_GET_ORDERSES_SIZE = new FinderPath(irestads.model.impl.OrdersModelImpl.ENTITY_CACHE_ENABLED,
			irestads.model.impl.OrdersModelImpl.FINDER_CACHE_ENABLED,
			irestads.model.impl.OrdersImpl.class,
			irestads.service.persistence.OrdersPersistenceImpl.FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"getOrdersesSize", new String[] { String.class.getName() });

	static {
		FINDER_PATH_GET_ORDERSES_SIZE.setCacheKeyGeneratorCacheName(null);
	}

	/**
	 * Returns the number of orderses associated with the dish table.
	 *
	 * @param pk the primary key of the dish table
	 * @return the number of orderses associated with the dish table
	 * @throws SystemException if a system exception occurred
	 */
	public int getOrdersesSize(String pk) throws SystemException {
		Object[] finderArgs = new Object[] { pk };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_GET_ORDERSES_SIZE,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				SQLQuery q = session.createSQLQuery(_SQL_GETORDERSESSIZE);

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

				FinderCacheUtil.putResult(FINDER_PATH_GET_ORDERSES_SIZE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public static final FinderPath FINDER_PATH_CONTAINS_ORDERS = new FinderPath(irestads.model.impl.OrdersModelImpl.ENTITY_CACHE_ENABLED,
			irestads.model.impl.OrdersModelImpl.FINDER_CACHE_ENABLED,
			irestads.model.impl.OrdersImpl.class,
			irestads.service.persistence.OrdersPersistenceImpl.FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"containsOrders",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns <code>true</code> if the orders is associated with the dish table.
	 *
	 * @param pk the primary key of the dish table
	 * @param ordersPK the primary key of the orders
	 * @return <code>true</code> if the orders is associated with the dish table; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	public boolean containsOrders(String pk, long ordersPK)
		throws SystemException {
		Object[] finderArgs = new Object[] { pk, ordersPK };

		Boolean value = (Boolean)FinderCacheUtil.getResult(FINDER_PATH_CONTAINS_ORDERS,
				finderArgs, this);

		if (value == null) {
			try {
				value = Boolean.valueOf(containsOrders.contains(pk, ordersPK));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (value == null) {
					value = Boolean.FALSE;
				}

				FinderCacheUtil.putResult(FINDER_PATH_CONTAINS_ORDERS,
					finderArgs, value);
			}
		}

		return value.booleanValue();
	}

	/**
	 * Returns <code>true</code> if the dish table has any orderses associated with it.
	 *
	 * @param pk the primary key of the dish table to check for associations with orderses
	 * @return <code>true</code> if the dish table has any orderses associated with it; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	public boolean containsOrderses(String pk) throws SystemException {
		if (getOrdersesSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Initializes the dish table persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.irestads.model.DishTable")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<DishTable>> listenersList = new ArrayList<ModelListener<DishTable>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<DishTable>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}

		containsOrders = new ContainsOrders();
	}

	public void destroy() {
		EntityCacheUtil.removeCache(DishTableImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = CategoryPersistence.class)
	protected CategoryPersistence categoryPersistence;
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
	protected ContainsOrders containsOrders;

	protected class ContainsOrders {
		protected ContainsOrders() {
			_mappingSqlQuery = MappingSqlQueryFactoryUtil.getMappingSqlQuery(getDataSource(),
					_SQL_CONTAINSORDERS,
					new int[] { java.sql.Types.VARCHAR, java.sql.Types.BIGINT },
					RowMapper.COUNT);
		}

		protected boolean contains(String dishTableId, long orderId) {
			List<Integer> results = _mappingSqlQuery.execute(new Object[] {
						dishTableId, new Long(orderId)
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

	private static final String _SQL_SELECT_DISHTABLE = "SELECT dishTable FROM DishTable dishTable";
	private static final String _SQL_SELECT_DISHTABLE_WHERE = "SELECT dishTable FROM DishTable dishTable WHERE ";
	private static final String _SQL_COUNT_DISHTABLE = "SELECT COUNT(dishTable) FROM DishTable dishTable";
	private static final String _SQL_COUNT_DISHTABLE_WHERE = "SELECT COUNT(dishTable) FROM DishTable dishTable WHERE ";
	private static final String _SQL_GETORDERSES = "SELECT {dishsstore_Orders.*} FROM dishsstore_Orders INNER JOIN dishsstore_DishTable ON (dishsstore_DishTable.dishTableId = dishsstore_Orders.dishTableId) WHERE (dishsstore_DishTable.dishTableId = ?)";
	private static final String _SQL_GETORDERSESSIZE = "SELECT COUNT(*) AS COUNT_VALUE FROM dishsstore_Orders WHERE dishTableId = ?";
	private static final String _SQL_CONTAINSORDERS = "SELECT COUNT(*) AS COUNT_VALUE FROM dishsstore_Orders WHERE dishTableId = ? AND orderId = ?";
	private static final String _FINDER_COLUMN_ISAVALABLE_ISAVALABLE_2 = "dishTable.isAvalable = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "dishTable.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No DishTable exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No DishTable exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(DishTablePersistenceImpl.class);
	private static DishTable _nullDishTable = new DishTableImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<DishTable> toCacheModel() {
				return _nullDishTableCacheModel;
			}
		};

	private static CacheModel<DishTable> _nullDishTableCacheModel = new CacheModel<DishTable>() {
			public DishTable toEntityModel() {
				return _nullDishTable;
			}
		};
}