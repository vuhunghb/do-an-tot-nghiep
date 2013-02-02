create table dishsstore_Category (
	categoryId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	categoryName VARCHAR(75) null
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
	detailBaseCode VARCHAR(75) null,
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
	numChair INTEGER
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
	statusDish INTEGER,
	dishId LONG,
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
	isPayMent BOOLEAN,
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