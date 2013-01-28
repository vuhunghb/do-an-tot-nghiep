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

import irestads.model.DishTable;

import java.util.List;

/**
 * The persistence utility for the dish table service. This utility wraps {@link DishTablePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Be
 * @see DishTablePersistence
 * @see DishTablePersistenceImpl
 * @generated
 */
public class DishTableUtil {
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
	public static void clearCache(DishTable dishTable) {
		getPersistence().clearCache(dishTable);
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
	public static List<DishTable> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DishTable> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DishTable> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static DishTable update(DishTable dishTable, boolean merge)
		throws SystemException {
		return getPersistence().update(dishTable, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static DishTable update(DishTable dishTable, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(dishTable, merge, serviceContext);
	}

	/**
	* Caches the dish table in the entity cache if it is enabled.
	*
	* @param dishTable the dish table
	*/
	public static void cacheResult(irestads.model.DishTable dishTable) {
		getPersistence().cacheResult(dishTable);
	}

	/**
	* Caches the dish tables in the entity cache if it is enabled.
	*
	* @param dishTables the dish tables
	*/
	public static void cacheResult(
		java.util.List<irestads.model.DishTable> dishTables) {
		getPersistence().cacheResult(dishTables);
	}

	/**
	* Creates a new dish table with the primary key. Does not add the dish table to the database.
	*
	* @param dishTableId the primary key for the new dish table
	* @return the new dish table
	*/
	public static irestads.model.DishTable create(long dishTableId) {
		return getPersistence().create(dishTableId);
	}

	/**
	* Removes the dish table with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param dishTableId the primary key of the dish table
	* @return the dish table that was removed
	* @throws irestads.NoSuchDishTableException if a dish table with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.DishTable remove(long dishTableId)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchDishTableException {
		return getPersistence().remove(dishTableId);
	}

	public static irestads.model.DishTable updateImpl(
		irestads.model.DishTable dishTable, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(dishTable, merge);
	}

	/**
	* Returns the dish table with the primary key or throws a {@link irestads.NoSuchDishTableException} if it could not be found.
	*
	* @param dishTableId the primary key of the dish table
	* @return the dish table
	* @throws irestads.NoSuchDishTableException if a dish table with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.DishTable findByPrimaryKey(long dishTableId)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchDishTableException {
		return getPersistence().findByPrimaryKey(dishTableId);
	}

	/**
	* Returns the dish table with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param dishTableId the primary key of the dish table
	* @return the dish table, or <code>null</code> if a dish table with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.DishTable fetchByPrimaryKey(long dishTableId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(dishTableId);
	}

	/**
	* Returns all the dish tables where isAvalable = &#63;.
	*
	* @param isAvalable the is avalable
	* @return the matching dish tables
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<irestads.model.DishTable> findByIsAvalable(
		boolean isAvalable)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByIsAvalable(isAvalable);
	}

	/**
	* Returns a range of all the dish tables where isAvalable = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param isAvalable the is avalable
	* @param start the lower bound of the range of dish tables
	* @param end the upper bound of the range of dish tables (not inclusive)
	* @return the range of matching dish tables
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<irestads.model.DishTable> findByIsAvalable(
		boolean isAvalable, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByIsAvalable(isAvalable, start, end);
	}

	/**
	* Returns an ordered range of all the dish tables where isAvalable = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param isAvalable the is avalable
	* @param start the lower bound of the range of dish tables
	* @param end the upper bound of the range of dish tables (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching dish tables
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<irestads.model.DishTable> findByIsAvalable(
		boolean isAvalable, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByIsAvalable(isAvalable, start, end, orderByComparator);
	}

	/**
	* Returns the first dish table in the ordered set where isAvalable = &#63;.
	*
	* @param isAvalable the is avalable
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dish table
	* @throws irestads.NoSuchDishTableException if a matching dish table could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.DishTable findByIsAvalable_First(
		boolean isAvalable,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchDishTableException {
		return getPersistence()
				   .findByIsAvalable_First(isAvalable, orderByComparator);
	}

	/**
	* Returns the first dish table in the ordered set where isAvalable = &#63;.
	*
	* @param isAvalable the is avalable
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dish table, or <code>null</code> if a matching dish table could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.DishTable fetchByIsAvalable_First(
		boolean isAvalable,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByIsAvalable_First(isAvalable, orderByComparator);
	}

	/**
	* Returns the last dish table in the ordered set where isAvalable = &#63;.
	*
	* @param isAvalable the is avalable
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dish table
	* @throws irestads.NoSuchDishTableException if a matching dish table could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.DishTable findByIsAvalable_Last(
		boolean isAvalable,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchDishTableException {
		return getPersistence()
				   .findByIsAvalable_Last(isAvalable, orderByComparator);
	}

	/**
	* Returns the last dish table in the ordered set where isAvalable = &#63;.
	*
	* @param isAvalable the is avalable
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dish table, or <code>null</code> if a matching dish table could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.DishTable fetchByIsAvalable_Last(
		boolean isAvalable,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByIsAvalable_Last(isAvalable, orderByComparator);
	}

	/**
	* Returns the dish tables before and after the current dish table in the ordered set where isAvalable = &#63;.
	*
	* @param dishTableId the primary key of the current dish table
	* @param isAvalable the is avalable
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next dish table
	* @throws irestads.NoSuchDishTableException if a dish table with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.DishTable[] findByIsAvalable_PrevAndNext(
		long dishTableId, boolean isAvalable,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchDishTableException {
		return getPersistence()
				   .findByIsAvalable_PrevAndNext(dishTableId, isAvalable,
			orderByComparator);
	}

	/**
	* Returns all the dish tables.
	*
	* @return the dish tables
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<irestads.model.DishTable> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the dish tables.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of dish tables
	* @param end the upper bound of the range of dish tables (not inclusive)
	* @return the range of dish tables
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<irestads.model.DishTable> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the dish tables.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of dish tables
	* @param end the upper bound of the range of dish tables (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of dish tables
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<irestads.model.DishTable> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the dish tables where isAvalable = &#63; from the database.
	*
	* @param isAvalable the is avalable
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByIsAvalable(boolean isAvalable)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByIsAvalable(isAvalable);
	}

	/**
	* Removes all the dish tables from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of dish tables where isAvalable = &#63;.
	*
	* @param isAvalable the is avalable
	* @return the number of matching dish tables
	* @throws SystemException if a system exception occurred
	*/
	public static int countByIsAvalable(boolean isAvalable)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByIsAvalable(isAvalable);
	}

	/**
	* Returns the number of dish tables.
	*
	* @return the number of dish tables
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	/**
	* Returns all the orderses associated with the dish table.
	*
	* @param pk the primary key of the dish table
	* @return the orderses associated with the dish table
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<irestads.model.Orders> getOrderses(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getOrderses(pk);
	}

	/**
	* Returns a range of all the orderses associated with the dish table.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param pk the primary key of the dish table
	* @param start the lower bound of the range of dish tables
	* @param end the upper bound of the range of dish tables (not inclusive)
	* @return the range of orderses associated with the dish table
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<irestads.model.Orders> getOrderses(long pk,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getOrderses(pk, start, end);
	}

	/**
	* Returns an ordered range of all the orderses associated with the dish table.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param pk the primary key of the dish table
	* @param start the lower bound of the range of dish tables
	* @param end the upper bound of the range of dish tables (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of orderses associated with the dish table
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<irestads.model.Orders> getOrderses(long pk,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getOrderses(pk, start, end, orderByComparator);
	}

	/**
	* Returns the number of orderses associated with the dish table.
	*
	* @param pk the primary key of the dish table
	* @return the number of orderses associated with the dish table
	* @throws SystemException if a system exception occurred
	*/
	public static int getOrdersesSize(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getOrdersesSize(pk);
	}

	/**
	* Returns <code>true</code> if the orders is associated with the dish table.
	*
	* @param pk the primary key of the dish table
	* @param ordersPK the primary key of the orders
	* @return <code>true</code> if the orders is associated with the dish table; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public static boolean containsOrders(long pk, long ordersPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().containsOrders(pk, ordersPK);
	}

	/**
	* Returns <code>true</code> if the dish table has any orderses associated with it.
	*
	* @param pk the primary key of the dish table to check for associations with orderses
	* @return <code>true</code> if the dish table has any orderses associated with it; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public static boolean containsOrderses(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().containsOrderses(pk);
	}

	public static DishTablePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (DishTablePersistence)PortletBeanLocatorUtil.locate(irestads.service.ClpSerializer.getServletContextName(),
					DishTablePersistence.class.getName());

			ReferenceRegistry.registerReference(DishTableUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(DishTablePersistence persistence) {
	}

	private static DishTablePersistence _persistence;
}