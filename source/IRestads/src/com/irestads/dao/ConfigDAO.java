package com.irestads.dao;

import java.util.List;

import com.irestads.model.CategoryAdsModel;
import com.irestads.model.CategoryModel;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class ConfigDAO {
	public static final String DB_NAME = "irestadsdb";
	public static final int DB_VERSION = 2;

	Context context;
	ConfigDAOHelper configDAOHelper;
	SQLiteDatabase db;

	public static String DB_TABLE_DISH = "dish";
	public static String DB_TABLE_CATEGORY = "category";
	public static String DB_TABLE_MENULINE = "menuline";
	public static String DB_TABLE_ORDER = "orders";
	public static String DB_TABLE_ORDERLINE = "orderline";
	public static String DB_TABLE_ADSITEM = "adsitem";
	public static String DB_TABLE_CATEGORY_ADS = "categoryads";

	public ConfigDAO(Context context) {
		super();
		this.context = context;
		configDAOHelper = new ConfigDAOHelper(context);
	}

	private static class ConfigDAOHelper extends SQLiteOpenHelper {

		public ConfigDAOHelper(Context context) {
			// TODO Auto-generated constructor stub
			super(context, ConfigDAO.DB_NAME, null, ConfigDAO.DB_VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			String createDishTableQuery = "CREATE TABLE dish (_dishID INTEGER PRIMARY KEY,dishname TEXT,description  TEXT," +
					"detail TEXT,avatarimg BLOB,detailimg TEXT,referPrice NUMERIC,numOfDiner NUMERIC,categoryId NUMERIC);";
			String createCategorQuery = "CREATE TABLE " + ConfigDAO.DB_TABLE_CATEGORY
					+ " (_categoryId INTEGER PRIMARY KEY, categoryName TEXT);";
			String createMenuLineQuery = "CREATE TABLE " + ConfigDAO.DB_TABLE_MENULINE
					+ " (menuLineId INTEGER PRIMARY KEY,numOfDish NUMERIC,status NUMERIC,dishId NUMERIC);";
			String createOrderQuery = "CREATE TABLE IF NOT EXISTS " + ConfigDAO.DB_TABLE_ORDER
					+ " (orderId INTEGER PRIMARY KEY,charge NUMERIC,isPayment NUMERIC,createDate TEXT);";
			String createOrderlineQuery = "CREATE TABLE "
					+ ConfigDAO.DB_TABLE_ORDERLINE
					+ " (orderLineId INTEGER PRIMARY KEY,numOfDish NUMERIC, numOfFinishDish NUMERIC,orderDate TEXT," +
					"status NUMERIC,dishId NUMERIC, orderId NUMERIC);";
			String createCategoryAdsQuery = "CREATE TABLE " + ConfigDAO.DB_TABLE_CATEGORY_ADS
					+ " (categoryAdsId INTEGER PRIMARY KEY,categoryAdsName TEXT);";

			String createAdsQuery = "CREATE TABLE "
					+ ConfigDAO.DB_TABLE_ADSITEM
					+ " ( adsItemId INTEGER PRIMARY KEY, companyName TEXT, productName TEXT, numberPhone TEXT, address TEXT," +
					" facebook TEXT,twitter TEXT, description TEXT,imageContent BLOB,itemType TEXT,tags TEXT,timeDuring NUMERIC," +
					"categoryAdsId NUMERIC,email TEXT);";
			try {
				db.execSQL(createCategorQuery);
				db.execSQL(createDishTableQuery);
				db.execSQL(createMenuLineQuery);
				db.execSQL(createOrderQuery);
				db.execSQL(createOrderlineQuery);
				db.execSQL(createCategoryAdsQuery);
				db.execSQL(createAdsQuery);

				List<CategoryAdsModel> categoryAdsModels = CategoryAdsModel.createTest();
				for (CategoryAdsModel categoryAdsModel : categoryAdsModels) {
					ContentValues contentValues = new ContentValues();
					contentValues.put("categoryAdsName", categoryAdsModel.getCategoryAdsName());
					contentValues.put("categoryAdsId", categoryAdsModel.getCategoryAdsId());
					db.insert(ConfigDAO.DB_TABLE_CATEGORY_ADS, null, contentValues);
				}
				
				List<CategoryModel> adsModels = CategoryModel.testData();
				for (CategoryModel categoryAdsModel : adsModels) {
					ContentValues contentValues = new ContentValues();
					contentValues.put("categoryName", categoryAdsModel.getCategoryName());
					contentValues.put("_categoryId", categoryAdsModel.getCategoryId());
					db.insert(ConfigDAO.DB_TABLE_CATEGORY, null, contentValues);
				}

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
			db.execSQL("DROP TABLE IF EXISTS " + ConfigDAO.DB_TABLE_CATEGORY);
			db.execSQL("DROP TABLE IF EXISTS " + ConfigDAO.DB_TABLE_ADSITEM);
			db.execSQL("DROP TABLE IF EXISTS " + ConfigDAO.DB_TABLE_CATEGORY_ADS);
			db.execSQL("DROP TABLE IF EXISTS " + ConfigDAO.DB_TABLE_MENULINE);
			db.execSQL("DROP TABLE IF EXISTS " + ConfigDAO.DB_TABLE_ORDER);
			db.execSQL("DROP TABLE IF EXISTS " + ConfigDAO.DB_TABLE_ORDERLINE);
			onCreate(db);
		}
	}

	public void open() {
		db = configDAOHelper.getWritableDatabase();
	}

	public void close() {
		db.close();
	}
}
