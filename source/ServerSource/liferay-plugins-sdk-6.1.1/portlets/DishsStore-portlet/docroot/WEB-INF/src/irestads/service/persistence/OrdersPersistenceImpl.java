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

import irestads.NoSuchOrdersException;

import irestads.model.Orders;

import irestads.model.impl.OrdersImpl;
import irestads.model.impl.OrdersModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the orders service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Be
 * @see OrdersPersistence
 * @see OrdersUtil
 * @generated
 */
public class OrdersPersistenceImpl extends BasePersistenceImpl<Orders>
	implements OrdersPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link OrdersUtil} to access the orders persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = OrdersImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ISPAYMENT =
		new FinderPath(OrdersModelImpl.ENTITY_CACHE_ENABLED,
			OrdersModelImpl.FINDER_CACHE_ENABLED, OrdersImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByIsPayMent",
			new String[] {
				Boolean.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISPAYMENT =
		new FinderPath(OrdersModelImpl.ENTITY_CACHE_ENABLED,
			OrdersModelImpl.FINDER_CACHE_ENABLED, OrdersImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByIsPayMent",
			new String[] { Boolean.class.getName() },
			OrdersModelImpl.ISPAYMENT_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ISPAYMENT = new FinderPath(OrdersModelImpl.ENTITY_CACHE_ENABLED,
			OrdersModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByIsPayMent",
			new String[] { Boolean.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(OrdersModelImpl.ENTITY_CACHE_ENABLED,
			OrdersModelImpl.FINDER_CACHE_ENABLED, OrdersImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(OrdersModelImpl.ENTITY_CACHE_ENABLED,
			OrdersModelImpl.FINDER_CACHE_ENABLED, OrdersImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(OrdersModelImpl.ENTITY_CACHE_ENABLED,
			OrdersModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the orders in the entity cache if it is enabled.
	 *
	 * @param orders the orders
	 */
	public void cacheResult(Orders orders) {
		EntityCacheUtil.putResult(OrdersModelImpl.ENTITY_CACHE_ENABLED,
			OrdersImpl.class, orders.getPrimaryKey(), orders);

		orders.resetOriginalValues();
	}

	/**
	 * Caches the orderses in the entity cache if it is enabled.
	 *
	 * @param orderses the orderses
	 */
	public void cacheResult(List<Orders> orderses) {
		for (Orders orders : orderses) {
			if (EntityCacheUtil.getResult(
						OrdersModelImpl.ENTITY_CACHE_ENABLED, OrdersImpl.class,
						orders.getPrimaryKey()) == null) {
				cacheResult(orders);
			}
			else {
				orders.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all orderses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(OrdersImpl.class.getName());
		}

		EntityCacheUtil.clearCache(OrdersImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the orders.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Orders orders) {
		EntityCacheUtil.removeResult(OrdersModelImpl.ENTITY_CACHE_ENABLED,
			OrdersImpl.class, orders.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Orders> orderses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Orders orders : orderses) {
			EntityCacheUtil.removeResult(OrdersModelImpl.ENTITY_CACHE_ENABLED,
				OrdersImpl.class, orders.getPrimaryKey());
		}
	}

	/**
	 * Creates a new orders with the primary key. Does not add the orders to the database.
	 *
	 * @param orderId the primary key for the new orders
	 * @return the new orders
	 */
	public Orders create(long orderId) {
		Orders orders = new OrdersImpl();

		orders.setNew(true);
		orders.setPrimaryKey(orderId);

		return orders;
	}

	/**
	 * Removes the orders with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param orderId the primary key of the orders
	 * @return the orders that was removed
	 * @throws irestads.NoSuchOrdersException if a orders with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Orders remove(long orderId)
		throws NoSuchOrdersException, SystemException {
		return remove(Long.valueOf(orderId));
	}

	/**
	 * Removes the orders with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the orders
	 * @return the orders that was removed
	 * @throws irestads.NoSuchOrdersException if a orders with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Orders remove(Serializable primaryKey)
		throws NoSuchOrdersException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Orders orders = (Orders)session.get(OrdersImpl.class, primaryKey);

			if (orders == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchOrdersException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(orders);
		}
		catch (NoSuchOrdersException nsee) {
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
	protected Orders removeImpl(Orders orders) throws SystemException {
		orders = toUnwrappedModel(orders);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, orders);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(orders);

		return orders;
	}

	@Override
	public Orders updateImpl(irestads.model.Orders orders, boolean merge)
		throws SystemException {
		orders = toUnwrappedModel(orders);

		boolean isNew = orders.isNew();

		OrdersModelImpl ordersModelImpl = (OrdersModelImpl)orders;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, orders, merge);

			orders.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !OrdersModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((ordersModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISPAYMENT.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Boolean.valueOf(ordersModelImpl.getOriginalIsPayMent())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ISPAYMENT,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISPAYMENT,
					args);

				args = new Object[] {
						Boolean.valueOf(ordersModelImpl.getIsPayMent())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ISPAYMENT,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISPAYMENT,
					args);
			}
		}

		EntityCacheUtil.putResult(OrdersModelImpl.ENTITY_CACHE_ENABLED,
			OrdersImpl.class, orders.getPrimaryKey(), orders);

		return orders;
	}

	protected Orders toUnwrappedModel(Orders orders) {
		if (orders instanceof OrdersImpl) {
			return orders;
		}

		OrdersImpl ordersImpl = new OrdersImpl();

		ordersImpl.setNew(orders.isNew());
		ordersImpl.setPrimaryKey(orders.getPrimaryKey());

		ordersImpl.setOrderId(orders.getOrderId());
		ordersImpl.setCompanyId(orders.getCompanyId());
		ordersImpl.setUserId(orders.getUserId());
		ordersImpl.setUserName(orders.getUserName());
		ordersImpl.setCreateDate(orders.getCreateDate());
		ordersImpl.setModifiedDate(orders.getModifiedDate());
		ordersImpl.setCharge(orders.getCharge());
		ordersImpl.setCreatedDate(orders.getCreatedDate());
		ordersImpl.setIsPayMent(orders.isIsPayMent());
		ordersImpl.setNumOfDinner(orders.getNumOfDinner());
		ordersImpl.setDishTableId(orders.getDishTableId());

		return ordersImpl;
	}

	/**
	 * Returns the orders with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the orders
	 * @return the orders
	 * @throws com.liferay.portal.NoSuchModelException if a orders with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Orders findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the orders with the primary key or throws a {@link irestads.NoSuchOrdersException} if it could not be found.
	 *
	 * @param orderId the primary key of the orders
	 * @return the orders
	 * @throws irestads.NoSuchOrdersException if a orders with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Orders findByPrimaryKey(long orderId)
		throws NoSuchOrdersException, SystemException {
		Orders orders = fetchByPrimaryKey(orderId);

		if (orders == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + orderId);
			}

			throw new NoSuchOrdersException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				orderId);
		}

		return orders;
	}

	/**
	 * Returns the orders with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the orders
	 * @return the orders, or <code>null</code> if a orders with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Orders fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the orders with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param orderId the primary key of the orders
	 * @return the orders, or <code>null</code> if a orders with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Orders fetchByPrimaryKey(long orderId) throws SystemException {
		Orders orders = (Orders)EntityCacheUtil.getResult(OrdersModelImpl.ENTITY_CACHE_ENABLED,
				OrdersImpl.class, orderId);

		if (orders == _nullOrders) {
			return null;
		}

		if (orders == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				orders = (Orders)session.get(OrdersImpl.class,
						Long.valueOf(orderId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (orders != null) {
					cacheResult(orders);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(OrdersModelImpl.ENTITY_CACHE_ENABLED,
						OrdersImpl.class, orderId, _nullOrders);
				}

				closeSession(session);
			}
		}

		return orders;
	}

	/**
	 * Returns all the orderses where isPayMent = &#63;.
	 *
	 * @param isPayMent the is pay ment
	 * @return the matching orderses
	 * @throws SystemException if a system exception occurred
	 */
	public List<Orders> findByIsPayMent(boolean isPayMent)
		throws SystemException {
		return findByIsPayMent(isPayMent, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the orderses where isPayMent = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param isPayMent the is pay ment
	 * @param start the lower bound of the range of orderses
	 * @param end the upper bound of the range of orderses (not inclusive)
	 * @return the range of matching orderses
	 * @throws SystemException if a system exception occurred
	 */
	public List<Orders> findByIsPayMent(boolean isPayMent, int start, int end)
		throws SystemException {
		return findByIsPayMent(isPayMent, start, end, null);
	}

	/**
	 * Returns an ordered range of all the orderses where isPayMent = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param isPayMent the is pay ment
	 * @param start the lower bound of the range of orderses
	 * @param end the upper bound of the range of orderses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching orderses
	 * @throws SystemException if a system exception occurred
	 */
	public List<Orders> findByIsPayMent(boolean isPayMent, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISPAYMENT;
			finderArgs = new Object[] { isPayMent };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ISPAYMENT;
			finderArgs = new Object[] { isPayMent, start, end, orderByComparator };
		}

		List<Orders> list = (List<Orders>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Orders orders : list) {
				if ((isPayMent != orders.getIsPayMent())) {
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
				query = new StringBundler(2);
			}

			query.append(_SQL_SELECT_ORDERS_WHERE);

			query.append(_FINDER_COLUMN_ISPAYMENT_ISPAYMENT_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(isPayMent);

				list = (List<Orders>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first orders in the ordered set where isPayMent = &#63;.
	 *
	 * @param isPayMent the is pay ment
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching orders
	 * @throws irestads.NoSuchOrdersException if a matching orders could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Orders findByIsPayMent_First(boolean isPayMent,
		OrderByComparator orderByComparator)
		throws NoSuchOrdersException, SystemException {
		Orders orders = fetchByIsPayMent_First(isPayMent, orderByComparator);

		if (orders != null) {
			return orders;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("isPayMent=");
		msg.append(isPayMent);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOrdersException(msg.toString());
	}

	/**
	 * Returns the first orders in the ordered set where isPayMent = &#63;.
	 *
	 * @param isPayMent the is pay ment
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching orders, or <code>null</code> if a matching orders could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Orders fetchByIsPayMent_First(boolean isPayMent,
		OrderByComparator orderByComparator) throws SystemException {
		List<Orders> list = findByIsPayMent(isPayMent, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last orders in the ordered set where isPayMent = &#63;.
	 *
	 * @param isPayMent the is pay ment
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching orders
	 * @throws irestads.NoSuchOrdersException if a matching orders could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Orders findByIsPayMent_Last(boolean isPayMent,
		OrderByComparator orderByComparator)
		throws NoSuchOrdersException, SystemException {
		Orders orders = fetchByIsPayMent_Last(isPayMent, orderByComparator);

		if (orders != null) {
			return orders;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("isPayMent=");
		msg.append(isPayMent);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOrdersException(msg.toString());
	}

	/**
	 * Returns the last orders in the ordered set where isPayMent = &#63;.
	 *
	 * @param isPayMent the is pay ment
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching orders, or <code>null</code> if a matching orders could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Orders fetchByIsPayMent_Last(boolean isPayMent,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByIsPayMent(isPayMent);

		List<Orders> list = findByIsPayMent(isPayMent, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the orderses before and after the current orders in the ordered set where isPayMent = &#63;.
	 *
	 * @param orderId the primary key of the current orders
	 * @param isPayMent the is pay ment
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next orders
	 * @throws irestads.NoSuchOrdersException if a orders with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Orders[] findByIsPayMent_PrevAndNext(long orderId,
		boolean isPayMent, OrderByComparator orderByComparator)
		throws NoSuchOrdersException, SystemException {
		Orders orders = findByPrimaryKey(orderId);

		Session session = null;

		try {
			session = openSession();

			Orders[] array = new OrdersImpl[3];

			array[0] = getByIsPayMent_PrevAndNext(session, orders, isPayMent,
					orderByComparator, true);

			array[1] = orders;

			array[2] = getByIsPayMent_PrevAndNext(session, orders, isPayMent,
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

	protected Orders getByIsPayMent_PrevAndNext(Session session, Orders orders,
		boolean isPayMent, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ORDERS_WHERE);

		query.append(_FINDER_COLUMN_ISPAYMENT_ISPAYMENT_2);

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

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(isPayMent);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(orders);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Orders> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the orderses.
	 *
	 * @return the orderses
	 * @throws SystemException if a system exception occurred
	 */
	public List<Orders> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the orderses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of orderses
	 * @param end the upper bound of the range of orderses (not inclusive)
	 * @return the range of orderses
	 * @throws SystemException if a system exception occurred
	 */
	public List<Orders> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the orderses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of orderses
	 * @param end the upper bound of the range of orderses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of orderses
	 * @throws SystemException if a system exception occurred
	 */
	public List<Orders> findAll(int start, int end,
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

		List<Orders> list = (List<Orders>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ORDERS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ORDERS;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Orders>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Orders>)QueryUtil.list(q, getDialect(), start,
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
	 * Removes all the orderses where isPayMent = &#63; from the database.
	 *
	 * @param isPayMent the is pay ment
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByIsPayMent(boolean isPayMent) throws SystemException {
		for (Orders orders : findByIsPayMent(isPayMent)) {
			remove(orders);
		}
	}

	/**
	 * Removes all the orderses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Orders orders : findAll()) {
			remove(orders);
		}
	}

	/**
	 * Returns the number of orderses where isPayMent = &#63;.
	 *
	 * @param isPayMent the is pay ment
	 * @return the number of matching orderses
	 * @throws SystemException if a system exception occurred
	 */
	public int countByIsPayMent(boolean isPayMent) throws SystemException {
		Object[] finderArgs = new Object[] { isPayMent };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ISPAYMENT,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ORDERS_WHERE);

			query.append(_FINDER_COLUMN_ISPAYMENT_ISPAYMENT_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(isPayMent);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ISPAYMENT,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of orderses.
	 *
	 * @return the number of orderses
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_ORDERS);

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
	 * Returns all the order lines associated with the orders.
	 *
	 * @param pk the primary key of the orders
	 * @return the order lines associated with the orders
	 * @throws SystemException if a system exception occurred
	 */
	public List<irestads.model.OrderLine> getOrderLines(long pk)
		throws SystemException {
		return getOrderLines(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	/**
	 * Returns a range of all the order lines associated with the orders.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param pk the primary key of the orders
	 * @param start the lower bound of the range of orderses
	 * @param end the upper bound of the range of orderses (not inclusive)
	 * @return the range of order lines associated with the orders
	 * @throws SystemException if a system exception occurred
	 */
	public List<irestads.model.OrderLine> getOrderLines(long pk, int start,
		int end) throws SystemException {
		return getOrderLines(pk, start, end, null);
	}

	public static final FinderPath FINDER_PATH_GET_ORDERLINES = new FinderPath(irestads.model.impl.OrderLineModelImpl.ENTITY_CACHE_ENABLED,
			irestads.model.impl.OrderLineModelImpl.FINDER_CACHE_ENABLED,
			irestads.model.impl.OrderLineImpl.class,
			irestads.service.persistence.OrderLinePersistenceImpl.FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"getOrderLines",
			new String[] {
				Long.class.getName(), "java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});

	static {
		FINDER_PATH_GET_ORDERLINES.setCacheKeyGeneratorCacheName(null);
	}

	/**
	 * Returns an ordered range of all the order lines associated with the orders.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param pk the primary key of the orders
	 * @param start the lower bound of the range of orderses
	 * @param end the upper bound of the range of orderses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of order lines associated with the orders
	 * @throws SystemException if a system exception occurred
	 */
	public List<irestads.model.OrderLine> getOrderLines(long pk, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] { pk, start, end, orderByComparator };

		List<irestads.model.OrderLine> list = (List<irestads.model.OrderLine>)FinderCacheUtil.getResult(FINDER_PATH_GET_ORDERLINES,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				String sql = null;

				if (orderByComparator != null) {
					sql = _SQL_GETORDERLINES.concat(ORDER_BY_CLAUSE)
											.concat(orderByComparator.getOrderBy());
				}
				else {
					sql = _SQL_GETORDERLINES.concat(irestads.model.impl.OrderLineModelImpl.ORDER_BY_SQL);
				}

				SQLQuery q = session.createSQLQuery(sql);

				q.addEntity("dishsstore_OrderLine",
					irestads.model.impl.OrderLineImpl.class);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(pk);

				list = (List<irestads.model.OrderLine>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_GET_ORDERLINES,
						finderArgs);
				}
				else {
					orderLinePersistence.cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_GET_ORDERLINES,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	public static final FinderPath FINDER_PATH_GET_ORDERLINES_SIZE = new FinderPath(irestads.model.impl.OrderLineModelImpl.ENTITY_CACHE_ENABLED,
			irestads.model.impl.OrderLineModelImpl.FINDER_CACHE_ENABLED,
			irestads.model.impl.OrderLineImpl.class,
			irestads.service.persistence.OrderLinePersistenceImpl.FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"getOrderLinesSize", new String[] { Long.class.getName() });

	static {
		FINDER_PATH_GET_ORDERLINES_SIZE.setCacheKeyGeneratorCacheName(null);
	}

	/**
	 * Returns the number of order lines associated with the orders.
	 *
	 * @param pk the primary key of the orders
	 * @return the number of order lines associated with the orders
	 * @throws SystemException if a system exception occurred
	 */
	public int getOrderLinesSize(long pk) throws SystemException {
		Object[] finderArgs = new Object[] { pk };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_GET_ORDERLINES_SIZE,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				SQLQuery q = session.createSQLQuery(_SQL_GETORDERLINESSIZE);

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

				FinderCacheUtil.putResult(FINDER_PATH_GET_ORDERLINES_SIZE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public static final FinderPath FINDER_PATH_CONTAINS_ORDERLINE = new FinderPath(irestads.model.impl.OrderLineModelImpl.ENTITY_CACHE_ENABLED,
			irestads.model.impl.OrderLineModelImpl.FINDER_CACHE_ENABLED,
			irestads.model.impl.OrderLineImpl.class,
			irestads.service.persistence.OrderLinePersistenceImpl.FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"containsOrderLine",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns <code>true</code> if the order line is associated with the orders.
	 *
	 * @param pk the primary key of the orders
	 * @param orderLinePK the primary key of the order line
	 * @return <code>true</code> if the order line is associated with the orders; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	public boolean containsOrderLine(long pk, long orderLinePK)
		throws SystemException {
		Object[] finderArgs = new Object[] { pk, orderLinePK };

		Boolean value = (Boolean)FinderCacheUtil.getResult(FINDER_PATH_CONTAINS_ORDERLINE,
				finderArgs, this);

		if (value == null) {
			try {
				value = Boolean.valueOf(containsOrderLine.contains(pk,
							orderLinePK));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (value == null) {
					value = Boolean.FALSE;
				}

				FinderCacheUtil.putResult(FINDER_PATH_CONTAINS_ORDERLINE,
					finderArgs, value);
			}
		}

		return value.booleanValue();
	}

	/**
	 * Returns <code>true</code> if the orders has any order lines associated with it.
	 *
	 * @param pk the primary key of the orders to check for associations with order lines
	 * @return <code>true</code> if the orders has any order lines associated with it; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	public boolean containsOrderLines(long pk) throws SystemException {
		if (getOrderLinesSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Initializes the orders persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.irestads.model.Orders")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Orders>> listenersList = new ArrayList<ModelListener<Orders>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Orders>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}

		containsOrderLine = new ContainsOrderLine();
	}

	public void destroy() {
		EntityCacheUtil.removeCache(OrdersImpl.class.getName());
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
	protected ContainsOrderLine containsOrderLine;

	protected class ContainsOrderLine {
		protected ContainsOrderLine() {
			_mappingSqlQuery = MappingSqlQueryFactoryUtil.getMappingSqlQuery(getDataSource(),
					_SQL_CONTAINSORDERLINE,
					new int[] { java.sql.Types.BIGINT, java.sql.Types.BIGINT },
					RowMapper.COUNT);
		}

		protected boolean contains(long orderId, long orderLineId) {
			List<Integer> results = _mappingSqlQuery.execute(new Object[] {
						new Long(orderId), new Long(orderLineId)
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

	private static final String _SQL_SELECT_ORDERS = "SELECT orders FROM Orders orders";
	private static final String _SQL_SELECT_ORDERS_WHERE = "SELECT orders FROM Orders orders WHERE ";
	private static final String _SQL_COUNT_ORDERS = "SELECT COUNT(orders) FROM Orders orders";
	private static final String _SQL_COUNT_ORDERS_WHERE = "SELECT COUNT(orders) FROM Orders orders WHERE ";
	private static final String _SQL_GETORDERLINES = "SELECT {dishsstore_OrderLine.*} FROM dishsstore_OrderLine INNER JOIN dishsstore_Orders ON (dishsstore_Orders.orderId = dishsstore_OrderLine.orderId) WHERE (dishsstore_Orders.orderId = ?)";
	private static final String _SQL_GETORDERLINESSIZE = "SELECT COUNT(*) AS COUNT_VALUE FROM dishsstore_OrderLine WHERE orderId = ?";
	private static final String _SQL_CONTAINSORDERLINE = "SELECT COUNT(*) AS COUNT_VALUE FROM dishsstore_OrderLine WHERE orderId = ? AND orderLineId = ?";
	private static final String _FINDER_COLUMN_ISPAYMENT_ISPAYMENT_2 = "orders.isPayMent = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "orders.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Orders exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Orders exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(OrdersPersistenceImpl.class);
	private static Orders _nullOrders = new OrdersImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Orders> toCacheModel() {
				return _nullOrdersCacheModel;
			}
		};

	private static CacheModel<Orders> _nullOrdersCacheModel = new CacheModel<Orders>() {
			public Orders toEntityModel() {
				return _nullOrders;
			}
		};
}