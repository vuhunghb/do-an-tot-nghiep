create index IX_75F64558 on dishsstore_AdsItem (productName);
create index IX_666B2514 on dishsstore_AdsItem (timeDuring);

create index IX_D4F254B8 on dishsstore_Category (categoryName);

create index IX_BBDE8C2C on dishsstore_CategoryAds (categoryAdsName);

create index IX_2C0E80F0 on dishsstore_Dish (dishName);
create index IX_774A3314 on dishsstore_Dish (referPrice);

create index IX_D937525B on dishsstore_DishTable (isAvalable);

create index IX_53E2693A on dishsstore_Menu (menuName);

create index IX_E60E55D9 on dishsstore_MenuLine (dishId);
create index IX_4F1AFFD7 on dishsstore_MenuLine (numOfDish);
create index IX_67B91469 on dishsstore_MenuLine (price);
create index IX_242A9A36 on dishsstore_MenuLine (status);

create index IX_4BE80E8 on dishsstore_OrderLine (orderId);
create index IX_E3402AD1 on dishsstore_OrderLine (statusDish);

create index IX_1DF0278A on dishsstore_Orders (isPayMent);
create index IX_4307F3B5 on dishsstore_Orders (isPayMent, dishTableId);

create index IX_888F73C2 on dishsstore_UVersion (logDate);
create index IX_D05F9F02 on dishsstore_UVersion (logObjId);
create index IX_63E2BB4 on dishsstore_UVersion (logObjName, logObjId);