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

package irestads.model.impl;

import irestads.model.Orders;

import com.liferay.portal.kernel.dao.orm.Order;

/**
 * The extended model implementation for the DishTable service. Represents a row in the &quot;dishsstore_DishTable&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link irestads.model.DishTable} interface.
 * </p>
 *
 * @author Be
 */
public class DishTableImpl extends DishTableBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a dish table model instance should use the {@link irestads.model.DishTable} interface instead.
	 */
	Orders curentOrder;
	public DishTableImpl() {
	}
	public Orders getCurentOrder() {
		return curentOrder;
	}
	public void setCurentOrder(Orders curentOrder) {
		this.curentOrder = curentOrder;
	}
	
	
}