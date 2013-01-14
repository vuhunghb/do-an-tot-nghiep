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

package iRestads.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import iRestads.model.Dish;

import java.util.List;

/**
 * The persistence utility for the dish service. This utility wraps {@link DishPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Be
 * @see DishPersistence
 * @see DishPersistenceImpl
 * @generated
 */
public class DishUtil {
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
	public static void clearCache(Dish dish) {
		getPersistence().clearCache(dish);
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
	public static List<Dish> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Dish> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Dish> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Dish update(Dish dish, boolean merge)
		throws SystemException {
		return getPersistence().update(dish, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Dish update(Dish dish, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(dish, merge, serviceContext);
	}

	/**
	* Caches the dish in the entity cache if it is enabled.
	*
	* @param dish the dish
	*/
	public static void cacheResult(iRestads.model.Dish dish) {
		getPersistence().cacheResult(dish);
	}

	/**
	* Caches the dishs in the entity cache if it is enabled.
	*
	* @param dishs the dishs
	*/
	public static void cacheResult(java.util.List<iRestads.model.Dish> dishs) {
		getPersistence().cacheResult(dishs);
	}

	/**
	* Creates a new dish with the primary key. Does not add the dish to the database.
	*
	* @param dishId the primary key for the new dish
	* @return the new dish
	*/
	public static iRestads.model.Dish create(long dishId) {
		return getPersistence().create(dishId);
	}

	/**
	* Removes the dish with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param dishId the primary key of the dish
	* @return the dish that was removed
	* @throws iRestads.NoSuchDishException if a dish with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static iRestads.model.Dish remove(long dishId)
		throws com.liferay.portal.kernel.exception.SystemException,
			iRestads.NoSuchDishException {
		return getPersistence().remove(dishId);
	}

	public static iRestads.model.Dish updateImpl(iRestads.model.Dish dish,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(dish, merge);
	}

	/**
	* Returns the dish with the primary key or throws a {@link iRestads.NoSuchDishException} if it could not be found.
	*
	* @param dishId the primary key of the dish
	* @return the dish
	* @throws iRestads.NoSuchDishException if a dish with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static iRestads.model.Dish findByPrimaryKey(long dishId)
		throws com.liferay.portal.kernel.exception.SystemException,
			iRestads.NoSuchDishException {
		return getPersistence().findByPrimaryKey(dishId);
	}

	/**
	* Returns the dish with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param dishId the primary key of the dish
	* @return the dish, or <code>null</code> if a dish with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static iRestads.model.Dish fetchByPrimaryKey(long dishId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(dishId);
	}

	/**
	* Returns all the dishs where dishName = &#63;.
	*
	* @param dishName the dish name
	* @return the matching dishs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<iRestads.model.Dish> findByDishName(
		java.lang.String dishName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDishName(dishName);
	}

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
	public static java.util.List<iRestads.model.Dish> findByDishName(
		java.lang.String dishName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDishName(dishName, start, end);
	}

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
	public static java.util.List<iRestads.model.Dish> findByDishName(
		java.lang.String dishName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDishName(dishName, start, end, orderByComparator);
	}

	/**
	* Returns the first dish in the ordered set where dishName = &#63;.
	*
	* @param dishName the dish name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dish
	* @throws iRestads.NoSuchDishException if a matching dish could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static iRestads.model.Dish findByDishName_First(
		java.lang.String dishName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			iRestads.NoSuchDishException {
		return getPersistence().findByDishName_First(dishName, orderByComparator);
	}

	/**
	* Returns the first dish in the ordered set where dishName = &#63;.
	*
	* @param dishName the dish name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dish, or <code>null</code> if a matching dish could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static iRestads.model.Dish fetchByDishName_First(
		java.lang.String dishName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByDishName_First(dishName, orderByComparator);
	}

	/**
	* Returns the last dish in the ordered set where dishName = &#63;.
	*
	* @param dishName the dish name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dish
	* @throws iRestads.NoSuchDishException if a matching dish could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static iRestads.model.Dish findByDishName_Last(
		java.lang.String dishName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			iRestads.NoSuchDishException {
		return getPersistence().findByDishName_Last(dishName, orderByComparator);
	}

	/**
	* Returns the last dish in the ordered set where dishName = &#63;.
	*
	* @param dishName the dish name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dish, or <code>null</code> if a matching dish could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static iRestads.model.Dish fetchByDishName_Last(
		java.lang.String dishName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByDishName_Last(dishName, orderByComparator);
	}

	/**
	* Returns the dishs before and after the current dish in the ordered set where dishName = &#63;.
	*
	* @param dishId the primary key of the current dish
	* @param dishName the dish name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next dish
	* @throws iRestads.NoSuchDishException if a dish with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static iRestads.model.Dish[] findByDishName_PrevAndNext(
		long dishId, java.lang.String dishName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			iRestads.NoSuchDishException {
		return getPersistence()
				   .findByDishName_PrevAndNext(dishId, dishName,
			orderByComparator);
	}

	/**
	* Returns all the dishs.
	*
	* @return the dishs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<iRestads.model.Dish> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<iRestads.model.Dish> findAll(int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<iRestads.model.Dish> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the dishs where dishName = &#63; from the database.
	*
	* @param dishName the dish name
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByDishName(java.lang.String dishName)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByDishName(dishName);
	}

	/**
	* Removes all the dishs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of dishs where dishName = &#63;.
	*
	* @param dishName the dish name
	* @return the number of matching dishs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByDishName(java.lang.String dishName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByDishName(dishName);
	}

	/**
	* Returns the number of dishs.
	*
	* @return the number of dishs
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static DishPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (DishPersistence)PortletBeanLocatorUtil.locate(iRestads.service.ClpSerializer.getServletContextName(),
					DishPersistence.class.getName());

			ReferenceRegistry.registerReference(DishUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(DishPersistence persistence) {
	}

	private static DishPersistence _persistence;
}