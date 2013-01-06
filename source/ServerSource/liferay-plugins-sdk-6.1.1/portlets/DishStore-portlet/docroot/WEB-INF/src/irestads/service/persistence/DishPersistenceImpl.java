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

import irestads.NoSuchDishException;

import irestads.model.Dish;

import irestads.model.impl.DishImpl;
import irestads.model.impl.DishModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the dish service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Be
 * @see DishPersistence
 * @see DishUtil
 * @generated
 */
public class DishPersistenceImpl extends BasePersistenceImpl<Dish>
	implements DishPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DishUtil} to access the dish persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DishImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DISHNAME = new FinderPath(DishModelImpl.ENTITY_CACHE_ENABLED,
			DishModelImpl.FINDER_CACHE_ENABLED, DishImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDishName",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DISHNAME =
		new FinderPath(DishModelImpl.ENTITY_CACHE_ENABLED,
			DishModelImpl.FINDER_CACHE_ENABLED, DishImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDishName",
			new String[] { String.class.getName() },
			DishModelImpl.DISHNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DISHNAME = new FinderPath(DishModelImpl.ENTITY_CACHE_ENABLED,
			DishModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDishName",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DishModelImpl.ENTITY_CACHE_ENABLED,
			DishModelImpl.FINDER_CACHE_ENABLED, DishImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DishModelImpl.ENTITY_CACHE_ENABLED,
			DishModelImpl.FINDER_CACHE_ENABLED, DishImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DishModelImpl.ENTITY_CACHE_ENABLED,
			DishModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the dish in the entity cache if it is enabled.
	 *
	 * @param dish the dish
	 */
	public void cacheResult(Dish dish) {
		EntityCacheUtil.putResult(DishModelImpl.ENTITY_CACHE_ENABLED,
			DishImpl.class, dish.getPrimaryKey(), dish);

		dish.resetOriginalValues();
	}

	/**
	 * Caches the dishs in the entity cache if it is enabled.
	 *
	 * @param dishs the dishs
	 */
	public void cacheResult(List<Dish> dishs) {
		for (Dish dish : dishs) {
			if (EntityCacheUtil.getResult(DishModelImpl.ENTITY_CACHE_ENABLED,
						DishImpl.class, dish.getPrimaryKey()) == null) {
				cacheResult(dish);
			}
			else {
				dish.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all dishs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(DishImpl.class.getName());
		}

		EntityCacheUtil.clearCache(DishImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the dish.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Dish dish) {
		EntityCacheUtil.removeResult(DishModelImpl.ENTITY_CACHE_ENABLED,
			DishImpl.class, dish.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Dish> dishs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Dish dish : dishs) {
			EntityCacheUtil.removeResult(DishModelImpl.ENTITY_CACHE_ENABLED,
				DishImpl.class, dish.getPrimaryKey());
		}
	}

	/**
	 * Creates a new dish with the primary key. Does not add the dish to the database.
	 *
	 * @param dishId the primary key for the new dish
	 * @return the new dish
	 */
	public Dish create(long dishId) {
		Dish dish = new DishImpl();

		dish.setNew(true);
		dish.setPrimaryKey(dishId);

		return dish;
	}

	/**
	 * Removes the dish with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dishId the primary key of the dish
	 * @return the dish that was removed
	 * @throws irestads.NoSuchDishException if a dish with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Dish remove(long dishId) throws NoSuchDishException, SystemException {
		return remove(Long.valueOf(dishId));
	}

	/**
	 * Removes the dish with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the dish
	 * @return the dish that was removed
	 * @throws irestads.NoSuchDishException if a dish with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Dish remove(Serializable primaryKey)
		throws NoSuchDishException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Dish dish = (Dish)session.get(DishImpl.class, primaryKey);

			if (dish == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDishException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(dish);
		}
		catch (NoSuchDishException nsee) {
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
	protected Dish removeImpl(Dish dish) throws SystemException {
		dish = toUnwrappedModel(dish);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, dish);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(dish);

		return dish;
	}

	@Override
	public Dish updateImpl(irestads.model.Dish dish, boolean merge)
		throws SystemException {
		dish = toUnwrappedModel(dish);

		boolean isNew = dish.isNew();

		DishModelImpl dishModelImpl = (DishModelImpl)dish;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, dish, merge);

			dish.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !DishModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((dishModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DISHNAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { dishModelImpl.getOriginalDishName() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DISHNAME, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DISHNAME,
					args);

				args = new Object[] { dishModelImpl.getDishName() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DISHNAME, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DISHNAME,
					args);
			}
		}

		EntityCacheUtil.putResult(DishModelImpl.ENTITY_CACHE_ENABLED,
			DishImpl.class, dish.getPrimaryKey(), dish);

		return dish;
	}

	protected Dish toUnwrappedModel(Dish dish) {
		if (dish instanceof DishImpl) {
			return dish;
		}

		DishImpl dishImpl = new DishImpl();

		dishImpl.setNew(dish.isNew());
		dishImpl.setPrimaryKey(dish.getPrimaryKey());

		dishImpl.setDishId(dish.getDishId());
		dishImpl.setCompanyId(dish.getCompanyId());
		dishImpl.setUserId(dish.getUserId());
		dishImpl.setUserName(dish.getUserName());
		dishImpl.setCreateDate(dish.getCreateDate());
		dishImpl.setModifiedDate(dish.getModifiedDate());
		dishImpl.setDishName(dish.getDishName());
		dishImpl.setDecription(dish.getDecription());
		dishImpl.setAvatarImg(dish.getAvatarImg());
		dishImpl.setDetailImg(dish.getDetailImg());
		dishImpl.setDetail(dish.getDetail());
		dishImpl.setReferPrice(dish.getReferPrice());
		dishImpl.setNumOfDiner(dish.getNumOfDiner());
		dishImpl.setCategoryId(dish.getCategoryId());

		return dishImpl;
	}

	/**
	 * Returns the dish with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the dish
	 * @return the dish
	 * @throws com.liferay.portal.NoSuchModelException if a dish with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Dish findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the dish with the primary key or throws a {@link irestads.NoSuchDishException} if it could not be found.
	 *
	 * @param dishId the primary key of the dish
	 * @return the dish
	 * @throws irestads.NoSuchDishException if a dish with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Dish findByPrimaryKey(long dishId)
		throws NoSuchDishException, SystemException {
		Dish dish = fetchByPrimaryKey(dishId);

		if (dish == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + dishId);
			}

			throw new NoSuchDishException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				dishId);
		}

		return dish;
	}

	/**
	 * Returns the dish with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the dish
	 * @return the dish, or <code>null</code> if a dish with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Dish fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the dish with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dishId the primary key of the dish
	 * @return the dish, or <code>null</code> if a dish with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Dish fetchByPrimaryKey(long dishId) throws SystemException {
		Dish dish = (Dish)EntityCacheUtil.getResult(DishModelImpl.ENTITY_CACHE_ENABLED,
				DishImpl.class, dishId);

		if (dish == _nullDish) {
			return null;
		}

		if (dish == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				dish = (Dish)session.get(DishImpl.class, Long.valueOf(dishId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (dish != null) {
					cacheResult(dish);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(DishModelImpl.ENTITY_CACHE_ENABLED,
						DishImpl.class, dishId, _nullDish);
				}

				closeSession(session);
			}
		}

		return dish;
	}

	/**
	 * Returns all the dishs where dishName = &#63;.
	 *
	 * @param dishName the dish name
	 * @return the matching dishs
	 * @throws SystemException if a system exception occurred
	 */
	public List<Dish> findByDishName(String dishName) throws SystemException {
		return findByDishName(dishName, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the dishs where dishName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param dishName the dish name
	 * @param start the lower bound of the range of dishs
	 * @param end the upper bound of the range of dishs (not inclusive)
	 * @return the range of matching dishs
	 * @throws SystemException if a system exception occurred
	 */
	public List<Dish> findByDishName(String dishName, int start, int end)
		throws SystemException {
		return findByDishName(dishName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dishs where dishName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param dishName the dish name
	 * @param start the lower bound of the range of dishs
	 * @param end the upper bound of the range of dishs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dishs
	 * @throws SystemException if a system exception occurred
	 */
	public List<Dish> findByDishName(String dishName, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DISHNAME;
			finderArgs = new Object[] { dishName };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DISHNAME;
			finderArgs = new Object[] { dishName, start, end, orderByComparator };
		}

		List<Dish> list = (List<Dish>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Dish dish : list) {
				if (!Validator.equals(dishName, dish.getDishName())) {
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

			query.append(_SQL_SELECT_DISH_WHERE);

			if (dishName == null) {
				query.append(_FINDER_COLUMN_DISHNAME_DISHNAME_1);
			}
			else {
				if (dishName.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_DISHNAME_DISHNAME_3);
				}
				else {
					query.append(_FINDER_COLUMN_DISHNAME_DISHNAME_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(DishModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (dishName != null) {
					qPos.add(dishName);
				}

				list = (List<Dish>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first dish in the ordered set where dishName = &#63;.
	 *
	 * @param dishName the dish name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dish
	 * @throws irestads.NoSuchDishException if a matching dish could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Dish findByDishName_First(String dishName,
		OrderByComparator orderByComparator)
		throws NoSuchDishException, SystemException {
		Dish dish = fetchByDishName_First(dishName, orderByComparator);

		if (dish != null) {
			return dish;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("dishName=");
		msg.append(dishName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDishException(msg.toString());
	}

	/**
	 * Returns the first dish in the ordered set where dishName = &#63;.
	 *
	 * @param dishName the dish name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dish, or <code>null</code> if a matching dish could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Dish fetchByDishName_First(String dishName,
		OrderByComparator orderByComparator) throws SystemException {
		List<Dish> list = findByDishName(dishName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dish in the ordered set where dishName = &#63;.
	 *
	 * @param dishName the dish name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dish
	 * @throws irestads.NoSuchDishException if a matching dish could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Dish findByDishName_Last(String dishName,
		OrderByComparator orderByComparator)
		throws NoSuchDishException, SystemException {
		Dish dish = fetchByDishName_Last(dishName, orderByComparator);

		if (dish != null) {
			return dish;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("dishName=");
		msg.append(dishName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDishException(msg.toString());
	}

	/**
	 * Returns the last dish in the ordered set where dishName = &#63;.
	 *
	 * @param dishName the dish name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dish, or <code>null</code> if a matching dish could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Dish fetchByDishName_Last(String dishName,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByDishName(dishName);

		List<Dish> list = findByDishName(dishName, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dishs before and after the current dish in the ordered set where dishName = &#63;.
	 *
	 * @param dishId the primary key of the current dish
	 * @param dishName the dish name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dish
	 * @throws irestads.NoSuchDishException if a dish with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Dish[] findByDishName_PrevAndNext(long dishId, String dishName,
		OrderByComparator orderByComparator)
		throws NoSuchDishException, SystemException {
		Dish dish = findByPrimaryKey(dishId);

		Session session = null;

		try {
			session = openSession();

			Dish[] array = new DishImpl[3];

			array[0] = getByDishName_PrevAndNext(session, dish, dishName,
					orderByComparator, true);

			array[1] = dish;

			array[2] = getByDishName_PrevAndNext(session, dish, dishName,
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

	protected Dish getByDishName_PrevAndNext(Session session, Dish dish,
		String dishName, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DISH_WHERE);

		if (dishName == null) {
			query.append(_FINDER_COLUMN_DISHNAME_DISHNAME_1);
		}
		else {
			if (dishName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_DISHNAME_DISHNAME_3);
			}
			else {
				query.append(_FINDER_COLUMN_DISHNAME_DISHNAME_2);
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
			query.append(DishModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (dishName != null) {
			qPos.add(dishName);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(dish);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Dish> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the dishs.
	 *
	 * @return the dishs
	 * @throws SystemException if a system exception occurred
	 */
	public List<Dish> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dishs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of dishs
	 * @param end the upper bound of the range of dishs (not inclusive)
	 * @return the range of dishs
	 * @throws SystemException if a system exception occurred
	 */
	public List<Dish> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the dishs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of dishs
	 * @param end the upper bound of the range of dishs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dishs
	 * @throws SystemException if a system exception occurred
	 */
	public List<Dish> findAll(int start, int end,
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

		List<Dish> list = (List<Dish>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_DISH);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DISH.concat(DishModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Dish>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Dish>)QueryUtil.list(q, getDialect(), start,
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
	 * Removes all the dishs where dishName = &#63; from the database.
	 *
	 * @param dishName the dish name
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByDishName(String dishName) throws SystemException {
		for (Dish dish : findByDishName(dishName)) {
			remove(dish);
		}
	}

	/**
	 * Removes all the dishs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Dish dish : findAll()) {
			remove(dish);
		}
	}

	/**
	 * Returns the number of dishs where dishName = &#63;.
	 *
	 * @param dishName the dish name
	 * @return the number of matching dishs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByDishName(String dishName) throws SystemException {
		Object[] finderArgs = new Object[] { dishName };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_DISHNAME,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DISH_WHERE);

			if (dishName == null) {
				query.append(_FINDER_COLUMN_DISHNAME_DISHNAME_1);
			}
			else {
				if (dishName.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_DISHNAME_DISHNAME_3);
				}
				else {
					query.append(_FINDER_COLUMN_DISHNAME_DISHNAME_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (dishName != null) {
					qPos.add(dishName);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_DISHNAME,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of dishs.
	 *
	 * @return the number of dishs
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_DISH);

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
	 * Initializes the dish persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.irestads.model.Dish")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Dish>> listenersList = new ArrayList<ModelListener<Dish>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Dish>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(DishImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = CategoryPersistence.class)
	protected CategoryPersistence categoryPersistence;
	@BeanReference(type = DishPersistence.class)
	protected DishPersistence dishPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_DISH = "SELECT dish FROM Dish dish";
	private static final String _SQL_SELECT_DISH_WHERE = "SELECT dish FROM Dish dish WHERE ";
	private static final String _SQL_COUNT_DISH = "SELECT COUNT(dish) FROM Dish dish";
	private static final String _SQL_COUNT_DISH_WHERE = "SELECT COUNT(dish) FROM Dish dish WHERE ";
	private static final String _FINDER_COLUMN_DISHNAME_DISHNAME_1 = "dish.dishName IS NULL";
	private static final String _FINDER_COLUMN_DISHNAME_DISHNAME_2 = "dish.dishName = ?";
	private static final String _FINDER_COLUMN_DISHNAME_DISHNAME_3 = "(dish.dishName IS NULL OR dish.dishName = ?)";
	private static final String _ORDER_BY_ENTITY_ALIAS = "dish.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Dish exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Dish exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(DishPersistenceImpl.class);
	private static Dish _nullDish = new DishImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Dish> toCacheModel() {
				return _nullDishCacheModel;
			}
		};

	private static CacheModel<Dish> _nullDishCacheModel = new CacheModel<Dish>() {
			public Dish toEntityModel() {
				return _nullDish;
			}
		};
}