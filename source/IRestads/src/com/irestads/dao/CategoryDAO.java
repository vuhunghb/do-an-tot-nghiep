package com.irestads.dao;

import java.util.ArrayList;
import java.util.List;

import com.irestads.model.CategoryModel;
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
public class CategoryDAO {
	static String CATEGORY_ID = "_categoryId";
	static String CATEGORY_NAME = "categoryName";

	static String DB_TABLE = "category";

	Context context;
	CategoryDAOHelper categoryDAOHelper;
	SQLiteDatabase db;

	public CategoryDAO(Context context) {
		super();
		this.context = context;
		categoryDAOHelper = new CategoryDAOHelper(context);
	}

	private static class CategoryDAOHelper extends SQLiteOpenHelper {

		public CategoryDAOHelper(Context context) {
			super(context, ConfigDAO.DB_NAME, null, ConfigDAO.DB_VERSION);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			String stringQuery = "CREATE TABLE " + DB_TABLE + " ("
					+ CATEGORY_ID + " INTEGER PRIMARY KEY, " + CATEGORY_NAME
					+ " TEXT);";
			db.execSQL(stringQuery);
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub
			Log.w("UPDATE " + DB_TABLE, "UPDATE " + DB_TABLE + " FROM "
					+ oldVersion + " TO " + newVersion);
			String stringQuery = "DROP TABLE IF EXISTS " + DB_TABLE;
			db.execSQL(stringQuery);
			onCreate(db);
		}
	}

	public CategoryDAO open() {
		db = categoryDAOHelper.getWritableDatabase();
		return this;
	}

	public void close() {
		categoryDAOHelper.close();
	}

	public long insertCategory(CategoryModel category) {
		ContentValues contentValues = new ContentValues();
		contentValues.put(CATEGORY_NAME, category.getCategoryName());
		contentValues.put(CATEGORY_ID, category.getCategoryId());
		long id = db.insert(DB_TABLE, null, contentValues);
		return id;
	}

	public boolean updateCategory(CategoryModel category) {
		ContentValues contentValues = new ContentValues();
		contentValues.put(CATEGORY_NAME, category.getCategoryName());

		long id = db.update(DB_TABLE, contentValues, CATEGORY_ID + "="
				+ category.getCategoryId(), null);
		return id > 0;
	}

	public long saveOrUpdateCategory(CategoryModel category) {
		ContentValues contentValues = new ContentValues();
		contentValues.put(CATEGORY_NAME, category.getCategoryName());
		boolean isExits = checkCategoryIsExist(category.getCategoryId());
		long id = -1;
		if (isExits == true) {
			id = db.update(DB_TABLE, contentValues, CATEGORY_ID + "="
					+ category.getCategoryId(), null);
		} else {
			contentValues.put(CATEGORY_ID, category.getCategoryId());
			id = db.insert(DB_TABLE, null, contentValues);
		}
		return id;
	}

	public boolean checkCategoryIsExist(long id) {
		long count = DatabaseUtils.queryNumEntries(db, DB_TABLE, CATEGORY_ID
				+ "=" + id);
		return count > 0;
	}
	
	public List<CategoryModel> getAllCategory(){
		List<CategoryModel> categories = new ArrayList<CategoryModel>();
		Cursor cursor = db.query(DB_TABLE, null, null, null, null, null, null);
		if(cursor.moveToFirst()){
			CategoryModel category;
			try {
				do {
					category = convertCategoryByCursor(cursor);
					categories.add(category);
				} while (cursor.moveToNext());
			}finally{
				cursor.close();
			}
		}
		return categories;
	}
	
	public CategoryModel convertCategoryByCursor(Cursor cursor){
		long categoryId = cursor.getLong(0);
		String categoryName = cursor.getString(1);
		CategoryModel categoryModel = new CategoryModel(categoryId, categoryName, new ArrayList<DishModel>());
		
		return categoryModel;
	}

}
