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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayOutputStream;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ClassLoaderObjectInputStream;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import irestads.model.CategoryClp;
import irestads.model.DishClp;
import irestads.model.MenuClp;
import irestads.model.MenuLineClp;
import irestads.model.UVersionClp;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class ClpSerializer {
	public static String getServletContextName() {
		if (Validator.isNotNull(_servletContextName)) {
			return _servletContextName;
		}

		synchronized (ClpSerializer.class) {
			if (Validator.isNotNull(_servletContextName)) {
				return _servletContextName;
			}

			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Class<?> portletPropsClass = classLoader.loadClass(
						"com.liferay.util.portlet.PortletProps");

				Method getMethod = portletPropsClass.getMethod("get",
						new Class<?>[] { String.class });

				String portletPropsServletContextName = (String)getMethod.invoke(null,
						"DishsStore-portlet-deployment-context");

				if (Validator.isNotNull(portletPropsServletContextName)) {
					_servletContextName = portletPropsServletContextName;
				}
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info(
						"Unable to locate deployment context from portlet properties");
				}
			}

			if (Validator.isNull(_servletContextName)) {
				try {
					String propsUtilServletContextName = PropsUtil.get(
							"DishsStore-portlet-deployment-context");

					if (Validator.isNotNull(propsUtilServletContextName)) {
						_servletContextName = propsUtilServletContextName;
					}
				}
				catch (Throwable t) {
					if (_log.isInfoEnabled()) {
						_log.info(
							"Unable to locate deployment context from portal properties");
					}
				}
			}

			if (Validator.isNull(_servletContextName)) {
				_servletContextName = "DishsStore-portlet";
			}

			return _servletContextName;
		}
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(CategoryClp.class.getName())) {
			return translateInputCategory(oldModel);
		}

		if (oldModelClassName.equals(DishClp.class.getName())) {
			return translateInputDish(oldModel);
		}

		if (oldModelClassName.equals(MenuClp.class.getName())) {
			return translateInputMenu(oldModel);
		}

		if (oldModelClassName.equals(MenuLineClp.class.getName())) {
			return translateInputMenuLine(oldModel);
		}

		if (oldModelClassName.equals(UVersionClp.class.getName())) {
			return translateInputUVersion(oldModel);
		}

		return oldModel;
	}

	public static Object translateInput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateInput(curObj));
		}

		return newList;
	}

	public static Object translateInputCategory(BaseModel<?> oldModel) {
		CategoryClp oldClpModel = (CategoryClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getCategoryRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputDish(BaseModel<?> oldModel) {
		DishClp oldClpModel = (DishClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getDishRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputMenu(BaseModel<?> oldModel) {
		MenuClp oldClpModel = (MenuClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getMenuRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputMenuLine(BaseModel<?> oldModel) {
		MenuLineClp oldClpModel = (MenuLineClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getMenuLineRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputUVersion(BaseModel<?> oldModel) {
		UVersionClp oldClpModel = (UVersionClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getUVersionRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateInput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateInput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals("irestads.model.impl.CategoryImpl")) {
			return translateOutputCategory(oldModel);
		}

		if (oldModelClassName.equals("irestads.model.impl.DishImpl")) {
			return translateOutputDish(oldModel);
		}

		if (oldModelClassName.equals("irestads.model.impl.MenuImpl")) {
			return translateOutputMenu(oldModel);
		}

		if (oldModelClassName.equals("irestads.model.impl.MenuLineImpl")) {
			return translateOutputMenuLine(oldModel);
		}

		if (oldModelClassName.equals("irestads.model.impl.UVersionImpl")) {
			return translateOutputUVersion(oldModel);
		}

		return oldModel;
	}

	public static Object translateOutput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateOutput(curObj));
		}

		return newList;
	}

	public static Object translateOutput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateOutput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateOutput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Throwable translateThrowable(Throwable throwable) {
		if (_useReflectionToTranslateThrowable) {
			try {
				UnsyncByteArrayOutputStream unsyncByteArrayOutputStream = new UnsyncByteArrayOutputStream();
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(unsyncByteArrayOutputStream);

				objectOutputStream.writeObject(throwable);

				objectOutputStream.flush();
				objectOutputStream.close();

				UnsyncByteArrayInputStream unsyncByteArrayInputStream = new UnsyncByteArrayInputStream(unsyncByteArrayOutputStream.unsafeGetByteArray(),
						0, unsyncByteArrayOutputStream.size());

				Thread currentThread = Thread.currentThread();

				ClassLoader contextClassLoader = currentThread.getContextClassLoader();

				ObjectInputStream objectInputStream = new ClassLoaderObjectInputStream(unsyncByteArrayInputStream,
						contextClassLoader);

				throwable = (Throwable)objectInputStream.readObject();

				objectInputStream.close();

				return throwable;
			}
			catch (SecurityException se) {
				if (_log.isInfoEnabled()) {
					_log.info("Do not use reflection to translate throwable");
				}

				_useReflectionToTranslateThrowable = false;
			}
			catch (Throwable throwable2) {
				_log.error(throwable2, throwable2);

				return throwable2;
			}
		}

		Class<?> clazz = throwable.getClass();

		String className = clazz.getName();

		if (className.equals(PortalException.class.getName())) {
			return new PortalException();
		}

		if (className.equals(SystemException.class.getName())) {
			return new SystemException();
		}

		if (className.equals("irestads.NoSuchCategoryException")) {
			return new irestads.NoSuchCategoryException();
		}

		if (className.equals("irestads.NoSuchDishException")) {
			return new irestads.NoSuchDishException();
		}

		if (className.equals("irestads.NoSuchMenuException")) {
			return new irestads.NoSuchMenuException();
		}

		if (className.equals("irestads.NoSuchMenuLineException")) {
			return new irestads.NoSuchMenuLineException();
		}

		if (className.equals("irestads.NoSuchUVersionException")) {
			return new irestads.NoSuchUVersionException();
		}

		return throwable;
	}

	public static Object translateOutputCategory(BaseModel<?> oldModel) {
		CategoryClp newModel = new CategoryClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setCategoryRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputDish(BaseModel<?> oldModel) {
		DishClp newModel = new DishClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setDishRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputMenu(BaseModel<?> oldModel) {
		MenuClp newModel = new MenuClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setMenuRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputMenuLine(BaseModel<?> oldModel) {
		MenuLineClp newModel = new MenuLineClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setMenuLineRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputUVersion(BaseModel<?> oldModel) {
		UVersionClp newModel = new UVersionClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setUVersionRemoteModel(oldModel);

		return newModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static String _servletContextName;
	private static boolean _useReflectionToTranslateThrowable = true;
}