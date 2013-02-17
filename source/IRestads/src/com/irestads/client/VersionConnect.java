package com.irestads.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.XMLGregorianCalendar;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import com.irestads.MainActivity;
import com.irestads.R;
import com.irestads.SettingsActivity;
import com.irestads.dao.DishDAO;
import com.irestads.dao.MenuLineDAO;
import com.irestads.model.DishModel;
import com.irestads.model.LogTypeEnum;
import com.irestads.model.MenuLineModel;
import com.irestads.model.SettingsModel;
import com.irestads.model.VersionModel;
import com.irestads.util.GenericUtil;
import com.irestads.util.ImageUtils;
import com.irestads.util.StogeSettingsUtil;
import com.irestads.util.UpdateTimerTask;

import android.R.menu;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

public class VersionConnect extends AsyncTask<Void, String, Long> {

	Activity activity;
	ProgressDialog progressDialog;
	private String[] versionAtr = { "versionId", "logObjName", "logObjId", "logType", "logDate" };
	MenuLineDAO menuLineDAO;
	DishDAO dishDAO;
	List<SoapObject> versionModels;

	private static String[] className = { MainActivity.class.toString(), SettingsActivity.class.toString() };
	public static List<String> listClassName = Arrays.asList(className);

	 boolean check = false;

	public VersionConnect(Activity activity) {
		super();
		this.activity = activity;
		menuLineDAO = new MenuLineDAO(activity);
		dishDAO = new DishDAO(activity);
		GenericUtil.isConnected = true;
		check = listClassName.contains(GenericUtil.currentActivity);
		versionModels = checkIsMaxVersion();
//		versionModels = new ArrayList<SoapObject>();
	}

	@Override
	protected Long doInBackground(Void... params) {
		// TODO Auto-generated method stub
		Long versionUpdate = GenericUtil.settingsModel.getCurrentVersion();
		if (versionModels.size() > 0) {
			String messageUpdate = activity.getResources().getString(R.string.version_update_message_download);
			long lastVersion = Long.valueOf(versionModels.get(versionModels.size() - 1).getProperty(versionAtr[0])
					.toString());
			for (SoapObject soapObject : versionModels) {
				try {
					String logObjName = soapObject.getProperty(versionAtr[1]).toString();
					long logObjId = Long.parseLong(soapObject.getProperty(versionAtr[2]) + "");
					String logType = soapObject.getProperty(versionAtr[3]).toString();

					int typeOfClass = GenericUtil.getTypeClass(logObjName);
					switch (typeOfClass) {
					case 0:
						handleUpdateMenuLine(logObjId, logType);
						break;
					case 1:
						handleUpdateDish(logObjId, logType);
						break;
					default:
						break;
					}
					versionUpdate = Long.valueOf(soapObject.getProperty(versionAtr[0]).toString());
					publishProgress(messageUpdate + " " + versionUpdate + "/" + lastVersion);
					GenericUtil.settingsModel.setCurrentVersion(versionUpdate);
				} catch (Exception e) {
					// TODO: handle exception
					break;
				}
			}
		}
		return versionUpdate;
	}

	public void handleUpdateMenuLine(long logObjId, String logType) {
		/*---update--*/
		if (logType.equals(LogTypeEnum.CREATE.toString()) || logType.equals(LogTypeEnum.UPDATE.toString())) {
			MenuLineModel lineModel = this.getMenuLineService(logObjId);
			Long id = Long.valueOf(lineModel.getMenuLineId());
			if (id != 0 && id != null) {
				menuLineDAO.open();
				menuLineDAO.saveOrUpdate(lineModel);
				menuLineDAO.close();
			}
		} else {
			menuLineDAO.open();
			menuLineDAO.deleteMenuLine(logObjId);
			menuLineDAO.close();
		}
	}

	public void handleUpdateDish(long logObjId, String logType) {
		/*---update--*/
		dishDAO.open();
		boolean checkIsExist = dishDAO.checkDishIsExist(logObjId);
		if (logType.equals(LogTypeEnum.CREATE.toString()) && checkIsExist == true) {
			System.out.println("Dish " + logObjId + " is Exist : can't create Dish");
		} else {
			DishModel dishModel = this.getDishService(logObjId);
			Long id = Long.valueOf(dishModel.getDishID());
			if (id != 0 && id != null) {
				dishDAO.open();
				dishDAO.saveOrUpdateDish(dishModel);
				dishDAO.close();
			}
		}
		dishDAO.close();
	}

	@Override
	protected void onPreExecute() {
		// TODO Auto-generated method stub
		super.onPreExecute();

		if (versionModels.size() > 0 && check == true) {
			String title = activity.getResources().getString(R.string.version_update_title);
			String message = activity.getResources().getString(R.string.version_update_message);
			progressDialog = ProgressDialog.show(activity, title, message, true, false);
		}
	}

	@Override
	protected void onProgressUpdate(String... values) {
		// TODO Auto-generated method stub
		super.onProgressUpdate(values);
		if (progressDialog != null && progressDialog.isShowing()) {
			progressDialog.setMessage(values[0]);
		}
	}

	@Override
	protected void onPostExecute(Long result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
		System.out.println("Update to " + result);
		StogeSettingsUtil stogeSettingsUtil = new StogeSettingsUtil();
		stogeSettingsUtil.writeSettings(GenericUtil.settingsModel);
		UpdateTimerTask.isDoTask = true;

		if (check == true) {
			if (GenericUtil.isConnected == true) {
				String msg = activity.getResources().getString(R.string.version_update_message_download_max);
				if (progressDialog != null && progressDialog.isShowing()) {
					progressDialog.setMessage(msg);
					Runnable runnable = new Runnable() {

						@Override
						public void run() {
							// TODO Auto-generated method stub
							progressDialog.dismiss();
						}
					};
					Handler handler = new Handler();
					handler.postDelayed(runnable, 3000);
				}
			} else {
				Toast.makeText(activity, activity.getResources().getString(R.string.version_update_message_disconnect),
						Toast.LENGTH_SHORT).show();
			}
		}
	}

	private List<SoapObject> checkIsMaxVersion() {
		SoapObject request = new SoapObject(GenericUtil.NAMESPACE, GenericUtil.VERSION_METHOD_CHECK);
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		envelope.setOutputSoapObject(request);
		request.addProperty("uversionId", Long.valueOf(GenericUtil.settingsModel.getCurrentVersion()));
		HttpTransportSE ht = new HttpTransportSE(GenericUtil.VERSION_URL);
		List<SoapObject> rs = new ArrayList<SoapObject>();
		try {
			ht.call(GenericUtil.NAMESPACE + "/" + GenericUtil.VERSION_METHOD_CHECK, envelope);
			List<SoapObject> response = (List<SoapObject>) envelope.getResponse();
			rs = response;

		} catch (IOException e) {
			// TODO Auto-generated catch block
			GenericUtil.isConnected = false;
			Log.w("VERSION ", e.toString());

		} catch (XmlPullParserException e) {
			// TODO Auto-generated catch block
			String b = ht.responseDump;
			e.printStackTrace();
		}

		return rs;
	}

	private MenuLineModel getMenuLineService(long menuLineId) {
		SoapObject request = new SoapObject(GenericUtil.NAMESPACE, GenericUtil.MENULINE_METHOD_GET);
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		envelope.setOutputSoapObject(request);
		request.addProperty("menuLineId", Long.valueOf(menuLineId));
		HttpTransportSE ht = new HttpTransportSE(GenericUtil.MENULINE_URL);
		MenuLineModel menuLineModel = new MenuLineModel();

		try {
			ht.call(GenericUtil.NAMESPACE + "/" + GenericUtil.MENULINE_METHOD_GET, envelope);
			SoapObject soapObject = (SoapObject) envelope.getResponse();
			if (soapObject != null) {
				long menuId = Long.valueOf(soapObject.getProperty("menuLineId").toString());
				int numOfDish = Integer.valueOf(soapObject.getProperty("numOfDish").toString());
				String stt = soapObject.getProperty("status").toString();
				boolean status = Boolean.getBoolean(stt);
				long dishId = Long.valueOf(soapObject.getProperty("dishId").toString());
				menuLineModel = new MenuLineModel(menuId, numOfDish, status, dishId);

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XmlPullParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return menuLineModel;
	}

	private DishModel getDishService(long dishId) {
		SoapObject request = new SoapObject(GenericUtil.NAMESPACE, GenericUtil.DISH_METHOD_GET);
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		envelope.setOutputSoapObject(request);
		request.addProperty("dishId", Long.valueOf(dishId));
		HttpTransportSE httpTransportSE = new HttpTransportSE(GenericUtil.DISH_URL);
		DishModel dishModel = new DishModel();
		try {
			httpTransportSE.call(GenericUtil.NAMESPACE + "/" + GenericUtil.DISH_METHOD_GET, envelope);
			SoapObject soapObject = (SoapObject) envelope.getResponse();
			if (soapObject != null) {
				dishId = Long.valueOf(soapObject.getProperty("dishId").toString());
				String dishName = soapObject.getProperty("dishName").toString();
				String decription = soapObject.getProperty("decription").toString();
				String detail = soapObject.getProperty("detail").toString();
				String avartarBase64 = soapObject.getProperty("avatarBaseCode").toString();
				byte[] avartarImg = new byte[] {};
				if (!avartarBase64.equals("string{}")) {
					avartarImg = ImageUtils.decodeImage(avartarBase64);
				}

				String detailBase64 = soapObject.getProperty("detailBaseCode").toString();
				if (detailBase64.equals("string{}")) {
					detailBase64 = "";
				}
				String detailImg = detailBase64;
				int referPrice = Integer.valueOf(soapObject.getProperty("referPrice").toString());
				int numOfDiners = Integer.valueOf(soapObject.getProperty("numOfDiner").toString());
				long categoryId = Long.valueOf(soapObject.getProperty("categoryId").toString());
				dishModel = new DishModel(dishId, dishName, decription, detail, avartarImg, detailImg, referPrice,
						numOfDiners, categoryId);

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XmlPullParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return dishModel;
	}

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

}
