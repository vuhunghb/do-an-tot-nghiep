Liferay.Service.register("Liferay.Service.testws", "irestads.service", "TestJsonService-portlet");

Liferay.Service.registerClass(
	Liferay.Service.testws, "TestEntity",
	{
		getHelloString: true,
		getHelloString2: true
	}
);