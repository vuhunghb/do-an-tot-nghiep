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
		_methodName86 = "getBeanIdentifier";

		_methodParameterTypes86 = new String[] {  };

		_methodName87 = "setBeanIdentifier";

		_methodParameterTypes87 = new String[] { "java.lang.String" };

		_methodName92 = "getAllMenuLine";

		_methodParameterTypes92 = new String[] {  };

		_methodName93 = "createMenuLine";

		_methodParameterTypes93 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "int",
				"java.lang.String", "java.lang.String", "long", "int", "boolean"
			};

		_methodName94 = "createMenuLineDish";

		_methodParameterTypes94 = new String[] { "irestads.model.MenuLine" };

		_methodName95 = "createMenuLine";

		_methodParameterTypes95 = new String[] { "irestads.model.MenuLine" };

		_methodName96 = "createMenuLine";

		_methodParameterTypes96 = new String[] { "long", "int", "boolean" };

		_methodName97 = "createMenuLine";

		_methodParameterTypes97 = new String[] { "java.util.List" };

		_methodName98 = "updateMenuLine";

		_methodParameterTypes98 = new String[] { "irestads.model.MenuLine" };

		_methodName99 = "deleteMenuLine";

		_methodParameterTypes99 = new String[] { "irestads.model.MenuLine" };

		_methodName100 = "findMenuLineById";

		_methodParameterTypes100 = new String[] { "long" };

		_methodName101 = "findMenuLinesByDReferPrice";

		_methodParameterTypes101 = new String[] { "int" };

		_methodName102 = "setDishForMenuLine";

		_methodParameterTypes102 = new String[] { "irestads.model.MenuLine" };

		_methodName103 = "findMenuLinesByDishId";

		_methodParameterTypes103 = new String[] { "long" };

		_methodName104 = "findMenuLinesByDName";

		_methodParameterTypes104 = new String[] { "java.lang.String" };

		_methodName105 = "findMenuLinesByDDecription";

		_methodParameterTypes105 = new String[] { "java.lang.String" };

		_methodName106 = "findMenuLinesByDAvatarImg";

		_methodParameterTypes106 = new String[] { "java.lang.String" };

		_methodName107 = "findMenuLinesByDDetailImg";

		_methodParameterTypes107 = new String[] { "java.lang.String" };

		_methodName108 = "findMenuLinesByDDetail";

		_methodParameterTypes108 = new String[] { "java.lang.String" };

		_methodName109 = "findMenuLinesByDCategoryName";

		_methodParameterTypes109 = new String[] { "java.lang.String" };

		_methodName110 = "findMenuLinesByNumOfDish";

		_methodParameterTypes110 = new String[] { "int" };

		_methodName111 = "findMenuLinesByStatus";

		_methodParameterTypes111 = new String[] { "boolean" };

		_methodName112 = "parseBooleanToShow";

		_methodParameterTypes112 = new String[] {
				"boolean", "java.lang.String", "java.lang.String"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName86.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes86, parameterTypes)) {
			return MenuLineServiceUtil.getBeanIdentifier();
		}

		if (_methodName87.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes87, parameterTypes)) {
			MenuLineServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);
		}

		if (_methodName92.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes92, parameterTypes)) {
			return MenuLineServiceUtil.getAllMenuLine();
		}

		if (_methodName93.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes93, parameterTypes)) {
			return MenuLineServiceUtil.createMenuLine((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3], (java.lang.String)arguments[4],
				((Integer)arguments[5]).intValue(),
				(java.lang.String)arguments[6], (java.lang.String)arguments[7],
				((Long)arguments[8]).longValue(),
				((Integer)arguments[9]).intValue(),
				((Boolean)arguments[10]).booleanValue());
		}

		if (_methodName94.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes94, parameterTypes)) {
			return MenuLineServiceUtil.createMenuLineDish((irestads.model.MenuLine)arguments[0]);
		}

		if (_methodName95.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes95, parameterTypes)) {
			return MenuLineServiceUtil.createMenuLine((irestads.model.MenuLine)arguments[0]);
		}

		if (_methodName96.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes96, parameterTypes)) {
			return MenuLineServiceUtil.createMenuLine(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Boolean)arguments[2]).booleanValue());
		}

		if (_methodName97.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes97, parameterTypes)) {
			return MenuLineServiceUtil.createMenuLine((java.util.List<irestads.model.MenuLine>)arguments[0]);
		}

		if (_methodName98.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes98, parameterTypes)) {
			return MenuLineServiceUtil.updateMenuLine((irestads.model.MenuLine)arguments[0]);
		}

		if (_methodName99.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes99, parameterTypes)) {
			return MenuLineServiceUtil.deleteMenuLine((irestads.model.MenuLine)arguments[0]);
		}

		if (_methodName100.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes100, parameterTypes)) {
			return MenuLineServiceUtil.findMenuLineById(((Long)arguments[0]).longValue());
		}

		if (_methodName101.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes101, parameterTypes)) {
			return MenuLineServiceUtil.findMenuLinesByDReferPrice(((Integer)arguments[0]).intValue());
		}

		if (_methodName102.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes102, parameterTypes)) {
			return MenuLineServiceUtil.setDishForMenuLine((irestads.model.MenuLine)arguments[0]);
		}

		if (_methodName103.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes103, parameterTypes)) {
			return MenuLineServiceUtil.findMenuLinesByDishId(((Long)arguments[0]).longValue());
		}

		if (_methodName104.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes104, parameterTypes)) {
			return MenuLineServiceUtil.findMenuLinesByDName((java.lang.String)arguments[0]);
		}

		if (_methodName105.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes105, parameterTypes)) {
			return MenuLineServiceUtil.findMenuLinesByDDecription((java.lang.String)arguments[0]);
		}

		if (_methodName106.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes106, parameterTypes)) {
			return MenuLineServiceUtil.findMenuLinesByDAvatarImg((java.lang.String)arguments[0]);
		}

		if (_methodName107.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes107, parameterTypes)) {
			return MenuLineServiceUtil.findMenuLinesByDDetailImg((java.lang.String)arguments[0]);
		}

		if (_methodName108.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes108, parameterTypes)) {
			return MenuLineServiceUtil.findMenuLinesByDDetail((java.lang.String)arguments[0]);
		}

		if (_methodName109.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes109, parameterTypes)) {
			return MenuLineServiceUtil.findMenuLinesByDCategoryName((java.lang.String)arguments[0]);
		}

		if (_methodName110.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes110, parameterTypes)) {
			return MenuLineServiceUtil.findMenuLinesByNumOfDish(((Integer)arguments[0]).intValue());
		}

		if (_methodName111.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes111, parameterTypes)) {
			return MenuLineServiceUtil.findMenuLinesByStatus(((Boolean)arguments[0]).booleanValue());
		}

		if (_methodName112.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes112, parameterTypes)) {
			return MenuLineServiceUtil.parseBooleanToShow(((Boolean)arguments[0]).booleanValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2]);
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName86;
	private String[] _methodParameterTypes86;
	private String _methodName87;
	private String[] _methodParameterTypes87;
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
	private String _methodName99;
	private String[] _methodParameterTypes99;
	private String _methodName100;
	private String[] _methodParameterTypes100;
	private String _methodName101;
	private String[] _methodParameterTypes101;
	private String _methodName102;
	private String[] _methodParameterTypes102;
	private String _methodName103;
	private String[] _methodParameterTypes103;
	private String _methodName104;
	private String[] _methodParameterTypes104;
	private String _methodName105;
	private String[] _methodParameterTypes105;
	private String _methodName106;
	private String[] _methodParameterTypes106;
	private String _methodName107;
	private String[] _methodParameterTypes107;
	private String _methodName108;
	private String[] _methodParameterTypes108;
	private String _methodName109;
	private String[] _methodParameterTypes109;
	private String _methodName110;
	private String[] _methodParameterTypes110;
	private String _methodName111;
	private String[] _methodParameterTypes111;
	private String _methodName112;
	private String[] _methodParameterTypes112;
}