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

import irestads.model.AdsItem;

import java.util.List;

/**
 * The persistence utility for the ads item service. This utility wraps {@link AdsItemPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Be
 * @see AdsItemPersistence
 * @see AdsItemPersistenceImpl
 * @generated
 */
public class AdsItemUtil {
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
	public static void clearCache(AdsItem adsItem) {
		getPersistence().clearCache(adsItem);
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
	public static List<AdsItem> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AdsItem> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AdsItem> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static AdsItem update(AdsItem adsItem, boolean merge)
		throws SystemException {
		return getPersistence().update(adsItem, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static AdsItem update(AdsItem adsItem, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(adsItem, merge, serviceContext);
	}

	/**
	* Caches the ads item in the entity cache if it is enabled.
	*
	* @param adsItem the ads item
	*/
	public static void cacheResult(irestads.model.AdsItem adsItem) {
		getPersistence().cacheResult(adsItem);
	}

	/**
	* Caches the ads items in the entity cache if it is enabled.
	*
	* @param adsItems the ads items
	*/
	public static void cacheResult(
		java.util.List<irestads.model.AdsItem> adsItems) {
		getPersistence().cacheResult(adsItems);
	}

	/**
	* Creates a new ads item with the primary key. Does not add the ads item to the database.
	*
	* @param adsItemId the primary key for the new ads item
	* @return the new ads item
	*/
	public static irestads.model.AdsItem create(long adsItemId) {
		return getPersistence().create(adsItemId);
	}

	/**
	* Removes the ads item with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param adsItemId the primary key of the ads item
	* @return the ads item that was removed
	* @throws irestads.NoSuchAdsItemException if a ads item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.AdsItem remove(long adsItemId)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchAdsItemException {
		return getPersistence().remove(adsItemId);
	}

	public static irestads.model.AdsItem updateImpl(
		irestads.model.AdsItem adsItem, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(adsItem, merge);
	}

	/**
	* Returns the ads item with the primary key or throws a {@link irestads.NoSuchAdsItemException} if it could not be found.
	*
	* @param adsItemId the primary key of the ads item
	* @return the ads item
	* @throws irestads.NoSuchAdsItemException if a ads item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.AdsItem findByPrimaryKey(long adsItemId)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchAdsItemException {
		return getPersistence().findByPrimaryKey(adsItemId);
	}

	/**
	* Returns the ads item with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param adsItemId the primary key of the ads item
	* @return the ads item, or <code>null</code> if a ads item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.AdsItem fetchByPrimaryKey(long adsItemId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(adsItemId);
	}

	/**
	* Returns all the ads items where productName = &#63;.
	*
	* @param productName the product name
	* @return the matching ads items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<irestads.model.AdsItem> findByProductName(
		java.lang.String productName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByProductName(productName);
	}

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
	public static java.util.List<irestads.model.AdsItem> findByProductName(
		java.lang.String productName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByProductName(productName, start, end);
	}

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
	public static java.util.List<irestads.model.AdsItem> findByProductName(
		java.lang.String productName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByProductName(productName, start, end, orderByComparator);
	}

	/**
	* Returns the first ads item in the ordered set where productName = &#63;.
	*
	* @param productName the product name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ads item
	* @throws irestads.NoSuchAdsItemException if a matching ads item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.AdsItem findByProductName_First(
		java.lang.String productName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchAdsItemException {
		return getPersistence()
				   .findByProductName_First(productName, orderByComparator);
	}

	/**
	* Returns the first ads item in the ordered set where productName = &#63;.
	*
	* @param productName the product name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ads item, or <code>null</code> if a matching ads item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.AdsItem fetchByProductName_First(
		java.lang.String productName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByProductName_First(productName, orderByComparator);
	}

	/**
	* Returns the last ads item in the ordered set where productName = &#63;.
	*
	* @param productName the product name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ads item
	* @throws irestads.NoSuchAdsItemException if a matching ads item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.AdsItem findByProductName_Last(
		java.lang.String productName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchAdsItemException {
		return getPersistence()
				   .findByProductName_Last(productName, orderByComparator);
	}

	/**
	* Returns the last ads item in the ordered set where productName = &#63;.
	*
	* @param productName the product name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ads item, or <code>null</code> if a matching ads item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.AdsItem fetchByProductName_Last(
		java.lang.String productName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByProductName_Last(productName, orderByComparator);
	}

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
	public static irestads.model.AdsItem[] findByProductName_PrevAndNext(
		long adsItemId, java.lang.String productName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchAdsItemException {
		return getPersistence()
				   .findByProductName_PrevAndNext(adsItemId, productName,
			orderByComparator);
	}

	/**
	* Returns all the ads items where timeDuring = &#63;.
	*
	* @param timeDuring the time during
	* @return the matching ads items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<irestads.model.AdsItem> findByTimeDuring(
		int timeDuring)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTimeDuring(timeDuring);
	}

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
	public static java.util.List<irestads.model.AdsItem> findByTimeDuring(
		int timeDuring, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTimeDuring(timeDuring, start, end);
	}

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
	public static java.util.List<irestads.model.AdsItem> findByTimeDuring(
		int timeDuring, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTimeDuring(timeDuring, start, end, orderByComparator);
	}

	/**
	* Returns the first ads item in the ordered set where timeDuring = &#63;.
	*
	* @param timeDuring the time during
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ads item
	* @throws irestads.NoSuchAdsItemException if a matching ads item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.AdsItem findByTimeDuring_First(
		int timeDuring,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchAdsItemException {
		return getPersistence()
				   .findByTimeDuring_First(timeDuring, orderByComparator);
	}

	/**
	* Returns the first ads item in the ordered set where timeDuring = &#63;.
	*
	* @param timeDuring the time during
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ads item, or <code>null</code> if a matching ads item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.AdsItem fetchByTimeDuring_First(
		int timeDuring,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTimeDuring_First(timeDuring, orderByComparator);
	}

	/**
	* Returns the last ads item in the ordered set where timeDuring = &#63;.
	*
	* @param timeDuring the time during
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ads item
	* @throws irestads.NoSuchAdsItemException if a matching ads item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.AdsItem findByTimeDuring_Last(int timeDuring,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchAdsItemException {
		return getPersistence()
				   .findByTimeDuring_Last(timeDuring, orderByComparator);
	}

	/**
	* Returns the last ads item in the ordered set where timeDuring = &#63;.
	*
	* @param timeDuring the time during
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ads item, or <code>null</code> if a matching ads item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.AdsItem fetchByTimeDuring_Last(
		int timeDuring,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTimeDuring_Last(timeDuring, orderByComparator);
	}

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
	public static irestads.model.AdsItem[] findByTimeDuring_PrevAndNext(
		long adsItemId, int timeDuring,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchAdsItemException {
		return getPersistence()
				   .findByTimeDuring_PrevAndNext(adsItemId, timeDuring,
			orderByComparator);
	}

	/**
	* Returns all the ads items.
	*
	* @return the ads items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<irestads.model.AdsItem> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<irestads.model.AdsItem> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<irestads.model.AdsItem> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the ads items where productName = &#63; from the database.
	*
	* @param productName the product name
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByProductName(java.lang.String productName)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByProductName(productName);
	}

	/**
	* Removes all the ads items where timeDuring = &#63; from the database.
	*
	* @param timeDuring the time during
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTimeDuring(int timeDuring)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTimeDuring(timeDuring);
	}

	/**
	* Removes all the ads items from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of ads items where productName = &#63;.
	*
	* @param productName the product name
	* @return the number of matching ads items
	* @throws SystemException if a system exception occurred
	*/
	public static int countByProductName(java.lang.String productName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByProductName(productName);
	}

	/**
	* Returns the number of ads items where timeDuring = &#63;.
	*
	* @param timeDuring the time during
	* @return the number of matching ads items
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTimeDuring(int timeDuring)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTimeDuring(timeDuring);
	}

	/**
	* Returns the number of ads items.
	*
	* @return the number of ads items
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static AdsItemPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (AdsItemPersistence)PortletBeanLocatorUtil.locate(irestads.service.ClpSerializer.getServletContextName(),
					AdsItemPersistence.class.getName());

			ReferenceRegistry.registerReference(AdsItemUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(AdsItemPersistence persistence) {
	}

	private static AdsItemPersistence _persistence;
}