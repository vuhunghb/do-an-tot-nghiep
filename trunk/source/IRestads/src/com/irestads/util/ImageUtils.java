package com.irestads.util;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import com.irestads.R;
import com.irestads.model.DishModel;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;

//import android.util.Base64;

public class ImageUtils {

	public static Bitmap LoadImage(String URL, BitmapFactory.Options options) {
		Bitmap bitmap = null;
		InputStream in = null;
		try {
			in = OpenHttpConnection(URL);
			bitmap = BitmapFactory.decodeStream(in, null, options);
			in.close();
		} catch (IOException e1) {
		}
		// byte[] data = this.convertBitmapToArrayBite(bitmap);
		// String stringData = this.encodeImage(data);
		// bitmap = getImageByString(stringData);
		return bitmap;
	}

	public static InputStream OpenHttpConnection(String strURL) throws IOException {
		InputStream inputStream = null;
		URL url = new URL(strURL);
		URLConnection conn = url.openConnection();

		try {
			HttpURLConnection httpConn = (HttpURLConnection) conn;
			httpConn.setRequestMethod("GET");
			httpConn.connect();

			if (httpConn.getResponseCode() == HttpURLConnection.HTTP_OK) {
				inputStream = new BufferedInputStream(httpConn.getInputStream());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return inputStream;
	}

	public static Bitmap getImageByString(String encode) {
		Bitmap bitmap = null;
		byte[] data = decodeImage(encode);
		bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);
		return bitmap;

	}

	/***
	 * get bitmap from encode avatar string
	 * 
	 * @param avatar
	 * @param res
	 * @param defautImage
	 * @return
	 */
	public static Bitmap getImageFromByteArray(byte[] avatar, Resources res, int defautImage) {
		Bitmap bm = null;
		if (avatar != null && avatar.length != 0) {
			bm = BitmapFactory.decodeByteArray(avatar, 0, avatar.length);
		} else {
			bm = BitmapFactory.decodeResource(res, defautImage);
		}
		return bm;
	}

	public static Bitmap resizeBitmap(Bitmap bm, int newWidth, int newHeight) {
		int width = bm.getWidth();
		int height = bm.getHeight();
		float scaleWidth = ((float) newWidth) / width;
		float scaleHeight = ((float) newHeight) / height;
		Matrix matrix = new Matrix();
		matrix.postScale(scaleWidth, scaleHeight);
		Bitmap resizedBitmap = Bitmap.createBitmap(bm, 0, 0, width, height, matrix, false);
		return resizedBitmap;
	}

	public static byte[] convertBitmapToArrayBite(Bitmap bmp) {
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		bmp.compress(Bitmap.CompressFormat.PNG, 100, stream);
		byte[] byteArray = stream.toByteArray();
		return byteArray;
	}

	// public static String encodeImage(byte[] imageByteArray) {
	// return Base64.encodeToString(imageByteArray, Base64.DEFAULT);
	// }
	//
	// public static byte[] decodeImage(String imageDataString) {
	// return Base64.decode(imageDataString, Base64.DEFAULT);
	// }
	// public static String encodeImage(byte[] imageByteArray) {
	// return Base64.encodeToString(imageByteArray, Base64.DEFAULT);
	// }
	//
	// public static byte[] decodeImage(String imageDataString) {
	// return
	// org.apache.commons.codec.binary.Base64.decodeBase64(imageDataString);
	// }

	/**
	 * Encodes the byte array into base64 string
	 * 
	 * @param imageByteArray
	 *            - byte array
	 * @return String a {@link java.lang.String}
	 */
	public static String encodeImage(byte[] imageByteArray) {
		return Base64.encodeBytes(imageByteArray);
	}

	/**
	 * Decodes the base64 string into byte array
	 * 
	 * @param imageDataString
	 *            - a {@link java.lang.String}
	 * @return byte array
	 */
	public static byte[] decodeImage(String imageDataString) {
		try {
			return Base64.decode(imageDataString);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
