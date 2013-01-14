package mybean;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;



public class ManagerDishStore  {

	/**
	 * 
	 */
////	private static final long serialVersionUID = 1L;
//	private Dish dishAdd = new Dish();
//	private int CategoryID;
//	private String searchTypeProperty;
//	private String contentSearch;
//	CategoryDAO categoryDAO= DAOFactory.instance(HibernateDAOFactory.class).getCategoryDAO();
//	 DishDAO dishDAO= DAOFactory.instance(HibernateDAOFactory.class).getDishDAO();
//	List<Category> categorys ;
//	private  ArrayList<Dish> dishs ;
//
//	public ManagerDishStore() {
//		categorys=categoryDAO.findAll();
//		dishs=(ArrayList<Dish>) dishDAO.findAll();
//		// TODO Auto-generated constructor stub
//	}
//	
//
//	public ArrayList<Dish> getDishs() {
//		return dishs;
//	}
//
//	public String addDish() {
//		// Dish dish=new Dish(dishID, dishName);
//		dishAdd.setEditTable(false);
//		System.out.println("caid "+CategoryID);
//		Category category=categoryDAO.findById(CategoryID, false);
//		System.out.println("ca"+category.getCategoryID());
//		//dishDAO.makePersistent(dishAdd);
//		category.getDishs().add(dishAdd);
//		categoryDAO.makePersistent(category);
//		
//		dishAdd = new Dish();
//		return "ManagerDish";
//	}
//
//	public String removeDish(Dish dish) {
//
//		dishs.remove(dish);
//		return null;
//	}
//
//	public String EditDish() {
//		return null;
//	}
//
//	public String saveEditAll() {
//
//		// get all existing value but set "editable" to false
//		for (Dish dish : dishs) {
//			dish.setEditTable(false);
//		}
//		// return to current page
//		return null;
//	}
//
//	public Map<String, Object> getFavCategoryValue() {
//		Map<String, Object> categoryValue = new LinkedHashMap<String, Object>();
//		
//		for (Category c : categorys) {
//			categoryValue.put(c.getCategoryName(), c.getCategoryID());
//		}
//
//		return categoryValue;
//	}
//	public Map<String,Object> getSearchTypes(){
//		return MyUtil.searchTypesForStoreDish();
//	}
//
//	public String saveDishEdit(Dish dish) {
//		
//		dishDAO.makePersistent(dish);
//		dish.setEditTable(false);
//		return null;
//	}
//
//	public String editAction(Dish dish) {
//
//		dish.setEditTable(true);
//		return null;
//	}
//
//	public String getSearchTypeProperty() {
//		return searchTypeProperty;
//	}
//
//	public void setSearchTypeProperty(String searchTypeProperty) {
//		this.searchTypeProperty = searchTypeProperty;
//	}
//
//	public Dish getDish() {
//		return dishAdd;
//	}
//
//	public void setDish(Dish dish) {
//		this.dishAdd = dish;
//	}
//
//	public String getContentSearch() {
//		return contentSearch;
//	}
//
//	public void setContentSearch(String contentSearch) {
//		this.contentSearch = contentSearch;
//	}
//
//
//	public int getCategoryID() {
//		return CategoryID;
//	}
//
//
//	public void setCategoryID(int categoryID) {
//		CategoryID = categoryID;
//	}
//	
	
}
