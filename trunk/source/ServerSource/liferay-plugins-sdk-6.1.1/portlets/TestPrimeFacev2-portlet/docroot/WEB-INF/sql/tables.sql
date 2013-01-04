create table testprimeface_Category (
	categoryId LONG not null primary key,
	categoryName VARCHAR(75) null
);

create table testprimeface_Dish (
	dishId LONG not null primary key,
	dishName VARCHAR(75) null,
	decription VARCHAR(75) null,
	avatarImg VARCHAR(75) null,
	detailImg VARCHAR(75) null,
	detail VARCHAR(75) null,
	referPrice DOUBLE,
	categoryId LONG,
	editTable BOOLEAN
);

create table testprimeface_Lop (
	lopId LONG not null primary key,
	tenLop VARCHAR(75) null
);

create table testprimeface_SinhVien (
	sinhVienId LONG not null primary key,
	mssv VARCHAR(75) null,
	ten VARCHAR(75) null,
	diaChi VARCHAR(75) null,
	diem DOUBLE,
	lopId VARCHAR(75) null
);