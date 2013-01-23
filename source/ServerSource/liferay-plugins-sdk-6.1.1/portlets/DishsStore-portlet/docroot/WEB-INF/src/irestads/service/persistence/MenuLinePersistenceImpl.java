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
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import irestads.NoSuchMenuLineException;

import irestads.model.MenuLine;

import irestads.model.impl.MenuLineImpl;
import irestads.model.impl.MenuLineModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the menu line service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Be
 * @see MenuLinePersistence
 * @see MenuLineUtil
 * @generated
 */
public class MenuLinePersistenceImpl extends BasePersistenceImpl<MenuLine>
	implements MenuLinePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link MenuLineUtil} to access the menu line persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = MenuLineImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS = new FinderPath(MenuLineModelImpl.ENTITY_CACHE_ENABLED,
			MenuLineModelImpl.FINDER_CACHE_ENABLED, MenuLineImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStatus",
			new String[] {
				Boolean.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS =
		new FinderPath(MenuLineModelImpl.ENTITY_CACHE_ENABLED,
			MenuLineModelImpl.FINDER_CACHE_ENABLED, MenuLineImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStatus",
			new String[] { Boolean.class.getName() },
			MenuLineModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STATUS = new FinderPath(MenuLineModelImpl.ENTITY_CACHE_ENABLED,
			MenuLineModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStatus",
			new String[] { Boolean.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DISHID = new FinderPath(MenuLineModelImpl.ENTITY_CACHE_ENABLED,
			MenuLineModelImpl.FINDER_CACHE_ENABLED, MenuLineImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDishId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DISHID =
		new FinderPath(MenuLineModelImpl.ENTITY_CACHE_ENABLED,
			MenuLineModelImpl.FINDER_CACHE_ENABLED, MenuLineImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDishId",
			new String[] { Long.class.getName() },
			MenuLineModelImpl.DISHID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DISHID = new FinderPath(MenuLineModelImpl.ENTITY_CACHE_ENABLED,
			MenuLineModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDishId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_NUMOFDISH =
		new FinderPath(MenuLineModelImpl.ENTITY_CACHE_ENABLED,
			MenuLineModelImpl.FINDER_CACHE_ENABLED, MenuLineImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByNumOfDish",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NUMOFDISH =
		new FinderPath(MenuLineModelImpl.ENTITY_CACHE_ENABLED,
			MenuLineModelImpl.FINDER_CACHE_ENABLED, MenuLineImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByNumOfDish",
			new String[] { Integer.class.getName() },
			MenuLineModelImpl.NUMOFDISH_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NUMOFDISH = new FinderPath(MenuLineModelImpl.ENTITY_CACHE_ENABLED,
			MenuLineModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByNumOfDish",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(MenuLineModelImpl.ENTITY_CACHE_ENABLED,
			MenuLineModelImpl.FINDER_CACHE_ENABLED, MenuLineImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(MenuLineModelImpl.ENTITY_CACHE_ENABLED,
			MenuLineModelImpl.FINDER_CACHE_ENABLED, MenuLineImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(MenuLineModelImpl.ENTITY_CACHE_ENABLED,
			MenuLineModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the menu line in the entity cache if it is enabled.
	 *
	 * @param menuLine the menu line
	 */
	public void cacheResult(MenuLine menuLine) {
		EntityCacheUtil.putResult(MenuLineModelImpl.ENTITY_CACHE_ENABLED,
			MenuLineImpl.class, menuLine.getPrimaryKey(), menuLine);

		menuLine.resetOriginalValues();
	}

	/**
	 * Caches the menu lines in the entity cache if it is enabled.
	 *
	 * @param menuLines the menu lines
	 */
	public void cacheResult(List<MenuLine> menuLines) {
		for (MenuLine menuLine : menuLines) {
			if (EntityCacheUtil.getResult(
						MenuLineModelImpl.ENTITY_CACHE_ENABLED,
						MenuLineImpl.class, menuLine.getPrimaryKey()) == null) {
				cacheResult(menuLine);
			}
			else {
				menuLine.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all menu lines.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(MenuLineImpl.class.getName());
		}

		EntityCacheUtil.clearCache(MenuLineImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the menu line.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(MenuLine menuLine) {
		EntityCacheUtil.removeResult(MenuLineModelImpl.ENTITY_CACHE_ENABLED,
			MenuLineImpl.class, menuLine.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<MenuLine> menuLines) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (MenuLine menuLine : menuLines) {
			EntityCacheUtil.removeResult(MenuLineModelImpl.ENTITY_CACHE_ENABLED,
				MenuLineImpl.class, menuLine.getPrimaryKey());
		}
	}

	/**
	 * Creates a new menu line with the primary key. Does not add the menu line to the database.
	 *
	 * @param menuLineId the primary key for the new menu line
	 * @return the new menu line
	 */
	public MenuLine create(long menuLineId) {
		MenuLine menuLine = new MenuLineImpl();

		menuLine.setNew(true);
		menuLine.setPrimaryKey(menuLineId);

		return menuLine;
	}

	/**
	 * Removes the menu line with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param menuLineId the primary key of the menu line
	 * @return the menu line that was removed
	 * @throws irestads.NoSuchMenuLineException if a menu line with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public MenuLine remove(long menuLineId)
		throws NoSuchMenuLineException, SystemException {
		return remove(Long.valueOf(menuLineId));
	}

	/**
	 * Removes the menu line with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the menu line
	 * @return the menu line that was removed
	 * @throws irestads.NoSuchMenuLineException if a menu line with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MenuLine remove(Serializable primaryKey)
		throws NoSuchMenuLineException, SystemException {
		Session session = null;

		try {
			session = openSession();

			MenuLine menuLine = (MenuLine)session.get(MenuLineImpl.class,
					primaryKey);

			if (menuLine == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMenuLineException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(menuLine);
		}
		catch (NoSuchMenuLineException nsee) {
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
	protected MenuLine removeImpl(MenuLine menuLine) throws SystemException {
		menuLine = toUnwrappedModel(menuLine);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, menuLine);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(menuLine);

		return menuLine;
	}

	@Override
	public MenuLine updateImpl(irestads.model.MenuLine menuLine, boolean merge)
		throws SystemException {
		menuLine = toUnwrappedModel(menuLine);

		boolean isNew = menuLine.isNew();

		MenuLineModelImpl menuLineModelImpl = (MenuLineModelImpl)menuLine;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, menuLine, merge);

			menuLine.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !MenuLineModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((menuLineModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Boolean.valueOf(menuLineModelImpl.getOriginalStatus())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);

				args = new Object[] {
						Boolean.valueOf(menuLineModelImpl.getStatus())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);
			}

			if ((menuLineModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DISHID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(menuLineModelImpl.getOriginalDishId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DISHID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DISHID,
					args);

				args = new Object[] { Long.valueOf(menuLineModelImpl.getDishId()) };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DISHID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DISHID,
					args);
			}

			if ((menuLineModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NUMOFDISH.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Integer.valueOf(menuLineModelImpl.getOriginalNumOfDish())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NUMOFDISH,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NUMOFDISH,
					args);

				args = new Object[] {
						Integer.valueOf(menuLineModelImpl.getNumOfDish())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NUMOFDISH,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NUMOFDISH,
					args);
			}
		}

		EntityCacheUtil.putResult(MenuLineModelImpl.ENTITY_CACHE_ENABLED,
			MenuLineImpl.class, menuLine.getPrimaryKey(), menuLine);

		return menuLine;
	}

	protected MenuLine toUnwrappedModel(MenuLine menuLine) {
		if (menuLine instanceof MenuLineImpl) {
			return menuLine;
		}

		MenuLineImpl menuLineImpl = new MenuLineImpl();

		menuLineImpl.setNew(menuLine.isNew());
		menuLineImpl.setPrimaryKey(menuLine.getPrimaryKey());

		menuLineImpl.setMenuLineId(menuLine.getMenuLineId());
		menuLineImpl.setCompanyId(menuLine.getCompanyId());
		menuLineImpl.setUserId(menuLine.getUserId());
		menuLineImpl.setUserName(menuLine.getUserName());
		menuLineImpl.setCreateDate(menuLine.getCreateDate());
		menuLineImpl.setModifiedDate(menuLine.getModifiedDate());
		menuLineImpl.setNumOfDish(menuLine.getNumOfDish());
		menuLineImpl.setStatus(menuLine.isStatus());
		menuLineImpl.setDishId(menuLine.getDishId());

		return menuLineImpl;
	}

	/**
	 * Returns the menu line with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the menu line
	 * @return the menu line
	 * @throws com.liferay.portal.NoSuchModelException if a menu line with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MenuLine findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the menu line with the primary key or throws a {@link irestads.NoSuchMenuLineException} if it could not be found.
	 *
	 * @param menuLineId the primary key of the menu line
	 * @return the menu line
	 * @throws irestads.NoSuchMenuLineException if a menu line with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public MenuLine findByPrimaryKey(long menuLineId)
		throws NoSuchMenuLineException, SystemException {
		MenuLine menuLine = fetchByPrimaryKey(menuLineId);

		if (menuLine == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + menuLineId);
			}

			throw new NoSuchMenuLineException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				menuLineId);
		}

		return menuLine;
	}

	/**
	 * Returns the menu line with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the menu line
	 * @return the menu line, or <code>null</code> if a menu line with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MenuLine fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the menu line with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param menuLineId the primary key of the menu line
	 * @return the menu line, or <code>null</code> if a menu line with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public MenuLine fetchByPrimaryKey(long menuLineId)
		throws SystemException {
		MenuLine menuLine = (MenuLine)EntityCacheUtil.getResult(MenuLineModelImpl.ENTITY_CACHE_ENABLED,
				MenuLineImpl.class, menuLineId);

		if (menuLine == _nullMenuLine) {
			return null;
		}

		if (menuLine == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				menuLine = (MenuLine)session.get(MenuLineImpl.class,
						Long.valueOf(menuLineId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (menuLine != null) {
					cacheResult(menuLine);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(MenuLineModelImpl.ENTITY_CACHE_ENABLED,
						MenuLineImpl.class, menuLineId, _nullMenuLine);
				}

				closeSession(session);
			}
		}

		return menuLine;
	}

	/**
	 * Returns all the menu lines where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching menu lines
	 * @throws SystemException if a system exception occurred
	 */
	public List<MenuLine> findByStatus(boolean status)
		throws SystemException {
		return findByStatus(status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the menu lines where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of menu lines
	 * @param end the upper bound of the range of menu lines (not inclusive)
	 * @return the range of matching menu lines
	 * @throws SystemException if a system exception occurred
	 */
	public List<MenuLine> findByStatus(boolean status, int start, int end)
		throws SystemException {
		return findByStatus(status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the menu lines where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of menu lines
	 * @param end the upper bound of the range of menu lines (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching menu lines
	 * @throws SystemException if a system exception occurred
	 */
	public List<MenuLine> findByStatus(boolean status, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS;
			finderArgs = new Object[] { status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS;
			finderArgs = new Object[] { status, start, end, orderByComparator };
		}

		List<MenuLine> list = (List<MenuLine>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (MenuLine menuLine : list) {
				if ((status != menuLine.getStatus())) {
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

			query.append(_SQL_SELECT_MENULINE_WHERE);

			query.append(_FINDER_COLUMN_STATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(MenuLineModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(status);

				list = (List<MenuLine>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first menu line in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching menu line
	 * @throws irestads.NoSuchMenuLineException if a matching menu line could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public MenuLine findByStatus_First(boolean status,
		OrderByComparator orderByComparator)
		throws NoSuchMenuLineException, SystemException {
		MenuLine menuLine = fetchByStatus_First(status, orderByComparator);

		if (menuLine != null) {
			return menuLine;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMenuLineException(msg.toString());
	}

	/**
	 * Returns the first menu line in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching menu line, or <code>null</code> if a matching menu line could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public MenuLine fetchByStatus_First(boolean status,
		OrderByComparator orderByComparator) throws SystemException {
		List<MenuLine> list = findByStatus(status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last menu line in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching menu line
	 * @throws irestads.NoSuchMenuLineException if a matching menu line could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public MenuLine findByStatus_Last(boolean status,
		OrderByComparator orderByComparator)
		throws NoSuchMenuLineException, SystemException {
		MenuLine menuLine = fetchByStatus_Last(status, orderByComparator);

		if (menuLine != null) {
			return menuLine;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMenuLineException(msg.toString());
	}

	/**
	 * Returns the last menu line in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching menu line, or <code>null</code> if a matching menu line could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public MenuLine fetchByStatus_Last(boolean status,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByStatus(status);

		List<MenuLine> list = findByStatus(status, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the menu lines before and after the current menu line in the ordered set where status = &#63;.
	 *
	 * @param menuLineId the primary key of the current menu line
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next menu line
	 * @throws irestads.NoSuchMenuLineException if a menu line with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public MenuLine[] findByStatus_PrevAndNext(long menuLineId, boolean status,
		OrderByComparator orderByComparator)
		throws NoSuchMenuLineException, SystemException {
		MenuLine menuLine = findByPrimaryKey(menuLineId);

		Session session = null;

		try {
			session = openSession();

			MenuLine[] array = new MenuLineImpl[3];

			array[0] = getByStatus_PrevAndNext(session, menuLine, status,
					orderByComparator, true);

			array[1] = menuLine;

			array[2] = getByStatus_PrevAndNext(session, menuLine, status,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected MenuLine getByStatus_PrevAndNext(Session session,
		MenuLine menuLine, boolean status, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MENULINE_WHERE);

		query.append(_FINDER_COLUMN_STATUS_STATUS_2);

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
			query.append(MenuLineModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(menuLine);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MenuLine> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the menu lines where dishId = &#63;.
	 *
	 * @param dishId the dish ID
	 * @return the matching menu lines
	 * @throws SystemException if a system exception occurred
	 */
	public List<MenuLine> findByDishId(long dishId) throws SystemException {
		return findByDishId(dishId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the menu lines where dishId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param dishId the dish ID
	 * @param start the lower bound of the range of menu lines
	 * @param end the upper bound of the range of menu lines (not inclusive)
	 * @return the range of matching menu lines
	 * @throws SystemException if a system exception occurred
	 */
	public List<MenuLine> findByDishId(long dishId, int start, int end)
		throws SystemException {
		return findByDishId(dishId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the menu lines where dishId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param dishId the dish ID
	 * @param start the lower bound of the range of menu lines
	 * @param end the upper bound of the range of menu lines (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching menu lines
	 * @throws SystemException if a system exception occurred
	 */
	public List<MenuLine> findByDishId(long dishId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DISHID;
			finderArgs = new Object[] { dishId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DISHID;
			finderArgs = new Object[] { dishId, start, end, orderByComparator };
		}

		List<MenuLine> list = (List<MenuLine>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (MenuLine menuLine : list) {
				if ((dishId != menuLine.getDishId())) {
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

			query.append(_SQL_SELECT_MENULINE_WHERE);

			query.append(_FINDER_COLUMN_DISHID_DISHID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(MenuLineModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(dishId);

				list = (List<MenuLine>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first menu line in the ordered set where dishId = &#63;.
	 *
	 * @param dishId the dish ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching menu line
	 * @throws irestads.NoSuchMenuLineException if a matching menu line could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public MenuLine findByDishId_First(long dishId,
		OrderByComparator orderByComparator)
		throws NoSuchMenuLineException, SystemException {
		MenuLine menuLine = fetchByDishId_First(dishId, orderByComparator);

		if (menuLine != null) {
			return menuLine;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("dishId=");
		msg.append(dishId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMenuLineException(msg.toString());
	}

	/**
	 * Returns the first menu line in the ordered set where dishId = &#63;.
	 *
	 * @param dishId the dish ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching menu line, or <code>null</code> if a matching menu line could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public MenuLine fetchByDishId_First(long dishId,
		OrderByComparator orderByComparator) throws SystemException {
		List<MenuLine> list = findByDishId(dishId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last menu line in the ordered set where dishId = &#63;.
	 *
	 * @param dishId the dish ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching menu line
	 * @throws irestads.NoSuchMenuLineException if a matching menu line could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public MenuLine findByDishId_Last(long dishId,
		OrderByComparator orderByComparator)
		throws NoSuchMenuLineException, SystemException {
		MenuLine menuLine = fetchByDishId_Last(dishId, orderByComparator);

		if (menuLine != null) {
			return menuLine;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("dishId=");
		msg.append(dishId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMenuLineException(msg.toString());
	}

	/**
	 * Returns the last menu line in the ordered set where dishId = &#63;.
	 *
	 * @param dishId the dish ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching menu line, or <code>null</code> if a matching menu line could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public MenuLine fetchByDishId_Last(long dishId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByDishId(dishId);

		List<MenuLine> list = findByDishId(dishId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the menu lines before and after the current menu line in the ordered set where dishId = &#63;.
	 *
	 * @param menuLineId the primary key of the current menu line
	 * @param dishId the dish ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next menu line
	 * @throws irestads.NoSuchMenuLineException if a menu line with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public MenuLine[] findByDishId_PrevAndNext(long menuLineId, long dishId,
		OrderByComparator orderByComparator)
		throws NoSuchMenuLineException, SystemException {
		MenuLine menuLine = findByPrimaryKey(menuLineId);

		Session session = null;

		try {
			session = openSession();

			MenuLine[] array = new MenuLineImpl[3];

			array[0] = getByDishId_PrevAndNext(session, menuLine, dishId,
					orderByComparator, true);

			array[1] = menuLine;

			array[2] = getByDishId_PrevAndNext(session, menuLine, dishId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected MenuLine getByDishId_PrevAndNext(Session session,
		MenuLine menuLine, long dishId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MENULINE_WHERE);

		query.append(_FINDER_COLUMN_DISHID_DISHID_2);

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
			query.append(MenuLineModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(dishId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(menuLine);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MenuLine> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the menu lines where numOfDish = &#63;.
	 *
	 * @param numOfDish the num of dish
	 * @return the matching menu lines
	 * @throws SystemException if a system exception occurred
	 */
	public List<MenuLine> findByNumOfDish(int numOfDish)
		throws SystemException {
		return findByNumOfDish(numOfDish, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the menu lines where numOfDish = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param numOfDish the num of dish
	 * @param start the lower bound of the range of menu lines
	 * @param end the upper bound of the range of menu lines (not inclusive)
	 * @return the range of matching menu lines
	 * @throws SystemException if a system exception occurred
	 */
	public List<MenuLine> findByNumOfDish(int numOfDish, int start, int end)
		throws SystemException {
		return findByNumOfDish(numOfDish, start, end, null);
	}

	/**
	 * Returns an ordered range of all the menu lines where numOfDish = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param numOfDish the num of dish
	 * @param start the lower bound of the range of menu lines
	 * @param end the upper bound of the range of menu lines (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching menu lines
	 * @throws SystemException if a system exception occurred
	 */
	public List<MenuLine> findByNumOfDish(int numOfDish, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NUMOFDISH;
			finderArgs = new Object[] { numOfDish };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_NUMOFDISH;
			finderArgs = new Object[] { numOfDish, start, end, orderByComparator };
		}

		List<MenuLine> list = (List<MenuLine>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (MenuLine menuLine : list) {
				if ((numOfDish != menuLine.getNumOfDish())) {
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

			query.append(_SQL_SELECT_MENULINE_WHERE);

			query.append(_FINDER_COLUMN_NUMOFDISH_NUMOFDISH_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(MenuLineModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(numOfDish);

				list = (List<MenuLine>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first menu line in the ordered set where numOfDish = &#63;.
	 *
	 * @param numOfDish the num of dish
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching menu line
	 * @throws irestads.NoSuchMenuLineException if a matching menu line could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public MenuLine findByNumOfDish_First(int numOfDish,
		OrderByComparator orderByComparator)
		throws NoSuchMenuLineException, SystemException {
		MenuLine menuLine = fetchByNumOfDish_First(numOfDish, orderByComparator);

		if (menuLine != null) {
			return menuLine;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("numOfDish=");
		msg.append(numOfDish);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMenuLineException(msg.toString());
	}

	/**
	 * Returns the first menu line in the ordered set where numOfDish = &#63;.
	 *
	 * @param numOfDish the num of dish
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching menu line, or <code>null</code> if a matching menu line could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public MenuLine fetchByNumOfDish_First(int numOfDish,
		OrderByComparator orderByComparator) throws SystemException {
		List<MenuLine> list = findByNumOfDish(numOfDish, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last menu line in the ordered set where numOfDish = &#63;.
	 *
	 * @param numOfDish the num of dish
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching menu line
	 * @throws irestads.NoSuchMenuLineException if a matching menu line could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public MenuLine findByNumOfDish_Last(int numOfDish,
		OrderByComparator orderByComparator)
		throws NoSuchMenuLineException, SystemException {
		MenuLine menuLine = fetchByNumOfDish_Last(numOfDish, orderByComparator);

		if (menuLine != null) {
			return menuLine;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("numOfDish=");
		msg.append(numOfDish);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMenuLineException(msg.toString());
	}

	/**
	 * Returns the last menu line in the ordered set where numOfDish = &#63;.
	 *
	 * @param numOfDish the num of dish
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching menu line, or <code>null</code> if a matching menu line could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public MenuLine fetchByNumOfDish_Last(int numOfDish,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByNumOfDish(numOfDish);

		List<MenuLine> list = findByNumOfDish(numOfDish, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the menu lines before and after the current menu line in the ordered set where numOfDish = &#63;.
	 *
	 * @param menuLineId the primary key of the current menu line
	 * @param numOfDish the num of dish
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next menu line
	 * @throws irestads.NoSuchMenuLineException if a menu line with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public MenuLine[] findByNumOfDish_PrevAndNext(long menuLineId,
		int numOfDish, OrderByComparator orderByComparator)
		throws NoSuchMenuLineException, SystemException {
		MenuLine menuLine = findByPrimaryKey(menuLineId);

		Session session = null;

		try {
			session = openSession();

			MenuLine[] array = new MenuLineImpl[3];

			array[0] = getByNumOfDish_PrevAndNext(session, menuLine, numOfDish,
					orderByComparator, true);

			array[1] = menuLine;

			array[2] = getByNumOfDish_PrevAndNext(session, menuLine, numOfDish,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected MenuLine getByNumOfDish_PrevAndNext(Session session,
		MenuLine menuLine, int numOfDish, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MENULINE_WHERE);

		query.append(_FINDER_COLUMN_NUMOFDISH_NUMOFDISH_2);

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
			query.append(MenuLineModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(numOfDish);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(menuLine);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MenuLine> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the menu lines.
	 *
	 * @return the menu lines
	 * @throws SystemException if a system exception occurred
	 */
	public List<MenuLine> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the menu lines.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of menu lines
	 * @param end the upper bound of the range of menu lines (not inclusive)
	 * @return the range of menu lines
	 * @throws SystemException if a system exception occurred
	 */
	public List<MenuLine> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the menu lines.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of menu lines
	 * @param end the upper bound of the range of menu lines (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of menu lines
	 * @throws SystemException if a system exception occurred
	 */
	public List<MenuLine> findAll(int start, int end,
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

		List<MenuLine> list = (List<MenuLine>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_MENULINE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_MENULINE.concat(MenuLineModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<MenuLine>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<MenuLine>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the menu lines where status = &#63; from the database.
	 *
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByStatus(boolean status) throws SystemException {
		for (MenuLine menuLine : findByStatus(status)) {
			remove(menuLine);
		}
	}

	/**
	 * Removes all the menu lines where dishId = &#63; from the database.
	 *
	 * @param dishId the dish ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByDishId(long dishId) throws SystemException {
		for (MenuLine menuLine : findByDishId(dishId)) {
			remove(menuLine);
		}
	}

	/**
	 * Removes all the menu lines where numOfDish = &#63; from the database.
	 *
	 * @param numOfDish the num of dish
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByNumOfDish(int numOfDish) throws SystemException {
		for (MenuLine menuLine : findByNumOfDish(numOfDish)) {
			remove(menuLine);
		}
	}

	/**
	 * Removes all the menu lines from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (MenuLine menuLine : findAll()) {
			remove(menuLine);
		}
	}

	/**
	 * Returns the number of menu lines where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching menu lines
	 * @throws SystemException if a system exception occurred
	 */
	public int countByStatus(boolean status) throws SystemException {
		Object[] finderArgs = new Object[] { status };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_STATUS,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_MENULINE_WHERE);

			query.append(_FINDER_COLUMN_STATUS_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(status);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_STATUS,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of menu lines where dishId = &#63;.
	 *
	 * @param dishId the dish ID
	 * @return the number of matching menu lines
	 * @throws SystemException if a system exception occurred
	 */
	public int countByDishId(long dishId) throws SystemException {
		Object[] finderArgs = new Object[] { dishId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_DISHID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_MENULINE_WHERE);

			query.append(_FINDER_COLUMN_DISHID_DISHID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(dishId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_DISHID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of menu lines where numOfDish = &#63;.
	 *
	 * @param numOfDish the num of dish
	 * @return the number of matching menu lines
	 * @throws SystemException if a system exception occurred
	 */
	public int countByNumOfDish(int numOfDish) throws SystemException {
		Object[] finderArgs = new Object[] { numOfDish };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_NUMOFDISH,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_MENULINE_WHERE);

			query.append(_FINDER_COLUMN_NUMOFDISH_NUMOFDISH_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(numOfDish);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NUMOFDISH,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of menu lines.
	 *
	 * @return the number of menu lines
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_MENULINE);

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
	 * Initializes the menu line persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.irestads.model.MenuLine")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<MenuLine>> listenersList = new ArrayList<ModelListener<MenuLine>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<MenuLine>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(MenuLineImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = CategoryPersistence.class)
	protected CategoryPersistence categoryPersistence;
	@BeanReference(type = DishPersistence.class)
	protected DishPersistence dishPersistence;
	@BeanReference(type = MenuPersistence.class)
	protected MenuPersistence menuPersistence;
	@BeanReference(type = MenuLinePersistence.class)
	protected MenuLinePersistence menuLinePersistence;
	@BeanReference(type = UVersionPersistence.class)
	protected UVersionPersistence uVersionPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_MENULINE = "SELECT menuLine FROM MenuLine menuLine";
	private static final String _SQL_SELECT_MENULINE_WHERE = "SELECT menuLine FROM MenuLine menuLine WHERE ";
	private static final String _SQL_COUNT_MENULINE = "SELECT COUNT(menuLine) FROM MenuLine menuLine";
	private static final String _SQL_COUNT_MENULINE_WHERE = "SELECT COUNT(menuLine) FROM MenuLine menuLine WHERE ";
	private static final String _FINDER_COLUMN_STATUS_STATUS_2 = "menuLine.status = ?";
	private static final String _FINDER_COLUMN_DISHID_DISHID_2 = "menuLine.dishId = ?";
	private static final String _FINDER_COLUMN_NUMOFDISH_NUMOFDISH_2 = "menuLine.numOfDish = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "menuLine.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No MenuLine exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No MenuLine exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(MenuLinePersistenceImpl.class);
	private static MenuLine _nullMenuLine = new MenuLineImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<MenuLine> toCacheModel() {
				return _nullMenuLineCacheModel;
			}
		};

	private static CacheModel<MenuLine> _nullMenuLineCacheModel = new CacheModel<MenuLine>() {
			public MenuLine toEntityModel() {
				return _nullMenuLine;
			}
		};
}