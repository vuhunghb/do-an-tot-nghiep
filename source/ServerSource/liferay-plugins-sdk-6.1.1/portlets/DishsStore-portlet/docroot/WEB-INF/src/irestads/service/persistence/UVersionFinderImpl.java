package irestads.service.persistence;

import java.util.List;

import irestads.model.Dish;
import irestads.model.UVersion;
import irestads.model.impl.DishImpl;
import irestads.model.impl.UVersionImpl;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class UVersionFinderImpl extends BasePersistenceImpl<UVersion> implements UVersionFinder{
	public static String FIND_BY_NEXT_VERSION = "findNextVersions";
	
	public List<UVersion> findNextVersions(long uversionId) {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_BY_NEXT_VERSION);
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity("UVersion", UVersionImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(uversionId);
			return (List) query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(session!=null) closeSession(session);
		}
		return null;
	}
//	public static void main(String[] args) {
//		UVersionFinderImpl u =new UVersionFinderImpl();
//		List<UVersion> l=u.findNextVersions(101);
//		System.out.println("size "+l.size());
//		for (int i = 0; i < l.size(); i++) {
//			System.out.println(l.get(i).getVersionId());
//			
//		}
//		
//	}

}
