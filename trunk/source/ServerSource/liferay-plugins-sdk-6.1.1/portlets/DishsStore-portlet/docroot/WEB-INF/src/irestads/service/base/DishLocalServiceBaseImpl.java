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

import irestads.model.Dish;

import irestads.service.CategoryLocalService;
import irestads.service.CategoryService;
import irestads.service.DishLocalService;
import irestads.service.DishService;
import irestads.service.DishTableLocalService;
import irestads.service.DishTableService;
import irestads.service.MenuLineLocalService;
import irestads.service.MenuLineService;
import irestads.service.MenuLocalService;
import irestads.service.MenuService;
import irestads.service.OrderLineLocalService;
import irestads.service.OrderLineService;
import irestads.service.OrdersLocalService;
import irestads.service.OrdersService;
import irestads.service.UVersionLocalService;
import irestads.service.UVersionService;

import irestads.service.persistence.CategoryFinder;
import irestads.service.persistence.CategoryPersistence;
import irestads.service.persistence.DishFinder;
import irestads.service.persistence.DishPersistence;
import irestads.service.persistence.DishTablePersistence;
import irestads.service.persistence.MenuLineFinder;
import irestads.service.persistence.MenuLinePersistence;
import irestads.service.persistence.MenuPersistence;
import irestads.service.persistence.OrderLinePersistence;
import irestads.service.persistence.OrdersPersistence;
import irestads.service.persistence.UVersionFinder;
import irestads.service.persistence.UVersionPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * The base implementation of the dish local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link irestads.service.impl.DishLocalServiceImpl}.
 * </p>
 *
 * @author Be
 * @see irestads.service.impl.DishLocalServiceImpl
 * @see irestads.service.DishLocalServiceUtil
 * @generated
 */
public abstract class DishLocalServiceBaseImpl extends BaseLocalServiceImpl
	implements DishLocalService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link irestads.service.DishLocalServiceUtil} to access the dish local service.
	 */

	/**
	 * Adds the dish to the database. Also notifies the appropriate model listeners.
	 *
	 * @param dish the dish
	 * @return the dish that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Dish addDish(Dish dish) throws SystemException {
		dish.setNew(true);

		return dishPersistence.update(dish, false);
	}

	/**
	 * Creates a new dish with the primary key. Does not add the dish to the database.
	 *
	 * @param dishId the primary key for the new dish
	 * @return the new dish
	 */
	public Dish createDish(long dishId) {
		return dishPersistence.create(dishId);
	}

	/**
	 * Deletes the dish with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dishId the primary key of the dish
	 * @return the dish that was removed
	 * @throws PortalException if a dish with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	public Dish deleteDish(long dishId) throws PortalException, SystemException {
		return dishPersistence.remove(dishId);
	}

	/**
	 * Deletes the dish from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dish the dish
	 * @return the dish that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	public Dish deleteDish(Dish dish) throws SystemException {
		return dishPersistence.remove(dish);
	}

	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(Dish.class,
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
		return dishPersistence.findWithDynamicQuery(dynamicQuery);
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
		return dishPersistence.findWithDynamicQuery(dynamicQuery, start, end);
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
		return dishPersistence.findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
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
		return dishPersistence.countWithDynamicQuery(dynamicQuery);
	}

	public Dish fetchDish(long dishId) throws SystemException {
		return dishPersistence.fetchByPrimaryKey(dishId);
	}

	/**
	 * Returns the dish with the primary key.
	 *
	 * @param dishId the primary key of the dish
	 * @return the dish
	 * @throws PortalException if a dish with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Dish getDish(long dishId) throws PortalException, SystemException {
		return dishPersistence.findByPrimaryKey(dishId);
	}

	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return dishPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the dishs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of dishs
	 * @param end the upper bound of the range of dishs (not inclusive)
	 * @return the range of dishs
	 * @throws SystemException if a system exception occurred
	 */
	public List<Dish> getDishs(int start, int end) throws SystemException {
		return dishPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of dishs.
	 *
	 * @return the number of dishs
	 * @throws SystemException if a system exception occurred
	 */
	public int getDishsCount() throws SystemException {
		return dishPersistence.countAll();
	}

	/**
	 * Updates the dish in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param dish the dish
	 * @return the dish that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Dish updateDish(Dish dish) throws SystemException {
		return updateDish(dish, true);
	}

	/**
	 * Updates the dish in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param dish the dish
	 * @param merge whether to merge the dish with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	 * @return the dish that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Dish updateDish(Dish dish, boolean merge) throws SystemException {
		dish.setNew(false);

		return dishPersistence.update(dish, merge);
	}

	/**
	 * Returns the category local service.
	 *
	 * @return the category local service
	 */
	public CategoryLocalService getCategoryLocalService() {
		return categoryLocalService;
	}

	/**
	 * Sets the category local service.
	 *
	 * @param categoryLocalService the category local service
	 */
	public void setCategoryLocalService(
		CategoryLocalService categoryLocalService) {
		this.categoryLocalService = categoryLocalService;
	}

	/**
	 * Returns the category remote service.
	 *
	 * @return the category remote service
	 */
	public CategoryService getCategoryService() {
		return categoryService;
	}

	/**
	 * Sets the category remote service.
	 *
	 * @param categoryService the category remote service
	 */
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	/**
	 * Returns the category persistence.
	 *
	 * @return the category persistence
	 */
	public CategoryPersistence getCategoryPersistence() {
		return categoryPersistence;
	}

	/**
	 * Sets the category persistence.
	 *
	 * @param categoryPersistence the category persistence
	 */
	public void setCategoryPersistence(CategoryPersistence categoryPersistence) {
		this.categoryPersistence = categoryPersistence;
	}

	/**
	 * Returns the category finder.
	 *
	 * @return the category finder
	 */
	public CategoryFinder getCategoryFinder() {
		return categoryFinder;
	}

	/**
	 * Sets the category finder.
	 *
	 * @param categoryFinder the category finder
	 */
	public void setCategoryFinder(CategoryFinder categoryFinder) {
		this.categoryFinder = categoryFinder;
	}

	/**
	 * Returns the dish local service.
	 *
	 * @return the dish local service
	 */
	public DishLocalService getDishLocalService() {
		return dishLocalService;
	}

	/**
	 * Sets the dish local service.
	 *
	 * @param dishLocalService the dish local service
	 */
	public void setDishLocalService(DishLocalService dishLocalService) {
		this.dishLocalService = dishLocalService;
	}

	/**
	 * Returns the dish remote service.
	 *
	 * @return the dish remote service
	 */
	public DishService getDishService() {
		return dishService;
	}

	/**
	 * Sets the dish remote service.
	 *
	 * @param dishService the dish remote service
	 */
	public void setDishService(DishService dishService) {
		this.dishService = dishService;
	}

	/**
	 * Returns the dish persistence.
	 *
	 * @return the dish persistence
	 */
	public DishPersistence getDishPersistence() {
		return dishPersistence;
	}

	/**
	 * Sets the dish persistence.
	 *
	 * @param dishPersistence the dish persistence
	 */
	public void setDishPersistence(DishPersistence dishPersistence) {
		this.dishPersistence = dishPersistence;
	}

	/**
	 * Returns the dish finder.
	 *
	 * @return the dish finder
	 */
	public DishFinder getDishFinder() {
		return dishFinder;
	}

	/**
	 * Sets the dish finder.
	 *
	 * @param dishFinder the dish finder
	 */
	public void setDishFinder(DishFinder dishFinder) {
		this.dishFinder = dishFinder;
	}

	/**
	 * Returns the dish table local service.
	 *
	 * @return the dish table local service
	 */
	public DishTableLocalService getDishTableLocalService() {
		return dishTableLocalService;
	}

	/**
	 * Sets the dish table local service.
	 *
	 * @param dishTableLocalService the dish table local service
	 */
	public void setDishTableLocalService(
		DishTableLocalService dishTableLocalService) {
		this.dishTableLocalService = dishTableLocalService;
	}

	/**
	 * Returns the dish table remote service.
	 *
	 * @return the dish table remote service
	 */
	public DishTableService getDishTableService() {
		return dishTableService;
	}

	/**
	 * Sets the dish table remote service.
	 *
	 * @param dishTableService the dish table remote service
	 */
	public void setDishTableService(DishTableService dishTableService) {
		this.dishTableService = dishTableService;
	}

	/**
	 * Returns the dish table persistence.
	 *
	 * @return the dish table persistence
	 */
	public DishTablePersistence getDishTablePersistence() {
		return dishTablePersistence;
	}

	/**
	 * Sets the dish table persistence.
	 *
	 * @param dishTablePersistence the dish table persistence
	 */
	public void setDishTablePersistence(
		DishTablePersistence dishTablePersistence) {
		this.dishTablePersistence = dishTablePersistence;
	}

	/**
	 * Returns the menu local service.
	 *
	 * @return the menu local service
	 */
	public MenuLocalService getMenuLocalService() {
		return menuLocalService;
	}

	/**
	 * Sets the menu local service.
	 *
	 * @param menuLocalService the menu local service
	 */
	public void setMenuLocalService(MenuLocalService menuLocalService) {
		this.menuLocalService = menuLocalService;
	}

	/**
	 * Returns the menu remote service.
	 *
	 * @return the menu remote service
	 */
	public MenuService getMenuService() {
		return menuService;
	}

	/**
	 * Sets the menu remote service.
	 *
	 * @param menuService the menu remote service
	 */
	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}

	/**
	 * Returns the menu persistence.
	 *
	 * @return the menu persistence
	 */
	public MenuPersistence getMenuPersistence() {
		return menuPersistence;
	}

	/**
	 * Sets the menu persistence.
	 *
	 * @param menuPersistence the menu persistence
	 */
	public void setMenuPersistence(MenuPersistence menuPersistence) {
		this.menuPersistence = menuPersistence;
	}

	/**
	 * Returns the menu line local service.
	 *
	 * @return the menu line local service
	 */
	public MenuLineLocalService getMenuLineLocalService() {
		return menuLineLocalService;
	}

	/**
	 * Sets the menu line local service.
	 *
	 * @param menuLineLocalService the menu line local service
	 */
	public void setMenuLineLocalService(
		MenuLineLocalService menuLineLocalService) {
		this.menuLineLocalService = menuLineLocalService;
	}

	/**
	 * Returns the menu line remote service.
	 *
	 * @return the menu line remote service
	 */
	public MenuLineService getMenuLineService() {
		return menuLineService;
	}

	/**
	 * Sets the menu line remote service.
	 *
	 * @param menuLineService the menu line remote service
	 */
	public void setMenuLineService(MenuLineService menuLineService) {
		this.menuLineService = menuLineService;
	}

	/**
	 * Returns the menu line persistence.
	 *
	 * @return the menu line persistence
	 */
	public MenuLinePersistence getMenuLinePersistence() {
		return menuLinePersistence;
	}

	/**
	 * Sets the menu line persistence.
	 *
	 * @param menuLinePersistence the menu line persistence
	 */
	public void setMenuLinePersistence(MenuLinePersistence menuLinePersistence) {
		this.menuLinePersistence = menuLinePersistence;
	}

	/**
	 * Returns the menu line finder.
	 *
	 * @return the menu line finder
	 */
	public MenuLineFinder getMenuLineFinder() {
		return menuLineFinder;
	}

	/**
	 * Sets the menu line finder.
	 *
	 * @param menuLineFinder the menu line finder
	 */
	public void setMenuLineFinder(MenuLineFinder menuLineFinder) {
		this.menuLineFinder = menuLineFinder;
	}

	/**
	 * Returns the order line local service.
	 *
	 * @return the order line local service
	 */
	public OrderLineLocalService getOrderLineLocalService() {
		return orderLineLocalService;
	}

	/**
	 * Sets the order line local service.
	 *
	 * @param orderLineLocalService the order line local service
	 */
	public void setOrderLineLocalService(
		OrderLineLocalService orderLineLocalService) {
		this.orderLineLocalService = orderLineLocalService;
	}

	/**
	 * Returns the order line remote service.
	 *
	 * @return the order line remote service
	 */
	public OrderLineService getOrderLineService() {
		return orderLineService;
	}

	/**
	 * Sets the order line remote service.
	 *
	 * @param orderLineService the order line remote service
	 */
	public void setOrderLineService(OrderLineService orderLineService) {
		this.orderLineService = orderLineService;
	}

	/**
	 * Returns the order line persistence.
	 *
	 * @return the order line persistence
	 */
	public OrderLinePersistence getOrderLinePersistence() {
		return orderLinePersistence;
	}

	/**
	 * Sets the order line persistence.
	 *
	 * @param orderLinePersistence the order line persistence
	 */
	public void setOrderLinePersistence(
		OrderLinePersistence orderLinePersistence) {
		this.orderLinePersistence = orderLinePersistence;
	}

	/**
	 * Returns the orders local service.
	 *
	 * @return the orders local service
	 */
	public OrdersLocalService getOrdersLocalService() {
		return ordersLocalService;
	}

	/**
	 * Sets the orders local service.
	 *
	 * @param ordersLocalService the orders local service
	 */
	public void setOrdersLocalService(OrdersLocalService ordersLocalService) {
		this.ordersLocalService = ordersLocalService;
	}

	/**
	 * Returns the orders remote service.
	 *
	 * @return the orders remote service
	 */
	public OrdersService getOrdersService() {
		return ordersService;
	}

	/**
	 * Sets the orders remote service.
	 *
	 * @param ordersService the orders remote service
	 */
	public void setOrdersService(OrdersService ordersService) {
		this.ordersService = ordersService;
	}

	/**
	 * Returns the orders persistence.
	 *
	 * @return the orders persistence
	 */
	public OrdersPersistence getOrdersPersistence() {
		return ordersPersistence;
	}

	/**
	 * Sets the orders persistence.
	 *
	 * @param ordersPersistence the orders persistence
	 */
	public void setOrdersPersistence(OrdersPersistence ordersPersistence) {
		this.ordersPersistence = ordersPersistence;
	}

	/**
	 * Returns the u version local service.
	 *
	 * @return the u version local service
	 */
	public UVersionLocalService getUVersionLocalService() {
		return uVersionLocalService;
	}

	/**
	 * Sets the u version local service.
	 *
	 * @param uVersionLocalService the u version local service
	 */
	public void setUVersionLocalService(
		UVersionLocalService uVersionLocalService) {
		this.uVersionLocalService = uVersionLocalService;
	}

	/**
	 * Returns the u version remote service.
	 *
	 * @return the u version remote service
	 */
	public UVersionService getUVersionService() {
		return uVersionService;
	}

	/**
	 * Sets the u version remote service.
	 *
	 * @param uVersionService the u version remote service
	 */
	public void setUVersionService(UVersionService uVersionService) {
		this.uVersionService = uVersionService;
	}

	/**
	 * Returns the u version persistence.
	 *
	 * @return the u version persistence
	 */
	public UVersionPersistence getUVersionPersistence() {
		return uVersionPersistence;
	}

	/**
	 * Sets the u version persistence.
	 *
	 * @param uVersionPersistence the u version persistence
	 */
	public void setUVersionPersistence(UVersionPersistence uVersionPersistence) {
		this.uVersionPersistence = uVersionPersistence;
	}

	/**
	 * Returns the u version finder.
	 *
	 * @return the u version finder
	 */
	public UVersionFinder getUVersionFinder() {
		return uVersionFinder;
	}

	/**
	 * Sets the u version finder.
	 *
	 * @param uVersionFinder the u version finder
	 */
	public void setUVersionFinder(UVersionFinder uVersionFinder) {
		this.uVersionFinder = uVersionFinder;
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
		PersistedModelLocalServiceRegistryUtil.register("irestads.model.Dish",
			dishLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister("irestads.model.Dish");
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
		return Dish.class;
	}

	protected String getModelClassName() {
		return Dish.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = dishPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = CategoryLocalService.class)
	protected CategoryLocalService categoryLocalService;
	@BeanReference(type = CategoryService.class)
	protected CategoryService categoryService;
	@BeanReference(type = CategoryPersistence.class)
	protected CategoryPersistence categoryPersistence;
	@BeanReference(type = CategoryFinder.class)
	protected CategoryFinder categoryFinder;
	@BeanReference(type = DishLocalService.class)
	protected DishLocalService dishLocalService;
	@BeanReference(type = DishService.class)
	protected DishService dishService;
	@BeanReference(type = DishPersistence.class)
	protected DishPersistence dishPersistence;
	@BeanReference(type = DishFinder.class)
	protected DishFinder dishFinder;
	@BeanReference(type = DishTableLocalService.class)
	protected DishTableLocalService dishTableLocalService;
	@BeanReference(type = DishTableService.class)
	protected DishTableService dishTableService;
	@BeanReference(type = DishTablePersistence.class)
	protected DishTablePersistence dishTablePersistence;
	@BeanReference(type = MenuLocalService.class)
	protected MenuLocalService menuLocalService;
	@BeanReference(type = MenuService.class)
	protected MenuService menuService;
	@BeanReference(type = MenuPersistence.class)
	protected MenuPersistence menuPersistence;
	@BeanReference(type = MenuLineLocalService.class)
	protected MenuLineLocalService menuLineLocalService;
	@BeanReference(type = MenuLineService.class)
	protected MenuLineService menuLineService;
	@BeanReference(type = MenuLinePersistence.class)
	protected MenuLinePersistence menuLinePersistence;
	@BeanReference(type = MenuLineFinder.class)
	protected MenuLineFinder menuLineFinder;
	@BeanReference(type = OrderLineLocalService.class)
	protected OrderLineLocalService orderLineLocalService;
	@BeanReference(type = OrderLineService.class)
	protected OrderLineService orderLineService;
	@BeanReference(type = OrderLinePersistence.class)
	protected OrderLinePersistence orderLinePersistence;
	@BeanReference(type = OrdersLocalService.class)
	protected OrdersLocalService ordersLocalService;
	@BeanReference(type = OrdersService.class)
	protected OrdersService ordersService;
	@BeanReference(type = OrdersPersistence.class)
	protected OrdersPersistence ordersPersistence;
	@BeanReference(type = UVersionLocalService.class)
	protected UVersionLocalService uVersionLocalService;
	@BeanReference(type = UVersionService.class)
	protected UVersionService uVersionService;
	@BeanReference(type = UVersionPersistence.class)
	protected UVersionPersistence uVersionPersistence;
	@BeanReference(type = UVersionFinder.class)
	protected UVersionFinder uVersionFinder;
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
	private DishLocalServiceClpInvoker _clpInvoker = new DishLocalServiceClpInvoker();
}