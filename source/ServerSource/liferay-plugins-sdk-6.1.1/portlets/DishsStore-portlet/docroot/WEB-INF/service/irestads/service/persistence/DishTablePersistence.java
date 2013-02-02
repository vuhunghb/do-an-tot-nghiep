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

import irestads.model.DishTable;

/**
 * The persistence interface for the dish table service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Be
 * @see DishTablePersistenceImpl
 * @see DishTableUtil
 * @generated
 */
public interface DishTablePersistence extends BasePersistence<DishTable> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DishTableUtil} to access the dish table persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the dish table in the entity cache if it is enabled.
	*
	* @param dishTable the dish table
	*/
	public void cacheResult(irestads.model.DishTable dishTable);

	/**
	* Caches the dish tables in the entity cache if it is enabled.
	*
	* @param dishTables the dish tables
	*/
	public void cacheResult(java.util.List<irestads.model.DishTable> dishTables);

	/**
	* Creates a new dish table with the primary key. Does not add the dish table to the database.
	*
	* @param dishTableId the primary key for the new dish table
	* @return the new dish table
	*/
	public irestads.model.DishTable create(java.lang.String dishTableId);

	/**
	* Removes the dish table with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param dishTableId the primary key of the dish table
	* @return the dish table that was removed
	* @throws irestads.NoSuchDishTableException if a dish table with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.DishTable remove(java.lang.String dishTableId)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchDishTableException;

	public irestads.model.DishTable updateImpl(
		irestads.model.DishTable dishTable, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the dish table with the primary key or throws a {@link irestads.NoSuchDishTableException} if it could not be found.
	*
	* @param dishTableId the primary key of the dish table
	* @return the dish table
	* @throws irestads.NoSuchDishTableException if a dish table with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.DishTable findByPrimaryKey(
		java.lang.String dishTableId)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchDishTableException;

	/**
	* Returns the dish table with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param dishTableId the primary key of the dish table
	* @return the dish table, or <code>null</code> if a dish table with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.DishTable fetchByPrimaryKey(
		java.lang.String dishTableId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the dish tables where isAvalable = &#63;.
	*
	* @param isAvalable the is avalable
	* @return the matching dish tables
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<irestads.model.DishTable> findByIsAvalable(
		boolean isAvalable)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<irestads.model.DishTable> findByIsAvalable(
		boolean isAvalable, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<irestads.model.DishTable> findByIsAvalable(
		boolean isAvalable, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first dish table in the ordered set where isAvalable = &#63;.
	*
	* @param isAvalable the is avalable
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dish table
	* @throws irestads.NoSuchDishTableException if a matching dish table could not be found
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.DishTable findByIsAvalable_First(boolean isAvalable,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchDishTableException;

	/**
	* Returns the first dish table in the ordered set where isAvalable = &#63;.
	*
	* @param isAvalable the is avalable
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dish table, or <code>null</code> if a matching dish table could not be found
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.DishTable fetchByIsAvalable_First(
		boolean isAvalable,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last dish table in the ordered set where isAvalable = &#63;.
	*
	* @param isAvalable the is avalable
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dish table
	* @throws irestads.NoSuchDishTableException if a matching dish table could not be found
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.DishTable findByIsAvalable_Last(boolean isAvalable,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchDishTableException;

	/**
	* Returns the last dish table in the ordered set where isAvalable = &#63;.
	*
	* @param isAvalable the is avalable
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dish table, or <code>null</code> if a matching dish table could not be found
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.DishTable fetchByIsAvalable_Last(boolean isAvalable,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public irestads.model.DishTable[] findByIsAvalable_PrevAndNext(
		java.lang.String dishTableId, boolean isAvalable,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchDishTableException;

	/**
	* Returns all the dish tables.
	*
	* @return the dish tables
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<irestads.model.DishTable> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<irestads.model.DishTable> findAll(int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<irestads.model.DishTable> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the dish tables where isAvalable = &#63; from the database.
	*
	* @param isAvalable the is avalable
	* @throws SystemException if a system exception occurred
	*/
	public void removeByIsAvalable(boolean isAvalable)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the dish tables from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of dish tables where isAvalable = &#63;.
	*
	* @param isAvalable the is avalable
	* @return the number of matching dish tables
	* @throws SystemException if a system exception occurred
	*/
	public int countByIsAvalable(boolean isAvalable)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of dish tables.
	*
	* @return the number of dish tables
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the orderses associated with the dish table.
	*
	* @param pk the primary key of the dish table
	* @return the orderses associated with the dish table
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<irestads.model.Orders> getOrderses(
		java.lang.String pk)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<irestads.model.Orders> getOrderses(
		java.lang.String pk, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<irestads.model.Orders> getOrderses(
		java.lang.String pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of orderses associated with the dish table.
	*
	* @param pk the primary key of the dish table
	* @return the number of orderses associated with the dish table
	* @throws SystemException if a system exception occurred
	*/
	public int getOrdersesSize(java.lang.String pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns <code>true</code> if the orders is associated with the dish table.
	*
	* @param pk the primary key of the dish table
	* @param ordersPK the primary key of the orders
	* @return <code>true</code> if the orders is associated with the dish table; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsOrders(java.lang.String pk, long ordersPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns <code>true</code> if the dish table has any orderses associated with it.
	*
	* @param pk the primary key of the dish table to check for associations with orderses
	* @return <code>true</code> if the dish table has any orderses associated with it; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsOrderses(java.lang.String pk)
		throws com.liferay.portal.kernel.exception.SystemException;
}