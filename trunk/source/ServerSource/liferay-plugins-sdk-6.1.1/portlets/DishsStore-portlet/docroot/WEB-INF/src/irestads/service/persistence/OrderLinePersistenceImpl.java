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

import irestads.NoSuchOrderLineException;

import irestads.model.OrderLine;

import irestads.model.impl.OrderLineImpl;
import irestads.model.impl.OrderLineModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the order line service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Be
 * @see OrderLinePersistence
 * @see OrderLineUtil
 * @generated
 */
public class OrderLinePersistenceImpl extends BasePersistenceImpl<OrderLine>
	implements OrderLinePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link OrderLineUtil} to access the order line persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = OrderLineImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUSDISH =
		new FinderPath(OrderLineModelImpl.ENTITY_CACHE_ENABLED,
			OrderLineModelImpl.FINDER_CACHE_ENABLED, OrderLineImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStatusDish",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUSDISH =
		new FinderPath(OrderLineModelImpl.ENTITY_CACHE_ENABLED,
			OrderLineModelImpl.FINDER_CACHE_ENABLED, OrderLineImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStatusDish",
			new String[] { Integer.class.getName() },
			OrderLineModelImpl.STATUSDISH_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STATUSDISH = new FinderPath(OrderLineModelImpl.ENTITY_CACHE_ENABLED,
			OrderLineModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStatusDish",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ORDERID = new FinderPath(OrderLineModelImpl.ENTITY_CACHE_ENABLED,
			OrderLineModelImpl.FINDER_CACHE_ENABLED, OrderLineImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByOrderId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORDERID =
		new FinderPath(OrderLineModelImpl.ENTITY_CACHE_ENABLED,
			OrderLineModelImpl.FINDER_CACHE_ENABLED, OrderLineImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByOrderId",
			new String[] { Long.class.getName() },
			OrderLineModelImpl.ORDERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ORDERID = new FinderPath(OrderLineModelImpl.ENTITY_CACHE_ENABLED,
			OrderLineModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByOrderId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(OrderLineModelImpl.ENTITY_CACHE_ENABLED,
			OrderLineModelImpl.FINDER_CACHE_ENABLED, OrderLineImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(OrderLineModelImpl.ENTITY_CACHE_ENABLED,
			OrderLineModelImpl.FINDER_CACHE_ENABLED, OrderLineImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(OrderLineModelImpl.ENTITY_CACHE_ENABLED,
			OrderLineModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the order line in the entity cache if it is enabled.
	 *
	 * @param orderLine the order line
	 */
	public void cacheResult(OrderLine orderLine) {
		EntityCacheUtil.putResult(OrderLineModelImpl.ENTITY_CACHE_ENABLED,
			OrderLineImpl.class, orderLine.getPrimaryKey(), orderLine);

		orderLine.resetOriginalValues();
	}

	/**
	 * Caches the order lines in the entity cache if it is enabled.
	 *
	 * @param orderLines the order lines
	 */
	public void cacheResult(List<OrderLine> orderLines) {
		for (OrderLine orderLine : orderLines) {
			if (EntityCacheUtil.getResult(
						OrderLineModelImpl.ENTITY_CACHE_ENABLED,
						OrderLineImpl.class, orderLine.getPrimaryKey()) == null) {
				cacheResult(orderLine);
			}
			else {
				orderLine.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all order lines.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(OrderLineImpl.class.getName());
		}

		EntityCacheUtil.clearCache(OrderLineImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the order line.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(OrderLine orderLine) {
		EntityCacheUtil.removeResult(OrderLineModelImpl.ENTITY_CACHE_ENABLED,
			OrderLineImpl.class, orderLine.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<OrderLine> orderLines) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (OrderLine orderLine : orderLines) {
			EntityCacheUtil.removeResult(OrderLineModelImpl.ENTITY_CACHE_ENABLED,
				OrderLineImpl.class, orderLine.getPrimaryKey());
		}
	}

	/**
	 * Creates a new order line with the primary key. Does not add the order line to the database.
	 *
	 * @param orderLineId the primary key for the new order line
	 * @return the new order line
	 */
	public OrderLine create(long orderLineId) {
		OrderLine orderLine = new OrderLineImpl();

		orderLine.setNew(true);
		orderLine.setPrimaryKey(orderLineId);

		return orderLine;
	}

	/**
	 * Removes the order line with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param orderLineId the primary key of the order line
	 * @return the order line that was removed
	 * @throws irestads.NoSuchOrderLineException if a order line with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public OrderLine remove(long orderLineId)
		throws NoSuchOrderLineException, SystemException {
		return remove(Long.valueOf(orderLineId));
	}

	/**
	 * Removes the order line with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the order line
	 * @return the order line that was removed
	 * @throws irestads.NoSuchOrderLineException if a order line with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrderLine remove(Serializable primaryKey)
		throws NoSuchOrderLineException, SystemException {
		Session session = null;

		try {
			session = openSession();

			OrderLine orderLine = (OrderLine)session.get(OrderLineImpl.class,
					primaryKey);

			if (orderLine == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchOrderLineException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(orderLine);
		}
		catch (NoSuchOrderLineException nsee) {
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
	protected OrderLine removeImpl(OrderLine orderLine)
		throws SystemException {
		orderLine = toUnwrappedModel(orderLine);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, orderLine);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(orderLine);

		return orderLine;
	}

	@Override
	public OrderLine updateImpl(irestads.model.OrderLine orderLine,
		boolean merge) throws SystemException {
		orderLine = toUnwrappedModel(orderLine);

		boolean isNew = orderLine.isNew();

		OrderLineModelImpl orderLineModelImpl = (OrderLineModelImpl)orderLine;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, orderLine, merge);

			orderLine.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !OrderLineModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((orderLineModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUSDISH.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Integer.valueOf(orderLineModelImpl.getOriginalStatusDish())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUSDISH,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUSDISH,
					args);

				args = new Object[] {
						Integer.valueOf(orderLineModelImpl.getStatusDish())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUSDISH,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUSDISH,
					args);
			}

			if ((orderLineModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORDERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(orderLineModelImpl.getOriginalOrderId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ORDERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORDERID,
					args);

				args = new Object[] {
						Long.valueOf(orderLineModelImpl.getOrderId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ORDERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORDERID,
					args);
			}
		}

		EntityCacheUtil.putResult(OrderLineModelImpl.ENTITY_CACHE_ENABLED,
			OrderLineImpl.class, orderLine.getPrimaryKey(), orderLine);

		return orderLine;
	}

	protected OrderLine toUnwrappedModel(OrderLine orderLine) {
		if (orderLine instanceof OrderLineImpl) {
			return orderLine;
		}

		OrderLineImpl orderLineImpl = new OrderLineImpl();

		orderLineImpl.setNew(orderLine.isNew());
		orderLineImpl.setPrimaryKey(orderLine.getPrimaryKey());

		orderLineImpl.setOrderLineId(orderLine.getOrderLineId());
		orderLineImpl.setCompanyId(orderLine.getCompanyId());
		orderLineImpl.setUserId(orderLine.getUserId());
		orderLineImpl.setUserName(orderLine.getUserName());
		orderLineImpl.setCreateDate(orderLine.getCreateDate());
		orderLineImpl.setModifiedDate(orderLine.getModifiedDate());
		orderLineImpl.setNumOfDish(orderLine.getNumOfDish());
		orderLineImpl.setNumOfFinishDish(orderLine.getNumOfFinishDish());
		orderLineImpl.setStatusDish(orderLine.getStatusDish());
		orderLineImpl.setDishId(orderLine.getDishId());
		orderLineImpl.setOrderDate(orderLine.getOrderDate());
		orderLineImpl.setOrderId(orderLine.getOrderId());

		return orderLineImpl;
	}

	/**
	 * Returns the order line with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the order line
	 * @return the order line
	 * @throws com.liferay.portal.NoSuchModelException if a order line with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrderLine findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the order line with the primary key or throws a {@link irestads.NoSuchOrderLineException} if it could not be found.
	 *
	 * @param orderLineId the primary key of the order line
	 * @return the order line
	 * @throws irestads.NoSuchOrderLineException if a order line with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public OrderLine findByPrimaryKey(long orderLineId)
		throws NoSuchOrderLineException, SystemException {
		OrderLine orderLine = fetchByPrimaryKey(orderLineId);

		if (orderLine == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + orderLineId);
			}

			throw new NoSuchOrderLineException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				orderLineId);
		}

		return orderLine;
	}

	/**
	 * Returns the order line with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the order line
	 * @return the order line, or <code>null</code> if a order line with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrderLine fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the order line with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param orderLineId the primary key of the order line
	 * @return the order line, or <code>null</code> if a order line with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public OrderLine fetchByPrimaryKey(long orderLineId)
		throws SystemException {
		OrderLine orderLine = (OrderLine)EntityCacheUtil.getResult(OrderLineModelImpl.ENTITY_CACHE_ENABLED,
				OrderLineImpl.class, orderLineId);

		if (orderLine == _nullOrderLine) {
			return null;
		}

		if (orderLine == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				orderLine = (OrderLine)session.get(OrderLineImpl.class,
						Long.valueOf(orderLineId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (orderLine != null) {
					cacheResult(orderLine);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(OrderLineModelImpl.ENTITY_CACHE_ENABLED,
						OrderLineImpl.class, orderLineId, _nullOrderLine);
				}

				closeSession(session);
			}
		}

		return orderLine;
	}

	/**
	 * Returns all the order lines where statusDish = &#63;.
	 *
	 * @param statusDish the status dish
	 * @return the matching order lines
	 * @throws SystemException if a system exception occurred
	 */
	public List<OrderLine> findByStatusDish(int statusDish)
		throws SystemException {
		return findByStatusDish(statusDish, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the order lines where statusDish = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param statusDish the status dish
	 * @param start the lower bound of the range of order lines
	 * @param end the upper bound of the range of order lines (not inclusive)
	 * @return the range of matching order lines
	 * @throws SystemException if a system exception occurred
	 */
	public List<OrderLine> findByStatusDish(int statusDish, int start, int end)
		throws SystemException {
		return findByStatusDish(statusDish, start, end, null);
	}

	/**
	 * Returns an ordered range of all the order lines where statusDish = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param statusDish the status dish
	 * @param start the lower bound of the range of order lines
	 * @param end the upper bound of the range of order lines (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching order lines
	 * @throws SystemException if a system exception occurred
	 */
	public List<OrderLine> findByStatusDish(int statusDish, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUSDISH;
			finderArgs = new Object[] { statusDish };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUSDISH;
			finderArgs = new Object[] { statusDish, start, end, orderByComparator };
		}

		List<OrderLine> list = (List<OrderLine>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (OrderLine orderLine : list) {
				if ((statusDish != orderLine.getStatusDish())) {
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

			query.append(_SQL_SELECT_ORDERLINE_WHERE);

			query.append(_FINDER_COLUMN_STATUSDISH_STATUSDISH_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(OrderLineModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(statusDish);

				list = (List<OrderLine>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first order line in the ordered set where statusDish = &#63;.
	 *
	 * @param statusDish the status dish
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching order line
	 * @throws irestads.NoSuchOrderLineException if a matching order line could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public OrderLine findByStatusDish_First(int statusDish,
		OrderByComparator orderByComparator)
		throws NoSuchOrderLineException, SystemException {
		OrderLine orderLine = fetchByStatusDish_First(statusDish,
				orderByComparator);

		if (orderLine != null) {
			return orderLine;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("statusDish=");
		msg.append(statusDish);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOrderLineException(msg.toString());
	}

	/**
	 * Returns the first order line in the ordered set where statusDish = &#63;.
	 *
	 * @param statusDish the status dish
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching order line, or <code>null</code> if a matching order line could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public OrderLine fetchByStatusDish_First(int statusDish,
		OrderByComparator orderByComparator) throws SystemException {
		List<OrderLine> list = findByStatusDish(statusDish, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last order line in the ordered set where statusDish = &#63;.
	 *
	 * @param statusDish the status dish
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching order line
	 * @throws irestads.NoSuchOrderLineException if a matching order line could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public OrderLine findByStatusDish_Last(int statusDish,
		OrderByComparator orderByComparator)
		throws NoSuchOrderLineException, SystemException {
		OrderLine orderLine = fetchByStatusDish_Last(statusDish,
				orderByComparator);

		if (orderLine != null) {
			return orderLine;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("statusDish=");
		msg.append(statusDish);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOrderLineException(msg.toString());
	}

	/**
	 * Returns the last order line in the ordered set where statusDish = &#63;.
	 *
	 * @param statusDish the status dish
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching order line, or <code>null</code> if a matching order line could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public OrderLine fetchByStatusDish_Last(int statusDish,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByStatusDish(statusDish);

		List<OrderLine> list = findByStatusDish(statusDish, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the order lines before and after the current order line in the ordered set where statusDish = &#63;.
	 *
	 * @param orderLineId the primary key of the current order line
	 * @param statusDish the status dish
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next order line
	 * @throws irestads.NoSuchOrderLineException if a order line with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public OrderLine[] findByStatusDish_PrevAndNext(long orderLineId,
		int statusDish, OrderByComparator orderByComparator)
		throws NoSuchOrderLineException, SystemException {
		OrderLine orderLine = findByPrimaryKey(orderLineId);

		Session session = null;

		try {
			session = openSession();

			OrderLine[] array = new OrderLineImpl[3];

			array[0] = getByStatusDish_PrevAndNext(session, orderLine,
					statusDish, orderByComparator, true);

			array[1] = orderLine;

			array[2] = getByStatusDish_PrevAndNext(session, orderLine,
					statusDish, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected OrderLine getByStatusDish_PrevAndNext(Session session,
		OrderLine orderLine, int statusDish,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ORDERLINE_WHERE);

		query.append(_FINDER_COLUMN_STATUSDISH_STATUSDISH_2);

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
			query.append(OrderLineModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(statusDish);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(orderLine);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<OrderLine> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the order lines where orderId = &#63;.
	 *
	 * @param orderId the order ID
	 * @return the matching order lines
	 * @throws SystemException if a system exception occurred
	 */
	public List<OrderLine> findByOrderId(long orderId)
		throws SystemException {
		return findByOrderId(orderId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the order lines where orderId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param orderId the order ID
	 * @param start the lower bound of the range of order lines
	 * @param end the upper bound of the range of order lines (not inclusive)
	 * @return the range of matching order lines
	 * @throws SystemException if a system exception occurred
	 */
	public List<OrderLine> findByOrderId(long orderId, int start, int end)
		throws SystemException {
		return findByOrderId(orderId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the order lines where orderId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param orderId the order ID
	 * @param start the lower bound of the range of order lines
	 * @param end the upper bound of the range of order lines (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching order lines
	 * @throws SystemException if a system exception occurred
	 */
	public List<OrderLine> findByOrderId(long orderId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORDERID;
			finderArgs = new Object[] { orderId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ORDERID;
			finderArgs = new Object[] { orderId, start, end, orderByComparator };
		}

		List<OrderLine> list = (List<OrderLine>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (OrderLine orderLine : list) {
				if ((orderId != orderLine.getOrderId())) {
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

			query.append(_SQL_SELECT_ORDERLINE_WHERE);

			query.append(_FINDER_COLUMN_ORDERID_ORDERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(OrderLineModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(orderId);

				list = (List<OrderLine>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first order line in the ordered set where orderId = &#63;.
	 *
	 * @param orderId the order ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching order line
	 * @throws irestads.NoSuchOrderLineException if a matching order line could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public OrderLine findByOrderId_First(long orderId,
		OrderByComparator orderByComparator)
		throws NoSuchOrderLineException, SystemException {
		OrderLine orderLine = fetchByOrderId_First(orderId, orderByComparator);

		if (orderLine != null) {
			return orderLine;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("orderId=");
		msg.append(orderId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOrderLineException(msg.toString());
	}

	/**
	 * Returns the first order line in the ordered set where orderId = &#63;.
	 *
	 * @param orderId the order ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching order line, or <code>null</code> if a matching order line could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public OrderLine fetchByOrderId_First(long orderId,
		OrderByComparator orderByComparator) throws SystemException {
		List<OrderLine> list = findByOrderId(orderId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last order line in the ordered set where orderId = &#63;.
	 *
	 * @param orderId the order ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching order line
	 * @throws irestads.NoSuchOrderLineException if a matching order line could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public OrderLine findByOrderId_Last(long orderId,
		OrderByComparator orderByComparator)
		throws NoSuchOrderLineException, SystemException {
		OrderLine orderLine = fetchByOrderId_Last(orderId, orderByComparator);

		if (orderLine != null) {
			return orderLine;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("orderId=");
		msg.append(orderId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOrderLineException(msg.toString());
	}

	/**
	 * Returns the last order line in the ordered set where orderId = &#63;.
	 *
	 * @param orderId the order ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching order line, or <code>null</code> if a matching order line could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public OrderLine fetchByOrderId_Last(long orderId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByOrderId(orderId);

		List<OrderLine> list = findByOrderId(orderId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the order lines before and after the current order line in the ordered set where orderId = &#63;.
	 *
	 * @param orderLineId the primary key of the current order line
	 * @param orderId the order ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next order line
	 * @throws irestads.NoSuchOrderLineException if a order line with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public OrderLine[] findByOrderId_PrevAndNext(long orderLineId,
		long orderId, OrderByComparator orderByComparator)
		throws NoSuchOrderLineException, SystemException {
		OrderLine orderLine = findByPrimaryKey(orderLineId);

		Session session = null;

		try {
			session = openSession();

			OrderLine[] array = new OrderLineImpl[3];

			array[0] = getByOrderId_PrevAndNext(session, orderLine, orderId,
					orderByComparator, true);

			array[1] = orderLine;

			array[2] = getByOrderId_PrevAndNext(session, orderLine, orderId,
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

	protected OrderLine getByOrderId_PrevAndNext(Session session,
		OrderLine orderLine, long orderId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ORDERLINE_WHERE);

		query.append(_FINDER_COLUMN_ORDERID_ORDERID_2);

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
			query.append(OrderLineModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(orderId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(orderLine);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<OrderLine> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the order lines.
	 *
	 * @return the order lines
	 * @throws SystemException if a system exception occurred
	 */
	public List<OrderLine> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the order lines.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of order lines
	 * @param end the upper bound of the range of order lines (not inclusive)
	 * @return the range of order lines
	 * @throws SystemException if a system exception occurred
	 */
	public List<OrderLine> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the order lines.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of order lines
	 * @param end the upper bound of the range of order lines (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of order lines
	 * @throws SystemException if a system exception occurred
	 */
	public List<OrderLine> findAll(int start, int end,
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

		List<OrderLine> list = (List<OrderLine>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ORDERLINE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ORDERLINE.concat(OrderLineModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<OrderLine>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<OrderLine>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the order lines where statusDish = &#63; from the database.
	 *
	 * @param statusDish the status dish
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByStatusDish(int statusDish) throws SystemException {
		for (OrderLine orderLine : findByStatusDish(statusDish)) {
			remove(orderLine);
		}
	}

	/**
	 * Removes all the order lines where orderId = &#63; from the database.
	 *
	 * @param orderId the order ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByOrderId(long orderId) throws SystemException {
		for (OrderLine orderLine : findByOrderId(orderId)) {
			remove(orderLine);
		}
	}

	/**
	 * Removes all the order lines from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (OrderLine orderLine : findAll()) {
			remove(orderLine);
		}
	}

	/**
	 * Returns the number of order lines where statusDish = &#63;.
	 *
	 * @param statusDish the status dish
	 * @return the number of matching order lines
	 * @throws SystemException if a system exception occurred
	 */
	public int countByStatusDish(int statusDish) throws SystemException {
		Object[] finderArgs = new Object[] { statusDish };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_STATUSDISH,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ORDERLINE_WHERE);

			query.append(_FINDER_COLUMN_STATUSDISH_STATUSDISH_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(statusDish);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_STATUSDISH,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of order lines where orderId = &#63;.
	 *
	 * @param orderId the order ID
	 * @return the number of matching order lines
	 * @throws SystemException if a system exception occurred
	 */
	public int countByOrderId(long orderId) throws SystemException {
		Object[] finderArgs = new Object[] { orderId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ORDERID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ORDERLINE_WHERE);

			query.append(_FINDER_COLUMN_ORDERID_ORDERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(orderId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ORDERID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of order lines.
	 *
	 * @return the number of order lines
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_ORDERLINE);

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
	 * Initializes the order line persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.irestads.model.OrderLine")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<OrderLine>> listenersList = new ArrayList<ModelListener<OrderLine>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<OrderLine>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(OrderLineImpl.class.getName());
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
	private static final String _SQL_SELECT_ORDERLINE = "SELECT orderLine FROM OrderLine orderLine";
	private static final String _SQL_SELECT_ORDERLINE_WHERE = "SELECT orderLine FROM OrderLine orderLine WHERE ";
	private static final String _SQL_COUNT_ORDERLINE = "SELECT COUNT(orderLine) FROM OrderLine orderLine";
	private static final String _SQL_COUNT_ORDERLINE_WHERE = "SELECT COUNT(orderLine) FROM OrderLine orderLine WHERE ";
	private static final String _FINDER_COLUMN_STATUSDISH_STATUSDISH_2 = "orderLine.statusDish = ?";
	private static final String _FINDER_COLUMN_ORDERID_ORDERID_2 = "orderLine.orderId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "orderLine.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No OrderLine exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No OrderLine exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(OrderLinePersistenceImpl.class);
	private static OrderLine _nullOrderLine = new OrderLineImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<OrderLine> toCacheModel() {
				return _nullOrderLineCacheModel;
			}
		};

	private static CacheModel<OrderLine> _nullOrderLineCacheModel = new CacheModel<OrderLine>() {
			public OrderLine toEntityModel() {
				return _nullOrderLine;
			}
		};
}