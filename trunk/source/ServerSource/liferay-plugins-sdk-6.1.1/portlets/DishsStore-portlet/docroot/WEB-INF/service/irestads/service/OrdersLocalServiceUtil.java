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
 * The utility for the orders local service. This utility wraps {@link irestads.service.impl.OrdersLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Be
 * @see OrdersLocalService
 * @see irestads.service.base.OrdersLocalServiceBaseImpl
 * @see irestads.service.impl.OrdersLocalServiceImpl
 * @generated
 */
public class OrdersLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link irestads.service.impl.OrdersLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the orders to the database. Also notifies the appropriate model listeners.
	*
	* @param orders the orders
	* @return the orders that was added
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.Orders addOrders(irestads.model.Orders orders)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addOrders(orders);
	}

	/**
	* Creates a new orders with the primary key. Does not add the orders to the database.
	*
	* @param orderId the primary key for the new orders
	* @return the new orders
	*/
	public static irestads.model.Orders createOrders(long orderId) {
		return getService().createOrders(orderId);
	}

	/**
	* Deletes the orders with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param orderId the primary key of the orders
	* @return the orders that was removed
	* @throws PortalException if a orders with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.Orders deleteOrders(long orderId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteOrders(orderId);
	}

	/**
	* Deletes the orders from the database. Also notifies the appropriate model listeners.
	*
	* @param orders the orders
	* @return the orders that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.Orders deleteOrders(
		irestads.model.Orders orders)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteOrders(orders);
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

	public static irestads.model.Orders fetchOrders(long orderId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchOrders(orderId);
	}

	/**
	* Returns the orders with the primary key.
	*
	* @param orderId the primary key of the orders
	* @return the orders
	* @throws PortalException if a orders with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.Orders getOrders(long orderId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getOrders(orderId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the orderses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of orderses
	* @param end the upper bound of the range of orderses (not inclusive)
	* @return the range of orderses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<irestads.model.Orders> getOrderses(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getOrderses(start, end);
	}

	/**
	* Returns the number of orderses.
	*
	* @return the number of orderses
	* @throws SystemException if a system exception occurred
	*/
	public static int getOrdersesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getOrdersesCount();
	}

	/**
	* Updates the orders in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param orders the orders
	* @return the orders that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.Orders updateOrders(
		irestads.model.Orders orders)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateOrders(orders);
	}

	/**
	* Updates the orders in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param orders the orders
	* @param merge whether to merge the orders with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the orders that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static irestads.model.Orders updateOrders(
		irestads.model.Orders orders, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateOrders(orders, merge);
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

	public static irestads.model.Orders findOrderById(long orderId) {
		return getService().findOrderById(orderId);
	}

	public static irestads.model.Orders createOrders(long orderId, int charge,
		int isPayment, int numOfDinner, java.lang.String dishTableId,
		long createdDate) {
		return getService()
				   .createOrders(orderId, charge, isPayment, numOfDinner,
			dishTableId, createdDate);
	}

	public static irestads.model.Orders updateOrder(irestads.model.Orders o) {
		return getService().updateOrder(o);
	}

	public static boolean deleteOrderById(long orderId) {
		return getService().deleteOrderById(orderId);
	}

	public static boolean setWaitingStatus(long orderId) {
		return getService().setWaitingStatus(orderId);
	}

	public static void clearService() {
		_service = null;
	}

	public static OrdersLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					OrdersLocalService.class.getName());

			if (invokableLocalService instanceof OrdersLocalService) {
				_service = (OrdersLocalService)invokableLocalService;
			}
			else {
				_service = new OrdersLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(OrdersLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(OrdersLocalService service) {
	}

	private static OrdersLocalService _service;
}