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
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the lop local service. This utility wraps {@link irestads.service.impl.LopLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author ADMIN
 * @see LopLocalService
 * @see irestads.service.base.LopLocalServiceBaseImpl
 * @see irestads.service.impl.LopLocalServiceImpl
 * @generated
 */
public class LopLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link irestads.service.impl.LopLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the lop to the database. Also notifies the appropriate model listeners.
	*
	* @param lop the lop
	* @return the lop that was added
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.Lop addLop(irestads.model.Lop lop)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addLop(lop);
	}

	/**
	* Creates a new lop with the primary key. Does not add the lop to the database.
	*
	* @param lopId the primary key for the new lop
	* @return the new lop
	*/
	public static irestads.model.Lop createLop(long lopId) {
		return getService().createLop(lopId);
	}

	/**
	* Deletes the lop with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param lopId the primary key of the lop
	* @return the lop that was removed
	* @throws PortalException if a lop with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.Lop deleteLop(long lopId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteLop(lopId);
	}

	/**
	* Deletes the lop from the database. Also notifies the appropriate model listeners.
	*
	* @param lop the lop
	* @return the lop that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.Lop deleteLop(irestads.model.Lop lop)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteLop(lop);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	public static irestads.model.Lop fetchLop(long lopId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchLop(lopId);
	}

	/**
	* Returns the lop with the primary key.
	*
	* @param lopId the primary key of the lop
	* @return the lop
	* @throws PortalException if a lop with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.Lop getLop(long lopId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getLop(lopId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the lops.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of lops
	* @param end the upper bound of the range of lops (not inclusive)
	* @return the range of lops
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<irestads.model.Lop> getLops(int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getLops(start, end);
	}

	/**
	* Returns the number of lops.
	*
	* @return the number of lops
	* @throws SystemException if a system exception occurred
	*/
	public static int getLopsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getLopsCount();
	}

	/**
	* Updates the lop in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param lop the lop
	* @return the lop that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.Lop updateLop(irestads.model.Lop lop)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateLop(lop);
	}

	/**
	* Updates the lop in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param lop the lop
	* @param merge whether to merge the lop with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the lop that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.Lop updateLop(irestads.model.Lop lop,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateLop(lop, merge);
	}

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

	public static java.util.List<irestads.model.Lop> getAllLop() {
		return getService().getAllLop();
	}

	public static void clearService() {
		_service = null;
	}

	public static LopLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					LopLocalService.class.getName());

			if (invokableLocalService instanceof LopLocalService) {
				_service = (LopLocalService)invokableLocalService;
			}
			else {
				_service = new LopLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(LopLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(LopLocalService service) {
	}

	private static LopLocalService _service;
}