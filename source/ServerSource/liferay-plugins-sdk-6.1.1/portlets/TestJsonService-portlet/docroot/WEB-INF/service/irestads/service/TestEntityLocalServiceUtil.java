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
 * The utility for the test entity local service. This utility wraps {@link irestads.service.impl.TestEntityLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author ADMIN
 * @see TestEntityLocalService
 * @see irestads.service.base.TestEntityLocalServiceBaseImpl
 * @see irestads.service.impl.TestEntityLocalServiceImpl
 * @generated
 */
public class TestEntityLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link irestads.service.impl.TestEntityLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the test entity to the database. Also notifies the appropriate model listeners.
	*
	* @param testEntity the test entity
	* @return the test entity that was added
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.TestEntity addTestEntity(
		irestads.model.TestEntity testEntity)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addTestEntity(testEntity);
	}

	/**
	* Creates a new test entity with the primary key. Does not add the test entity to the database.
	*
	* @param entityId the primary key for the new test entity
	* @return the new test entity
	*/
	public static irestads.model.TestEntity createTestEntity(long entityId) {
		return getService().createTestEntity(entityId);
	}

	/**
	* Deletes the test entity with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param entityId the primary key of the test entity
	* @return the test entity that was removed
	* @throws PortalException if a test entity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.TestEntity deleteTestEntity(long entityId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteTestEntity(entityId);
	}

	/**
	* Deletes the test entity from the database. Also notifies the appropriate model listeners.
	*
	* @param testEntity the test entity
	* @return the test entity that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.TestEntity deleteTestEntity(
		irestads.model.TestEntity testEntity)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteTestEntity(testEntity);
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

	public static irestads.model.TestEntity fetchTestEntity(long entityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchTestEntity(entityId);
	}

	/**
	* Returns the test entity with the primary key.
	*
	* @param entityId the primary key of the test entity
	* @return the test entity
	* @throws PortalException if a test entity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.TestEntity getTestEntity(long entityId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getTestEntity(entityId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the test entities.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of test entities
	* @param end the upper bound of the range of test entities (not inclusive)
	* @return the range of test entities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<irestads.model.TestEntity> getTestEntities(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTestEntities(start, end);
	}

	/**
	* Returns the number of test entities.
	*
	* @return the number of test entities
	* @throws SystemException if a system exception occurred
	*/
	public static int getTestEntitiesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTestEntitiesCount();
	}

	/**
	* Updates the test entity in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param testEntity the test entity
	* @return the test entity that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.TestEntity updateTestEntity(
		irestads.model.TestEntity testEntity)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateTestEntity(testEntity);
	}

	/**
	* Updates the test entity in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param testEntity the test entity
	* @param merge whether to merge the test entity with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the test entity that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.TestEntity updateTestEntity(
		irestads.model.TestEntity testEntity, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateTestEntity(testEntity, merge);
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

	public static java.lang.String getHelloString() {
		return getService().getHelloString();
	}

	public static java.lang.String getHelloString2() {
		return getService().getHelloString2();
	}

	public static void clearService() {
		_service = null;
	}

	public static TestEntityLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					TestEntityLocalService.class.getName());

			if (invokableLocalService instanceof TestEntityLocalService) {
				_service = (TestEntityLocalService)invokableLocalService;
			}
			else {
				_service = new TestEntityLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(TestEntityLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(TestEntityLocalService service) {
	}

	private static TestEntityLocalService _service;
}