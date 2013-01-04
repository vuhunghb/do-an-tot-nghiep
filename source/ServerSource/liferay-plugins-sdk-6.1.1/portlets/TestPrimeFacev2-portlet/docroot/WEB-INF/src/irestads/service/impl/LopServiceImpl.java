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
import irestads.service.LopLocalServiceUtil;
import irestads.service.base.LopServiceBaseImpl;
import irestads.service.persistence.LopUtil;

/**
 * The implementation of the lop remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link irestads.service.LopService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author ADMIN
 * @see irestads.service.base.LopServiceBaseImpl
 * @see irestads.service.LopServiceUtil
 */
public class LopServiceImpl extends LopServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link irestads.service.LopServiceUtil} to access the lop remote service.
	 */
	public List<Lop> getAllLop(){
		
		return LopLocalServiceUtil.getAllLop();
	}
}