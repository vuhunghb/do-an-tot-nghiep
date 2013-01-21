package com.irestads;

import java.util.ArrayList;
import java.util.List;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.Toast;

@TargetApi(11)
public class MenuDialog extends DialogFragment {

	int id = 0;
	int scr = 0;
	int selectedItem = 0;

	List<String> activities = new ArrayList<String>();

	// Define list activity to tranfer when click OK button

	static MenuDialog newInstance(String title, int type, int scr) {
		MenuDialog menuDialog = new MenuDialog();
		Bundle args = new Bundle();
		args.putString("title", title);
		args.putInt("type", type);
		args.putInt("scr", scr);
		menuDialog.setArguments(args);
		return menuDialog;
	}

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		String title = getArguments().getString("title");
		int type = getArguments().getInt("type");
		int scr = getArguments().getInt("scr"); // this attribute to get array
												// string list depend screen
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		final String[] items = getResources().getStringArray(scr);

		switch (type) {
		case R.string.menu_dialog_type_list:
			builder = this.createListDialogBuilder(builder, title, items);
			break;

		default:
			break;
		}

		return builder.create();
	}

	public AlertDialog.Builder createListDialogBuilder(
			AlertDialog.Builder builder, String title, final String[] items) {
		builder.setTitle(title)
				.setSingleChoiceItems(items, id,
						new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								// TODO Auto-generated method stub
								id = which;
							}
						})
				.setPositiveButton("OK", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						selectedItem = id;
						tranferActivity(selectedItem);
					}
				})
				.setNegativeButton("Cancel",
						new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								// TODO Auto-generated method stub

							}
						});
		builder.setIcon(R.drawable.menu_icon);
		return builder;
	}

	public AlertDialog.Builder createListImageDialogBuilder(
			AlertDialog.Builder builder, String title, final String[] items) {
		builder = new AlertDialog.Builder(getActivity());
		LayoutInflater inflater = getActivity().getLayoutInflater();
		builder.setView(inflater.inflate(R.layout.menu_dialog, null));

		return builder;
	}

	/***
	 * Move to other activity which name is defined in list activities;
	 * 
	 * @param selectedItem
	 */
	public void tranferActivity(int selectedItem) {
		startActivity(new Intent(activities.get(selectedItem)));
	}

	public int getScr() {
		return scr;
	}

	public void setScr(int scr) {
		this.scr = scr;
	}

	public int getSelectedItem() {
		return selectedItem;
	}

	public void setSelectedItem(int selectedItem) {
		this.selectedItem = selectedItem;
	}

	public List<String> getActivities() {
		return activities;
	}

	public void setActivities(List<String> activities) {
		this.activities = activities;
	}

}
