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

import irestads.model.OrderLine;

import java.util.List;

/**
 * The persistence utility for the order line service. This utility wraps {@link OrderLinePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Be
 * @see OrderLinePersistence
 * @see OrderLinePersistenceImpl
 * @generated
 */
public class OrderLineUtil {
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
	public static void clearCache(OrderLine orderLine) {
		getPersistence().clearCache(orderLine);
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
	public static List<OrderLine> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<OrderLine> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<OrderLine> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static OrderLine update(OrderLine orderLine, boolean merge)
		throws SystemException {
		return getPersistence().update(orderLine, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static OrderLine update(OrderLine orderLine, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(orderLine, merge, serviceContext);
	}

	/**
	* Caches the order line in the entity cache if it is enabled.
	*
	* @param orderLine the order line
	*/
	public static void cacheResult(irestads.model.OrderLine orderLine) {
		getPersistence().cacheResult(orderLine);
	}

	/**
	* Caches the order lines in the entity cache if it is enabled.
	*
	* @param orderLines the order lines
	*/
	public static void cacheResult(
		java.util.List<irestads.model.OrderLine> orderLines) {
		getPersistence().cacheResult(orderLines);
	}

	/**
	* Creates a new order line with the primary key. Does not add the order line to the database.
	*
	* @param orderLineId the primary key for the new order line
	* @return the new order line
	*/
	public static irestads.model.OrderLine create(long orderLineId) {
		return getPersistence().create(orderLineId);
	}

	/**
	* Removes the order line with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param orderLineId the primary key of the order line
	* @return the order line that was removed
	* @throws irestads.NoSuchOrderLineException if a order line with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.OrderLine remove(long orderLineId)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchOrderLineException {
		return getPersistence().remove(orderLineId);
	}

	public static irestads.model.OrderLine updateImpl(
		irestads.model.OrderLine orderLine, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(orderLine, merge);
	}

	/**
	* Returns the order line with the primary key or throws a {@link irestads.NoSuchOrderLineException} if it could not be found.
	*
	* @param orderLineId the primary key of the order line
	* @return the order line
	* @throws irestads.NoSuchOrderLineException if a order line with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.OrderLine findByPrimaryKey(long orderLineId)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchOrderLineException {
		return getPersistence().findByPrimaryKey(orderLineId);
	}

	/**
	* Returns the order line with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param orderLineId the primary key of the order line
	* @return the order line, or <code>null</code> if a order line with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.OrderLine fetchByPrimaryKey(long orderLineId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(orderLineId);
	}

	/**
	* Returns all the order lines where statusDish = &#63;.
	*
	* @param statusDish the status dish
	* @return the matching order lines
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<irestads.model.OrderLine> findByStatusDish(
		boolean statusDish)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStatusDish(statusDish);
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
	public static java.util.List<irestads.model.OrderLine> findByStatusDish(
		boolean statusDish, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStatusDish(statusDish, start, end);
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
	public static java.util.List<irestads.model.OrderLine> findByStatusDish(
		boolean statusDish, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStatusDish(statusDish, start, end, orderByComparator);
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
	public static irestads.model.OrderLine findByStatusDish_First(
		boolean statusDish,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchOrderLineException {
		return getPersistence()
				   .findByStatusDish_First(statusDish, orderByComparator);
	}

	/**
	* Returns the first order line in the ordered set where statusDish = &#63;.
	*
	* @param statusDish the status dish
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching order line, or <code>null</code> if a matching order line could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.OrderLine fetchByStatusDish_First(
		boolean statusDish,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByStatusDish_First(statusDish, orderByComparator);
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
	public static irestads.model.OrderLine findByStatusDish_Last(
		boolean statusDish,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchOrderLineException {
		return getPersistence()
				   .findByStatusDish_Last(statusDish, orderByComparator);
	}

	/**
	* Returns the last order line in the ordered set where statusDish = &#63;.
	*
	* @param statusDish the status dish
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching order line, or <code>null</code> if a matching order line could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.OrderLine fetchByStatusDish_Last(
		boolean statusDish,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByStatusDish_Last(statusDish, orderByComparator);
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
	public static irestads.model.OrderLine[] findByStatusDish_PrevAndNext(
		long orderLineId, boolean statusDish,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchOrderLineException {
		return getPersistence()
				   .findByStatusDish_PrevAndNext(orderLineId, statusDish,
			orderByComparator);
	}

	/**
	* Returns all the order lines.
	*
	* @return the order lines
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<irestads.model.OrderLine> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<irestads.model.OrderLine> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
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
	public static java.util.List<irestads.model.OrderLine> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the order lines where statusDish = &#63; from the database.
	*
	* @param statusDish the status dish
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByStatusDish(boolean statusDish)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByStatusDish(statusDish);
	}

	/**
	* Removes all the order lines from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of order lines where statusDish = &#63;.
	*
	* @param statusDish the status dish
	* @return the number of matching order lines
	* @throws SystemException if a system exception occurred
	*/
	public static int countByStatusDish(boolean statusDish)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByStatusDish(statusDish);
	}

	/**
	* Returns the number of order lines.
	*
	* @return the number of order lines
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static OrderLinePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (OrderLinePersistence)PortletBeanLocatorUtil.locate(irestads.service.ClpSerializer.getServletContextName(),
					OrderLinePersistence.class.getName());

			ReferenceRegistry.registerReference(OrderLineUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(OrderLinePersistence persistence) {
	}

	private static OrderLinePersistence _persistence;
}