package com.irestads;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Timer;
import java.util.Vector;

import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.provider.Settings;
import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.app.KeyguardManager;
import android.app.KeyguardManager.KeyguardLock;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.graphics.PixelFormat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.ksoap2.serialization.PropertyInfo;
import org.xmlpull.v1.XmlPullParserException;

import com.irestads.dao.AdsItemDAO;
import com.irestads.dao.CategoryAdsDAO;
import com.irestads.dao.CategoryDAO;
import com.irestads.dao.ConfigDAO;
import com.irestads.dao.DishDAO;
import com.irestads.dao.MenuLineDAO;
import com.irestads.dao.OrderDAO;
import com.irestads.dao.OrderLineDAO;
import com.irestads.marshal.MarshalLong;
import com.irestads.model.AdsItemModel;
import com.irestads.model.CategoryModel;
import com.irestads.model.DishModel;
import com.irestads.model.SettingsModel;
import com.irestads.util.GenericUtil;
import com.irestads.util.StogeSettingsUtil;
import com.irestads.util.UpdateTimerTask;

@SuppressLint({ "NewApi", "UseValueOf" })
public class MainActivity extends Activity {
	BroadcastReceiver mReceiver;

	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().setFormat(PixelFormat.RGBA_8888);
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_DITHER);

		setContentView(R.layout.activity_main);
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		StrictMode.setThreadPolicy(policy);

		/*-------Create Generic link and property--------*/

		GenericUtil genericUtil = new GenericUtil();
		GenericUtil.currentActivity = MainActivity.class.toString();
		settupDB();
		/*-------Create Generic link and property--------*/
		createCategoryTest();
		ActionBar actionBar = getActionBar();
		actionBar.hide();
		GenericUtil.runUpdateTimer(this);

		/*---------- Register Broadcast Lock Screen-----------*/
		/*-- Set timeout Lockscreen decrease 1 minute--
		 * -- Remember add permission android:name="android.permission.WRITE_SETTINGS" */
		GenericUtil.DEFTIMEOUT = Settings.System.getInt(getContentResolver(), Settings.System.SCREEN_OFF_TIMEOUT,
				GenericUtil.DELAY);
		Settings.System.putInt(getContentResolver(), Settings.System.SCREEN_OFF_TIMEOUT, GenericUtil.DELAY);

		if (mReceiver == null) {
			IntentFilter filter = new IntentFilter(Intent.ACTION_SCREEN_ON);
			filter.addAction(Intent.ACTION_SCREEN_OFF);
			mReceiver = new LockScreenReceiver();
			registerReceiver(mReceiver, filter);
		}

		/*---------- Register Broadcast Lock Screen-----------*/
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Settings.System.putInt(getContentResolver(), Settings.System.SCREEN_OFF_TIMEOUT, GenericUtil.DEFTIMEOUT);
		unregisterReceiver(mReceiver);
	}

	/***
	 * This method to setup DB Because DB is created in first time
	 */
	public void settupDB() {
		ConfigDAO configDAO = new ConfigDAO(this);
		configDAO.open();
		configDAO.close();
	}

	public void createCategoryTest() {
		String[] categories = getResources().getStringArray(R.array.category_name);
		CategoryDAO categoryDAO = new CategoryDAO(this);
		categoryDAO.open();
		for (int i = 0; i < categories.length; i++) {
			String string = categories[i];
			CategoryModel categoryModel = new CategoryModel(i + 1, categories[i], new ArrayList<DishModel>());
			categoryDAO.saveOrUpdateCategory(categoryModel);
		}
		categoryDAO.close();
	}

	public void setUserSession() {
		SharedPreferences sharedPreferences = getSharedPreferences(GenericUtil.PREFS_NAME, 0);
		SharedPreferences.Editor editor = sharedPreferences.edit();

		editor.putLong("userSession", new Date().getTime());

		editor.commit();
	}

	public long getUserSession() {
		SharedPreferences sharedPreferences = getSharedPreferences(GenericUtil.PREFS_NAME, 0);
		long userSession = sharedPreferences.getLong("userSession", new Date().getTime());
		return userSession;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		// getMenuInflater().inflate(R.menu.activity_main, menu);
		super.onCreateOptionsMenu(menu);
		createMenu(menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		return menuChoice(item);
	}

	public void onClickCallDish(View view) {
		startActivity(new Intent("android.intent.action.MainListActivity"));
	}

	public void onClickAds(View view) {
		startActivity(new Intent("android.intent.action.AdsBookActivity"));
	}

	public void createMenu(Menu menu) {
		MenuItem mnu1 = menu.add(0, 0, 0, getResources().getString(R.string.menu_item_settings));
		{
			mnu1.setAlphabeticShortcut('a');
			mnu1.setIcon(R.drawable.ic_launcher);

		}
		// MenuItem mnu2 = menu.add(0, 1, 1, "Item 2");
		// {
		// mnu2.setAlphabeticShortcut('b');
		// mnu2.setIcon(R.drawable.ic_launcher);
		//
		// }
		// MenuItem mnu3 = menu.add(0, 2, 2, "Item 3");
		// {
		// mnu3.setAlphabeticShortcut('c');
		// mnu3.setIcon(R.drawable.ic_launcher);
		//
		// }
		// MenuItem mnu4 = menu.add(0, 3, 3, "Item 4");
		// {
		// mnu4.setAlphabeticShortcut('d');
		// mnu4.setIcon(R.drawable.ic_launcher);
		//
		// }
		// MenuItem mnu5 = menu.add(0, 4, 4, "Item 5");
		// {
		// mnu5.setAlphabeticShortcut('e');
		// mnu5.setIcon(R.drawable.ic_launcher);
		//
		// }
	}

	public boolean menuChoice(MenuItem item) {
		switch (item.getItemId()) {
		case 0:
			startActivity(new Intent("android.intent.action.SettingsActivity"));
			return true;
		case 1:
			Toast.makeText(this, "Choice 1", Toast.LENGTH_SHORT).show();
			return true;
		case 2:
			Toast.makeText(this, "Choice 2", Toast.LENGTH_SHORT).show();
			return true;
		case 3:
			Toast.makeText(this, "Choice 3", Toast.LENGTH_SHORT).show();
			return true;
		case 4:
			Toast.makeText(this, "Choice 4", Toast.LENGTH_SHORT).show();
			return true;
		case 5:
			Toast.makeText(this, "Choice 5", Toast.LENGTH_SHORT).show();
			return true;

		default:
			return false;
		}
	}

	public void callServiceMethod() {

		// SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
		// SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
		// SoapEnvelope.VER11);
		// envelope.setOutputSoapObject(request);
		// String body = envelope.bodyOut.toString();
		// System.out.println("body out : " + envelope.bodyOut.toString());
		// request.addProperty("dishId", new Long(1));
		// HttpTransportSE ht = new HttpTransportSE(URL);
		//
		// try {
		// ht.debug = true;
		// String a = ht.requestDump;
		// ht.call(SOAP_ACTION, envelope);
		// String b = ht.responseDump;
		//
		// final List<SoapObject> response = (List<SoapObject>) envelope
		// .getResponse();
		// final List<SoapObject> rs = response;
		// String resultsRequestSOAP = "";
		// if (rs != null) {
		// for (SoapObject cs : rs) {
		// resultsRequestSOAP = resultsRequestSOAP + "0 : "
		// + cs.getProperty("dishName").toString(); // ok
		// resultsRequestSOAP = resultsRequestSOAP + "2 : "
		// + cs.getProperty("dishId").toString();
		// resultsRequestSOAP = resultsRequestSOAP + "\n";
		// }
		// }
		// System.out.println("Result " + resultsRequestSOAP);
		//
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// } catch (XmlPullParserException e) {
		// // TODO Auto-generated catch block
		// String b = ht.responseDump;
		// e.printStackTrace();
		// }
	}

}
