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
public class AdsItemServiceClp implements AdsItemService {
	public AdsItemServiceClp(InvokableService invokableService) {
		_invokableService = invokableService;

		_methodName0 = "getBeanIdentifier";

		_methodParameterTypes0 = new String[] {  };

		_methodName1 = "setBeanIdentifier";

		_methodParameterTypes1 = new String[] { "java.lang.String" };

		_methodName3 = "createAdsItem";

		_methodParameterTypes3 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "int",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"long"
			};

		_methodName4 = "createAdsItem";

		_methodParameterTypes4 = new String[] { "irestads.model.AdsItem" };

		_methodName5 = "updateAdsItem";

		_methodParameterTypes5 = new String[] { "irestads.model.AdsItem" };

		_methodName6 = "deleteAdsItem";

		_methodParameterTypes6 = new String[] { "long" };

		_methodName7 = "findById";

		_methodParameterTypes7 = new String[] { "long" };

		_methodName8 = "getAllAdsItems";

		_methodParameterTypes8 = new String[] {  };

		_methodName9 = "findAdsByCompName";

		_methodParameterTypes9 = new String[] { "java.lang.String" };

		_methodName10 = "findAdsByTags";

		_methodParameterTypes10 = new String[] { "java.lang.String" };

		_methodName11 = "findAdsByProductName";

		_methodParameterTypes11 = new String[] { "java.lang.String" };

		_methodName12 = "findAdsByItemType";

		_methodParameterTypes12 = new String[] { "java.lang.String" };

		_methodName13 = "findAdsByCategoryName";

		_methodParameterTypes13 = new String[] { "java.lang.String" };

		_methodName14 = "findAdsByTimeDuration";

		_methodParameterTypes14 = new String[] { "int" };
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

	public irestads.model.AdsItem createAdsItem(java.lang.String companyName,
		java.lang.String numberPhone, java.lang.String email,
		java.lang.String address, java.lang.String facebook,
		java.lang.String twitter, java.lang.String description,
		java.lang.String imageContent, int timeDuring,
		java.lang.String productName, java.lang.String tags,
		java.lang.String itemType, long categoryAdsId) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName3,
					_methodParameterTypes3,
					new Object[] {
						ClpSerializer.translateInput(companyName),
						
					ClpSerializer.translateInput(numberPhone),
						
					ClpSerializer.translateInput(email),
						
					ClpSerializer.translateInput(address),
						
					ClpSerializer.translateInput(facebook),
						
					ClpSerializer.translateInput(twitter),
						
					ClpSerializer.translateInput(description),
						
					ClpSerializer.translateInput(imageContent),
						
					timeDuring,
						
					ClpSerializer.translateInput(productName),
						
					ClpSerializer.translateInput(tags),
						
					ClpSerializer.translateInput(itemType),
						
					categoryAdsId
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

		return (irestads.model.AdsItem)ClpSerializer.translateOutput(returnObj);
	}

	public irestads.model.AdsItem createAdsItem(irestads.model.AdsItem adsItem) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName4,
					_methodParameterTypes4,
					new Object[] { ClpSerializer.translateInput(adsItem) });
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

		return (irestads.model.AdsItem)ClpSerializer.translateOutput(returnObj);
	}

	public irestads.model.AdsItem updateAdsItem(irestads.model.AdsItem item) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName5,
					_methodParameterTypes5,
					new Object[] { ClpSerializer.translateInput(item) });
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

		return (irestads.model.AdsItem)ClpSerializer.translateOutput(returnObj);
	}

	public irestads.model.AdsItem deleteAdsItem(long adsItemId) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName6,
					_methodParameterTypes6, new Object[] { adsItemId });
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

		return (irestads.model.AdsItem)ClpSerializer.translateOutput(returnObj);
	}

	public irestads.model.AdsItem findById(long adsItemId) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName7,
					_methodParameterTypes7, new Object[] { adsItemId });
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

		return (irestads.model.AdsItem)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<irestads.model.AdsItem> getAllAdsItems() {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName8,
					_methodParameterTypes8, new Object[] {  });
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

		return (java.util.List<irestads.model.AdsItem>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<irestads.model.AdsItem> findAdsByCompName(
		java.lang.String keyword) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName9,
					_methodParameterTypes9,
					new Object[] { ClpSerializer.translateInput(keyword) });
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

		return (java.util.List<irestads.model.AdsItem>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<irestads.model.AdsItem> findAdsByTags(
		java.lang.String keyword) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName10,
					_methodParameterTypes10,
					new Object[] { ClpSerializer.translateInput(keyword) });
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

		return (java.util.List<irestads.model.AdsItem>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<irestads.model.AdsItem> findAdsByProductName(
		java.lang.String keyword) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName11,
					_methodParameterTypes11,
					new Object[] { ClpSerializer.translateInput(keyword) });
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

		return (java.util.List<irestads.model.AdsItem>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<irestads.model.AdsItem> findAdsByItemType(
		java.lang.String keyword) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName12,
					_methodParameterTypes12,
					new Object[] { ClpSerializer.translateInput(keyword) });
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

		return (java.util.List<irestads.model.AdsItem>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<irestads.model.AdsItem> findAdsByCategoryName(
		java.lang.String keyword) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName13,
					_methodParameterTypes13,
					new Object[] { ClpSerializer.translateInput(keyword) });
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

		return (java.util.List<irestads.model.AdsItem>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<irestads.model.AdsItem> findAdsByTimeDuration(
		int keyword) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName14,
					_methodParameterTypes14, new Object[] { keyword });
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

		return (java.util.List<irestads.model.AdsItem>)ClpSerializer.translateOutput(returnObj);
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
}