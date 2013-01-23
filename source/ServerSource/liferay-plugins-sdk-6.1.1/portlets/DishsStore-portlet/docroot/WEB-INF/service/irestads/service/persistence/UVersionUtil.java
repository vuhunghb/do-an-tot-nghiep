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

import irestads.model.UVersion;

import java.util.List;

/**
 * The persistence utility for the u version service. This utility wraps {@link UVersionPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Be
 * @see UVersionPersistence
 * @see UVersionPersistenceImpl
 * @generated
 */
public class UVersionUtil {
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
	public static void clearCache(UVersion uVersion) {
		getPersistence().clearCache(uVersion);
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
	public static List<UVersion> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<UVersion> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<UVersion> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static UVersion update(UVersion uVersion, boolean merge)
		throws SystemException {
		return getPersistence().update(uVersion, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static UVersion update(UVersion uVersion, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(uVersion, merge, serviceContext);
	}

	/**
	* Caches the u version in the entity cache if it is enabled.
	*
	* @param uVersion the u version
	*/
	public static void cacheResult(irestads.model.UVersion uVersion) {
		getPersistence().cacheResult(uVersion);
	}

	/**
	* Caches the u versions in the entity cache if it is enabled.
	*
	* @param uVersions the u versions
	*/
	public static void cacheResult(
		java.util.List<irestads.model.UVersion> uVersions) {
		getPersistence().cacheResult(uVersions);
	}

	/**
	* Creates a new u version with the primary key. Does not add the u version to the database.
	*
	* @param versionId the primary key for the new u version
	* @return the new u version
	*/
	public static irestads.model.UVersion create(long versionId) {
		return getPersistence().create(versionId);
	}

	/**
	* Removes the u version with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param versionId the primary key of the u version
	* @return the u version that was removed
	* @throws irestads.NoSuchUVersionException if a u version with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.UVersion remove(long versionId)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchUVersionException {
		return getPersistence().remove(versionId);
	}

	public static irestads.model.UVersion updateImpl(
		irestads.model.UVersion uVersion, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(uVersion, merge);
	}

	/**
	* Returns the u version with the primary key or throws a {@link irestads.NoSuchUVersionException} if it could not be found.
	*
	* @param versionId the primary key of the u version
	* @return the u version
	* @throws irestads.NoSuchUVersionException if a u version with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.UVersion findByPrimaryKey(long versionId)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchUVersionException {
		return getPersistence().findByPrimaryKey(versionId);
	}

	/**
	* Returns the u version with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param versionId the primary key of the u version
	* @return the u version, or <code>null</code> if a u version with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.UVersion fetchByPrimaryKey(long versionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(versionId);
	}

	/**
	* Returns all the u versions where logDate = &#63;.
	*
	* @param logDate the log date
	* @return the matching u versions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<irestads.model.UVersion> findByLogDate(
		java.util.Date logDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLogDate(logDate);
	}

	/**
	* Returns a range of all the u versions where logDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param logDate the log date
	* @param start the lower bound of the range of u versions
	* @param end the upper bound of the range of u versions (not inclusive)
	* @return the range of matching u versions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<irestads.model.UVersion> findByLogDate(
		java.util.Date logDate, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLogDate(logDate, start, end);
	}

	/**
	* Returns an ordered range of all the u versions where logDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param logDate the log date
	* @param start the lower bound of the range of u versions
	* @param end the upper bound of the range of u versions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching u versions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<irestads.model.UVersion> findByLogDate(
		java.util.Date logDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLogDate(logDate, start, end, orderByComparator);
	}

	/**
	* Returns the first u version in the ordered set where logDate = &#63;.
	*
	* @param logDate the log date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching u version
	* @throws irestads.NoSuchUVersionException if a matching u version could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.UVersion findByLogDate_First(
		java.util.Date logDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchUVersionException {
		return getPersistence().findByLogDate_First(logDate, orderByComparator);
	}

	/**
	* Returns the first u version in the ordered set where logDate = &#63;.
	*
	* @param logDate the log date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching u version, or <code>null</code> if a matching u version could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.UVersion fetchByLogDate_First(
		java.util.Date logDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByLogDate_First(logDate, orderByComparator);
	}

	/**
	* Returns the last u version in the ordered set where logDate = &#63;.
	*
	* @param logDate the log date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching u version
	* @throws irestads.NoSuchUVersionException if a matching u version could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.UVersion findByLogDate_Last(
		java.util.Date logDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchUVersionException {
		return getPersistence().findByLogDate_Last(logDate, orderByComparator);
	}

	/**
	* Returns the last u version in the ordered set where logDate = &#63;.
	*
	* @param logDate the log date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching u version, or <code>null</code> if a matching u version could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.UVersion fetchByLogDate_Last(
		java.util.Date logDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByLogDate_Last(logDate, orderByComparator);
	}

	/**
	* Returns the u versions before and after the current u version in the ordered set where logDate = &#63;.
	*
	* @param versionId the primary key of the current u version
	* @param logDate the log date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next u version
	* @throws irestads.NoSuchUVersionException if a u version with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.UVersion[] findByLogDate_PrevAndNext(
		long versionId, java.util.Date logDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchUVersionException {
		return getPersistence()
				   .findByLogDate_PrevAndNext(versionId, logDate,
			orderByComparator);
	}

	/**
	* Returns all the u versions.
	*
	* @return the u versions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<irestads.model.UVersion> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the u versions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of u versions
	* @param end the upper bound of the range of u versions (not inclusive)
	* @return the range of u versions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<irestads.model.UVersion> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the u versions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of u versions
	* @param end the upper bound of the range of u versions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of u versions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<irestads.model.UVersion> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the u versions where logDate = &#63; from the database.
	*
	* @param logDate the log date
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByLogDate(java.util.Date logDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByLogDate(logDate);
	}

	/**
	* Removes all the u versions from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of u versions where logDate = &#63;.
	*
	* @param logDate the log date
	* @return the number of matching u versions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByLogDate(java.util.Date logDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByLogDate(logDate);
	}

	/**
	* Returns the number of u versions.
	*
	* @return the number of u versions
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static UVersionPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (UVersionPersistence)PortletBeanLocatorUtil.locate(irestads.service.ClpSerializer.getServletContextName(),
					UVersionPersistence.class.getName());

			ReferenceRegistry.registerReference(UVersionUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(UVersionPersistence persistence) {
	}

	private static UVersionPersistence _persistence;
}