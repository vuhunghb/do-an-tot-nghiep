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
public class AdsBookListCategoriesFragment extends ListFragment {
	AdsBookActivity adsBookActivity;
	AdsItemDAO adsItemDAO;
	CategoryAdsDAO categoryAdsDAO;
	List<CategoryAdsModel> categoryAdsModels;
	String[] values;
	static int currentIndex = 0;
	TextView titleCategory;

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		adsBookActivity = (AdsBookActivity) getActivity();
		categoryAdsDAO = new CategoryAdsDAO(adsBookActivity);
		categoryAdsDAO.open();
		categoryAdsModels = categoryAdsDAO.getAllCategory();
		categoryAdsDAO.close();
		values = new String[categoryAdsModels.size()];
		for (int i = 0; i < categoryAdsModels.size(); i++) {
			values[i] = categoryAdsModels.get(i).getCategoryAdsName();
		}
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,
				values);
		setListAdapter(adapter);

		adsItemDAO = new AdsItemDAO(adsBookActivity);
		titleCategory = (TextView) adsBookActivity.findViewById(R.id.scr5_ads_book_category_title);
		titleCategory.setText(values[currentIndex]);
		adsBookActivity.updateDataByCategory(categoryAdsModels.get(currentIndex).getCategoryAdsId());
	}

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		currentIndex = position;

		titleCategory.setText(values[currentIndex]);
		adsBookActivity.updateDataByCategory(categoryAdsModels.get(currentIndex).getCategoryAdsId());
		adsBookActivity.toggleListCategory(v);
	}
}
