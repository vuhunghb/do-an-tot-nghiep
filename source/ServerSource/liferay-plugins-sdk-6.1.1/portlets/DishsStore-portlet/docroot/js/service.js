Liferay.Service.register("Liferay.Service.dishsstore", "irestads.service", "DishsStore-portlet");

Liferay.Service.registerClass(
	Liferay.Service.dishsstore, "Category",
	{
		createCategory: true,
		getAllCategorys: true,
		findByID: true
	}
);

Liferay.Service.registerClass(
	Liferay.Service.dishsstore, "Dish",
	{
		createDish: true,
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