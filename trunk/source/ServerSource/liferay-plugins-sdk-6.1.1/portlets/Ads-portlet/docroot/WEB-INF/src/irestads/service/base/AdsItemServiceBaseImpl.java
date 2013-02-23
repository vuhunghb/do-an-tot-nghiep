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
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.BaseServiceImpl;
import com.liferay.portal.service.ResourceLocalService;
import com.liferay.portal.service.ResourceService;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserService;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;

import irestads.model.AdsItem;

import irestads.service.AdsItemLocalService;
import irestads.service.AdsItemService;
import irestads.service.CategoryAdsLocalService;
import irestads.service.CategoryAdsService;

import irestads.service.persistence.AdsItemFinder;
import irestads.service.persistence.AdsItemPersistence;
import irestads.service.persistence.CategoryAdsPersistence;

import javax.sql.DataSource;

/**
 * The base implementation of the ads item remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link irestads.service.impl.AdsItemServiceImpl}.
 * </p>
 *
 * @author Be
 * @see irestads.service.impl.AdsItemServiceImpl
 * @see irestads.service.AdsItemServiceUtil
 * @generated
 */
public abstract class AdsItemServiceBaseImpl extends BaseServiceImpl
	implements AdsItemService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link irestads.service.AdsItemServiceUtil} to access the ads item remote service.
	 */

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
	}

	public void destroy() {
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
		return AdsItem.class;
	}

	protected String getModelClassName() {
		return AdsItem.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = adsItemPersistence.getDataSource();

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
	private AdsItemServiceClpInvoker _clpInvoker = new AdsItemServiceClpInvoker();
}