package com.irestads.model;

import java.util.Date;

public class VersionModel {
	long versionId;
	String logObjName;
	long logObjId;
	String logType;
	Date logDate;
	
	public VersionModel() {
		super();
	}
	public VersionModel(long versionId, String logObjName, long logObjId, String logType, Date logDate) {
		super();
		this.versionId = versionId;
		this.logObjName = logObjName;
		this.logObjId = logObjId;
		this.logType = logType;
		this.logDate = logDate;
	}
	public long getVersionId() {
		return versionId;
	}
	public void setVersionId(long versionId) {
		this.versionId = versionId;
	}
	public String getLogObjName() {
		return logObjName;
	}
	public void setLogObjName(String logObjName) {
		this.logObjName = logObjName;
	}
	public long getLogObjId() {
		return logObjId;
	}
	public void setLogObjId(long logObjId) {
		this.logObjId = logObjId;
	}
	public String getLogType() {
		return logType;
	}
	public void setLogType(String logType) {
		this.logType = logType;
	}
	public Date getLogDate() {
		return logDate;
	}
	public void setLogDate(Date logDate) {
		this.logDate = logDate;
	}
	
}
