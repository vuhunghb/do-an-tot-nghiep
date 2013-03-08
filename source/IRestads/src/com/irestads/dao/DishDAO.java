package com.irestads.dao;

import java.util.ArrayList;
import java.util.List;

import com.irestads.MainActivity;
import com.irestads.model.DishModel;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

@SuppressLint("NewApi")
public class DishDAO {

	Context context;
	DishDAOHelper dishDAOHelper;
	SQLiteDatabase db;

	static String DISH_NAME = "dishname";
	static String DESCRIPTION = "description";
	static String DETAIL = "detail";
	static String AVATAR_IMG = "avatarimg";
	static String DETAIL_IMG = "detailimg";
	static String REFER_PRICE = "referPrice";
	static String NUM_OF_DINER = "numOfDiner";
	static String DISH_ID = "_dishID";
	static String CATEGORY_ID = "categoryId";

	public DishDAO(Context context) {
		super();
		this.context = context;
		dishDAOHelper = new DishDAOHelper(context);
	}

	private static class DishDAOHelper extends SQLiteOpenHelper {

		public DishDAOHelper(Context context) {
			// TODO Auto-generated constructor stub
			super(context, ConfigDAO.DB_NAME, null, ConfigDAO.DB_VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			String createDishTableQuery = "CREATE TABLE dish (" + DISH_ID + " INTEGER PRIMARY KEY," + DISH_NAME
					+ " TEXT, " + DESCRIPTION + " TEXT," + DETAIL + " TEXT," + AVATAR_IMG + " BLOB," + DETAIL_IMG
					+ " TEXT," + REFER_PRICE + " NUMERIC," + NUM_OF_DINER + " NUMERIC," + CATEGORY_ID + " NUMERIC);";

			try {
				db.execSQL(createDishTableQuery);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub
			Log.w("DBDishAdapt", "Update Dish to " + oldVersion + " from " + newVersion);
			db.execSQL("DROP TABLE IF EXISTS " + ConfigDAO.DB_TABLE_DISH);
			onCreate(db);
		}
	}

	public DishDAO open() {
		db = dishDAOHelper.getWritableDatabase();
		return this;
	}

	public void close() {
		dishDAOHelper.close();
	}

	public long insertDish(DishModel dish) {
		ContentValues contentValues = new ContentValues();
		contentValues.put(DISH_ID, dish.getDishID());
		contentValues.put(DISH_NAME, dish.getDishName());
		contentValues.put(DESCRIPTION, dish.getDecription());
		contentValues.put(DETAIL, dish.getDetail());
		contentValues.put(REFER_PRICE, dish.getReferPrice());
		contentValues.put(NUM_OF_DINER, dish.getNumOfDiner());
		contentValues.put(AVATAR_IMG, dish.getAvatarImg());
		contentValues.put(DETAIL_IMG, dish.getDetailImg());
		contentValues.put(CATEGORY_ID, dish.getCategoryId());
		return db.insert(ConfigDAO.DB_TABLE_DISH, null, contentValues);
	}

	public boolean updateDish(DishModel dish) {
		ContentValues contentValues = new ContentValues();
		contentValues.put(DISH_NAME, dish.getDishName());
		contentValues.put(DESCRIPTION, dish.getDecription());
		contentValues.put(DETAIL, dish.getDetail());
		contentValues.put(REFER_PRICE, dish.getReferPrice());
		contentValues.put(NUM_OF_DINER, dish.getNumOfDiner());
		contentValues.put(AVATAR_IMG, dish.getAvatarImg());
		contentValues.put(DETAIL_IMG, dish.getDetailImg());
		contentValues.put(CATEGORY_ID, dish.getCategoryId());
		return db.update(ConfigDAO.DB_TABLE_DISH, contentValues, DISH_ID + "=" + dish.getDishID(), null) > 0;
	}

	public long saveOrUpdateDish(DishModel dish) {
		ContentValues contentValues = new ContentValues();
		contentValues.put(DISH_NAME, dish.getDishName());
		contentValues.put(DESCRIPTION, dish.getDecription());
		contentValues.put(DETAIL, dish.getDetail());
		contentValues.put(REFER_PRICE, dish.getReferPrice());
		contentValues.put(NUM_OF_DINER, dish.getNumOfDiner());
		contentValues.put(AVATAR_IMG, dish.getAvatarImg());
		contentValues.put(DETAIL_IMG, dish.getDetailImg());
		contentValues.put(CATEGORY_ID, dish.getCategoryId());
		long id = dish.getDishID();
		boolean isExit = checkDishIsExist(id);
		long result = -1;
		if (isExit == true) {
			result = db.update(ConfigDAO.DB_TABLE_DISH, contentValues, DISH_ID + "=" + id, null);
		} else {
			contentValues.put(DISH_ID, id);
			result = db.insert(ConfigDAO.DB_TABLE_DISH, null, contentValues);
		}
		return result;
	}

	@SuppressLint("NewApi")
	public boolean checkDishIsExist(long _id) {
		Long count = DatabaseUtils.queryNumEntries(db, ConfigDAO.DB_TABLE_DISH, DISH_ID + "=" + _id);
		boolean result = (count != null && count != 0) ? true : false;
		return result;
	}

	public List<DishModel> getDishsByCategoryId(long categoryId) {
		List<DishModel> dishModels = new ArrayList<DishModel>();
		DishModel model;
		Cursor mcursor = db.rawQuery("select " + DISH_ID + "," + DISH_NAME + "," + DESCRIPTION + ", " + DETAIL + ","
				+ REFER_PRICE + "," + NUM_OF_DINER + "," + CATEGORY_ID + " from " + ConfigDAO.DB_TABLE_DISH
				+ ",menuline where " + CATEGORY_ID + " = ? and menuline.dishid = " + DISH_ID + " ORDER BY " + DISH_ID
				+ " DESC", new String[] { categoryId + "" });
		if (mcursor.moveToFirst()) {
			try {
				do {
					model = convertDishFromCusorNoAvatar(mcursor);
					dishModels.add(model);
				} while (mcursor.moveToNext());
			} finally {
				// TODO: handle exception
				mcursor.close();
			}
		}
		return dishModels;
	}

	public DishModel getDishById(long id) {
		DishModel model = null;
		Cursor mcursor = db.query(ConfigDAO.DB_TABLE_DISH, new String[] { DISH_ID, DISH_NAME, DESCRIPTION, DETAIL,
				AVATAR_IMG, REFER_PRICE, NUM_OF_DINER, CATEGORY_ID }, DISH_ID + "=" + id, null, null, null, null);
		// int count = cursor.getColumnCount();
		if (mcursor.moveToFirst()) {
			try {
				model = convertDishFromCusorHaveAvatar(mcursor);
			} finally {
				// TODO: handle exception
				mcursor.close();
			}
		}
		return model;
	}

	public DishModel getDishByIdNoImage(long id) {
		DishModel model = null;
		Cursor mcursor = db.query(ConfigDAO.DB_TABLE_DISH, new String[] { DISH_ID, DISH_NAME, DESCRIPTION, DETAIL,
				REFER_PRICE, NUM_OF_DINER, CATEGORY_ID }, DISH_ID + "=" + id, null, null, null, null);
		// int count = cursor.getColumnCount();
		if (mcursor.moveToFirst()) {
			try {
				model = convertDishFromCusorNoAvatar(mcursor);
			} finally {
				// TODO: handle exception
				mcursor.close();
			}
		}
		return model;
	}

	public byte[] getAvatarOfDish(long id) {
		Cursor mcursor = db.query(ConfigDAO.DB_TABLE_DISH, new String[] { AVATAR_IMG }, DISH_ID + "=" + id, null, null,
				null, null);
		// int count = cursor.getColumnCount();
		byte[] result = new byte[] {};
		if (mcursor.moveToFirst()) {
			try {
				result = mcursor.getBlob(mcursor.getColumnIndex(AVATAR_IMG));
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				// TODO: handle exception
				mcursor.close();
			}
		}
		return result;
	}

	private DishModel convertDishFromCusorNoAvatar(Cursor cursor) {
		long dishId = cursor.getLong(0);
		String dishName = cursor.getString(1);
		String decription = cursor.getString(2);
		String detail = cursor.getString(3);
		int referPrice = cursor.getInt(4);
		int numOfDiners = cursor.getInt(5);
		long categoryId = cursor.getLong(6);

		byte[] avatarImg = new byte[] {};
		String detailImg = "";
		DishModel dish = new DishModel(dishId, dishName, decription, detail, avatarImg, detailImg, referPrice,
				numOfDiners, categoryId);
		return dish;
	}

	private DishModel convertDishFromCusorHaveAvatar(Cursor cursor) {
		long dishId = cursor.getLong(0);
		String dishName = cursor.getString(1);
		String decription = cursor.getString(2);
		String detail = cursor.getString(3);
		byte[] avatarImg = cursor.getBlob(4);
		int referPrice = cursor.getInt(5);
		int numOfDiners = cursor.getInt(6);
		long categoryId = cursor.getLong(7);

		String detailImg = "";
		DishModel dish = new DishModel(dishId, dishName, decription, detail, avatarImg, detailImg, referPrice,
				numOfDiners, categoryId);
		return dish;
	}

	public void deleteAllDish() {
		db.delete(ConfigDAO.DB_TABLE_DISH, "1", null);
	}

	public long countDish() {
		Long count = DatabaseUtils.queryNumEntries(db, ConfigDAO.DB_TABLE_DISH, null);
		return count;
	}
}
