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

import irestads.model.SinhVien;

/**
 * The persistence interface for the sinh vien service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ADMIN
 * @see SinhVienPersistenceImpl
 * @see SinhVienUtil
 * @generated
 */
public interface SinhVienPersistence extends BasePersistence<SinhVien> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SinhVienUtil} to access the sinh vien persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the sinh vien in the entity cache if it is enabled.
	*
	* @param sinhVien the sinh vien
	*/
	public void cacheResult(irestads.model.SinhVien sinhVien);

	/**
	* Caches the sinh viens in the entity cache if it is enabled.
	*
	* @param sinhViens the sinh viens
	*/
	public void cacheResult(java.util.List<irestads.model.SinhVien> sinhViens);

	/**
	* Creates a new sinh vien with the primary key. Does not add the sinh vien to the database.
	*
	* @param sinhVienId the primary key for the new sinh vien
	* @return the new sinh vien
	*/
	public irestads.model.SinhVien create(long sinhVienId);

	/**
	* Removes the sinh vien with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param sinhVienId the primary key of the sinh vien
	* @return the sinh vien that was removed
	* @throws irestads.NoSuchSinhVienException if a sinh vien with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.SinhVien remove(long sinhVienId)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchSinhVienException;

	public irestads.model.SinhVien updateImpl(
		irestads.model.SinhVien sinhVien, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the sinh vien with the primary key or throws a {@link irestads.NoSuchSinhVienException} if it could not be found.
	*
	* @param sinhVienId the primary key of the sinh vien
	* @return the sinh vien
	* @throws irestads.NoSuchSinhVienException if a sinh vien with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.SinhVien findByPrimaryKey(long sinhVienId)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchSinhVienException;

	/**
	* Returns the sinh vien with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param sinhVienId the primary key of the sinh vien
	* @return the sinh vien, or <code>null</code> if a sinh vien with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.SinhVien fetchByPrimaryKey(long sinhVienId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the sinh viens.
	*
	* @return the sinh viens
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<irestads.model.SinhVien> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<irestads.model.SinhVien> findAll(int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<irestads.model.SinhVien> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the sinh viens from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of sinh viens.
	*
	* @return the number of sinh viens
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}