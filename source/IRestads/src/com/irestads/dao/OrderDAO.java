package com.irestads.dao;

import java.util.ArrayList;
import java.util.Date;

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
public class OrderDAO {

	String ORDER_ID = "orderId";
	String ORDER_CHARGE = "charge";
	String IS_PAYMENT = "isPayment";
	String CREATE_DATE = "createDate";

	Context context;
	SQLiteDatabase db;
	OrderDAOHelper orderDAOHelper;
	OrderLineDAO orderLineDAO;

	public OrderDAO(Context context) {
		super();
		this.context = context;
		orderDAOHelper = new OrderDAOHelper(context);
		orderLineDAO = new OrderLineDAO(context);
	}

	private class OrderDAOHelper extends SQLiteOpenHelper {

		public OrderDAOHelper(Context context) {
			super(context, ConfigDAO.DB_NAME, null, ConfigDAO.DB_VERSION);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			Log.w("DBAdapt", "CREATE " + ConfigDAO.DB_TABLE_ORDER);
			try {
				String query = "CREATE TABLE IF NOT EXISTS " + ConfigDAO.DB_TABLE_ORDER + " (" + ORDER_ID
						+ " INTEGER PRIMARY KEY, " + ORDER_CHARGE + " NUMERIC, " + IS_PAYMENT + " NUMERIC, "
						+ CREATE_DATE + " TEXT);";
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
			db.execSQL("DROP TABLE IF EXISTS " + ConfigDAO.DB_TABLE_ORDER);
			onCreate(db);
		}
	}

	public OrderDAO open() {
		db = orderDAOHelper.getWritableDatabase();
		return this;
	}

	public void close() {
		orderDAOHelper.close();
	}

	public boolean deleteOrder(long id) {
		int result = db.delete(ConfigDAO.DB_TABLE_ORDER, ORDER_ID + "=" + id, null);
		return (result > 0) ? true : false;
	}

	public boolean deleteAllOrder() {
		int result = db.delete(ConfigDAO.DB_TABLE_ORDER, "1", null);
		return (result > 0) ? true : false;
	}

	public boolean checkOrderExist(long id) {
		long count = DatabaseUtils.queryNumEntries(db, ConfigDAO.DB_TABLE_ORDER, ORDER_ID + "=" + id);
		return (count > 0) ? true : false;
	}

	public void saveOrUpdateOrder(OrderModel orderModel) {
		ContentValues contentValues = new ContentValues();
		contentValues.put(ORDER_CHARGE, orderModel.getTotalCharge());
		contentValues.put(CREATE_DATE, GenericUtil.convertDateToStringSQL(orderModel.getCreateDate()));
		contentValues.put(IS_PAYMENT, orderModel.isPayment());
		long id = orderModel.getOrderId();
		if (checkOrderExist(id) == true) {
			db.update(ConfigDAO.DB_TABLE_ORDER, contentValues, ORDER_ID + "=" + id, null);
		} else {
			contentValues.put(ORDER_ID, orderModel.getOrderId());
			db.insert(ConfigDAO.DB_TABLE_ORDER, null, contentValues);
		}
	}

	public OrderModel getCurrentOrder() {
		OrderModel orderModel = new OrderModel();
		Cursor cursor = db.query(ConfigDAO.DB_TABLE_ORDER, new String[] { ORDER_ID, ORDER_CHARGE, CREATE_DATE,
				IS_PAYMENT }, IS_PAYMENT + "= 0", null, null, null, null);
		if (cursor.moveToLast()) {
			orderModel = convertOrderFromCusor(cursor);
		}
		cursor.close();
		return orderModel;
	}

	public OrderModel getOrderById(long orderId, boolean isLoadOrderLine) {
		OrderModel orderModel = new OrderModel();
		Cursor cursor = db.query(ConfigDAO.DB_TABLE_ORDER, new String[] { ORDER_ID, ORDER_CHARGE, CREATE_DATE,
				IS_PAYMENT }, ORDER_ID + "= " + orderId, null, null, null, null);
		if (cursor.moveToFirst()) {
			if (isLoadOrderLine == false) {
				orderModel = convertOrderNoOrderLine(cursor);
			} else {
				orderModel = convertOrderFromCusor(cursor);
			}
		}
		cursor.close();
		return orderModel;
	}

	public void updateOrderStatus(long orderId, boolean isPayment) {
	
		String sqlUpdate = "UPDATE " + ConfigDAO.DB_TABLE_ORDER + " SET " + IS_PAYMENT + "= ? WHERE " + ORDER_ID
				+ "= ?";
		db.rawQuery(sqlUpdate, new String[] { isPayment + "", orderId + "" });

	}

	public OrderModel convertOrderFromCusor(Cursor cursor) {
		OrderModel orderModel;
		long orderId = cursor.getLong(cursor.getColumnIndex(ORDER_ID));
		int orderCharge = cursor.getInt(cursor.getColumnIndex(ORDER_CHARGE));
		String dateString = cursor.getString(cursor.getColumnIndex(CREATE_DATE));
		Date createDate = GenericUtil.convertDateFromStringSQL(dateString);
		boolean isPayment = (cursor.getInt(cursor.getColumnIndex(IS_PAYMENT)) == 1) ? true : false;
		orderModel = new OrderModel(orderCharge, createDate, isPayment, new ArrayList<OrderLineModel>(), orderId);
		orderLineDAO.open();
		orderModel.setListOrderLine(orderLineDAO.getOrderLineByOrder(orderId));
		orderLineDAO.close();
		return orderModel;
	}

	public OrderModel convertOrderNoOrderLine(Cursor cursor) {
		OrderModel orderModel;
		long orderId = cursor.getLong(cursor.getColumnIndex(ORDER_ID));
		int orderCharge = cursor.getInt(cursor.getColumnIndex(ORDER_CHARGE));
		String dateString = cursor.getString(cursor.getColumnIndex(CREATE_DATE));
		Date createDate = GenericUtil.convertDateFromStringSQL(dateString);
		boolean isPayment = (cursor.getInt(cursor.getColumnIndex(IS_PAYMENT)) == 1) ? true : false;
		orderModel = new OrderModel(orderCharge, createDate, isPayment, new ArrayList<OrderLineModel>(), orderId);
		return orderModel;
	}

	public long countOrder() {
		long count = DatabaseUtils.queryNumEntries(db, ConfigDAO.DB_TABLE_ORDER);
		return count;
	}

}
