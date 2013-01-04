Liferay.Service.register("Liferay.Service.testprimeface", "irestads.service", "TestPrimeFacev2-portlet");

Liferay.Service.registerClass(
	Liferay.Service.testprimeface, "Lop",
	{
		getAllLop: true
	}
);

Liferay.Service.registerClass(
	Liferay.Service.testprimeface, "SinhVien",
	{
		getSinhVienByLop: true,
		getAllSinhVien: true,
		updateSinhVien: true,
		deleteSinhVien: true
	}
);