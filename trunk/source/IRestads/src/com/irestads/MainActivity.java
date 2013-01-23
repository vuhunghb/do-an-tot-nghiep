package com.irestads;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.Vector;

import android.os.Bundle;
import android.os.StrictMode;
import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
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

import com.irestads.dao.DishDAO;
import com.irestads.marshal.MarshalLong;
import com.irestads.model.DishModel;
import com.irestads.model.SettingsModel;
import com.irestads.util.StogeSettingsUtil;
import com.irestads.util.UpdateTimerTask;

@SuppressLint({ "NewApi", "UseValueOf" })
public class MainActivity extends Activity {

	public static final String NAMESPACE = "http://model.irestads/";
	public static String URL = "http://test:test@192.168.15.100:8080/DishsStore-portlet/api/axis/Plugin_dishsstore_DishService?wsdl";
	public static final String METHOD_NAME = "getAllDishs";
	 private static final String SOAP_ACTION ="http://model.irestads/getAllDishs";
	// "http://model.irestads/getSinhVienByLop";
	public static final String PREFS_NAME = "iRestAdsPrefsFile";
	public static SettingsModel settingsModel;
	public static Timer timer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().setFormat(PixelFormat.RGBA_8888);
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_DITHER);

		setContentView(R.layout.activity_main);
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
				.permitAll().build();
		StrictMode.setThreadPolicy(policy);

		ActionBar actionBar = getActionBar();
		actionBar.hide();

		callServiceMethod();
		
		StogeSettingsUtil settingsUtil = new StogeSettingsUtil();
		settingsModel = settingsUtil.readSettings();
		runUpdateTimer();
	}

	public static void runUpdateTimer() {
		if (timer != null) {
			timer.cancel();
		}
		timer = new Timer();
		// Calendar calendar = new GregorianCalendar(2013, 0, 20, 17, 40);
		Date date = settingsModel.getAutoUpdateTime();
		UpdateTimerTask updateTimerTask = new UpdateTimerTask();
		timer.scheduleAtFixedRate(updateTimerTask, date, 86400000);
	}

	public void setUserSession() {
		SharedPreferences sharedPreferences = getSharedPreferences(
				MainActivity.PREFS_NAME, 0);
		SharedPreferences.Editor editor = sharedPreferences.edit();

		editor.putLong("userSession", new Date().getTime());

		editor.commit();
	}

	public long getUserSession() {
		SharedPreferences sharedPreferences = getSharedPreferences(
				MainActivity.PREFS_NAME, 0);
		long userSession = sharedPreferences.getLong("userSession",
				new Date().getTime());
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

	public void createMenu(Menu menu) {
		// SigninDialog signinDialog = new SigninDialog();
		// signinDialog.show(getFragmentManager(), "dialog");

		MenuItem mnu1 = menu.add(0, 0, 0, "Thiết lập");
		{
			mnu1.setAlphabeticShortcut('a');
			mnu1.setIcon(R.drawable.ic_launcher);

		}
		MenuItem mnu2 = menu.add(0, 1, 1, "Item 2");
		{
			mnu2.setAlphabeticShortcut('b');
			mnu2.setIcon(R.drawable.ic_launcher);

		}
		MenuItem mnu3 = menu.add(0, 2, 2, "Item 3");
		{
			mnu3.setAlphabeticShortcut('c');
			mnu3.setIcon(R.drawable.ic_launcher);

		}
		MenuItem mnu4 = menu.add(0, 3, 3, "Item 4");
		{
			mnu4.setAlphabeticShortcut('d');
			mnu4.setIcon(R.drawable.ic_launcher);

		}
		MenuItem mnu5 = menu.add(0, 4, 4, "Item 5");
		{
			mnu5.setAlphabeticShortcut('e');
			mnu5.setIcon(R.drawable.ic_launcher);

		}
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
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
				.permitAll().build();

		StrictMode.setThreadPolicy(policy);

		SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);

		/*
		 * Create a org.ksoap2.serialization.PropertyInfo object to contain
		 * property information to be sent with the SOAP method call. Each
		 * property requires a new PropertyInfo object. The hello method takes
		 * only 1 argument for a name. Set the property name as "arg0", and
		 * specify the type of the property as STRING_CLASS. Add the
		 * PropertyInfo object to the SoapObject using the addProperty method.
		 * 
		 * PropertyInfo propInfo=new PropertyInfo(); propInfo.name="arg0";
		 * propInfo.type=PropertyInfo.STRING_CLASS;
		 * request.addProperty(propInfo, "John Smith");
		 */
		//
		// PropertyInfo propInfo = new PropertyInfo();
		// propInfo.setName("lopId");
		// propInfo.setType(PropertyInfo.LONG_CLASS);
		Long id = new Long(1);
		// propInfo.setValue(id);

//		request.addProperty("lopID", new Long(1));
		// request.addProperty(propInfo);
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER12);
		envelope.setOutputSoapObject(request);
		
		MarshalLong mL = new MarshalLong();
		mL.register(envelope);

		HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

		try {
			androidHttpTransport.call(SOAP_ACTION, envelope);

			// SoapPrimitive resultsRequestSOAP = (SoapPrimitive) envelope
			// .getResponse();
			String resultsRequestSOAP = "";

			java.util.Vector<SoapObject> response = (java.util.Vector<SoapObject>) envelope
					.getResponse();
			Vector<SoapObject> rs = response;
			if (rs != null) {
				for (SoapObject cs : rs) {
					resultsRequestSOAP = resultsRequestSOAP + "0 : "
							+ cs.getProperty("dishName").toString(); // ok
					resultsRequestSOAP = resultsRequestSOAP + "2 : "
							+ cs.getProperty("dishId").toString();
					resultsRequestSOAP = resultsRequestSOAP + "\n";
				}
			}

			Toast.makeText(this, resultsRequestSOAP, Toast.LENGTH_LONG).show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
