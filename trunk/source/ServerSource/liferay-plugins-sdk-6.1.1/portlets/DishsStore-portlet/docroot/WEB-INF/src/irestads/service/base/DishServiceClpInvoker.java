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

import irestads.service.DishServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 */
public class DishServiceClpInvoker {
	public DishServiceClpInvoker() {
		_methodName52 = "getBeanIdentifier";

		_methodParameterTypes52 = new String[] {  };

		_methodName53 = "setBeanIdentifier";

		_methodParameterTypes53 = new String[] { "java.lang.String" };

		_methodName58 = "createDish";

		_methodParameterTypes58 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "int",
				"java.lang.String", "java.lang.String", "long"
			};

		_methodName59 = "createDish";

		_methodParameterTypes59 = new String[] { "irestads.model.Dish" };

		_methodName60 = "findDishNotInMenu";

		_methodParameterTypes60 = new String[] {  };

		_methodName61 = "getAllDishs";

		_methodParameterTypes61 = new String[] {  };

		_methodName62 = "getDishsByCategory";

		_methodParameterTypes62 = new String[] { "long" };

		_methodName63 = "updateDish";

		_methodParameterTypes63 = new String[] { "irestads.model.Dish" };

		_methodName64 = "deleteDish";

		_methodParameterTypes64 = new String[] { "irestads.model.Dish" };

		_methodName65 = "findDishsById";

		_methodParameterTypes65 = new String[] { "long" };

		_methodName66 = "findDishsByReferPrice";

		_methodParameterTypes66 = new String[] { "int" };

		_methodName67 = "findDishsByName";

		_methodParameterTypes67 = new String[] { "java.lang.String" };

		_methodName68 = "findDishsByDecription";

		_methodParameterTypes68 = new String[] { "java.lang.String" };

		_methodName69 = "findDishsByAvatarImg";

		_methodParameterTypes69 = new String[] { "java.lang.String" };

		_methodName70 = "findDishsByDetailImg";

		_methodParameterTypes70 = new String[] { "java.lang.String" };

		_methodName71 = "findDishsByDetail";

		_methodParameterTypes71 = new String[] { "java.lang.String" };

		_methodName72 = "findDishsByCategoryName";

		_methodParameterTypes72 = new String[] { "java.lang.String" };

		_methodName73 = "findDishsBySomeField";

		_methodParameterTypes73 = new String[] {
				"long", "int", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName52.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes52, parameterTypes)) {
			return DishServiceUtil.getBeanIdentifier();
		}

		if (_methodName53.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes53, parameterTypes)) {
			DishServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);
		}

		if (_methodName58.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes58, parameterTypes)) {
			return DishServiceUtil.createDish((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3], (java.lang.String)arguments[4],
				((Integer)arguments[5]).intValue(),
				(java.lang.String)arguments[6], (java.lang.String)arguments[7],
				((Long)arguments[8]).longValue());
		}

		if (_methodName59.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes59, parameterTypes)) {
			return DishServiceUtil.createDish((irestads.model.Dish)arguments[0]);
		}

		if (_methodName60.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes60, parameterTypes)) {
			return DishServiceUtil.findDishNotInMenu();
		}

		if (_methodName61.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes61, parameterTypes)) {
			return DishServiceUtil.getAllDishs();
		}

		if (_methodName62.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes62, parameterTypes)) {
			return DishServiceUtil.getDishsByCategory(((Long)arguments[0]).longValue());
		}

		if (_methodName63.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes63, parameterTypes)) {
			return DishServiceUtil.updateDish((irestads.model.Dish)arguments[0]);
		}

		if (_methodName64.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes64, parameterTypes)) {
			return DishServiceUtil.deleteDish((irestads.model.Dish)arguments[0]);
		}

		if (_methodName65.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes65, parameterTypes)) {
			return DishServiceUtil.findDishsById(((Long)arguments[0]).longValue());
		}

		if (_methodName66.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes66, parameterTypes)) {
			return DishServiceUtil.findDishsByReferPrice(((Integer)arguments[0]).intValue());
		}

		if (_methodName67.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes67, parameterTypes)) {
			return DishServiceUtil.findDishsByName((java.lang.String)arguments[0]);
		}

		if (_methodName68.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes68, parameterTypes)) {
			return DishServiceUtil.findDishsByDecription((java.lang.String)arguments[0]);
		}

		if (_methodName69.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes69, parameterTypes)) {
			return DishServiceUtil.findDishsByAvatarImg((java.lang.String)arguments[0]);
		}

		if (_methodName70.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes70, parameterTypes)) {
			return DishServiceUtil.findDishsByDetailImg((java.lang.String)arguments[0]);
		}

		if (_methodName71.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes71, parameterTypes)) {
			return DishServiceUtil.findDishsByDetail((java.lang.String)arguments[0]);
		}

		if (_methodName72.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes72, parameterTypes)) {
			return DishServiceUtil.findDishsByCategoryName((java.lang.String)arguments[0]);
		}

		if (_methodName73.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes73, parameterTypes)) {
			return DishServiceUtil.findDishsBySomeField(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3],
				(java.lang.String)arguments[4], (java.lang.String)arguments[5],
				(java.lang.String)arguments[6]);
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName52;
	private String[] _methodParameterTypes52;
	private String _methodName53;
	private String[] _methodParameterTypes53;
	private String _methodName58;
	private String[] _methodParameterTypes58;
	private String _methodName59;
	private String[] _methodParameterTypes59;
	private String _methodName60;
	private String[] _methodParameterTypes60;
	private String _methodName61;
	private String[] _methodParameterTypes61;
	private String _methodName62;
	private String[] _methodParameterTypes62;
	private String _methodName63;
	private String[] _methodParameterTypes63;
	private String _methodName64;
	private String[] _methodParameterTypes64;
	private String _methodName65;
	private String[] _methodParameterTypes65;
	private String _methodName66;
	private String[] _methodParameterTypes66;
	private String _methodName67;
	private String[] _methodParameterTypes67;
	private String _methodName68;
	private String[] _methodParameterTypes68;
	private String _methodName69;
	private String[] _methodParameterTypes69;
	private String _methodName70;
	private String[] _methodParameterTypes70;
	private String _methodName71;
	private String[] _methodParameterTypes71;
	private String _methodName72;
	private String[] _methodParameterTypes72;
	private String _methodName73;
	private String[] _methodParameterTypes73;
}