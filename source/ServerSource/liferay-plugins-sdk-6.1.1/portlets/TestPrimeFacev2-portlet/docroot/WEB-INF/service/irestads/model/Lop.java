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

package irestads.model;

import com.liferay.portal.model.PersistedModel;

/**
 * The extended model interface for the Lop service. Represents a row in the &quot;testprimeface_Lop&quot; database table, with each column mapped to a property of this class.
 *
 * @author ADMIN
 * @see LopModel
 * @see irestads.model.impl.LopImpl
 * @see irestads.model.impl.LopModelImpl
 * @generated
 */
public interface Lop extends LopModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link irestads.model.impl.LopImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public java.util.List<irestads.model.SinhVien> getDssv();

	public void setDssv(java.util.List<irestads.model.SinhVien> dssv);
}