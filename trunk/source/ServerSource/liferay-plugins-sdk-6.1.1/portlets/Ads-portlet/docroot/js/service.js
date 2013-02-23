Liferay.Service.register("Liferay.Service.Ads", "irestads.service", "Ads-portlet");

Liferay.Service.registerClass(
	Liferay.Service.Ads, "AdsItem",
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
	Liferay.Service.Ads, "CategoryAds",
	{
		getAddCategoryAds: true,
		findById: true
	}
);