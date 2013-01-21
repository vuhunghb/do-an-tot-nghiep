package com.irestads;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

@SuppressLint("NewApi")
public class ConfirmDialog extends DialogFragment {
	String massage, okButtonName, cancelButtonName;
	boolean result = false;

	public ConfirmDialog(String massage, String okButtonName,
			String cancelButtonName) {
		super();
		this.massage = massage;
		this.okButtonName = okButtonName;
		this.cancelButtonName = cancelButtonName;
		
	}
	

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		builder.setMessage(massage)
				.setPositiveButton(okButtonName,
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								// FIRE ZE MISSILES!
								result = true;
							}
						})
				.setNegativeButton(cancelButtonName,
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								// User cancelled the dialog
								result = false;
							}
						});
		// Create the AlertDialog object and return it
		return builder.create();
	}
	

	public String getMassage() {
		return massage;
	}

	public void setMassage(String massage) {
		this.massage = massage;
	}

	public String getOkButtonName() {
		return okButtonName;
	}

	public void setOkButtonName(String okButtonName) {
		this.okButtonName = okButtonName;
	}

	public String getCancelButtonName() {
		return cancelButtonName;
	}

	public void setCancelButtonName(String cancelButtonName) {
		this.cancelButtonName = cancelButtonName;
	}

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

}
