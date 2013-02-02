package com.irestads;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.irestads.client.VersionConnect;
import com.irestads.util.GenericUtil;
import com.irestads.util.StogeSettingsUtil;
import com.irestads.util.UpdateTimerTask;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

@SuppressLint("NewApi")
public class SettingsUpdateFragment extends Fragment {
	TimePicker timePicker;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View v = inflater.inflate(R.layout.activity_setting_update_fragment,
				container, false);
		return v;
	}

	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		super.onStart();

		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
				.permitAll().build();
		StrictMode.setThreadPolicy(policy);
		
		TextView currentVersionText = (TextView) getActivity().findViewById(
				R.id.settings_update_current_version);
		currentVersionText.setText("# "
				+ GenericUtil.settingsModel.getCurrentVersion());

		updateAutoTimeDisplay();

		Button btnAutoUpdate = (Button) getActivity().findViewById(
				R.id.settings_update_auto_save);
		btnAutoUpdate.setOnClickListener(onClickSettingAutoUpdate);

		Button btnAutoUpdateCancel = (Button) getActivity().findViewById(
				R.id.settings_update_auto_cancel);
		btnAutoUpdateCancel.setOnClickListener(onClickSettingAutoUpdate);

		Button btnManualUpdate = (Button) getActivity().findViewById(
				R.id.settings_update_manual_save);
		btnManualUpdate.setOnClickListener(onClickManuaUpdate);

	}

	public void updateAutoTimeDisplay() {
		timePicker = (TimePicker) getActivity().findViewById(
				R.id.settings_update_time);
		timePicker.setIs24HourView(true);

		Calendar calendar = new GregorianCalendar();
		calendar.setTime(GenericUtil.settingsModel.getAutoUpdateTime());
		timePicker.setCurrentHour(calendar.get(Calendar.HOUR_OF_DAY));
		timePicker.setCurrentMinute(calendar.get(Calendar.MINUTE));
	}

	public OnClickListener onClickSettingAutoUpdate = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Button button = (Button) v;
			int id = button.getId();
			String message = "";
			switch (id) {
			case R.id.settings_update_auto_save:
				
				GenericUtil.settingsModel.setAutoUpdateTime(new Date());
				GenericUtil.settingsModel.getAutoUpdateTime().setHours(
						timePicker.getCurrentHour());
				GenericUtil.settingsModel.getAutoUpdateTime().setMinutes(
						timePicker.getCurrentMinute());
				// MainActivity.settingsModel.setMaxVersion(0);
				StogeSettingsUtil settingsUtil = new StogeSettingsUtil();
				settingsUtil.writeSettings(GenericUtil.settingsModel);
				
				GenericUtil.runUpdateTimer(getActivity());
				
				message = getResources().getString(
						R.string.settings_update_auto_message_ok);
				break;
			case R.id.settings_update_auto_cancel:

				message = getResources().getString(
						R.string.settings_update_auto_message_cancel);
				break;

			default:
				break;
			}
			updateAutoTimeDisplay();
			Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
		}
	};

	public OnClickListener onClickManuaUpdate = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			new AlertDialog.Builder(getActivity())
					.setTitle(
							getResources()
									.getString(
											R.string.settings_update_manual_confim_title))
					.setMessage(
							getResources()
									.getString(
											R.string.settings_update_manual_confim_message))
					.setIcon(android.R.drawable.ic_dialog_alert)
					.setPositiveButton(
							getResources().getString(
									R.string.scr2_comfirm_accept_ok),
							new DialogInterface.OnClickListener() {

								public void onClick(DialogInterface dialog,
										int whichButton) {
									VersionConnect connect = new VersionConnect(getActivity());
									connect.execute();
								}
							})
					.setNegativeButton(
							getResources().getString(
									R.string.scr2_comfirm_accept_cancel), null)
					.show();
		}
	};

}
