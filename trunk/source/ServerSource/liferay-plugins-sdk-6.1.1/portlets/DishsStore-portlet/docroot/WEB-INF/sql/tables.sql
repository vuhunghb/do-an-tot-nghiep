create table dishsstore_AdsItem (
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
	description TEXT null,
	imageContent TEXT null,
	timeDuring INTEGER,
	tags VARCHAR(75) null,
	itemType VARCHAR(75) null,
	categoryAdsId LONG
);

create table dishsstore_Category (
	categoryId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	categoryName VARCHAR(75) null
);

create table dishsstore_CategoryAds (
	categoryAdsId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	categoryAdsName VARCHAR(75) null
);

create table dishsstore_Dish (
	dishId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	dishName VARCHAR(75) null,
	decription VARCHAR(75) null,
	avatarImg VARCHAR(75) null,
	avatarBaseCode TEXT null,
	detailImg VARCHAR(75) null,
	detailBaseCode TEXT null,
	detail VARCHAR(75) null,
	referPrice INTEGER,
	numOfDiner INTEGER,
	categoryId LONG
);

create table dishsstore_DishTable (
	dishTableId VARCHAR(75) not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	tableName VARCHAR(75) null,
	isAvalable BOOLEAN,
	numChair INTEGER,
	currentOrderId LONG
);

create table dishsstore_Menu (
	menuId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	menuName VARCHAR(75) null
);

create table dishsstore_MenuLine (
	menuLineId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	numOfDish INTEGER,
	capacity INTEGER,
	status BOOLEAN,
	dishId LONG
);

create table dishsstore_OrderLine (
	orderLineId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	numOfDish INTEGER,
	numOfFinishDish INTEGER,
	statusDish INTEGER,
	dishId LONG,
	orderDate DATE null,
	orderId LONG
);

create table dishsstore_Orders (
	orderId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	charge INTEGER,
	createdDate DATE null,
	isPayMent INTEGER,
	numOfDinner INTEGER,
	dishTableId VARCHAR(75) null
);

create table dishsstore_UVersion (
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