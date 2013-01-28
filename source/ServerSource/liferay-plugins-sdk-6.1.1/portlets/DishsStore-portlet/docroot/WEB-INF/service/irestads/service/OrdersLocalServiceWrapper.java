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

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link OrdersLocalService}.
 * </p>
 *
 * @author    Be
 * @see       OrdersLocalService
 * @generated
 */
public class OrdersLocalServiceWrapper implements OrdersLocalService,
	ServiceWrapper<OrdersLocalService> {
	public OrdersLocalServiceWrapper(OrdersLocalService ordersLocalService) {
		_ordersLocalService = ordersLocalService;
	}

	/**
	* Adds the orders to the database. Also notifies the appropriate model listeners.
	*
	* @param orders the orders
	* @return the orders that was added
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.Orders addOrders(irestads.model.Orders orders)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ordersLocalService.addOrders(orders);
	}

	/**
	* Creates a new orders with the primary key. Does not add the orders to the database.
	*
	* @param orderId the primary key for the new orders
	* @return the new orders
	*/
	public irestads.model.Orders createOrders(long orderId) {
		return _ordersLocalService.createOrders(orderId);
	}

	/**
	* Deletes the orders with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param orderId the primary key of the orders
	* @return the orders that was removed
	* @throws PortalException if a orders with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.Orders deleteOrders(long orderId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ordersLocalService.deleteOrders(orderId);
	}

	/**
	* Deletes the orders from the database. Also notifies the appropriate model listeners.
	*
	* @param orders the orders
	* @return the orders that was removed
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.Orders deleteOrders(irestads.model.Orders orders)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ordersLocalService.deleteOrders(orders);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _ordersLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ordersLocalService.dynamicQuery(dynamicQuery);
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _ordersLocalService.dynamicQuery(dynamicQuery, start, end);
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ordersLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ordersLocalService.dynamicQueryCount(dynamicQuery);
	}

	public irestads.model.Orders fetchOrders(long orderId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ordersLocalService.fetchOrders(orderId);
	}

	/**
	* Returns the orders with the primary key.
	*
	* @param orderId the primary key of the orders
	* @return the orders
	* @throws PortalException if a orders with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.Orders getOrders(long orderId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ordersLocalService.getOrders(orderId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ordersLocalService.getPersistedModel(primaryKeyObj);
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
	public java.util.List<irestads.model.Orders> getOrderses(int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ordersLocalService.getOrderses(start, end);
	}

	/**
	* Returns the number of orderses.
	*
	* @return the number of orderses
	* @throws SystemException if a system exception occurred
	*/
	public int getOrdersesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ordersLocalService.getOrdersesCount();
	}

	/**
	* Updates the orders in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param orders the orders
	* @return the orders that was updated
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.Orders updateOrders(irestads.model.Orders orders)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ordersLocalService.updateOrders(orders);
	}

	/**
	* Updates the orders in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param orders the orders
	* @param merge whether to merge the orders with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the orders that was updated
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.Orders updateOrders(irestads.model.Orders orders,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ordersLocalService.updateOrders(orders, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _ordersLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_ordersLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _ordersLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public OrdersLocalService getWrappedOrdersLocalService() {
		return _ordersLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedOrdersLocalService(
		OrdersLocalService ordersLocalService) {
		_ordersLocalService = ordersLocalService;
	}

	public OrdersLocalService getWrappedService() {
		return _ordersLocalService;
	}

	public void setWrappedService(OrdersLocalService ordersLocalService) {
		_ordersLocalService = ordersLocalService;
	}

	private OrdersLocalService _ordersLocalService;
}