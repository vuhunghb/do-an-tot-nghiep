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

import irestads.model.Lop;

/**
 * The persistence interface for the lop service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ADMIN
 * @see LopPersistenceImpl
 * @see LopUtil
 * @generated
 */
public interface LopPersistence extends BasePersistence<Lop> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LopUtil} to access the lop persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the lop in the entity cache if it is enabled.
	*
	* @param lop the lop
	*/
	public void cacheResult(irestads.model.Lop lop);

	/**
	* Caches the lops in the entity cache if it is enabled.
	*
	* @param lops the lops
	*/
	public void cacheResult(java.util.List<irestads.model.Lop> lops);

	/**
	* Creates a new lop with the primary key. Does not add the lop to the database.
	*
	* @param lopId the primary key for the new lop
	* @return the new lop
	*/
	public irestads.model.Lop create(long lopId);

	/**
	* Removes the lop with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param lopId the primary key of the lop
	* @return the lop that was removed
	* @throws irestads.NoSuchLopException if a lop with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.Lop remove(long lopId)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchLopException;

	public irestads.model.Lop updateImpl(irestads.model.Lop lop, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the lop with the primary key or throws a {@link irestads.NoSuchLopException} if it could not be found.
	*
	* @param lopId the primary key of the lop
	* @return the lop
	* @throws irestads.NoSuchLopException if a lop with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.Lop findByPrimaryKey(long lopId)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchLopException;

	/**
	* Returns the lop with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param lopId the primary key of the lop
	* @return the lop, or <code>null</code> if a lop with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.Lop fetchByPrimaryKey(long lopId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the lops.
	*
	* @return the lops
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<irestads.model.Lop> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<irestads.model.Lop> findAll(int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<irestads.model.Lop> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the lops from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of lops.
	*
	* @return the number of lops
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the sinh viens associated with the lop.
	*
	* @param pk the primary key of the lop
	* @return the sinh viens associated with the lop
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<irestads.model.SinhVien> getSinhViens(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<irestads.model.SinhVien> getSinhViens(long pk,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<irestads.model.SinhVien> getSinhViens(long pk,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of sinh viens associated with the lop.
	*
	* @param pk the primary key of the lop
	* @return the number of sinh viens associated with the lop
	* @throws SystemException if a system exception occurred
	*/
	public int getSinhViensSize(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns <code>true</code> if the sinh vien is associated with the lop.
	*
	* @param pk the primary key of the lop
	* @param sinhVienPK the primary key of the sinh vien
	* @return <code>true</code> if the sinh vien is associated with the lop; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsSinhVien(long pk, long sinhVienPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns <code>true</code> if the lop has any sinh viens associated with it.
	*
	* @param pk the primary key of the lop to check for associations with sinh viens
	* @return <code>true</code> if the lop has any sinh viens associated with it; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsSinhViens(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;
}