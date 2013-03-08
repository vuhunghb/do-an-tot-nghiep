package com.irestads.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import com.irestads.OrderDishActivity;
import com.irestads.PaymentActivity;
import com.irestads.dao.OrderDAO;
import com.irestads.dao.OrderLineDAO;
import com.irestads.model.OrderLineModel;
import com.irestads.model.OrderModel;
import com.irestads.util.GenericUtil;

import android.app.Activity;
import android.os.AsyncTask;

public class OrderUpdateConnect extends AsyncTask<Object, Void, Void> {

	OrderDishActivity orderDishActivity;
	PaymentActivity paymentActivity;
	long orderId;
	OrderLineDAO orderLineDAO;
	OrderDAO orderDAO;
	boolean isStopping = false;

	public OrderUpdateConnect() {
		super();
	}

	@Override
	protected Void doInBackground(Object... params) {
		// TODO Auto-generated method stub

		if (isStopping == false) {
			orderId = (Long) params[1];
			Object object = params[0];
			if (object instanceof OrderDishActivity) {
				orderDishActivity = (OrderDishActivity) object;
				orderLineDAO = new OrderLineDAO(orderDishActivity);
				orderDAO = new OrderDAO(orderDishActivity);
			} else if (object instanceof PaymentActivity) {
				paymentActivity = (PaymentActivity) object;
				orderLineDAO = new OrderLineDAO(paymentActivity);
				orderDAO = new OrderDAO(paymentActivity);
				this.getOrderById(orderId);
			}
			this.getOrderLinesByOrderId(orderId);
		}
		return null;
	}

	@Override
	protected void onPostExecute(Void result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
		if (orderDishActivity != null) {
			orderDishActivity.initOrder();
		} else if (paymentActivity != null) {
			paymentActivity.initPayment();
		}
	}

	public boolean getOrderById(long orderId) {
		SoapObject request = new SoapObject(GenericUtil.NAMESPACE, GenericUtil.ORDER_METHOD_GET);
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		envelope.setOutputSoapObject(request);
		request.addProperty(OrderConnect.orderAttr[0], orderId);

		HttpTransportSE ht = new HttpTransportSE(GenericUtil.ORDER_URL);

		try {
			ht.call(GenericUtil.NAMESPACE + "/" + GenericUtil.ORDER_METHOD_GET, envelope);
			SoapObject response = (SoapObject) envelope.getResponse();
			long orderIds;
			int isPayment;
			orderDAO.open();
			if (response != null) {
				orderIds = Long.valueOf(response.getProperty(OrderConnect.orderAttr[0]).toString());
				isPayment = Integer.valueOf(response.getProperty(OrderConnect.orderAttr[2]).toString());
				// isWaiting =
				// Boolean.valueOf(response.getProperty(OrderConnect.orderAttr[6]).toString());
				orderDAO.updateOrderStatus(orderIds, isPayment);
				if (isPayment == 3) {
					isStopping = true;
				}
			}
			orderDAO.close();
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XmlPullParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public List<OrderLineModel> getOrderLinesByOrderId(long orderId) {
		List<OrderLineModel> lineModels = new ArrayList<OrderLineModel>();
		SoapObject request = new SoapObject(GenericUtil.NAMESPACE, GenericUtil.ORDERLINE_METHOD_GET_BY_ORDER);
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		envelope.setOutputSoapObject(request);
		request.addProperty(OrderConnect.orderLineAttr[5], orderId);

		HttpTransportSE ht = new HttpTransportSE(GenericUtil.ORDERLINE_URL);

		try {
			ht.call(GenericUtil.NAMESPACE + "/" + GenericUtil.ORDERLINE_METHOD_GET_BY_ORDER, envelope);

			List<SoapObject> response = (List<SoapObject>) envelope.getResponse();
			if (response != null) {
				long orderLineId;
				int numOfFinishDish;
				int statusDish;
				OrderLineModel orderLineModel;
				orderLineDAO.open();

				for (SoapObject soapObject : response) {
					orderLineId = Long.valueOf(soapObject.getProperty(OrderConnect.orderLineAttr[0]).toString());
					numOfFinishDish = Integer.valueOf(soapObject.getProperty(OrderConnect.orderLineAttr[2]).toString());
					statusDish = Integer.valueOf(soapObject.getProperty(OrderConnect.orderLineAttr[3]).toString());
					orderLineModel = orderLineDAO.getOrderLineByIdNotDish(orderLineId);
					orderLineModel.setNumOfFinishDish(numOfFinishDish);
					orderLineModel.setStatus(statusDish);
					orderLineDAO.saveOrUpdateOrder(orderLineModel);
				}
				orderLineDAO.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XmlPullParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lineModels;
	}

}
