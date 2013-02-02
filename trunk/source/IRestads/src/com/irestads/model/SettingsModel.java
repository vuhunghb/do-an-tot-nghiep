package com.irestads.model;

import java.io.Serializable;
import java.util.Date;

public class SettingsModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1910535642840573764L;

	long currentVersion, maxVersion;
	Date autoUpdateTime;
	String serverAddress;
	String userConnect;
	String passConnect;
	String tableName;

	public SettingsModel() {
		super();
		this.currentVersion = 0;
		this.maxVersion = 0;
		this.autoUpdateTime = new Date();
		this.serverAddress = "127.0.0.1";
		this.userConnect = "test";
		this.passConnect = "test";
		tableName = "";
	}

	public SettingsModel(long currentVersion, Date autoUpdateTime, String serverAddress, String userConnect,
			String passConnect, long maxVersion, String tableName) {
		super();
		this.currentVersion = currentVersion;
		this.autoUpdateTime = autoUpdateTime;
		this.serverAddress = serverAddress;
		this.userConnect = userConnect;
		this.passConnect = passConnect;
		this.maxVersion = maxVersion;
		this.tableName = tableName;
	}

	public long getCurrentVersion() {
		return currentVersion;
	}

	public void setCurrentVersion(long currentVersion) {
		this.currentVersion = currentVersion;
	}

	public long getMaxVersion() {
		return maxVersion;
	}

	public void setMaxVersion(long maxVersion) {
		this.maxVersion = maxVersion;
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

	public void setPassConnect(String passConnect) {
		this.passConnect = passConnect;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

}
