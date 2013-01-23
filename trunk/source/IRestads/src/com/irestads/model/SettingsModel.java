package com.irestads.model;

import java.io.Serializable;
import java.util.Date;

public class SettingsModel implements Serializable {
	int currentVersion, maxVersion;
	Date autoUpdateTime;
	String serverAddress;
	String userConnect;
	String passConnect;

	public SettingsModel() {
		super();
		this.currentVersion = 0 ;
		this.maxVersion = 0;
		this.autoUpdateTime = new Date();
		this.serverAddress = "localhost";
		this.userConnect = "test";
		this.passConnect = "test";
	}

	public SettingsModel(int currentVersion, Date autoUpdateTime,
			String serverAddress, String userConnect, String passConnect, int maxVersion) {
		super();
		this.currentVersion = currentVersion;
		this.autoUpdateTime = autoUpdateTime;
		this.serverAddress = serverAddress;
		this.userConnect = userConnect;
		this.passConnect = passConnect;
		this.maxVersion = maxVersion;
	}
	

	public int getCurrentVersion() {
		return currentVersion;
	}

	public void setCurrentVersion(int currentVersion) {
		this.currentVersion = currentVersion;
	}

	public Date getAutoUpdateTime() {
		return autoUpdateTime;
	}

	public void setAutoUpdateTime(Date autoUpdateTime) {
		this.autoUpdateTime = autoUpdateTime;
	}

	public String getServerAddress() {
		return serverAddress;
	}

	public void setServerAddress(String serverAddress) {
		this.serverAddress = serverAddress;
	}

	public String getUserConnect() {
		return userConnect;
	}

	public void setUserConnect(String userConnect) {
		this.userConnect = userConnect;
	}

	public String getPassConnect() {
		return passConnect;
	}
	

	public int getMaxVersion() {
		return maxVersion;
	}

	public void setMaxVersion(int maxVersion) {
		this.maxVersion = maxVersion;
	}

	public void setPassConnect(String passConnect) {
		this.passConnect = passConnect;
	}

}
