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

import com.liferay.portal.service.InvokableService;

/**
 * @author Be
 */
public class MenuLineServiceClp implements MenuLineService {
	public MenuLineServiceClp(InvokableService invokableService) {
		_invokableService = invokableService;

		_methodName0 = "getBeanIdentifier";

		_methodParameterTypes0 = new String[] {  };

		_methodName1 = "setBeanIdentifier";

		_methodParameterTypes1 = new String[] { "java.lang.String" };

		_methodName3 = "getAllMenuLine";

		_methodParameterTypes3 = new String[] {  };

		_methodName4 = "createMenuLine";

		_methodParameterTypes4 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "int",
				"java.lang.String", "java.lang.String", "long", "int", "boolean"
			};

		_methodName5 = "createMenuLineDish";

		_methodParameterTypes5 = new String[] { "irestads.model.MenuLine" };

		_methodName6 = "createMenuLine";

		_methodParameterTypes6 = new String[] { "irestads.model.MenuLine" };

		_methodName7 = "createMenuLine";

		_methodParameterTypes7 = new String[] { "long", "int", "boolean" };

		_methodName8 = "createMenuLine";

		_methodParameterTypes8 = new String[] { "java.util.List" };

		_methodName9 = "updateMenuLine";

		_methodParameterTypes9 = new String[] { "irestads.model.MenuLine" };

		_methodName10 = "deleteMenuLine";

		_methodParameterTypes10 = new String[] { "irestads.model.MenuLine" };

		_methodName11 = "findMenuLineById";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "findMenuLinesByDReferPrice";

		_methodParameterTypes12 = new String[] { "int" };

		_methodName13 = "setDishForMenuLine";

		_methodParameterTypes13 = new String[] { "irestads.model.MenuLine" };

		_methodName14 = "findMenuLinesByDishId";

		_methodParameterTypes14 = new String[] { "long" };

		_methodName15 = "findMenuLinesByDName";

		_methodParameterTypes15 = new String[] { "java.lang.String" };

		_methodName16 = "findMenuLinesByDDecription";

		_methodParameterTypes16 = new String[] { "java.lang.String" };

		_methodName17 = "findMenuLinesByDAvatarImg";

		_methodParameterTypes17 = new String[] { "java.lang.String" };

		_methodName18 = "findMenuLinesByDDetailImg";

		_methodParameterTypes18 = new String[] { "java.lang.String" };

		_methodName19 = "findMenuLinesByDDetail";

		_methodParameterTypes19 = new String[] { "java.lang.String" };

		_methodName20 = "findMenuLinesByDCategoryName";

		_methodParameterTypes20 = new String[] { "java.lang.String" };

		_methodName21 = "findMenuLinesByNumOfDish";

		_methodParameterTypes21 = new String[] { "int" };

		_methodName22 = "findMenuLinesByStatus";

		_methodParameterTypes22 = new String[] { "boolean" };

		_methodName23 = "parseBooleanToShow";

		_methodParameterTypes23 = new String[] {
				"boolean", "java.lang.String", "java.lang.String"
			};
	}

	public java.lang.String getBeanIdentifier() {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName0,
					_methodParameterTypes0, new Object[] {  });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		try {
			_invokableService.invokeMethod(_methodName1,
				_methodParameterTypes1,
				new Object[] { ClpSerializer.translateInput(beanIdentifier) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		throw new UnsupportedOperationException();
	}

	public java.util.List<irestads.model.MenuLine> getAllMenuLine() {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName3,
					_methodParameterTypes3, new Object[] {  });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<irestads.model.MenuLine>)ClpSerializer.translateOutput(returnObj);
	}

	public irestads.model.MenuLine createMenuLine(java.lang.String dishName,
		java.lang.String decription, java.lang.String avatarImg,
		java.lang.String detailImg, java.lang.String detail, int referPrice,
		java.lang.String avatarBaseCode, java.lang.String detailBaseCode,
		long categoryId, int numOfDish, boolean status) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName4,
					_methodParameterTypes4,
					new Object[] {
						ClpSerializer.translateInput(dishName),
						
					ClpSerializer.translateInput(decription),
						
					ClpSerializer.translateInput(avatarImg),
						
					ClpSerializer.translateInput(detailImg),
						
					ClpSerializer.translateInput(detail),
						
					referPrice,
						
					ClpSerializer.translateInput(avatarBaseCode),
						
					ClpSerializer.translateInput(detailBaseCode),
						
					categoryId,
						
					numOfDish,
						
					status
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (irestads.model.MenuLine)ClpSerializer.translateOutput(returnObj);
	}

	public irestads.model.MenuLine createMenuLineDish(
		irestads.model.MenuLine ml) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName5,
					_methodParameterTypes5,
					new Object[] { ClpSerializer.translateInput(ml) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (irestads.model.MenuLine)ClpSerializer.translateOutput(returnObj);
	}

	public irestads.model.MenuLine createMenuLine(irestads.model.MenuLine ml) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName6,
					_methodParameterTypes6,
					new Object[] { ClpSerializer.translateInput(ml) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (irestads.model.MenuLine)ClpSerializer.translateOutput(returnObj);
	}

	public irestads.model.MenuLine createMenuLine(long dishId, int numOfDish,
		boolean status) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName7,
					_methodParameterTypes7,
					new Object[] { dishId, numOfDish, status });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (irestads.model.MenuLine)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<irestads.model.MenuLine> createMenuLine(
		java.util.List<irestads.model.MenuLine> mls) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName8,
					_methodParameterTypes8,
					new Object[] { ClpSerializer.translateInput(mls) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<irestads.model.MenuLine>)ClpSerializer.translateOutput(returnObj);
	}

	public irestads.model.MenuLine updateMenuLine(irestads.model.MenuLine ml) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName9,
					_methodParameterTypes9,
					new Object[] { ClpSerializer.translateInput(ml) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (irestads.model.MenuLine)ClpSerializer.translateOutput(returnObj);
	}

	public irestads.model.MenuLine deleteMenuLine(irestads.model.MenuLine ml) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName10,
					_methodParameterTypes10,
					new Object[] { ClpSerializer.translateInput(ml) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (irestads.model.MenuLine)ClpSerializer.translateOutput(returnObj);
	}

	public irestads.model.MenuLine findMenuLineById(long menuLineId) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName11,
					_methodParameterTypes11, new Object[] { menuLineId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (irestads.model.MenuLine)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<irestads.model.MenuLine> findMenuLinesByDReferPrice(
		int price) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName12,
					_methodParameterTypes12, new Object[] { price });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<irestads.model.MenuLine>)ClpSerializer.translateOutput(returnObj);
	}

	public irestads.model.MenuLine setDishForMenuLine(
		irestads.model.MenuLine menuLine) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName13,
					_methodParameterTypes13,
					new Object[] { ClpSerializer.translateInput(menuLine) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (irestads.model.MenuLine)ClpSerializer.translateOutput(returnObj);
	}

	public irestads.model.MenuLine findMenuLinesByDishId(long dishId) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName14,
					_methodParameterTypes14, new Object[] { dishId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (irestads.model.MenuLine)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<irestads.model.MenuLine> findMenuLinesByDName(
		java.lang.String dishName) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName15,
					_methodParameterTypes15,
					new Object[] { ClpSerializer.translateInput(dishName) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<irestads.model.MenuLine>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<irestads.model.MenuLine> findMenuLinesByDDecription(
		java.lang.String decription) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName16,
					_methodParameterTypes16,
					new Object[] { ClpSerializer.translateInput(decription) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<irestads.model.MenuLine>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<irestads.model.MenuLine> findMenuLinesByDAvatarImg(
		java.lang.String avartarImg) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName17,
					_methodParameterTypes17,
					new Object[] { ClpSerializer.translateInput(avartarImg) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<irestads.model.MenuLine>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<irestads.model.MenuLine> findMenuLinesByDDetailImg(
		java.lang.String detailImg) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName18,
					_methodParameterTypes18,
					new Object[] { ClpSerializer.translateInput(detailImg) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<irestads.model.MenuLine>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<irestads.model.MenuLine> findMenuLinesByDDetail(
		java.lang.String detail) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName19,
					_methodParameterTypes19,
					new Object[] { ClpSerializer.translateInput(detail) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<irestads.model.MenuLine>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<irestads.model.MenuLine> findMenuLinesByDCategoryName(
		java.lang.String categoryName) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName20,
					_methodParameterTypes20,
					new Object[] { ClpSerializer.translateInput(categoryName) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<irestads.model.MenuLine>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<irestads.model.MenuLine> findMenuLinesByNumOfDish(
		int numOfDish) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName21,
					_methodParameterTypes21, new Object[] { numOfDish });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<irestads.model.MenuLine>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<irestads.model.MenuLine> findMenuLinesByStatus(
		boolean status) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName22,
					_methodParameterTypes22, new Object[] { status });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<irestads.model.MenuLine>)ClpSerializer.translateOutput(returnObj);
	}

	public java.lang.String parseBooleanToShow(boolean value,
		java.lang.String TValue, java.lang.String Fvalue) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName23,
					_methodParameterTypes23,
					new Object[] {
						value,
						
					ClpSerializer.translateInput(TValue),
						
					ClpSerializer.translateInput(Fvalue)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	private InvokableService _invokableService;
	private String _methodName0;
	private String[] _methodParameterTypes0;
	private String _methodName1;
	private String[] _methodParameterTypes1;
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
	private String _methodName16;
	private String[] _methodParameterTypes16;
	private String _methodName17;
	private String[] _methodParameterTypes17;
	private String _methodName18;
	private String[] _methodParameterTypes18;
	private String _methodName19;
	private String[] _methodParameterTypes19;
	private String _methodName20;
	private String[] _methodParameterTypes20;
	private String _methodName21;
	private String[] _methodParameterTypes21;
	private String _methodName22;
	private String[] _methodParameterTypes22;
	private String _methodName23;
	private String[] _methodParameterTypes23;
}