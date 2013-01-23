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

import irestads.model.MenuLine;

/**
 * The persistence interface for the menu line service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Be
 * @see MenuLinePersistenceImpl
 * @see MenuLineUtil
 * @generated
 */
public interface MenuLinePersistence extends BasePersistence<MenuLine> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MenuLineUtil} to access the menu line persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the menu line in the entity cache if it is enabled.
	*
	* @param menuLine the menu line
	*/
	public void cacheResult(irestads.model.MenuLine menuLine);

	/**
	* Caches the menu lines in the entity cache if it is enabled.
	*
	* @param menuLines the menu lines
	*/
	public void cacheResult(java.util.List<irestads.model.MenuLine> menuLines);

	/**
	* Creates a new menu line with the primary key. Does not add the menu line to the database.
	*
	* @param menuLineId the primary key for the new menu line
	* @return the new menu line
	*/
	public irestads.model.MenuLine create(long menuLineId);

	/**
	* Removes the menu line with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param menuLineId the primary key of the menu line
	* @return the menu line that was removed
	* @throws irestads.NoSuchMenuLineException if a menu line with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.MenuLine remove(long menuLineId)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchMenuLineException;

	public irestads.model.MenuLine updateImpl(
		irestads.model.MenuLine menuLine, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the menu line with the primary key or throws a {@link irestads.NoSuchMenuLineException} if it could not be found.
	*
	* @param menuLineId the primary key of the menu line
	* @return the menu line
	* @throws irestads.NoSuchMenuLineException if a menu line with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.MenuLine findByPrimaryKey(long menuLineId)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchMenuLineException;

	/**
	* Returns the menu line with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param menuLineId the primary key of the menu line
	* @return the menu line, or <code>null</code> if a menu line with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.MenuLine fetchByPrimaryKey(long menuLineId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the menu lines where status = &#63;.
	*
	* @param status the status
	* @return the matching menu lines
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<irestads.model.MenuLine> findByStatus(boolean status)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<irestads.model.MenuLine> findByStatus(
		boolean status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<irestads.model.MenuLine> findByStatus(
		boolean status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first menu line in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching menu line
	* @throws irestads.NoSuchMenuLineException if a matching menu line could not be found
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.MenuLine findByStatus_First(boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchMenuLineException;

	/**
	* Returns the first menu line in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching menu line, or <code>null</code> if a matching menu line could not be found
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.MenuLine fetchByStatus_First(boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last menu line in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching menu line
	* @throws irestads.NoSuchMenuLineException if a matching menu line could not be found
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.MenuLine findByStatus_Last(boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchMenuLineException;

	/**
	* Returns the last menu line in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching menu line, or <code>null</code> if a matching menu line could not be found
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.MenuLine fetchByStatus_Last(boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public irestads.model.MenuLine[] findByStatus_PrevAndNext(long menuLineId,
		boolean status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchMenuLineException;

	/**
	* Returns all the menu lines where dishId = &#63;.
	*
	* @param dishId the dish ID
	* @return the matching menu lines
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<irestads.model.MenuLine> findByDishId(long dishId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the menu lines where dishId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dishId the dish ID
	* @param start the lower bound of the range of menu lines
	* @param end the upper bound of the range of menu lines (not inclusive)
	* @return the range of matching menu lines
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<irestads.model.MenuLine> findByDishId(long dishId,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the menu lines where dishId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dishId the dish ID
	* @param start the lower bound of the range of menu lines
	* @param end the upper bound of the range of menu lines (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching menu lines
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<irestads.model.MenuLine> findByDishId(long dishId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first menu line in the ordered set where dishId = &#63;.
	*
	* @param dishId the dish ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching menu line
	* @throws irestads.NoSuchMenuLineException if a matching menu line could not be found
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.MenuLine findByDishId_First(long dishId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchMenuLineException;

	/**
	* Returns the first menu line in the ordered set where dishId = &#63;.
	*
	* @param dishId the dish ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching menu line, or <code>null</code> if a matching menu line could not be found
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.MenuLine fetchByDishId_First(long dishId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last menu line in the ordered set where dishId = &#63;.
	*
	* @param dishId the dish ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching menu line
	* @throws irestads.NoSuchMenuLineException if a matching menu line could not be found
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.MenuLine findByDishId_Last(long dishId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchMenuLineException;

	/**
	* Returns the last menu line in the ordered set where dishId = &#63;.
	*
	* @param dishId the dish ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching menu line, or <code>null</code> if a matching menu line could not be found
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.MenuLine fetchByDishId_Last(long dishId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the menu lines before and after the current menu line in the ordered set where dishId = &#63;.
	*
	* @param menuLineId the primary key of the current menu line
	* @param dishId the dish ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next menu line
	* @throws irestads.NoSuchMenuLineException if a menu line with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.MenuLine[] findByDishId_PrevAndNext(long menuLineId,
		long dishId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchMenuLineException;

	/**
	* Returns all the menu lines where numOfDish = &#63;.
	*
	* @param numOfDish the num of dish
	* @return the matching menu lines
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<irestads.model.MenuLine> findByNumOfDish(
		int numOfDish)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<irestads.model.MenuLine> findByNumOfDish(
		int numOfDish, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<irestads.model.MenuLine> findByNumOfDish(
		int numOfDish, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first menu line in the ordered set where numOfDish = &#63;.
	*
	* @param numOfDish the num of dish
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching menu line
	* @throws irestads.NoSuchMenuLineException if a matching menu line could not be found
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.MenuLine findByNumOfDish_First(int numOfDish,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchMenuLineException;

	/**
	* Returns the first menu line in the ordered set where numOfDish = &#63;.
	*
	* @param numOfDish the num of dish
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching menu line, or <code>null</code> if a matching menu line could not be found
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.MenuLine fetchByNumOfDish_First(int numOfDish,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last menu line in the ordered set where numOfDish = &#63;.
	*
	* @param numOfDish the num of dish
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching menu line
	* @throws irestads.NoSuchMenuLineException if a matching menu line could not be found
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.MenuLine findByNumOfDish_Last(int numOfDish,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchMenuLineException;

	/**
	* Returns the last menu line in the ordered set where numOfDish = &#63;.
	*
	* @param numOfDish the num of dish
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching menu line, or <code>null</code> if a matching menu line could not be found
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.MenuLine fetchByNumOfDish_Last(int numOfDish,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public irestads.model.MenuLine[] findByNumOfDish_PrevAndNext(
		long menuLineId, int numOfDish,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchMenuLineException;

	/**
	* Returns all the menu lines.
	*
	* @return the menu lines
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<irestads.model.MenuLine> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<irestads.model.MenuLine> findAll(int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<irestads.model.MenuLine> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the menu lines where status = &#63; from the database.
	*
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByStatus(boolean status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the menu lines where dishId = &#63; from the database.
	*
	* @param dishId the dish ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByDishId(long dishId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the menu lines where numOfDish = &#63; from the database.
	*
	* @param numOfDish the num of dish
	* @throws SystemException if a system exception occurred
	*/
	public void removeByNumOfDish(int numOfDish)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the menu lines from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of menu lines where status = &#63;.
	*
	* @param status the status
	* @return the number of matching menu lines
	* @throws SystemException if a system exception occurred
	*/
	public int countByStatus(boolean status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of menu lines where dishId = &#63;.
	*
	* @param dishId the dish ID
	* @return the number of matching menu lines
	* @throws SystemException if a system exception occurred
	*/
	public int countByDishId(long dishId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of menu lines where numOfDish = &#63;.
	*
	* @param numOfDish the num of dish
	* @return the number of matching menu lines
	* @throws SystemException if a system exception occurred
	*/
	public int countByNumOfDish(int numOfDish)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of menu lines.
	*
	* @return the number of menu lines
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}