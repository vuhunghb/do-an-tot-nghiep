Liferay.Service.register("Liferay.Service.DishStore", "irestads.service", "DishStore-portlet");

Liferay.Service.registerClass(
	Liferay.Service.DishStore, "Category",
	{
		createCategory: true,
		getAllCategorys: true,
		findByID: true
	}
);

Liferay.Service.registerClass(
	Liferay.Service.DishStore, "Dish",
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
		findDishsByCategoryName: true
	}
);