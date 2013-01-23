create index IX_D4F254B8 on dishsstore_Category (categoryName);

create index IX_2C0E80F0 on dishsstore_Dish (dishName);
create index IX_774A3314 on dishsstore_Dish (referPrice);

create index IX_53E2693A on dishsstore_Menu (menuName);

create index IX_E60E55D9 on dishsstore_MenuLine (dishId);
create index IX_4F1AFFD7 on dishsstore_MenuLine (numOfDish);
create index IX_67B91469 on dishsstore_MenuLine (price);
create index IX_242A9A36 on dishsstore_MenuLine (status);

create index IX_888F73C2 on dishsstore_UVersion (logDate);