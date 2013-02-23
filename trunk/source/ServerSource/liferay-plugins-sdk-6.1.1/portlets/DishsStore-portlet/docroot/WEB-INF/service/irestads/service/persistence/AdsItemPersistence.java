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

import irestads.model.AdsItem;

/**
 * The persistence interface for the ads item service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Be
 * @see AdsItemPersistenceImpl
 * @see AdsItemUtil
 * @generated
 */
public interface AdsItemPersistence extends BasePersistence<AdsItem> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AdsItemUtil} to access the ads item persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the ads item in the entity cache if it is enabled.
	*
	* @param adsItem the ads item
	*/
	public void cacheResult(irestads.model.AdsItem adsItem);

	/**
	* Caches the ads items in the entity cache if it is enabled.
	*
	* @param adsItems the ads items
	*/
	public void cacheResult(java.util.List<irestads.model.AdsItem> adsItems);

	/**
	* Creates a new ads item with the primary key. Does not add the ads item to the database.
	*
	* @param adsItemId the primary key for the new ads item
	* @return the new ads item
	*/
	public irestads.model.AdsItem create(long adsItemId);

	/**
	* Removes the ads item with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param adsItemId the primary key of the ads item
	* @return the ads item that was removed
	* @throws irestads.NoSuchAdsItemException if a ads item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.AdsItem remove(long adsItemId)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchAdsItemException;

	public irestads.model.AdsItem updateImpl(irestads.model.AdsItem adsItem,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the ads item with the primary key or throws a {@link irestads.NoSuchAdsItemException} if it could not be found.
	*
	* @param adsItemId the primary key of the ads item
	* @return the ads item
	* @throws irestads.NoSuchAdsItemException if a ads item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.AdsItem findByPrimaryKey(long adsItemId)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchAdsItemException;

	/**
	* Returns the ads item with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param adsItemId the primary key of the ads item
	* @return the ads item, or <code>null</code> if a ads item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.AdsItem fetchByPrimaryKey(long adsItemId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the ads items where productName = &#63;.
	*
	* @param productName the product name
	* @return the matching ads items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<irestads.model.AdsItem> findByProductName(
		java.lang.String productName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the ads items where productName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param productName the product name
	* @param start the lower bound of the range of ads items
	* @param end the upper bound of the range of ads items (not inclusive)
	* @return the range of matching ads items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<irestads.model.AdsItem> findByProductName(
		java.lang.String productName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the ads items where productName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param productName the product name
	* @param start the lower bound of the range of ads items
	* @param end the upper bound of the range of ads items (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching ads items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<irestads.model.AdsItem> findByProductName(
		java.lang.String productName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first ads item in the ordered set where productName = &#63;.
	*
	* @param productName the product name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ads item
	* @throws irestads.NoSuchAdsItemException if a matching ads item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.AdsItem findByProductName_First(
		java.lang.String productName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchAdsItemException;

	/**
	* Returns the first ads item in the ordered set where productName = &#63;.
	*
	* @param productName the product name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ads item, or <code>null</code> if a matching ads item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.AdsItem fetchByProductName_First(
		java.lang.String productName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last ads item in the ordered set where productName = &#63;.
	*
	* @param productName the product name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ads item
	* @throws irestads.NoSuchAdsItemException if a matching ads item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.AdsItem findByProductName_Last(
		java.lang.String productName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchAdsItemException;

	/**
	* Returns the last ads item in the ordered set where productName = &#63;.
	*
	* @param productName the product name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ads item, or <code>null</code> if a matching ads item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.AdsItem fetchByProductName_Last(
		java.lang.String productName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the ads items before and after the current ads item in the ordered set where productName = &#63;.
	*
	* @param adsItemId the primary key of the current ads item
	* @param productName the product name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next ads item
	* @throws irestads.NoSuchAdsItemException if a ads item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.AdsItem[] findByProductName_PrevAndNext(
		long adsItemId, java.lang.String productName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchAdsItemException;

	/**
	* Returns all the ads items where timeDuring = &#63;.
	*
	* @param timeDuring the time during
	* @return the matching ads items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<irestads.model.AdsItem> findByTimeDuring(
		int timeDuring)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the ads items where timeDuring = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param timeDuring the time during
	* @param start the lower bound of the range of ads items
	* @param end the upper bound of the range of ads items (not inclusive)
	* @return the range of matching ads items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<irestads.model.AdsItem> findByTimeDuring(
		int timeDuring, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the ads items where timeDuring = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param timeDuring the time during
	* @param start the lower bound of the range of ads items
	* @param end the upper bound of the range of ads items (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching ads items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<irestads.model.AdsItem> findByTimeDuring(
		int timeDuring, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first ads item in the ordered set where timeDuring = &#63;.
	*
	* @param timeDuring the time during
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ads item
	* @throws irestads.NoSuchAdsItemException if a matching ads item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.AdsItem findByTimeDuring_First(int timeDuring,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchAdsItemException;

	/**
	* Returns the first ads item in the ordered set where timeDuring = &#63;.
	*
	* @param timeDuring the time during
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ads item, or <code>null</code> if a matching ads item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.AdsItem fetchByTimeDuring_First(int timeDuring,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last ads item in the ordered set where timeDuring = &#63;.
	*
	* @param timeDuring the time during
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ads item
	* @throws irestads.NoSuchAdsItemException if a matching ads item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.AdsItem findByTimeDuring_Last(int timeDuring,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchAdsItemException;

	/**
	* Returns the last ads item in the ordered set where timeDuring = &#63;.
	*
	* @param timeDuring the time during
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ads item, or <code>null</code> if a matching ads item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.AdsItem fetchByTimeDuring_Last(int timeDuring,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the ads items before and after the current ads item in the ordered set where timeDuring = &#63;.
	*
	* @param adsItemId the primary key of the current ads item
	* @param timeDuring the time during
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next ads item
	* @throws irestads.NoSuchAdsItemException if a ads item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.AdsItem[] findByTimeDuring_PrevAndNext(
		long adsItemId, int timeDuring,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchAdsItemException;

	/**
	* Returns all the ads items.
	*
	* @return the ads items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<irestads.model.AdsItem> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the ads items.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of ads items
	* @param end the upper bound of the range of ads items (not inclusive)
	* @return the range of ads items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<irestads.model.AdsItem> findAll(int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the ads items.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of ads items
	* @param end the upper bound of the range of ads items (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of ads items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<irestads.model.AdsItem> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the ads items where productName = &#63; from the database.
	*
	* @param productName the product name
	* @throws SystemException if a system exception occurred
	*/
	public void removeByProductName(java.lang.String productName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the ads items where timeDuring = &#63; from the database.
	*
	* @param timeDuring the time during
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTimeDuring(int timeDuring)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the ads items from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of ads items where productName = &#63;.
	*
	* @param productName the product name
	* @return the number of matching ads items
	* @throws SystemException if a system exception occurred
	*/
	public int countByProductName(java.lang.String productName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of ads items where timeDuring = &#63;.
	*
	* @param timeDuring the time during
	* @return the number of matching ads items
	* @throws SystemException if a system exception occurred
	*/
	public int countByTimeDuring(int timeDuring)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of ads items.
	*
	* @return the number of ads items
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}