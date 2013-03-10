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
 * The utility for the u version remote service. This utility wraps {@link irestads.service.impl.UVersionServiceImpl} and is the primary access point for service operations in application layer code running on a remote server.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Be
 * @see UVersionService
 * @see irestads.service.base.UVersionServiceBaseImpl
 * @see irestads.service.impl.UVersionServiceImpl
 * @generated
 */
public class UVersionServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link irestads.service.impl.UVersionServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

	public static irestads.model.UVersion createVersion(
		irestads.model.UVersion v) {
		return getService().createVersion(v);
	}

	public static irestads.model.UVersion createVersion(long idObj,
		java.lang.String nameObj, java.lang.String type) {
		return getService().createVersion(idObj, nameObj, type);
	}

	public static java.util.List<irestads.model.UVersion> findNextVersions(
		long uversionId) {
		return getService().findNextVersions(uversionId);
	}

	public static void checkDelete(java.lang.String objName, long idObj) {
		getService().checkDelete(objName, idObj);
	}

	public static java.util.List<irestads.model.UVersion> findBylogIdAndName(
		java.lang.String typename, long logId) {
		return getService().findBylogIdAndName(typename, logId);
	}

	public static void deleteVersion(long versionId) {
		getService().deleteVersion(versionId);
	}

	public static irestads.model.UVersion updateVersion(
		irestads.model.UVersion newUversion) {
		return getService().updateVersion(newUversion);
	}

	public static void clearService() {
		_service = null;
	}

	public static UVersionService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					UVersionService.class.getName());

			if (invokableService instanceof UVersionService) {
				_service = (UVersionService)invokableService;
			}
			else {
				_service = new UVersionServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(UVersionServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(UVersionService service) {
	}

	private static UVersionService _service;
}