package com.irestads;

import java.util.List;

import com.irestads.model.AdsItemModel;
import com.irestads.util.ImageUtils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AdsBookItemAdapter extends BaseAdapter {
	private Context context;
	private List<AdsItemModel> adsItemModel;

	public AdsBookItemAdapter(Context context, List<AdsItemModel> adsItemModel) {
		super();
		this.context = context;
		this.adsItemModel = adsItemModel;
	}

	public Context getContext() {
		return context;
	}

	public void setContext(Context context) {
		this.context = context;
	}

	public List<AdsItemModel> getAdsItemModel() {
		return adsItemModel;
	}

	public void setAdsItemModel(List<AdsItemModel> adsItemModel) {
		this.adsItemModel = adsItemModel;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return adsItemModel.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		View gridView;
		if (convertView != null) {
			gridView = new View(context);
			gridView = inflater.inflate(R.layout.activity_ads_book_item, null);
			AdsItemModel currentItem = adsItemModel.get(position);

			TextView itemName = (TextView) gridView.findViewById(R.id.scr5_ads_book_item_name);
			ImageView itemAvatar = (ImageView) gridView.findViewById(R.id.scr5_ads_book_item_avatar);
			itemName.setText(currentItem.getProductName());
			itemAvatar.setImageBitmap(ImageUtils.resizeBitmap(ImageUtils.getImageFromByteArray(
					currentItem.getImageContent(), context.getResources(), R.drawable.cantfoundish), 200, 132));
		} else {
			gridView = new View(context);
		}
		return gridView;
	}

}
