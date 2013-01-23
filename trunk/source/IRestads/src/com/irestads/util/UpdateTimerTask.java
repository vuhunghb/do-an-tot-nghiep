package com.irestads.util;

import java.util.TimerTask;

import android.util.Log;

public class UpdateTimerTask extends TimerTask {
	boolean isDoTask = true;
	int i = 0;

	@Override
	public void run() {
		// TODO Auto-generated method stub
			Log.w("TIMER TASK", "This Task is fire ");
	}

	public boolean isDoTask() {
		return isDoTask;
	}

	public void setDoTask(boolean isDoTask) {
		this.isDoTask = isDoTask;
	}

}
