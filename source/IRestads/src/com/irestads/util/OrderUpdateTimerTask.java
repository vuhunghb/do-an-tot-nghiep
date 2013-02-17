package com.irestads.util;

import java.util.TimerTask;

import com.irestads.MainActivity;
import com.irestads.client.OrderUpdateConnect;
import com.irestads.client.VersionConnect;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.util.Log;

public class OrderUpdateTimerTask extends TimerTask {
	OrderUpdateConnect orderUpdateConnect;
	Activity activity;
	Handler handler;
	long orderId;

	public OrderUpdateTimerTask(Activity activity, Handler handler, long orderId) {
		super();

		this.activity = activity;
		this.handler = handler;
		this.orderId = orderId;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		handler.post(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Log.w("TIMER TASK", "This Task is fire ");
				orderUpdateConnect = new OrderUpdateConnect();
				orderUpdateConnect.execute(activity, orderId);
			}
		});
	}

}
