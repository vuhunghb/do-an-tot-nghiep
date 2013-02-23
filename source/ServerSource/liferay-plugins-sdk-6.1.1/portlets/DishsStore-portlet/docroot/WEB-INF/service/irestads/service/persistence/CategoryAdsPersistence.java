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

import irestads.model.CategoryAds;

/**
 * The persistence interface for the category ads service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Be
 * @see CategoryAdsPersistenceImpl
 * @see CategoryAdsUtil
 * @generated
 */
public interface CategoryAdsPersistence extends BasePersistence<CategoryAds> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CategoryAdsUtil} to access the category ads persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the category ads in the entity cache if it is enabled.
	*
	* @param categoryAds the category ads
	*/
	public void cacheResult(irestads.model.CategoryAds categoryAds);

	/**
	* Caches the category adses in the entity cache if it is enabled.
	*
	* @param categoryAdses the category adses
	*/
	public void cacheResult(
		java.util.List<irestads.model.CategoryAds> categoryAdses);

	/**
	* Creates a new category ads with the primary key. Does not add the category ads to the database.
	*
	* @param categoryAdsId the primary key for the new category ads
	* @return the new category ads
	*/
	public irestads.model.CategoryAds create(long categoryAdsId);

	/**
	* Removes the category ads with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param categoryAdsId the primary key of the category ads
	* @return the category ads that was removed
	* @throws irestads.NoSuchCategoryAdsException if a category ads with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.CategoryAds remove(long categoryAdsId)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchCategoryAdsException;

	public irestads.model.CategoryAds updateImpl(
		irestads.model.CategoryAds categoryAds, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the category ads with the primary key or throws a {@link irestads.NoSuchCategoryAdsException} if it could not be found.
	*
	* @param categoryAdsId the primary key of the category ads
	* @return the category ads
	* @throws irestads.NoSuchCategoryAdsException if a category ads with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.CategoryAds findByPrimaryKey(long categoryAdsId)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchCategoryAdsException;

	/**
	* Returns the category ads with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param categoryAdsId the primary key of the category ads
	* @return the category ads, or <code>null</code> if a category ads with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.CategoryAds fetchByPrimaryKey(long categoryAdsId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the category adses where categoryAdsName = &#63;.
	*
	* @param categoryAdsName the category ads name
	* @return the matching category adses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<irestads.model.CategoryAds> findByCategoryAdsName(
		java.lang.String categoryAdsName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the category adses where categoryAdsName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param categoryAdsName the category ads name
	* @param start the lower bound of the range of category adses
	* @param end the upper bound of the range of category adses (not inclusive)
	* @return the range of matching category adses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<irestads.model.CategoryAds> findByCategoryAdsName(
		java.lang.String categoryAdsName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the category adses where categoryAdsName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param categoryAdsName the category ads name
	* @param start the lower bound of the range of category adses
	* @param end the upper bound of the range of category adses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching category adses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<irestads.model.CategoryAds> findByCategoryAdsName(
		java.lang.String categoryAdsName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first category ads in the ordered set where categoryAdsName = &#63;.
	*
	* @param categoryAdsName the category ads name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching category ads
	* @throws irestads.NoSuchCategoryAdsException if a matching category ads could not be found
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.CategoryAds findByCategoryAdsName_First(
		java.lang.String categoryAdsName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchCategoryAdsException;

	/**
	* Returns the first category ads in the ordered set where categoryAdsName = &#63;.
	*
	* @param categoryAdsName the category ads name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching category ads, or <code>null</code> if a matching category ads could not be found
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.CategoryAds fetchByCategoryAdsName_First(
		java.lang.String categoryAdsName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last category ads in the ordered set where categoryAdsName = &#63;.
	*
	* @param categoryAdsName the category ads name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching category ads
	* @throws irestads.NoSuchCategoryAdsException if a matching category ads could not be found
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.CategoryAds findByCategoryAdsName_Last(
		java.lang.String categoryAdsName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchCategoryAdsException;

	/**
	* Returns the last category ads in the ordered set where categoryAdsName = &#63;.
	*
	* @param categoryAdsName the category ads name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching category ads, or <code>null</code> if a matching category ads could not be found
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.CategoryAds fetchByCategoryAdsName_Last(
		java.lang.String categoryAdsName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the category adses before and after the current category ads in the ordered set where categoryAdsName = &#63;.
	*
	* @param categoryAdsId the primary key of the current category ads
	* @param categoryAdsName the category ads name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next category ads
	* @throws irestads.NoSuchCategoryAdsException if a category ads with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.CategoryAds[] findByCategoryAdsName_PrevAndNext(
		long categoryAdsId, java.lang.String categoryAdsName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchCategoryAdsException;

	/**
	* Returns all the category adses.
	*
	* @return the category adses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<irestads.model.CategoryAds> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the category adses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of category adses
	* @param end the upper bound of the range of category adses (not inclusive)
	* @return the range of category adses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<irestads.model.CategoryAds> findAll(int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the category adses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of category adses
	* @param end the upper bound of the range of category adses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of category adses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<irestads.model.CategoryAds> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the category adses where categoryAdsName = &#63; from the database.
	*
	* @param categoryAdsName the category ads name
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCategoryAdsName(java.lang.String categoryAdsName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the category adses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of category adses where categoryAdsName = &#63;.
	*
	* @param categoryAdsName the category ads name
	* @return the number of matching category adses
	* @throws SystemException if a system exception occurred
	*/
	public int countByCategoryAdsName(java.lang.String categoryAdsName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of category adses.
	*
	* @return the number of category adses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the ads items associated with the category ads.
	*
	* @param pk the primary key of the category ads
	* @return the ads items associated with the category ads
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<irestads.model.AdsItem> getAdsItems(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the ads items associated with the category ads.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param pk the primary key of the category ads
	* @param start the lower bound of the range of category adses
	* @param end the upper bound of the range of category adses (not inclusive)
	* @return the range of ads items associated with the category ads
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<irestads.model.AdsItem> getAdsItems(long pk,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the ads items associated with the category ads.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param pk the primary key of the category ads
	* @param start the lower bound of the range of category adses
	* @param end the upper bound of the range of category adses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of ads items associated with the category ads
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<irestads.model.AdsItem> getAdsItems(long pk,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of ads items associated with the category ads.
	*
	* @param pk the primary key of the category ads
	* @return the number of ads items associated with the category ads
	* @throws SystemException if a system exception occurred
	*/
	public int getAdsItemsSize(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns <code>true</code> if the ads item is associated with the category ads.
	*
	* @param pk the primary key of the category ads
	* @param adsItemPK the primary key of the ads item
	* @return <code>true</code> if the ads item is associated with the category ads; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsAdsItem(long pk, long adsItemPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns <code>true</code> if the category ads has any ads items associated with it.
	*
	* @param pk the primary key of the category ads to check for associations with ads items
	* @return <code>true</code> if the category ads has any ads items associated with it; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsAdsItems(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;
}