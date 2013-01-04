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

import irestads.model.TestEntity;

/**
 * The persistence interface for the test entity service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ADMIN
 * @see TestEntityPersistenceImpl
 * @see TestEntityUtil
 * @generated
 */
public interface TestEntityPersistence extends BasePersistence<TestEntity> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TestEntityUtil} to access the test entity persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the test entity in the entity cache if it is enabled.
	*
	* @param testEntity the test entity
	*/
	public void cacheResult(irestads.model.TestEntity testEntity);

	/**
	* Caches the test entities in the entity cache if it is enabled.
	*
	* @param testEntities the test entities
	*/
	public void cacheResult(
		java.util.List<irestads.model.TestEntity> testEntities);

	/**
	* Creates a new test entity with the primary key. Does not add the test entity to the database.
	*
	* @param entityId the primary key for the new test entity
	* @return the new test entity
	*/
	public irestads.model.TestEntity create(long entityId);

	/**
	* Removes the test entity with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param entityId the primary key of the test entity
	* @return the test entity that was removed
	* @throws irestads.NoSuchTestEntityException if a test entity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.TestEntity remove(long entityId)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchTestEntityException;

	public irestads.model.TestEntity updateImpl(
		irestads.model.TestEntity testEntity, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the test entity with the primary key or throws a {@link irestads.NoSuchTestEntityException} if it could not be found.
	*
	* @param entityId the primary key of the test entity
	* @return the test entity
	* @throws irestads.NoSuchTestEntityException if a test entity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.TestEntity findByPrimaryKey(long entityId)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchTestEntityException;

	/**
	* Returns the test entity with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param entityId the primary key of the test entity
	* @return the test entity, or <code>null</code> if a test entity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.TestEntity fetchByPrimaryKey(long entityId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the test entities where name = &#63;.
	*
	* @param name the name
	* @return the matching test entities
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<irestads.model.TestEntity> findByName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the test entities where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param name the name
	* @param start the lower bound of the range of test entities
	* @param end the upper bound of the range of test entities (not inclusive)
	* @return the range of matching test entities
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<irestads.model.TestEntity> findByName(
		java.lang.String name, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the test entities where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param name the name
	* @param start the lower bound of the range of test entities
	* @param end the upper bound of the range of test entities (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching test entities
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<irestads.model.TestEntity> findByName(
		java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first test entity in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching test entity
	* @throws irestads.NoSuchTestEntityException if a matching test entity could not be found
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.TestEntity findByName_First(java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchTestEntityException;

	/**
	* Returns the first test entity in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching test entity, or <code>null</code> if a matching test entity could not be found
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.TestEntity fetchByName_First(java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last test entity in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching test entity
	* @throws irestads.NoSuchTestEntityException if a matching test entity could not be found
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.TestEntity findByName_Last(java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchTestEntityException;

	/**
	* Returns the last test entity in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching test entity, or <code>null</code> if a matching test entity could not be found
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.TestEntity fetchByName_Last(java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the test entities before and after the current test entity in the ordered set where name = &#63;.
	*
	* @param entityId the primary key of the current test entity
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next test entity
	* @throws irestads.NoSuchTestEntityException if a test entity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.TestEntity[] findByName_PrevAndNext(long entityId,
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchTestEntityException;

	/**
	* Returns all the test entities.
	*
	* @return the test entities
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<irestads.model.TestEntity> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the test entities.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of test entities
	* @param end the upper bound of the range of test entities (not inclusive)
	* @return the range of test entities
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<irestads.model.TestEntity> findAll(int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the test entities.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of test entities
	* @param end the upper bound of the range of test entities (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of test entities
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<irestads.model.TestEntity> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the test entities where name = &#63; from the database.
	*
	* @param name the name
	* @throws SystemException if a system exception occurred
	*/
	public void removeByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the test entities from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of test entities where name = &#63;.
	*
	* @param name the name
	* @return the number of matching test entities
	* @throws SystemException if a system exception occurred
	*/
	public int countByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of test entities.
	*
	* @return the number of test entities
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}