package com.irestads.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;

import android.os.Environment;

import com.irestads.model.SettingsModel;

public class StogeSettingsUtil {
	File sdFile = Environment.getExternalStorageDirectory();
	String folderName = "iRestAds";

	public void writeSettings(SettingsModel settings) {
		File diretory = new File(sdFile.getAbsoluteFile() + "/" + folderName);
		if (diretory.exists() != true || diretory.isDirectory() == false) {
			diretory.mkdirs();
		}
		try {
			File file = new File(diretory, "settings.obj");
			FileOutputStream fileOutputStream = new FileOutputStream(file,
					false);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(
					fileOutputStream);

			objectOutputStream.writeObject(settings);
			objectOutputStream.flush();
			objectOutputStream.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public SettingsModel readSettings() {
		SettingsModel settingsModel = new SettingsModel();
		File file = new File(sdFile.getAbsoluteFile() + "/" + folderName + "/"
				+ "settings.obj");
		if (file.exists() != true) {
			this.writeSettings(settingsModel);
		} else {
			try {
				FileInputStream fileInputStream = new FileInputStream(file);
				ObjectInputStream objectInputStream = new ObjectInputStream(
						fileInputStream);
				settingsModel = (SettingsModel) objectInputStream.readObject();
				objectInputStream.close();

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return settingsModel;
	}

}
