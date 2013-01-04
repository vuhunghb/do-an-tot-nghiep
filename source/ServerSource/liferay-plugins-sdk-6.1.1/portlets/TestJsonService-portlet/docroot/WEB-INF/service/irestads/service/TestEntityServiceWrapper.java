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

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link TestEntityService}.
 * </p>
 *
 * @author    ADMIN
 * @see       TestEntityService
 * @generated
 */
public class TestEntityServiceWrapper implements TestEntityService,
	ServiceWrapper<TestEntityService> {
	public TestEntityServiceWrapper(TestEntityService testEntityService) {
		_testEntityService = testEntityService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _testEntityService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_testEntityService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _testEntityService.invokeMethod(name, parameterTypes, arguments);
	}

	public java.lang.String getHelloString() {
		return _testEntityService.getHelloString();
	}

	public java.lang.String getHelloString2() {
		return _testEntityService.getHelloString2();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public TestEntityService getWrappedTestEntityService() {
		return _testEntityService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedTestEntityService(TestEntityService testEntityService) {
		_testEntityService = testEntityService;
	}

	public TestEntityService getWrappedService() {
		return _testEntityService;
	}

	public void setWrappedService(TestEntityService testEntityService) {
		_testEntityService = testEntityService;
	}

	private TestEntityService _testEntityService;
}