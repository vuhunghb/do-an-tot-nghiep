package irestads.beans;

import irestads.model.SinhVien;
import irestads.service.SinhVienServiceUtil;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

public class SinhVienBeans {
	List<SinhVien> sinhViens;
	SinhVien sinhVienSelected;

	public SinhVien getSinhVienSelected() {
		return sinhVienSelected;
	}

	public void setSinhVienSelected(SinhVien sinhVienSelected) {
		System.out.println("SET SV " + sinhVienSelected.getMssv());
		this.sinhVienSelected = sinhVienSelected;
	}

	public List<SinhVien> getSinhViens() {

		return this.sinhViens;
	}

	public void setSinhViens(List<SinhVien> sinhViens) {
		this.sinhViens = sinhViens;
	}

	public SinhVienBeans() {
		super();
		this.sinhViens = new ArrayList<SinhVien>();
		 this.getSinhVienFromDB();
	}
	// must create a method to get SV from DB, because when edit and delete, list SV must update.
	public List<SinhVien> getSinhVienFromDB(){
		this.sinhViens = SinhVienServiceUtil.getAllSinhVien();
		return this.sinhViens;
	}

	public void onEdit(RowEditEvent event) {
		SinhVien sv = (SinhVien) event.getObject();
		sv = SinhVienServiceUtil.updateSinhVien(sv);
		String message = "Không thể thực hiện thay đổi thông tin sinh viên";
		if (sv != null) {
			message = "Đã thay đổi thông tin sinh viên thành công";
			this.getSinhVienFromDB();
		}
		FacesMessage msg = new FacesMessage(message, sv.getSinhVienId() + " : "
				+ sv.getMssv());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void deleteSinhVien(){
		SinhVien sv = SinhVienServiceUtil.deleteSinhVien(sinhVienSelected);
		String message = "Không thể thực hiện xóa sinh viên";
		if (sv != null) {
			message = "Đã xóa sinh viên thành công";
			this.getSinhVienFromDB();
		}
		FacesMessage msg = new FacesMessage(message, sv.getSinhVienId() + " : "
				+ sv.getMssv());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
}
