package com.irestads.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Timer;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Handler;

import com.irestads.MainActivity;
import com.irestads.dao.CategoryDAO;
import com.irestads.model.SettingsModel;

public class GenericUtil {

	public static final String NAMESPACE = "http://model.irestads";
	public static final String PREFS_NAME = "iRestAdsPrefsFile";

	public static String URL;

	public static String VERSION_URL;
	public static String VERSION_METHOD_CHECK = "findNextVersions";

	public static String MENULINE_URL;
	public static String MENULINE_METHOD_GET = "findMenuLineById";

	public static String DISH_URL;
	public static String DISH_METHOD_GET = "findDishsById";

	public static SettingsModel settingsModel;

	public static Timer timerAutoUpdate;
	public static String[] classNames = { "irestads.model.MenuLine", "irestads.model.Dish" };

	public static boolean isConnected = true;

	public static String currentActivity = "";

	public GenericUtil() {
		StogeSettingsUtil settingsUtil = new StogeSettingsUtil();
		settingsModel = settingsUtil.readSettings();
		updateLink(settingsModel);
	}

	public static void updateLink(SettingsModel settingsModel) {
		URL = "http://" + settingsModel.getUserConnect() + ":" + settingsModel.getPassConnect() + "@"
				+ settingsModel.getServerAddress() + ":8080";
		VERSION_URL = URL + "/DishsStore-portlet/api/axis/Plugin_dishsstore_UVersionService?wsdl";
		MENULINE_URL = URL + "/DishsStore-portlet/api/axis/Plugin_dishsstore_MenuLineService?wsdl";
		DISH_URL = URL + "/DishsStore-portlet/api/axis/Plugin_dishsstore_DishService?wsdl";
	}

	@SuppressLint("SimpleDateFormat")
	private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
	private static SimpleDateFormat dateSQLFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public static void runUpdateTimer(Activity activity) {
		if (timerAutoUpdate != null) {
			timerAutoUpdate.cancel();
		}

		Handler handler = new Handler();
		UpdateTimerTask updateTimerTask = new UpdateTimerTask(activity, handler);

		timerAutoUpdate = new Timer();
		Date date = settingsModel.getAutoUpdateTime();

		timerAutoUpdate.scheduleAtFixedRate(updateTimerTask, date, 86400000);
	}

	public static int getTypeClass(String className) {
		List<String> list = Arrays.asList(classNames);
		return list.indexOf(className);
	}

	public static Date convertDateFromString(String dateString) {
		Date date = new Date();
		try {
			date = dateFormat.parse(dateString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}

	public static String convertDateToString(Date date) {
		String dateString = dateFormat.format(date);
		return dateString;
	}

	public static Date convertDateFromStringSQL(String dateString) {
		Date date = new Date();
		try {
			date = dateSQLFormat.parse(dateString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}

	public static String convertDateToStringSQL(Date date) {
		String dateString = dateSQLFormat.format(date);
		return dateString;
	}
}
