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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.BaseLocalService;
import com.liferay.portal.service.InvokableLocalService;
import com.liferay.portal.service.PersistedModelLocalService;

/**
 * The interface for the menu line local service.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Be
 * @see MenuLineLocalServiceUtil
 * @see irestads.service.base.MenuLineLocalServiceBaseImpl
 * @see irestads.service.impl.MenuLineLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface MenuLineLocalService extends BaseLocalService,
	InvokableLocalService, PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MenuLineLocalServiceUtil} to access the menu line local service. Add custom service methods to {@link irestads.service.impl.MenuLineLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the menu line to the database. Also notifies the appropriate model listeners.
	*
	* @param menuLine the menu line
	* @return the menu line that was added
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.MenuLine addMenuLine(irestads.model.MenuLine menuLine)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates a new menu line with the primary key. Does not add the menu line to the database.
	*
	* @param menuLineId the primary key for the new menu line
	* @return the new menu line
	*/
	public irestads.model.MenuLine createMenuLine(long menuLineId);

	/**
	* Deletes the menu line with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param menuLineId the primary key of the menu line
	* @return the menu line that was removed
	* @throws PortalException if a menu line with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.MenuLine deleteMenuLine(long menuLineId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes the menu line from the database. Also notifies the appropriate model listeners.
	*
	* @param menuLine the menu line
	* @return the menu line that was removed
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.MenuLine deleteMenuLine(
		irestads.model.MenuLine menuLine)
		throws com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery();

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public irestads.model.MenuLine fetchMenuLine(long menuLineId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the menu line with the primary key.
	*
	* @param menuLineId the primary key of the menu line
	* @return the menu line
	* @throws PortalException if a menu line with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public irestads.model.MenuLine getMenuLine(long menuLineId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the menu lines.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of menu lines
	* @param end the upper bound of the range of menu lines (not inclusive)
	* @return the range of menu lines
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<irestads.model.MenuLine> getMenuLines(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of menu lines.
	*
	* @return the number of menu lines
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getMenuLinesCount()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the menu line in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param menuLine the menu line
	* @return the menu line that was updated
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.MenuLine updateMenuLine(
		irestads.model.MenuLine menuLine)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the menu line in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param menuLine the menu line
	* @param merge whether to merge the menu line with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the menu line that was updated
	* @throws SystemException if a system exception occurred
	*/
	public irestads.model.MenuLine updateMenuLine(
		irestads.model.MenuLine menuLine, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier();

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier);

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<irestads.model.MenuLine> getAllMenuLines();

	public irestads.model.MenuLine createMenuLine(java.lang.String dishName,
		java.lang.String decription, java.lang.String avatarImg,
		java.lang.String detailImg, java.lang.String detail, int referPrice,
		java.lang.String avatarBaseCode, java.lang.String detailBaseCode,
		long categoryId, int numOfDish, boolean status);

	public irestads.model.MenuLine createMenuLineDish(
		irestads.model.MenuLine ml);

	public irestads.model.MenuLine createMenuLine(long dishId, int numOfDish,
		boolean status);

	public irestads.model.MenuLine createMenuLine(irestads.model.MenuLine ml);

	public java.util.List<irestads.model.MenuLine> createMenuLine(
		java.util.List<irestads.model.MenuLine> mls);

	public irestads.model.MenuLine findMenuLineById(long menuLineId);

	public irestads.model.MenuLine setDishForMenuLine(
		irestads.model.MenuLine menuLine);

	public java.util.List<irestads.model.MenuLine> setDishForMenuLine(
		java.util.List<irestads.model.MenuLine> menuLines);

	public irestads.model.MenuLine findMenuLinesByDishId(long dishId);

	public java.util.List<irestads.model.MenuLine> findMenuLinesByDReferPrice(
		int price);

	public java.util.List<irestads.model.MenuLine> findMenuLinesByDName(
		java.lang.String dishName);

	public java.util.List<irestads.model.MenuLine> findMenuLinesByDDecription(
		java.lang.String decription);

	public java.util.List<irestads.model.MenuLine> findMenuLinesByDAvatarImg(
		java.lang.String avartarImg);

	public java.util.List<irestads.model.MenuLine> findMenuLinesByDDetailImg(
		java.lang.String detailImg);

	public java.util.List<irestads.model.MenuLine> findMenuLinesByDDetail(
		java.lang.String detail);

	public java.util.List<irestads.model.MenuLine> findMenuLinesByDCategoryName(
		java.lang.String categoryName);

	public java.util.List<irestads.model.MenuLine> findMenuLinesByNumOfDish(
		int numOfDish);

	public java.util.List<irestads.model.MenuLine> findMenuLinesByStatus(
		boolean status);

	public java.lang.String parseBooleanToShow(boolean value,
		java.lang.String TValue, java.lang.String Fvalue);
}