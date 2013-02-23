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
 * This class is a wrapper for {@link CategoryAdsLocalService}.
 * </p>
 *
 * @author    Be
 * @see       CategoryAdsLocalService
 * @generated
 */
public class CategoryAdsLocalServiceWrapper implements CategoryAdsLocalService,
	ServiceWrapper<CategoryAdsLocalService> {
	public CategoryAdsLocalServiceWrapper(
		CategoryAdsLocalService categoryAdsLocalService) {
		_categoryAdsLocalService = categoryAdsLocalService;
	}

	/**
	* Adds the category ads to the database. Also notifies the appropriate model listeners.
	*
	* @param categoryAds the category ads
	* @return the category ads that was added
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.CategoryAds addCategoryAds(
		irestads.model.CategoryAds categoryAds)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _categoryAdsLocalService.addCategoryAds(categoryAds);
	}

	/**
	* Creates a new category ads with the primary key. Does not add the category ads to the database.
	*
	* @param categoryAdsId the primary key for the new category ads
	* @return the new category ads
	*/
	public irestads.model.CategoryAds createCategoryAds(long categoryAdsId) {
		return _categoryAdsLocalService.createCategoryAds(categoryAdsId);
	}

	/**
	* Deletes the category ads with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param categoryAdsId the primary key of the category ads
	* @return the category ads that was removed
	* @throws PortalException if a category ads with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.CategoryAds deleteCategoryAds(long categoryAdsId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _categoryAdsLocalService.deleteCategoryAds(categoryAdsId);
	}

	/**
	* Deletes the category ads from the database. Also notifies the appropriate model listeners.
	*
	* @param categoryAds the category ads
	* @return the category ads that was removed
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.CategoryAds deleteCategoryAds(
		irestads.model.CategoryAds categoryAds)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _categoryAdsLocalService.deleteCategoryAds(categoryAds);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _categoryAdsLocalService.dynamicQuery();
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
		return _categoryAdsLocalService.dynamicQuery(dynamicQuery);
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
		return _categoryAdsLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _categoryAdsLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _categoryAdsLocalService.dynamicQueryCount(dynamicQuery);
	}

	public irestads.model.CategoryAds fetchCategoryAds(long categoryAdsId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _categoryAdsLocalService.fetchCategoryAds(categoryAdsId);
	}

	/**
	* Returns the category ads with the primary key.
	*
	* @param categoryAdsId the primary key of the category ads
	* @return the category ads
	* @throws PortalException if a category ads with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.CategoryAds getCategoryAds(long categoryAdsId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _categoryAdsLocalService.getCategoryAds(categoryAdsId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _categoryAdsLocalService.getPersistedModel(primaryKeyObj);
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
	public java.util.List<irestads.model.CategoryAds> getCategoryAdses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _categoryAdsLocalService.getCategoryAdses(start, end);
	}

	/**
	* Returns the number of category adses.
	*
	* @return the number of category adses
	* @throws SystemException if a system exception occurred
	*/
	public int getCategoryAdsesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _categoryAdsLocalService.getCategoryAdsesCount();
	}

	/**
	* Updates the category ads in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param categoryAds the category ads
	* @return the category ads that was updated
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.CategoryAds updateCategoryAds(
		irestads.model.CategoryAds categoryAds)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _categoryAdsLocalService.updateCategoryAds(categoryAds);
	}

	/**
	* Updates the category ads in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param categoryAds the category ads
	* @param merge whether to merge the category ads with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the category ads that was updated
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.CategoryAds updateCategoryAds(
		irestads.model.CategoryAds categoryAds, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _categoryAdsLocalService.updateCategoryAds(categoryAds, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _categoryAdsLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_categoryAdsLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _categoryAdsLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	public java.util.List<irestads.model.CategoryAds> getAddCategoryAds() {
		return _categoryAdsLocalService.getAddCategoryAds();
	}

	public irestads.model.CategoryAds findById(long id) {
		return _categoryAdsLocalService.findById(id);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public CategoryAdsLocalService getWrappedCategoryAdsLocalService() {
		return _categoryAdsLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedCategoryAdsLocalService(
		CategoryAdsLocalService categoryAdsLocalService) {
		_categoryAdsLocalService = categoryAdsLocalService;
	}

	public CategoryAdsLocalService getWrappedService() {
		return _categoryAdsLocalService;
	}

	public void setWrappedService(
		CategoryAdsLocalService categoryAdsLocalService) {
		_categoryAdsLocalService = categoryAdsLocalService;
	}

	private CategoryAdsLocalService _categoryAdsLocalService;
}