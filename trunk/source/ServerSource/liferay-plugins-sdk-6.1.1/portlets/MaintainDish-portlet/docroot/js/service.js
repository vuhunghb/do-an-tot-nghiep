Liferay.Service.register("Liferay.Service.DishStore", "iRestads.service", "MaintainDish-portlet");

Liferay.Service.register("Liferay.Service.dishstore", "iRestads.service", "MaintainDish-portlet");

Liferay.Service.registerClass(
	Liferay.Service.dishstore, "Category",
	{
		createCategory: true,
		getAllCategorys: true
	}
);

Liferay.Service.registerClass(
	Liferay.Service.dishstore, "Dish",
	{
		createDish: true,
		getAllDishs: true
	}
);