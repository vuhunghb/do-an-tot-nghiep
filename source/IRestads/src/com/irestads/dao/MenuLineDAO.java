package com.irestads.dao;

import com.irestads.model.MenuLineModel;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MenuLineDAO {
	static String MENULINE_ID = "menuLineId";
	static String NUM_OF_DISH = "numOfDish";
	static String STATUS = "status";
	static String DISH_ID = "dishId";

	Context context;
	SQLiteDatabase db;
	MenuLineDAOHelper menuLineDAOHelper;

	public MenuLineDAO(Context context) {
		super();
		this.context = context;
		menuLineDAOHelper = new MenuLineDAOHelper(context);
	}

	private class MenuLineDAOHelper extends SQLiteOpenHelper {

		public MenuLineDAOHelper(Context context) {
			super(context, ConfigDAO.DB_NAME, null, ConfigDAO.DB_VERSION);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			String createQuery = "CREATE TABLE " + ConfigDAO.DB_TABLE_MENULINE + " (" + MENULINE_ID + " INTEGER PRIMARY KEY, "
					+ NUM_OF_DISH + " NUMERIC, " + STATUS + " NUMERIC, " + DISH_ID + " NUMERIC);";
			try {
				db.execSQL(createQuery);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub
			Log.w("DBDishAdapt", "Update Dish to " + oldVersion + " from " + newVersion);
			String dropQuery = "DROP TABLE IF EXISTS " + ConfigDAO.DB_TABLE_MENULINE;
			db.execSQL(dropQuery);
			onCreate(db);
		}
	}

	public MenuLineDAO open() {
		db = menuLineDAOHelper.getWritableDatabase();
		return this;
	}

	public void close() {
		menuLineDAOHelper.close();
	}

	public long saveOrUpdate(MenuLineModel menuLineModel) {
		ContentValues contentValues = new ContentValues();
		contentValues.put(NUM_OF_DISH, menuLineModel.getNumOfDish());
		contentValues.put(STATUS, menuLineModel.isStatus());
		contentValues.put(DISH_ID, menuLineModel.getDishId());
		long id = menuLineModel.getMenuLineId();
		long result = -1;
		if (checkMenuLineIsExits(id) == true) {
			result = db.update(ConfigDAO.DB_TABLE_MENULINE, contentValues, MENULINE_ID + "=" + id, null);
		} else {
			contentValues.put(MENULINE_ID, id);
			result = db.insert(ConfigDAO.DB_TABLE_MENULINE, null, contentValues);
		}
		return result;
	}

	@SuppressLint("NewApi")
	public boolean checkMenuLineIsExits(long menuLineId) {
		long count = DatabaseUtils.queryNumEntries(db, ConfigDAO.DB_TABLE_MENULINE, MENULINE_ID + "=" + menuLineId);
		boolean result = (count > 0) ? true : false;
		return result;
	}

	public boolean deleteMenuLine(long id) {
		int rows = db.delete(ConfigDAO.DB_TABLE_MENULINE, MENULINE_ID + "=" + id, null);
		return (rows > 0) ? true : false;
	}
	
	public boolean deleteAllMenuLine() {
		int rows = db.delete(ConfigDAO.DB_TABLE_MENULINE, "1", null);
		return (rows > 0) ? true : false;
	}
}
