package com.irestads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class LockScreenReceiver extends BroadcastReceiver {
	public static boolean isScreenOn = true;

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		if (intent.getAction().equals(Intent.ACTION_SCREEN_OFF)) {
			Intent startActivity = new Intent();
			startActivity.setClass(context, AdsMainActivity.class);
			startActivity.setAction(AdsMainActivity.class.getName());
			startActivity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
			context.startActivity(startActivity);
		} else if (intent.getAction().equals(Intent.ACTION_SCREEN_ON)) {

		}

	}

}
