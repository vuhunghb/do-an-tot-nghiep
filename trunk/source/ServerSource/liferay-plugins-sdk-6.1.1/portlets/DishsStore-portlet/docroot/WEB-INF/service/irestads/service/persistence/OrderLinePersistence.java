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

import irestads.model.OrderLine;

/**
 * The persistence interface for the order line service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Be
 * @see OrderLinePersistenceImpl
 * @see OrderLineUtil
 * @generated
 */
public interface OrderLinePersistence extends BasePersistence<OrderLine> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link OrderLineUtil} to access the order line persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the order line in the entity cache if it is enabled.
	*
	* @param orderLine the order line
	*/
	public void cacheResult(irestads.model.OrderLine orderLine);

	/**
	* Caches the order lines in the entity cache if it is enabled.
	*
	* @param orderLines the order lines
	*/
	public void cacheResult(java.util.List<irestads.model.OrderLine> orderLines);

	/**
	* Creates a new order line with the primary key. Does not add the order line to the database.
	*
	* @param orderLineId the primary key for the new order line
	* @return the new order line
	*/
	public irestads.model.OrderLine create(long orderLineId);

	/**
	* Removes the order line with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param orderLineId the primary key of the order line
	* @return the order line that was removed
	* @throws irestads.NoSuchOrderLineException if a order line with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.OrderLine remove(long orderLineId)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchOrderLineException;

	public irestads.model.OrderLine updateImpl(
		irestads.model.OrderLine orderLine, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the order line with the primary key or throws a {@link irestads.NoSuchOrderLineException} if it could not be found.
	*
	* @param orderLineId the primary key of the order line
	* @return the order line
	* @throws irestads.NoSuchOrderLineException if a order line with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.OrderLine findByPrimaryKey(long orderLineId)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchOrderLineException;

	/**
	* Returns the order line with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param orderLineId the primary key of the order line
	* @return the order line, or <code>null</code> if a order line with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.OrderLine fetchByPrimaryKey(long orderLineId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the order lines where statusDish = &#63;.
	*
	* @param statusDish the status dish
	* @return the matching order lines
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<irestads.model.OrderLine> findByStatusDish(
		boolean statusDish)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<irestads.model.OrderLine> findByStatusDish(
		boolean statusDish, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<irestads.model.OrderLine> findByStatusDish(
		boolean statusDish, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first order line in the ordered set where statusDish = &#63;.
	*
	* @param statusDish the status dish
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching order line
	* @throws irestads.NoSuchOrderLineException if a matching order line could not be found
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.OrderLine findByStatusDish_First(boolean statusDish,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchOrderLineException;

	/**
	* Returns the first order line in the ordered set where statusDish = &#63;.
	*
	* @param statusDish the status dish
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching order line, or <code>null</code> if a matching order line could not be found
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.OrderLine fetchByStatusDish_First(
		boolean statusDish,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last order line in the ordered set where statusDish = &#63;.
	*
	* @param statusDish the status dish
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching order line
	* @throws irestads.NoSuchOrderLineException if a matching order line could not be found
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.OrderLine findByStatusDish_Last(boolean statusDish,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchOrderLineException;

	/**
	* Returns the last order line in the ordered set where statusDish = &#63;.
	*
	* @param statusDish the status dish
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching order line, or <code>null</code> if a matching order line could not be found
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.OrderLine fetchByStatusDish_Last(boolean statusDish,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public irestads.model.OrderLine[] findByStatusDish_PrevAndNext(
		long orderLineId, boolean statusDish,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchOrderLineException;

	/**
	* Returns all the order lines.
	*
	* @return the order lines
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<irestads.model.OrderLine> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<irestads.model.OrderLine> findAll(int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<irestads.model.OrderLine> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the order lines where statusDish = &#63; from the database.
	*
	* @param statusDish the status dish
	* @throws SystemException if a system exception occurred
	*/
	public void removeByStatusDish(boolean statusDish)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the order lines from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of order lines where statusDish = &#63;.
	*
	* @param statusDish the status dish
	* @return the number of matching order lines
	* @throws SystemException if a system exception occurred
	*/
	public int countByStatusDish(boolean statusDish)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of order lines.
	*
	* @return the number of order lines
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}