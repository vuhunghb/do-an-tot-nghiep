package com.irestads;

import com.irestads.util.GenericUtil;
import com.irestads.util.StogeSettingsUtil;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

@SuppressLint("NewApi")
public class SettingsTableInfFragment extends Fragment {
	EditText tableName;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return inflater.inflate(R.layout.activity_setting_tableinf_fragment, container, false);
	}

	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		tableName = (EditText) getActivity().findViewById(R.id.settings_tableinf_name);
		tableName.setText(GenericUtil.settingsModel.getTableName());
		Button storeButton = (Button) getActivity().findViewById(R.id.settings_tableinf_btn_store);
		storeButton.setOnClickListener(onClickSettingsButton);
	}

	private OnClickListener onClickSettingsButton = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			int id = v.getId();

			switch (id) {
			case R.id.settings_tableinf_btn_store:
				new AlertDialog.Builder(getActivity())
						.setTitle(getResources().getString(R.string.settings_tableinf_message_title))
						.setMessage(getResources().getString(R.string.settings_tableinf_message))
						.setIcon(android.R.drawable.ic_dialog_alert)
						.setPositiveButton(getResources().getString(R.string.btn_stoge_label),
								new DialogInterface.OnClickListener() {
									public void onClick(DialogInterface dialog, int whichButton) {
										GenericUtil.settingsModel.setTableName(tableName.getText().toString());
										StogeSettingsUtil settingsUtil = new StogeSettingsUtil();
										settingsUtil.writeSettings(GenericUtil.settingsModel);
										Toast.makeText(
												getActivity(),
												getActivity().getResources().getString(
														R.string.settings_tableinf_message_stored), Toast.LENGTH_SHORT)
												.show();
									}
								})
						.setNegativeButton(getResources().getString(R.string.scr2_comfirm_accept_cancel), null).show();
				break;

			case R.id.settings_resetdata_btn_cancel:

				break;

			default:
				break;
			}
		}
	};

}
