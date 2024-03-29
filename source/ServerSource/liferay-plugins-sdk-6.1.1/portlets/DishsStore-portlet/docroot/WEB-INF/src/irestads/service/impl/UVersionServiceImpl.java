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

import com.liferay.portal.kernel.exception.SystemException;

import irestads.model.UVersion;
import irestads.service.UVersionLocalServiceUtil;
import irestads.service.base.UVersionServiceBaseImpl;
import irestads.service.persistence.UVersionUtil;

/**
 * The implementation of the u version remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link irestads.service.UVersionService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have
 * security checks based on the propagated JAAS credentials because this service
 * can be accessed remotely.
 * </p>
 *
 * @author Be
 * @see irestads.service.base.UVersionServiceBaseImpl
 * @see irestads.service.UVersionServiceUtil
 */
public class UVersionServiceImpl extends UVersionServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link
	 * irestads.service.UVersionServiceUtil} to access the u version remote
	 * service.
	 */
	public UVersion createVersion(UVersion v){
		
		return UVersionLocalServiceUtil.createVersion(v);
	}

	public UVersion createVersion(long idObj, String nameObj,String type){
		return UVersionLocalServiceUtil.createVersion(idObj, nameObj, type);
	}

	public List<UVersion> findNextVersions(long uversionId) {
		return UVersionLocalServiceUtil.findNextVersions(uversionId);
	}
	public void checkDelete(String objName,long idObj){
		UVersionLocalServiceUtil.checkDelete(objName,idObj);
	}
	public List<UVersion> findBylogIdAndName(String typename, long logId){
		
		return UVersionLocalServiceUtil.findBylogIdAndName(typename,logId);
	}
	public void deleteVersion(long versionId){
		UVersionLocalServiceUtil.deleteVersion( versionId);
	}
	public UVersion updateVersion(UVersion newUversion) {
		try {
			return UVersionLocalServiceUtil.updateUVersion(newUversion);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}