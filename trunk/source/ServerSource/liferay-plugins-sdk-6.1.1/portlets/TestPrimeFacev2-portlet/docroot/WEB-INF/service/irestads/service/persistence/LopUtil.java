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

import irestads.model.Lop;

import java.util.List;

/**
 * The persistence utility for the lop service. This utility wraps {@link LopPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ADMIN
 * @see LopPersistence
 * @see LopPersistenceImpl
 * @generated
 */
public class LopUtil {
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
	public static void clearCache(Lop lop) {
		getPersistence().clearCache(lop);
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
	public static List<Lop> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Lop> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Lop> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Lop update(Lop lop, boolean merge) throws SystemException {
		return getPersistence().update(lop, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Lop update(Lop lop, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(lop, merge, serviceContext);
	}

	/**
	* Caches the lop in the entity cache if it is enabled.
	*
	* @param lop the lop
	*/
	public static void cacheResult(irestads.model.Lop lop) {
		getPersistence().cacheResult(lop);
	}

	/**
	* Caches the lops in the entity cache if it is enabled.
	*
	* @param lops the lops
	*/
	public static void cacheResult(java.util.List<irestads.model.Lop> lops) {
		getPersistence().cacheResult(lops);
	}

	/**
	* Creates a new lop with the primary key. Does not add the lop to the database.
	*
	* @param lopId the primary key for the new lop
	* @return the new lop
	*/
	public static irestads.model.Lop create(long lopId) {
		return getPersistence().create(lopId);
	}

	/**
	* Removes the lop with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param lopId the primary key of the lop
	* @return the lop that was removed
	* @throws irestads.NoSuchLopException if a lop with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.Lop remove(long lopId)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchLopException {
		return getPersistence().remove(lopId);
	}

	public static irestads.model.Lop updateImpl(irestads.model.Lop lop,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(lop, merge);
	}

	/**
	* Returns the lop with the primary key or throws a {@link irestads.NoSuchLopException} if it could not be found.
	*
	* @param lopId the primary key of the lop
	* @return the lop
	* @throws irestads.NoSuchLopException if a lop with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.Lop findByPrimaryKey(long lopId)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchLopException {
		return getPersistence().findByPrimaryKey(lopId);
	}

	/**
	* Returns the lop with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param lopId the primary key of the lop
	* @return the lop, or <code>null</code> if a lop with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.Lop fetchByPrimaryKey(long lopId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(lopId);
	}

	/**
	* Returns all the lops.
	*
	* @return the lops
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<irestads.model.Lop> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the lops.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of lops
	* @param end the upper bound of the range of lops (not inclusive)
	* @return the range of lops
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<irestads.model.Lop> findAll(int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the lops.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of lops
	* @param end the upper bound of the range of lops (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of lops
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<irestads.model.Lop> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the lops from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of lops.
	*
	* @return the number of lops
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	/**
	* Returns all the sinh viens associated with the lop.
	*
	* @param pk the primary key of the lop
	* @return the sinh viens associated with the lop
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<irestads.model.SinhVien> getSinhViens(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getSinhViens(pk);
	}

	/**
	* Returns a range of all the sinh viens associated with the lop.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param pk the primary key of the lop
	* @param start the lower bound of the range of lops
	* @param end the upper bound of the range of lops (not inclusive)
	* @return the range of sinh viens associated with the lop
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<irestads.model.SinhVien> getSinhViens(
		long pk, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getSinhViens(pk, start, end);
	}

	/**
	* Returns an ordered range of all the sinh viens associated with the lop.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param pk the primary key of the lop
	* @param start the lower bound of the range of lops
	* @param end the upper bound of the range of lops (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of sinh viens associated with the lop
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<irestads.model.SinhVien> getSinhViens(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getSinhViens(pk, start, end, orderByComparator);
	}

	/**
	* Returns the number of sinh viens associated with the lop.
	*
	* @param pk the primary key of the lop
	* @return the number of sinh viens associated with the lop
	* @throws SystemException if a system exception occurred
	*/
	public static int getSinhViensSize(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getSinhViensSize(pk);
	}

	/**
	* Returns <code>true</code> if the sinh vien is associated with the lop.
	*
	* @param pk the primary key of the lop
	* @param sinhVienPK the primary key of the sinh vien
	* @return <code>true</code> if the sinh vien is associated with the lop; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public static boolean containsSinhVien(long pk, long sinhVienPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().containsSinhVien(pk, sinhVienPK);
	}

	/**
	* Returns <code>true</code> if the lop has any sinh viens associated with it.
	*
	* @param pk the primary key of the lop to check for associations with sinh viens
	* @return <code>true</code> if the lop has any sinh viens associated with it; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public static boolean containsSinhViens(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().containsSinhViens(pk);
	}

	public static LopPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (LopPersistence)PortletBeanLocatorUtil.locate(irestads.service.ClpSerializer.getServletContextName(),
					LopPersistence.class.getName());

			ReferenceRegistry.registerReference(LopUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(LopPersistence persistence) {
	}

	private static LopPersistence _persistence;
}