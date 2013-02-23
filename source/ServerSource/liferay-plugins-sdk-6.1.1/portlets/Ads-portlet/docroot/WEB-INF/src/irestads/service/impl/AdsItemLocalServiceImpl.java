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

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;


import irestads.NoSuchItemException;
import irestads.defination.LogTypeEnum;
import irestads.model.AdsItem;

import irestads.service.UVersionLocalServiceUtil;
import irestads.service.UVersionServiceUtil;
import irestads.service.base.AdsItemLocalServiceBaseImpl;
import irestads.service.persistence.AdsItemFinder;
import irestads.service.persistence.AdsItemFinderUtil;
import irestads.service.persistence.AdsItemUtil;

/**
 * The implementation of the ads item local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link irestads.service.AdsItemLocalService} interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author Be
 * @see irestads.service.base.AdsItemLocalServiceBaseImpl
 * @see irestads.service.AdsItemLocalServiceUtil
 */
public class AdsItemLocalServiceImpl extends AdsItemLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * irestads.service.AdsItemLocalServiceUtil} to access the ads item local
	 * service.
	 */
	public AdsItem createAdsItem( String companyName,
			String numberPhone, String email, String address, String facebook,
			String twitter, String description,String imageContent, int timeDuring,
			String productName, String tags, String itemType, long categoryAdsId) {
		long id;
		try {
			 id = CounterLocalServiceUtil.increment(AdsItem.class.getName());
			AdsItem adsItem = AdsItemUtil.create(id);
			adsItem.setCompanyName(companyName);
			adsItem.setNumberPhone(numberPhone);
			adsItem.setEmail(email);
			adsItem.setAddress(address);
			adsItem.setFacebook(facebook);
			adsItem.setTwitter(twitter);
			adsItem.setDescription(description);
			adsItem.setTimeDuring(timeDuring);
			adsItem.setProductName(productName);
			adsItem.setTags(tags);
			adsItem.setItemType(itemType);
			adsItem.setCategoryAdsId(categoryAdsId);
			adsItem.setImageContent(imageContent);

			adsItem = AdsItemUtil.update(adsItem, true);
			if(adsItem!=null){
				UVersionServiceUtil.createVersion(adsItem.getAdsItemId(), AdsItem.class.getName(), LogTypeEnum.CREATE.toString());
			}
			return adsItem;

		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public AdsItem createAdsItem(AdsItem adsItem){
		return this.createAdsItem(adsItem.getCompanyName(), adsItem.getNumberPhone(),
				adsItem.getEmail(), adsItem.getAddress(), adsItem.getFacebook(), 
				adsItem.getTwitter(), adsItem.getDescription(),adsItem.getImageContent(), adsItem.getTimeDuring(),
				adsItem.getProductName(), adsItem.getTags(), adsItem.getItemType(), adsItem.getCategoryAdsId());
	}
	

	public AdsItem updateAdsItem(AdsItem item) {
		try {
			AdsItem adsItem = AdsItemUtil.fetchByPrimaryKey(item.getAdsItemId());
			
			if (adsItem!= null && item.getAdsItemId() == adsItem.getAdsItemId()) {
				adsItem.setCompanyName(item.getCompanyName());
				adsItem.setNumberPhone(item.getNumberPhone());
				adsItem.setEmail(item.getEmail());
				adsItem.setAddress(item.getAddress());
				adsItem.setFacebook(item.getFacebook());
				adsItem.setTwitter(item.getTwitter());
				adsItem.setDescription(item.getDescription());
				adsItem.setTimeDuring(item.getTimeDuring());
				adsItem.setProductName(item.getProductName());
				adsItem.setTags(item.getTags());
				adsItem.setItemType(item.getItemType());
				adsItem.setCategoryAdsId(item.getCategoryAdsId());
				adsItem.setImageContent(item.getImageContent());

				adsItem=AdsItemUtil.update(adsItem, true);
				if (adsItem != null) {
					UVersionServiceUtil
							.createVersion(adsItem.getAdsItemId(), AdsItem.class.getName(),
									LogTypeEnum.UPDATE.toString());
				}
				return adsItem;
			}

		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public AdsItem deleteAdsItem(long adsItemId){
	
			try {
				AdsItem ads= AdsItemUtil.remove(adsItemId);
				if(ads!=null){
					UVersionLocalServiceUtil.checkDelete(ads.getAdsItemId());
					UVersionServiceUtil
					.createVersion(ads.getAdsItemId(),
							AdsItem.class.getName(),
							LogTypeEnum.DELETE.toString());
					}
				return ads;
			} catch (NoSuchItemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		return null;
	}
	public AdsItem findById(long adsItemId){
		try {
			return AdsItemUtil.fetchByPrimaryKey(adsItemId);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public List<AdsItem> getAllAdsItems(){
		try {
			return AdsItemUtil.findAll();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public List<AdsItem> findAdsByCompName(String keyword) {
		return AdsItemFinderUtil.findAdsByCompName(keyword);

	}

	public List<AdsItem> findAdsByTags(String keyword) {
		return AdsItemFinderUtil.findAdsByTags(keyword);

	}

	public List<AdsItem> findAdsByProductName(String keyword) {
		return AdsItemFinderUtil.findAdsByProductName(keyword);

	}

	public List<AdsItem> findAdsByItemType(String keyword) {
		return AdsItemFinderUtil.findAdsByItemType(keyword);

	}

	public List<AdsItem> findAdsByCategoryName(String keyword) {
		return AdsItemFinderUtil.findAdsByCategoryName(keyword);

	}
	public List<AdsItem> findAdsByTimeDuration(int keyword) {
		try {
			return AdsItemUtil.findByTimeDuring(keyword);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}