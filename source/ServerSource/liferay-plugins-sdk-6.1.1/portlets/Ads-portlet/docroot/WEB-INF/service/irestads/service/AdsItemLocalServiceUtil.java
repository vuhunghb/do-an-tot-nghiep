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
 * The utility for the ads item local service. This utility wraps {@link irestads.service.impl.AdsItemLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Be
 * @see AdsItemLocalService
 * @see irestads.service.base.AdsItemLocalServiceBaseImpl
 * @see irestads.service.impl.AdsItemLocalServiceImpl
 * @generated
 */
public class AdsItemLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link irestads.service.impl.AdsItemLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the ads item to the database. Also notifies the appropriate model listeners.
	*
	* @param adsItem the ads item
	* @return the ads item that was added
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.AdsItem addAdsItem(
		irestads.model.AdsItem adsItem)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addAdsItem(adsItem);
	}

	/**
	* Creates a new ads item with the primary key. Does not add the ads item to the database.
	*
	* @param adsItemId the primary key for the new ads item
	* @return the new ads item
	*/
	public static irestads.model.AdsItem createAdsItem(long adsItemId) {
		return getService().createAdsItem(adsItemId);
	}

	/**
	* Deletes the ads item with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param adsItemId the primary key of the ads item
	* @return the ads item that was removed
	* @throws PortalException if a ads item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.AdsItem deleteAdsItem(long adsItemId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteAdsItem(adsItemId);
	}

	/**
	* Deletes the ads item from the database. Also notifies the appropriate model listeners.
	*
	* @param adsItem the ads item
	* @return the ads item that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.AdsItem deleteAdsItem(
		irestads.model.AdsItem adsItem)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteAdsItem(adsItem);
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

	public static irestads.model.AdsItem fetchAdsItem(long adsItemId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchAdsItem(adsItemId);
	}

	/**
	* Returns the ads item with the primary key.
	*
	* @param adsItemId the primary key of the ads item
	* @return the ads item
	* @throws PortalException if a ads item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.AdsItem getAdsItem(long adsItemId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getAdsItem(adsItemId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the ads items.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of ads items
	* @param end the upper bound of the range of ads items (not inclusive)
	* @return the range of ads items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<irestads.model.AdsItem> getAdsItems(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAdsItems(start, end);
	}

	/**
	* Returns the number of ads items.
	*
	* @return the number of ads items
	* @throws SystemException if a system exception occurred
	*/
	public static int getAdsItemsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAdsItemsCount();
	}

	/**
	* Updates the ads item in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param adsItem the ads item
	* @return the ads item that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.AdsItem updateAdsItem(
		irestads.model.AdsItem adsItem)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateAdsItem(adsItem);
	}

	/**
	* Updates the ads item in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param adsItem the ads item
	* @param merge whether to merge the ads item with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the ads item that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.AdsItem updateAdsItem(
		irestads.model.AdsItem adsItem, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateAdsItem(adsItem, merge);
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

	public static irestads.model.AdsItem createAdsItem(
		java.lang.String companyName, java.lang.String numberPhone,
		java.lang.String email, java.lang.String address,
		java.lang.String facebook, java.lang.String twitter,
		java.lang.String description, java.lang.String imageContent,
		int timeDuring, java.lang.String productName, java.lang.String tags,
		java.lang.String itemType, long categoryAdsId) {
		return getService()
				   .createAdsItem(companyName, numberPhone, email, address,
			facebook, twitter, description, imageContent, timeDuring,
			productName, tags, itemType, categoryAdsId);
	}

	public static irestads.model.AdsItem createAdsItem(
		irestads.model.AdsItem adsItem) {
		return getService().createAdsItem(adsItem);
	}

	public static irestads.model.AdsItem findById(long adsItemId) {
		return getService().findById(adsItemId);
	}

	public static java.util.List<irestads.model.AdsItem> getAllAdsItems() {
		return getService().getAllAdsItems();
	}

	public static java.util.List<irestads.model.AdsItem> findAdsByCompName(
		java.lang.String keyword) {
		return getService().findAdsByCompName(keyword);
	}

	public static java.util.List<irestads.model.AdsItem> findAdsByTags(
		java.lang.String keyword) {
		return getService().findAdsByTags(keyword);
	}

	public static java.util.List<irestads.model.AdsItem> findAdsByProductName(
		java.lang.String keyword) {
		return getService().findAdsByProductName(keyword);
	}

	public static java.util.List<irestads.model.AdsItem> findAdsByItemType(
		java.lang.String keyword) {
		return getService().findAdsByItemType(keyword);
	}

	public static java.util.List<irestads.model.AdsItem> findAdsByCategoryName(
		java.lang.String keyword) {
		return getService().findAdsByCategoryName(keyword);
	}

	public static java.util.List<irestads.model.AdsItem> findAdsByTimeDuration(
		int keyword) {
		return getService().findAdsByTimeDuration(keyword);
	}

	public static void clearService() {
		_service = null;
	}

	public static AdsItemLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					AdsItemLocalService.class.getName());

			if (invokableLocalService instanceof AdsItemLocalService) {
				_service = (AdsItemLocalService)invokableLocalService;
			}
			else {
				_service = new AdsItemLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(AdsItemLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(AdsItemLocalService service) {
	}

	private static AdsItemLocalService _service;
}