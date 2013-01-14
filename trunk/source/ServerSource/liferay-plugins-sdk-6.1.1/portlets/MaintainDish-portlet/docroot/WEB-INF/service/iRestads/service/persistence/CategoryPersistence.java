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

import com.liferay.portal.service.persistence.BasePersistence;

import iRestads.model.Category;

/**
 * The persistence interface for the category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Be
 * @see CategoryPersistenceImpl
 * @see CategoryUtil
 * @generated
 */
public interface CategoryPersistence extends BasePersistence<Category> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CategoryUtil} to access the category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the category in the entity cache if it is enabled.
	*
	* @param category the category
	*/
	public void cacheResult(iRestads.model.Category category);

	/**
	* Caches the categories in the entity cache if it is enabled.
	*
	* @param categories the categories
	*/
	public void cacheResult(java.util.List<iRestads.model.Category> categories);

	/**
	* Creates a new category with the primary key. Does not add the category to the database.
	*
	* @param categoryId the primary key for the new category
	* @return the new category
	*/
	public iRestads.model.Category create(long categoryId);

	/**
	* Removes the category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param categoryId the primary key of the category
	* @return the category that was removed
	* @throws iRestads.NoSuchCategoryException if a category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public iRestads.model.Category remove(long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			iRestads.NoSuchCategoryException;

	public iRestads.model.Category updateImpl(
		iRestads.model.Category category, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the category with the primary key or throws a {@link iRestads.NoSuchCategoryException} if it could not be found.
	*
	* @param categoryId the primary key of the category
	* @return the category
	* @throws iRestads.NoSuchCategoryException if a category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public iRestads.model.Category findByPrimaryKey(long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			iRestads.NoSuchCategoryException;

	/**
	* Returns the category with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param categoryId the primary key of the category
	* @return the category, or <code>null</code> if a category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public iRestads.model.Category fetchByPrimaryKey(long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the categories where categoryName = &#63;.
	*
	* @param categoryName the category name
	* @return the matching categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<iRestads.model.Category> findByCategoryName(
		java.lang.String categoryName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the categories where categoryName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param categoryName the category name
	* @param start the lower bound of the range of categories
	* @param end the upper bound of the range of categories (not inclusive)
	* @return the range of matching categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<iRestads.model.Category> findByCategoryName(
		java.lang.String categoryName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the categories where categoryName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param categoryName the category name
	* @param start the lower bound of the range of categories
	* @param end the upper bound of the range of categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<iRestads.model.Category> findByCategoryName(
		java.lang.String categoryName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first category in the ordered set where categoryName = &#63;.
	*
	* @param categoryName the category name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching category
	* @throws iRestads.NoSuchCategoryException if a matching category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public iRestads.model.Category findByCategoryName_First(
		java.lang.String categoryName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			iRestads.NoSuchCategoryException;

	/**
	* Returns the first category in the ordered set where categoryName = &#63;.
	*
	* @param categoryName the category name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching category, or <code>null</code> if a matching category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public iRestads.model.Category fetchByCategoryName_First(
		java.lang.String categoryName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last category in the ordered set where categoryName = &#63;.
	*
	* @param categoryName the category name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching category
	* @throws iRestads.NoSuchCategoryException if a matching category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public iRestads.model.Category findByCategoryName_Last(
		java.lang.String categoryName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			iRestads.NoSuchCategoryException;

	/**
	* Returns the last category in the ordered set where categoryName = &#63;.
	*
	* @param categoryName the category name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching category, or <code>null</code> if a matching category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public iRestads.model.Category fetchByCategoryName_Last(
		java.lang.String categoryName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the categories before and after the current category in the ordered set where categoryName = &#63;.
	*
	* @param categoryId the primary key of the current category
	* @param categoryName the category name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next category
	* @throws iRestads.NoSuchCategoryException if a category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public iRestads.model.Category[] findByCategoryName_PrevAndNext(
		long categoryId, java.lang.String categoryName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			iRestads.NoSuchCategoryException;

	/**
	* Returns all the categories.
	*
	* @return the categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<iRestads.model.Category> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of categories
	* @param end the upper bound of the range of categories (not inclusive)
	* @return the range of categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<iRestads.model.Category> findAll(int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of categories
	* @param end the upper bound of the range of categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<iRestads.model.Category> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the categories where categoryName = &#63; from the database.
	*
	* @param categoryName the category name
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCategoryName(java.lang.String categoryName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the categories from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of categories where categoryName = &#63;.
	*
	* @param categoryName the category name
	* @return the number of matching categories
	* @throws SystemException if a system exception occurred
	*/
	public int countByCategoryName(java.lang.String categoryName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of categories.
	*
	* @return the number of categories
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the dishs associated with the category.
	*
	* @param pk the primary key of the category
	* @return the dishs associated with the category
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<iRestads.model.Dish> getDishs(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the dishs associated with the category.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param pk the primary key of the category
	* @param start the lower bound of the range of categories
	* @param end the upper bound of the range of categories (not inclusive)
	* @return the range of dishs associated with the category
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<iRestads.model.Dish> getDishs(long pk, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the dishs associated with the category.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param pk the primary key of the category
	* @param start the lower bound of the range of categories
	* @param end the upper bound of the range of categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of dishs associated with the category
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<iRestads.model.Dish> getDishs(long pk, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of dishs associated with the category.
	*
	* @param pk the primary key of the category
	* @return the number of dishs associated with the category
	* @throws SystemException if a system exception occurred
	*/
	public int getDishsSize(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns <code>true</code> if the dish is associated with the category.
	*
	* @param pk the primary key of the category
	* @param dishPK the primary key of the dish
	* @return <code>true</code> if the dish is associated with the category; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsDish(long pk, long dishPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns <code>true</code> if the category has any dishs associated with it.
	*
	* @param pk the primary key of the category to check for associations with dishs
	* @return <code>true</code> if the category has any dishs associated with it; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsDishs(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;
}