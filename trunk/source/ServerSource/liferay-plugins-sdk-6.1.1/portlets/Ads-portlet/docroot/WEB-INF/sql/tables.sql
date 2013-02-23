create table Ads_AdsItem (
	adsItemId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	companyName VARCHAR(75) null,
	productName VARCHAR(75) null,
	numberPhone VARCHAR(75) null,
	email VARCHAR(75) null,
	address VARCHAR(75) null,
	facebook VARCHAR(75) null,
	twitter VARCHAR(75) null,
	description VARCHAR(75) null,
	imageContent TEXT null,
	timeDuring INTEGER,
	tags VARCHAR(75) null,
	itemType VARCHAR(75) null,
	categoryAdsId LONG
);

create table Ads_CategoryAds (
	categoryAdsId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	categoryAdsName VARCHAR(75) null
);

create table Ads_UVersion (
	versionId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	logObjName VARCHAR(75) null,
	logObjId LONG,
	logType VARCHAR(75) null,
	logDate DATE null
);