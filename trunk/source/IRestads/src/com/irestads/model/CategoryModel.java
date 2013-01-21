package com.irestads.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.irestads.util.ImageUtils;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class CategoryModel {
	long categoryId;
	String categoryName;
	List<DishModel> dishs;

	public CategoryModel(long categoryId, String categoryName,
			List<DishModel> dishs) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.dishs = dishs;
	}

	public CategoryModel() {
		super();
		this.dishs = new ArrayList<DishModel>();
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<DishModel> getDishs() {
		return dishs;
	}

	public void setDishs(List<DishModel> dishs) {
		this.dishs = dishs;
	}

	public void addDish(DishModel dish) {
		this.dishs.add(dish);
		dish.setCategory(this);
	}

	public void removeDish(DishModel dish) {
		this.dishs.remove(dish);
		dish.setCategory(null);
	}

	public static List<CategoryModel> testData() {

		/* Step 1 : get List Dish like from Database */
		List<DishModel> listDishTest = new ArrayList<DishModel>();

		String imgURL = "http://ngoinhaamthuc.vn/upload/images/an-hai-san-2.jpg";
		BitmapFactory.Options bmOptions;
		bmOptions = new BitmapFactory.Options();
		bmOptions.inSampleSize = 1;

		Bitmap bm = ImageUtils.LoadImage(imgURL, bmOptions);
		byte[] data = ImageUtils.convertBitmapToArrayBite(bm);
//		String stringData = ImageUtils.encodeImage(data);
		
		String[] categoryName = { "A", "B", "C", "D", "E", "F", "G", "H", "I",
				"J", "K", "L", "M", "N", "O", "P", "Q" };

		List<CategoryModel> categories = new ArrayList<CategoryModel>();
		CategoryModel category;
		DishModel model;

		for (int i = 0; i < categoryName.length; i++) {

			for (int j = 0; j < 20; j++) {
				long dishId = (i * 20) + j;
				String desciption = "Phục vụ thực khách đòi hỏi bạn không những phải biết rỏ những món trong menu để trả lời thắc mắc của khách, mà còn phải biết cách mời chào những món ăn thức uống sao cho hấp dẫn và tỏ ra chìu ý khách. Đó là chất lượng phục vụ không thể thiếu trong một nhà hàng thành công";
				desciption += desciption;
				byte[] empty = {};
				data = (data != null && data.length > 0)?data : empty;
				model = new DishModel(dishId, categoryName[i] + j, desciption,
						"", data, "", 150000, j % 4, i);

				listDishTest.add(model);
			}
		}

		/*--Step 2 Get and Grouping Category--*/
		groupingDishInCategory(listDishTest);
		categories = new ArrayList<CategoryModel>(groupingDishInCategory(listDishTest).values());
		
		return categories;
	}

	public static Map<Long, CategoryModel> groupingDishInCategory(
			List<DishModel> dishs) {
		Map<Long, CategoryModel> categories = new HashMap<Long, CategoryModel>();
		CategoryModel category;
		DishModel dish;
		String[] categoryName = { "A", "B", "C", "D", "E", "F", "G", "H", "I",
				"J", "K", "L", "M", "N", "O", "P", "Q" };
		for (int i = 0; i < dishs.size(); i++) {
			dish = dishs.get(i);
			long categoryId = dish.getCategoryId();
			if (categories.containsKey(dish.getCategoryId()) != true) {
				/*--- will get from database --*/
				category = new CategoryModel(categoryId,
						categoryName[Integer.parseInt(categoryId + "")],
						new ArrayList<DishModel>());
				/*--- will get from database --*/
				categories.put(categoryId, category);
			}
			categories.get(categoryId).addDish(dish);
		}
		return categories;
	}

	public static void main(String[] args) {
		List<CategoryModel> categories = CategoryModel.testData();
		System.out.println("AAA");
	}

}
