package com.irestads;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import android.os.Bundle;
import android.os.StrictMode;
import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.ksoap2.serialization.PropertyInfo;

import com.irestads.dao.DishDAO;
import com.irestads.dao.OrderDAO;
import com.irestads.dao.OrderLineDAO;
import com.irestads.marshal.MarshalLong;
import com.irestads.model.CategoryModel;
import com.irestads.model.DishModel;
import com.irestads.model.OrderLineModel;
import com.irestads.model.OrderModel;
import com.irestads.util.FormatOutputUtils;
import com.irestads.util.GenericUtil;
import com.irestads.util.ImageUtils;

@SuppressLint({ "NewApi", "UseValueOf" })
public class OrderDishActivity extends Activity {

	// DishModel currentDishModel;
	long selectedDishId;
	int currentNumOfDish = 1;

	OrderLineModel currentOrderLineModel;
	int currentOrderLineIndex = -1;
	OrderModel orderModel;
	String[] orderLineStatus;
	DishDAO dishDAO;
	OrderDAO orderDAO;
	OrderLineDAO orderLineDAO;
	TableLayout tableLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().setFormat(PixelFormat.RGBA_8888);
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_DITHER);

		setContentView(R.layout.activity_order_dish);

		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		StrictMode.setThreadPolicy(policy);

		ActionBar actionBar = getActionBar();
		actionBar.hide();
		dishDAO = new DishDAO(this);
		orderLineDAO = new OrderLineDAO(this);
		orderDAO = new OrderDAO(this);

		initOrder();

		/*-----------Test Data-----------*/
		/*-----------Test Data-----------*/

		this.updateDishSelectedView();
		this.updateOrderView();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		if (orderModel.getListOrderLine().size() > 0) {

			orderDAO.open();
			orderDAO.saveOrUpdateOrder(orderModel);
			orderDAO.close();
		}
	}

	public void initTestData() {
		long userSession = getUserSession();
		/*----This Data will get from DB by userSession----*/
		orderModel = new OrderModel(0, new Date(), false, new ArrayList<OrderLineModel>(), userSession);
		// DishModel dish = CategoryModel.testData().get(0).getDishs().get(2);
		// /*-----Test Data-----*/
		// currentOrderLineModel = new OrderLineModel(dish, 1, 0, new Date(),
		// 1);
		// orderModel.getListOrderLine().add(currentOrderLineModel);

	}

	public void initOrder() {
		// initTestData();
		orderDAO.open();
		orderModel = orderDAO.getCurrentOrder();
		orderDAO.close();

		if (orderModel.getOrderId() == 0) {
			orderModel = new OrderModel(0, new Date(), false, new ArrayList<OrderLineModel>(), new Date().getTime());
		}

		orderLineStatus = getResources().getStringArray(R.array.order_line_status);

		SharedPreferences sharedPreferences = getSharedPreferences(GenericUtil.PREFS_NAME, 0);
		selectedDishId = sharedPreferences.getLong("scr1CurrentDishId", 0);

		getCurrentOrderline(selectedDishId);

	}

	public void getCurrentOrderline(long dishID) {
		OrderLineModel oderLine;
		int currentIndex = getCurrentOrderlineIndex(dishID);

		if (currentIndex != -1) {
			currentOrderLineModel = orderModel.getListOrderLine().get(currentIndex);
			currentOrderLineIndex = currentIndex;
		} else {
			/*-----Test Data-----*/
			dishDAO.open();
			DishModel dish = dishDAO.getDishById(dishID);
			dishDAO.close();
			/*-----Test Data-----*/
			currentOrderLineModel = new OrderLineModel(new Date().getTime(), 1, 0, new Date(), 0, dish.getDishID(),
					orderModel.getOrderId());
			currentOrderLineModel.setDish(dish);

		}
		currentNumOfDish = currentOrderLineModel.getNumOfDish();
	}

	public int getCurrentOrderlineIndex(long dishID) {
		OrderLineModel oderLine;
		int size = orderModel.getListOrderLine().size();
		int currentIndex = -1;

		for (int i = 0; i < size; i++) {
			oderLine = orderModel.getListOrderLine().get(i);
			if (oderLine.getDish().getDishID() == dishID) {
				currentIndex = i;
				break;
			}
		}
		return currentIndex;
	}

	public void updateDishSelectedView() {

		DishModel currentDishModel = this.currentOrderLineModel.getDish();
		TextView rightDishName = (TextView) findViewById(R.id.scr2_current_dish_name);
		rightDishName.setText(currentDishModel.getDishName());

		TextView rightDishPrice = (TextView) findViewById(R.id.scr2_current_price_value);
		rightDishPrice.setText(currentDishModel.getReferPrice() + "");

		TextView rightNumOfDiner = (TextView) findViewById(R.id.scr2_current_numofdiner_value);
		int numOfDiner = currentDishModel.getNumOfDiner();
		String numOfDinerText = FormatOutputUtils.formatIntToString(numOfDiner, 1);
		rightNumOfDiner.setText(numOfDinerText + " " + getResources().getString(R.string.sc1_dinner_title));

		ImageView avatarView = (ImageView) findViewById(R.id.scr2_dish_avatar);
		Bitmap bm = ImageUtils.getImageByDishAvatar(currentDishModel.getAvatarImg(), this.getResources(),
				R.drawable.cantfoundish);
		avatarView.setImageBitmap(bm);

		TextView numOfDish = (TextView) findViewById(R.id.scr2_current_numofdish);
		numOfDish.setText(FormatOutputUtils.formatIntToString(currentNumOfDish, 1));

		TextView currentOrderLineStt = (TextView) findViewById(R.id.scr2_current_orderline_stt);
		int currentStt = currentOrderLineModel.getStatus();
		currentOrderLineStt.setText(orderLineStatus[currentStt]);

		TextView currentDishFinish = (TextView) findViewById(R.id.scr2_current_orderline_finish_stt);

		if (currentStt != 0) {
			currentDishFinish.setText("(" + currentOrderLineModel.getNumOfFinishDish() + "/"
					+ currentOrderLineModel.getNumOfDish() + ")");
		} else {
			currentDishFinish.setText("");
		}
	}

	public void updateOrderView() {

		TextView orderTotalPrice = (TextView) findViewById(R.id.scr2_order_total_price);
		orderTotalPrice.setText(orderModel.getTotalCharge() + "");

		tableLayout = (TableLayout) findViewById(R.id.scr2_order_table);
		tableLayout.removeAllViews();

		List<OrderLineModel> listOrderLine = orderModel.getListOrderLine();

		if (listOrderLine.size() > 0) {

			TableRow tableRow;
			TextView tableCellNumber, tableCellDishName, tableCellDishPrice, tableCellNumberDish, tableCellPrice;

			TableLayout.LayoutParams tableRowLayout = new TableLayout.LayoutParams(
					TableLayout.LayoutParams.WRAP_CONTENT, TableLayout.LayoutParams.WRAP_CONTENT, 1f);
			tableRowLayout.setMargins(1, 1, 1, 1);

			TableRow.LayoutParams textRowNumber = new TableRow.LayoutParams(0, TableRow.LayoutParams.MATCH_PARENT,
					0.08f);
			TableRow.LayoutParams textDishName = new TableRow.LayoutParams(0, TableRow.LayoutParams.MATCH_PARENT, 0.55f);
			TableRow.LayoutParams textDishPrice = new TableRow.LayoutParams(0, TableRow.LayoutParams.MATCH_PARENT,
					0.15f);
			TableRow.LayoutParams textNumberDish = new TableRow.LayoutParams(0, TableRow.LayoutParams.MATCH_PARENT,
					0.08f);
			TableRow.LayoutParams textPrice = new TableRow.LayoutParams(0, TableRow.LayoutParams.MATCH_PARENT, 0.15f);

			for (int i = listOrderLine.size() - 1; i >= 0; i--) {
				OrderLineModel orderLine = listOrderLine.get(i);

				tableRow = new TableRow(this);
				tableRow.setBackgroundColor(Color.parseColor("#ffffff"));
				tableRow.setGravity(Gravity.CENTER_VERTICAL);
				tableRow.setMinimumHeight(50);
				tableRow.setLayoutParams(tableRowLayout);
				tableRow.setId(i);

				tableCellNumber = new TextView(this);
				tableCellNumber.setLayoutParams(textRowNumber);
				tableCellNumber.setGravity(Gravity.CENTER_VERTICAL);
				tableCellNumber.setTextAppearance(this, android.R.style.TextAppearance_Medium);
				tableCellNumber.setText("#" + (i + 1));

				tableCellDishName = new TextView(this);
				tableCellDishName.setLayoutParams(textDishName);
				tableCellDishName.setGravity(Gravity.CENTER_VERTICAL);
				tableCellDishName.setTextAppearance(this, android.R.style.TextAppearance_Medium);
				tableCellDishName.setText(orderLine.getDish().getDishName());

				tableCellDishPrice = new TextView(this);
				tableCellDishPrice.setLayoutParams(textDishPrice);
				tableCellDishPrice.setGravity(Gravity.CENTER_VERTICAL);
				tableCellDishPrice.setTextAppearance(this, android.R.style.TextAppearance_Medium);
				tableCellDishPrice.setText(orderLine.getDish().getReferPrice() + "");

				tableCellNumberDish = new TextView(this);
				tableCellNumberDish.setLayoutParams(textNumberDish);
				tableCellNumberDish.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER);
				tableCellNumberDish.setTextAppearance(this, android.R.style.TextAppearance_Medium);
				tableCellNumberDish.setText("X " + orderLine.getNumOfDish());
				tableCellNumberDish.setTextColor(Color.parseColor("#1e48e7"));

				tableCellPrice = new TextView(this);
				tableCellPrice.setLayoutParams(textPrice);
				tableCellPrice.setGravity(Gravity.CENTER_VERTICAL | Gravity.RIGHT);
				tableCellPrice.setTextAppearance(this, android.R.style.TextAppearance_Medium);
				tableCellPrice.setText(orderLine.getOrderLinePrice() + "");
				tableCellPrice.setTextColor(Color.parseColor("#c20e0e"));

				tableRow.addView(tableCellNumber);
				tableRow.addView(tableCellDishName);
				tableRow.addView(tableCellDishPrice);
				tableRow.addView(tableCellNumberDish);
				tableRow.addView(tableCellPrice);

				tableRow.setClickable(true);
				tableRow.setOnClickListener(onClickScr2OrderLineItem);
				tableLayout.addView(tableRow);
			}
		}

	}

	/***
	 * listening when user click on dish item when Scr1
	 */
	private OnClickListener onClickScr2OrderLineItem = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			TableRow tbRow = (TableRow) v;
			int id = tbRow.getId();
			currentOrderLineIndex = id;
			currentOrderLineModel = orderModel.getListOrderLine().get(id);
			currentNumOfDish = currentOrderLineModel.getNumOfDish();
			updateDishSelectedView();
		}
	};

	public void onClickScr2ChangeNumber(View v) {
		int id = v.getId();
		if (id == R.id.scr2_increase_button) {
			currentNumOfDish = currentNumOfDish + 1;
		} else if (currentNumOfDish > 1) {
			currentNumOfDish = currentNumOfDish - 1;
		}
		TextView numOfDish = (TextView) findViewById(R.id.scr2_current_numofdish);
		numOfDish.setText(FormatOutputUtils.formatIntToString(currentNumOfDish, 1));
	}

	public void onClickScr2AcceptOrder(View v) {
		new AlertDialog.Builder(this)
				.setTitle(getResources().getString(R.string.scr2_comfirm_accept_title))
				.setMessage(getResources().getString(R.string.scr2_comfirm_accept_massage))
				.setIcon(android.R.drawable.ic_dialog_alert)
				.setPositiveButton(getResources().getString(R.string.scr2_comfirm_accept_ok),
						new DialogInterface.OnClickListener() {

							public void onClick(DialogInterface dialog, int whichButton) {
								addOrderLine();
							}
						}).setNegativeButton(getResources().getString(R.string.scr2_comfirm_accept_cancel), null)
				.show();

	}

	public void onClieckScr2CancelOrder(View v) {
		new AlertDialog.Builder(this)
				.setTitle(getResources().getString(R.string.scr2_comfirm_cancel_title))
				.setMessage(getResources().getString(R.string.scr2_comfirm_cancel_massage))
				.setIcon(android.R.drawable.ic_dialog_alert)
				.setPositiveButton(getResources().getString(R.string.scr2_comfirm_accept_ok),
						new DialogInterface.OnClickListener() {

							public void onClick(DialogInterface dialog, int whichButton) {
								removeOrderLine();
							}
						}).setNegativeButton(getResources().getString(R.string.scr2_comfirm_accept_cancel), null)
				.show();

	}

	public void removeOrderLine() {
		String massage = "";

		int stt = this.currentOrderLineModel.getStatus();
		if (stt == 0) {
			startActivity(new Intent("android.intent.action.MainListActivity"));
		} else if (stt == 1) {
			int index = this.getCurrentOrderlineIndex(this.currentOrderLineModel.getDish().getDishID());

			if (index != -1) {
				this.orderModel.getListOrderLine().remove(index);
			}

			this.orderModel.getTotalCharge();

			orderLineDAO.open();
			orderLineDAO.deleteOrderLine(currentOrderLineModel.getOrderLineId());
			orderLineDAO.close();

			this.updateDishSelectedView();
			this.updateOrderView();
			Toast.makeText(this, getResources().getString(R.string.scr2_comfirm_cancel_1), Toast.LENGTH_SHORT).show();
		} else {
			Toast.makeText(this, getResources().getString(R.string.scr2_comfirm_cancel_2), Toast.LENGTH_SHORT).show();
		}
	}

	public void addOrderLine() {
		this.currentOrderLineModel.setNumOfDish(currentNumOfDish);
		this.currentOrderLineModel.setStatus(1);
		int index = this.getCurrentOrderlineIndex(this.currentOrderLineModel.getDish().getDishID());

		if (index != -1) {
			this.orderModel.getListOrderLine().set(index, currentOrderLineModel);
		} else {
			this.orderModel.getListOrderLine().add(currentOrderLineModel);
		}
		orderLineDAO.open();
		orderLineDAO.saveOrUpdateOrder(currentOrderLineModel);
		orderLineDAO.close();
		this.orderModel.getTotalCharge();

		this.updateDishSelectedView();
		this.updateOrderView();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	public long getUserSession() {
		SharedPreferences sharedPreferences = getSharedPreferences(GenericUtil.PREFS_NAME, 0);
		long userSession = sharedPreferences.getLong("userSession", new Date().getTime());
		return userSession;
	}

}