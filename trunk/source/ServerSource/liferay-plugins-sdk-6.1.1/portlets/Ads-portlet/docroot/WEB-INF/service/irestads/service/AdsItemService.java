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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.BaseService;
import com.liferay.portal.service.InvokableService;

/**
 * The interface for the ads item remote service.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Be
 * @see AdsItemServiceUtil
 * @see irestads.service.base.AdsItemServiceBaseImpl
 * @see irestads.service.impl.AdsItemServiceImpl
 * @generated
 */
@JSONWebService
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface AdsItemService extends BaseService, InvokableService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AdsItemServiceUtil} to access the ads item remote service. Add custom service methods to {@link irestads.service.impl.AdsItemServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier();

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier);

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable;

	public irestads.model.AdsItem createAdsItem(java.lang.String companyName,
		java.lang.String numberPhone, java.lang.String email,
		java.lang.String address, java.lang.String facebook,
		java.lang.String twitter, java.lang.String description,
		java.lang.String imageContent, int timeDuring,
		java.lang.String productName, java.lang.String tags,
		java.lang.String itemType, long categoryAdsId);

	public irestads.model.AdsItem createAdsItem(irestads.model.AdsItem adsItem);

	public irestads.model.AdsItem updateAdsItem(irestads.model.AdsItem item);

	public irestads.model.AdsItem deleteAdsItem(long adsItemId);

	public irestads.model.AdsItem findById(long adsItemId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<irestads.model.AdsItem> getAllAdsItems();

	public java.util.List<irestads.model.AdsItem> findAdsByCompName(
		java.lang.String keyword);

	public java.util.List<irestads.model.AdsItem> findAdsByTags(
		java.lang.String keyword);

	public java.util.List<irestads.model.AdsItem> findAdsByProductName(
		java.lang.String keyword);

	public java.util.List<irestads.model.AdsItem> findAdsByItemType(
		java.lang.String keyword);

	public java.util.List<irestads.model.AdsItem> findAdsByCategoryName(
		java.lang.String keyword);

	public java.util.List<irestads.model.AdsItem> findAdsByTimeDuration(
		int keyword);
}