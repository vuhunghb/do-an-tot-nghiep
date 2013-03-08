package com.irestads.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

import com.irestads.model.AdsItemContextModel;
import com.irestads.model.AdsItemModel;
import com.irestads.model.AdsItemNormalModel;
import com.irestads.model.OrderLineModel;
import com.irestads.model.OrderModel;
import com.irestads.util.GenericUtil;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

@SuppressLint("NewApi")
public class AdsItemDAO {

	String ADSITEM_ID = "adsItemId";
	String ADSITEM_COMPANY = "companyName";
	String ADSITEM_PRODUCT = "productName";
	String ADSITEM_NUMBERPHONE = "numberPhone";
	String ADSITEM_EMAIL = "email";
	String ADSITEM_ADDRESS = "address";
	String ADSITEM_FACEBOOK = "facebook";
	String ADSITEM_TWITTER = "twitter";
	String ADSITEM_DESCRIPTION = "description";
	String ADSITEM_IMAGE = "imageContent";
	String ADSITEM_TIMEDURING = "timeDuring";
	String ADSITEM_TAGS = "tags";
	String ADSITEM_ITEMTYPE = "itemType";
	String ADSITEM_CATEGORY = "categoryAdsId";

	String[] ADSITEM_GETCOLUMNS = { ADSITEM_ID, ADSITEM_COMPANY, ADSITEM_PRODUCT, ADSITEM_NUMBERPHONE, ADSITEM_EMAIL,
			ADSITEM_ADDRESS, ADSITEM_FACEBOOK, ADSITEM_TWITTER, ADSITEM_DESCRIPTION, ADSITEM_TIMEDURING, ADSITEM_TAGS,
			ADSITEM_ITEMTYPE, ADSITEM_CATEGORY };
	Context context;
	SQLiteDatabase db;
	AdsItemDAOHelper adsItemDAOHelper;

	public AdsItemDAO(Context context) {
		super();
		this.context = context;
		adsItemDAOHelper = new AdsItemDAOHelper(context);
	}

	private class AdsItemDAOHelper extends SQLiteOpenHelper {

		public AdsItemDAOHelper(Context context) {
			super(context, ConfigDAO.DB_NAME, null, ConfigDAO.DB_VERSION);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			Log.w("DBAdapt", "CREATE " + ConfigDAO.DB_TABLE_ADSITEM);
			try {
				String query = "CREATE TABLE " + ConfigDAO.DB_TABLE_ADSITEM + " ( " + ADSITEM_ID
						+ " INTEGER PRIMARY KEY, " + ADSITEM_COMPANY + " TEXT, " + ADSITEM_PRODUCT + " TEXT, "
						+ ADSITEM_NUMBERPHONE + " TEXT, " + ADSITEM_ADDRESS + " TEXT, " + ADSITEM_FACEBOOK + " TEXT, "
						+ ADSITEM_TWITTER + " TEXT, " + ADSITEM_DESCRIPTION + " TEXT, " + ADSITEM_IMAGE + " BLOB,"
						+ ADSITEM_ITEMTYPE + " TEXT, " + ADSITEM_TAGS + " TEXT, " + ADSITEM_TIMEDURING + " NUMERIC,"
						+ ADSITEM_CATEGORY + " NUMERIC, " + ADSITEM_EMAIL + " TEXT);";
				db.execSQL(query);
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub
			Log.w("DBDishAdapt", "Update Order to " + oldVersion + " from " + newVersion);
			db.execSQL("DROP TABLE IF EXISTS " + ConfigDAO.DB_TABLE_ADSITEM);
			onCreate(db);
		}
	}

	public AdsItemDAO open() {
		db = adsItemDAOHelper.getWritableDatabase();
		return this;
	}

	public void close() {
		adsItemDAOHelper.close();
	}

	public long saveOrUpdateAds(AdsItemModel adsItemModel) {
		ContentValues contentValues = new ContentValues();
		contentValues.put(ADSITEM_COMPANY, adsItemModel.getCompanyName());
		contentValues.put(ADSITEM_PRODUCT, adsItemModel.getProductName());
		contentValues.put(ADSITEM_NUMBERPHONE, adsItemModel.getNumberPhone());
		contentValues.put(ADSITEM_EMAIL, adsItemModel.getEmail());
		contentValues.put(ADSITEM_ADDRESS, adsItemModel.getAddress());
		contentValues.put(ADSITEM_FACEBOOK, adsItemModel.getFacebook());
		contentValues.put(ADSITEM_TWITTER, adsItemModel.getTwitter());
		contentValues.put(ADSITEM_DESCRIPTION, adsItemModel.getDescription());
		contentValues.put(ADSITEM_IMAGE, adsItemModel.getImageContent());
		contentValues.put(ADSITEM_TIMEDURING, adsItemModel.getTimeDuring());
		contentValues.put(ADSITEM_TAGS, adsItemModel.getTags());
		contentValues.put(ADSITEM_ITEMTYPE, adsItemModel.getItemType());
		contentValues.put(ADSITEM_CATEGORY, adsItemModel.getCategoryAdsId());

		long id = adsItemModel.getAdsItemId();
		boolean isExit = checkAdsItemIsExist(id);
		long result = -1;
		if (isExit == true) {
			result = db.update(ConfigDAO.DB_TABLE_ADSITEM, contentValues, ADSITEM_ID + "=" + id, null);
		} else {
			contentValues.put(ADSITEM_ID, id);
			result = db.insert(ConfigDAO.DB_TABLE_ADSITEM, null, contentValues);
		}
		return result;
	}

	public List<AdsItemModel> getAllAdsItem(int type) {
		List<AdsItemModel> adsItemModels = new ArrayList<AdsItemModel>();

		Cursor cursor;
		switch (type) {
		case 0:
			cursor = db.query(ConfigDAO.DB_TABLE_ADSITEM, ADSITEM_GETCOLUMNS, ADSITEM_ITEMTYPE + "=?",
					new String[] { AdsItemNormalModel.class.toString() }, null, null, null);
			break;
		case 1:
			cursor = db.query(ConfigDAO.DB_TABLE_ADSITEM, ADSITEM_GETCOLUMNS, ADSITEM_ITEMTYPE + "=?",
					new String[] { AdsItemContextModel.class.toString() }, null, null, null);
			break;
		default:
			cursor = db.query(ConfigDAO.DB_TABLE_ADSITEM, ADSITEM_GETCOLUMNS, null, null, null, null, null);
			break;
		}
		AdsItemModel model;
		if (cursor.moveToFirst()) {
			try {
				do {
					model = convertAdsItemFromCusorNoAvatar(cursor);
					model.setImageContent(getAvatarOfAdsItem(model.getAdsItemId()));
					adsItemModels.add(model);
				} while (cursor.moveToNext());
			} finally {
				// TODO: handle exception
				cursor.close();
			}
		}
		return adsItemModels;
	}

	public List<AdsItemModel> getAdsItemByCategory(long id) {
		List<AdsItemModel> adsItemModels = new ArrayList<AdsItemModel>();

		Cursor cursor = db.query(ConfigDAO.DB_TABLE_ADSITEM, ADSITEM_GETCOLUMNS, ADSITEM_CATEGORY + "=" + id, null,
				null, null, null);
		AdsItemModel model;
		if (cursor.moveToFirst()) {
			try {
				do {
					model = convertAdsItemFromCusorNoAvatar(cursor);
					model.setImageContent(getAvatarOfAdsItem(model.getAdsItemId()));
					adsItemModels.add(model);
				} while (cursor.moveToNext());
			} finally {
				// TODO: handle exception
				cursor.close();
			}
		}
		return adsItemModels;
	}

	public List<AdsItemModel> getAdsItemContextByCategory(long id, boolean isHasAvatar) {
		List<AdsItemModel> adsItemModels = new ArrayList<AdsItemModel>();

		Cursor cursor = db.query(ConfigDAO.DB_TABLE_ADSITEM, ADSITEM_GETCOLUMNS, ADSITEM_CATEGORY + "= ? AND "
				+ ADSITEM_ITEMTYPE + "= ?", new String[] { id + "", AdsItemContextModel.class.toString() }, null, null,
				null);
		AdsItemModel model;
		if (cursor.moveToFirst()) {
			try {
				do {
					model = convertAdsItemFromCusorNoAvatar(cursor);
					if (isHasAvatar) {
						model.setImageContent(getAvatarOfAdsItem(model.getAdsItemId()));
					}
					adsItemModels.add(model);
				} while (cursor.moveToNext());
			} finally {
				// TODO: handle exception
				cursor.close();
			}
		}
		return adsItemModels;
	}

	public List<AdsItemModel> getAdsItemByTags(long id, String tags) {
		List<AdsItemModel> adsItemModels = new ArrayList<AdsItemModel>();
		String tagsQuery = convertTagsToSQLQuery(tags);
		Cursor cursor = db.query(ConfigDAO.DB_TABLE_ADSITEM, ADSITEM_GETCOLUMNS, ADSITEM_ID + "!=? AND "+ADSITEM_ITEMTYPE+"!=? AND" + tagsQuery,
				new String[] { id + "",AdsItemContextModel.class.toString() }, null, null, null);
		AdsItemModel model;
		if (cursor.moveToFirst()) {
			try {
				do {
					model = convertAdsItemFromCusorNoAvatar(cursor);
					model.setImageContent(getAvatarOfAdsItem(model.getAdsItemId()));
					adsItemModels.add(model);
				} while (cursor.moveToNext());
			} finally {
				// TODO: handle exception
				cursor.close();
			}
		}
		return adsItemModels;
	}

	public String convertTagsToSQLQuery(String tags) {
		String result = "";
		StringTokenizer stringTokenizer = new StringTokenizer(tags, ",");
		while (stringTokenizer.hasMoreElements()) {
			String tag = (String) stringTokenizer.nextElement();
			if (result.equals("")) {
				result = result + ADSITEM_TAGS + " LIKE " + "'%" + tag + "%'";
			} else {
				result = result + " OR " + ADSITEM_TAGS + " LIKE " + "'%" + tag + "%'";
			}
		}

		return "(" + result + ")";
	}

	private AdsItemModel convertAdsItemFromCusorNoAvatar(Cursor cursor) {
		long adsItemId = cursor.getLong(cursor.getColumnIndex(ADSITEM_ID));
		String companyName = cursor.getString(cursor.getColumnIndex(ADSITEM_COMPANY));
		String productName = cursor.getString(cursor.getColumnIndex(ADSITEM_PRODUCT));
		String numberPhone = cursor.getString(cursor.getColumnIndex(ADSITEM_NUMBERPHONE));
		String email = cursor.getString(cursor.getColumnIndex(ADSITEM_EMAIL));
		String address = cursor.getString(cursor.getColumnIndex(ADSITEM_ADDRESS));
		String facebook = cursor.getString(cursor.getColumnIndex(ADSITEM_FACEBOOK));
		String twitter = cursor.getString(cursor.getColumnIndex(ADSITEM_TWITTER));
		String description = cursor.getString(cursor.getColumnIndex(ADSITEM_DESCRIPTION));
		byte[] imageContent = new byte[] {};
		int timeDuring = cursor.getInt(cursor.getColumnIndex(ADSITEM_TIMEDURING));
		String tags = cursor.getString(cursor.getColumnIndex(ADSITEM_TAGS));
		String itemType = cursor.getString(cursor.getColumnIndex(ADSITEM_ITEMTYPE));
		long categoryAdsId = cursor.getLong(cursor.getColumnIndex(ADSITEM_CATEGORY));
		if (itemType.equals(AdsItemNormalModel.class.toString())) {
			AdsItemNormalModel adsItemNormalModel = new AdsItemNormalModel(adsItemId, companyName, numberPhone, email,
					address, facebook, twitter, description, imageContent, timeDuring, productName, tags, categoryAdsId);
			return adsItemNormalModel;
		} else {
			AdsItemContextModel adsItemContextModel = new AdsItemContextModel(adsItemId, companyName, numberPhone,
					email, address, facebook, twitter, description, imageContent, timeDuring, productName, tags,
					categoryAdsId);
			return adsItemContextModel;
		}
	}

	public byte[] getAvatarOfAdsItem(long id) {

		Cursor mcursor = db.query(ConfigDAO.DB_TABLE_ADSITEM, new String[] { ADSITEM_IMAGE }, ADSITEM_ID + "=" + id,
				null, null, null, null);
		// int count = cursor.getColumnCount();
		byte[] result = new byte[] {};
		if (mcursor.moveToFirst()) {
			try {
				result = mcursor.getBlob(mcursor.getColumnIndex(ADSITEM_IMAGE));
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				// TODO: handle exception
				mcursor.close();
			}
		}
		return result;
	}

	private boolean checkAdsItemIsExist(long id) {
		// TODO Auto-generated method stub
		Long count = DatabaseUtils.queryNumEntries(db, ConfigDAO.DB_TABLE_ADSITEM, ADSITEM_ID + "=" + id);
		boolean result = (count != null && count != 0) ? true : false;
		return result;
	}

	public long countAdsItem() {
		// TODO Auto-generated method stub
		Long count = DatabaseUtils.queryNumEntries(db, ConfigDAO.DB_TABLE_ADSITEM, null);
		return count;
	}

	public void deleteAllAdsItem() {
		db.delete(ConfigDAO.DB_TABLE_ADSITEM, "1", null);
	}

	public int deleteAdsItem(long adsId) {
		return db.delete(ConfigDAO.DB_TABLE_ADSITEM, ADSITEM_ID + "?", new String[] { adsId + "" });
	}
}
