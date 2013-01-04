package irestads.beans;

import irestads.model.Lop;
import irestads.model.SinhVien;
import irestads.service.LopServiceUtil;
import irestads.service.SinhVienServiceUtil;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ViewScoped;

import org.primefaces.event.SelectEvent;

@ViewScoped
public class LopHocBeans {
	List<Lop> lops;
	SinhVien sinhVienSelected;

	public LopHocBeans() {
		super();
		this.lops = new ArrayList<Lop>();
	}

	public List<Lop> getLops() {
		this.lops = LopServiceUtil.getAllLop();
		for (int i = 0; i < this.lops.size(); i++) {
			Lop l = this.lops.get(i);
			l.setDssv(SinhVienServiceUtil.getSinhVienByLop(l.getLopId()));
		}
		return lops;
	}

	public void setLops(List<Lop> lops) {
		this.lops = lops;
	}

	public SinhVien getSinhVienSelected() {
		return sinhVienSelected;
	}

	public void setSinhVienSelected(SinhVien sinhVien) {
		this.sinhVienSelected = sinhVien;
	}
}
