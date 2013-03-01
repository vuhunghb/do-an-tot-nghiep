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

package irestads.service.base;

import com.liferay.counter.service.CounterLocalService;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.ResourceLocalService;
import com.liferay.portal.service.ResourceService;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserService;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;

import irestads.model.CategoryAds;

import irestads.service.AdsItemLocalService;
import irestads.service.AdsItemService;
import irestads.service.CategoryAdsLocalService;
import irestads.service.CategoryAdsService;

import irestads.service.persistence.AdsItemFinder;
import irestads.service.persistence.AdsItemPersistence;
import irestads.service.persistence.CategoryAdsPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * The base implementation of the category ads local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link irestads.service.impl.CategoryAdsLocalServiceImpl}.
 * </p>
 *
 * @author Be
 * @see irestads.service.impl.CategoryAdsLocalServiceImpl
 * @see irestads.service.CategoryAdsLocalServiceUtil
 * @generated
 */
public abstract class CategoryAdsLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements CategoryAdsLocalService,
		IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link irestads.service.CategoryAdsLocalServiceUtil} to access the category ads local service.
	 */

	/**
	 * Adds the category ads to the database. Also notifies the appropriate model listeners.
	 *
	 * @param categoryAds the category ads
	 * @return the category ads that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public CategoryAds addCategoryAds(CategoryAds categoryAds)
		throws SystemException {
		categoryAds.setNew(true);

		return categoryAdsPersistence.update(categoryAds, false);
	}

	/**
	 * Creates a new category ads with the primary key. Does not add the category ads to the database.
	 *
	 * @param categoryAdsId the primary key for the new category ads
	 * @return the new category ads
	 */
	public CategoryAds createCategoryAds(long categoryAdsId) {
		return categoryAdsPersistence.create(categoryAdsId);
	}

	/**
	 * Deletes the category ads with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param categoryAdsId the primary key of the category ads
	 * @return the category ads that was removed
	 * @throws PortalException if a category ads with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	public CategoryAds deleteCategoryAds(long categoryAdsId)
		throws PortalException, SystemException {
		return categoryAdsPersistence.remove(categoryAdsId);
	}

	/**
	 * Deletes the category ads from the database. Also notifies the appropriate model listeners.
	 *
	 * @param categoryAds the category ads
	 * @return the category ads that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	public CategoryAds deleteCategoryAds(CategoryAds categoryAds)
		throws SystemException {
		return categoryAdsPersistence.remove(categoryAds);
	}

	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(CategoryAds.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return categoryAdsPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return categoryAdsPersistence.findWithDynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return categoryAdsPersistence.findWithDynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return categoryAdsPersistence.countWithDynamicQuery(dynamicQuery);
	}

	public CategoryAds fetchCategoryAds(long categoryAdsId)
		throws SystemException {
		return categoryAdsPersistence.fetchByPrimaryKey(categoryAdsId);
	}

	/**
	 * Returns the category ads with the primary key.
	 *
	 * @param categoryAdsId the primary key of the category ads
	 * @return the category ads
	 * @throws PortalException if a category ads with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CategoryAds getCategoryAds(long categoryAdsId)
		throws PortalException, SystemException {
		return categoryAdsPersistence.findByPrimaryKey(categoryAdsId);
	}

	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return categoryAdsPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the category adses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of category adses
	 * @param end the upper bound of the range of category adses (not inclusive)
	 * @return the range of category adses
	 * @throws SystemException if a system exception occurred
	 */
	public List<CategoryAds> getCategoryAdses(int start, int end)
		throws SystemException {
		return categoryAdsPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of category adses.
	 *
	 * @return the number of category adses
	 * @throws SystemException if a system exception occurred
	 */
	public int getCategoryAdsesCount() throws SystemException {
		return categoryAdsPersistence.countAll();
	}

	/**
	 * Updates the category ads in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param categoryAds the category ads
	 * @return the category ads that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public CategoryAds updateCategoryAds(CategoryAds categoryAds)
		throws SystemException {
		return updateCategoryAds(categoryAds, true);
	}

	/**
	 * Updates the category ads in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param categoryAds the category ads
	 * @param merge whether to merge the category ads with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	 * @return the category ads that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public CategoryAds updateCategoryAds(CategoryAds categoryAds, boolean merge)
		throws SystemException {
		categoryAds.setNew(false);

		return categoryAdsPersistence.update(categoryAds, merge);
	}

	/**
	 * Returns the ads item local service.
	 *
	 * @return the ads item local service
	 */
	public AdsItemLocalService getAdsItemLocalService() {
		return adsItemLocalService;
	}

	/**
	 * Sets the ads item local service.
	 *
	 * @param adsItemLocalService the ads item local service
	 */
	public void setAdsItemLocalService(AdsItemLocalService adsItemLocalService) {
		this.adsItemLocalService = adsItemLocalService;
	}

	/**
	 * Returns the ads item remote service.
	 *
	 * @return the ads item remote service
	 */
	public AdsItemService getAdsItemService() {
		return adsItemService;
	}

	/**
	 * Sets the ads item remote service.
	 *
	 * @param adsItemService the ads item remote service
	 */
	public void setAdsItemService(AdsItemService adsItemService) {
		this.adsItemService = adsItemService;
	}

	/**
	 * Returns the ads item persistence.
	 *
	 * @return the ads item persistence
	 */
	public AdsItemPersistence getAdsItemPersistence() {
		return adsItemPersistence;
	}

	/**
	 * Sets the ads item persistence.
	 *
	 * @param adsItemPersistence the ads item persistence
	 */
	public void setAdsItemPersistence(AdsItemPersistence adsItemPersistence) {
		this.adsItemPersistence = adsItemPersistence;
	}

	/**
	 * Returns the ads item finder.
	 *
	 * @return the ads item finder
	 */
	public AdsItemFinder getAdsItemFinder() {
		return adsItemFinder;
	}

	/**
	 * Sets the ads item finder.
	 *
	 * @param adsItemFinder the ads item finder
	 */
	public void setAdsItemFinder(AdsItemFinder adsItemFinder) {
		this.adsItemFinder = adsItemFinder;
	}

	/**
	 * Returns the category ads local service.
	 *
	 * @return the category ads local service
	 */
	public CategoryAdsLocalService getCategoryAdsLocalService() {
		return categoryAdsLocalService;
	}

	/**
	 * Sets the category ads local service.
	 *
	 * @param categoryAdsLocalService the category ads local service
	 */
	public void setCategoryAdsLocalService(
		CategoryAdsLocalService categoryAdsLocalService) {
		this.categoryAdsLocalService = categoryAdsLocalService;
	}

	/**
	 * Returns the category ads remote service.
	 *
	 * @return the category ads remote service
	 */
	public CategoryAdsService getCategoryAdsService() {
		return categoryAdsService;
	}

	/**
	 * Sets the category ads remote service.
	 *
	 * @param categoryAdsService the category ads remote service
	 */
	public void setCategoryAdsService(CategoryAdsService categoryAdsService) {
		this.categoryAdsService = categoryAdsService;
	}

	/**
	 * Returns the category ads persistence.
	 *
	 * @return the category ads persistence
	 */
	public CategoryAdsPersistence getCategoryAdsPersistence() {
		return categoryAdsPersistence;
	}

	/**
	 * Sets the category ads persistence.
	 *
	 * @param categoryAdsPersistence the category ads persistence
	 */
	public void setCategoryAdsPersistence(
		CategoryAdsPersistence categoryAdsPersistence) {
		this.categoryAdsPersistence = categoryAdsPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the resource remote service.
	 *
	 * @return the resource remote service
	 */
	public ResourceService getResourceService() {
		return resourceService;
	}

	/**
	 * Sets the resource remote service.
	 *
	 * @param resourceService the resource remote service
	 */
	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}

	/**
	 * Returns the resource persistence.
	 *
	 * @return the resource persistence
	 */
	public ResourcePersistence getResourcePersistence() {
		return resourcePersistence;
	}

	/**
	 * Sets the resource persistence.
	 *
	 * @param resourcePersistence the resource persistence
	 */
	public void setResourcePersistence(ResourcePersistence resourcePersistence) {
		this.resourcePersistence = resourcePersistence;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		PersistedModelLocalServiceRegistryUtil.register("irestads.model.CategoryAds",
			categoryAdsLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"irestads.model.CategoryAds");
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
	}

	protected Class<?> getModelClass() {
		return CategoryAds.class;
	}

	protected String getModelClassName() {
		return CategoryAds.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = categoryAdsPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = AdsItemLocalService.class)
	protected AdsItemLocalService adsItemLocalService;
	@BeanReference(type = AdsItemService.class)
	protected AdsItemService adsItemService;
	@BeanReference(type = AdsItemPersistence.class)
	protected AdsItemPersistence adsItemPersistence;
	@BeanReference(type = AdsItemFinder.class)
	protected AdsItemFinder adsItemFinder;
	@BeanReference(type = CategoryAdsLocalService.class)
	protected CategoryAdsLocalService categoryAdsLocalService;
	@BeanReference(type = CategoryAdsService.class)
	protected CategoryAdsService categoryAdsService;
	@BeanReference(type = CategoryAdsPersistence.class)
	protected CategoryAdsPersistence categoryAdsPersistence;
	@BeanReference(type = CounterLocalService.class)
	protected CounterLocalService counterLocalService;
	@BeanReference(type = ResourceLocalService.class)
	protected ResourceLocalService resourceLocalService;
	@BeanReference(type = ResourceService.class)
	protected ResourceService resourceService;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserLocalService.class)
	protected UserLocalService userLocalService;
	@BeanReference(type = UserService.class)
	protected UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private CategoryAdsLocalServiceClpInvoker _clpInvoker = new CategoryAdsLocalServiceClpInvoker();
}