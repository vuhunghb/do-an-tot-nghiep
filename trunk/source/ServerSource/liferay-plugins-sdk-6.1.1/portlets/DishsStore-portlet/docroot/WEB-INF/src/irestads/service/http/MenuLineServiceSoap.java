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

import irestads.service.MenuLineServiceUtil;

import java.rmi.RemoteException;

/**
 * <p>
 * This class provides a SOAP utility for the
 * {@link irestads.service.MenuLineServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 * </p>
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link irestads.model.MenuLineSoap}.
 * If the method in the service utility returns a
 * {@link irestads.model.MenuLine}, that is translated to a
 * {@link irestads.model.MenuLineSoap}. Methods that SOAP cannot
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
 * @see       MenuLineServiceHttp
 * @see       irestads.model.MenuLineSoap
 * @see       irestads.service.MenuLineServiceUtil
 * @generated
 */
public class MenuLineServiceSoap {
	public static irestads.model.MenuLineSoap[] getAllMenuLine()
		throws RemoteException {
		try {
			java.util.List<irestads.model.MenuLine> returnValue = MenuLineServiceUtil.getAllMenuLine();

			return irestads.model.MenuLineSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static irestads.model.MenuLineSoap createMenuLine(
		java.lang.String dishName, java.lang.String decription,
		java.lang.String avatarImg, java.lang.String detailImg,
		java.lang.String detail, int referPrice,
		java.lang.String avatarBaseCode, java.lang.String detailBaseCode,
		long categoryId, int numOfDish, boolean status)
		throws RemoteException {
		try {
			irestads.model.MenuLine returnValue = MenuLineServiceUtil.createMenuLine(dishName,
					decription, avatarImg, detailImg, detail, referPrice,
					avatarBaseCode, detailBaseCode, categoryId, numOfDish,
					status);

			return irestads.model.MenuLineSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static irestads.model.MenuLineSoap createMenuLineDish(
		irestads.model.MenuLineSoap ml) throws RemoteException {
		try {
			irestads.model.MenuLine returnValue = MenuLineServiceUtil.createMenuLineDish(irestads.model.impl.MenuLineModelImpl.toModel(
						ml));

			return irestads.model.MenuLineSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static irestads.model.MenuLineSoap createMenuLine(
		irestads.model.MenuLineSoap ml) throws RemoteException {
		try {
			irestads.model.MenuLine returnValue = MenuLineServiceUtil.createMenuLine(irestads.model.impl.MenuLineModelImpl.toModel(
						ml));

			return irestads.model.MenuLineSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static irestads.model.MenuLineSoap createMenuLine(long dishId,
		int numOfDish, boolean status) throws RemoteException {
		try {
			irestads.model.MenuLine returnValue = MenuLineServiceUtil.createMenuLine(dishId,
					numOfDish, status);

			return irestads.model.MenuLineSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static irestads.model.MenuLineSoap[] createMenuLine(
		irestads.model.MenuLineSoap[] mls) throws RemoteException {
		try {
			java.util.List<irestads.model.MenuLine> returnValue = MenuLineServiceUtil.createMenuLine(irestads.model.impl.MenuLineModelImpl.toModels(
						mls));

			return irestads.model.MenuLineSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static irestads.model.MenuLineSoap updateMenuLine(
		irestads.model.MenuLineSoap ml) throws RemoteException {
		try {
			irestads.model.MenuLine returnValue = MenuLineServiceUtil.updateMenuLine(irestads.model.impl.MenuLineModelImpl.toModel(
						ml));

			return irestads.model.MenuLineSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static irestads.model.MenuLineSoap deleteMenuLine(
		irestads.model.MenuLineSoap ml) throws RemoteException {
		try {
			irestads.model.MenuLine returnValue = MenuLineServiceUtil.deleteMenuLine(irestads.model.impl.MenuLineModelImpl.toModel(
						ml));

			return irestads.model.MenuLineSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static irestads.model.MenuLineSoap findMenuLineById(long menuLineId)
		throws RemoteException {
		try {
			irestads.model.MenuLine returnValue = MenuLineServiceUtil.findMenuLineById(menuLineId);

			return irestads.model.MenuLineSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static irestads.model.MenuLineSoap[] findMenuLinesByDReferPrice(
		int price) throws RemoteException {
		try {
			java.util.List<irestads.model.MenuLine> returnValue = MenuLineServiceUtil.findMenuLinesByDReferPrice(price);

			return irestads.model.MenuLineSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static irestads.model.MenuLineSoap setDishForMenuLine(
		irestads.model.MenuLineSoap menuLine) throws RemoteException {
		try {
			irestads.model.MenuLine returnValue = MenuLineServiceUtil.setDishForMenuLine(irestads.model.impl.MenuLineModelImpl.toModel(
						menuLine));

			return irestads.model.MenuLineSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static irestads.model.MenuLineSoap findMenuLinesByDishId(long dishId)
		throws RemoteException {
		try {
			irestads.model.MenuLine returnValue = MenuLineServiceUtil.findMenuLinesByDishId(dishId);

			return irestads.model.MenuLineSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static irestads.model.MenuLineSoap[] findMenuLinesByDName(
		java.lang.String dishName) throws RemoteException {
		try {
			java.util.List<irestads.model.MenuLine> returnValue = MenuLineServiceUtil.findMenuLinesByDName(dishName);

			return irestads.model.MenuLineSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static irestads.model.MenuLineSoap[] findMenuLinesByDDecription(
		java.lang.String decription) throws RemoteException {
		try {
			java.util.List<irestads.model.MenuLine> returnValue = MenuLineServiceUtil.findMenuLinesByDDecription(decription);

			return irestads.model.MenuLineSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static irestads.model.MenuLineSoap[] findMenuLinesByDAvatarImg(
		java.lang.String avartarImg) throws RemoteException {
		try {
			java.util.List<irestads.model.MenuLine> returnValue = MenuLineServiceUtil.findMenuLinesByDAvatarImg(avartarImg);

			return irestads.model.MenuLineSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static irestads.model.MenuLineSoap[] findMenuLinesByDDetailImg(
		java.lang.String detailImg) throws RemoteException {
		try {
			java.util.List<irestads.model.MenuLine> returnValue = MenuLineServiceUtil.findMenuLinesByDDetailImg(detailImg);

			return irestads.model.MenuLineSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static irestads.model.MenuLineSoap[] findMenuLinesByDDetail(
		java.lang.String detail) throws RemoteException {
		try {
			java.util.List<irestads.model.MenuLine> returnValue = MenuLineServiceUtil.findMenuLinesByDDetail(detail);

			return irestads.model.MenuLineSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static irestads.model.MenuLineSoap[] findMenuLinesByDCategoryName(
		java.lang.String categoryName) throws RemoteException {
		try {
			java.util.List<irestads.model.MenuLine> returnValue = MenuLineServiceUtil.findMenuLinesByDCategoryName(categoryName);

			return irestads.model.MenuLineSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static irestads.model.MenuLineSoap[] findMenuLinesByNumOfDish(
		int numOfDish) throws RemoteException {
		try {
			java.util.List<irestads.model.MenuLine> returnValue = MenuLineServiceUtil.findMenuLinesByNumOfDish(numOfDish);

			return irestads.model.MenuLineSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static irestads.model.MenuLineSoap[] findMenuLinesByStatus(
		boolean status) throws RemoteException {
		try {
			java.util.List<irestads.model.MenuLine> returnValue = MenuLineServiceUtil.findMenuLinesByStatus(status);

			return irestads.model.MenuLineSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String parseBooleanToShow(boolean value,
		java.lang.String TValue, java.lang.String Fvalue)
		throws RemoteException {
		try {
			java.lang.String returnValue = MenuLineServiceUtil.parseBooleanToShow(value,
					TValue, Fvalue);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(MenuLineServiceSoap.class);
}