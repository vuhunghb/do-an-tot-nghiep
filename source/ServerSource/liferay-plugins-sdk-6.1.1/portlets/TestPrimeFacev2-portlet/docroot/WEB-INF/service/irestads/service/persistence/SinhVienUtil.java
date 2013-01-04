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

import irestads.model.SinhVien;

import java.util.List;

/**
 * The persistence utility for the sinh vien service. This utility wraps {@link SinhVienPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ADMIN
 * @see SinhVienPersistence
 * @see SinhVienPersistenceImpl
 * @generated
 */
public class SinhVienUtil {
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
	public static void clearCache(SinhVien sinhVien) {
		getPersistence().clearCache(sinhVien);
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
	public static List<SinhVien> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SinhVien> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SinhVien> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static SinhVien update(SinhVien sinhVien, boolean merge)
		throws SystemException {
		return getPersistence().update(sinhVien, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static SinhVien update(SinhVien sinhVien, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(sinhVien, merge, serviceContext);
	}

	/**
	* Caches the sinh vien in the entity cache if it is enabled.
	*
	* @param sinhVien the sinh vien
	*/
	public static void cacheResult(irestads.model.SinhVien sinhVien) {
		getPersistence().cacheResult(sinhVien);
	}

	/**
	* Caches the sinh viens in the entity cache if it is enabled.
	*
	* @param sinhViens the sinh viens
	*/
	public static void cacheResult(
		java.util.List<irestads.model.SinhVien> sinhViens) {
		getPersistence().cacheResult(sinhViens);
	}

	/**
	* Creates a new sinh vien with the primary key. Does not add the sinh vien to the database.
	*
	* @param sinhVienId the primary key for the new sinh vien
	* @return the new sinh vien
	*/
	public static irestads.model.SinhVien create(long sinhVienId) {
		return getPersistence().create(sinhVienId);
	}

	/**
	* Removes the sinh vien with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param sinhVienId the primary key of the sinh vien
	* @return the sinh vien that was removed
	* @throws irestads.NoSuchSinhVienException if a sinh vien with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.SinhVien remove(long sinhVienId)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchSinhVienException {
		return getPersistence().remove(sinhVienId);
	}

	public static irestads.model.SinhVien updateImpl(
		irestads.model.SinhVien sinhVien, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(sinhVien, merge);
	}

	/**
	* Returns the sinh vien with the primary key or throws a {@link irestads.NoSuchSinhVienException} if it could not be found.
	*
	* @param sinhVienId the primary key of the sinh vien
	* @return the sinh vien
	* @throws irestads.NoSuchSinhVienException if a sinh vien with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.SinhVien findByPrimaryKey(long sinhVienId)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchSinhVienException {
		return getPersistence().findByPrimaryKey(sinhVienId);
	}

	/**
	* Returns the sinh vien with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param sinhVienId the primary key of the sinh vien
	* @return the sinh vien, or <code>null</code> if a sinh vien with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.SinhVien fetchByPrimaryKey(long sinhVienId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(sinhVienId);
	}

	/**
	* Returns all the sinh viens.
	*
	* @return the sinh viens
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<irestads.model.SinhVien> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the sinh viens.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of sinh viens
	* @param end the upper bound of the range of sinh viens (not inclusive)
	* @return the range of sinh viens
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<irestads.model.SinhVien> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the sinh viens.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of sinh viens
	* @param end the upper bound of the range of sinh viens (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of sinh viens
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<irestads.model.SinhVien> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the sinh viens from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of sinh viens.
	*
	* @return the number of sinh viens
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static SinhVienPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SinhVienPersistence)PortletBeanLocatorUtil.locate(irestads.service.ClpSerializer.getServletContextName(),
					SinhVienPersistence.class.getName());

			ReferenceRegistry.registerReference(SinhVienUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(SinhVienPersistence persistence) {
	}

	private static SinhVienPersistence _persistence;
}