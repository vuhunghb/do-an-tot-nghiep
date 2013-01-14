package mybean;

import java.util.LinkedHashMap;
import java.util.Map;

public class MyUtil {
	
	public static Map<String, Object> searchTypesForStoreDish(){
		Map<String, Object> searchTypes=new LinkedHashMap<String, Object>();
		searchTypes.put("Tất cả", 0);
		searchTypes.put("Loại",1 );
		searchTypes.put("Mã món ăn",2 );
		searchTypes.put("Têm món ăn",3 );
		searchTypes.put("Giá tham khảo",4 );
		searchTypes.put("hình đại diện",5 );
		searchTypes.put("hình chi tiết",6 );
		
		
		return searchTypes;
	}

}
