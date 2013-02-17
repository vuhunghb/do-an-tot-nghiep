package com.irestads;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.irestads.dao.AdsItemDAO;
import com.irestads.model.AdsItemModel;
import com.irestads.util.GenericUtil;
import com.irestads.util.MyAnimationUtils;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

@SuppressLint("NewApi")
public class AdsBookActivity extends Activity {
	GridView gridItem;
	AdsItemDAO adsItemDAO;
	LinearLayout categoriesLayout;
	ImageView toggleListButon;
	boolean isShowListCategory = false;
	List<AdsItemModel> adsItemModels;

	AdsBookContactCompanyDialog adsBookContactCompanyDialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ads_book);

		GenericUtil.currentActivity = AdsBookActivity.class.toString();
		ActionBar actionBar = getActionBar();
		actionBar.hide();
		adsItemModels = new ArrayList<AdsItemModel>();

		adsItemDAO = new AdsItemDAO(this);
		gridItem = (GridView) findViewById(R.id.scr5_ads_book_griditem);
		gridItem.setOnItemClickListener(onCliclItemGrid);
		categoriesLayout = (LinearLayout) findViewById(R.id.scr5_ads_book_categories_layout);
		toggleListButon = (ImageView) findViewById(R.id.scr5_ads_book_toggle_list);

		adsBookContactCompanyDialog = new AdsBookContactCompanyDialog();
	}

	public void updateDataByCategory(long categoryId) {
		/*--------TEST DATA-----*/
		adsItemDAO.open();
		adsItemModels = adsItemDAO.getAdsItemByCategory(categoryId);
		adsItemDAO.close();
		/*--------TEST DATA-----*/
		this.updateGridITem(adsItemModels);
	}

	public void updateGridITem(List<AdsItemModel> adsItemModels) {
		gridItem.setAdapter(new AdsBookItemAdapter(this, adsItemModels));
	}

	public OnItemClickListener onCliclItemGrid = new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			// TODO Auto-generated method stub
			adsBookContactCompanyDialog.setAdsItemModel(adsItemModels.get(position));
			adsBookContactCompanyDialog.show(getFragmentManager(), "dialog");
		}
	};

	public void toggleListCategory(View view) {
		if (isShowListCategory == false) {
			categoriesLayout.setAnimation(MyAnimationUtils.inFromLeftAnimation());
			categoriesLayout.setVisibility(View.VISIBLE);
			toggleListButon.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.arrowleft));
		} else {
			categoriesLayout.setAnimation(MyAnimationUtils.outToLeftAnimation());
			categoriesLayout.setVisibility(View.INVISIBLE);
			toggleListButon.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.arrowright));
		}
		isShowListCategory = !isShowListCategory;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		// getMenuInflater().inflate(R.menu.activity_main, menu);
		super.onCreateOptionsMenu(menu);
		createMenu(menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		return menuChoice(item);
	}

	public void createMenu(Menu menu) {

		String[] function = getResources().getStringArray(R.array.menu_src1_item_title);
		MenuItem mnu1 = menu.add(0, 0, 0, getResources().getString(R.string.menu_item_listdish));
		{
			mnu1.setAlphabeticShortcut('a');
			mnu1.setIcon(R.drawable.ic_launcher);

		}
		MenuItem mnu2 = menu.add(0, 1, 1, function[0]);
		{
			mnu2.setAlphabeticShortcut('b');
			mnu2.setIcon(R.drawable.ic_launcher);

		}
		MenuItem mnu3 = menu.add(0, 2, 2, function[1]);
		{
			mnu3.setAlphabeticShortcut('c');
			mnu3.setIcon(R.drawable.ic_launcher);

		}
		MenuItem mnu4 = menu.add(0, 3, 3, function[2]);
		{
			mnu4.setAlphabeticShortcut('d');
			mnu4.setIcon(R.drawable.ic_launcher);

		}
	}

	public boolean menuChoice(MenuItem item) {

		switch (item.getItemId()) {
		case 0:
			startActivity(new Intent("android.intent.action.MainListActivity"));
			return true;
		case 1:
			startActivity(new Intent("android.intent.action.OrderDishActivity"));
			return true;
		case 2:
			Toast.makeText(this, "Choice 2", Toast.LENGTH_SHORT).show();
			return true;
		case 3:
			startActivity(new Intent("android.intent.action.PaymentActivity"));
			return true;
		default:
			return false;
		}
	}
}
