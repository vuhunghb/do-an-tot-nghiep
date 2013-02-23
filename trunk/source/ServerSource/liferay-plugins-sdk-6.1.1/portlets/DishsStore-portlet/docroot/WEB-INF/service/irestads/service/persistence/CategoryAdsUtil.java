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

import irestads.model.CategoryAds;

import java.util.List;

/**
 * The persistence utility for the category ads service. This utility wraps {@link CategoryAdsPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Be
 * @see CategoryAdsPersistence
 * @see CategoryAdsPersistenceImpl
 * @generated
 */
public class CategoryAdsUtil {
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
	public static void clearCache(CategoryAds categoryAds) {
		getPersistence().clearCache(categoryAds);
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
	public static List<CategoryAds> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CategoryAds> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CategoryAds> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static CategoryAds update(CategoryAds categoryAds, boolean merge)
		throws SystemException {
		return getPersistence().update(categoryAds, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static CategoryAds update(CategoryAds categoryAds, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(categoryAds, merge, serviceContext);
	}

	/**
	* Caches the category ads in the entity cache if it is enabled.
	*
	* @param categoryAds the category ads
	*/
	public static void cacheResult(irestads.model.CategoryAds categoryAds) {
		getPersistence().cacheResult(categoryAds);
	}

	/**
	* Caches the category adses in the entity cache if it is enabled.
	*
	* @param categoryAdses the category adses
	*/
	public static void cacheResult(
		java.util.List<irestads.model.CategoryAds> categoryAdses) {
		getPersistence().cacheResult(categoryAdses);
	}

	/**
	* Creates a new category ads with the primary key. Does not add the category ads to the database.
	*
	* @param categoryAdsId the primary key for the new category ads
	* @return the new category ads
	*/
	public static irestads.model.CategoryAds create(long categoryAdsId) {
		return getPersistence().create(categoryAdsId);
	}

	/**
	* Removes the category ads with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param categoryAdsId the primary key of the category ads
	* @return the category ads that was removed
	* @throws irestads.NoSuchCategoryAdsException if a category ads with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.CategoryAds remove(long categoryAdsId)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchCategoryAdsException {
		return getPersistence().remove(categoryAdsId);
	}

	public static irestads.model.CategoryAds updateImpl(
		irestads.model.CategoryAds categoryAds, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(categoryAds, merge);
	}

	/**
	* Returns the category ads with the primary key or throws a {@link irestads.NoSuchCategoryAdsException} if it could not be found.
	*
	* @param categoryAdsId the primary key of the category ads
	* @return the category ads
	* @throws irestads.NoSuchCategoryAdsException if a category ads with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.CategoryAds findByPrimaryKey(
		long categoryAdsId)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchCategoryAdsException {
		return getPersistence().findByPrimaryKey(categoryAdsId);
	}

	/**
	* Returns the category ads with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param categoryAdsId the primary key of the category ads
	* @return the category ads, or <code>null</code> if a category ads with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.CategoryAds fetchByPrimaryKey(
		long categoryAdsId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(categoryAdsId);
	}

	/**
	* Returns all the category adses where categoryAdsName = &#63;.
	*
	* @param categoryAdsName the category ads name
	* @return the matching category adses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<irestads.model.CategoryAds> findByCategoryAdsName(
		java.lang.String categoryAdsName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCategoryAdsName(categoryAdsName);
	}

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
	public static java.util.List<irestads.model.CategoryAds> findByCategoryAdsName(
		java.lang.String categoryAdsName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCategoryAdsName(categoryAdsName, start, end);
	}

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
	public static java.util.List<irestads.model.CategoryAds> findByCategoryAdsName(
		java.lang.String categoryAdsName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCategoryAdsName(categoryAdsName, start, end,
			orderByComparator);
	}

	/**
	* Returns the first category ads in the ordered set where categoryAdsName = &#63;.
	*
	* @param categoryAdsName the category ads name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching category ads
	* @throws irestads.NoSuchCategoryAdsException if a matching category ads could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.CategoryAds findByCategoryAdsName_First(
		java.lang.String categoryAdsName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchCategoryAdsException {
		return getPersistence()
				   .findByCategoryAdsName_First(categoryAdsName,
			orderByComparator);
	}

	/**
	* Returns the first category ads in the ordered set where categoryAdsName = &#63;.
	*
	* @param categoryAdsName the category ads name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching category ads, or <code>null</code> if a matching category ads could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.CategoryAds fetchByCategoryAdsName_First(
		java.lang.String categoryAdsName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCategoryAdsName_First(categoryAdsName,
			orderByComparator);
	}

	/**
	* Returns the last category ads in the ordered set where categoryAdsName = &#63;.
	*
	* @param categoryAdsName the category ads name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching category ads
	* @throws irestads.NoSuchCategoryAdsException if a matching category ads could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.CategoryAds findByCategoryAdsName_Last(
		java.lang.String categoryAdsName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchCategoryAdsException {
		return getPersistence()
				   .findByCategoryAdsName_Last(categoryAdsName,
			orderByComparator);
	}

	/**
	* Returns the last category ads in the ordered set where categoryAdsName = &#63;.
	*
	* @param categoryAdsName the category ads name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching category ads, or <code>null</code> if a matching category ads could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.CategoryAds fetchByCategoryAdsName_Last(
		java.lang.String categoryAdsName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCategoryAdsName_Last(categoryAdsName,
			orderByComparator);
	}

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
	public static irestads.model.CategoryAds[] findByCategoryAdsName_PrevAndNext(
		long categoryAdsId, java.lang.String categoryAdsName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchCategoryAdsException {
		return getPersistence()
				   .findByCategoryAdsName_PrevAndNext(categoryAdsId,
			categoryAdsName, orderByComparator);
	}

	/**
	* Returns all the category adses.
	*
	* @return the category adses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<irestads.model.CategoryAds> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<irestads.model.CategoryAds> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<irestads.model.CategoryAds> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the category adses where categoryAdsName = &#63; from the database.
	*
	* @param categoryAdsName the category ads name
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCategoryAdsName(java.lang.String categoryAdsName)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCategoryAdsName(categoryAdsName);
	}

	/**
	* Removes all the category adses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of category adses where categoryAdsName = &#63;.
	*
	* @param categoryAdsName the category ads name
	* @return the number of matching category adses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCategoryAdsName(java.lang.String categoryAdsName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCategoryAdsName(categoryAdsName);
	}

	/**
	* Returns the number of category adses.
	*
	* @return the number of category adses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	/**
	* Returns all the ads items associated with the category ads.
	*
	* @param pk the primary key of the category ads
	* @return the ads items associated with the category ads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<irestads.model.AdsItem> getAdsItems(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getAdsItems(pk);
	}

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
	public static java.util.List<irestads.model.AdsItem> getAdsItems(long pk,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getAdsItems(pk, start, end);
	}

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
	public static java.util.List<irestads.model.AdsItem> getAdsItems(long pk,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getAdsItems(pk, start, end, orderByComparator);
	}

	/**
	* Returns the number of ads items associated with the category ads.
	*
	* @param pk the primary key of the category ads
	* @return the number of ads items associated with the category ads
	* @throws SystemException if a system exception occurred
	*/
	public static int getAdsItemsSize(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getAdsItemsSize(pk);
	}

	/**
	* Returns <code>true</code> if the ads item is associated with the category ads.
	*
	* @param pk the primary key of the category ads
	* @param adsItemPK the primary key of the ads item
	* @return <code>true</code> if the ads item is associated with the category ads; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public static boolean containsAdsItem(long pk, long adsItemPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().containsAdsItem(pk, adsItemPK);
	}

	/**
	* Returns <code>true</code> if the category ads has any ads items associated with it.
	*
	* @param pk the primary key of the category ads to check for associations with ads items
	* @return <code>true</code> if the category ads has any ads items associated with it; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public static boolean containsAdsItems(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().containsAdsItems(pk);
	}

	public static CategoryAdsPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (CategoryAdsPersistence)PortletBeanLocatorUtil.locate(irestads.service.ClpSerializer.getServletContextName(),
					CategoryAdsPersistence.class.getName());

			ReferenceRegistry.registerReference(CategoryAdsUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(CategoryAdsPersistence persistence) {
	}

	private static CategoryAdsPersistence _persistence;
}