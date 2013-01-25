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

import irestads.service.UVersionLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 */
public class UVersionLocalServiceClpInvoker {
	public UVersionLocalServiceClpInvoker() {
		_methodName0 = "addUVersion";

		_methodParameterTypes0 = new String[] { "irestads.model.UVersion" };

		_methodName1 = "createUVersion";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteUVersion";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteUVersion";

		_methodParameterTypes3 = new String[] { "irestads.model.UVersion" };

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

		_methodName9 = "fetchUVersion";

		_methodParameterTypes9 = new String[] { "long" };

		_methodName10 = "getUVersion";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getPersistedModel";

		_methodParameterTypes11 = new String[] { "java.io.Serializable" };

		_methodName12 = "getUVersions";

		_methodParameterTypes12 = new String[] { "int", "int" };

		_methodName13 = "getUVersionsCount";

		_methodParameterTypes13 = new String[] {  };

		_methodName14 = "updateUVersion";

		_methodParameterTypes14 = new String[] { "irestads.model.UVersion" };

		_methodName15 = "updateUVersion";

		_methodParameterTypes15 = new String[] {
				"irestads.model.UVersion", "boolean"
			};

		_methodName70 = "getBeanIdentifier";

		_methodParameterTypes70 = new String[] {  };

		_methodName71 = "setBeanIdentifier";

		_methodParameterTypes71 = new String[] { "java.lang.String" };

		_methodName76 = "createVersion";

		_methodParameterTypes76 = new String[] { "irestads.model.UVersion" };

		_methodName77 = "createVersion";

		_methodParameterTypes77 = new String[] {
				"long", "java.lang.String", "java.lang.String"
			};

		_methodName78 = "findNextVersions";

		_methodParameterTypes78 = new String[] { "long" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return UVersionLocalServiceUtil.addUVersion((irestads.model.UVersion)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return UVersionLocalServiceUtil.createUVersion(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return UVersionLocalServiceUtil.deleteUVersion(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return UVersionLocalServiceUtil.deleteUVersion((irestads.model.UVersion)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return UVersionLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return UVersionLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return UVersionLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return UVersionLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return UVersionLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return UVersionLocalServiceUtil.fetchUVersion(((Long)arguments[0]).longValue());
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return UVersionLocalServiceUtil.getUVersion(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return UVersionLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return UVersionLocalServiceUtil.getUVersions(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return UVersionLocalServiceUtil.getUVersionsCount();
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return UVersionLocalServiceUtil.updateUVersion((irestads.model.UVersion)arguments[0]);
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return UVersionLocalServiceUtil.updateUVersion((irestads.model.UVersion)arguments[0],
				((Boolean)arguments[1]).booleanValue());
		}

		if (_methodName70.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes70, parameterTypes)) {
			return UVersionLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName71.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes71, parameterTypes)) {
			UVersionLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);
		}

		if (_methodName76.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes76, parameterTypes)) {
			return UVersionLocalServiceUtil.createVersion((irestads.model.UVersion)arguments[0]);
		}

		if (_methodName77.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes77, parameterTypes)) {
			return UVersionLocalServiceUtil.createVersion(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2]);
		}

		if (_methodName78.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes78, parameterTypes)) {
			return UVersionLocalServiceUtil.findNextVersions(((Long)arguments[0]).longValue());
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
	private String _methodName70;
	private String[] _methodParameterTypes70;
	private String _methodName71;
	private String[] _methodParameterTypes71;
	private String _methodName76;
	private String[] _methodParameterTypes76;
	private String _methodName77;
	private String[] _methodParameterTypes77;
	private String _methodName78;
	private String[] _methodParameterTypes78;
}