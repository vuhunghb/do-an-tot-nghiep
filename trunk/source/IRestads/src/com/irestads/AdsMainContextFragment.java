package com.irestads;

import com.irestads.dao.AdsItemDAO;
import com.irestads.model.AdsItemContextModel;
import com.irestads.model.AdsItemModel;
import com.irestads.util.ImageUtils;
import com.irestads.util.MyAnimationUtils;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

@SuppressLint("NewApi")
public class AdsMainContextFragment extends Fragment {
	AdsItemContextModel adsItemContextModel;
	AdsItemModel selectedAsdItem;
	LinearLayout adsListItems;
	RelativeLayout adsItemInf;
	LinearLayout mainContext;
	ImageView currentProductImage;
	int selectedIndex = 0;
	private AdsBookContactCompanyDialog adsContactCompanyDialog;
	AdsItemDAO adsItemDAO;

	public AdsMainContextFragment() {
		super();
	}

	public AdsItemContextModel getAdsItemContextModel() {
		return adsItemContextModel;
	}

	public void setAdsItemContextModel(AdsItemContextModel adsItemContextModel) {
		this.adsItemContextModel = adsItemContextModel;
	}

	public AdsMainContextFragment(AdsItemModel adsItemContextModel) {
		super();
		this.adsItemContextModel = (AdsItemContextModel) adsItemContextModel;

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return inflater.inflate(R.layout.activity_ads_main_context_fragment, container, false);
	}

	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		adsContactCompanyDialog = new AdsBookContactCompanyDialog();
		adsListItems = (LinearLayout) getActivity().findViewById(R.id.scr4_ads_main_context_list_tags);
		adsItemInf = (RelativeLayout) getActivity().findViewById(R.id.scr4_ads_main_context_inf);
		currentProductImage = (ImageView) getActivity().findViewById(R.id.scr4_ads_main_context_img);
		mainContext = (LinearLayout) getActivity().findViewById(R.id.scr4_main_context);
		ImageView hideButton = (ImageView) getActivity().findViewById(R.id.scr4_hide_btn);
		hideButton.setOnClickListener(onClickHideInf);
		ImageView orderButton = (ImageView) getActivity().findViewById(R.id.scr4_ads_context_order_btn);
		orderButton.setOnClickListener(onClickOrder);
		/*-------TEST DATA : it will access DB------------*/
		adsItemDAO = new AdsItemDAO(getActivity());
		adsItemDAO.open();
		adsItemContextModel.setAdsItemTags(adsItemDAO.getAdsItemByTags(adsItemContextModel.getAdsItemId(),
				adsItemContextModel.getTags()));
		adsItemDAO.close();
		/*-------TEST DATA------------*/
		updateViewListTags();
	}

	public void updateViewListTags() {
		adsListItems.removeAllViews();
		if (adsItemContextModel.getAdsItemTags().size() > 0) {
			mainContext.setVisibility(View.VISIBLE);
			ImageView itemView;
			LinearLayout.LayoutParams itemLayout = new LinearLayout.LayoutParams(145, 100);
			itemLayout.setMargins(0, 0, 0, 5);
			for (int i = adsItemContextModel.getAdsItemTags().size() - 1; i >= 0; i--) {
				AdsItemModel model = adsItemContextModel.getAdsItemTags().get(i);
				itemView = new ImageView(getActivity());
				itemView.setBackgroundColor(Color.WHITE);
				itemView.setLayoutParams(itemLayout);
				itemView.setImageBitmap(ImageUtils.resizeBitmap(ImageUtils.getImageFromByteArray(
						model.getImageContent(), getActivity().getResources(), R.drawable.cantfoundish), 145, 100));
				itemView.setId(i);
				itemView.setClickable(true);
				itemView.setOnClickListener(onClickItemTag);
				adsListItems.addView(itemView);
			}

		} else {
			mainContext.setVisibility(View.INVISIBLE);
		}
	}

	public OnClickListener onClickItemTag = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub

			ImageView imageView = (ImageView) v;
			int index = imageView.getId();
			selectedAsdItem = adsItemContextModel.getAdsItemTags().get(index);
			adsItemInf.setVisibility(View.VISIBLE);
			adsItemInf.setAnimation(MyAnimationUtils.inFromRightAnimation(500));
			currentProductImage.setImageBitmap(ImageUtils.getImageFromByteArray(selectedAsdItem.getImageContent(),
					getActivity().getResources(), R.drawable.cantfoundish));
		}
	};

	public OnClickListener onClickHideInf = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			adsItemInf.setAnimation(MyAnimationUtils.outToLeftAnimation(500));
			adsItemInf.setVisibility(View.INVISIBLE);

		}
	};

	public OnClickListener onClickOrder = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			adsContactCompanyDialog.setAdsItemModel(selectedAsdItem);
			adsContactCompanyDialog.show(getFragmentManager(), "dialog");
		}
	};
}
