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

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import irestads.model.Lop;

import java.io.Serializable;

/**
 * The cache model class for representing Lop in entity cache.
 *
 * @author ADMIN
 * @see Lop
 * @generated
 */
public class LopCacheModel implements CacheModel<Lop>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{lopId=");
		sb.append(lopId);
		sb.append(", tenLop=");
		sb.append(tenLop);
		sb.append("}");

		return sb.toString();
	}

	public Lop toEntityModel() {
		LopImpl lopImpl = new LopImpl();

		lopImpl.setLopId(lopId);

		if (tenLop == null) {
			lopImpl.setTenLop(StringPool.BLANK);
		}
		else {
			lopImpl.setTenLop(tenLop);
		}

		lopImpl.resetOriginalValues();

		return lopImpl;
	}

	public long lopId;
	public String tenLop;
}