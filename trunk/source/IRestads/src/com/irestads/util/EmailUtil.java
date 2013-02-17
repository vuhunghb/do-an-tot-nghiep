package com.irestads.util;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

public class EmailUtil {

	public static void sendEmailsAds(Activity activity, String emailAddress, String carbonCopies, String subject,
			String message) {
		List<String> to = new ArrayList<String>();
		List<String> cc = new ArrayList<String>();
		StringTokenizer emailAddressToken = new StringTokenizer(emailAddress, ";");
		while (emailAddressToken.hasMoreTokens()) {
			to.add(emailAddressToken.nextToken());
		}
		StringTokenizer ccToken = new StringTokenizer(carbonCopies, ";");
		while (ccToken.hasMoreTokens()) {
			cc.add(ccToken.nextToken());
		}
		sendEmails(activity, to, cc, subject, message);
	}

	public static void sendEmails(Activity activity, List<String> emailAddress, List<String> carbonCopies,
			String subject, String message) {
		Intent emailIntent = new Intent(Intent.ACTION_SEND);
		emailIntent.setData(Uri.parse("mailto:"));
		String[] to = emailAddress.toArray(new String[emailAddress.size()]);
		String[] cc = carbonCopies.toArray(new String[carbonCopies.size()]);

		emailIntent.putExtra(Intent.EXTRA_EMAIL, to);
		emailIntent.putExtra(Intent.EXTRA_CC, cc);
		emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
		emailIntent.putExtra(Intent.EXTRA_TEXT, message);
		emailIntent.setType("message/rfc822");
		activity.startActivity(Intent.createChooser(emailIntent, "Email"));
	}
}
