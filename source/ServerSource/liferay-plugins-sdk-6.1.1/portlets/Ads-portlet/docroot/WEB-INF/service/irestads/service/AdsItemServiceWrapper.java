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
 * This class is a wrapper for {@link AdsItemService}.
 * </p>
 *
 * @author    Be
 * @see       AdsItemService
 * @generated
 */
public class AdsItemServiceWrapper implements AdsItemService,
	ServiceWrapper<AdsItemService> {
	public AdsItemServiceWrapper(AdsItemService adsItemService) {
		_adsItemService = adsItemService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _adsItemService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_adsItemService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _adsItemService.invokeMethod(name, parameterTypes, arguments);
	}

	public irestads.model.AdsItem createAdsItem(java.lang.String companyName,
		java.lang.String numberPhone, java.lang.String email,
		java.lang.String address, java.lang.String facebook,
		java.lang.String twitter, java.lang.String description,
		java.lang.String imageContent, int timeDuring,
		java.lang.String productName, java.lang.String tags,
		java.lang.String itemType, long categoryAdsId) {
		return _adsItemService.createAdsItem(companyName, numberPhone, email,
			address, facebook, twitter, description, imageContent, timeDuring,
			productName, tags, itemType, categoryAdsId);
	}

	public irestads.model.AdsItem createAdsItem(irestads.model.AdsItem adsItem) {
		return _adsItemService.createAdsItem(adsItem);
	}

	public irestads.model.AdsItem updateAdsItem(irestads.model.AdsItem item) {
		return _adsItemService.updateAdsItem(item);
	}

	public irestads.model.AdsItem deleteAdsItem(long adsItemId) {
		return _adsItemService.deleteAdsItem(adsItemId);
	}

	public irestads.model.AdsItem findById(long adsItemId) {
		return _adsItemService.findById(adsItemId);
	}

	public java.util.List<irestads.model.AdsItem> getAllAdsItems() {
		return _adsItemService.getAllAdsItems();
	}

	public java.util.List<irestads.model.AdsItem> findAdsByCompName(
		java.lang.String keyword) {
		return _adsItemService.findAdsByCompName(keyword);
	}

	public java.util.List<irestads.model.AdsItem> findAdsByTags(
		java.lang.String keyword) {
		return _adsItemService.findAdsByTags(keyword);
	}

	public java.util.List<irestads.model.AdsItem> findAdsByProductName(
		java.lang.String keyword) {
		return _adsItemService.findAdsByProductName(keyword);
	}

	public java.util.List<irestads.model.AdsItem> findAdsByItemType(
		java.lang.String keyword) {
		return _adsItemService.findAdsByItemType(keyword);
	}

	public java.util.List<irestads.model.AdsItem> findAdsByCategoryName(
		java.lang.String keyword) {
		return _adsItemService.findAdsByCategoryName(keyword);
	}

	public java.util.List<irestads.model.AdsItem> findAdsByTimeDuration(
		int keyword) {
		return _adsItemService.findAdsByTimeDuration(keyword);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public AdsItemService getWrappedAdsItemService() {
		return _adsItemService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedAdsItemService(AdsItemService adsItemService) {
		_adsItemService = adsItemService;
	}

	public AdsItemService getWrappedService() {
		return _adsItemService;
	}

	public void setWrappedService(AdsItemService adsItemService) {
		_adsItemService = adsItemService;
	}

	private AdsItemService _adsItemService;
}