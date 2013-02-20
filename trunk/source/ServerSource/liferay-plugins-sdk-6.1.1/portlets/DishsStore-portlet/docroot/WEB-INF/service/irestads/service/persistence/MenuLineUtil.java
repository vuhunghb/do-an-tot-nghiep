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

import irestads.model.MenuLine;

import java.util.List;

/**
 * The persistence utility for the menu line service. This utility wraps {@link MenuLinePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Be
 * @see MenuLinePersistence
 * @see MenuLinePersistenceImpl
 * @generated
 */
public class MenuLineUtil {
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
	public static void clearCache(MenuLine menuLine) {
		getPersistence().clearCache(menuLine);
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
	public static List<MenuLine> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<MenuLine> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<MenuLine> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static MenuLine update(MenuLine menuLine, boolean merge)
		throws SystemException {
		return getPersistence().update(menuLine, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static MenuLine update(MenuLine menuLine, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(menuLine, merge, serviceContext);
	}

	/**
	* Caches the menu line in the entity cache if it is enabled.
	*
	* @param menuLine the menu line
	*/
	public static void cacheResult(irestads.model.MenuLine menuLine) {
		getPersistence().cacheResult(menuLine);
	}

	/**
	* Caches the menu lines in the entity cache if it is enabled.
	*
	* @param menuLines the menu lines
	*/
	public static void cacheResult(
		java.util.List<irestads.model.MenuLine> menuLines) {
		getPersistence().cacheResult(menuLines);
	}

	/**
	* Creates a new menu line with the primary key. Does not add the menu line to the database.
	*
	* @param menuLineId the primary key for the new menu line
	* @return the new menu line
	*/
	public static irestads.model.MenuLine create(long menuLineId) {
		return getPersistence().create(menuLineId);
	}

	/**
	* Removes the menu line with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param menuLineId the primary key of the menu line
	* @return the menu line that was removed
	* @throws irestads.NoSuchMenuLineException if a menu line with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.MenuLine remove(long menuLineId)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchMenuLineException {
		return getPersistence().remove(menuLineId);
	}

	public static irestads.model.MenuLine updateImpl(
		irestads.model.MenuLine menuLine, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(menuLine, merge);
	}

	/**
	* Returns the menu line with the primary key or throws a {@link irestads.NoSuchMenuLineException} if it could not be found.
	*
	* @param menuLineId the primary key of the menu line
	* @return the menu line
	* @throws irestads.NoSuchMenuLineException if a menu line with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.MenuLine findByPrimaryKey(long menuLineId)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchMenuLineException {
		return getPersistence().findByPrimaryKey(menuLineId);
	}

	/**
	* Returns the menu line with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param menuLineId the primary key of the menu line
	* @return the menu line, or <code>null</code> if a menu line with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.MenuLine fetchByPrimaryKey(long menuLineId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(menuLineId);
	}

	/**
	* Returns all the menu lines where status = &#63;.
	*
	* @param status the status
	* @return the matching menu lines
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<irestads.model.MenuLine> findByStatus(
		boolean status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStatus(status);
	}

	/**
	* Returns a range of all the menu lines where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of menu lines
	* @param end the upper bound of the range of menu lines (not inclusive)
	* @return the range of matching menu lines
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<irestads.model.MenuLine> findByStatus(
		boolean status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStatus(status, start, end);
	}

	/**
	* Returns an ordered range of all the menu lines where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of menu lines
	* @param end the upper bound of the range of menu lines (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching menu lines
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<irestads.model.MenuLine> findByStatus(
		boolean status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStatus(status, start, end, orderByComparator);
	}

	/**
	* Returns the first menu line in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching menu line
	* @throws irestads.NoSuchMenuLineException if a matching menu line could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.MenuLine findByStatus_First(boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchMenuLineException {
		return getPersistence().findByStatus_First(status, orderByComparator);
	}

	/**
	* Returns the first menu line in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching menu line, or <code>null</code> if a matching menu line could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.MenuLine fetchByStatus_First(boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByStatus_First(status, orderByComparator);
	}

	/**
	* Returns the last menu line in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching menu line
	* @throws irestads.NoSuchMenuLineException if a matching menu line could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.MenuLine findByStatus_Last(boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchMenuLineException {
		return getPersistence().findByStatus_Last(status, orderByComparator);
	}

	/**
	* Returns the last menu line in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching menu line, or <code>null</code> if a matching menu line could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.MenuLine fetchByStatus_Last(boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByStatus_Last(status, orderByComparator);
	}

	/**
	* Returns the menu lines before and after the current menu line in the ordered set where status = &#63;.
	*
	* @param menuLineId the primary key of the current menu line
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next menu line
	* @throws irestads.NoSuchMenuLineException if a menu line with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.MenuLine[] findByStatus_PrevAndNext(
		long menuLineId, boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchMenuLineException {
		return getPersistence()
				   .findByStatus_PrevAndNext(menuLineId, status,
			orderByComparator);
	}

	/**
	* Returns the menu line where dishId = &#63; or throws a {@link irestads.NoSuchMenuLineException} if it could not be found.
	*
	* @param dishId the dish ID
	* @return the matching menu line
	* @throws irestads.NoSuchMenuLineException if a matching menu line could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.MenuLine findByDishId(long dishId)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchMenuLineException {
		return getPersistence().findByDishId(dishId);
	}

	/**
	* Returns the menu line where dishId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param dishId the dish ID
	* @return the matching menu line, or <code>null</code> if a matching menu line could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.MenuLine fetchByDishId(long dishId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByDishId(dishId);
	}

	/**
	* Returns the menu line where dishId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param dishId the dish ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching menu line, or <code>null</code> if a matching menu line could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.MenuLine fetchByDishId(long dishId,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByDishId(dishId, retrieveFromCache);
	}

	/**
	* Returns all the menu lines where numOfDish = &#63;.
	*
	* @param numOfDish the num of dish
	* @return the matching menu lines
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<irestads.model.MenuLine> findByNumOfDish(
		int numOfDish)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByNumOfDish(numOfDish);
	}

	/**
	* Returns a range of all the menu lines where numOfDish = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param numOfDish the num of dish
	* @param start the lower bound of the range of menu lines
	* @param end the upper bound of the range of menu lines (not inclusive)
	* @return the range of matching menu lines
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<irestads.model.MenuLine> findByNumOfDish(
		int numOfDish, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByNumOfDish(numOfDish, start, end);
	}

	/**
	* Returns an ordered range of all the menu lines where numOfDish = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param numOfDish the num of dish
	* @param start the lower bound of the range of menu lines
	* @param end the upper bound of the range of menu lines (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching menu lines
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<irestads.model.MenuLine> findByNumOfDish(
		int numOfDish, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByNumOfDish(numOfDish, start, end, orderByComparator);
	}

	/**
	* Returns the first menu line in the ordered set where numOfDish = &#63;.
	*
	* @param numOfDish the num of dish
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching menu line
	* @throws irestads.NoSuchMenuLineException if a matching menu line could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.MenuLine findByNumOfDish_First(int numOfDish,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchMenuLineException {
		return getPersistence()
				   .findByNumOfDish_First(numOfDish, orderByComparator);
	}

	/**
	* Returns the first menu line in the ordered set where numOfDish = &#63;.
	*
	* @param numOfDish the num of dish
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching menu line, or <code>null</code> if a matching menu line could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.MenuLine fetchByNumOfDish_First(
		int numOfDish,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByNumOfDish_First(numOfDish, orderByComparator);
	}

	/**
	* Returns the last menu line in the ordered set where numOfDish = &#63;.
	*
	* @param numOfDish the num of dish
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching menu line
	* @throws irestads.NoSuchMenuLineException if a matching menu line could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.MenuLine findByNumOfDish_Last(int numOfDish,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchMenuLineException {
		return getPersistence()
				   .findByNumOfDish_Last(numOfDish, orderByComparator);
	}

	/**
	* Returns the last menu line in the ordered set where numOfDish = &#63;.
	*
	* @param numOfDish the num of dish
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching menu line, or <code>null</code> if a matching menu line could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.MenuLine fetchByNumOfDish_Last(int numOfDish,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByNumOfDish_Last(numOfDish, orderByComparator);
	}

	/**
	* Returns the menu lines before and after the current menu line in the ordered set where numOfDish = &#63;.
	*
	* @param menuLineId the primary key of the current menu line
	* @param numOfDish the num of dish
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next menu line
	* @throws irestads.NoSuchMenuLineException if a menu line with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.MenuLine[] findByNumOfDish_PrevAndNext(
		long menuLineId, int numOfDish,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchMenuLineException {
		return getPersistence()
				   .findByNumOfDish_PrevAndNext(menuLineId, numOfDish,
			orderByComparator);
	}

	/**
	* Returns all the menu lines.
	*
	* @return the menu lines
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<irestads.model.MenuLine> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the menu lines.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of menu lines
	* @param end the upper bound of the range of menu lines (not inclusive)
	* @return the range of menu lines
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<irestads.model.MenuLine> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the menu lines.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of menu lines
	* @param end the upper bound of the range of menu lines (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of menu lines
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<irestads.model.MenuLine> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the menu lines where status = &#63; from the database.
	*
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByStatus(boolean status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByStatus(status);
	}

	/**
	* Removes the menu line where dishId = &#63; from the database.
	*
	* @param dishId the dish ID
	* @return the menu line that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.MenuLine removeByDishId(long dishId)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchMenuLineException {
		return getPersistence().removeByDishId(dishId);
	}

	/**
	* Removes all the menu lines where numOfDish = &#63; from the database.
	*
	* @param numOfDish the num of dish
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByNumOfDish(int numOfDish)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByNumOfDish(numOfDish);
	}

	/**
	* Removes all the menu lines from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of menu lines where status = &#63;.
	*
	* @param status the status
	* @return the number of matching menu lines
	* @throws SystemException if a system exception occurred
	*/
	public static int countByStatus(boolean status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByStatus(status);
	}

	/**
	* Returns the number of menu lines where dishId = &#63;.
	*
	* @param dishId the dish ID
	* @return the number of matching menu lines
	* @throws SystemException if a system exception occurred
	*/
	public static int countByDishId(long dishId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByDishId(dishId);
	}

	/**
	* Returns the number of menu lines where numOfDish = &#63;.
	*
	* @param numOfDish the num of dish
	* @return the number of matching menu lines
	* @throws SystemException if a system exception occurred
	*/
	public static int countByNumOfDish(int numOfDish)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByNumOfDish(numOfDish);
	}

	/**
	* Returns the number of menu lines.
	*
	* @return the number of menu lines
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static MenuLinePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (MenuLinePersistence)PortletBeanLocatorUtil.locate(irestads.service.ClpSerializer.getServletContextName(),
					MenuLinePersistence.class.getName());

			ReferenceRegistry.registerReference(MenuLineUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(MenuLinePersistence persistence) {
	}

	private static MenuLinePersistence _persistence;
}