package com.irestads;

import com.irestads.util.GenericUtil;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

@SuppressLint("NewApi")
public class PaymentActivity extends Activity {
	FragmentManager fragmentManager;

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_payment);

		GenericUtil.currentActivity = PaymentActivity.class.toString();
		
		ActionBar actionBar = getActionBar();
		actionBar.hide();
	}
}
