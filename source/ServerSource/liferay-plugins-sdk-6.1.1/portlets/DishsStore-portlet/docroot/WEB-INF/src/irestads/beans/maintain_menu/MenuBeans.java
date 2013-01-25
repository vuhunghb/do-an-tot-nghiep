package irestads.beans.maintain_menu;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import org.primefaces.event.DragDropEvent;
import org.primefaces.event.FlowEvent;
import org.primefaces.event.RowEditEvent;

import irestads.model.*;
import irestads.service.DishServiceUtil;
import irestads.service.MenuLineLocalServiceUtil;
import irestads.service.MenuLineServiceUtil;
import irestads.service.MenuServiceUtil;
import irestads.service.UVersionLocalServiceUtil;
import irestads.service.persistence.DishUtil;
import irestads.service.persistence.MenuLineUtil;

public class MenuBeans {
	private List<MenuLine> menuLines;
	private List<MenuLine> menuLinestemp;
	private MenuLine menuLineSelected;
	private List<MenuLine> candidateMenuLine;
	private MenuLine menuLineAdd;
	private String searchType;
	private String keyWords;
	private List<Dish> dishsNotInML=new ArrayList<Dish>();
	private Dish [] selectedDishs;
	private Map<String, Object> checkboxValue=new  LinkedHashMap<String, Object>();
	private boolean skip;  
    private static Logger logger = Logger.getLogger(MenuBeans.class.getName()); 
	private boolean validateFlag=false;
   
	public void searchTypeChanged(ValueChangeEvent e){
		
		//assign new value to localeCode
		int st = (Integer) e.getNewValue();
		System.out.println("st "+st);
		if(st==10){
			validateFlag=true;
		}else{
			validateFlag=false;
		}
 
	}
    public List<UVersion> findNextVersions() {
    	List<UVersion> list =	UVersionLocalServiceUtil.findNextVersions(201);
    	System.out.println("lisst "+list.size());
    	for (UVersion uVersion : list) {
			System.out.println(" v "+uVersion.getVersionId());
		}
    	return list;
    }

	private Map<String, Object> searchTypesValue;
	{
		searchTypesValue = new LinkedHashMap<String, Object>();
		searchTypesValue.put("Tất cả", -1); // label, value
		searchTypesValue.put("Mã món ăn", 1); // label, value
		searchTypesValue.put("Tên món ăn", 2); // label, value
		searchTypesValue.put("Mô Tả", 3); // label, value
		searchTypesValue.put("Ảnh đại diện", 4); // label, value
		searchTypesValue.put("Ảnh chi tiết", 5); // label, value
		searchTypesValue.put("Chi tiết", 6); // label, value
		searchTypesValue.put("Giá ", 7); // label, value
		searchTypesValue.put("Loại", 8); // label, value
		searchTypesValue.put("Số lượng", 9); // label, value
		searchTypesValue.put("Trạng thái", 10); // label, value
	}
	public String onFlowProcess(FlowEvent event) {  
        logger.info("Current wizard step:" + event.getOldStep());  
        logger.info("Next step:" + event.getNewStep());  
         
       
            
            		String e=event.getNewStep();  
            //		 System.out.println(e);
           		return e;
         
    }  

	public boolean isSkip() {
		return skip;
	}

	public void setSkip(boolean skip) {
		this.skip = skip;
	}

	public static Logger getLogger() {
		return logger;
	}

	public static void setLogger(Logger logger) {
		MenuBeans.logger = logger;
	}

	public MenuBeans() {

		// TODO Auto-generated constructor stub
		this.getMenuLinesDB();
		this.innitAdd();
		this.findDishNotInMenu();
	}

	public void innitAdd() {
		Dish d = DishUtil.create(0);
		menuLineAdd = MenuLineUtil.create(0);
		menuLineAdd.setDish(d);
	}

	public List<MenuLine> getMenuLines() {
		return menuLines;
	}

	public void setMenuLines(List<MenuLine> menuLines) {
		this.menuLines = menuLines;
	}

	public List<MenuLine> getMenuLinesDB() {
		this.menuLines = MenuLineLocalServiceUtil.getAllMenuLines();
		for (MenuLine iterable_element : menuLines) {
			System.out.println("dish bean " + iterable_element.getDish());
			this.menuLinestemp = MenuLineLocalServiceUtil.getAllMenuLines();

		}
		return this.menuLines;
	}

	public List<MenuLine> getMenuLinestemp() {
		return menuLinestemp;
	}

	public void setMenuLinestemp(List<MenuLine> menuLinestemp) {
		this.menuLinestemp = menuLinestemp;
	}

	public void onCarDrop(DragDropEvent ddEvent) {
		MenuLine ml = ((MenuLine) ddEvent.getData());

		this.menuLines.add(ml);
		this.menuLinestemp.remove(ml);
		System.out.println("drap drop " + ml.getMenuLineId());

	}

	public void onEdit(RowEditEvent event) {
		try {
			MenuLine menuLine = (MenuLine) event.getObject();
			menuLine = MenuLineServiceUtil.updateMenuLine(menuLine);
			String message = "Không thể thực hiện thay đổi thông tin thực đơn";
			FacesMessage msg = null;
			if (menuLine != null) {
				message = "Đã thay đổi thông tin thực đơn thành công";
				MenuLineServiceUtil.setDishForMenuLine(menuLine);
				this.getMenuLinesDB();
				msg = new FacesMessage(message, menuLine.getDish()
						.getDishId() + " : " + menuLine.getDish().getDishName());
			}
			
			
			FacesContext.getCurrentInstance().addMessage(null, msg);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	public String addMenuLine() {
		FacesMessage msg = null;
		DishModel dish = menuLineAdd.getDish();
//	MenuLine menuLine=	 MenuLineServiceUtil.createMenuLine(dish.getDishName(),
//				dish.getDecription(), dish.getAvatarImg(), dish.getDetailImg(),
//				dish.getDetail(), dish.getReferPrice(),
//				dish.getAvatarBaseCode(), dish.getDetailBaseCode(),
//				dish.getCategoryId(), menuLineAdd.getNumOfDish(),
//				true);
		MenuLine menuLine=MenuLineServiceUtil.createMenuLineDish(menuLineAdd);
		 String message = "Không thêm thực đơn";
			if (menuLine != null) {
				message = "Đã thêm  thực đơn thành công";
				MenuLineServiceUtil.setDishForMenuLine(menuLine);
				this.getMenuLinesDB();
				msg = new FacesMessage(message, menuLine.getDish()
						.getDishId() + " : " + menuLine.getDish().getDishName());
			}
			
			
			FacesContext.getCurrentInstance().addMessage(null, msg);
		return "menu.xhtml";
	}
	public String addMenuLines(){
		FacesMessage msg = null;
		if(this.candidateMenuLine.size()>0){
		
		List<MenuLine> mlSaved=MenuLineServiceUtil.createMenuLine(this.candidateMenuLine);
		 String message = "Thêm thực đơn không thành công";
		if(mlSaved.size()>0){
			message = "Đã thêm  thực đơn thành công";
			msg = new FacesMessage(message,"Số lượng đã thêm là: "+mlSaved.size());
			this.getMenuLinesDB();
			this.findDishNotInMenu();
		}
		}else{
			msg = new FacesMessage("Chưa chọn món ăn để thêm","");
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
		return "menu.xhtml";
	}

	public void deleteMenuLine() {

		MenuLine menuLine = MenuLineServiceUtil
				.deleteMenuLine(menuLineSelected);
		String message = "Không thể thực hiện xóa thực đơn.";
		if (menuLine != null) {
			message = "Đã xóa thực đơn thành công";
			this.getMenuLinesDB();
			this.findDishNotInMenu();
		}
		FacesMessage msg = new FacesMessage(message, "");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public MenuLine getMenuLineSelected() {
		return menuLineSelected;
	}

	public void setMenuLineSelected(MenuLine menuLineSelected) {
		this.menuLineSelected = menuLineSelected;
	}
	public List<Dish> findDishNotInMenu() {
		
		 this.dishsNotInML=DishServiceUtil.findDishNotInMenu();
		 for (int i = 0; i <dishsNotInML.size(); i++) {
			 checkboxValue.put(dishsNotInML.get(i).getDishId()+"", dishsNotInML.get(i).getDishId());
		}
		 
		 return dishsNotInML;
	}
	public String search() {
		System.out.println("ST:  " + searchType + " kw : " + keyWords);
		switch (Integer.parseInt(searchType)) {
		case -1:
			this.menuLines = this.getMenuLinesDB();
			break;

		case 1:
			this.menuLines = MenuLineServiceUtil.findMenuLinesByDishId(Long
					.parseLong(keyWords));
			break;
		case 2:
			this.menuLines = MenuLineServiceUtil.findMenuLinesByDName(keyWords);
			break;
		case 3:
			this.menuLines = MenuLineServiceUtil
					.findMenuLinesByDDecription(keyWords);
			break;
		case 4:
			this.menuLines = MenuLineServiceUtil
					.findMenuLinesByDAvatarImg(keyWords);
			break;
		case 5:
			this.menuLines = MenuLineServiceUtil
					.findMenuLinesByDDetailImg(keyWords);

			break;
		case 6:
			this.menuLines = MenuLineServiceUtil
					.findMenuLinesByDDetail(keyWords);

			break;
		case 7:
			// this.menuLines=
			this.menuLines = MenuLineServiceUtil
					.findMenuLinesByDReferPrice(Integer.parseInt(keyWords));
			break;
		case 8:
			this.menuLines = MenuLineServiceUtil
					.findMenuLinesByDCategoryName(keyWords);
			break;
		case 9:
			this.menuLines = MenuLineServiceUtil
					.findMenuLinesByNumOfDish(Integer.parseInt(keyWords));
			break;
		case 10:
			this.menuLines = MenuLineServiceUtil.findMenuLinesByStatus(Boolean
					.parseBoolean(keyWords));
			break;

		// default:this.dishs= getDishsFromDB();
		// break;
		}

		// System.out.println("list dish " + dishs.size());
		return null;
	}

	public String parseBooleanToShow(boolean value) {
		return MenuLineServiceUtil.parseBooleanToShow(value, "Còn", "Hết");
	}

	public MenuLine getMenuLineAdd() {
		return menuLineAdd;
	}

	public void setMenuLineAdd(MenuLine menuLineAdd) {
		this.menuLineAdd = menuLineAdd;
	}

	public List<Dish> getDishsNotInML() {
		//this.findDishNotInMenu();
		return dishsNotInML;
	}

	public void setDishsNotInML(List<Dish> dishsNotInML) {
		this.dishsNotInML = dishsNotInML;
	}
	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getKeyWords() {
		return keyWords;
	}

	public void setKeyWords(String keyWords) {
		this.keyWords = keyWords;
	}

	public Map<String, Object> getSearchTypesValue() {
		return searchTypesValue;
	}

	public void setSearchTypesValue(Map<String, Object> searchTypesValue) {
		this.searchTypesValue = searchTypesValue;
	}
	public Map<String, Object> getCheckboxValue() {
		return checkboxValue;
	}

	public void setCheckboxValue(Map<String, Object> checkboxValue) {
		this.checkboxValue = checkboxValue;
	}

	public Dish[] getSelectedDishs() {
		return selectedDishs;
	}

	public void setSelectedDishs(Dish[] selectedDishs) {
		this.selectedDishs = selectedDishs;
	}

	public List<MenuLine> getCandidateMenuLine() { // 
		//this.setCandidateMenuLine(candidateMenuLine)
		List<MenuLine> temp=new ArrayList<MenuLine>();
		MenuLine m;
		for (int i = 0; i < this.selectedDishs.length; i++) {
			Dish d=this.selectedDishs[i];
			m=MenuLineUtil.create(0);
			m.setDishId(d.getDishId());
			m.setDish(d);
			m.setStatus(true);
			temp.add(m);
		
		}
		this.candidateMenuLine=temp;
		return candidateMenuLine;
	}

	public void setCandidateMenuLine(List<MenuLine> candidateMenuLine) {
		this.candidateMenuLine = candidateMenuLine;
	}
	public boolean isValidateFlag() {
		return validateFlag;
	}
	public void setValidateFlag(boolean validateFlag) {
		this.validateFlag = validateFlag;
	}

	
}
