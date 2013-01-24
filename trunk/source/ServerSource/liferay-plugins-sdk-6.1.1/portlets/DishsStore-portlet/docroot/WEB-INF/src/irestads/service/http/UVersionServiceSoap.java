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

import irestads.service.UVersionServiceUtil;

import java.rmi.RemoteException;

/**
 * <p>
 * This class provides a SOAP utility for the
 * {@link irestads.service.UVersionServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 * </p>
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link irestads.model.UVersionSoap}.
 * If the method in the service utility returns a
 * {@link irestads.model.UVersion}, that is translated to a
 * {@link irestads.model.UVersionSoap}. Methods that SOAP cannot
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
 * @see       UVersionServiceHttp
 * @see       irestads.model.UVersionSoap
 * @see       irestads.service.UVersionServiceUtil
 * @generated
 */
public class UVersionServiceSoap {
	public static irestads.model.UVersionSoap createVersion(
		irestads.model.UVersionSoap v) throws RemoteException {
		try {
			irestads.model.UVersion returnValue = UVersionServiceUtil.createVersion(irestads.model.impl.UVersionModelImpl.toModel(
						v));

			return irestads.model.UVersionSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static irestads.model.UVersionSoap createVersion(long idObj,
		java.lang.String nameObj, java.lang.String type)
		throws RemoteException {
		try {
			irestads.model.UVersion returnValue = UVersionServiceUtil.createVersion(idObj,
					nameObj, type);

			return irestads.model.UVersionSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static irestads.model.UVersionSoap[] findNextVersions(
		long uversionId) throws RemoteException {
		try {
			java.util.List<irestads.model.UVersion> returnValue = UVersionServiceUtil.findNextVersions(uversionId);

			return irestads.model.UVersionSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(UVersionServiceSoap.class);
}