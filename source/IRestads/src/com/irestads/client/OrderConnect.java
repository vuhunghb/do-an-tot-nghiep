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

import com.irestads.dao.OrderLineDAO;
import com.irestads.model.MenuLineModel;
import com.irestads.model.OrderLineModel;
import com.irestads.model.OrderModel;
import com.irestads.util.GenericUtil;

import android.app.Activity;
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

	@Override
	protected Boolean doInBackground(Object... params) {
		// TODO Auto-generated method stub

		String modelName = (String) params[0];
		if (modelName.equalsIgnoreCase(OrderModel.class.toString())) {
			handleOrderService(params);
		} else if (modelName.equalsIgnoreCase(OrderLineModel.class.toString())) {
			handleOrderLineService(params);
		}
		return false;
	}

	public void handleOrderService(Object... params) {
		OrderModel orderModel = (OrderModel) params[1];
		Integer actionType = (Integer) params[2];
		switch (actionType) {
		case 0:
			this.createOrderServer(orderModel);
			break;
		case 1:
			this.deleteOrderById(orderModel);
			break;
		case 2:
			this.setWaitingStatus(orderModel.getOrderId());
			break;

		default:
			break;
		}
	}

	public void handleOrderLineService(Object... params) {
		OrderLineModel orderLineModel = (OrderLineModel) params[1];
		Integer actionType = (Integer) params[2];
		switch (actionType) {
		case 0:
			this.createOrderLineServer(orderLineModel);
			break;
		case 1:
			this.deleteOrderLineById(orderLineModel);
			break;
		default:
			break;
		}
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
		request.addProperty(orderAttr[2], orderModel.isPayment());
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

}
