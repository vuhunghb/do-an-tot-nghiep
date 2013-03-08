package com.irestads.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import com.irestads.OrderDishActivity;
import com.irestads.R;
import com.irestads.dao.OrderLineDAO;
import com.irestads.model.MenuLineModel;
import com.irestads.model.OrderLineModel;
import com.irestads.model.OrderModel;
import com.irestads.util.GenericUtil;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;

public class OrderConnect extends AsyncTask<Object, String, Boolean> {

	Activity activity;
	public static String[] orderAttr = { "orderId", "charge", "isPayMent", "numOfDinner", "dishTableId", "createdDate",
			"isWaiting" };
	public static String[] orderLineAttr = { "orderLineId", "numOfDish", "numOfFinishDish", "statusDish", "dishId",
			"orderId", "orderDate" };

	public OrderConnect(Activity activity) {
		super();
		this.activity = activity;
	}

	int dishIsAvaiable = 0;
	int resultOfTask = 0;
	String modelName;

	@Override
	protected Boolean doInBackground(Object... params) {
		// TODO Auto-generated method stub

		modelName = (String) params[0];
		if (modelName.equalsIgnoreCase(OrderModel.class.toString())) {
			return handleOrderService(params);
		} else if (modelName.equalsIgnoreCase(OrderLineModel.class.toString())) {
			return handleOrderLineService(params);
		}
		return true;
	}

	public boolean handleOrderService(Object... params) {
		OrderModel orderModel = (OrderModel) params[1];
		Integer actionType = (Integer) params[2];
		switch (actionType) {
		case 0:
			return (this.createOrderServer(orderModel) > -1);
		case 1:
			return deleteOrderById(orderModel);
		case 2:
			return setWaitingStatus(orderModel.getOrderId());
		default:
			break;
		}
		return false;
	}

	public boolean handleOrderLineService(Object... params) {
		OrderLineModel orderLineModel = (OrderLineModel) params[1];
		Integer actionType = (Integer) params[2];
		boolean result = false;
		switch (actionType) {
		case 0:
			result = this.createOrderLineServer(orderLineModel) != -1;
			break;
		case 1:
			result =  this.deleteOrderLineById(orderLineModel);
		default:
			break;
		}
		return result;
	}

	@Override
	protected void onProgressUpdate(String... values) {
		// TODO Auto-generated method stub
		super.onProgressUpdate(values);
	}

	@Override
	protected void onPostExecute(Boolean result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
		if (modelName.equals(OrderLineModel.class.toString())) {
			if (resultOfTask == -1) {
				new AlertDialog.Builder(activity)
						.setTitle(activity.getResources().getString(R.string.scr2_comfirm_notenoughdish_title))
						.setMessage(
								activity.getResources().getString(R.string.scr2_comfirm_notenoughdish_massage)
										+ dishIsAvaiable
										+ activity.getResources().getString(
												R.string.scr2_comfirm_notenoughdish_massage_postfix))
						.setIcon(android.R.drawable.ic_dialog_alert)
						.setPositiveButton(activity.getResources().getString(R.string.scr2_comfirm_notenoughdish_ok),
								new DialogInterface.OnClickListener() {

									public void onClick(DialogInterface dialog, int whichButton) {
									}
								}).show();
			} else {
				OrderDishActivity orDishActivity = (OrderDishActivity) activity;
				orDishActivity.createOrderLine();
			}

		}
	}

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	private long createOrderServer(OrderModel orderModel) {
		long resultId = 0;
		SoapObject request = new SoapObject(GenericUtil.NAMESPACE, GenericUtil.ORDER_METHOD_CREATE);
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		envelope.setOutputSoapObject(request);

		request.addProperty(orderAttr[0], orderModel.getOrderId());
		request.addProperty(orderAttr[1], orderModel.getCharge());
		request.addProperty(orderAttr[2], orderModel.getIsPayment());
		request.addProperty(orderAttr[3], 0);
		request.addProperty(orderAttr[4], GenericUtil.settingsModel.getTableName());
		request.addProperty(orderAttr[5], orderModel.getCreateDate().getTime());

		HttpTransportSE ht = new HttpTransportSE(GenericUtil.ORDER_URL);

		try {
			ht.call(GenericUtil.NAMESPACE + "/" + GenericUtil.ORDER_METHOD_CREATE, envelope);
			SoapObject soapObject = (SoapObject) envelope.getResponse();
			if (soapObject != null) {
				resultId = Long.valueOf(soapObject.getProperty(orderAttr[0]).toString());
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XmlPullParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultId;
	}

	private boolean deleteOrderById(OrderModel orderModel) {
		boolean result = false;
		SoapObject request = new SoapObject(GenericUtil.NAMESPACE, GenericUtil.ORDER_METHOD_DELETE);
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		envelope.setOutputSoapObject(request);
		request.addProperty(orderAttr[0], orderModel.getOrderId());

		HttpTransportSE ht = new HttpTransportSE(GenericUtil.ORDER_URL);

		try {
			ht.call(GenericUtil.NAMESPACE + "/" + GenericUtil.ORDER_METHOD_DELETE, envelope);
			Boolean response = (Boolean) envelope.getResponse();
			if (response != null) {
				result = response;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XmlPullParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	private long createOrderLineServer(OrderLineModel orderLineModel) {
		long resultId = 0;
		SoapObject request = new SoapObject(GenericUtil.NAMESPACE, GenericUtil.ORDERLINE_METHOD_CREATE);
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		envelope.setOutputSoapObject(request);
		request.addProperty(orderLineAttr[0], orderLineModel.getOrderLineId());
		request.addProperty(orderLineAttr[1], orderLineModel.getNumOfDish());
		request.addProperty(orderLineAttr[3], orderLineModel.getStatus());
		request.addProperty(orderLineAttr[4], orderLineModel.getDishId());
		request.addProperty(orderLineAttr[5], orderLineModel.getOrderId());
		request.addProperty(orderLineAttr[6], orderLineModel.getOrderDate().getTime());

		HttpTransportSE ht = new HttpTransportSE(GenericUtil.ORDERLINE_URL);

		try {
			ht.call(GenericUtil.NAMESPACE + "/" + GenericUtil.ORDERLINE_METHOD_CREATE, envelope);
			SoapObject soapObject = (SoapObject) envelope.getResponse();
			if (soapObject != null) {
				resultId = Long.valueOf(soapObject.getProperty(orderLineAttr[0]).toString());
				if (resultId == -1) {
					dishIsAvaiable = Integer.parseInt(soapObject.getProperty(orderLineAttr[1]).toString());
					resultOfTask = -1;
				} else {
					dishIsAvaiable = 0;
					resultOfTask = 0;
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			dishIsAvaiable = 0;
			resultOfTask = 0;
		} catch (XmlPullParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultId;
	}

	private boolean deleteOrderLineById(OrderLineModel orderLineModel) {
		boolean result = false;
		SoapObject request = new SoapObject(GenericUtil.NAMESPACE, GenericUtil.ORDERLINE_METHOD_DELETE);
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		envelope.setOutputSoapObject(request);
		request.addProperty(orderLineAttr[0], orderLineModel.getOrderLineId());

		HttpTransportSE ht = new HttpTransportSE(GenericUtil.ORDERLINE_URL);

		try {
			ht.call(GenericUtil.NAMESPACE + "/" + GenericUtil.ORDERLINE_METHOD_DELETE, envelope);
			Boolean response = (Boolean) envelope.getResponse();
			if (response != null) {
				result = response;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XmlPullParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	private boolean setWaitingStatus(long orderId) {
		boolean result = false;
		SoapObject request = new SoapObject(GenericUtil.NAMESPACE, GenericUtil.ORDER_METHOD_SETWAITING);
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		envelope.setOutputSoapObject(request);
		request.addProperty(OrderConnect.orderAttr[0], orderId);
		HttpTransportSE ht = new HttpTransportSE(GenericUtil.ORDER_URL);

		try {
			ht.call(GenericUtil.NAMESPACE + "/" + GenericUtil.ORDER_METHOD_SETWAITING, envelope);
			Boolean response = (Boolean) envelope.getResponse();
			if (response != null) {
				result = response;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XmlPullParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public int getDishIsAvaiable() {
		return dishIsAvaiable;
	}

	public void setDishIsAvaiable(int dishIsAvaiable) {
		this.dishIsAvaiable = dishIsAvaiable;
	}

	public int getResultOfTask() {
		return resultOfTask;
	}

	public void setResultOfTask(int resultOfTask) {
		this.resultOfTask = resultOfTask;
	}

}
