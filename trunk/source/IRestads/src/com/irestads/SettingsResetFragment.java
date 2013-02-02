package com.irestads;

import com.irestads.client.VersionConnect;
import com.irestads.dao.DishDAO;
import com.irestads.dao.MenuLineDAO;
import com.irestads.dao.OrderDAO;
import com.irestads.dao.OrderLineDAO;
import com.irestads.util.GenericUtil;
import com.irestads.util.StogeSettingsUtil;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

@SuppressLint("NewApi")
public class SettingsResetFragment extends Fragment {

	DishDAO dishDAO;
	MenuLineDAO menuLineDAO;
	OrderDAO orderDAO;
	OrderLineDAO orderLineDAO;
	long countDish;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		dishDAO = new DishDAO(getActivity());
		menuLineDAO = new MenuLineDAO(getActivity());
		orderDAO = new OrderDAO(getActivity());
		orderLineDAO = new OrderLineDAO(getActivity());
		return inflater.inflate(R.layout.activity_setting_resetdata_fragment, container, false);
	}

	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		updateGUI();

		Button btnDelete = (Button) getActivity().findViewById(R.id.settings_resetdata_btn_delete);
		Button btnCancel = (Button) getActivity().findViewById(R.id.settings_resetdata_btn_cancel);

		btnDelete.setOnClickListener(onClickSettingsButton);
		btnCancel.setOnClickListener(onClickSettingsButton);
	}

	public void updateGUI() {
		dishDAO.open();
		countDish = dishDAO.countDish();
		dishDAO.close();
		
		orderDAO.open();
		long countOrder = orderDAO.countOrder();
		orderDAO.close();
		
		orderLineDAO.open();
		long countOrderline = orderLineDAO.countOrderline();
		orderLineDAO.close();
		
		TextView version = (TextView) getActivity().findViewById(R.id.settings_resetdata_version);
		version.setText("# " + GenericUtil.settingsModel.getCurrentVersion());
		TextView numDishs = (TextView) getActivity().findViewById(R.id.settings_resetdata_numdish);
		numDishs.setText("# " + countDish);
		TextView numOrder = (TextView)getActivity().findViewById(R.id.settings_resetdata_numorder);
		numOrder.setText("# "+countOrder);
		TextView numOrderline = (TextView)getActivity().findViewById(R.id.settings_resetdata_numorderline);
		numOrderline.setText("# "+countOrderline);
	}

	private OnClickListener onClickSettingsButton = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			int id = v.getId();

			switch (id) {
			case R.id.settings_resetdata_btn_delete:
				new AlertDialog.Builder(getActivity())
						.setTitle(getResources().getString(R.string.settings_resetdata_message_title))
						.setMessage(getResources().getString(R.string.settings_resetdata_message))
						.setIcon(android.R.drawable.ic_dialog_alert)
						.setPositiveButton(getResources().getString(R.string.btn_delete),
								new DialogInterface.OnClickListener() {
									public void onClick(DialogInterface dialog, int whichButton) {
										doResetData();
										updateGUI();
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

		public void doResetData() {
			menuLineDAO.open();
			menuLineDAO.deleteAllMenuLine();
			menuLineDAO.close();
			dishDAO.open();
			dishDAO.deleteAllDish();
			dishDAO.close();
			orderDAO.open();
			orderDAO.deleteAllOrder();
			orderDAO.close();
			orderLineDAO.open();
			orderLineDAO.deleteAllOrderLine();
			orderLineDAO.close();
			
			GenericUtil.settingsModel.setCurrentVersion(0);
			StogeSettingsUtil settingsUtil = new StogeSettingsUtil();
			settingsUtil.writeSettings(GenericUtil.settingsModel);
		}
	};
}
