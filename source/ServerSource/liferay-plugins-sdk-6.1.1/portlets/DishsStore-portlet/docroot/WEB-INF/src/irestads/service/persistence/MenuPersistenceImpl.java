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

import irestads.NoSuchMenuException;

import irestads.model.Menu;

import irestads.model.impl.MenuImpl;
import irestads.model.impl.MenuModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the menu service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Be
 * @see MenuPersistence
 * @see MenuUtil
 * @generated
 */
public class MenuPersistenceImpl extends BasePersistenceImpl<Menu>
	implements MenuPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link MenuUtil} to access the menu persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = MenuImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MENUNAME = new FinderPath(MenuModelImpl.ENTITY_CACHE_ENABLED,
			MenuModelImpl.FINDER_CACHE_ENABLED, MenuImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByMenuName",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MENUNAME =
		new FinderPath(MenuModelImpl.ENTITY_CACHE_ENABLED,
			MenuModelImpl.FINDER_CACHE_ENABLED, MenuImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByMenuName",
			new String[] { String.class.getName() },
			MenuModelImpl.MENUNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MENUNAME = new FinderPath(MenuModelImpl.ENTITY_CACHE_ENABLED,
			MenuModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByMenuName",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(MenuModelImpl.ENTITY_CACHE_ENABLED,
			MenuModelImpl.FINDER_CACHE_ENABLED, MenuImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(MenuModelImpl.ENTITY_CACHE_ENABLED,
			MenuModelImpl.FINDER_CACHE_ENABLED, MenuImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(MenuModelImpl.ENTITY_CACHE_ENABLED,
			MenuModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the menu in the entity cache if it is enabled.
	 *
	 * @param menu the menu
	 */
	public void cacheResult(Menu menu) {
		EntityCacheUtil.putResult(MenuModelImpl.ENTITY_CACHE_ENABLED,
			MenuImpl.class, menu.getPrimaryKey(), menu);

		menu.resetOriginalValues();
	}

	/**
	 * Caches the menus in the entity cache if it is enabled.
	 *
	 * @param menus the menus
	 */
	public void cacheResult(List<Menu> menus) {
		for (Menu menu : menus) {
			if (EntityCacheUtil.getResult(MenuModelImpl.ENTITY_CACHE_ENABLED,
						MenuImpl.class, menu.getPrimaryKey()) == null) {
				cacheResult(menu);
			}
			else {
				menu.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all menus.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(MenuImpl.class.getName());
		}

		EntityCacheUtil.clearCache(MenuImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the menu.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Menu menu) {
		EntityCacheUtil.removeResult(MenuModelImpl.ENTITY_CACHE_ENABLED,
			MenuImpl.class, menu.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Menu> menus) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Menu menu : menus) {
			EntityCacheUtil.removeResult(MenuModelImpl.ENTITY_CACHE_ENABLED,
				MenuImpl.class, menu.getPrimaryKey());
		}
	}

	/**
	 * Creates a new menu with the primary key. Does not add the menu to the database.
	 *
	 * @param menuId the primary key for the new menu
	 * @return the new menu
	 */
	public Menu create(long menuId) {
		Menu menu = new MenuImpl();

		menu.setNew(true);
		menu.setPrimaryKey(menuId);

		return menu;
	}

	/**
	 * Removes the menu with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param menuId the primary key of the menu
	 * @return the menu that was removed
	 * @throws irestads.NoSuchMenuException if a menu with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Menu remove(long menuId) throws NoSuchMenuException, SystemException {
		return remove(Long.valueOf(menuId));
	}

	/**
	 * Removes the menu with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the menu
	 * @return the menu that was removed
	 * @throws irestads.NoSuchMenuException if a menu with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Menu remove(Serializable primaryKey)
		throws NoSuchMenuException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Menu menu = (Menu)session.get(MenuImpl.class, primaryKey);

			if (menu == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMenuException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(menu);
		}
		catch (NoSuchMenuException nsee) {
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
	protected Menu removeImpl(Menu menu) throws SystemException {
		menu = toUnwrappedModel(menu);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, menu);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(menu);

		return menu;
	}

	@Override
	public Menu updateImpl(irestads.model.Menu menu, boolean merge)
		throws SystemException {
		menu = toUnwrappedModel(menu);

		boolean isNew = menu.isNew();

		MenuModelImpl menuModelImpl = (MenuModelImpl)menu;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, menu, merge);

			menu.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !MenuModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((menuModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MENUNAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { menuModelImpl.getOriginalMenuName() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MENUNAME, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MENUNAME,
					args);

				args = new Object[] { menuModelImpl.getMenuName() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MENUNAME, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MENUNAME,
					args);
			}
		}

		EntityCacheUtil.putResult(MenuModelImpl.ENTITY_CACHE_ENABLED,
			MenuImpl.class, menu.getPrimaryKey(), menu);

		return menu;
	}

	protected Menu toUnwrappedModel(Menu menu) {
		if (menu instanceof MenuImpl) {
			return menu;
		}

		MenuImpl menuImpl = new MenuImpl();

		menuImpl.setNew(menu.isNew());
		menuImpl.setPrimaryKey(menu.getPrimaryKey());

		menuImpl.setMenuId(menu.getMenuId());
		menuImpl.setCompanyId(menu.getCompanyId());
		menuImpl.setUserId(menu.getUserId());
		menuImpl.setUserName(menu.getUserName());
		menuImpl.setCreateDate(menu.getCreateDate());
		menuImpl.setModifiedDate(menu.getModifiedDate());
		menuImpl.setMenuName(menu.getMenuName());

		return menuImpl;
	}

	/**
	 * Returns the menu with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the menu
	 * @return the menu
	 * @throws com.liferay.portal.NoSuchModelException if a menu with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Menu findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the menu with the primary key or throws a {@link irestads.NoSuchMenuException} if it could not be found.
	 *
	 * @param menuId the primary key of the menu
	 * @return the menu
	 * @throws irestads.NoSuchMenuException if a menu with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Menu findByPrimaryKey(long menuId)
		throws NoSuchMenuException, SystemException {
		Menu menu = fetchByPrimaryKey(menuId);

		if (menu == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + menuId);
			}

			throw new NoSuchMenuException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				menuId);
		}

		return menu;
	}

	/**
	 * Returns the menu with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the menu
	 * @return the menu, or <code>null</code> if a menu with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Menu fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the menu with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param menuId the primary key of the menu
	 * @return the menu, or <code>null</code> if a menu with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Menu fetchByPrimaryKey(long menuId) throws SystemException {
		Menu menu = (Menu)EntityCacheUtil.getResult(MenuModelImpl.ENTITY_CACHE_ENABLED,
				MenuImpl.class, menuId);

		if (menu == _nullMenu) {
			return null;
		}

		if (menu == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				menu = (Menu)session.get(MenuImpl.class, Long.valueOf(menuId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (menu != null) {
					cacheResult(menu);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(MenuModelImpl.ENTITY_CACHE_ENABLED,
						MenuImpl.class, menuId, _nullMenu);
				}

				closeSession(session);
			}
		}

		return menu;
	}

	/**
	 * Returns all the menus where menuName = &#63;.
	 *
	 * @param menuName the menu name
	 * @return the matching menus
	 * @throws SystemException if a system exception occurred
	 */
	public List<Menu> findByMenuName(String menuName) throws SystemException {
		return findByMenuName(menuName, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the menus where menuName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param menuName the menu name
	 * @param start the lower bound of the range of menus
	 * @param end the upper bound of the range of menus (not inclusive)
	 * @return the range of matching menus
	 * @throws SystemException if a system exception occurred
	 */
	public List<Menu> findByMenuName(String menuName, int start, int end)
		throws SystemException {
		return findByMenuName(menuName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the menus where menuName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param menuName the menu name
	 * @param start the lower bound of the range of menus
	 * @param end the upper bound of the range of menus (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching menus
	 * @throws SystemException if a system exception occurred
	 */
	public List<Menu> findByMenuName(String menuName, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MENUNAME;
			finderArgs = new Object[] { menuName };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MENUNAME;
			finderArgs = new Object[] { menuName, start, end, orderByComparator };
		}

		List<Menu> list = (List<Menu>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Menu menu : list) {
				if (!Validator.equals(menuName, menu.getMenuName())) {
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

			query.append(_SQL_SELECT_MENU_WHERE);

			if (menuName == null) {
				query.append(_FINDER_COLUMN_MENUNAME_MENUNAME_1);
			}
			else {
				if (menuName.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_MENUNAME_MENUNAME_3);
				}
				else {
					query.append(_FINDER_COLUMN_MENUNAME_MENUNAME_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(MenuModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (menuName != null) {
					qPos.add(menuName);
				}

				list = (List<Menu>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first menu in the ordered set where menuName = &#63;.
	 *
	 * @param menuName the menu name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching menu
	 * @throws irestads.NoSuchMenuException if a matching menu could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Menu findByMenuName_First(String menuName,
		OrderByComparator orderByComparator)
		throws NoSuchMenuException, SystemException {
		Menu menu = fetchByMenuName_First(menuName, orderByComparator);

		if (menu != null) {
			return menu;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("menuName=");
		msg.append(menuName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMenuException(msg.toString());
	}

	/**
	 * Returns the first menu in the ordered set where menuName = &#63;.
	 *
	 * @param menuName the menu name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching menu, or <code>null</code> if a matching menu could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Menu fetchByMenuName_First(String menuName,
		OrderByComparator orderByComparator) throws SystemException {
		List<Menu> list = findByMenuName(menuName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last menu in the ordered set where menuName = &#63;.
	 *
	 * @param menuName the menu name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching menu
	 * @throws irestads.NoSuchMenuException if a matching menu could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Menu findByMenuName_Last(String menuName,
		OrderByComparator orderByComparator)
		throws NoSuchMenuException, SystemException {
		Menu menu = fetchByMenuName_Last(menuName, orderByComparator);

		if (menu != null) {
			return menu;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("menuName=");
		msg.append(menuName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMenuException(msg.toString());
	}

	/**
	 * Returns the last menu in the ordered set where menuName = &#63;.
	 *
	 * @param menuName the menu name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching menu, or <code>null</code> if a matching menu could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Menu fetchByMenuName_Last(String menuName,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByMenuName(menuName);

		List<Menu> list = findByMenuName(menuName, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the menus before and after the current menu in the ordered set where menuName = &#63;.
	 *
	 * @param menuId the primary key of the current menu
	 * @param menuName the menu name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next menu
	 * @throws irestads.NoSuchMenuException if a menu with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Menu[] findByMenuName_PrevAndNext(long menuId, String menuName,
		OrderByComparator orderByComparator)
		throws NoSuchMenuException, SystemException {
		Menu menu = findByPrimaryKey(menuId);

		Session session = null;

		try {
			session = openSession();

			Menu[] array = new MenuImpl[3];

			array[0] = getByMenuName_PrevAndNext(session, menu, menuName,
					orderByComparator, true);

			array[1] = menu;

			array[2] = getByMenuName_PrevAndNext(session, menu, menuName,
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

	protected Menu getByMenuName_PrevAndNext(Session session, Menu menu,
		String menuName, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MENU_WHERE);

		if (menuName == null) {
			query.append(_FINDER_COLUMN_MENUNAME_MENUNAME_1);
		}
		else {
			if (menuName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_MENUNAME_MENUNAME_3);
			}
			else {
				query.append(_FINDER_COLUMN_MENUNAME_MENUNAME_2);
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
			query.append(MenuModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (menuName != null) {
			qPos.add(menuName);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(menu);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Menu> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the menus.
	 *
	 * @return the menus
	 * @throws SystemException if a system exception occurred
	 */
	public List<Menu> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the menus.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of menus
	 * @param end the upper bound of the range of menus (not inclusive)
	 * @return the range of menus
	 * @throws SystemException if a system exception occurred
	 */
	public List<Menu> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the menus.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of menus
	 * @param end the upper bound of the range of menus (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of menus
	 * @throws SystemException if a system exception occurred
	 */
	public List<Menu> findAll(int start, int end,
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

		List<Menu> list = (List<Menu>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_MENU);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_MENU.concat(MenuModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Menu>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Menu>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Removes all the menus where menuName = &#63; from the database.
	 *
	 * @param menuName the menu name
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByMenuName(String menuName) throws SystemException {
		for (Menu menu : findByMenuName(menuName)) {
			remove(menu);
		}
	}

	/**
	 * Removes all the menus from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Menu menu : findAll()) {
			remove(menu);
		}
	}

	/**
	 * Returns the number of menus where menuName = &#63;.
	 *
	 * @param menuName the menu name
	 * @return the number of matching menus
	 * @throws SystemException if a system exception occurred
	 */
	public int countByMenuName(String menuName) throws SystemException {
		Object[] finderArgs = new Object[] { menuName };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_MENUNAME,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_MENU_WHERE);

			if (menuName == null) {
				query.append(_FINDER_COLUMN_MENUNAME_MENUNAME_1);
			}
			else {
				if (menuName.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_MENUNAME_MENUNAME_3);
				}
				else {
					query.append(_FINDER_COLUMN_MENUNAME_MENUNAME_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (menuName != null) {
					qPos.add(menuName);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_MENUNAME,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of menus.
	 *
	 * @return the number of menus
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_MENU);

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
	 * Returns all the menu lines associated with the menu.
	 *
	 * @param pk the primary key of the menu
	 * @return the menu lines associated with the menu
	 * @throws SystemException if a system exception occurred
	 */
	public List<irestads.model.MenuLine> getMenuLines(long pk)
		throws SystemException {
		return getMenuLines(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	/**
	 * Returns a range of all the menu lines associated with the menu.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param pk the primary key of the menu
	 * @param start the lower bound of the range of menus
	 * @param end the upper bound of the range of menus (not inclusive)
	 * @return the range of menu lines associated with the menu
	 * @throws SystemException if a system exception occurred
	 */
	public List<irestads.model.MenuLine> getMenuLines(long pk, int start,
		int end) throws SystemException {
		return getMenuLines(pk, start, end, null);
	}

	public static final FinderPath FINDER_PATH_GET_MENULINES = new FinderPath(irestads.model.impl.MenuLineModelImpl.ENTITY_CACHE_ENABLED,
			irestads.model.impl.MenuLineModelImpl.FINDER_CACHE_ENABLED,
			irestads.model.impl.MenuLineImpl.class,
			irestads.service.persistence.MenuLinePersistenceImpl.FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"getMenuLines",
			new String[] {
				Long.class.getName(), "java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});

	static {
		FINDER_PATH_GET_MENULINES.setCacheKeyGeneratorCacheName(null);
	}

	/**
	 * Returns an ordered range of all the menu lines associated with the menu.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param pk the primary key of the menu
	 * @param start the lower bound of the range of menus
	 * @param end the upper bound of the range of menus (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of menu lines associated with the menu
	 * @throws SystemException if a system exception occurred
	 */
	public List<irestads.model.MenuLine> getMenuLines(long pk, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] { pk, start, end, orderByComparator };

		List<irestads.model.MenuLine> list = (List<irestads.model.MenuLine>)FinderCacheUtil.getResult(FINDER_PATH_GET_MENULINES,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				String sql = null;

				if (orderByComparator != null) {
					sql = _SQL_GETMENULINES.concat(ORDER_BY_CLAUSE)
										   .concat(orderByComparator.getOrderBy());
				}
				else {
					sql = _SQL_GETMENULINES.concat(irestads.model.impl.MenuLineModelImpl.ORDER_BY_SQL);
				}

				SQLQuery q = session.createSQLQuery(sql);

				q.addEntity("dishsstore_MenuLine",
					irestads.model.impl.MenuLineImpl.class);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(pk);

				list = (List<irestads.model.MenuLine>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_GET_MENULINES,
						finderArgs);
				}
				else {
					menuLinePersistence.cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_GET_MENULINES,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	public static final FinderPath FINDER_PATH_GET_MENULINES_SIZE = new FinderPath(irestads.model.impl.MenuLineModelImpl.ENTITY_CACHE_ENABLED,
			irestads.model.impl.MenuLineModelImpl.FINDER_CACHE_ENABLED,
			irestads.model.impl.MenuLineImpl.class,
			irestads.service.persistence.MenuLinePersistenceImpl.FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"getMenuLinesSize", new String[] { Long.class.getName() });

	static {
		FINDER_PATH_GET_MENULINES_SIZE.setCacheKeyGeneratorCacheName(null);
	}

	/**
	 * Returns the number of menu lines associated with the menu.
	 *
	 * @param pk the primary key of the menu
	 * @return the number of menu lines associated with the menu
	 * @throws SystemException if a system exception occurred
	 */
	public int getMenuLinesSize(long pk) throws SystemException {
		Object[] finderArgs = new Object[] { pk };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_GET_MENULINES_SIZE,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				SQLQuery q = session.createSQLQuery(_SQL_GETMENULINESSIZE);

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

				FinderCacheUtil.putResult(FINDER_PATH_GET_MENULINES_SIZE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public static final FinderPath FINDER_PATH_CONTAINS_MENULINE = new FinderPath(irestads.model.impl.MenuLineModelImpl.ENTITY_CACHE_ENABLED,
			irestads.model.impl.MenuLineModelImpl.FINDER_CACHE_ENABLED,
			irestads.model.impl.MenuLineImpl.class,
			irestads.service.persistence.MenuLinePersistenceImpl.FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"containsMenuLine",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns <code>true</code> if the menu line is associated with the menu.
	 *
	 * @param pk the primary key of the menu
	 * @param menuLinePK the primary key of the menu line
	 * @return <code>true</code> if the menu line is associated with the menu; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	public boolean containsMenuLine(long pk, long menuLinePK)
		throws SystemException {
		Object[] finderArgs = new Object[] { pk, menuLinePK };

		Boolean value = (Boolean)FinderCacheUtil.getResult(FINDER_PATH_CONTAINS_MENULINE,
				finderArgs, this);

		if (value == null) {
			try {
				value = Boolean.valueOf(containsMenuLine.contains(pk, menuLinePK));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (value == null) {
					value = Boolean.FALSE;
				}

				FinderCacheUtil.putResult(FINDER_PATH_CONTAINS_MENULINE,
					finderArgs, value);
			}
		}

		return value.booleanValue();
	}

	/**
	 * Returns <code>true</code> if the menu has any menu lines associated with it.
	 *
	 * @param pk the primary key of the menu to check for associations with menu lines
	 * @return <code>true</code> if the menu has any menu lines associated with it; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	public boolean containsMenuLines(long pk) throws SystemException {
		if (getMenuLinesSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Initializes the menu persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.irestads.model.Menu")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Menu>> listenersList = new ArrayList<ModelListener<Menu>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Menu>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}

		containsMenuLine = new ContainsMenuLine();
	}

	public void destroy() {
		EntityCacheUtil.removeCache(MenuImpl.class.getName());
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
	protected ContainsMenuLine containsMenuLine;

	protected class ContainsMenuLine {
		protected ContainsMenuLine() {
			_mappingSqlQuery = MappingSqlQueryFactoryUtil.getMappingSqlQuery(getDataSource(),
					_SQL_CONTAINSMENULINE,
					new int[] { java.sql.Types.BIGINT, java.sql.Types.BIGINT },
					RowMapper.COUNT);
		}

		protected boolean contains(long menuId, long menuLineId) {
			List<Integer> results = _mappingSqlQuery.execute(new Object[] {
						new Long(menuId), new Long(menuLineId)
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

	private static final String _SQL_SELECT_MENU = "SELECT menu FROM Menu menu";
	private static final String _SQL_SELECT_MENU_WHERE = "SELECT menu FROM Menu menu WHERE ";
	private static final String _SQL_COUNT_MENU = "SELECT COUNT(menu) FROM Menu menu";
	private static final String _SQL_COUNT_MENU_WHERE = "SELECT COUNT(menu) FROM Menu menu WHERE ";
	private static final String _SQL_GETMENULINES = "SELECT {dishsstore_MenuLine.*} FROM dishsstore_MenuLine INNER JOIN dishsstore_Menu ON (dishsstore_Menu.menuId = dishsstore_MenuLine.menuId) WHERE (dishsstore_Menu.menuId = ?)";
	private static final String _SQL_GETMENULINESSIZE = "SELECT COUNT(*) AS COUNT_VALUE FROM dishsstore_MenuLine WHERE menuId = ?";
	private static final String _SQL_CONTAINSMENULINE = "SELECT COUNT(*) AS COUNT_VALUE FROM dishsstore_MenuLine WHERE menuId = ? AND menuLineId = ?";
	private static final String _FINDER_COLUMN_MENUNAME_MENUNAME_1 = "menu.menuName IS NULL";
	private static final String _FINDER_COLUMN_MENUNAME_MENUNAME_2 = "menu.menuName = ?";
	private static final String _FINDER_COLUMN_MENUNAME_MENUNAME_3 = "(menu.menuName IS NULL OR menu.menuName = ?)";
	private static final String _ORDER_BY_ENTITY_ALIAS = "menu.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Menu exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Menu exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(MenuPersistenceImpl.class);
	private static Menu _nullMenu = new MenuImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Menu> toCacheModel() {
				return _nullMenuCacheModel;
			}
		};

	private static CacheModel<Menu> _nullMenuCacheModel = new CacheModel<Menu>() {
			public Menu toEntityModel() {
				return _nullMenu;
			}
		};
}