create table testws_TestEntity (
	entityId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	pass VARCHAR(75) null,
	email VARCHAR(75) null,
	loginDate DATE null
);