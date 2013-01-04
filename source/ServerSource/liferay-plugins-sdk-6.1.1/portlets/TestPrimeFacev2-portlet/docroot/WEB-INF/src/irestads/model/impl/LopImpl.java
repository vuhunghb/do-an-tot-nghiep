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

import irestads.model.SinhVien;

import java.util.ArrayList;
import java.util.List;

/**
 * The extended model implementation for the Lop service. Represents a row in the &quot;testprimeface_Lop&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link irestads.model.Lop} interface.
 * </p>
 *
 * @author ADMIN
 */
public class LopImpl extends LopBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a lop model instance should use the {@link irestads.model.Lop} interface instead.
	 */
	List<SinhVien> dssv;
	public LopImpl() {
		dssv = new ArrayList<SinhVien>();
	}
	public List<SinhVien> getDssv() {
		return dssv;
	}
	public void setDssv(List<SinhVien> dssv) {
		this.dssv = dssv;
	}
}