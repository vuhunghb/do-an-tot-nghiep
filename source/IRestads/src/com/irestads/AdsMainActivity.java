package com.irestads;

import java.util.ArrayList;
import java.util.List;

import com.irestads.dao.AdsItemDAO;
import com.irestads.model.AdsItemContextModel;
import com.irestads.model.AdsItemModel;
import com.irestads.model.AdsItemNormalModel;
import com.irestads.util.GenericUtil;
import com.irestads.util.ImageUtils;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.view.View.OnClickListener;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.ViewSwitcher.ViewFactory;
import android.widget.ViewFlipper;

@SuppressLint("NewApi")
public class AdsMainActivity extends Activity implements ViewFactory {

	AdsItemDAO adsItemDAO;
	List<AdsItemModel> adsItemModels = new ArrayList<AdsItemModel>();
	AdsItemModel currentItem;
	TextView companyName, numPhone, email, address, productInf;
	ViewFlipper viewFlipper;

	AdsContactCompanyDialog adsContactCompanyDialog;

	ImageSwitcher itemSwitcher;
	static int currentItemIndex = 0;
	Handler switcherHandler = new Handler();

	LinearLayout itemInfo;
	LinearLayout itemContext;
	int resizeWidth = 150;
	int resizeHeight = 100;
	boolean isViewInf = false;

	Drawable drawable;
	private FragmentManager fragmentManager;
	AdsMainContextFragment contextFragment;

	boolean onRunning = true;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_ads_main);
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		StrictMode.setThreadPolicy(policy);
		GenericUtil.currentActivity = AdsMainActivity.class.toString();
		ActionBar actionBar = getActionBar();
		actionBar.hide();

		Window window = getWindow();
		window.addFlags(WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON
				+ WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED + WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON
				+ WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD);
		adsItemDAO = new AdsItemDAO(this);

		/*--------TEST BITMAP------------*/
		adsItemDAO.open();
		adsItemModels = adsItemDAO.getAllAdsItem();
		adsItemDAO.close();
		adsContactCompanyDialog = new AdsContactCompanyDialog(adsItemModels.get(currentItemIndex));
		/*--------TEST BITMAP------------*/

		itemSwitcher = (ImageSwitcher) findViewById(R.id.scr4_imageSwitcher);
		Animation fadeIn = AnimationUtils.loadAnimation(this, android.R.anim.fade_in);
		Animation fadeOut = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);
		itemSwitcher.setInAnimation(fadeIn);
		itemSwitcher.setOutAnimation(fadeOut);
		itemSwitcher.setFactory(this);
		switcherHandler.post(updateSwitcherTimeTask);

		itemInfo = (LinearLayout) findViewById(R.id.scr4_main_infads);
		companyName = (TextView) findViewById(R.id.scr4_ads_main_company_name);
		numPhone = (TextView) findViewById(R.id.scr4_ads_main_contact_phonenumber);
		email = (TextView) findViewById(R.id.scr4_ads_main_contact_email);
		address = (TextView) findViewById(R.id.scr4_ads_main_contact_address);
		productInf = (TextView) findViewById(R.id.scr4_ads_main_product_inf);

		fragmentManager = getFragmentManager();

	}

	@Override
	public View makeView() {
		// TODO Auto-generated method stub
		ImageView i = new ImageView(this);
		i.setLayoutParams(new ImageSwitcher.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
		i.setScaleType(ScaleType.FIT_XY);
		i.setOnClickListener(onClickItemAds);
		return i;
	}

	private Runnable updateSwitcherTimeTask = new Runnable() {

		@SuppressWarnings("deprecation")
		@Override
		public void run() {
			// TODO Auto-generated method stub
			AdsItemModel adsItemModel = adsItemModels.get(currentItemIndex);
			drawable = new BitmapDrawable(ImageUtils.getImageFromByteArray(adsItemModel.getImageContent(),
					getResources(), R.drawable.cantfoundish));
			if (drawable == null) {
				currentItemIndex = 0;
				drawable = new BitmapDrawable(ImageUtils.getImageFromByteArray(adsItemModel.getImageContent(),
						getResources(), R.drawable.cantfoundish));
			}
			itemSwitcher.setImageDrawable(drawable);

			currentItem = adsItemModel;

			if (currentItem.getItemType().equals(AdsItemContextModel.class.toString())) {
				FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
				contextFragment = new AdsMainContextFragment(currentItem);
				fragmentTransaction.replace(R.id.scr4_context_fragment, contextFragment);
				fragmentTransaction.commitAllowingStateLoss();
			} else {
				if (contextFragment != null) {
					FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
					fragmentTransaction.remove(contextFragment);
					fragmentTransaction.commitAllowingStateLoss();
				}
				updateProductInf(adsItemModel);
				adsContactCompanyDialog.setAdsItemModel(adsItemModel);
			}

			currentItemIndex++;
			if (currentItemIndex > (adsItemModels.size() - 1)) {
				currentItemIndex = 0;
			}
			switcherHandler.postDelayed(this, (adsItemModel.getTimeDuring() * 1000));
		}
	};

	public void updateProductInf(AdsItemModel adsItemModel) {
		companyName.setText(adsItemModel.getCompanyName());
		numPhone.setText(adsItemModel.getNumberPhone());
		email.setText(adsItemModel.getEmail());
		address.setText(adsItemModel.getAddress());
		productInf.setText(adsItemModel.getDescription());
	}

	private OnClickListener onClickItemAds = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub

			if (isViewInf == false) {
				if (currentItem.getItemType().equals(AdsItemNormalModel.class.toString()))
					itemInfo.setVisibility(View.VISIBLE);
				switcherHandler.removeCallbacks(updateSwitcherTimeTask);
			} else {
				if (currentItem.getItemType().equals(AdsItemNormalModel.class.toString()))
					itemInfo.setVisibility(View.INVISIBLE);
				switcherHandler.post(updateSwitcherTimeTask);
			}
			isViewInf = !isViewInf;
		}
	};

	protected void onResume() {
		super.onResume();

	};

	protected void onStop() {
		super.onStop();
		if (switcherHandler != null) {
			System.out.println("On Stop AdsMainActivity");
			switcherHandler.removeCallbacks(updateSwitcherTimeTask);
		}
	};

	public void onClickAdsOrder(View v) {
		adsContactCompanyDialog.show(getFragmentManager(), "dialog");
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		outState.putString("WORKAROUND_FOR_BUG_19917_KEY", "WORKAROUND_FOR_BUG_19917_VALUE");
		super.onSaveInstanceState(outState);
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
		MenuItem mnu5 = menu.add(0, 4, 4, function[3]);
		{
			mnu5.setAlphabeticShortcut('e');
			mnu5.setIcon(R.drawable.ic_launcher);

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
		case 4:
			startActivity(new Intent("android.intent.action.AdsBookActivity"));
			return true;

		default:
			return false;
		}
	}

}
