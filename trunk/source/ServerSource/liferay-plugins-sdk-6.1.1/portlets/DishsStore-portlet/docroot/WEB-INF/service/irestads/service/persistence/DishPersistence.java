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

import irestads.model.Dish;

/**
 * The persistence interface for the dish service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Be
 * @see DishPersistenceImpl
 * @see DishUtil
 * @generated
 */
public interface DishPersistence extends BasePersistence<Dish> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DishUtil} to access the dish persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the dish in the entity cache if it is enabled.
	*
	* @param dish the dish
	*/
	public void cacheResult(irestads.model.Dish dish);

	/**
	* Caches the dishs in the entity cache if it is enabled.
	*
	* @param dishs the dishs
	*/
	public void cacheResult(java.util.List<irestads.model.Dish> dishs);

	/**
	* Creates a new dish with the primary key. Does not add the dish to the database.
	*
	* @param dishId the primary key for the new dish
	* @return the new dish
	*/
	public irestads.model.Dish create(long dishId);

	/**
	* Removes the dish with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param dishId the primary key of the dish
	* @return the dish that was removed
	* @throws irestads.NoSuchDishException if a dish with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.Dish remove(long dishId)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchDishException;

	public irestads.model.Dish updateImpl(irestads.model.Dish dish,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the dish with the primary key or throws a {@link irestads.NoSuchDishException} if it could not be found.
	*
	* @param dishId the primary key of the dish
	* @return the dish
	* @throws irestads.NoSuchDishException if a dish with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.Dish findByPrimaryKey(long dishId)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchDishException;

	/**
	* Returns the dish with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param dishId the primary key of the dish
	* @return the dish, or <code>null</code> if a dish with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.Dish fetchByPrimaryKey(long dishId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the dishs where dishName = &#63;.
	*
	* @param dishName the dish name
	* @return the matching dishs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<irestads.model.Dish> findByDishName(
		java.lang.String dishName)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<irestads.model.Dish> findByDishName(
		java.lang.String dishName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<irestads.model.Dish> findByDishName(
		java.lang.String dishName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first dish in the ordered set where dishName = &#63;.
	*
	* @param dishName the dish name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dish
	* @throws irestads.NoSuchDishException if a matching dish could not be found
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.Dish findByDishName_First(java.lang.String dishName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchDishException;

	/**
	* Returns the first dish in the ordered set where dishName = &#63;.
	*
	* @param dishName the dish name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dish, or <code>null</code> if a matching dish could not be found
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.Dish fetchByDishName_First(
		java.lang.String dishName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last dish in the ordered set where dishName = &#63;.
	*
	* @param dishName the dish name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dish
	* @throws irestads.NoSuchDishException if a matching dish could not be found
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.Dish findByDishName_Last(java.lang.String dishName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchDishException;

	/**
	* Returns the last dish in the ordered set where dishName = &#63;.
	*
	* @param dishName the dish name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dish, or <code>null</code> if a matching dish could not be found
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.Dish fetchByDishName_Last(java.lang.String dishName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public irestads.model.Dish[] findByDishName_PrevAndNext(long dishId,
		java.lang.String dishName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchDishException;

	/**
	* Returns all the dishs where referPrice = &#63;.
	*
	* @param referPrice the refer price
	* @return the matching dishs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<irestads.model.Dish> findByReferPrice(int referPrice)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the dishs where referPrice = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param referPrice the refer price
	* @param start the lower bound of the range of dishs
	* @param end the upper bound of the range of dishs (not inclusive)
	* @return the range of matching dishs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<irestads.model.Dish> findByReferPrice(
		int referPrice, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the dishs where referPrice = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param referPrice the refer price
	* @param start the lower bound of the range of dishs
	* @param end the upper bound of the range of dishs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching dishs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<irestads.model.Dish> findByReferPrice(
		int referPrice, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first dish in the ordered set where referPrice = &#63;.
	*
	* @param referPrice the refer price
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dish
	* @throws irestads.NoSuchDishException if a matching dish could not be found
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.Dish findByReferPrice_First(int referPrice,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchDishException;

	/**
	* Returns the first dish in the ordered set where referPrice = &#63;.
	*
	* @param referPrice the refer price
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dish, or <code>null</code> if a matching dish could not be found
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.Dish fetchByReferPrice_First(int referPrice,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last dish in the ordered set where referPrice = &#63;.
	*
	* @param referPrice the refer price
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dish
	* @throws irestads.NoSuchDishException if a matching dish could not be found
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.Dish findByReferPrice_Last(int referPrice,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchDishException;

	/**
	* Returns the last dish in the ordered set where referPrice = &#63;.
	*
	* @param referPrice the refer price
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dish, or <code>null</code> if a matching dish could not be found
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.Dish fetchByReferPrice_Last(int referPrice,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the dishs before and after the current dish in the ordered set where referPrice = &#63;.
	*
	* @param dishId the primary key of the current dish
	* @param referPrice the refer price
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next dish
	* @throws irestads.NoSuchDishException if a dish with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.Dish[] findByReferPrice_PrevAndNext(long dishId,
		int referPrice,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchDishException;

	/**
	* Returns all the dishs.
	*
	* @return the dishs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<irestads.model.Dish> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<irestads.model.Dish> findAll(int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<irestads.model.Dish> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the dishs where dishName = &#63; from the database.
	*
	* @param dishName the dish name
	* @throws SystemException if a system exception occurred
	*/
	public void removeByDishName(java.lang.String dishName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the dishs where referPrice = &#63; from the database.
	*
	* @param referPrice the refer price
	* @throws SystemException if a system exception occurred
	*/
	public void removeByReferPrice(int referPrice)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the dishs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of dishs where dishName = &#63;.
	*
	* @param dishName the dish name
	* @return the number of matching dishs
	* @throws SystemException if a system exception occurred
	*/
	public int countByDishName(java.lang.String dishName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of dishs where referPrice = &#63;.
	*
	* @param referPrice the refer price
	* @return the number of matching dishs
	* @throws SystemException if a system exception occurred
	*/
	public int countByReferPrice(int referPrice)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of dishs.
	*
	* @return the number of dishs
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}