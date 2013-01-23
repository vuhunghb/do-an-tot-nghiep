package irestads.service.persistence;

import java.util.List;

import irestads.model.Dish;
import irestads.model.MenuLine;
import irestads.model.impl.DishImpl;
import irestads.model.impl.MenuLineImpl;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.service.persistence.BasePersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class MenuLineFinderImpl extends BasePersistenceImpl<MenuLine> implements
		MenuLineFinder {
	public static String FIND_MLS_BY_NAME = "findMLsByDName";
	public static String FIND_MLS_BY_DECRIPTION = "findMLsByDDecription";
	public static String FIND_MLS_BY_AVATAR_IMG = "findMLsByDAvatarImg";
	public static String FIND_MLS_BY_DETAIL_IMG = "findMLsByDDetailImg";
	public static String FIND_MLS_BY_DETAIL = "findMLsByDDetail";
	public static String FIND_MLS_BY_CATEGORY_NAME = "findMlsByDCategoryName";
	public static String FIND_MLS_BY_NumOfDish = "findMLsByNumofDish";
	public static String FIND_MLS_BY_STATUS = "findMLsByStatus";
	public static String FIND_MLS_BY_SOME_FIELD = "findMLsBySomeField";
	public static String FIND_MLS_BY_REFER_PRICE = "findMlsByDReferPrice";
//	public static String FIND_DISH_NOTIN_ML = "findDishNotInMenu";
//
//	public List<Dish> findDishNotInMenu() {
//		Session session = null;
//		try {
//			session = openSession();
//			String sql = CustomSQLUtil.get(FIND_DISH_NOTIN_ML);
//			System.out.println("sql d n m" + sql);
//			SQLQuery query = session.createSQLQuery(sql);
//			query.addEntity("Dish", DishImpl.class);
//			QueryPos qPos = QueryPos.getInstance(query);
//			return (List) query.list();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			if (session != null)
//				closeSession(session);
//		}
//		return null;
//	}

	public List<MenuLine> findMenuLinesByDName(String dishName) {
		return this.findMenuLinesByDish(dishName, FIND_MLS_BY_NAME);
	}

	public List<MenuLine> findMenuLinesByDDecription(String decription) {
		return this.findMenuLinesByDish(decription, FIND_MLS_BY_DECRIPTION);
	}

	public List<MenuLine> findMenuLinesByDAvatarImg(String avartarImg) {
		return this.findMenuLinesByDish(avartarImg, FIND_MLS_BY_AVATAR_IMG);
	}

	public List<MenuLine> findMenuLinesByDDetailImg(String detailImg) {
		return this.findMenuLinesByDish(detailImg, FIND_MLS_BY_DETAIL_IMG);
	}

	public List<MenuLine> findMenuLinesByDDetail(String detail) {
		return this.findMenuLinesByDish(detail, FIND_MLS_BY_DETAIL);
	}

	public List<MenuLine> findMenuLinesByDCategoryName(String categoryName) {
		return this
				.findMenuLinesByDish(categoryName, FIND_MLS_BY_CATEGORY_NAME);
	}

	public List<MenuLine> findMenuLinesByDReferPrice(int price) {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_MLS_BY_REFER_PRICE);
			System.out.println("sql PRICE " + sql);
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity("MenuLine", MenuLineImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(price);
			return (List) query.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				closeSession(session);
		}
		return null;
	}

	public List<MenuLine> findMenuLinesByDish(String field, String idQuery) {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(idQuery);
			System.out.println("sql " + sql);
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity("MenuLine", MenuLineImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add("%" + field + "%");
			return (List) query.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				closeSession(session);
		}
		return null;
	}
}
