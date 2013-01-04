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
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import irestads.NoSuchSinhVienException;

import irestads.model.SinhVien;

import irestads.model.impl.SinhVienImpl;
import irestads.model.impl.SinhVienModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the sinh vien service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ADMIN
 * @see SinhVienPersistence
 * @see SinhVienUtil
 * @generated
 */
public class SinhVienPersistenceImpl extends BasePersistenceImpl<SinhVien>
	implements SinhVienPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SinhVienUtil} to access the sinh vien persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SinhVienImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SinhVienModelImpl.ENTITY_CACHE_ENABLED,
			SinhVienModelImpl.FINDER_CACHE_ENABLED, SinhVienImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SinhVienModelImpl.ENTITY_CACHE_ENABLED,
			SinhVienModelImpl.FINDER_CACHE_ENABLED, SinhVienImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SinhVienModelImpl.ENTITY_CACHE_ENABLED,
			SinhVienModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the sinh vien in the entity cache if it is enabled.
	 *
	 * @param sinhVien the sinh vien
	 */
	public void cacheResult(SinhVien sinhVien) {
		EntityCacheUtil.putResult(SinhVienModelImpl.ENTITY_CACHE_ENABLED,
			SinhVienImpl.class, sinhVien.getPrimaryKey(), sinhVien);

		sinhVien.resetOriginalValues();
	}

	/**
	 * Caches the sinh viens in the entity cache if it is enabled.
	 *
	 * @param sinhViens the sinh viens
	 */
	public void cacheResult(List<SinhVien> sinhViens) {
		for (SinhVien sinhVien : sinhViens) {
			if (EntityCacheUtil.getResult(
						SinhVienModelImpl.ENTITY_CACHE_ENABLED,
						SinhVienImpl.class, sinhVien.getPrimaryKey()) == null) {
				cacheResult(sinhVien);
			}
			else {
				sinhVien.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all sinh viens.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SinhVienImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SinhVienImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the sinh vien.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SinhVien sinhVien) {
		EntityCacheUtil.removeResult(SinhVienModelImpl.ENTITY_CACHE_ENABLED,
			SinhVienImpl.class, sinhVien.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<SinhVien> sinhViens) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SinhVien sinhVien : sinhViens) {
			EntityCacheUtil.removeResult(SinhVienModelImpl.ENTITY_CACHE_ENABLED,
				SinhVienImpl.class, sinhVien.getPrimaryKey());
		}
	}

	/**
	 * Creates a new sinh vien with the primary key. Does not add the sinh vien to the database.
	 *
	 * @param sinhVienId the primary key for the new sinh vien
	 * @return the new sinh vien
	 */
	public SinhVien create(long sinhVienId) {
		SinhVien sinhVien = new SinhVienImpl();

		sinhVien.setNew(true);
		sinhVien.setPrimaryKey(sinhVienId);

		return sinhVien;
	}

	/**
	 * Removes the sinh vien with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param sinhVienId the primary key of the sinh vien
	 * @return the sinh vien that was removed
	 * @throws irestads.NoSuchSinhVienException if a sinh vien with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SinhVien remove(long sinhVienId)
		throws NoSuchSinhVienException, SystemException {
		return remove(Long.valueOf(sinhVienId));
	}

	/**
	 * Removes the sinh vien with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the sinh vien
	 * @return the sinh vien that was removed
	 * @throws irestads.NoSuchSinhVienException if a sinh vien with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SinhVien remove(Serializable primaryKey)
		throws NoSuchSinhVienException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SinhVien sinhVien = (SinhVien)session.get(SinhVienImpl.class,
					primaryKey);

			if (sinhVien == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSinhVienException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(sinhVien);
		}
		catch (NoSuchSinhVienException nsee) {
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
	protected SinhVien removeImpl(SinhVien sinhVien) throws SystemException {
		sinhVien = toUnwrappedModel(sinhVien);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, sinhVien);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(sinhVien);

		return sinhVien;
	}

	@Override
	public SinhVien updateImpl(irestads.model.SinhVien sinhVien, boolean merge)
		throws SystemException {
		sinhVien = toUnwrappedModel(sinhVien);

		boolean isNew = sinhVien.isNew();

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, sinhVien, merge);

			sinhVien.setNew(false);
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

		EntityCacheUtil.putResult(SinhVienModelImpl.ENTITY_CACHE_ENABLED,
			SinhVienImpl.class, sinhVien.getPrimaryKey(), sinhVien);

		return sinhVien;
	}

	protected SinhVien toUnwrappedModel(SinhVien sinhVien) {
		if (sinhVien instanceof SinhVienImpl) {
			return sinhVien;
		}

		SinhVienImpl sinhVienImpl = new SinhVienImpl();

		sinhVienImpl.setNew(sinhVien.isNew());
		sinhVienImpl.setPrimaryKey(sinhVien.getPrimaryKey());

		sinhVienImpl.setSinhVienId(sinhVien.getSinhVienId());
		sinhVienImpl.setMssv(sinhVien.getMssv());
		sinhVienImpl.setTen(sinhVien.getTen());
		sinhVienImpl.setDiaChi(sinhVien.getDiaChi());
		sinhVienImpl.setDiem(sinhVien.getDiem());
		sinhVienImpl.setLopId(sinhVien.getLopId());

		return sinhVienImpl;
	}

	/**
	 * Returns the sinh vien with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the sinh vien
	 * @return the sinh vien
	 * @throws com.liferay.portal.NoSuchModelException if a sinh vien with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SinhVien findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the sinh vien with the primary key or throws a {@link irestads.NoSuchSinhVienException} if it could not be found.
	 *
	 * @param sinhVienId the primary key of the sinh vien
	 * @return the sinh vien
	 * @throws irestads.NoSuchSinhVienException if a sinh vien with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SinhVien findByPrimaryKey(long sinhVienId)
		throws NoSuchSinhVienException, SystemException {
		SinhVien sinhVien = fetchByPrimaryKey(sinhVienId);

		if (sinhVien == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + sinhVienId);
			}

			throw new NoSuchSinhVienException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				sinhVienId);
		}

		return sinhVien;
	}

	/**
	 * Returns the sinh vien with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the sinh vien
	 * @return the sinh vien, or <code>null</code> if a sinh vien with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SinhVien fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the sinh vien with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param sinhVienId the primary key of the sinh vien
	 * @return the sinh vien, or <code>null</code> if a sinh vien with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SinhVien fetchByPrimaryKey(long sinhVienId)
		throws SystemException {
		SinhVien sinhVien = (SinhVien)EntityCacheUtil.getResult(SinhVienModelImpl.ENTITY_CACHE_ENABLED,
				SinhVienImpl.class, sinhVienId);

		if (sinhVien == _nullSinhVien) {
			return null;
		}

		if (sinhVien == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				sinhVien = (SinhVien)session.get(SinhVienImpl.class,
						Long.valueOf(sinhVienId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (sinhVien != null) {
					cacheResult(sinhVien);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(SinhVienModelImpl.ENTITY_CACHE_ENABLED,
						SinhVienImpl.class, sinhVienId, _nullSinhVien);
				}

				closeSession(session);
			}
		}

		return sinhVien;
	}

	/**
	 * Returns all the sinh viens.
	 *
	 * @return the sinh viens
	 * @throws SystemException if a system exception occurred
	 */
	public List<SinhVien> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<SinhVien> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
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
	public List<SinhVien> findAll(int start, int end,
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

		List<SinhVien> list = (List<SinhVien>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SINHVIEN);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SINHVIEN.concat(SinhVienModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<SinhVien>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<SinhVien>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the sinh viens from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (SinhVien sinhVien : findAll()) {
			remove(sinhVien);
		}
	}

	/**
	 * Returns the number of sinh viens.
	 *
	 * @return the number of sinh viens
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_SINHVIEN);

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
	 * Initializes the sinh vien persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.irestads.model.SinhVien")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SinhVien>> listenersList = new ArrayList<ModelListener<SinhVien>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SinhVien>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SinhVienImpl.class.getName());
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
	private static final String _SQL_SELECT_SINHVIEN = "SELECT sinhVien FROM SinhVien sinhVien";
	private static final String _SQL_COUNT_SINHVIEN = "SELECT COUNT(sinhVien) FROM SinhVien sinhVien";
	private static final String _ORDER_BY_ENTITY_ALIAS = "sinhVien.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SinhVien exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SinhVienPersistenceImpl.class);
	private static SinhVien _nullSinhVien = new SinhVienImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SinhVien> toCacheModel() {
				return _nullSinhVienCacheModel;
			}
		};

	private static CacheModel<SinhVien> _nullSinhVienCacheModel = new CacheModel<SinhVien>() {
			public SinhVien toEntityModel() {
				return _nullSinhVien;
			}
		};
}