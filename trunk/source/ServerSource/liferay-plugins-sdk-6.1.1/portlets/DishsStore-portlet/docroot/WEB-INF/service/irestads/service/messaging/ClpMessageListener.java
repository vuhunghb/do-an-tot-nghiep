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

package irestads.service.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

import irestads.service.AdsItemLocalServiceUtil;
import irestads.service.AdsItemServiceUtil;
import irestads.service.CategoryAdsLocalServiceUtil;
import irestads.service.CategoryAdsServiceUtil;
import irestads.service.CategoryLocalServiceUtil;
import irestads.service.CategoryServiceUtil;
import irestads.service.ClpSerializer;
import irestads.service.DishLocalServiceUtil;
import irestads.service.DishServiceUtil;
import irestads.service.DishTableLocalServiceUtil;
import irestads.service.DishTableServiceUtil;
import irestads.service.MenuLineLocalServiceUtil;
import irestads.service.MenuLineServiceUtil;
import irestads.service.MenuLocalServiceUtil;
import irestads.service.MenuServiceUtil;
import irestads.service.OrderLineLocalServiceUtil;
import irestads.service.OrderLineServiceUtil;
import irestads.service.OrdersLocalServiceUtil;
import irestads.service.OrdersServiceUtil;
import irestads.service.UVersionLocalServiceUtil;
import irestads.service.UVersionServiceUtil;

/**
 * @author Brian Wing Shun Chan
 */
public class ClpMessageListener extends BaseMessageListener {
	public static String getServletContextName() {
		return ClpSerializer.getServletContextName();
	}

	@Override
	protected void doReceive(Message message) throws Exception {
		String command = message.getString("command");
		String servletContextName = message.getString("servletContextName");

		if (command.equals("undeploy") &&
				servletContextName.equals(getServletContextName())) {
			AdsItemLocalServiceUtil.clearService();

			AdsItemServiceUtil.clearService();
			CategoryLocalServiceUtil.clearService();

			CategoryServiceUtil.clearService();
			CategoryAdsLocalServiceUtil.clearService();

			CategoryAdsServiceUtil.clearService();
			DishLocalServiceUtil.clearService();

			DishServiceUtil.clearService();
			DishTableLocalServiceUtil.clearService();

			DishTableServiceUtil.clearService();
			MenuLocalServiceUtil.clearService();

			MenuServiceUtil.clearService();
			MenuLineLocalServiceUtil.clearService();

			MenuLineServiceUtil.clearService();
			OrderLineLocalServiceUtil.clearService();

			OrderLineServiceUtil.clearService();
			OrdersLocalServiceUtil.clearService();

			OrdersServiceUtil.clearService();
			UVersionLocalServiceUtil.clearService();

			UVersionServiceUtil.clearService();
		}
	}
}