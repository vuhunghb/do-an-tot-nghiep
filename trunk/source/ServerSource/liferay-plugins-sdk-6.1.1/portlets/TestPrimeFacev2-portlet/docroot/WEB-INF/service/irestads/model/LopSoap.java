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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link irestads.service.http.LopServiceSoap}.
 *
 * @author    ADMIN
 * @see       irestads.service.http.LopServiceSoap
 * @generated
 */
public class LopSoap implements Serializable {
	public static LopSoap toSoapModel(Lop model) {
		LopSoap soapModel = new LopSoap();

		soapModel.setLopId(model.getLopId());
		soapModel.setTenLop(model.getTenLop());

		return soapModel;
	}

	public static LopSoap[] toSoapModels(Lop[] models) {
		LopSoap[] soapModels = new LopSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LopSoap[][] toSoapModels(Lop[][] models) {
		LopSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LopSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LopSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LopSoap[] toSoapModels(List<Lop> models) {
		List<LopSoap> soapModels = new ArrayList<LopSoap>(models.size());

		for (Lop model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LopSoap[soapModels.size()]);
	}

	public LopSoap() {
	}

	public long getPrimaryKey() {
		return _lopId;
	}

	public void setPrimaryKey(long pk) {
		setLopId(pk);
	}

	public long getLopId() {
		return _lopId;
	}

	public void setLopId(long lopId) {
		_lopId = lopId;
	}

	public String getTenLop() {
		return _tenLop;
	}

	public void setTenLop(String tenLop) {
		_tenLop = tenLop;
	}

	private long _lopId;
	private String _tenLop;
}