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

import irestads.service.MenuLineLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 */
public class MenuLineLocalServiceClpInvoker {
	public MenuLineLocalServiceClpInvoker() {
		_methodName0 = "addMenuLine";

		_methodParameterTypes0 = new String[] { "irestads.model.MenuLine" };

		_methodName1 = "createMenuLine";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteMenuLine";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteMenuLine";

		_methodParameterTypes3 = new String[] { "irestads.model.MenuLine" };

		_methodName4 = "dynamicQuery";

		_methodParameterTypes4 = new String[] {  };

		_methodName5 = "dynamicQuery";

		_methodParameterTypes5 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName6 = "dynamicQuery";

		_methodParameterTypes6 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int"
			};

		_methodName7 = "dynamicQuery";

		_methodParameterTypes7 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName8 = "dynamicQueryCount";

		_methodParameterTypes8 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName9 = "fetchMenuLine";

		_methodParameterTypes9 = new String[] { "long" };

		_methodName10 = "getMenuLine";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getPersistedModel";

		_methodParameterTypes11 = new String[] { "java.io.Serializable" };

		_methodName12 = "getMenuLines";

		_methodParameterTypes12 = new String[] { "int", "int" };

		_methodName13 = "getMenuLinesCount";

		_methodParameterTypes13 = new String[] {  };

		_methodName14 = "updateMenuLine";

		_methodParameterTypes14 = new String[] { "irestads.model.MenuLine" };

		_methodName15 = "updateMenuLine";

		_methodParameterTypes15 = new String[] {
				"irestads.model.MenuLine", "boolean"
			};

		_methodName68 = "getBeanIdentifier";

		_methodParameterTypes68 = new String[] {  };

		_methodName69 = "setBeanIdentifier";

		_methodParameterTypes69 = new String[] { "java.lang.String" };

		_methodName74 = "getAllMenuLines";

		_methodParameterTypes74 = new String[] {  };

		_methodName75 = "createMenuLine";

		_methodParameterTypes75 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "int",
				"java.lang.String", "java.lang.String", "long", "int", "boolean"
			};

		_methodName76 = "createMenuLineDish";

		_methodParameterTypes76 = new String[] { "irestads.model.MenuLine" };

		_methodName77 = "createMenuLine";

		_methodParameterTypes77 = new String[] { "long", "int", "boolean" };

		_methodName78 = "createMenuLine";

		_methodParameterTypes78 = new String[] { "irestads.model.MenuLine" };

		_methodName79 = "createMenuLine";

		_methodParameterTypes79 = new String[] { "java.util.List" };

		_methodName80 = "updateMenuLine";

		_methodParameterTypes80 = new String[] { "irestads.model.MenuLine" };

		_methodName81 = "deleteMenuLine";

		_methodParameterTypes81 = new String[] { "irestads.model.MenuLine" };

		_methodName82 = "findMenuLineById";

		_methodParameterTypes82 = new String[] { "long" };

		_methodName83 = "setDishForMenuLine";

		_methodParameterTypes83 = new String[] { "irestads.model.MenuLine" };

		_methodName84 = "setDishForMenuLine";

		_methodParameterTypes84 = new String[] { "java.util.List" };

		_methodName85 = "findMenuLinesByDishId";

		_methodParameterTypes85 = new String[] { "long" };

		_methodName86 = "findMenuLinesByDReferPrice";

		_methodParameterTypes86 = new String[] { "int" };

		_methodName87 = "findMenuLinesByDName";

		_methodParameterTypes87 = new String[] { "java.lang.String" };

		_methodName88 = "findMenuLinesByDDecription";

		_methodParameterTypes88 = new String[] { "java.lang.String" };

		_methodName89 = "findMenuLinesByDAvatarImg";

		_methodParameterTypes89 = new String[] { "java.lang.String" };

		_methodName90 = "findMenuLinesByDDetailImg";

		_methodParameterTypes90 = new String[] { "java.lang.String" };

		_methodName91 = "findMenuLinesByDDetail";

		_methodParameterTypes91 = new String[] { "java.lang.String" };

		_methodName92 = "findMenuLinesByDCategoryName";

		_methodParameterTypes92 = new String[] { "java.lang.String" };

		_methodName93 = "findMenuLinesByNumOfDish";

		_methodParameterTypes93 = new String[] { "int" };

		_methodName94 = "findMenuLinesByStatus";

		_methodParameterTypes94 = new String[] { "boolean" };

		_methodName95 = "parseBooleanToShow";

		_methodParameterTypes95 = new String[] {
				"boolean", "java.lang.String", "java.lang.String"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return MenuLineLocalServiceUtil.addMenuLine((irestads.model.MenuLine)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return MenuLineLocalServiceUtil.createMenuLine(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return MenuLineLocalServiceUtil.deleteMenuLine(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return MenuLineLocalServiceUtil.deleteMenuLine((irestads.model.MenuLine)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return MenuLineLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return MenuLineLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return MenuLineLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return MenuLineLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return MenuLineLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return MenuLineLocalServiceUtil.fetchMenuLine(((Long)arguments[0]).longValue());
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return MenuLineLocalServiceUtil.getMenuLine(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return MenuLineLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return MenuLineLocalServiceUtil.getMenuLines(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return MenuLineLocalServiceUtil.getMenuLinesCount();
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return MenuLineLocalServiceUtil.updateMenuLine((irestads.model.MenuLine)arguments[0]);
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return MenuLineLocalServiceUtil.updateMenuLine((irestads.model.MenuLine)arguments[0],
				((Boolean)arguments[1]).booleanValue());
		}

		if (_methodName68.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes68, parameterTypes)) {
			return MenuLineLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName69.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes69, parameterTypes)) {
			MenuLineLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);
		}

		if (_methodName74.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes74, parameterTypes)) {
			return MenuLineLocalServiceUtil.getAllMenuLines();
		}

		if (_methodName75.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes75, parameterTypes)) {
			return MenuLineLocalServiceUtil.createMenuLine((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3], (java.lang.String)arguments[4],
				((Integer)arguments[5]).intValue(),
				(java.lang.String)arguments[6], (java.lang.String)arguments[7],
				((Long)arguments[8]).longValue(),
				((Integer)arguments[9]).intValue(),
				((Boolean)arguments[10]).booleanValue());
		}

		if (_methodName76.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes76, parameterTypes)) {
			return MenuLineLocalServiceUtil.createMenuLineDish((irestads.model.MenuLine)arguments[0]);
		}

		if (_methodName77.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes77, parameterTypes)) {
			return MenuLineLocalServiceUtil.createMenuLine(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Boolean)arguments[2]).booleanValue());
		}

		if (_methodName78.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes78, parameterTypes)) {
			return MenuLineLocalServiceUtil.createMenuLine((irestads.model.MenuLine)arguments[0]);
		}

		if (_methodName79.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes79, parameterTypes)) {
			return MenuLineLocalServiceUtil.createMenuLine((java.util.List<irestads.model.MenuLine>)arguments[0]);
		}

		if (_methodName80.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes80, parameterTypes)) {
			return MenuLineLocalServiceUtil.updateMenuLine((irestads.model.MenuLine)arguments[0]);
		}

		if (_methodName81.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes81, parameterTypes)) {
			return MenuLineLocalServiceUtil.deleteMenuLine((irestads.model.MenuLine)arguments[0]);
		}

		if (_methodName82.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes82, parameterTypes)) {
			return MenuLineLocalServiceUtil.findMenuLineById(((Long)arguments[0]).longValue());
		}

		if (_methodName83.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes83, parameterTypes)) {
			return MenuLineLocalServiceUtil.setDishForMenuLine((irestads.model.MenuLine)arguments[0]);
		}

		if (_methodName84.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes84, parameterTypes)) {
			return MenuLineLocalServiceUtil.setDishForMenuLine((java.util.List<irestads.model.MenuLine>)arguments[0]);
		}

		if (_methodName85.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes85, parameterTypes)) {
			return MenuLineLocalServiceUtil.findMenuLinesByDishId(((Long)arguments[0]).longValue());
		}

		if (_methodName86.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes86, parameterTypes)) {
			return MenuLineLocalServiceUtil.findMenuLinesByDReferPrice(((Integer)arguments[0]).intValue());
		}

		if (_methodName87.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes87, parameterTypes)) {
			return MenuLineLocalServiceUtil.findMenuLinesByDName((java.lang.String)arguments[0]);
		}

		if (_methodName88.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes88, parameterTypes)) {
			return MenuLineLocalServiceUtil.findMenuLinesByDDecription((java.lang.String)arguments[0]);
		}

		if (_methodName89.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes89, parameterTypes)) {
			return MenuLineLocalServiceUtil.findMenuLinesByDAvatarImg((java.lang.String)arguments[0]);
		}

		if (_methodName90.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes90, parameterTypes)) {
			return MenuLineLocalServiceUtil.findMenuLinesByDDetailImg((java.lang.String)arguments[0]);
		}

		if (_methodName91.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes91, parameterTypes)) {
			return MenuLineLocalServiceUtil.findMenuLinesByDDetail((java.lang.String)arguments[0]);
		}

		if (_methodName92.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes92, parameterTypes)) {
			return MenuLineLocalServiceUtil.findMenuLinesByDCategoryName((java.lang.String)arguments[0]);
		}

		if (_methodName93.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes93, parameterTypes)) {
			return MenuLineLocalServiceUtil.findMenuLinesByNumOfDish(((Integer)arguments[0]).intValue());
		}

		if (_methodName94.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes94, parameterTypes)) {
			return MenuLineLocalServiceUtil.findMenuLinesByStatus(((Boolean)arguments[0]).booleanValue());
		}

		if (_methodName95.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes95, parameterTypes)) {
			return MenuLineLocalServiceUtil.parseBooleanToShow(((Boolean)arguments[0]).booleanValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2]);
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName0;
	private String[] _methodParameterTypes0;
	private String _methodName1;
	private String[] _methodParameterTypes1;
	private String _methodName2;
	private String[] _methodParameterTypes2;
	private String _methodName3;
	private String[] _methodParameterTypes3;
	private String _methodName4;
	private String[] _methodParameterTypes4;
	private String _methodName5;
	private String[] _methodParameterTypes5;
	private String _methodName6;
	private String[] _methodParameterTypes6;
	private String _methodName7;
	private String[] _methodParameterTypes7;
	private String _methodName8;
	private String[] _methodParameterTypes8;
	private String _methodName9;
	private String[] _methodParameterTypes9;
	private String _methodName10;
	private String[] _methodParameterTypes10;
	private String _methodName11;
	private String[] _methodParameterTypes11;
	private String _methodName12;
	private String[] _methodParameterTypes12;
	private String _methodName13;
	private String[] _methodParameterTypes13;
	private String _methodName14;
	private String[] _methodParameterTypes14;
	private String _methodName15;
	private String[] _methodParameterTypes15;
	private String _methodName68;
	private String[] _methodParameterTypes68;
	private String _methodName69;
	private String[] _methodParameterTypes69;
	private String _methodName74;
	private String[] _methodParameterTypes74;
	private String _methodName75;
	private String[] _methodParameterTypes75;
	private String _methodName76;
	private String[] _methodParameterTypes76;
	private String _methodName77;
	private String[] _methodParameterTypes77;
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
}