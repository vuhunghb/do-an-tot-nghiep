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
import com.liferay.portal.service.InvokableService;

/**
 * The utility for the ads item remote service. This utility wraps {@link irestads.service.impl.AdsItemServiceImpl} and is the primary access point for service operations in application layer code running on a remote server.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Be
 * @see AdsItemService
 * @see irestads.service.base.AdsItemServiceBaseImpl
 * @see irestads.service.impl.AdsItemServiceImpl
 * @generated
 */
public class AdsItemServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link irestads.service.impl.AdsItemServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

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

	public static irestads.model.AdsItem updateAdsItem(
		irestads.model.AdsItem item) {
		return getService().updateAdsItem(item);
	}

	public static irestads.model.AdsItem deleteAdsItem(long adsItemId) {
		return getService().deleteAdsItem(adsItemId);
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

	public static AdsItemService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					AdsItemService.class.getName());

			if (invokableService instanceof AdsItemService) {
				_service = (AdsItemService)invokableService;
			}
			else {
				_service = new AdsItemServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(AdsItemServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(AdsItemService service) {
	}

	private static AdsItemService _service;
}