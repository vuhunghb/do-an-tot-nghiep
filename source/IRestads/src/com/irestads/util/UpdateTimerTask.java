package com.irestads.util;

import java.util.TimerTask;

import com.irestads.MainActivity;
import com.irestads.client.VersionConnect;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.util.Log;

public class UpdateTimerTask extends TimerTask {
	public static boolean isDoTask = true;
	int i = 0;
	Activity activity;
	Handler handler;
	static VersionConnect versionConnect;

	public UpdateTimerTask(Activity activity, Handler handler) {
		super();

		this.activity = activity;
		this.handler = handler;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		if (isDoTask == true) {
			isDoTask = false;
			handler.post(new Runnable() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					Log.w("TIMER TASK", "This Task is fire ");
					versionConnect = new VersionConnect(activity);
					versionConnect.execute();
				}
			});
		}
	}

	public boolean isDoTask() {
		return isDoTask;
	}

	public void setDoTask(boolean isDoTask) {
		this.isDoTask = isDoTask;
	}

}
