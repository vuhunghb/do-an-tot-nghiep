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

package irestads.service.impl;

import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import irestads.model.AdsItem;
import irestads.service.AdsItemLocalServiceUtil;
import irestads.service.base.AdsItemServiceBaseImpl;
		
/**
 * The implementation of the ads item remote service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link irestads.service.AdsItemService} interface.
 * 
 * <p>
 * This is a remote service. Methods of this service are expected to have
 * security checks based on the propagated JAAS credentials because this service
 * can be accessed remotely.
 * </p>
 * 
 * @author Be
 * @see irestads.service.base.AdsItemServiceBaseImpl
 * @see irestads.service.AdsItemServiceUtil
 */
public class AdsItemServiceImpl extends AdsItemServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * irestads.service.AdsItemServiceUtil} to access the ads item remote
	 * service.
	 */
	public AdsItem createAdsItem( String companyName,
			String numberPhone, String email, String address, String facebook,
			String twitter, String description,String imageContent, int timeDuring,
			String productName, String tags, String itemType, long categoryAdsId) {
		return AdsItemLocalServiceUtil.createAdsItem( companyName, numberPhone, email, address, facebook, twitter, description, imageContent, timeDuring, productName, tags, itemType, categoryAdsId);
	}

	public AdsItem createAdsItem(AdsItem adsItem) {
		return AdsItemLocalServiceUtil.createAdsItem(adsItem);
	}
	public AdsItem updateAdsItem(AdsItem item) {
		try {
			return AdsItemLocalServiceUtil.updateAdsItem(item);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public AdsItem deleteAdsItem(long adsItemId){
		try {
			return AdsItemLocalServiceUtil.deleteAdsItem(adsItemId);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public AdsItem findById(long adsItemId){
		return AdsItemLocalServiceUtil.findById(adsItemId);
	}
	public List<AdsItem> getAllAdsItems(){
		return AdsItemLocalServiceUtil.getAllAdsItems();
	}
	public List<AdsItem> findAdsByCompName(String keyword) {
		return AdsItemLocalServiceUtil.findAdsByCompName(keyword);

	}

	public List<AdsItem> findAdsByTags(String keyword) {
		return AdsItemLocalServiceUtil.findAdsByTags(keyword);

	}

	public List<AdsItem> findAdsByProductName(String keyword) {
		return AdsItemLocalServiceUtil.findAdsByProductName(keyword);

	}
	public List<AdsItem> findAdsByItemType(String keyword) {
		return AdsItemLocalServiceUtil.findAdsByItemType(keyword);

	}

	public List<AdsItem> findAdsByCategoryName(String keyword) {
		return AdsItemLocalServiceUtil.findAdsByCategoryName(keyword);
	}
	public List<AdsItem> findAdsByTimeDuration(int keyword) {
		return AdsItemLocalServiceUtil.findAdsByTimeDuration(keyword);
	}

}