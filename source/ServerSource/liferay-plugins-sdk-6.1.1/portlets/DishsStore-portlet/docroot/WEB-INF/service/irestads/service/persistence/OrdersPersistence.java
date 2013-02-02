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

import com.liferay.portal.service.persistence.BasePersistence;

import irestads.model.Orders;

/**
 * The persistence interface for the orders service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Be
 * @see OrdersPersistenceImpl
 * @see OrdersUtil
 * @generated
 */
public interface OrdersPersistence extends BasePersistence<Orders> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link OrdersUtil} to access the orders persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the orders in the entity cache if it is enabled.
	*
	* @param orders the orders
	*/
	public void cacheResult(irestads.model.Orders orders);

	/**
	* Caches the orderses in the entity cache if it is enabled.
	*
	* @param orderses the orderses
	*/
	public void cacheResult(java.util.List<irestads.model.Orders> orderses);

	/**
	* Creates a new orders with the primary key. Does not add the orders to the database.
	*
	* @param orderId the primary key for the new orders
	* @return the new orders
	*/
	public irestads.model.Orders create(long orderId);

	/**
	* Removes the orders with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param orderId the primary key of the orders
	* @return the orders that was removed
	* @throws irestads.NoSuchOrdersException if a orders with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.Orders remove(long orderId)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchOrdersException;

	public irestads.model.Orders updateImpl(irestads.model.Orders orders,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the orders with the primary key or throws a {@link irestads.NoSuchOrdersException} if it could not be found.
	*
	* @param orderId the primary key of the orders
	* @return the orders
	* @throws irestads.NoSuchOrdersException if a orders with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.Orders findByPrimaryKey(long orderId)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchOrdersException;

	/**
	* Returns the orders with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param orderId the primary key of the orders
	* @return the orders, or <code>null</code> if a orders with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.Orders fetchByPrimaryKey(long orderId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the orders where isPayMent = &#63; and dishTableId = &#63; or throws a {@link irestads.NoSuchOrdersException} if it could not be found.
	*
	* @param isPayMent the is pay ment
	* @param dishTableId the dish table ID
	* @return the matching orders
	* @throws irestads.NoSuchOrdersException if a matching orders could not be found
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.Orders findBycurentOrder(boolean isPayMent,
		java.lang.String dishTableId)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchOrdersException;

	/**
	* Returns the orders where isPayMent = &#63; and dishTableId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param isPayMent the is pay ment
	* @param dishTableId the dish table ID
	* @return the matching orders, or <code>null</code> if a matching orders could not be found
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.Orders fetchBycurentOrder(boolean isPayMent,
		java.lang.String dishTableId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the orders where isPayMent = &#63; and dishTableId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param isPayMent the is pay ment
	* @param dishTableId the dish table ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching orders, or <code>null</code> if a matching orders could not be found
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.Orders fetchBycurentOrder(boolean isPayMent,
		java.lang.String dishTableId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the orderses.
	*
	* @return the orderses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<irestads.model.Orders> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<irestads.model.Orders> findAll(int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<irestads.model.Orders> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the orders where isPayMent = &#63; and dishTableId = &#63; from the database.
	*
	* @param isPayMent the is pay ment
	* @param dishTableId the dish table ID
	* @return the orders that was removed
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.Orders removeBycurentOrder(boolean isPayMent,
		java.lang.String dishTableId)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchOrdersException;

	/**
	* Removes all the orderses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of orderses where isPayMent = &#63; and dishTableId = &#63;.
	*
	* @param isPayMent the is pay ment
	* @param dishTableId the dish table ID
	* @return the number of matching orderses
	* @throws SystemException if a system exception occurred
	*/
	public int countBycurentOrder(boolean isPayMent,
		java.lang.String dishTableId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of orderses.
	*
	* @return the number of orderses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the order lines associated with the orders.
	*
	* @param pk the primary key of the orders
	* @return the order lines associated with the orders
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<irestads.model.OrderLine> getOrderLines(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<irestads.model.OrderLine> getOrderLines(long pk,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<irestads.model.OrderLine> getOrderLines(long pk,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of order lines associated with the orders.
	*
	* @param pk the primary key of the orders
	* @return the number of order lines associated with the orders
	* @throws SystemException if a system exception occurred
	*/
	public int getOrderLinesSize(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns <code>true</code> if the order line is associated with the orders.
	*
	* @param pk the primary key of the orders
	* @param orderLinePK the primary key of the order line
	* @return <code>true</code> if the order line is associated with the orders; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsOrderLine(long pk, long orderLinePK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns <code>true</code> if the orders has any order lines associated with it.
	*
	* @param pk the primary key of the orders to check for associations with order lines
	* @return <code>true</code> if the orders has any order lines associated with it; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsOrderLines(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;
}