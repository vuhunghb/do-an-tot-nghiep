package com.irestads;

import java.util.List;

import com.irestads.dao.AdsItemDAO;
import com.irestads.dao.CategoryAdsDAO;
import com.irestads.model.AdsItemModel;
import com.irestads.model.CategoryAdsModel;

import android.annotation.SuppressLint;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

@SuppressLint("NewApi")
public class AdsBookListTopicFragment extends ListFragment {
	AdsBookActivity adsBookActivity;
	AdsItemDAO adsItemDAO;
	List<AdsItemModel> adsItemModels;
	String[] values;
	static int currentIndex = 0;

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		adsBookActivity = (AdsBookActivity) getActivity();

		adsItemDAO = new AdsItemDAO(adsBookActivity);
		adsItemDAO.open();
		long currentCategoryId = adsBookActivity.getCurrentCategoryId();
		adsItemModels = adsItemDAO.getAdsItemContextByCategory(currentCategoryId, false);
		adsItemDAO.close();

		values = new String[adsItemModels.size()];
		for (int i = 0; i < adsItemModels.size(); i++) {
			String name = adsItemModels.get(i).getProductName();
			values[i] = (name != null && name != "") ? name : "Not found";
		}
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,
				values);
		setListAdapter(adapter);
	}

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		currentIndex = position;
		adsBookActivity.updateSelectedAdsItem(adsItemModels.get(currentIndex));
		adsBookActivity.toggleListCategory(v);
	}
}
