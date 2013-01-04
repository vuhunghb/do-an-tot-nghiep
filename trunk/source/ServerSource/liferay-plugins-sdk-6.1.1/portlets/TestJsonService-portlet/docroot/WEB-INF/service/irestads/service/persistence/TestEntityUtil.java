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

import irestads.model.TestEntity;

import java.util.List;

/**
 * The persistence utility for the test entity service. This utility wraps {@link TestEntityPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ADMIN
 * @see TestEntityPersistence
 * @see TestEntityPersistenceImpl
 * @generated
 */
public class TestEntityUtil {
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
	public static void clearCache(TestEntity testEntity) {
		getPersistence().clearCache(testEntity);
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
	public static List<TestEntity> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TestEntity> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TestEntity> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static TestEntity update(TestEntity testEntity, boolean merge)
		throws SystemException {
		return getPersistence().update(testEntity, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static TestEntity update(TestEntity testEntity, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(testEntity, merge, serviceContext);
	}

	/**
	* Caches the test entity in the entity cache if it is enabled.
	*
	* @param testEntity the test entity
	*/
	public static void cacheResult(irestads.model.TestEntity testEntity) {
		getPersistence().cacheResult(testEntity);
	}

	/**
	* Caches the test entities in the entity cache if it is enabled.
	*
	* @param testEntities the test entities
	*/
	public static void cacheResult(
		java.util.List<irestads.model.TestEntity> testEntities) {
		getPersistence().cacheResult(testEntities);
	}

	/**
	* Creates a new test entity with the primary key. Does not add the test entity to the database.
	*
	* @param entityId the primary key for the new test entity
	* @return the new test entity
	*/
	public static irestads.model.TestEntity create(long entityId) {
		return getPersistence().create(entityId);
	}

	/**
	* Removes the test entity with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param entityId the primary key of the test entity
	* @return the test entity that was removed
	* @throws irestads.NoSuchTestEntityException if a test entity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.TestEntity remove(long entityId)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchTestEntityException {
		return getPersistence().remove(entityId);
	}

	public static irestads.model.TestEntity updateImpl(
		irestads.model.TestEntity testEntity, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(testEntity, merge);
	}

	/**
	* Returns the test entity with the primary key or throws a {@link irestads.NoSuchTestEntityException} if it could not be found.
	*
	* @param entityId the primary key of the test entity
	* @return the test entity
	* @throws irestads.NoSuchTestEntityException if a test entity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.TestEntity findByPrimaryKey(long entityId)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchTestEntityException {
		return getPersistence().findByPrimaryKey(entityId);
	}

	/**
	* Returns the test entity with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param entityId the primary key of the test entity
	* @return the test entity, or <code>null</code> if a test entity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.TestEntity fetchByPrimaryKey(long entityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(entityId);
	}

	/**
	* Returns all the test entities where name = &#63;.
	*
	* @param name the name
	* @return the matching test entities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<irestads.model.TestEntity> findByName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByName(name);
	}

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
	public static java.util.List<irestads.model.TestEntity> findByName(
		java.lang.String name, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByName(name, start, end);
	}

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
	public static java.util.List<irestads.model.TestEntity> findByName(
		java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByName(name, start, end, orderByComparator);
	}

	/**
	* Returns the first test entity in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching test entity
	* @throws irestads.NoSuchTestEntityException if a matching test entity could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.TestEntity findByName_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchTestEntityException {
		return getPersistence().findByName_First(name, orderByComparator);
	}

	/**
	* Returns the first test entity in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching test entity, or <code>null</code> if a matching test entity could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.TestEntity fetchByName_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByName_First(name, orderByComparator);
	}

	/**
	* Returns the last test entity in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching test entity
	* @throws irestads.NoSuchTestEntityException if a matching test entity could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.TestEntity findByName_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchTestEntityException {
		return getPersistence().findByName_Last(name, orderByComparator);
	}

	/**
	* Returns the last test entity in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching test entity, or <code>null</code> if a matching test entity could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.TestEntity fetchByName_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByName_Last(name, orderByComparator);
	}

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
	public static irestads.model.TestEntity[] findByName_PrevAndNext(
		long entityId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			irestads.NoSuchTestEntityException {
		return getPersistence()
				   .findByName_PrevAndNext(entityId, name, orderByComparator);
	}

	/**
	* Returns all the test entities.
	*
	* @return the test entities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<irestads.model.TestEntity> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<irestads.model.TestEntity> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<irestads.model.TestEntity> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the test entities where name = &#63; from the database.
	*
	* @param name the name
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByName(name);
	}

	/**
	* Removes all the test entities from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of test entities where name = &#63;.
	*
	* @param name the name
	* @return the number of matching test entities
	* @throws SystemException if a system exception occurred
	*/
	public static int countByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByName(name);
	}

	/**
	* Returns the number of test entities.
	*
	* @return the number of test entities
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static TestEntityPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (TestEntityPersistence)PortletBeanLocatorUtil.locate(irestads.service.ClpSerializer.getServletContextName(),
					TestEntityPersistence.class.getName());

			ReferenceRegistry.registerReference(TestEntityUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(TestEntityPersistence persistence) {
	}

	private static TestEntityPersistence _persistence;
}