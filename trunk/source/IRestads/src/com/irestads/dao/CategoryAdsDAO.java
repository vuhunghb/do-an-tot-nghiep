package com.irestads.dao;

import java.util.ArrayList;
import java.util.List;

import com.irestads.model.AdsItemContextModel;
import com.irestads.model.AdsItemModel;
import com.irestads.model.AdsItemNormalModel;
import com.irestads.model.CategoryAdsModel;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

@SuppressLint("NewApi")
public class CategoryAdsDAO {
	static String CATEGORY_ADS_ID = "categoryAdsId";
	static String CATEGORY_ADS_NAME = "categoryAdsName";

	Context context;
	CategoryAdsDAOHelper categoryAdsDAOHelper;
	SQLiteDatabase db;

	public CategoryAdsDAO(Context context) {
		super();
		this.context = context;
		categoryAdsDAOHelper = new CategoryAdsDAOHelper(context);
	}

	private static class CategoryAdsDAOHelper extends SQLiteOpenHelper {

		public CategoryAdsDAOHelper(Context context) {
			super(context, ConfigDAO.DB_NAME, null, ConfigDAO.DB_VERSION);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			String stringQuery = "CREATE TABLE " + ConfigDAO.DB_TABLE_CATEGORY_ADS + " (" + CATEGORY_ADS_ID
					+ " INTEGER PRIMARY KEY, " + CATEGORY_ADS_NAME + " TEXT);";
			db.execSQL(stringQuery);
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub
			Log.w("UPDATE " + ConfigDAO.DB_TABLE_CATEGORY_ADS, "UPDATE " + ConfigDAO.DB_TABLE_CATEGORY_ADS + " FROM "
					+ oldVersion + " TO " + newVersion);
			String stringQuery = "DROP TABLE IF EXISTS " + ConfigDAO.DB_TABLE_CATEGORY_ADS;
			db.execSQL(stringQuery);
			onCreate(db);
		}
	}

	public CategoryAdsDAO open() {
		db = categoryAdsDAOHelper.getWritableDatabase();
		return this;
	}

	public void close() {
		categoryAdsDAOHelper.close();
	}

	public long insertCategory(CategoryAdsModel category) {
		ContentValues contentValues = new ContentValues();
		contentValues.put(CATEGORY_ADS_NAME, category.getCategoryAdsName());
		contentValues.put(CATEGORY_ADS_ID, category.getCategoryAdsId());
		long id = db.insert(ConfigDAO.DB_TABLE_CATEGORY_ADS, null, contentValues);
		return id;
	}

	public boolean updateCategory(CategoryAdsModel category) {
		ContentValues contentValues = new ContentValues();
		contentValues.put(CATEGORY_ADS_NAME, category.getCategoryAdsName());

		long id = db.update(ConfigDAO.DB_TABLE_CATEGORY_ADS, contentValues,
				CATEGORY_ADS_ID + "=" + category.getCategoryAdsId(), null);
		return id > 0;
	}

	public long saveOrUpdateCategory(CategoryAdsModel category) {
		ContentValues contentValues = new ContentValues();
		contentValues.put(CATEGORY_ADS_NAME, category.getCategoryAdsName());
		boolean isExits = checkCategoryIsExist(category.getCategoryAdsId());
		long id = -1;
		if (isExits == true) {
			id = db.update(ConfigDAO.DB_TABLE_CATEGORY_ADS, contentValues,
					CATEGORY_ADS_ID + "=" + category.getCategoryAdsId(), null);
		} else {
			contentValues.put(CATEGORY_ADS_ID, category.getCategoryAdsId());
			id = db.insert(ConfigDAO.DB_TABLE_CATEGORY_ADS, null, contentValues);
		}
		return id;
	}

	public boolean checkCategoryIsExist(long id) {
		long count = DatabaseUtils.queryNumEntries(db, ConfigDAO.DB_TABLE_CATEGORY_ADS, CATEGORY_ADS_ID + "=" + id);
		return count > 0;
	}

	public List<CategoryAdsModel> getAllCategory(int type) {
		List<CategoryAdsModel> categories = new ArrayList<CategoryAdsModel>();
		Cursor cursor;
		String subQuery = "";
		switch (type) {
		case 0:
			subQuery = "SELECT " + CATEGORY_ADS_ID + " FROM " + ConfigDAO.DB_TABLE_ADSITEM + " WHERE itemType = '"
					+ AdsItemNormalModel.class.toString() + "'";
			break;
		case 1:
			subQuery = "SELECT " + CATEGORY_ADS_ID + " FROM " + ConfigDAO.DB_TABLE_ADSITEM + " WHERE itemType = '"
					+ AdsItemContextModel.class.toString() + "'";
			break;
		default:
			subQuery = "SELECT " + CATEGORY_ADS_ID + " FROM " + ConfigDAO.DB_TABLE_ADSITEM;
			break;
		}
		cursor = db.query(ConfigDAO.DB_TABLE_CATEGORY_ADS, new String[] { CATEGORY_ADS_ID, CATEGORY_ADS_NAME },
				CATEGORY_ADS_ID + " IN ( " + subQuery + " )", null, null, null, null);

		if (cursor.moveToFirst()) {
			CategoryAdsModel category;
			try {
				do {
					category = convertCategoryByCursor(cursor);
					categories.add(category);
				} while (cursor.moveToNext());
			} finally {
				cursor.close();
			}
		}
		return categories;
	}

	public CategoryAdsModel convertCategoryByCursor(Cursor cursor) {
		long categoryId = cursor.getLong(0);
		String categoryName = cursor.getString(1);
		CategoryAdsModel CategoryAdsModel = new CategoryAdsModel(categoryId, categoryName,
				new ArrayList<AdsItemModel>());
		return CategoryAdsModel;
	}

	public boolean deleteAllCategory() {
		db.delete(ConfigDAO.DB_TABLE_CATEGORY_ADS, "1", null);
		return false;
	}

}
