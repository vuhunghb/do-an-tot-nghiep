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

package irestads.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import irestads.service.OrderLineServiceUtil;

import java.rmi.RemoteException;

/**
 * <p>
 * This class provides a SOAP utility for the
 * {@link irestads.service.OrderLineServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 * </p>
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link irestads.model.OrderLineSoap}.
 * If the method in the service utility returns a
 * {@link irestads.model.OrderLine}, that is translated to a
 * {@link irestads.model.OrderLineSoap}. Methods that SOAP cannot
 * safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at
 * http://localhost:8080/api/secure/axis. Set the property
 * <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author    Be
 * @see       OrderLineServiceHttp
 * @see       irestads.model.OrderLineSoap
 * @see       irestads.service.OrderLineServiceUtil
 * @generated
 */
public class OrderLineServiceSoap {
	public static irestads.model.OrderLineSoap createOrderLine(
		java.lang.Long orderLineId, int numOfDish, int statusDish, long dishId,
		long orderId, long orderDate) throws RemoteException {
		try {
			irestads.model.OrderLine returnValue = OrderLineServiceUtil.createOrderLine(orderLineId,
					numOfDish, statusDish, dishId, orderId, orderDate);

			return irestads.model.OrderLineSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static boolean deleteOrderLineById(long orderLineId)
		throws RemoteException {
		try {
			boolean returnValue = OrderLineServiceUtil.deleteOrderLineById(orderLineId);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static irestads.model.OrderLineSoap[] getOrderLineByOrder(
		long orderId) throws RemoteException {
		try {
			java.util.List<irestads.model.OrderLine> returnValue = OrderLineServiceUtil.getOrderLineByOrder(orderId);

			return irestads.model.OrderLineSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static irestads.model.OrderLineSoap updateOrderLine(
		long orderLineId, int numOfFinishDish, int status)
		throws RemoteException {
		try {
			irestads.model.OrderLine returnValue = OrderLineServiceUtil.updateOrderLine(orderLineId,
					numOfFinishDish, status);

			return irestads.model.OrderLineSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static irestads.model.OrderLineSoap synchStatusOrderLine(
		irestads.model.OrderLineSoap ol) throws RemoteException {
		try {
			irestads.model.OrderLine returnValue = OrderLineServiceUtil.synchStatusOrderLine(irestads.model.impl.OrderLineModelImpl.toModel(
						ol));

			return irestads.model.OrderLineSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(OrderLineServiceSoap.class);
}