package com.irestads.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.irestads.model.DishModel;
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
public class OrderLineDAO {

	String NUM_OF_DISH = "numOfDish";
	String NUM_OF_FINISH_DISH = "numOfFinishDish";
	String ORDER_DATE = "orderDate";
	String STATUS = "status";
	String ORDER_LINE_ID = "orderLineId";
	String DISH_ID = "dishId";
	String ORDER_ID = "orderId";
	String[] queryColumns = { ORDER_LINE_ID, NUM_OF_DISH, NUM_OF_FINISH_DISH, ORDER_DATE, STATUS, DISH_ID, ORDER_ID };
	Context context;
	SQLiteDatabase db;
	OrderLineDAOHelper orderLineDAOHelper;
	DishDAO dishDAO;

	public OrderLineDAO(Context context) {
		super();
		this.context = context;
		orderLineDAOHelper = new OrderLineDAOHelper(context);
		dishDAO = new DishDAO(context);
	}

	private class OrderLineDAOHelper extends SQLiteOpenHelper {

		public OrderLineDAOHelper(Context context) {
			super(context, ConfigDAO.DB_NAME, null, ConfigDAO.DB_VERSION);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			Log.w("DBAdapt", "CREATE " + ConfigDAO.DB_TABLE_ORDERLINE);
			try {
				String query = "CREATE TABLE " + ConfigDAO.DB_TABLE_ORDERLINE + " (" + ORDER_LINE_ID
						+ " INTEGER PRIMARY KEY, " + NUM_OF_DISH + " NUMERIC, " + NUM_OF_FINISH_DISH + " NUMERIC, "
						+ ORDER_DATE + " TEXT, " + STATUS + " NUMERIC, " + DISH_ID + " NUMERIC, " + ORDER_ID
						+ " NUMERIC);";
				db.execSQL(query);
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub
			Log.w("DBDishAdapt", "Update Orderline to " + oldVersion + " from " + newVersion);
			db.execSQL("DROP TABLE IF EXISTS " + ConfigDAO.DB_TABLE_ORDERLINE);
			onCreate(db);
		}
	}

	public OrderLineDAO open() {
		db = orderLineDAOHelper.getWritableDatabase();
		return this;
	}

	public void close() {
		orderLineDAOHelper.close();
	}

	public boolean checkOrderLineExist(long id) {
		long count = DatabaseUtils.queryNumEntries(db, ConfigDAO.DB_TABLE_ORDERLINE, ORDER_LINE_ID + "=" + id);
		return (count > 0) ? true : false;
	}

	public boolean deleteOrderLine(long id) {
		int result = db.delete(ConfigDAO.DB_TABLE_ORDERLINE, ORDER_LINE_ID + "= ?", new String[] { id + "" });
		return (result > 0) ? true : false;
	}

	public boolean deleteAllOrderLine() {
		int result = db.delete(ConfigDAO.DB_TABLE_ORDERLINE, "1", null);
		return (result > 0) ? true : false;
	}

	public void saveOrUpdateOrder(OrderLineModel orderLineModel) {
		ContentValues contentValues = new ContentValues();

		contentValues.put(NUM_OF_DISH, orderLineModel.getNumOfDish());
		contentValues.put(NUM_OF_FINISH_DISH, orderLineModel.getNumOfFinishDish());
		contentValues.put(ORDER_DATE, GenericUtil.convertDateToStringSQL(orderLineModel.getOrderDate()));
		contentValues.put(STATUS, orderLineModel.getStatus());
		contentValues.put(DISH_ID, orderLineModel.getDishId());
		contentValues.put(ORDER_ID, orderLineModel.getOrderId());

		long id = orderLineModel.getOrderLineId();
		if (checkOrderLineExist(id) == true) {
			db.update(ConfigDAO.DB_TABLE_ORDERLINE, contentValues, ORDER_LINE_ID + "=" + id, null);
		} else {
			contentValues.put(ORDER_LINE_ID, orderLineModel.getOrderLineId());
			db.insert(ConfigDAO.DB_TABLE_ORDERLINE, null, contentValues);
		}
	}

	public OrderLineModel getOrderLineByIdNotDish(long orderLineId) {
		Cursor cursor = db.query(ConfigDAO.DB_TABLE_ORDERLINE, queryColumns, ORDER_LINE_ID + "= ?",
				new String[] { orderLineId + "" }, null, null, null);
		OrderLineModel model = new OrderLineModel();
		if (cursor.moveToFirst()) {
			try {
				model = convertOrderLineNotDish(cursor);
			} finally {
				// TODO: handle exception
				cursor.close();
			}
		}
		return model;
	}

	public List<OrderLineModel> getOrderLineByOrder(long orderId) {
		List<OrderLineModel> orderLineModels = new ArrayList<OrderLineModel>();
		Cursor cursor = db.query(ConfigDAO.DB_TABLE_ORDERLINE, queryColumns, ORDER_ID + "= ?", new String[] { orderId
				+ "" }, null, null, null);
		OrderLineModel model;
		if (cursor.moveToFirst()) {
			try {
				do {
					model = convertOrderLineFromCusor(cursor);
					orderLineModels.add(model);
				} while (cursor.moveToNext());
			} finally {
				// TODO: handle exception
				cursor.close();
			}
		}
		return orderLineModels;
	}

	private OrderLineModel convertOrderLineFromCusor(Cursor cursor) {
		// TODO Auto-generated method stub
		long orderLineId = cursor.getLong(cursor.getColumnIndex(ORDER_LINE_ID));
		int numOfDish = cursor.getInt(cursor.getColumnIndex(NUM_OF_DISH));
		int numOfFinishDish = cursor.getInt(cursor.getColumnIndex(NUM_OF_FINISH_DISH));
		String orderDateString = cursor.getString(cursor.getColumnIndex(ORDER_DATE));
		Date orderDate = GenericUtil.convertDateFromStringSQL(orderDateString);
		int status = cursor.getInt(cursor.getColumnIndex(STATUS));
		long dishId = cursor.getLong(cursor.getColumnIndex(DISH_ID));
		long orderId = cursor.getLong(cursor.getColumnIndex(ORDER_ID));
		OrderLineModel orderLineModel = new OrderLineModel(orderLineId, numOfDish, numOfFinishDish, orderDate, status,
				dishId, orderId);
		dishDAO.open();
		DishModel dishModel = dishDAO.getDishById(dishId);
		dishDAO.close();
		orderLineModel.setDish(dishModel);
		return orderLineModel;
	}

	private OrderLineModel convertOrderLineNotDish(Cursor cursor) {
		// TODO Auto-generated method stub
		long orderLineId = cursor.getLong(cursor.getColumnIndex(ORDER_LINE_ID));
		int numOfDish = cursor.getInt(cursor.getColumnIndex(NUM_OF_DISH));
		int numOfFinishDish = cursor.getInt(cursor.getColumnIndex(NUM_OF_FINISH_DISH));
		String orderDateString = cursor.getString(cursor.getColumnIndex(ORDER_DATE));
		Date orderDate = GenericUtil.convertDateFromStringSQL(orderDateString);
		int status = cursor.getInt(cursor.getColumnIndex(STATUS));
		long dishId = cursor.getLong(cursor.getColumnIndex(DISH_ID));
		long orderId = cursor.getLong(cursor.getColumnIndex(ORDER_ID));
		OrderLineModel orderLineModel = new OrderLineModel(orderLineId, numOfDish, numOfFinishDish, orderDate, status,
				dishId, orderId);
		return orderLineModel;
	}

	public long countOrderline() {
		long count = DatabaseUtils.queryNumEntries(db, ConfigDAO.DB_TABLE_ORDERLINE);
		return count;
	}
}
