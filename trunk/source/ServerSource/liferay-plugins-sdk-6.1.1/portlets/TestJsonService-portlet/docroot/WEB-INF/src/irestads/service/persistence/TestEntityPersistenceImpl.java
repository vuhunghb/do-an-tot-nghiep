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

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import irestads.NoSuchTestEntityException;

import irestads.model.TestEntity;

import irestads.model.impl.TestEntityImpl;
import irestads.model.impl.TestEntityModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the test entity service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ADMIN
 * @see TestEntityPersistence
 * @see TestEntityUtil
 * @generated
 */
public class TestEntityPersistenceImpl extends BasePersistenceImpl<TestEntity>
	implements TestEntityPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TestEntityUtil} to access the test entity persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TestEntityImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_NAME = new FinderPath(TestEntityModelImpl.ENTITY_CACHE_ENABLED,
			TestEntityModelImpl.FINDER_CACHE_ENABLED, TestEntityImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByName",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME = new FinderPath(TestEntityModelImpl.ENTITY_CACHE_ENABLED,
			TestEntityModelImpl.FINDER_CACHE_ENABLED, TestEntityImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByName",
			new String[] { String.class.getName() },
			TestEntityModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NAME = new FinderPath(TestEntityModelImpl.ENTITY_CACHE_ENABLED,
			TestEntityModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByName",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TestEntityModelImpl.ENTITY_CACHE_ENABLED,
			TestEntityModelImpl.FINDER_CACHE_ENABLED, TestEntityImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TestEntityModelImpl.ENTITY_CACHE_ENABLED,
			TestEntityModelImpl.FINDER_CACHE_ENABLED, TestEntityImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TestEntityModelImpl.ENTITY_CACHE_ENABLED,
			TestEntityModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the test entity in the entity cache if it is enabled.
	 *
	 * @param testEntity the test entity
	 */
	public void cacheResult(TestEntity testEntity) {
		EntityCacheUtil.putResult(TestEntityModelImpl.ENTITY_CACHE_ENABLED,
			TestEntityImpl.class, testEntity.getPrimaryKey(), testEntity);

		testEntity.resetOriginalValues();
	}

	/**
	 * Caches the test entities in the entity cache if it is enabled.
	 *
	 * @param testEntities the test entities
	 */
	public void cacheResult(List<TestEntity> testEntities) {
		for (TestEntity testEntity : testEntities) {
			if (EntityCacheUtil.getResult(
						TestEntityModelImpl.ENTITY_CACHE_ENABLED,
						TestEntityImpl.class, testEntity.getPrimaryKey()) == null) {
				cacheResult(testEntity);
			}
			else {
				testEntity.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all test entities.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(TestEntityImpl.class.getName());
		}

		EntityCacheUtil.clearCache(TestEntityImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the test entity.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TestEntity testEntity) {
		EntityCacheUtil.removeResult(TestEntityModelImpl.ENTITY_CACHE_ENABLED,
			TestEntityImpl.class, testEntity.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<TestEntity> testEntities) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TestEntity testEntity : testEntities) {
			EntityCacheUtil.removeResult(TestEntityModelImpl.ENTITY_CACHE_ENABLED,
				TestEntityImpl.class, testEntity.getPrimaryKey());
		}
	}

	/**
	 * Creates a new test entity with the primary key. Does not add the test entity to the database.
	 *
	 * @param entityId the primary key for the new test entity
	 * @return the new test entity
	 */
	public TestEntity create(long entityId) {
		TestEntity testEntity = new TestEntityImpl();

		testEntity.setNew(true);
		testEntity.setPrimaryKey(entityId);

		return testEntity;
	}

	/**
	 * Removes the test entity with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param entityId the primary key of the test entity
	 * @return the test entity that was removed
	 * @throws irestads.NoSuchTestEntityException if a test entity with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TestEntity remove(long entityId)
		throws NoSuchTestEntityException, SystemException {
		return remove(Long.valueOf(entityId));
	}

	/**
	 * Removes the test entity with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the test entity
	 * @return the test entity that was removed
	 * @throws irestads.NoSuchTestEntityException if a test entity with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TestEntity remove(Serializable primaryKey)
		throws NoSuchTestEntityException, SystemException {
		Session session = null;

		try {
			session = openSession();

			TestEntity testEntity = (TestEntity)session.get(TestEntityImpl.class,
					primaryKey);

			if (testEntity == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTestEntityException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(testEntity);
		}
		catch (NoSuchTestEntityException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected TestEntity removeImpl(TestEntity testEntity)
		throws SystemException {
		testEntity = toUnwrappedModel(testEntity);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, testEntity);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(testEntity);

		return testEntity;
	}

	@Override
	public TestEntity updateImpl(irestads.model.TestEntity testEntity,
		boolean merge) throws SystemException {
		testEntity = toUnwrappedModel(testEntity);

		boolean isNew = testEntity.isNew();

		TestEntityModelImpl testEntityModelImpl = (TestEntityModelImpl)testEntity;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, testEntity, merge);

			testEntity.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !TestEntityModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((testEntityModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						testEntityModelImpl.getOriginalName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME,
					args);

				args = new Object[] { testEntityModelImpl.getName() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME,
					args);
			}
		}

		EntityCacheUtil.putResult(TestEntityModelImpl.ENTITY_CACHE_ENABLED,
			TestEntityImpl.class, testEntity.getPrimaryKey(), testEntity);

		return testEntity;
	}

	protected TestEntity toUnwrappedModel(TestEntity testEntity) {
		if (testEntity instanceof TestEntityImpl) {
			return testEntity;
		}

		TestEntityImpl testEntityImpl = new TestEntityImpl();

		testEntityImpl.setNew(testEntity.isNew());
		testEntityImpl.setPrimaryKey(testEntity.getPrimaryKey());

		testEntityImpl.setEntityId(testEntity.getEntityId());
		testEntityImpl.setCompanyId(testEntity.getCompanyId());
		testEntityImpl.setUserId(testEntity.getUserId());
		testEntityImpl.setUserName(testEntity.getUserName());
		testEntityImpl.setCreateDate(testEntity.getCreateDate());
		testEntityImpl.setModifiedDate(testEntity.getModifiedDate());
		testEntityImpl.setName(testEntity.getName());
		testEntityImpl.setPass(testEntity.getPass());
		testEntityImpl.setEmail(testEntity.getEmail());
		testEntityImpl.setLoginDate(testEntity.getLoginDate());

		return testEntityImpl;
	}

	/**
	 * Returns the test entity with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the test entity
	 * @return the test entity
	 * @throws com.liferay.portal.NoSuchModelException if a test entity with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TestEntity findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the test entity with the primary key or throws a {@link irestads.NoSuchTestEntityException} if it could not be found.
	 *
	 * @param entityId the primary key of the test entity
	 * @return the test entity
	 * @throws irestads.NoSuchTestEntityException if a test entity with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TestEntity findByPrimaryKey(long entityId)
		throws NoSuchTestEntityException, SystemException {
		TestEntity testEntity = fetchByPrimaryKey(entityId);

		if (testEntity == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + entityId);
			}

			throw new NoSuchTestEntityException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				entityId);
		}

		return testEntity;
	}

	/**
	 * Returns the test entity with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the test entity
	 * @return the test entity, or <code>null</code> if a test entity with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TestEntity fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the test entity with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param entityId the primary key of the test entity
	 * @return the test entity, or <code>null</code> if a test entity with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TestEntity fetchByPrimaryKey(long entityId)
		throws SystemException {
		TestEntity testEntity = (TestEntity)EntityCacheUtil.getResult(TestEntityModelImpl.ENTITY_CACHE_ENABLED,
				TestEntityImpl.class, entityId);

		if (testEntity == _nullTestEntity) {
			return null;
		}

		if (testEntity == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				testEntity = (TestEntity)session.get(TestEntityImpl.class,
						Long.valueOf(entityId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (testEntity != null) {
					cacheResult(testEntity);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(TestEntityModelImpl.ENTITY_CACHE_ENABLED,
						TestEntityImpl.class, entityId, _nullTestEntity);
				}

				closeSession(session);
			}
		}

		return testEntity;
	}

	/**
	 * Returns all the test entities where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching test entities
	 * @throws SystemException if a system exception occurred
	 */
	public List<TestEntity> findByName(String name) throws SystemException {
		return findByName(name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<TestEntity> findByName(String name, int start, int end)
		throws SystemException {
		return findByName(name, start, end, null);
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
	public List<TestEntity> findByName(String name, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME;
			finderArgs = new Object[] { name };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_NAME;
			finderArgs = new Object[] { name, start, end, orderByComparator };
		}

		List<TestEntity> list = (List<TestEntity>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TestEntity testEntity : list) {
				if (!Validator.equals(name, testEntity.getName())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_TESTENTITY_WHERE);

			if (name == null) {
				query.append(_FINDER_COLUMN_NAME_NAME_1);
			}
			else {
				if (name.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_NAME_NAME_3);
				}
				else {
					query.append(_FINDER_COLUMN_NAME_NAME_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(TestEntityModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (name != null) {
					qPos.add(name);
				}

				list = (List<TestEntity>)QueryUtil.list(q, getDialect(), start,
						end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
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
	public TestEntity findByName_First(String name,
		OrderByComparator orderByComparator)
		throws NoSuchTestEntityException, SystemException {
		TestEntity testEntity = fetchByName_First(name, orderByComparator);

		if (testEntity != null) {
			return testEntity;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("name=");
		msg.append(name);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTestEntityException(msg.toString());
	}

	/**
	 * Returns the first test entity in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching test entity, or <code>null</code> if a matching test entity could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TestEntity fetchByName_First(String name,
		OrderByComparator orderByComparator) throws SystemException {
		List<TestEntity> list = findByName(name, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public TestEntity findByName_Last(String name,
		OrderByComparator orderByComparator)
		throws NoSuchTestEntityException, SystemException {
		TestEntity testEntity = fetchByName_Last(name, orderByComparator);

		if (testEntity != null) {
			return testEntity;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("name=");
		msg.append(name);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTestEntityException(msg.toString());
	}

	/**
	 * Returns the last test entity in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching test entity, or <code>null</code> if a matching test entity could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TestEntity fetchByName_Last(String name,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByName(name);

		List<TestEntity> list = findByName(name, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public TestEntity[] findByName_PrevAndNext(long entityId, String name,
		OrderByComparator orderByComparator)
		throws NoSuchTestEntityException, SystemException {
		TestEntity testEntity = findByPrimaryKey(entityId);

		Session session = null;

		try {
			session = openSession();

			TestEntity[] array = new TestEntityImpl[3];

			array[0] = getByName_PrevAndNext(session, testEntity, name,
					orderByComparator, true);

			array[1] = testEntity;

			array[2] = getByName_PrevAndNext(session, testEntity, name,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TestEntity getByName_PrevAndNext(Session session,
		TestEntity testEntity, String name,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TESTENTITY_WHERE);

		if (name == null) {
			query.append(_FINDER_COLUMN_NAME_NAME_1);
		}
		else {
			if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				query.append(_FINDER_COLUMN_NAME_NAME_2);
			}
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(TestEntityModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (name != null) {
			qPos.add(name);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(testEntity);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TestEntity> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the test entities.
	 *
	 * @return the test entities
	 * @throws SystemException if a system exception occurred
	 */
	public List<TestEntity> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<TestEntity> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	public List<TestEntity> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = new Object[] { start, end, orderByComparator };

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<TestEntity> list = (List<TestEntity>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_TESTENTITY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TESTENTITY.concat(TestEntityModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<TestEntity>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<TestEntity>)QueryUtil.list(q, getDialect(),
							start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the test entities where name = &#63; from the database.
	 *
	 * @param name the name
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByName(String name) throws SystemException {
		for (TestEntity testEntity : findByName(name)) {
			remove(testEntity);
		}
	}

	/**
	 * Removes all the test entities from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (TestEntity testEntity : findAll()) {
			remove(testEntity);
		}
	}

	/**
	 * Returns the number of test entities where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching test entities
	 * @throws SystemException if a system exception occurred
	 */
	public int countByName(String name) throws SystemException {
		Object[] finderArgs = new Object[] { name };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_NAME,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TESTENTITY_WHERE);

			if (name == null) {
				query.append(_FINDER_COLUMN_NAME_NAME_1);
			}
			else {
				if (name.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_NAME_NAME_3);
				}
				else {
					query.append(_FINDER_COLUMN_NAME_NAME_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (name != null) {
					qPos.add(name);
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NAME,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of test entities.
	 *
	 * @return the number of test entities
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TESTENTITY);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the test entity persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.irestads.model.TestEntity")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<TestEntity>> listenersList = new ArrayList<ModelListener<TestEntity>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<TestEntity>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(TestEntityImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = TestEntityPersistence.class)
	protected TestEntityPersistence testEntityPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_TESTENTITY = "SELECT testEntity FROM TestEntity testEntity";
	private static final String _SQL_SELECT_TESTENTITY_WHERE = "SELECT testEntity FROM TestEntity testEntity WHERE ";
	private static final String _SQL_COUNT_TESTENTITY = "SELECT COUNT(testEntity) FROM TestEntity testEntity";
	private static final String _SQL_COUNT_TESTENTITY_WHERE = "SELECT COUNT(testEntity) FROM TestEntity testEntity WHERE ";
	private static final String _FINDER_COLUMN_NAME_NAME_1 = "testEntity.name IS NULL";
	private static final String _FINDER_COLUMN_NAME_NAME_2 = "testEntity.name = ?";
	private static final String _FINDER_COLUMN_NAME_NAME_3 = "(testEntity.name IS NULL OR testEntity.name = ?)";
	private static final String _ORDER_BY_ENTITY_ALIAS = "testEntity.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TestEntity exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No TestEntity exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(TestEntityPersistenceImpl.class);
	private static TestEntity _nullTestEntity = new TestEntityImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<TestEntity> toCacheModel() {
				return _nullTestEntityCacheModel;
			}
		};

	private static CacheModel<TestEntity> _nullTestEntityCacheModel = new CacheModel<TestEntity>() {
			public TestEntity toEntityModel() {
				return _nullTestEntity;
			}
		};
}