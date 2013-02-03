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
 * This class is a wrapper for {@link OrderLineLocalService}.
 * </p>
 *
 * @author    Be
 * @see       OrderLineLocalService
 * @generated
 */
public class OrderLineLocalServiceWrapper implements OrderLineLocalService,
	ServiceWrapper<OrderLineLocalService> {
	public OrderLineLocalServiceWrapper(
		OrderLineLocalService orderLineLocalService) {
		_orderLineLocalService = orderLineLocalService;
	}

	/**
	* Adds the order line to the database. Also notifies the appropriate model listeners.
	*
	* @param orderLine the order line
	* @return the order line that was added
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.OrderLine addOrderLine(
		irestads.model.OrderLine orderLine)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _orderLineLocalService.addOrderLine(orderLine);
	}

	/**
	* Creates a new order line with the primary key. Does not add the order line to the database.
	*
	* @param orderLineId the primary key for the new order line
	* @return the new order line
	*/
	public irestads.model.OrderLine createOrderLine(long orderLineId) {
		return _orderLineLocalService.createOrderLine(orderLineId);
	}

	/**
	* Deletes the order line with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param orderLineId the primary key of the order line
	* @return the order line that was removed
	* @throws PortalException if a order line with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.OrderLine deleteOrderLine(long orderLineId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _orderLineLocalService.deleteOrderLine(orderLineId);
	}

	/**
	* Deletes the order line from the database. Also notifies the appropriate model listeners.
	*
	* @param orderLine the order line
	* @return the order line that was removed
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.OrderLine deleteOrderLine(
		irestads.model.OrderLine orderLine)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _orderLineLocalService.deleteOrderLine(orderLine);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _orderLineLocalService.dynamicQuery();
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
		return _orderLineLocalService.dynamicQuery(dynamicQuery);
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
		return _orderLineLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _orderLineLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _orderLineLocalService.dynamicQueryCount(dynamicQuery);
	}

	public irestads.model.OrderLine fetchOrderLine(long orderLineId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _orderLineLocalService.fetchOrderLine(orderLineId);
	}

	/**
	* Returns the order line with the primary key.
	*
	* @param orderLineId the primary key of the order line
	* @return the order line
	* @throws PortalException if a order line with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.OrderLine getOrderLine(long orderLineId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _orderLineLocalService.getOrderLine(orderLineId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _orderLineLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the order lines.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of order lines
	* @param end the upper bound of the range of order lines (not inclusive)
	* @return the range of order lines
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<irestads.model.OrderLine> getOrderLines(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _orderLineLocalService.getOrderLines(start, end);
	}

	/**
	* Returns the number of order lines.
	*
	* @return the number of order lines
	* @throws SystemException if a system exception occurred
	*/
	public int getOrderLinesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _orderLineLocalService.getOrderLinesCount();
	}

	/**
	* Updates the order line in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param orderLine the order line
	* @return the order line that was updated
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.OrderLine updateOrderLine(
		irestads.model.OrderLine orderLine)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _orderLineLocalService.updateOrderLine(orderLine);
	}

	/**
	* Updates the order line in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param orderLine the order line
	* @param merge whether to merge the order line with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the order line that was updated
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.OrderLine updateOrderLine(
		irestads.model.OrderLine orderLine, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _orderLineLocalService.updateOrderLine(orderLine, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _orderLineLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_orderLineLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _orderLineLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	public irestads.model.OrderLine createOrderLine(
		java.lang.Long orderLineId, int numOfDish, int capacity,
		boolean statusDish, long dishId, long orderId) {
		return _orderLineLocalService.createOrderLine(orderLineId, numOfDish,
			capacity, statusDish, dishId, orderId);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public OrderLineLocalService getWrappedOrderLineLocalService() {
		return _orderLineLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedOrderLineLocalService(
		OrderLineLocalService orderLineLocalService) {
		_orderLineLocalService = orderLineLocalService;
	}

	public OrderLineLocalService getWrappedService() {
		return _orderLineLocalService;
	}

	public void setWrappedService(OrderLineLocalService orderLineLocalService) {
		_orderLineLocalService = orderLineLocalService;
	}

	private OrderLineLocalService _orderLineLocalService;
}