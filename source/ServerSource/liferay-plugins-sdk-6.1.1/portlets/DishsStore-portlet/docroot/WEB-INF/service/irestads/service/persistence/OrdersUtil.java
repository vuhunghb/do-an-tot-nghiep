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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import irestads.model.Orders;

import java.util.List;

/**
 * The persistence utility for the orders service. This utility wraps {@link OrdersPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Be
 * @see OrdersPersistence
 * @see OrdersPersistenceImpl
 * @generated
 */
public class OrdersUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(Orders orders) {
		getPersistence().clearCache(orders);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Orders> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Orders> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Orders> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Orders update(Orders orders, boolean merge)
		throws SystemException {
		return getPersistence().update(orders, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Orders update(Orders orders, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(orders, merge, serviceContext);
	}

	/**
	* Caches the orders in the entity cache if it is enabled.
	*
	* @param orders the orders
	*/
	public static void cacheResult(irestads.model.Orders orders) {
		getPersistence().cacheResult(orders);
	}

	/**
	* Caches the orderses in the entity cache if it is enabled.
	*
	* @param orderses the orderses
	*/
	public static void cacheResult(
		java.util.List<irestads.model.Orders> orderses) {
		getPersistence().cacheResult(orderses);
	}

	/**
	* Creates a new orders with the primary key. Does not add the orders to the database.
	*
	* @param orderId the primary key for the new orders
	* @return the new orders
	*/
	public static irestads.model.Orders create(long orderId) {
		return getPersistence().create(orderId);
	}

	/**
	* Removes the orders with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param orderId the primary key of the orders
	* @return the orders that was removed
	* @throws irestads.NoSuchOrdersException if a orders with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.Orders remove(long orderId)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchOrdersException {
		return getPersistence().remove(orderId);
	}

	public static irestads.model.Orders updateImpl(
		irestads.model.Orders orders, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(orders, merge);
	}

	/**
	* Returns the orders with the primary key or throws a {@link irestads.NoSuchOrdersException} if it could not be found.
	*
	* @param orderId the primary key of the orders
	* @return the orders
	* @throws irestads.NoSuchOrdersException if a orders with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.Orders findByPrimaryKey(long orderId)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchOrdersException {
		return getPersistence().findByPrimaryKey(orderId);
	}

	/**
	* Returns the orders with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param orderId the primary key of the orders
	* @return the orders, or <code>null</code> if a orders with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.Orders fetchByPrimaryKey(long orderId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(orderId);
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
	public static irestads.model.Orders findBycurentOrder(int isPayMent,
		java.lang.String dishTableId)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchOrdersException {
		return getPersistence().findBycurentOrder(isPayMent, dishTableId);
	}

	/**
	* Returns the orders where isPayMent = &#63; and dishTableId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param isPayMent the is pay ment
	* @param dishTableId the dish table ID
	* @return the matching orders, or <code>null</code> if a matching orders could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.Orders fetchBycurentOrder(int isPayMent,
		java.lang.String dishTableId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBycurentOrder(isPayMent, dishTableId);
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
	public static irestads.model.Orders fetchBycurentOrder(int isPayMent,
		java.lang.String dishTableId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBycurentOrder(isPayMent, dishTableId, retrieveFromCache);
	}

	/**
	* Returns all the orderses.
	*
	* @return the orderses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<irestads.model.Orders> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<irestads.model.Orders> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
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
	public static java.util.List<irestads.model.Orders> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes the orders where isPayMent = &#63; and dishTableId = &#63; from the database.
	*
	* @param isPayMent the is pay ment
	* @param dishTableId the dish table ID
	* @return the orders that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.Orders removeBycurentOrder(int isPayMent,
		java.lang.String dishTableId)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchOrdersException {
		return getPersistence().removeBycurentOrder(isPayMent, dishTableId);
	}

	/**
	* Removes all the orderses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of orderses where isPayMent = &#63; and dishTableId = &#63;.
	*
	* @param isPayMent the is pay ment
	* @param dishTableId the dish table ID
	* @return the number of matching orderses
	* @throws SystemException if a system exception occurred
	*/
	public static int countBycurentOrder(int isPayMent,
		java.lang.String dishTableId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBycurentOrder(isPayMent, dishTableId);
	}

	/**
	* Returns the number of orderses.
	*
	* @return the number of orderses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	/**
	* Returns all the order lines associated with the orders.
	*
	* @param pk the primary key of the orders
	* @return the order lines associated with the orders
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<irestads.model.OrderLine> getOrderLines(
		long pk) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getOrderLines(pk);
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
	public static java.util.List<irestads.model.OrderLine> getOrderLines(
		long pk, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getOrderLines(pk, start, end);
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
	public static java.util.List<irestads.model.OrderLine> getOrderLines(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getOrderLines(pk, start, end, orderByComparator);
	}

	/**
	* Returns the number of order lines associated with the orders.
	*
	* @param pk the primary key of the orders
	* @return the number of order lines associated with the orders
	* @throws SystemException if a system exception occurred
	*/
	public static int getOrderLinesSize(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getOrderLinesSize(pk);
	}

	/**
	* Returns <code>true</code> if the order line is associated with the orders.
	*
	* @param pk the primary key of the orders
	* @param orderLinePK the primary key of the order line
	* @return <code>true</code> if the order line is associated with the orders; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public static boolean containsOrderLine(long pk, long orderLinePK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().containsOrderLine(pk, orderLinePK);
	}

	/**
	* Returns <code>true</code> if the orders has any order lines associated with it.
	*
	* @param pk the primary key of the orders to check for associations with order lines
	* @return <code>true</code> if the orders has any order lines associated with it; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public static boolean containsOrderLines(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().containsOrderLines(pk);
	}

	public static OrdersPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (OrdersPersistence)PortletBeanLocatorUtil.locate(irestads.service.ClpSerializer.getServletContextName(),
					OrdersPersistence.class.getName());

			ReferenceRegistry.registerReference(OrdersUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(OrdersPersistence persistence) {
	}

	private static OrdersPersistence _persistence;
}