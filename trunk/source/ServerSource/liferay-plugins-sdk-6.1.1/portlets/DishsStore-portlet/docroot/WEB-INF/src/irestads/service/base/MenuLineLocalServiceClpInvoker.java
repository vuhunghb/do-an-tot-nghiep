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

		_methodName102 = "getBeanIdentifier";

		_methodParameterTypes102 = new String[] {  };

		_methodName103 = "setBeanIdentifier";

		_methodParameterTypes103 = new String[] { "java.lang.String" };

		_methodName108 = "getAllMenuLines";

		_methodParameterTypes108 = new String[] {  };

		_methodName109 = "createMenuLine";

		_methodParameterTypes109 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "int",
				"java.lang.String", "java.lang.String", "long", "int", "boolean"
			};

		_methodName110 = "createMenuLineDish";

		_methodParameterTypes110 = new String[] { "irestads.model.MenuLine" };

		_methodName111 = "createMenuLine";

		_methodParameterTypes111 = new String[] { "long", "int", "boolean" };

		_methodName112 = "createMenuLine";

		_methodParameterTypes112 = new String[] { "irestads.model.MenuLine" };

		_methodName113 = "createMenuLine";

		_methodParameterTypes113 = new String[] { "java.util.List" };

		_methodName114 = "updateMenuLine";

		_methodParameterTypes114 = new String[] { "irestads.model.MenuLine" };

		_methodName115 = "deleteMenuLine";

		_methodParameterTypes115 = new String[] { "irestads.model.MenuLine" };

		_methodName116 = "findMenuLineById";

		_methodParameterTypes116 = new String[] { "long" };

		_methodName117 = "setDishForMenuLine";

		_methodParameterTypes117 = new String[] { "irestads.model.MenuLine" };

		_methodName118 = "setDishForMenuLine";

		_methodParameterTypes118 = new String[] { "java.util.List" };

		_methodName119 = "findMenuLinesByDishId";

		_methodParameterTypes119 = new String[] { "long" };

		_methodName120 = "findMenuLinesByDReferPrice";

		_methodParameterTypes120 = new String[] { "int" };

		_methodName121 = "findMenuLinesByDName";

		_methodParameterTypes121 = new String[] { "java.lang.String" };

		_methodName122 = "findMenuLinesByDDecription";

		_methodParameterTypes122 = new String[] { "java.lang.String" };

		_methodName123 = "findMenuLinesByDAvatarImg";

		_methodParameterTypes123 = new String[] { "java.lang.String" };

		_methodName124 = "findMenuLinesByDDetailImg";

		_methodParameterTypes124 = new String[] { "java.lang.String" };

		_methodName125 = "findMenuLinesByDDetail";

		_methodParameterTypes125 = new String[] { "java.lang.String" };

		_methodName126 = "findMenuLinesByDCategoryName";

		_methodParameterTypes126 = new String[] { "java.lang.String" };

		_methodName127 = "findMenuLinesByNumOfDish";

		_methodParameterTypes127 = new String[] { "int" };

		_methodName128 = "findMenuLinesByStatus";

		_methodParameterTypes128 = new String[] { "boolean" };

		_methodName129 = "parseBooleanToShow";

		_methodParameterTypes129 = new String[] {
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

		if (_methodName102.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes102, parameterTypes)) {
			return MenuLineLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName103.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes103, parameterTypes)) {
			MenuLineLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);
		}

		if (_methodName108.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes108, parameterTypes)) {
			return MenuLineLocalServiceUtil.getAllMenuLines();
		}

		if (_methodName109.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes109, parameterTypes)) {
			return MenuLineLocalServiceUtil.createMenuLine((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3], (java.lang.String)arguments[4],
				((Integer)arguments[5]).intValue(),
				(java.lang.String)arguments[6], (java.lang.String)arguments[7],
				((Long)arguments[8]).longValue(),
				((Integer)arguments[9]).intValue(),
				((Boolean)arguments[10]).booleanValue());
		}

		if (_methodName110.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes110, parameterTypes)) {
			return MenuLineLocalServiceUtil.createMenuLineDish((irestads.model.MenuLine)arguments[0]);
		}

		if (_methodName111.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes111, parameterTypes)) {
			return MenuLineLocalServiceUtil.createMenuLine(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Boolean)arguments[2]).booleanValue());
		}

		if (_methodName112.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes112, parameterTypes)) {
			return MenuLineLocalServiceUtil.createMenuLine((irestads.model.MenuLine)arguments[0]);
		}

		if (_methodName113.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes113, parameterTypes)) {
			return MenuLineLocalServiceUtil.createMenuLine((java.util.List<irestads.model.MenuLine>)arguments[0]);
		}

		if (_methodName114.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes114, parameterTypes)) {
			return MenuLineLocalServiceUtil.updateMenuLine((irestads.model.MenuLine)arguments[0]);
		}

		if (_methodName115.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes115, parameterTypes)) {
			return MenuLineLocalServiceUtil.deleteMenuLine((irestads.model.MenuLine)arguments[0]);
		}

		if (_methodName116.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes116, parameterTypes)) {
			return MenuLineLocalServiceUtil.findMenuLineById(((Long)arguments[0]).longValue());
		}

		if (_methodName117.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes117, parameterTypes)) {
			return MenuLineLocalServiceUtil.setDishForMenuLine((irestads.model.MenuLine)arguments[0]);
		}

		if (_methodName118.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes118, parameterTypes)) {
			return MenuLineLocalServiceUtil.setDishForMenuLine((java.util.List<irestads.model.MenuLine>)arguments[0]);
		}

		if (_methodName119.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes119, parameterTypes)) {
			return MenuLineLocalServiceUtil.findMenuLinesByDishId(((Long)arguments[0]).longValue());
		}

		if (_methodName120.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes120, parameterTypes)) {
			return MenuLineLocalServiceUtil.findMenuLinesByDReferPrice(((Integer)arguments[0]).intValue());
		}

		if (_methodName121.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes121, parameterTypes)) {
			return MenuLineLocalServiceUtil.findMenuLinesByDName((java.lang.String)arguments[0]);
		}

		if (_methodName122.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes122, parameterTypes)) {
			return MenuLineLocalServiceUtil.findMenuLinesByDDecription((java.lang.String)arguments[0]);
		}

		if (_methodName123.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes123, parameterTypes)) {
			return MenuLineLocalServiceUtil.findMenuLinesByDAvatarImg((java.lang.String)arguments[0]);
		}

		if (_methodName124.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes124, parameterTypes)) {
			return MenuLineLocalServiceUtil.findMenuLinesByDDetailImg((java.lang.String)arguments[0]);
		}

		if (_methodName125.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes125, parameterTypes)) {
			return MenuLineLocalServiceUtil.findMenuLinesByDDetail((java.lang.String)arguments[0]);
		}

		if (_methodName126.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes126, parameterTypes)) {
			return MenuLineLocalServiceUtil.findMenuLinesByDCategoryName((java.lang.String)arguments[0]);
		}

		if (_methodName127.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes127, parameterTypes)) {
			return MenuLineLocalServiceUtil.findMenuLinesByNumOfDish(((Integer)arguments[0]).intValue());
		}

		if (_methodName128.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes128, parameterTypes)) {
			return MenuLineLocalServiceUtil.findMenuLinesByStatus(((Boolean)arguments[0]).booleanValue());
		}

		if (_methodName129.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes129, parameterTypes)) {
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
	private String _methodName102;
	private String[] _methodParameterTypes102;
	private String _methodName103;
	private String[] _methodParameterTypes103;
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
	private String _methodName113;
	private String[] _methodParameterTypes113;
	private String _methodName114;
	private String[] _methodParameterTypes114;
	private String _methodName115;
	private String[] _methodParameterTypes115;
	private String _methodName116;
	private String[] _methodParameterTypes116;
	private String _methodName117;
	private String[] _methodParameterTypes117;
	private String _methodName118;
	private String[] _methodParameterTypes118;
	private String _methodName119;
	private String[] _methodParameterTypes119;
	private String _methodName120;
	private String[] _methodParameterTypes120;
	private String _methodName121;
	private String[] _methodParameterTypes121;
	private String _methodName122;
	private String[] _methodParameterTypes122;
	private String _methodName123;
	private String[] _methodParameterTypes123;
	private String _methodName124;
	private String[] _methodParameterTypes124;
	private String _methodName125;
	private String[] _methodParameterTypes125;
	private String _methodName126;
	private String[] _methodParameterTypes126;
	private String _methodName127;
	private String[] _methodParameterTypes127;
	private String _methodName128;
	private String[] _methodParameterTypes128;
	private String _methodName129;
	private String[] _methodParameterTypes129;
}