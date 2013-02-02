package com.irestads;

import com.irestads.util.GenericUtil;
import com.irestads.util.StogeSettingsUtil;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

@SuppressLint("NewApi")
public class SettingsConnectFragment extends Fragment {
	EditText serverAddress, connectAccount, connectPass;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub

		return inflater.inflate(R.layout.activity_setting_connect_fragment, container, false);
	}

	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		serverAddress = (EditText) getActivity().findViewById(R.id.settings_connect_serveraddress);

		connectAccount = (EditText) getActivity().findViewById(R.id.settings_connect_account);

		connectPass = (EditText) getActivity().findViewById(R.id.settings_connect_pass);

		Button btnStore = (Button) getActivity().findViewById(R.id.settings_connect_btn_store);
		Button btnCheck = (Button) getActivity().findViewById(R.id.settings_connect_btn_check);
		Button btnCancel = (Button) getActivity().findViewById(R.id.settings_connect_btn_cancel);

		btnStore.setOnClickListener(onClickSettingsButton);
		btnCheck.setOnClickListener(onClickSettingsButton);
		btnCancel.setOnClickListener(onClickSettingsButton);
		updateGUI();
	}

	private void updateGUI() {
		serverAddress.setText(GenericUtil.settingsModel.getServerAddress());
		connectAccount.setText(GenericUtil.settingsModel.getUserConnect());
		connectPass.setText(GenericUtil.settingsModel.getPassConnect());
	}

	private OnClickListener onClickSettingsButton = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			int id = v.getId();
			String serverAddressValue = serverAddress.getText().toString();
			String accountValue = connectAccount.getText().toString();
			String passValue = connectPass.getText().toString();
			String message = "";
			switch (id) {
			case R.id.settings_connect_btn_store:
				GenericUtil.settingsModel.setServerAddress(serverAddressValue);
				GenericUtil.settingsModel.setUserConnect(accountValue);
				GenericUtil.settingsModel.setPassConnect(passValue);
				GenericUtil.updateLink(GenericUtil.settingsModel);
				StogeSettingsUtil settingsUtil = new StogeSettingsUtil();
				settingsUtil.writeSettings(GenericUtil.settingsModel);
				message = getActivity().getResources().getString(R.string.settings_connect_storge_mesage);
				break;
			case R.id.settings_connect_btn_check:
				break;
			case R.id.settings_connect_btn_cancel:
				updateGUI();
				break;

			default:
				break;
			}
			Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
		}
	};
}
