Liferay.Service.register("Liferay.Service.dishsstore", "irestads.service", "DishsStore-portlet");

Liferay.Service.registerClass(
	Liferay.Service.dishsstore, "AdsItem",
	{
		createAdsItem: true,
		updateAdsItem: true,
		deleteAdsItem: true,
		findById: true,
		getAllAdsItems: true,
		findAdsByCompName: true,
		findAdsByTags: true,
		findAdsByProductName: true,
		findAdsByItemType: true,
		findAdsByCategoryName: true,
		findAdsByTimeDuration: true
	}
);

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
	Liferay.Service.dishsstore, "CategoryAds",
	{
		getAddCategoryAds: true,
		findById: true
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
		findDishsBySomeField: true,
		isDeleteDish: true
	}
);

Liferay.Service.registerClass(
	Liferay.Service.dishsstore, "DishTable",
	{
		getAllDishTables: true,
		updateDishTable: true
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
		createOrderLine: true,
		deleteOrderLineById: true,
		getOrderLineByOrder: true,
		updateOrderLine: true,
		synchStatusOrderLine: true,
		getCharge: true
	}
);

Liferay.Service.registerClass(
	Liferay.Service.dishsstore, "Orders",
	{
		findOrderById: true,
		createOrders: true,
		deleteOrderById: true,
		setWaitingStatus: true,
		updateOrder: true,
		payment: true,
		calCharge: true
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