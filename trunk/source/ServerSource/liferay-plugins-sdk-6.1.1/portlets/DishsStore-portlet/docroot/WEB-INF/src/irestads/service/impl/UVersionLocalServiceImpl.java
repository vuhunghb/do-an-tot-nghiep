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

import java.util.Date;
import java.util.List;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;

import irestads.defination.LogTypeEnum;
import irestads.model.Dish;
import irestads.model.MenuLine;
import irestads.model.UVersion;
import irestads.service.UVersionLocalServiceUtil;
import irestads.service.base.UVersionLocalServiceBaseImpl;
import irestads.service.persistence.UVersionFinder;
import irestads.service.persistence.UVersionFinderUtil;
import irestads.service.persistence.UVersionUtil;

/**
 * The implementation of the u version local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link irestads.service.UVersionLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Be
 * @see irestads.service.base.UVersionLocalServiceBaseImpl
 * @see irestads.service.UVersionLocalServiceUtil
 */
public class UVersionLocalServiceImpl extends UVersionLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link irestads.service.UVersionLocalServiceUtil} to access the u version local service.
	 */
	public UVersion createVersion(UVersion v){
		try {
			long id = CounterLocalServiceUtil.increment(UVersion.class.getName());
			UVersion uVersion =UVersionUtil.create(id);
			uVersion.setLogDate(new Date());
			uVersion.setLogObjId(v.getLogObjId());
			uVersion.setLogObjName(v.getLogObjName());
			uVersion.setLogType(v.getLogType());
			uVersion=	UVersionUtil.update(uVersion, true);
			return uVersion;
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
		public UVersion createVersion(long idObj, String nameObj,String type){
			try {
				long id = CounterLocalServiceUtil.increment(UVersion.class.getName());
				UVersion uVersion =UVersionUtil.create(id);
				uVersion.setLogDate(new Date());
				uVersion.setLogObjId(idObj);
				uVersion.setLogObjName(nameObj);
				uVersion.setLogType(type);
				uVersion=	UVersionUtil.update(uVersion, true);
				return uVersion;
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
		}
		
		
	}
		public List<UVersion> findNextVersions(long uversionId) {
			return UVersionFinderUtil.findNextVersions(uversionId);
		}
}