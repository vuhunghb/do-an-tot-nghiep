package irestads.service.persistence;

import java.util.List;

import irestads.model.AdsItem;
import irestads.model.impl.AdsItemImpl;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class AdsItemFinderImpl extends BasePersistenceImpl<AdsItem> implements
		AdsItemFinder {
	public static String findAdsByCompName = "findAdsByCompName";
	public static String findAdsByTags = "findAdsByTags";
	public static String findAdsByProductName = "findAdsByProductName";
	public static String findAdsByItemType = "findAdsByItemType";
	public static String findAdsByCategoryName = "findAdsByCategoryName";
	public static String FIND_DISHS_BY_CATEGORY_NAME = "findDishsByCategoryName";
	public static String FIND_DISHS_BY_SOME_FIELD = "findDishsBySomeField";
	public static String FIND_DISH_NOTIN_ML = "findDishNotInMenu";

	public List<AdsItem> findAdsByCompName(String keyword) {
		return findAdsItemByProperty(keyword, findAdsByCompName);

	}

	public List<AdsItem> findAdsByTags(String keyword) {
		return findAdsItemByProperty(keyword, findAdsByTags);

	}

	public List<AdsItem> findAdsByProductName(String keyword) {
		return findAdsItemByProperty(keyword, findAdsByProductName);

	}

	public List<AdsItem> findAdsByItemType(String keyword) {
		return findAdsItemByProperty(keyword, findAdsByItemType);

	}

	public List<AdsItem> findAdsByCategoryName(String keyword) {
		return findAdsItemByProperty(keyword, findAdsByCategoryName);

	}

	public List<AdsItem> findAdsItemByProperty(String field, String idQuery) {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(idQuery);
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity("AdsItem", AdsItemImpl.class);
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
