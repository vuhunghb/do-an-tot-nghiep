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

package irestads.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import irestads.service.AdsItemServiceUtil;

import java.rmi.RemoteException;

/**
 * <p>
 * This class provides a SOAP utility for the
 * {@link irestads.service.AdsItemServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 * </p>
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link irestads.model.AdsItemSoap}.
 * If the method in the service utility returns a
 * {@link irestads.model.AdsItem}, that is translated to a
 * {@link irestads.model.AdsItemSoap}. Methods that SOAP cannot
 * safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at
 * http://localhost:8080/api/secure/axis. Set the property
 * <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author    Be
 * @see       AdsItemServiceHttp
 * @see       irestads.model.AdsItemSoap
 * @see       irestads.service.AdsItemServiceUtil
 * @generated
 */
public class AdsItemServiceSoap {
	public static irestads.model.AdsItemSoap createAdsItem(
		java.lang.String companyName, java.lang.String numberPhone,
		java.lang.String email, java.lang.String address,
		java.lang.String facebook, java.lang.String twitter,
		java.lang.String description, java.lang.String imageContent,
		int timeDuring, java.lang.String productName, java.lang.String tags,
		java.lang.String itemType, long categoryAdsId)
		throws RemoteException {
		try {
			irestads.model.AdsItem returnValue = AdsItemServiceUtil.createAdsItem(companyName,
					numberPhone, email, address, facebook, twitter,
					description, imageContent, timeDuring, productName, tags,
					itemType, categoryAdsId);

			return irestads.model.AdsItemSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static irestads.model.AdsItemSoap createAdsItem(
		irestads.model.AdsItemSoap adsItem) throws RemoteException {
		try {
			irestads.model.AdsItem returnValue = AdsItemServiceUtil.createAdsItem(irestads.model.impl.AdsItemModelImpl.toModel(
						adsItem));

			return irestads.model.AdsItemSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static irestads.model.AdsItemSoap updateAdsItem(
		irestads.model.AdsItemSoap item) throws RemoteException {
		try {
			irestads.model.AdsItem returnValue = AdsItemServiceUtil.updateAdsItem(irestads.model.impl.AdsItemModelImpl.toModel(
						item));

			return irestads.model.AdsItemSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static irestads.model.AdsItemSoap deleteAdsItem(long adsItemId)
		throws RemoteException {
		try {
			irestads.model.AdsItem returnValue = AdsItemServiceUtil.deleteAdsItem(adsItemId);

			return irestads.model.AdsItemSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static irestads.model.AdsItemSoap findById(long adsItemId)
		throws RemoteException {
		try {
			irestads.model.AdsItem returnValue = AdsItemServiceUtil.findById(adsItemId);

			return irestads.model.AdsItemSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static irestads.model.AdsItemSoap[] getAllAdsItems()
		throws RemoteException {
		try {
			java.util.List<irestads.model.AdsItem> returnValue = AdsItemServiceUtil.getAllAdsItems();

			return irestads.model.AdsItemSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static irestads.model.AdsItemSoap[] findAdsByCompName(
		java.lang.String keyword) throws RemoteException {
		try {
			java.util.List<irestads.model.AdsItem> returnValue = AdsItemServiceUtil.findAdsByCompName(keyword);

			return irestads.model.AdsItemSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static irestads.model.AdsItemSoap[] findAdsByTags(
		java.lang.String keyword) throws RemoteException {
		try {
			java.util.List<irestads.model.AdsItem> returnValue = AdsItemServiceUtil.findAdsByTags(keyword);

			return irestads.model.AdsItemSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static irestads.model.AdsItemSoap[] findAdsByProductName(
		java.lang.String keyword) throws RemoteException {
		try {
			java.util.List<irestads.model.AdsItem> returnValue = AdsItemServiceUtil.findAdsByProductName(keyword);

			return irestads.model.AdsItemSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static irestads.model.AdsItemSoap[] findAdsByItemType(
		java.lang.String keyword) throws RemoteException {
		try {
			java.util.List<irestads.model.AdsItem> returnValue = AdsItemServiceUtil.findAdsByItemType(keyword);

			return irestads.model.AdsItemSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static irestads.model.AdsItemSoap[] findAdsByCategoryName(
		java.lang.String keyword) throws RemoteException {
		try {
			java.util.List<irestads.model.AdsItem> returnValue = AdsItemServiceUtil.findAdsByCategoryName(keyword);

			return irestads.model.AdsItemSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static irestads.model.AdsItemSoap[] findAdsByTimeDuration(
		int keyword) throws RemoteException {
		try {
			java.util.List<irestads.model.AdsItem> returnValue = AdsItemServiceUtil.findAdsByTimeDuration(keyword);

			return irestads.model.AdsItemSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(AdsItemServiceSoap.class);
}