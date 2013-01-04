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
import com.liferay.portal.kernel.dao.jdbc.MappingSqlQuery;
import com.liferay.portal.kernel.dao.jdbc.MappingSqlQueryFactoryUtil;
import com.liferay.portal.kernel.dao.jdbc.RowMapper;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
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
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import irestads.NoSuchLopException;

import irestads.model.Lop;

import irestads.model.impl.LopImpl;
import irestads.model.impl.LopModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the lop service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ADMIN
 * @see LopPersistence
 * @see LopUtil
 * @generated
 */
public class LopPersistenceImpl extends BasePersistenceImpl<Lop>
	implements LopPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LopUtil} to access the lop persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LopImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LopModelImpl.ENTITY_CACHE_ENABLED,
			LopModelImpl.FINDER_CACHE_ENABLED, LopImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LopModelImpl.ENTITY_CACHE_ENABLED,
			LopModelImpl.FINDER_CACHE_ENABLED, LopImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LopModelImpl.ENTITY_CACHE_ENABLED,
			LopModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the lop in the entity cache if it is enabled.
	 *
	 * @param lop the lop
	 */
	public void cacheResult(Lop lop) {
		EntityCacheUtil.putResult(LopModelImpl.ENTITY_CACHE_ENABLED,
			LopImpl.class, lop.getPrimaryKey(), lop);

		lop.resetOriginalValues();
	}

	/**
	 * Caches the lops in the entity cache if it is enabled.
	 *
	 * @param lops the lops
	 */
	public void cacheResult(List<Lop> lops) {
		for (Lop lop : lops) {
			if (EntityCacheUtil.getResult(LopModelImpl.ENTITY_CACHE_ENABLED,
						LopImpl.class, lop.getPrimaryKey()) == null) {
				cacheResult(lop);
			}
			else {
				lop.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all lops.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(LopImpl.class.getName());
		}

		EntityCacheUtil.clearCache(LopImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the lop.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Lop lop) {
		EntityCacheUtil.removeResult(LopModelImpl.ENTITY_CACHE_ENABLED,
			LopImpl.class, lop.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Lop> lops) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Lop lop : lops) {
			EntityCacheUtil.removeResult(LopModelImpl.ENTITY_CACHE_ENABLED,
				LopImpl.class, lop.getPrimaryKey());
		}
	}

	/**
	 * Creates a new lop with the primary key. Does not add the lop to the database.
	 *
	 * @param lopId the primary key for the new lop
	 * @return the new lop
	 */
	public Lop create(long lopId) {
		Lop lop = new LopImpl();

		lop.setNew(true);
		lop.setPrimaryKey(lopId);

		return lop;
	}

	/**
	 * Removes the lop with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param lopId the primary key of the lop
	 * @return the lop that was removed
	 * @throws irestads.NoSuchLopException if a lop with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Lop remove(long lopId) throws NoSuchLopException, SystemException {
		return remove(Long.valueOf(lopId));
	}

	/**
	 * Removes the lop with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the lop
	 * @return the lop that was removed
	 * @throws irestads.NoSuchLopException if a lop with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Lop remove(Serializable primaryKey)
		throws NoSuchLopException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Lop lop = (Lop)session.get(LopImpl.class, primaryKey);

			if (lop == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLopException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(lop);
		}
		catch (NoSuchLopException nsee) {
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
	protected Lop removeImpl(Lop lop) throws SystemException {
		lop = toUnwrappedModel(lop);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, lop);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(lop);

		return lop;
	}

	@Override
	public Lop updateImpl(irestads.model.Lop lop, boolean merge)
		throws SystemException {
		lop = toUnwrappedModel(lop);

		boolean isNew = lop.isNew();

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, lop, merge);

			lop.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(LopModelImpl.ENTITY_CACHE_ENABLED,
			LopImpl.class, lop.getPrimaryKey(), lop);

		return lop;
	}

	protected Lop toUnwrappedModel(Lop lop) {
		if (lop instanceof LopImpl) {
			return lop;
		}

		LopImpl lopImpl = new LopImpl();

		lopImpl.setNew(lop.isNew());
		lopImpl.setPrimaryKey(lop.getPrimaryKey());

		lopImpl.setLopId(lop.getLopId());
		lopImpl.setTenLop(lop.getTenLop());

		return lopImpl;
	}

	/**
	 * Returns the lop with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the lop
	 * @return the lop
	 * @throws com.liferay.portal.NoSuchModelException if a lop with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Lop findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the lop with the primary key or throws a {@link irestads.NoSuchLopException} if it could not be found.
	 *
	 * @param lopId the primary key of the lop
	 * @return the lop
	 * @throws irestads.NoSuchLopException if a lop with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Lop findByPrimaryKey(long lopId)
		throws NoSuchLopException, SystemException {
		Lop lop = fetchByPrimaryKey(lopId);

		if (lop == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + lopId);
			}

			throw new NoSuchLopException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				lopId);
		}

		return lop;
	}

	/**
	 * Returns the lop with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the lop
	 * @return the lop, or <code>null</code> if a lop with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Lop fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the lop with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param lopId the primary key of the lop
	 * @return the lop, or <code>null</code> if a lop with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Lop fetchByPrimaryKey(long lopId) throws SystemException {
		Lop lop = (Lop)EntityCacheUtil.getResult(LopModelImpl.ENTITY_CACHE_ENABLED,
				LopImpl.class, lopId);

		if (lop == _nullLop) {
			return null;
		}

		if (lop == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				lop = (Lop)session.get(LopImpl.class, Long.valueOf(lopId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (lop != null) {
					cacheResult(lop);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(LopModelImpl.ENTITY_CACHE_ENABLED,
						LopImpl.class, lopId, _nullLop);
				}

				closeSession(session);
			}
		}

		return lop;
	}

	/**
	 * Returns all the lops.
	 *
	 * @return the lops
	 * @throws SystemException if a system exception occurred
	 */
	public List<Lop> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<Lop> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
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
	public List<Lop> findAll(int start, int end,
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

		List<Lop> list = (List<Lop>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LOP);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LOP.concat(LopModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Lop>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Lop>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Removes all the lops from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Lop lop : findAll()) {
			remove(lop);
		}
	}

	/**
	 * Returns the number of lops.
	 *
	 * @return the number of lops
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LOP);

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
	 * Returns all the sinh viens associated with the lop.
	 *
	 * @param pk the primary key of the lop
	 * @return the sinh viens associated with the lop
	 * @throws SystemException if a system exception occurred
	 */
	public List<irestads.model.SinhVien> getSinhViens(long pk)
		throws SystemException {
		return getSinhViens(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
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
	public List<irestads.model.SinhVien> getSinhViens(long pk, int start,
		int end) throws SystemException {
		return getSinhViens(pk, start, end, null);
	}

	public static final FinderPath FINDER_PATH_GET_SINHVIENS = new FinderPath(irestads.model.impl.SinhVienModelImpl.ENTITY_CACHE_ENABLED,
			irestads.model.impl.SinhVienModelImpl.FINDER_CACHE_ENABLED,
			irestads.model.impl.SinhVienImpl.class,
			irestads.service.persistence.SinhVienPersistenceImpl.FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"getSinhViens",
			new String[] {
				Long.class.getName(), "java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});

	static {
		FINDER_PATH_GET_SINHVIENS.setCacheKeyGeneratorCacheName(null);
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
	public List<irestads.model.SinhVien> getSinhViens(long pk, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] { pk, start, end, orderByComparator };

		List<irestads.model.SinhVien> list = (List<irestads.model.SinhVien>)FinderCacheUtil.getResult(FINDER_PATH_GET_SINHVIENS,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				String sql = null;

				if (orderByComparator != null) {
					sql = _SQL_GETSINHVIENS.concat(ORDER_BY_CLAUSE)
										   .concat(orderByComparator.getOrderBy());
				}
				else {
					sql = _SQL_GETSINHVIENS.concat(irestads.model.impl.SinhVienModelImpl.ORDER_BY_SQL);
				}

				SQLQuery q = session.createSQLQuery(sql);

				q.addEntity("testprimeface_SinhVien",
					irestads.model.impl.SinhVienImpl.class);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(pk);

				list = (List<irestads.model.SinhVien>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_GET_SINHVIENS,
						finderArgs);
				}
				else {
					sinhVienPersistence.cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_GET_SINHVIENS,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	public static final FinderPath FINDER_PATH_GET_SINHVIENS_SIZE = new FinderPath(irestads.model.impl.SinhVienModelImpl.ENTITY_CACHE_ENABLED,
			irestads.model.impl.SinhVienModelImpl.FINDER_CACHE_ENABLED,
			irestads.model.impl.SinhVienImpl.class,
			irestads.service.persistence.SinhVienPersistenceImpl.FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"getSinhViensSize", new String[] { Long.class.getName() });

	static {
		FINDER_PATH_GET_SINHVIENS_SIZE.setCacheKeyGeneratorCacheName(null);
	}

	/**
	 * Returns the number of sinh viens associated with the lop.
	 *
	 * @param pk the primary key of the lop
	 * @return the number of sinh viens associated with the lop
	 * @throws SystemException if a system exception occurred
	 */
	public int getSinhViensSize(long pk) throws SystemException {
		Object[] finderArgs = new Object[] { pk };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_GET_SINHVIENS_SIZE,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				SQLQuery q = session.createSQLQuery(_SQL_GETSINHVIENSSIZE);

				q.addScalar(COUNT_COLUMN_NAME,
					com.liferay.portal.kernel.dao.orm.Type.LONG);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(pk);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_GET_SINHVIENS_SIZE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public static final FinderPath FINDER_PATH_CONTAINS_SINHVIEN = new FinderPath(irestads.model.impl.SinhVienModelImpl.ENTITY_CACHE_ENABLED,
			irestads.model.impl.SinhVienModelImpl.FINDER_CACHE_ENABLED,
			irestads.model.impl.SinhVienImpl.class,
			irestads.service.persistence.SinhVienPersistenceImpl.FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"containsSinhVien",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns <code>true</code> if the sinh vien is associated with the lop.
	 *
	 * @param pk the primary key of the lop
	 * @param sinhVienPK the primary key of the sinh vien
	 * @return <code>true</code> if the sinh vien is associated with the lop; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	public boolean containsSinhVien(long pk, long sinhVienPK)
		throws SystemException {
		Object[] finderArgs = new Object[] { pk, sinhVienPK };

		Boolean value = (Boolean)FinderCacheUtil.getResult(FINDER_PATH_CONTAINS_SINHVIEN,
				finderArgs, this);

		if (value == null) {
			try {
				value = Boolean.valueOf(containsSinhVien.contains(pk, sinhVienPK));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (value == null) {
					value = Boolean.FALSE;
				}

				FinderCacheUtil.putResult(FINDER_PATH_CONTAINS_SINHVIEN,
					finderArgs, value);
			}
		}

		return value.booleanValue();
	}

	/**
	 * Returns <code>true</code> if the lop has any sinh viens associated with it.
	 *
	 * @param pk the primary key of the lop to check for associations with sinh viens
	 * @return <code>true</code> if the lop has any sinh viens associated with it; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	public boolean containsSinhViens(long pk) throws SystemException {
		if (getSinhViensSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Initializes the lop persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.irestads.model.Lop")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Lop>> listenersList = new ArrayList<ModelListener<Lop>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Lop>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}

		containsSinhVien = new ContainsSinhVien();
	}

	public void destroy() {
		EntityCacheUtil.removeCache(LopImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = LopPersistence.class)
	protected LopPersistence lopPersistence;
	@BeanReference(type = SinhVienPersistence.class)
	protected SinhVienPersistence sinhVienPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	protected ContainsSinhVien containsSinhVien;

	protected class ContainsSinhVien {
		protected ContainsSinhVien() {
			_mappingSqlQuery = MappingSqlQueryFactoryUtil.getMappingSqlQuery(getDataSource(),
					_SQL_CONTAINSSINHVIEN,
					new int[] { java.sql.Types.BIGINT, java.sql.Types.BIGINT },
					RowMapper.COUNT);
		}

		protected boolean contains(long lopId, long sinhVienId) {
			List<Integer> results = _mappingSqlQuery.execute(new Object[] {
						new Long(lopId), new Long(sinhVienId)
					});

			if (results.size() > 0) {
				Integer count = results.get(0);

				if (count.intValue() > 0) {
					return true;
				}
			}

			return false;
		}

		private MappingSqlQuery<Integer> _mappingSqlQuery;
	}

	private static final String _SQL_SELECT_LOP = "SELECT lop FROM Lop lop";
	private static final String _SQL_COUNT_LOP = "SELECT COUNT(lop) FROM Lop lop";
	private static final String _SQL_GETSINHVIENS = "SELECT {testprimeface_SinhVien.*} FROM testprimeface_SinhVien INNER JOIN testprimeface_Lop ON (testprimeface_Lop.lopId = testprimeface_SinhVien.lopId) WHERE (testprimeface_Lop.lopId = ?)";
	private static final String _SQL_GETSINHVIENSSIZE = "SELECT COUNT(*) AS COUNT_VALUE FROM testprimeface_SinhVien WHERE lopId = ?";
	private static final String _SQL_CONTAINSSINHVIEN = "SELECT COUNT(*) AS COUNT_VALUE FROM testprimeface_SinhVien WHERE lopId = ? AND sinhVienId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "lop.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Lop exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(LopPersistenceImpl.class);
	private static Lop _nullLop = new LopImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Lop> toCacheModel() {
				return _nullLopCacheModel;
			}
		};

	private static CacheModel<Lop> _nullLopCacheModel = new CacheModel<Lop>() {
			public Lop toEntityModel() {
				return _nullLop;
			}
		};
}