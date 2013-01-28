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

package irestads.service.base;

import irestads.service.CategoryServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 */
public class CategoryServiceClpInvoker {
	public CategoryServiceClpInvoker() {
		_methodName72 = "getBeanIdentifier";

		_methodParameterTypes72 = new String[] {  };

		_methodName73 = "setBeanIdentifier";

		_methodParameterTypes73 = new String[] { "java.lang.String" };

		_methodName78 = "countCategoryById";

		_methodParameterTypes78 = new String[] { "long" };

		_methodName79 = "createCategory";

		_methodParameterTypes79 = new String[] { "java.lang.String" };

		_methodName80 = "getAllCategorys";

		_methodParameterTypes80 = new String[] {  };

		_methodName81 = "findByID";

		_methodParameterTypes81 = new String[] { "long" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName72.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes72, parameterTypes)) {
			return CategoryServiceUtil.getBeanIdentifier();
		}

		if (_methodName73.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes73, parameterTypes)) {
			CategoryServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);
		}

		if (_methodName78.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes78, parameterTypes)) {
			return CategoryServiceUtil.countCategoryById(((Long)arguments[0]).longValue());
		}

		if (_methodName79.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes79, parameterTypes)) {
			return CategoryServiceUtil.createCategory((java.lang.String)arguments[0]);
		}

		if (_methodName80.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes80, parameterTypes)) {
			return CategoryServiceUtil.getAllCategorys();
		}

		if (_methodName81.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes81, parameterTypes)) {
			return CategoryServiceUtil.findByID(((Long)arguments[0]).longValue());
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName72;
	private String[] _methodParameterTypes72;
	private String _methodName73;
	private String[] _methodParameterTypes73;
	private String _methodName78;
	private String[] _methodParameterTypes78;
	private String _methodName79;
	private String[] _methodParameterTypes79;
	private String _methodName80;
	private String[] _methodParameterTypes80;
	private String _methodName81;
	private String[] _methodParameterTypes81;
}