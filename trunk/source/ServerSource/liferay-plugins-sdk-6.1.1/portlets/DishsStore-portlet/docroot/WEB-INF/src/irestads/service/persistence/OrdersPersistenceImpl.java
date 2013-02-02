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
	public static final FinderPath FINDER_PATH_FETCH_BY_CURENTORDER = new FinderPath(OrdersModelImpl.ENTITY_CACHE_ENABLED,
			OrdersModelImpl.FINDER_CACHE_ENABLED, OrdersImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchBycurentOrder",
			new String[] { Boolean.class.getName(), String.class.getName() },
			OrdersModelImpl.ISPAYMENT_COLUMN_BITMASK |
			OrdersModelImpl.DISHTABLEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CURENTORDER = new FinderPath(OrdersModelImpl.ENTITY_CACHE_ENABLED,
			OrdersModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBycurentOrder",
			new String[] { Boolean.class.getName(), String.class.getName() });
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

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CURENTORDER,
			new Object[] {
				Boolean.valueOf(orders.getIsPayMent()),
				
			orders.getDishTableId()
			}, orders);

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

		clearUniqueFindersCache(orders);
	}

	@Override
	public void clearCache(List<Orders> orderses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Orders orders : orderses) {
			EntityCacheUtil.removeResult(OrdersModelImpl.ENTITY_CACHE_ENABLED,
				OrdersImpl.class, orders.getPrimaryKey());

			clearUniqueFindersCache(orders);
		}
	}

	protected void clearUniqueFindersCache(Orders orders) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CURENTORDER,
			new Object[] {
				Boolean.valueOf(orders.getIsPayMent()),
				
			orders.getDishTableId()
			});
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

		EntityCacheUtil.putResult(OrdersModelImpl.ENTITY_CACHE_ENABLED,
			OrdersImpl.class, orders.getPrimaryKey(), orders);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CURENTORDER,
				new Object[] {
					Boolean.valueOf(orders.getIsPayMent()),
					
				orders.getDishTableId()
				}, orders);
		}
		else {
			if ((ordersModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_CURENTORDER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Boolean.valueOf(ordersModelImpl.getOriginalIsPayMent()),
						
						ordersModelImpl.getOriginalDishTableId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CURENTORDER,
					args);

				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CURENTORDER,
					args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CURENTORDER,
					new Object[] {
						Boolean.valueOf(orders.getIsPayMent()),
						
					orders.getDishTableId()
					}, orders);
			}
		}

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
	 * Returns the orders where isPayMent = &#63; and dishTableId = &#63; or throws a {@link irestads.NoSuchOrdersException} if it could not be found.
	 *
	 * @param isPayMent the is pay ment
	 * @param dishTableId the dish table ID
	 * @return the matching orders
	 * @throws irestads.NoSuchOrdersException if a matching orders could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Orders findBycurentOrder(boolean isPayMent, String dishTableId)
		throws NoSuchOrdersException, SystemException {
		Orders orders = fetchBycurentOrder(isPayMent, dishTableId);

		if (orders == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("isPayMent=");
			msg.append(isPayMent);

			msg.append(", dishTableId=");
			msg.append(dishTableId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchOrdersException(msg.toString());
		}

		return orders;
	}

	/**
	 * Returns the orders where isPayMent = &#63; and dishTableId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param isPayMent the is pay ment
	 * @param dishTableId the dish table ID
	 * @return the matching orders, or <code>null</code> if a matching orders could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Orders fetchBycurentOrder(boolean isPayMent, String dishTableId)
		throws SystemException {
		return fetchBycurentOrder(isPayMent, dishTableId, true);
	}

	/**
	 * Returns the orders where isPayMent = &#63; and dishTableId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param isPayMent the is pay ment
	 * @param dishTableId the dish table ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching orders, or <code>null</code> if a matching orders could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Orders fetchBycurentOrder(boolean isPayMent, String dishTableId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { isPayMent, dishTableId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_CURENTORDER,
					finderArgs, this);
		}

		if (result instanceof Orders) {
			Orders orders = (Orders)result;

			if ((isPayMent != orders.getIsPayMent()) ||
					!Validator.equals(dishTableId, orders.getDishTableId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_ORDERS_WHERE);

			query.append(_FINDER_COLUMN_CURENTORDER_ISPAYMENT_2);

			if (dishTableId == null) {
				query.append(_FINDER_COLUMN_CURENTORDER_DISHTABLEID_1);
			}
			else {
				if (dishTableId.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_CURENTORDER_DISHTABLEID_3);
				}
				else {
					query.append(_FINDER_COLUMN_CURENTORDER_DISHTABLEID_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(isPayMent);

				if (dishTableId != null) {
					qPos.add(dishTableId);
				}

				List<Orders> list = q.list();

				result = list;

				Orders orders = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CURENTORDER,
						finderArgs, list);
				}
				else {
					orders = list.get(0);

					cacheResult(orders);

					if ((orders.getIsPayMent() != isPayMent) ||
							(orders.getDishTableId() == null) ||
							!orders.getDishTableId().equals(dishTableId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CURENTORDER,
							finderArgs, orders);
					}
				}

				return orders;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CURENTORDER,
						finderArgs);
				}

				closeSession(session);
			}
		}
		else {
			if (result instanceof List<?>) {
				return null;
			}
			else {
				return (Orders)result;
			}
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
	 * Removes the orders where isPayMent = &#63; and dishTableId = &#63; from the database.
	 *
	 * @param isPayMent the is pay ment
	 * @param dishTableId the dish table ID
	 * @return the orders that was removed
	 * @throws SystemException if a system exception occurred
	 */
	public Orders removeBycurentOrder(boolean isPayMent, String dishTableId)
		throws NoSuchOrdersException, SystemException {
		Orders orders = findBycurentOrder(isPayMent, dishTableId);

		return remove(orders);
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
	 * Returns the number of orderses where isPayMent = &#63; and dishTableId = &#63;.
	 *
	 * @param isPayMent the is pay ment
	 * @param dishTableId the dish table ID
	 * @return the number of matching orderses
	 * @throws SystemException if a system exception occurred
	 */
	public int countBycurentOrder(boolean isPayMent, String dishTableId)
		throws SystemException {
		Object[] finderArgs = new Object[] { isPayMent, dishTableId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CURENTORDER,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ORDERS_WHERE);

			query.append(_FINDER_COLUMN_CURENTORDER_ISPAYMENT_2);

			if (dishTableId == null) {
				query.append(_FINDER_COLUMN_CURENTORDER_DISHTABLEID_1);
			}
			else {
				if (dishTableId.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_CURENTORDER_DISHTABLEID_3);
				}
				else {
					query.append(_FINDER_COLUMN_CURENTORDER_DISHTABLEID_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(isPayMent);

				if (dishTableId != null) {
					qPos.add(dishTableId);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CURENTORDER,
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
	private static final String _FINDER_COLUMN_CURENTORDER_ISPAYMENT_2 = "orders.isPayMent = ? AND ";
	private static final String _FINDER_COLUMN_CURENTORDER_DISHTABLEID_1 = "orders.dishTableId IS NULL";
	private static final String _FINDER_COLUMN_CURENTORDER_DISHTABLEID_2 = "orders.dishTableId = ?";
	private static final String _FINDER_COLUMN_CURENTORDER_DISHTABLEID_3 = "(orders.dishTableId IS NULL OR orders.dishTableId = ?)";
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