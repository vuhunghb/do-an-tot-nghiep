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

package irestads.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link DishLocalService}.
 * </p>
 *
 * @author    Be
 * @see       DishLocalService
 * @generated
 */
public class DishLocalServiceWrapper implements DishLocalService,
	ServiceWrapper<DishLocalService> {
	public DishLocalServiceWrapper(DishLocalService dishLocalService) {
		_dishLocalService = dishLocalService;
	}

	/**
	* Adds the dish to the database. Also notifies the appropriate model listeners.
	*
	* @param dish the dish
	* @return the dish that was added
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.Dish addDish(irestads.model.Dish dish)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dishLocalService.addDish(dish);
	}

	/**
	* Creates a new dish with the primary key. Does not add the dish to the database.
	*
	* @param dishId the primary key for the new dish
	* @return the new dish
	*/
	public irestads.model.Dish createDish(long dishId) {
		return _dishLocalService.createDish(dishId);
	}

	/**
	* Deletes the dish with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param dishId the primary key of the dish
	* @return the dish that was removed
	* @throws PortalException if a dish with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.Dish deleteDish(long dishId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _dishLocalService.deleteDish(dishId);
	}

	/**
	* Deletes the dish from the database. Also notifies the appropriate model listeners.
	*
	* @param dish the dish
	* @return the dish that was removed
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.Dish deleteDish(irestads.model.Dish dish)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dishLocalService.deleteDish(dish);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _dishLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dishLocalService.dynamicQuery(dynamicQuery);
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _dishLocalService.dynamicQuery(dynamicQuery, start, end);
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dishLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dishLocalService.dynamicQueryCount(dynamicQuery);
	}

	public irestads.model.Dish fetchDish(long dishId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dishLocalService.fetchDish(dishId);
	}

	/**
	* Returns the dish with the primary key.
	*
	* @param dishId the primary key of the dish
	* @return the dish
	* @throws PortalException if a dish with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.Dish getDish(long dishId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _dishLocalService.getDish(dishId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _dishLocalService.getPersistedModel(primaryKeyObj);
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
	public java.util.List<irestads.model.Dish> getDishs(int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dishLocalService.getDishs(start, end);
	}

	/**
	* Returns the number of dishs.
	*
	* @return the number of dishs
	* @throws SystemException if a system exception occurred
	*/
	public int getDishsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dishLocalService.getDishsCount();
	}

	/**
	* Updates the dish in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param dish the dish
	* @return the dish that was updated
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.Dish updateDish(irestads.model.Dish dish)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dishLocalService.updateDish(dish);
	}

	/**
	* Updates the dish in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param dish the dish
	* @param merge whether to merge the dish with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the dish that was updated
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.Dish updateDish(irestads.model.Dish dish,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dishLocalService.updateDish(dish, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _dishLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_dishLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _dishLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	public irestads.model.Dish createDish(java.lang.String dishName,
		java.lang.String decription, java.lang.String avatarImg,
		java.lang.String detailImg, java.lang.String detail, int referPrice,
		long categoryId) {
		return _dishLocalService.createDish(dishName, decription, avatarImg,
			detailImg, detail, referPrice, categoryId);
	}

	public java.util.List<irestads.model.Dish> getAllDishs() {
		return _dishLocalService.getAllDishs();
	}

	public java.util.List<irestads.model.Dish> getDishsByCategory(
		long categoryId) {
		return _dishLocalService.getDishsByCategory(categoryId);
	}

	public irestads.model.Dish findDishsById(long dishId) {
		return _dishLocalService.findDishsById(dishId);
	}

	public java.util.List<irestads.model.Dish> findDishsByReferPrice(
		int referPrice) {
		return _dishLocalService.findDishsByReferPrice(referPrice);
	}

	public java.util.List<irestads.model.Dish> findDishsByCategoryName(
		java.lang.String categoryName) {
		return _dishLocalService.findDishsByCategoryName(categoryName);
	}

	public java.util.List<irestads.model.Dish> findDishsByName(
		java.lang.String dishName) {
		return _dishLocalService.findDishsByName(dishName);
	}

	public java.util.List<irestads.model.Dish> findDishsByDecription(
		java.lang.String decription) {
		return _dishLocalService.findDishsByDecription(decription);
	}

	public java.util.List<irestads.model.Dish> findDishsByAvatarImg(
		java.lang.String avatarImg) {
		return _dishLocalService.findDishsByAvatarImg(avatarImg);
	}

	public java.util.List<irestads.model.Dish> findDishsByDetailImg(
		java.lang.String detailImg) {
		return _dishLocalService.findDishsByDetailImg(detailImg);
	}

	public java.util.List<irestads.model.Dish> findDishsByDetail(
		java.lang.String detail) {
		return _dishLocalService.findDishsByDetail(detail);
	}

	public java.util.List<irestads.model.Dish> findDishsBySomeField(
		long dishId, int referPrice, java.lang.String dishName,
		java.lang.String decription, java.lang.String avatarImg,
		java.lang.String detailImg, java.lang.String detail) {
		return _dishLocalService.findDishsBySomeField(dishId, referPrice,
			dishName, decription, avatarImg, detailImg, detail);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public DishLocalService getWrappedDishLocalService() {
		return _dishLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedDishLocalService(DishLocalService dishLocalService) {
		_dishLocalService = dishLocalService;
	}

	public DishLocalService getWrappedService() {
		return _dishLocalService;
	}

	public void setWrappedService(DishLocalService dishLocalService) {
		_dishLocalService = dishLocalService;
	}

	private DishLocalService _dishLocalService;
}