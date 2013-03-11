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

import irestads.service.MenuLineServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 */
public class MenuLineServiceClpInvoker {
	public MenuLineServiceClpInvoker() {
		_methodName72 = "getBeanIdentifier";

		_methodParameterTypes72 = new String[] {  };

		_methodName73 = "setBeanIdentifier";

		_methodParameterTypes73 = new String[] { "java.lang.String" };

		_methodName78 = "getAllMenuLine";

		_methodParameterTypes78 = new String[] {  };

		_methodName79 = "createMenuLine";

		_methodParameterTypes79 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "int",
				"java.lang.String", "java.lang.String", "int", "long", "int",
				"boolean"
			};

		_methodName80 = "createMenuLineDish";

		_methodParameterTypes80 = new String[] { "irestads.model.MenuLine" };

		_methodName81 = "createMenuLine";

		_methodParameterTypes81 = new String[] { "irestads.model.MenuLine" };

		_methodName82 = "createMenuLine";

		_methodParameterTypes82 = new String[] { "long", "int", "boolean" };

		_methodName83 = "createMenuLine";

		_methodParameterTypes83 = new String[] { "java.util.List" };

		_methodName84 = "updateMenuLine";

		_methodParameterTypes84 = new String[] { "irestads.model.MenuLine" };

		_methodName85 = "deleteMenuLine";

		_methodParameterTypes85 = new String[] { "irestads.model.MenuLine" };

		_methodName86 = "findMenuLineById";

		_methodParameterTypes86 = new String[] { "long" };

		_methodName87 = "findMenuLinesByDReferPrice";

		_methodParameterTypes87 = new String[] { "int" };

		_methodName88 = "setDishForMenuLine";

		_methodParameterTypes88 = new String[] { "irestads.model.MenuLine" };

		_methodName89 = "findMenuLinesByDishId";

		_methodParameterTypes89 = new String[] { "long" };

		_methodName90 = "findMenuLinesByDName";

		_methodParameterTypes90 = new String[] { "java.lang.String" };

		_methodName91 = "findMenuLinesByDDecription";

		_methodParameterTypes91 = new String[] { "java.lang.String" };

		_methodName92 = "findMenuLinesByDAvatarImg";

		_methodParameterTypes92 = new String[] { "java.lang.String" };

		_methodName93 = "findMenuLinesByDDetailImg";

		_methodParameterTypes93 = new String[] { "java.lang.String" };

		_methodName94 = "findMenuLinesByDDetail";

		_methodParameterTypes94 = new String[] { "java.lang.String" };

		_methodName95 = "findMenuLinesByDCategoryName";

		_methodParameterTypes95 = new String[] { "java.lang.String" };

		_methodName96 = "findMenuLinesByNumOfDish";

		_methodParameterTypes96 = new String[] { "int" };

		_methodName97 = "findMenuLinesByStatus";

		_methodParameterTypes97 = new String[] { "boolean" };

		_methodName98 = "parseBooleanToShow";

		_methodParameterTypes98 = new String[] {
				"boolean", "java.lang.String", "java.lang.String"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName72.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes72, parameterTypes)) {
			return MenuLineServiceUtil.getBeanIdentifier();
		}

		if (_methodName73.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes73, parameterTypes)) {
			MenuLineServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);
		}

		if (_methodName78.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes78, parameterTypes)) {
			return MenuLineServiceUtil.getAllMenuLine();
		}

		if (_methodName79.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes79, parameterTypes)) {
			return MenuLineServiceUtil.createMenuLine((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3], (java.lang.String)arguments[4],
				((Integer)arguments[5]).intValue(),
				(java.lang.String)arguments[6], (java.lang.String)arguments[7],
				((Integer)arguments[8]).intValue(),
				((Long)arguments[9]).longValue(),
				((Integer)arguments[10]).intValue(),
				((Boolean)arguments[11]).booleanValue());
		}

		if (_methodName80.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes80, parameterTypes)) {
			return MenuLineServiceUtil.createMenuLineDish((irestads.model.MenuLine)arguments[0]);
		}

		if (_methodName81.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes81, parameterTypes)) {
			return MenuLineServiceUtil.createMenuLine((irestads.model.MenuLine)arguments[0]);
		}

		if (_methodName82.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes82, parameterTypes)) {
			return MenuLineServiceUtil.createMenuLine(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Boolean)arguments[2]).booleanValue());
		}

		if (_methodName83.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes83, parameterTypes)) {
			return MenuLineServiceUtil.createMenuLine((java.util.List<irestads.model.MenuLine>)arguments[0]);
		}

		if (_methodName84.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes84, parameterTypes)) {
			return MenuLineServiceUtil.updateMenuLine((irestads.model.MenuLine)arguments[0]);
		}

		if (_methodName85.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes85, parameterTypes)) {
			return MenuLineServiceUtil.deleteMenuLine((irestads.model.MenuLine)arguments[0]);
		}

		if (_methodName86.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes86, parameterTypes)) {
			return MenuLineServiceUtil.findMenuLineById(((Long)arguments[0]).longValue());
		}

		if (_methodName87.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes87, parameterTypes)) {
			return MenuLineServiceUtil.findMenuLinesByDReferPrice(((Integer)arguments[0]).intValue());
		}

		if (_methodName88.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes88, parameterTypes)) {
			return MenuLineServiceUtil.setDishForMenuLine((irestads.model.MenuLine)arguments[0]);
		}

		if (_methodName89.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes89, parameterTypes)) {
			return MenuLineServiceUtil.findMenuLinesByDishId(((Long)arguments[0]).longValue());
		}

		if (_methodName90.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes90, parameterTypes)) {
			return MenuLineServiceUtil.findMenuLinesByDName((java.lang.String)arguments[0]);
		}

		if (_methodName91.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes91, parameterTypes)) {
			return MenuLineServiceUtil.findMenuLinesByDDecription((java.lang.String)arguments[0]);
		}

		if (_methodName92.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes92, parameterTypes)) {
			return MenuLineServiceUtil.findMenuLinesByDAvatarImg((java.lang.String)arguments[0]);
		}

		if (_methodName93.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes93, parameterTypes)) {
			return MenuLineServiceUtil.findMenuLinesByDDetailImg((java.lang.String)arguments[0]);
		}

		if (_methodName94.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes94, parameterTypes)) {
			return MenuLineServiceUtil.findMenuLinesByDDetail((java.lang.String)arguments[0]);
		}

		if (_methodName95.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes95, parameterTypes)) {
			return MenuLineServiceUtil.findMenuLinesByDCategoryName((java.lang.String)arguments[0]);
		}

		if (_methodName96.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes96, parameterTypes)) {
			return MenuLineServiceUtil.findMenuLinesByNumOfDish(((Integer)arguments[0]).intValue());
		}

		if (_methodName97.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes97, parameterTypes)) {
			return MenuLineServiceUtil.findMenuLinesByStatus(((Boolean)arguments[0]).booleanValue());
		}

		if (_methodName98.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes98, parameterTypes)) {
			return MenuLineServiceUtil.parseBooleanToShow(((Boolean)arguments[0]).booleanValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2]);
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
	private String _methodName82;
	private String[] _methodParameterTypes82;
	private String _methodName83;
	private String[] _methodParameterTypes83;
	private String _methodName84;
	private String[] _methodParameterTypes84;
	private String _methodName85;
	private String[] _methodParameterTypes85;
	private String _methodName86;
	private String[] _methodParameterTypes86;
	private String _methodName87;
	private String[] _methodParameterTypes87;
	private String _methodName88;
	private String[] _methodParameterTypes88;
	private String _methodName89;
	private String[] _methodParameterTypes89;
	private String _methodName90;
	private String[] _methodParameterTypes90;
	private String _methodName91;
	private String[] _methodParameterTypes91;
	private String _methodName92;
	private String[] _methodParameterTypes92;
	private String _methodName93;
	private String[] _methodParameterTypes93;
	private String _methodName94;
	private String[] _methodParameterTypes94;
	private String _methodName95;
	private String[] _methodParameterTypes95;
	private String _methodName96;
	private String[] _methodParameterTypes96;
	private String _methodName97;
	private String[] _methodParameterTypes97;
	private String _methodName98;
	private String[] _methodParameterTypes98;
}