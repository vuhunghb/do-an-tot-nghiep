package com.irestads;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

@SuppressLint("NewApi")
public class SettingsActivity extends Activity {

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_setting);
		FragmentManager fragmentManager = getFragmentManager();
		FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
		
		SettingsUpdateFragment updateFragment = new SettingsUpdateFragment();
		fragmentTransaction.replace(R.id.settings_content, updateFragment);
		fragmentTransaction.commit();
		
	}
	
}
