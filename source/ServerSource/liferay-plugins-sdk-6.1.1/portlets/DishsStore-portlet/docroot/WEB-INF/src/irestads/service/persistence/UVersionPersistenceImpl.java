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
import com.liferay.portal.kernel.util.CalendarUtil;
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

import irestads.NoSuchUVersionException;

import irestads.model.UVersion;

import irestads.model.impl.UVersionImpl;
import irestads.model.impl.UVersionModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * The persistence implementation for the u version service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Be
 * @see UVersionPersistence
 * @see UVersionUtil
 * @generated
 */
public class UVersionPersistenceImpl extends BasePersistenceImpl<UVersion>
	implements UVersionPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link UVersionUtil} to access the u version persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = UVersionImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LOGDATE = new FinderPath(UVersionModelImpl.ENTITY_CACHE_ENABLED,
			UVersionModelImpl.FINDER_CACHE_ENABLED, UVersionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByLogDate",
			new String[] {
				Date.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOGDATE =
		new FinderPath(UVersionModelImpl.ENTITY_CACHE_ENABLED,
			UVersionModelImpl.FINDER_CACHE_ENABLED, UVersionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByLogDate",
			new String[] { Date.class.getName() },
			UVersionModelImpl.LOGDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LOGDATE = new FinderPath(UVersionModelImpl.ENTITY_CACHE_ENABLED,
			UVersionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLogDate",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(UVersionModelImpl.ENTITY_CACHE_ENABLED,
			UVersionModelImpl.FINDER_CACHE_ENABLED, UVersionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(UVersionModelImpl.ENTITY_CACHE_ENABLED,
			UVersionModelImpl.FINDER_CACHE_ENABLED, UVersionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(UVersionModelImpl.ENTITY_CACHE_ENABLED,
			UVersionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the u version in the entity cache if it is enabled.
	 *
	 * @param uVersion the u version
	 */
	public void cacheResult(UVersion uVersion) {
		EntityCacheUtil.putResult(UVersionModelImpl.ENTITY_CACHE_ENABLED,
			UVersionImpl.class, uVersion.getPrimaryKey(), uVersion);

		uVersion.resetOriginalValues();
	}

	/**
	 * Caches the u versions in the entity cache if it is enabled.
	 *
	 * @param uVersions the u versions
	 */
	public void cacheResult(List<UVersion> uVersions) {
		for (UVersion uVersion : uVersions) {
			if (EntityCacheUtil.getResult(
						UVersionModelImpl.ENTITY_CACHE_ENABLED,
						UVersionImpl.class, uVersion.getPrimaryKey()) == null) {
				cacheResult(uVersion);
			}
			else {
				uVersion.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all u versions.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(UVersionImpl.class.getName());
		}

		EntityCacheUtil.clearCache(UVersionImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the u version.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(UVersion uVersion) {
		EntityCacheUtil.removeResult(UVersionModelImpl.ENTITY_CACHE_ENABLED,
			UVersionImpl.class, uVersion.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<UVersion> uVersions) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (UVersion uVersion : uVersions) {
			EntityCacheUtil.removeResult(UVersionModelImpl.ENTITY_CACHE_ENABLED,
				UVersionImpl.class, uVersion.getPrimaryKey());
		}
	}

	/**
	 * Creates a new u version with the primary key. Does not add the u version to the database.
	 *
	 * @param versionId the primary key for the new u version
	 * @return the new u version
	 */
	public UVersion create(long versionId) {
		UVersion uVersion = new UVersionImpl();

		uVersion.setNew(true);
		uVersion.setPrimaryKey(versionId);

		return uVersion;
	}

	/**
	 * Removes the u version with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param versionId the primary key of the u version
	 * @return the u version that was removed
	 * @throws irestads.NoSuchUVersionException if a u version with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public UVersion remove(long versionId)
		throws NoSuchUVersionException, SystemException {
		return remove(Long.valueOf(versionId));
	}

	/**
	 * Removes the u version with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the u version
	 * @return the u version that was removed
	 * @throws irestads.NoSuchUVersionException if a u version with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UVersion remove(Serializable primaryKey)
		throws NoSuchUVersionException, SystemException {
		Session session = null;

		try {
			session = openSession();

			UVersion uVersion = (UVersion)session.get(UVersionImpl.class,
					primaryKey);

			if (uVersion == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUVersionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(uVersion);
		}
		catch (NoSuchUVersionException nsee) {
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
	protected UVersion removeImpl(UVersion uVersion) throws SystemException {
		uVersion = toUnwrappedModel(uVersion);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, uVersion);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(uVersion);

		return uVersion;
	}

	@Override
	public UVersion updateImpl(irestads.model.UVersion uVersion, boolean merge)
		throws SystemException {
		uVersion = toUnwrappedModel(uVersion);

		boolean isNew = uVersion.isNew();

		UVersionModelImpl uVersionModelImpl = (UVersionModelImpl)uVersion;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, uVersion, merge);

			uVersion.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !UVersionModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((uVersionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOGDATE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						uVersionModelImpl.getOriginalLogDate()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LOGDATE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOGDATE,
					args);

				args = new Object[] { uVersionModelImpl.getLogDate() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LOGDATE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOGDATE,
					args);
			}
		}

		EntityCacheUtil.putResult(UVersionModelImpl.ENTITY_CACHE_ENABLED,
			UVersionImpl.class, uVersion.getPrimaryKey(), uVersion);

		return uVersion;
	}

	protected UVersion toUnwrappedModel(UVersion uVersion) {
		if (uVersion instanceof UVersionImpl) {
			return uVersion;
		}

		UVersionImpl uVersionImpl = new UVersionImpl();

		uVersionImpl.setNew(uVersion.isNew());
		uVersionImpl.setPrimaryKey(uVersion.getPrimaryKey());

		uVersionImpl.setVersionId(uVersion.getVersionId());
		uVersionImpl.setCompanyId(uVersion.getCompanyId());
		uVersionImpl.setUserId(uVersion.getUserId());
		uVersionImpl.setUserName(uVersion.getUserName());
		uVersionImpl.setCreateDate(uVersion.getCreateDate());
		uVersionImpl.setModifiedDate(uVersion.getModifiedDate());
		uVersionImpl.setLogObjName(uVersion.getLogObjName());
		uVersionImpl.setLogObjId(uVersion.getLogObjId());
		uVersionImpl.setLogType(uVersion.getLogType());
		uVersionImpl.setLogDate(uVersion.getLogDate());

		return uVersionImpl;
	}

	/**
	 * Returns the u version with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the u version
	 * @return the u version
	 * @throws com.liferay.portal.NoSuchModelException if a u version with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UVersion findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the u version with the primary key or throws a {@link irestads.NoSuchUVersionException} if it could not be found.
	 *
	 * @param versionId the primary key of the u version
	 * @return the u version
	 * @throws irestads.NoSuchUVersionException if a u version with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public UVersion findByPrimaryKey(long versionId)
		throws NoSuchUVersionException, SystemException {
		UVersion uVersion = fetchByPrimaryKey(versionId);

		if (uVersion == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + versionId);
			}

			throw new NoSuchUVersionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				versionId);
		}

		return uVersion;
	}

	/**
	 * Returns the u version with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the u version
	 * @return the u version, or <code>null</code> if a u version with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UVersion fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the u version with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param versionId the primary key of the u version
	 * @return the u version, or <code>null</code> if a u version with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public UVersion fetchByPrimaryKey(long versionId) throws SystemException {
		UVersion uVersion = (UVersion)EntityCacheUtil.getResult(UVersionModelImpl.ENTITY_CACHE_ENABLED,
				UVersionImpl.class, versionId);

		if (uVersion == _nullUVersion) {
			return null;
		}

		if (uVersion == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				uVersion = (UVersion)session.get(UVersionImpl.class,
						Long.valueOf(versionId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (uVersion != null) {
					cacheResult(uVersion);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(UVersionModelImpl.ENTITY_CACHE_ENABLED,
						UVersionImpl.class, versionId, _nullUVersion);
				}

				closeSession(session);
			}
		}

		return uVersion;
	}

	/**
	 * Returns all the u versions where logDate = &#63;.
	 *
	 * @param logDate the log date
	 * @return the matching u versions
	 * @throws SystemException if a system exception occurred
	 */
	public List<UVersion> findByLogDate(Date logDate) throws SystemException {
		return findByLogDate(logDate, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<UVersion> findByLogDate(Date logDate, int start, int end)
		throws SystemException {
		return findByLogDate(logDate, start, end, null);
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
	public List<UVersion> findByLogDate(Date logDate, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOGDATE;
			finderArgs = new Object[] { logDate };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_LOGDATE;
			finderArgs = new Object[] { logDate, start, end, orderByComparator };
		}

		List<UVersion> list = (List<UVersion>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (UVersion uVersion : list) {
				if (!Validator.equals(logDate, uVersion.getLogDate())) {
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

			query.append(_SQL_SELECT_UVERSION_WHERE);

			if (logDate == null) {
				query.append(_FINDER_COLUMN_LOGDATE_LOGDATE_1);
			}
			else {
				query.append(_FINDER_COLUMN_LOGDATE_LOGDATE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(UVersionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (logDate != null) {
					qPos.add(CalendarUtil.getTimestamp(logDate));
				}

				list = (List<UVersion>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first u version in the ordered set where logDate = &#63;.
	 *
	 * @param logDate the log date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching u version
	 * @throws irestads.NoSuchUVersionException if a matching u version could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public UVersion findByLogDate_First(Date logDate,
		OrderByComparator orderByComparator)
		throws NoSuchUVersionException, SystemException {
		UVersion uVersion = fetchByLogDate_First(logDate, orderByComparator);

		if (uVersion != null) {
			return uVersion;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("logDate=");
		msg.append(logDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUVersionException(msg.toString());
	}

	/**
	 * Returns the first u version in the ordered set where logDate = &#63;.
	 *
	 * @param logDate the log date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching u version, or <code>null</code> if a matching u version could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public UVersion fetchByLogDate_First(Date logDate,
		OrderByComparator orderByComparator) throws SystemException {
		List<UVersion> list = findByLogDate(logDate, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public UVersion findByLogDate_Last(Date logDate,
		OrderByComparator orderByComparator)
		throws NoSuchUVersionException, SystemException {
		UVersion uVersion = fetchByLogDate_Last(logDate, orderByComparator);

		if (uVersion != null) {
			return uVersion;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("logDate=");
		msg.append(logDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUVersionException(msg.toString());
	}

	/**
	 * Returns the last u version in the ordered set where logDate = &#63;.
	 *
	 * @param logDate the log date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching u version, or <code>null</code> if a matching u version could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public UVersion fetchByLogDate_Last(Date logDate,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByLogDate(logDate);

		List<UVersion> list = findByLogDate(logDate, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public UVersion[] findByLogDate_PrevAndNext(long versionId, Date logDate,
		OrderByComparator orderByComparator)
		throws NoSuchUVersionException, SystemException {
		UVersion uVersion = findByPrimaryKey(versionId);

		Session session = null;

		try {
			session = openSession();

			UVersion[] array = new UVersionImpl[3];

			array[0] = getByLogDate_PrevAndNext(session, uVersion, logDate,
					orderByComparator, true);

			array[1] = uVersion;

			array[2] = getByLogDate_PrevAndNext(session, uVersion, logDate,
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

	protected UVersion getByLogDate_PrevAndNext(Session session,
		UVersion uVersion, Date logDate, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_UVERSION_WHERE);

		if (logDate == null) {
			query.append(_FINDER_COLUMN_LOGDATE_LOGDATE_1);
		}
		else {
			query.append(_FINDER_COLUMN_LOGDATE_LOGDATE_2);
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
			query.append(UVersionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (logDate != null) {
			qPos.add(CalendarUtil.getTimestamp(logDate));
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(uVersion);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<UVersion> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the u versions.
	 *
	 * @return the u versions
	 * @throws SystemException if a system exception occurred
	 */
	public List<UVersion> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<UVersion> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
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
	public List<UVersion> findAll(int start, int end,
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

		List<UVersion> list = (List<UVersion>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_UVERSION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_UVERSION.concat(UVersionModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<UVersion>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<UVersion>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the u versions where logDate = &#63; from the database.
	 *
	 * @param logDate the log date
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByLogDate(Date logDate) throws SystemException {
		for (UVersion uVersion : findByLogDate(logDate)) {
			remove(uVersion);
		}
	}

	/**
	 * Removes all the u versions from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (UVersion uVersion : findAll()) {
			remove(uVersion);
		}
	}

	/**
	 * Returns the number of u versions where logDate = &#63;.
	 *
	 * @param logDate the log date
	 * @return the number of matching u versions
	 * @throws SystemException if a system exception occurred
	 */
	public int countByLogDate(Date logDate) throws SystemException {
		Object[] finderArgs = new Object[] { logDate };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_LOGDATE,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_UVERSION_WHERE);

			if (logDate == null) {
				query.append(_FINDER_COLUMN_LOGDATE_LOGDATE_1);
			}
			else {
				query.append(_FINDER_COLUMN_LOGDATE_LOGDATE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (logDate != null) {
					qPos.add(CalendarUtil.getTimestamp(logDate));
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_LOGDATE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of u versions.
	 *
	 * @return the number of u versions
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_UVERSION);

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
	 * Initializes the u version persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.irestads.model.UVersion")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<UVersion>> listenersList = new ArrayList<ModelListener<UVersion>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<UVersion>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(UVersionImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = CategoryPersistence.class)
	protected CategoryPersistence categoryPersistence;
	@BeanReference(type = DishPersistence.class)
	protected DishPersistence dishPersistence;
	@BeanReference(type = MenuPersistence.class)
	protected MenuPersistence menuPersistence;
	@BeanReference(type = MenuLinePersistence.class)
	protected MenuLinePersistence menuLinePersistence;
	@BeanReference(type = UVersionPersistence.class)
	protected UVersionPersistence uVersionPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_UVERSION = "SELECT uVersion FROM UVersion uVersion";
	private static final String _SQL_SELECT_UVERSION_WHERE = "SELECT uVersion FROM UVersion uVersion WHERE ";
	private static final String _SQL_COUNT_UVERSION = "SELECT COUNT(uVersion) FROM UVersion uVersion";
	private static final String _SQL_COUNT_UVERSION_WHERE = "SELECT COUNT(uVersion) FROM UVersion uVersion WHERE ";
	private static final String _FINDER_COLUMN_LOGDATE_LOGDATE_1 = "uVersion.logDate IS NULL";
	private static final String _FINDER_COLUMN_LOGDATE_LOGDATE_2 = "uVersion.logDate = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "uVersion.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No UVersion exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No UVersion exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(UVersionPersistenceImpl.class);
	private static UVersion _nullUVersion = new UVersionImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<UVersion> toCacheModel() {
				return _nullUVersionCacheModel;
			}
		};

	private static CacheModel<UVersion> _nullUVersionCacheModel = new CacheModel<UVersion>() {
			public UVersion toEntityModel() {
				return _nullUVersion;
			}
		};
}