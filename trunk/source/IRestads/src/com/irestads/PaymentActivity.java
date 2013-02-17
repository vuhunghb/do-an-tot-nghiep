package com.irestads;

import java.util.ArrayList;
import java.util.List;

import com.irestads.client.OrderConnect;
import com.irestads.dao.OrderDAO;
import com.irestads.model.OrderLineModel;
import com.irestads.model.OrderModel;
import com.irestads.util.FormatOutputUtils;
import com.irestads.util.GenericUtil;
import com.irestads.util.ImageUtils;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.Bundle;
import android.provider.CalendarContract.Colors;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;

@SuppressLint("NewApi")
public class PaymentActivity extends Activity {
	FragmentManager fragmentManager;
	OrderModel orderModel;
	OrderLineModel selectedOrderLine;
	OrderDAO orderDAO;
	String[] orderStatusValue;
	String[] orderLineStatusValue;
	String[] functionName;
	TextView totalPrice;
	TextView numOfDish;
	TextView orderStatus;
	TextView createDate;
	LinearLayout rightContent;
	List<LinearLayout> listItemsLayout;
	OrderConnect orderConnect;

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_payment);

		GenericUtil.currentActivity = PaymentActivity.class.toString();
		orderStatusValue = getResources().getStringArray(R.array.order_status);
		orderLineStatusValue = getResources().getStringArray(R.array.order_line_status);
		functionName = getResources().getStringArray(R.array.menu_src1_item_title);
		ActionBar actionBar = getActionBar();
		actionBar.hide();

		totalPrice = (TextView) findViewById(R.id.scr3_totalprice_value);
		numOfDish = (TextView) findViewById(R.id.scr3_numberdish_value);
		orderStatus = (TextView) findViewById(R.id.scr3_orderstatus_value);
		createDate = (TextView) findViewById(R.id.scr3_paymenttime_value);
		rightContent = (LinearLayout) findViewById(R.id.scr3_right_orderlines);

		listItemsLayout = new ArrayList<LinearLayout>();
		initPayment();
		GenericUtil.runOrderUpdateTimer(this, orderModel.getOrderId());
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		if (GenericUtil.timerAutoOrderUpdate != null) {
			GenericUtil.timerAutoOrderUpdate.cancel();
		}
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		GenericUtil.runOrderUpdateTimer(this, orderModel.getOrderId());
	}

	public void initPayment() {
		orderDAO = new OrderDAO(this);
		orderDAO.open();
		orderModel = orderDAO.getCurrentOrder();
		orderDAO.close();

		totalPrice.setText(orderModel.getTotalCharge() + "");
		numOfDish.setText(FormatOutputUtils.formatIntToString(orderModel.getListOrderLine().size(), 1));
		String statusValue = (orderModel.isPayment() == false) ? orderStatusValue[0] : orderStatusValue[1];
		orderStatus.setText(statusValue);
		createDate.setText((orderModel.isPayment() == false) ? orderStatusValue[0] : GenericUtil
				.convertDateToStringSQL(orderModel.getCreateDate()));
		rightContent.removeAllViews();
		listItemsLayout = new ArrayList<LinearLayout>();
		for (OrderLineModel orderLineModel : orderModel.getListOrderLine()) {
			this.createRightContent(orderLineModel);
		}
	}

	public void createRightContent(OrderLineModel orderLineModel) {

		LinearLayout.LayoutParams itemParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		itemParams.setMargins(0, 0, 0, 10);
		LinearLayout itemLayout = new LinearLayout(this);
		itemLayout.setLayoutParams(itemParams);
		itemLayout.setOrientation(LinearLayout.VERTICAL);
		itemLayout.setGravity(Gravity.CENTER);

		LinearLayout.LayoutParams itemTextParams = new LayoutParams(LayoutParams.WRAP_CONTENT,
				LayoutParams.WRAP_CONTENT);
		TextView dishName = new TextView(this);
		dishName.setLayoutParams(itemTextParams);
		dishName.setTextAppearance(this, android.R.style.TextAppearance_Large);
		dishName.setText(orderLineModel.getDish().getDishName().toUpperCase());
		itemLayout.addView(dishName);

		LinearLayout.LayoutParams avatarLayoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT,
				LayoutParams.WRAP_CONTENT);
		avatarLayoutParams.gravity = Gravity.CENTER_VERTICAL | Gravity.CENTER;
		LinearLayout avatarLayout = new LinearLayout(this);
		avatarLayout.setLayoutParams(avatarLayoutParams);
		avatarLayout.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER);
		avatarLayout.setBackgroundResource(R.drawable.scr3griditemimgbg);
		// avatarLayout.setClickable(true);
		// avatarLayout.setOnClickListener(onItemPaymentClick);
		avatarLayout.setOnCreateContextMenuListener(this);

		listItemsLayout.add(avatarLayout);

		LinearLayout.LayoutParams imageLayout = new LayoutParams(220, 146);
		ImageView avatar = new ImageView(this);
		avatar.setLayoutParams(imageLayout);
		Bitmap bitmap = ImageUtils.getImageFromByteArray(orderLineModel.getDish().getAvatarImg(), getResources(),
				R.drawable.cantfoundish);
		avatar.setImageBitmap(bitmap);

		avatarLayout.addView(avatar);
		itemLayout.addView(avatarLayout);

		TextView price = new TextView(this);
		price.setLayoutParams(itemTextParams);
		price.setTextAppearance(this, android.R.style.TextAppearance_Medium);
		price.setTextColor(Color.parseColor("#c20e0e"));
		int referPrice = orderLineModel.getDish().getReferPrice();
		int numOfDish = orderLineModel.getNumOfDish();
		price.setText(referPrice + " x " + numOfDish + " = " + (referPrice * numOfDish));
		itemLayout.addView(price);

		TextView orderLineStatus = new TextView(this);
		orderLineStatus.setLayoutParams(itemTextParams);
		orderLineStatus.setTextAppearance(this, android.R.style.TextAppearance_Medium);
		String orderStatus = orderLineStatusValue[orderLineModel.getStatus()] + " ("
				+ orderLineModel.getNumOfFinishDish() + "/" + numOfDish + ")";
		orderLineStatus.setText(orderStatus);
		itemLayout.addView(orderLineStatus);

		LinearLayout.LayoutParams imageLineParam = new LayoutParams(LayoutParams.WRAP_CONTENT,
				LayoutParams.WRAP_CONTENT);
		imageLineParam.setMargins(0, 5, 0, 0);
		ImageView itemLine = new ImageView(this);
		itemLine.setLayoutParams(imageLineParam);
		itemLine.setImageResource(R.drawable.scr3itemline);
		itemLayout.addView(itemLine);

		rightContent.addView(itemLayout);
	}

	public void paymentOnClick(View v) {
		new AlertDialog.Builder(this)
				.setTitle(getResources().getString(R.string.scr3_comfirm_payment_title))
				.setMessage(getResources().getString(R.string.scr3_comfirm_payment_message))
				.setIcon(android.R.drawable.ic_dialog_alert)
				.setPositiveButton(getResources().getString(R.string.scr2_comfirm_accept_ok),
						new DialogInterface.OnClickListener() {

							public void onClick(DialogInterface dialog, int whichButton) {
								setWaitingStatus();
							}
						}).setNegativeButton(getResources().getString(R.string.scr2_comfirm_accept_cancel), null)
				.show();
	}

	public void setWaitingStatus() {
		orderConnect = new OrderConnect(this);
		orderConnect.execute(OrderModel.class.toString(), orderModel, 2);
	}

	public void saveCurrentState(OrderLineModel orderLineModel) {
		SharedPreferences sharedPreferences = getSharedPreferences(GenericUtil.PREFS_NAME, 0);
		SharedPreferences.Editor editor = sharedPreferences.edit();
		editor.putLong("scr1CurrentCategoryId", orderLineModel.getDish().getCategoryId());
		editor.putLong("scr1CurrentDishId", orderLineModel.getDishId());
		editor.commit();
	}

	public void createMenu(Menu menu) {
		menu.add(0, 0, 0, functionName[0]);
		menu.add(0, 1, 1, functionName[1]);
	}

	public boolean choiceItem(MenuItem menuItem) {
		saveCurrentState(selectedOrderLine);
		switch (menuItem.getItemId()) {
		case 0:
			startActivity(new Intent("android.intent.action.OrderDishActivity"));
			return true;
		case 1:
			return true;
		default:
			break;
		}
		return false;
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		super.onCreateContextMenu(menu, v, menuInfo);

		LinearLayout tagetLayout = (LinearLayout) v;
		int index = listItemsLayout.indexOf(tagetLayout);
		selectedOrderLine = orderModel.getListOrderLine().get(index);
		menu.setHeaderTitle(getResources().getString(R.string.scr3_paymenttime_context_title)
				+ selectedOrderLine.getDish().getDishName());
		createMenu(menu);
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		boolean result = choiceItem(item);

		return result;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		// getMenuInflater().inflate(R.menu.activity_main, menu);
		super.onCreateOptionsMenu(menu);
		createMenuOption(menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		return menuChoice(item);
	}

	public void createMenuOption(Menu menu) {

		String[] function = getResources().getStringArray(R.array.menu_src1_item_title);
		MenuItem mnu1 = menu.add(0, 0, 0, getResources().getString(R.string.menu_item_listdish));
		{
			mnu1.setAlphabeticShortcut('a');
			mnu1.setIcon(R.drawable.ic_launcher);

		}
		MenuItem mnu2 = menu.add(0, 1, 1, function[0]);
		{
			mnu2.setAlphabeticShortcut('b');
			mnu2.setIcon(R.drawable.ic_launcher);

		}
		MenuItem mnu3 = menu.add(0, 2, 2, function[1]);
		{
			mnu3.setAlphabeticShortcut('c');
			mnu3.setIcon(R.drawable.ic_launcher);

		}
		MenuItem mnu5 = menu.add(0, 4, 4, function[3]);
		{
			mnu5.setAlphabeticShortcut('e');
			mnu5.setIcon(R.drawable.ic_launcher);

		}
	}

	public boolean menuChoice(MenuItem item) {

		switch (item.getItemId()) {
		case 0:
			startActivity(new Intent("android.intent.action.MainListActivity"));
			return true;
		case 1:
			startActivity(new Intent("android.intent.action.OrderDishActivity"));
			return true;
		case 2:
			Toast.makeText(this, "Choice 2", Toast.LENGTH_SHORT).show();
			return true;		case 4:
			startActivity(new Intent("android.intent.action.AdsBookActivity"));
			return true;

		default:
			return false;
		}
	}
}
