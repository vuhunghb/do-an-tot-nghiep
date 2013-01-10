package irestads.beans;

import irestads.model.Category;
import irestads.model.Dish;

import irestads.service.CategoryServiceUtil;
import irestads.service.DishLocalServiceUtil;
import irestads.service.DishServiceUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import sun.security.x509.DistributionPointName;

public class DishBeans {
	private List<Dish> dishs;
	private Dish dishSelected;
	private Dish dishSearch;
	private Dish dishAdd;
	private String searchType;
	private String keyWords;

	// Generated by Map search types
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
	}

	public DishBeans() {
		// dishSearch=DishLocalServiceUtil.createDish(0);
		dishAdd = DishLocalServiceUtil.createDish(0);
		this.dishs = new ArrayList<Dish>();
		this.getDishsFromDB();
		// this.findDishsByName();
		// this.search();

		// TODO Auto-generated constructor stub
	}

	public void onEdit(RowEditEvent event) {
		try {
			Dish dish = (Dish) event.getObject();
			dish = DishServiceUtil.updateDish(dish);
			String message = "Không thể thực hiện thay đổi thông tin món ăn";
			if (dish != null) {
				message = "Đã thay đổi thông tin món ăn thành công";
				this.getDishsFromDB();
			}
			FacesMessage msg = new FacesMessage(message, dish.getDishId()
					+ " : " + dish.getDishName());
			FacesContext.getCurrentInstance().addMessage(null, msg);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	public List<Dish> getDishsFromDB() {
		this.dishs = DishServiceUtil.getAllDishs();
		System.out.println("get dishs ------------------" + dishs.size());
		return this.dishs;

	}

	public String addDish() {
		System.out.println("add");
		
		DishServiceUtil.createDish(dishAdd.getDishName(),
				dishAdd.getDecription(), dishAdd.getAvatarImg(),
				dishAdd.getDetailImg(), dishAdd.getDetail(),
				dishAdd.getReferPrice(), dishAdd.getCategoryId());
		return "index.xhtml";
	}
	public String changeAddPage(){
		return "add_dish.xhtml";
	}

	public void deleteDish() {

		Dish dish = DishServiceUtil.deleteDish(dishSelected);
		String message = "Không thể thực hiện xóa sinh viên";
		if (dish != null) {
			message = "Đã xóa sinh viên thành công";
			this.getDishsFromDB();
		}
		FacesMessage msg = new FacesMessage(message, dish.getDishId() + " : "
				+ dish.getDishName());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Car Cancelled",
				((Dish) event.getObject()).getDishName());

		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public String search() {
		System.out.println("ST:  " + searchType + " kw : " + keyWords);
		switch (Integer.parseInt(searchType)) {
		case -1:
			this.dishs = getDishsFromDB();
			break;
		case 1:
			Dish d = DishServiceUtil.findDishsById(Long.parseLong(keyWords)); // ma
																				// mon
																				// na
			this.dishs.clear();
			this.dishs.add(d);
			break;
		case 2:
			this.dishs = DishServiceUtil.findDishsByName(keyWords);

			break;
		case 3:
			this.dishs = DishServiceUtil.findDishsByDecription(keyWords);

			break;
		case 4:
			this.dishs = DishServiceUtil.findDishsByAvatarImg(keyWords);

			break;
		case 5:
			this.dishs = DishServiceUtil.findDishsByDetailImg(keyWords);

			break;
		case 6:
			this.dishs = DishServiceUtil.findDishsByDetail(keyWords);

			break;
		case 7:
			this.dishs = DishServiceUtil.findDishsByReferPrice(Integer
					.parseInt(keyWords));

			break;
		case 8:
			this.dishs = DishServiceUtil.findDishsByCategoryName(keyWords);

			break;

		// default:this.dishs= getDishsFromDB();
		// break;
		}

		System.out.println("list dish " + dishs.size());
		return null;
	}

	public String searchSomeField() {
		System.out.println("search " + dishSearch.getDishName());
		this.dishs = DishServiceUtil.findDishsBySomeField(
				dishSearch.getDishId(), dishSearch.getReferPrice(),
				dishSearch.getDishName(), dishSearch.getDecription(),
				dishSearch.getAvatarImg(), dishSearch.getDetailImg(),
				dishSearch.getDetail());
		return null;
	}

	public String getCategoryNameByID(long categoryId) {
		System.out.println("Category ID " + categoryId);
		Category c = CategoryServiceUtil.findByID(categoryId);
		return c.getCategoryName();
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

	public List<Dish> getDishs() {
		return dishs;
	}

	public void setDishs(List<Dish> dishs) {
		this.dishs = dishs;
	}

	public Dish getDishSelected() {
		return dishSelected;
	}

	public void setDishSelected(Dish dishSelected) {
		this.dishSelected = dishSelected;
	}

	public Dish getDishSearch() {
		return dishSearch;
	}

	public void setDishSearch(Dish dishSearch) {
		this.dishSearch = dishSearch;
	}

	public Dish getDishAdd() {
		return dishAdd;
	}

	public void setDishAdd(Dish dishAdd) {
		this.dishAdd = dishAdd;
	}

}
