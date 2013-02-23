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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the category ads local service. This utility wraps {@link irestads.service.impl.CategoryAdsLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Be
 * @see CategoryAdsLocalService
 * @see irestads.service.base.CategoryAdsLocalServiceBaseImpl
 * @see irestads.service.impl.CategoryAdsLocalServiceImpl
 * @generated
 */
public class CategoryAdsLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link irestads.service.impl.CategoryAdsLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the category ads to the database. Also notifies the appropriate model listeners.
	*
	* @param categoryAds the category ads
	* @return the category ads that was added
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.CategoryAds addCategoryAds(
		irestads.model.CategoryAds categoryAds)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addCategoryAds(categoryAds);
	}

	/**
	* Creates a new category ads with the primary key. Does not add the category ads to the database.
	*
	* @param categoryAdsId the primary key for the new category ads
	* @return the new category ads
	*/
	public static irestads.model.CategoryAds createCategoryAds(
		long categoryAdsId) {
		return getService().createCategoryAds(categoryAdsId);
	}

	/**
	* Deletes the category ads with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param categoryAdsId the primary key of the category ads
	* @return the category ads that was removed
	* @throws PortalException if a category ads with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.CategoryAds deleteCategoryAds(
		long categoryAdsId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteCategoryAds(categoryAdsId);
	}

	/**
	* Deletes the category ads from the database. Also notifies the appropriate model listeners.
	*
	* @param categoryAds the category ads
	* @return the category ads that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.CategoryAds deleteCategoryAds(
		irestads.model.CategoryAds categoryAds)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteCategoryAds(categoryAds);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	public static irestads.model.CategoryAds fetchCategoryAds(
		long categoryAdsId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchCategoryAds(categoryAdsId);
	}

	/**
	* Returns the category ads with the primary key.
	*
	* @param categoryAdsId the primary key of the category ads
	* @return the category ads
	* @throws PortalException if a category ads with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.CategoryAds getCategoryAds(long categoryAdsId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getCategoryAds(categoryAdsId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<irestads.model.CategoryAds> getCategoryAdses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCategoryAdses(start, end);
	}

	/**
	* Returns the number of category adses.
	*
	* @return the number of category adses
	* @throws SystemException if a system exception occurred
	*/
	public static int getCategoryAdsesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCategoryAdsesCount();
	}

	/**
	* Updates the category ads in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param categoryAds the category ads
	* @return the category ads that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.CategoryAds updateCategoryAds(
		irestads.model.CategoryAds categoryAds)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateCategoryAds(categoryAds);
	}

	/**
	* Updates the category ads in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param categoryAds the category ads
	* @param merge whether to merge the category ads with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the category ads that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.CategoryAds updateCategoryAds(
		irestads.model.CategoryAds categoryAds, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateCategoryAds(categoryAds, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static java.util.List<irestads.model.CategoryAds> getAddCategoryAds() {
		return getService().getAddCategoryAds();
	}

	public static irestads.model.CategoryAds findById(long id) {
		return getService().findById(id);
	}

	public static void clearService() {
		_service = null;
	}

	public static CategoryAdsLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					CategoryAdsLocalService.class.getName());

			if (invokableLocalService instanceof CategoryAdsLocalService) {
				_service = (CategoryAdsLocalService)invokableLocalService;
			}
			else {
				_service = new CategoryAdsLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(CategoryAdsLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(CategoryAdsLocalService service) {
	}

	private static CategoryAdsLocalService _service;
}