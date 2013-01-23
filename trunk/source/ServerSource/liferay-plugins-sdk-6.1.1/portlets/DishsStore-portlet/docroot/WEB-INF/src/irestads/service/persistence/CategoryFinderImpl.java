package irestads.service.persistence;

import java.util.Iterator;
import java.util.List;

import irestads.model.Category;
import irestads.model.Dish;
import irestads.model.impl.CategoryImpl;
import irestads.model.impl.DishImpl;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class CategoryFinderImpl extends BasePersistenceImpl<Category> implements CategoryFinder{

	public static String COUNT_CATEGORY_BY_ID = "countCategoryById";
	
	public int countCategoryById(long categoryId) {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(COUNT_CATEGORY_BY_ID);
			System.out.println("couter " + sql);
			SQLQuery query = session.createSQLQuery(sql);
			query.addScalar(COUNT_COLUMN_NAME, Type.LONG);
			query.addEntity("Category", CategoryImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(categoryId);
			
			Iterator<Long> itr = query.list().iterator();

			if (itr.hasNext()) {
				Long count = itr.next();

				if (count != null) {
					return count.intValue();
				}
			}
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				closeSession(session);
		}
		return 0;
	}

}
