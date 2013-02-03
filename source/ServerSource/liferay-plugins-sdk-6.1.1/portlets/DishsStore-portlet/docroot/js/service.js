Liferay.Service.register("Liferay.Service.dishsstore", "irestads.service", "DishsStore-portlet");

Liferay.Service.registerClass(
	Liferay.Service.dishsstore, "Category",
	{
		countCategoryById: true,
		createCategory: true,
		getAllCategorys: true,
		findByID: true
	}
);

Liferay.Service.registerClass(
	Liferay.Service.dishsstore, "Dish",
	{
		createDish: true,
		findDishNotInMenu: true,
		getAllDishs: true,
		getDishsByCategory: true,
		updateDish: true,
		deleteDish: true,
		findDishsById: true,
		findDishsByReferPrice: true,
		findDishsByName: true,
		findDishsByDecription: true,
		findDishsByAvatarImg: true,
		findDishsByDetailImg: true,
		findDishsByDetail: true,
		findDishsByCategoryName: true,
		findDishsBySomeField: true
	}
);

Liferay.Service.registerClass(
	Liferay.Service.dishsstore, "DishTable",
	{
		getAllDishTables: true
	}
);

Liferay.Service.registerClass(
	Liferay.Service.dishsstore, "MenuLine",
	{
		getAllMenuLine: true,
		createMenuLine: true,
		createMenuLineDish: true,
		updateMenuLine: true,
		deleteMenuLine: true,
		findMenuLineById: true,
		findMenuLinesByDReferPrice: true,
		setDishForMenuLine: true,
		findMenuLinesByDishId: true,
		findMenuLinesByDName: true,
		findMenuLinesByDDecription: true,
		findMenuLinesByDAvatarImg: true,
		findMenuLinesByDDetailImg: true,
		findMenuLinesByDDetail: true,
		findMenuLinesByDCategoryName: true,
		findMenuLinesByNumOfDish: true,
		findMenuLinesByStatus: true,
		parseBooleanToShow: true
	}
);

Liferay.Service.registerClass(
	Liferay.Service.dishsstore, "OrderLine",
	{
		createOrderLine: true
	}
);

Liferay.Service.registerClass(
	Liferay.Service.dishsstore, "Orders",
	{
		findCurrentOrder: true,
		createOrders: true
	}
);

Liferay.Service.registerClass(
	Liferay.Service.dishsstore, "UVersion",
	{
		createVersion: true,
		findNextVersions: true,
		checkDelete: true
	}
);