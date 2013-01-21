package com.irestads;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.irestads.dao.CategoryDAO;
import com.irestads.dao.DishDAO;
import com.irestads.model.CategoryModel;
import com.irestads.model.DishModel;
import com.irestads.util.ImageUtils;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Gallery.LayoutParams;

@SuppressLint("NewApi")
public class MainListActivity extends Activity {

	List<CategoryModel> categories;
	TextView sce1LeftCategoryName;
	int currentCategoryIndex = 0;
	CategoryModel currentCategoryModel;

	List<LinearLayout> leftDishListView;
	int currentDishIndex = 0;
	DishModel currentDishModel;
	LinearLayout leftListDishLayout;
	CategoryDAO categoryDAO;
	DishDAO dishDAO;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().setFormat(PixelFormat.RGBA_8888);
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_DITHER);
		setContentView(R.layout.activity_mainlist);

		ActionBar actionBar = getActionBar();
		actionBar.hide();

		categoryDAO = new CategoryDAO(this);
		dishDAO = new DishDAO(this);
		// insertDataTest();

		categories = getAllCategory();

		if (categories.size() != 0 && categories != null) {

			initCurrentStatus();

			sce1LeftCategoryName = (TextView) findViewById(R.id.sce1_left_category_name);
			sce1LeftCategoryName.setText(categories.get(currentCategoryIndex)
					.getCategoryName());

			/*--------------ListDish----------------*/
			leftDishListView = new ArrayList<LinearLayout>();
			leftListDishLayout = (LinearLayout) findViewById(R.id.scr1_left_list_dish_layout);

			updateSce1LeftDishList();
			updateSce1LeftDishSelected(currentDishIndex);
		}
	}

	public void insertDataTest() {
		this.categories = CategoryModel.testData();
		/*-----Test Dish DB--------*/
		// dishDAO.open();
		// for (CategoryModel category : categories) {
		// for (DishModel dish : category.getDishs()) {
		// long id = dishDAO.saveOrUpdateDish(dish);
		// }
		// }
		// dishDAO.close();

		/*-----Test Category DB--------*/
		categoryDAO.open();
		for (CategoryModel category : categories) {
			categoryDAO.saveOrUpdateCategory(category);
		}
		categoryDAO.close();
	}

	public List<DishModel> getDishsByCategoryId(long categoryId) {
		dishDAO.open();
		List<DishModel> dishs = dishDAO.getDishsByCategoryId(categoryId);
		dishDAO.close();
		return dishs;
	}

	public List<CategoryModel> getDishsByCategory(long categoryId) {
		dishDAO.open();
		List<DishModel> dishs = dishDAO.getDishsByCategoryId(categoryId);
		List<CategoryModel> categories = new ArrayList<CategoryModel>(
				groupingDishInCategory(dishs).values());
		dishDAO.close();
		return categories;
	}

	public byte[] getAvatarOfDish(long id) {
		dishDAO.open();
		byte[] result = dishDAO.getAvatarOfDish(id);
		dishDAO.close();
		return result;
	}

	public List<CategoryModel> getAllCategory() {
		categoryDAO.open();
		List<CategoryModel> categories = categoryDAO.getAllCategory();
		categoryDAO.close();
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

	/***
	 * This method to set current index for category and dish. it will get id
	 * from shared preference and compare with id of category and dish
	 */
	public void initCurrentStatus() {

		SharedPreferences sharedPreferences = getSharedPreferences(
				MainActivity.PREFS_NAME, 0);
		long refsCategoryId = sharedPreferences.getLong(
				"scr1CurrentCategoryId", 0);
		long refsDisId = sharedPreferences.getLong("scr1CurrentDishId", 0);

		currentCategoryIndex = 0;
		currentDishIndex = 0;
		CategoryModel category;
		DishModel dish;

		List<DishModel> dishs = new ArrayList<DishModel>();
		if (refsDisId != 0 && refsCategoryId != 0) {
			for (int i = 0; i < this.categories.size(); i++) {
				category = this.categories.get(i);
				if (category.getCategoryId() == refsCategoryId) {
					currentCategoryIndex = i;
					dishs = getDishsByCategoryId(category.getCategoryId());

					for (int j = 0; j < dishs.size(); j++) {
						dish = dishs.get(j);
						if (dish.getDishID() == refsDisId) {
							currentDishIndex = j;
							break;
						}
					}
					break;
				}
			}
		}

		currentCategoryModel = this.categories.get(currentCategoryIndex);
		dishs = (dishs.size() > 0) ? dishs
				: getDishsByCategoryId(currentCategoryModel.getCategoryId());
		currentCategoryModel.setDishs(dishs);
		currentDishModel = currentCategoryModel.getDishs()
				.get(currentDishIndex);
		currentDishModel.setAvatarImg(getAvatarOfDish(currentDishModel
				.getDishID()));

	}

	/**
	 * This method is used to listening event when user click left/right arrow
	 * near category name
	 * 
	 * @param view
	 */
	public void onClickLeftCategoryArrow(View view) {
		LinearLayout layout = (LinearLayout) view;
		int id = layout.getId();
		if (this.categories.size() > 0) {
			if (id == R.id.sce1_left_category_left) {
				currentCategoryIndex = (currentCategoryIndex == 0) ? (categories
						.size() - 1) : currentCategoryIndex - 1;
			} else {
				currentCategoryIndex = (currentCategoryIndex == categories
						.size() - 1) ? (0) : currentCategoryIndex + 1;
			}

			currentCategoryModel = this.categories.get(currentCategoryIndex);
			currentCategoryModel
					.setDishs(getDishsByCategoryId(currentCategoryModel
							.getCategoryId()));

			sce1LeftCategoryName
					.setText(currentCategoryModel.getCategoryName());

			updateSce1LeftDishList();
			updateSce1LeftDishSelected(0);
		}

	}

	/***
	 * Update Left panel with list dish
	 */
	public void updateSce1LeftDishList() {
		if (currentCategoryIndex >= 0
				&& currentCategoryIndex < this.categories.size()) {

			leftDishListView = new ArrayList<LinearLayout>();
			leftListDishLayout.removeAllViews();

			LinearLayout dishItemLayout;
			LinearLayout.LayoutParams itemLayout = new LinearLayout.LayoutParams(
					LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
			LinearLayout.LayoutParams itemNameLayout = new LinearLayout.LayoutParams(
					190, LayoutParams.WRAP_CONTENT);
			LinearLayout.LayoutParams itemPriceLayout = new LinearLayout.LayoutParams(
					100, LayoutParams.WRAP_CONTENT);

			TextView nameText, priceText;
			for (int i = 0; i < currentCategoryModel.getDishs().size(); i++) {
				dishItemLayout = new LinearLayout(this);
				dishItemLayout.setPadding(0, 0, 0, 10);
				dishItemLayout.setLayoutParams(itemLayout);
				dishItemLayout.setGravity(Gravity.CENTER_VERTICAL);

				nameText = new TextView(dishItemLayout.getContext());
				nameText.setPadding(20, 0, 0, 0);
				nameText.setTextAppearance(dishItemLayout.getContext(),
						android.R.style.TextAppearance_Medium);
				nameText.setLayoutParams(itemNameLayout);
				nameText.setText(currentCategoryModel.getDishs().get(i)
						.getDishName());

				priceText = new TextView(dishItemLayout.getContext());
				priceText.setPadding(5, 0, 0, 0);
				priceText.setTextAppearance(dishItemLayout.getContext(),
						android.R.style.TextAppearance_Medium);
				priceText.setLayoutParams(itemPriceLayout);
				priceText.setText(currentCategoryModel.getDishs().get(i)
						.getReferPrice()
						+ "");
				priceText.setGravity(Gravity.RIGHT);

				dishItemLayout.addView(nameText, 0);
				dishItemLayout.addView(priceText, 1);
				dishItemLayout.setClickable(true);

				dishItemLayout.setOnClickListener(onClickScr1ListDishItem);
				leftDishListView.add(dishItemLayout);
				leftListDishLayout.addView(dishItemLayout, i);
			}
		}
	}

	/***
	 * listening when user click on dish item when Scr1
	 */
	private OnClickListener onClickScr1ListDishItem = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			LinearLayout layout = (LinearLayout) v;
			int position = leftDishListView.indexOf(layout);
			updateSce1LeftDishSelected(position);

		}
	};

	/***
	 * update text color of dish item at position
	 * 
	 * @param position
	 */
	public void updateSce1LeftDishSelected(int position) {
		try {
			if (this.currentCategoryModel.getDishs().get(position) != null) {
				LinearLayout currentLayout = leftDishListView
						.get(currentDishIndex);
				setTextColorForLayout(currentLayout, Color.BLACK);
				currentLayout.setBackgroundColor(Color.TRANSPARENT);
				this.currentDishIndex = position;

				LinearLayout newLayout = leftDishListView.get(currentDishIndex);
				setTextColorForLayout(newLayout, Color.WHITE);
				newLayout.setBackgroundColor(Color.parseColor("#5b0000"));

				this.updateScr1RightDishSelected();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	public void updateScr1RightDishSelected() {

		this.currentDishModel = this.currentCategoryModel.getDishs().get(
				this.currentDishIndex);
		/*----Set Avatar for dish ---------------*/
		if(this.currentDishModel.getAvatarImg().length == 0){
			this.currentDishModel.setAvatarImg(getAvatarOfDish(currentDishModel.getDishID()));
		}

		TextView rightDishName = (TextView) findViewById(R.id.scr1_right_dish_name);
		rightDishName.setText(this.currentDishModel.getDishName());

		TextView rightDishPrice = (TextView) findViewById(R.id.scr1_right_price_value);
		rightDishPrice.setText(this.currentDishModel.getReferPrice() + "");

		TextView rightNumOfDiner = (TextView) findViewById(R.id.scr1_right_numofdiner_value);
		int numOfDiner = this.currentDishModel.getNumOfDiner();
		String numOfDinerText = (numOfDiner < 10) ? "0" + numOfDiner
				: numOfDiner + "";
		rightNumOfDiner.setText(numOfDinerText + " "
				+ getResources().getString(R.string.sc1_dinner_title));

		TextView rightDescription = (TextView) findViewById(R.id.scr1_right_dish_description_value);
		rightDescription.setText(currentDishModel.getDecription());

		ImageView img = (ImageView) findViewById(R.id.scr1_right_dish_img);
		Bitmap bm = ImageUtils.getImageByDishAvatar(
				currentDishModel.getAvatarImg(), this.getResources(),
				R.drawable.cantfoundish);

		img.setImageBitmap(bm);
	}

	/***
	 * change all text color of layout with color
	 * 
	 * @param layout
	 * @param color
	 */
	public static void setTextColorForLayout(LinearLayout layout, int color) {
		int count = layout.getChildCount();
		for (int i = 0; i < count; i++) {
			View view = layout.getChildAt(i);
			if (view instanceof TextView) {
				TextView textView = (TextView) view;
				textView.setTextColor(color);
			}
		}
	}

	public void menuOnClick(View view) {
		// TODO Auto-generated method stub
		MenuDialog menuDiaglog = MenuDialog.newInstance(getResources()
				.getString(R.string.menu_function_title),
				R.string.menu_dialog_type_list, R.array.menu_src1_item_title);
		List<String> activities = new ArrayList<String>();
		activities.add("android.intent.action.OrderDishActivity");

		menuDiaglog.setActivities(activities);
		menuDiaglog.show(getFragmentManager(), "dialog");
	};

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		SharedPreferences sharedPreferences = getSharedPreferences(
				MainActivity.PREFS_NAME, 0);
		SharedPreferences.Editor editor = sharedPreferences.edit();

		editor.putLong("scr1CurrentCategoryId",
				this.currentCategoryModel.getCategoryId());
		editor.putLong("scr1CurrentDishId", this.currentDishModel.getDishID());

		editor.commit();

		super.onPause();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
