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
	avatarBaseCode VARCHAR(75) null,
	detailImg VARCHAR(75) null,
	detailBaseCode VARCHAR(75) null,
	detail VARCHAR(75) null,
	referPrice INTEGER,
	numOfDiner INTEGER,
	categoryId LONG
);