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

import irestads.model.Menu;

/**
 * The persistence interface for the menu service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Be
 * @see MenuPersistenceImpl
 * @see MenuUtil
 * @generated
 */
public interface MenuPersistence extends BasePersistence<Menu> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MenuUtil} to access the menu persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the menu in the entity cache if it is enabled.
	*
	* @param menu the menu
	*/
	public void cacheResult(irestads.model.Menu menu);

	/**
	* Caches the menus in the entity cache if it is enabled.
	*
	* @param menus the menus
	*/
	public void cacheResult(java.util.List<irestads.model.Menu> menus);

	/**
	* Creates a new menu with the primary key. Does not add the menu to the database.
	*
	* @param menuId the primary key for the new menu
	* @return the new menu
	*/
	public irestads.model.Menu create(long menuId);

	/**
	* Removes the menu with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param menuId the primary key of the menu
	* @return the menu that was removed
	* @throws irestads.NoSuchMenuException if a menu with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.Menu remove(long menuId)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchMenuException;

	public irestads.model.Menu updateImpl(irestads.model.Menu menu,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the menu with the primary key or throws a {@link irestads.NoSuchMenuException} if it could not be found.
	*
	* @param menuId the primary key of the menu
	* @return the menu
	* @throws irestads.NoSuchMenuException if a menu with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.Menu findByPrimaryKey(long menuId)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchMenuException;

	/**
	* Returns the menu with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param menuId the primary key of the menu
	* @return the menu, or <code>null</code> if a menu with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.Menu fetchByPrimaryKey(long menuId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the menus where menuName = &#63;.
	*
	* @param menuName the menu name
	* @return the matching menus
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<irestads.model.Menu> findByMenuName(
		java.lang.String menuName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the menus where menuName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param menuName the menu name
	* @param start the lower bound of the range of menus
	* @param end the upper bound of the range of menus (not inclusive)
	* @return the range of matching menus
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<irestads.model.Menu> findByMenuName(
		java.lang.String menuName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the menus where menuName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param menuName the menu name
	* @param start the lower bound of the range of menus
	* @param end the upper bound of the range of menus (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching menus
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<irestads.model.Menu> findByMenuName(
		java.lang.String menuName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first menu in the ordered set where menuName = &#63;.
	*
	* @param menuName the menu name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching menu
	* @throws irestads.NoSuchMenuException if a matching menu could not be found
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.Menu findByMenuName_First(java.lang.String menuName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchMenuException;

	/**
	* Returns the first menu in the ordered set where menuName = &#63;.
	*
	* @param menuName the menu name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching menu, or <code>null</code> if a matching menu could not be found
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.Menu fetchByMenuName_First(
		java.lang.String menuName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last menu in the ordered set where menuName = &#63;.
	*
	* @param menuName the menu name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching menu
	* @throws irestads.NoSuchMenuException if a matching menu could not be found
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.Menu findByMenuName_Last(java.lang.String menuName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchMenuException;

	/**
	* Returns the last menu in the ordered set where menuName = &#63;.
	*
	* @param menuName the menu name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching menu, or <code>null</code> if a matching menu could not be found
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.Menu fetchByMenuName_Last(java.lang.String menuName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the menus before and after the current menu in the ordered set where menuName = &#63;.
	*
	* @param menuId the primary key of the current menu
	* @param menuName the menu name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next menu
	* @throws irestads.NoSuchMenuException if a menu with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.Menu[] findByMenuName_PrevAndNext(long menuId,
		java.lang.String menuName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchMenuException;

	/**
	* Returns all the menus.
	*
	* @return the menus
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<irestads.model.Menu> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the menus.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of menus
	* @param end the upper bound of the range of menus (not inclusive)
	* @return the range of menus
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<irestads.model.Menu> findAll(int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the menus.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of menus
	* @param end the upper bound of the range of menus (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of menus
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<irestads.model.Menu> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the menus where menuName = &#63; from the database.
	*
	* @param menuName the menu name
	* @throws SystemException if a system exception occurred
	*/
	public void removeByMenuName(java.lang.String menuName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the menus from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of menus where menuName = &#63;.
	*
	* @param menuName the menu name
	* @return the number of matching menus
	* @throws SystemException if a system exception occurred
	*/
	public int countByMenuName(java.lang.String menuName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of menus.
	*
	* @return the number of menus
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the menu lines associated with the menu.
	*
	* @param pk the primary key of the menu
	* @return the menu lines associated with the menu
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<irestads.model.MenuLine> getMenuLines(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the menu lines associated with the menu.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param pk the primary key of the menu
	* @param start the lower bound of the range of menus
	* @param end the upper bound of the range of menus (not inclusive)
	* @return the range of menu lines associated with the menu
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<irestads.model.MenuLine> getMenuLines(long pk,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the menu lines associated with the menu.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param pk the primary key of the menu
	* @param start the lower bound of the range of menus
	* @param end the upper bound of the range of menus (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of menu lines associated with the menu
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<irestads.model.MenuLine> getMenuLines(long pk,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of menu lines associated with the menu.
	*
	* @param pk the primary key of the menu
	* @return the number of menu lines associated with the menu
	* @throws SystemException if a system exception occurred
	*/
	public int getMenuLinesSize(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns <code>true</code> if the menu line is associated with the menu.
	*
	* @param pk the primary key of the menu
	* @param menuLinePK the primary key of the menu line
	* @return <code>true</code> if the menu line is associated with the menu; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsMenuLine(long pk, long menuLinePK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns <code>true</code> if the menu has any menu lines associated with it.
	*
	* @param pk the primary key of the menu to check for associations with menu lines
	* @return <code>true</code> if the menu has any menu lines associated with it; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsMenuLines(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;
}