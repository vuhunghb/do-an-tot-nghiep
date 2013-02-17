package com.irestads;

import com.irestads.model.AdsItemModel;
import com.irestads.util.EmailUtil;
import com.irestads.util.ImageUtils;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

@SuppressLint("NewApi")
public class AdsBookContactCompanyDialog extends DialogFragment {

	EditText name, email, phoneNumber, address;
	Button sendButton, cancelButton;
	AdsItemModel adsItemModel;

	public AdsBookContactCompanyDialog(AdsItemModel adsItemModel) {
		super();
		this.adsItemModel = adsItemModel;
	}

	public AdsBookContactCompanyDialog() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.activity_ads_book_order_dialog, container);
		getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);

		name = (EditText) view.findViewById(R.id.ads_order_name);
		email = (EditText) view.findViewById(R.id.ads_order_email);
		phoneNumber = (EditText) view.findViewById(R.id.ads_order_phonenum);
		address = (EditText) view.findViewById(R.id.ads_order_address);
		sendButton = (Button) view.findViewById(R.id.ads_order_sendcontact);
		sendButton.setOnClickListener(onClickSendContact);

		cancelButton = (Button) view.findViewById(R.id.ads_order_cancel);
		cancelButton.setOnClickListener(onClickCancel);

		ImageView productAvatar = (ImageView) view.findViewById(R.id.scr5_ads_book_dialog_img);
		productAvatar.setImageBitmap(ImageUtils.resizeBitmap(ImageUtils.getImageFromByteArray(
				adsItemModel.getImageContent(), view.getResources(), R.drawable.cantfoundish), 237, 174));

		TextView productName = (TextView) view.findViewById(R.id.scr5_ads_book_dialog_product_name);
		productName.setText(adsItemModel.getProductName());
		TextView companyName = (TextView) view.findViewById(R.id.scr5_ads_book_dialog_companyname);
		companyName.setText(adsItemModel.getCompanyName());

		TextView companyPhoneNum = (TextView) view.findViewById(R.id.scr5_ads_book_dialog_phonenum);
		companyPhoneNum.setText(adsItemModel.getNumberPhone());

		TextView companyEmail = (TextView) view.findViewById(R.id.scr5_ads_book_dialog_email);
		companyEmail.setText(adsItemModel.getEmail());

		TextView companyAdress = (TextView) view.findViewById(R.id.scr5_ads_book_dialog_adress);
		companyAdress.setText(adsItemModel.getAddress());
		
		return view;
	}

	private OnClickListener onClickSendContact = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			String nameValue = name.getText().toString();
			String emailValute = email.getText().toString();
			String phoneNumberValue = phoneNumber.getText().toString();
			String addressValue = address.getText().toString();
			String subject = getActivity().getResources().getString(R.string.ads_contact_subject) + " : "
					+ adsItemModel.getProductName();
			String message = adsItemModel.getProductName() + "\n" + nameValue + "\n" + emailValute + "\n"
					+ phoneNumberValue + "\n" + addressValue + "\n";
			try {
				EmailUtil.sendEmailsAds(getActivity(), adsItemModel.getEmail(), emailValute, subject, message);
				getDialog().dismiss();
			} catch (Exception e) {
				// TODO: handle exception
				Toast.makeText(getActivity(),
						getActivity().getResources().getString(R.string.ads_contact_report_faild), Toast.LENGTH_SHORT)
						.show();
			}

		}
	};

	public AdsItemModel getAdsItemModel() {
		return adsItemModel;
	}

	public void setAdsItemModel(AdsItemModel adsItemModel) {
		this.adsItemModel = adsItemModel;
	}

	private OnClickListener onClickCancel = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			getDialog().dismiss();
		}
	};
}
