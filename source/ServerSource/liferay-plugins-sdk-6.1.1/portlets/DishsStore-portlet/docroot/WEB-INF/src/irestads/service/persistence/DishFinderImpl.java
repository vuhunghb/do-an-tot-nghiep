package irestads.service.persistence;

import java.util.List;

import javax.servlet.jsp.tagext.TryCatchFinally;

import irestads.model.Dish;
import irestads.model.impl.DishImpl;
import irestads.model.impl.MenuLineImpl;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringPool;

import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class DishFinderImpl extends BasePersistenceImpl<Dish> implements
		DishFinder {
	public static String FIND_DISHS_BY_NAME = "findDishsByName";
	public static String FIND_DISHS_BY_DECRIPTION = "findDishsByDecription";
	public static String FIND_DISHS_BY_AVATAR_IMG = "findDishsByAvatarImg";
	public static String FIND_DISHS_BY_DETAIL_IMG = "findDishsByDetailImg";
	public static String FIND_DISHS_BY_DETAIL = "findDishsByDetail";
	public static String FIND_DISHS_BY_CATEGORY_NAME = "findDishsByCategoryName";
	public static String FIND_DISHS_BY_SOME_FIELD="findDishsBySomeField";
	public static String FIND_DISH_NOTIN_ML = "findDishNotInMenu";
	
		public List<Dish> findDishNotInMenu() {
			Session session = null;
			try {
				session = openSession();
				String sql = CustomSQLUtil.get(FIND_DISH_NOTIN_ML);
				System.out.println("sql d n m" + sql);
				SQLQuery query = session.createSQLQuery(sql);
				query.addEntity("Dish", DishImpl.class);
				QueryPos qPos = QueryPos.getInstance(query);
				return (List) query.list();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (session != null)
					closeSession(session);
			}
			return null;
		}

	public List<Dish> findDishsByName(String dishName) {

		return this.findDishsByProperty(dishName, FIND_DISHS_BY_NAME);

	}

	public List<Dish> findDishsByDecription(String decription) {
		return findDishsByProperty(decription, FIND_DISHS_BY_DECRIPTION);
	}

	public List<Dish> findDishsByAvatarImg(String avatarImg) {
		return findDishsByProperty(avatarImg, FIND_DISHS_BY_AVATAR_IMG);
	}

	public List<Dish> findDishsByDetailImg(String detailImg) {
		return findDishsByProperty(detailImg, FIND_DISHS_BY_DETAIL_IMG);
	}

	public List<Dish> findDishsByDetail(String detail) {
		return findDishsByProperty(detail, FIND_DISHS_BY_DETAIL);
	}
	public List<Dish> findDishsByCategoryName(String categoryName) {
		return findDishsByProperty(categoryName, FIND_DISHS_BY_CATEGORY_NAME);
	
	}

	public List<Dish> findDishsByProperty(String field, String idQuery) {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(idQuery);
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity("Dish", DishImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(field);
			return (List) query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(session!=null) closeSession(session);
		}
		return null;
	}
	public List<Dish> findDishsBySomeField(long dishId,int referPrice,String dishName, String decription, String avatarImg,String detailImg, String detail) {
		
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_DISHS_BY_SOME_FIELD);
//			sql = CustomSQLUtil.replaceKeywords(sql, "lower(dishName)", StringPool.LIKE, false, dishName);
//			sql = CustomSQLUtil.replaceKeywords(sql, "lower(decription)", StringPool.LIKE, false, decription);
//			sql = CustomSQLUtil.replaceKeywords(sql, "lower(avatarImg)", StringPool.LIKE, false, avatarImg);
//			sql = CustomSQLUtil.replaceKeywords(sql, "lower(detailImg)", StringPool.LIKE, false, detailImg);
//			sql = CustomSQLUtil.replaceKeywords(sql, "lower(detail)", StringPool.LIKE, true, detail);
			 sql = CustomSQLUtil.replaceAndOperator(sql, false);
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity("Dish", DishImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			
			qPos.add(dishId);
			qPos.add(referPrice);
			qPos.add("%"+dishName+"%");
			qPos.add(dishName);
			qPos.add("%"+decription+"%");
			qPos.add(decription);
			qPos.add("%"+avatarImg+"%");
			qPos.add(avatarImg);
			qPos.add("%"+detailImg+"%");
			qPos.add(detailImg);
			qPos.add("%"+detail+"%");
			qPos.add(detail);
			
			return (List) query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(session!=null) closeSession(session);
		}
		return null;
	}
}
