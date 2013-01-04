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

import irestads.model.Lop;
import irestads.service.base.LopLocalServiceBaseImpl;
import irestads.service.persistence.LopUtil;

/**
 * The implementation of the lop local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link irestads.service.LopLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author ADMIN
 * @see irestads.service.base.LopLocalServiceBaseImpl
 * @see irestads.service.LopLocalServiceUtil
 */
public class LopLocalServiceImpl extends LopLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link irestads.service.LopLocalServiceUtil} to access the lop local service.
	 */
	
	public List<Lop> getAllLop(){
		try {
			return LopUtil.findAll();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}