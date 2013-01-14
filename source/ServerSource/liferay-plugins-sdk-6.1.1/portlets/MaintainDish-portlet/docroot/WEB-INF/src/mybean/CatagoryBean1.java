package mybean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;


public class CatagoryBean1 {
//	private String sType;
//	private String sContent;
//	private int dishID;
//	private String dishName;
//	private Dish dish = new Dish();
//	private int offset=0;
//
//	private static ArrayList<Dish> dishs = new ArrayList<Dish>(Arrays.asList(
//
//			new Dish(1, "Gà", "Decription", "avatar Img", "detail img", "detail", 5000,
//					"Khai Vị"), new Dish(2, "Gà", "Decription", "avatar Img",
//					"detail img", "detail", 5000, "Khai Vị"),
//					new Dish(3, "Gà", "Decription", "avatar Img", "detail img",
//							"detail", 5000, "Khai Vị"),
//							new Dish(4, "Gà", "Decription", "avatar Img", "detail img",
//									"detail", 5000, "Khai Vị"),
//			new Dish(5, "Gà", "Decription", "avatar Img", "detail img",
//					"detail", 5000, "Khai Vị")
//			));
//
//	public ArrayList<Dish> getDishs() {
//		return dishs;
//	}
//
//	public String addDish() {
//		// Dish dish=new Dish(dishID, dishName);
//		dish.setEditTable(false);
//		dishs.add(dish);
//		return null;
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
//
//		// return to current page
//		return null;
//
//	}
//
//	public Map<String, Object> getFavCategoryValue() {
//		Map<String, Object> coffee2Value = new LinkedHashMap<String, Object>();
//		coffee2Value.put("Khai vị", "Khai vị"); // label, value
//		coffee2Value.put("Món lẩu ", "Món lẩu ");
//		coffee2Value.put("Món Nướng", "Món Nướng");
//		return coffee2Value;
//	}
//
//	public void search() {
//	//	System.out.println("stype " + sType);
//		//System.out.println("scontent " + sContent);
//		if (sType.equals("1")) {
//			dishs = new ArrayList<Dish>(Arrays.asList(
//
//			new Dish(4, "Cơm", "Decription", "avatar Img", "detail img",
//					"detail", 5000, "Khai Vị"), new Dish(5, "Bia",
//					"Decription", "avatar Img", "detail img", "detail", 5000,
//					"Khai Vị"), new Dish(6, "Trứng", "Decription",
//					"avatar Img", "detail img", "detail", 5000, "Khai Vị")));
//		}
//		if (sType.equals("2")) {
//			dishs = new ArrayList<Dish>(Arrays.asList(
//
//			new Dish(7, "Gỏi", "Decription", "avatar Img", "detail img",
//					"detail", 5000, "Khai Vị"), new Dish(8, "Lẩu",
//					"Decription", "avatar Img", "detail img", "detail", 5000,
//					"Khai Vị")
//
//			));
//		}else{
//			dishs = new ArrayList<Dish>(Arrays.asList(
//
//					new Dish(1, "Gà", "Decription", "avatar Img", "detail img", "detail", 5000,
//							"Khai Vị"), new Dish(2, "Gà", "Decription", "avatar Img",
//							"detail img", "detail", 5000, "Khai Vị"),
//							new Dish(3, "Gà", "Decription", "avatar Img", "detail img",
//									"detail", 5000, "Khai Vị")));
//		}
//	}
//	public void prevAction(){
//		if (getOffset() > 2){
//			setOffset(getOffset() - 3);
//		}
//	}
//	public void nextAction(){
//		if (getOffset() < dishs.size() - 2){
//			setOffset(getOffset() + 3);
//		}
//		System.out.println("next " + getOffset());
//		}
//
//	public String saveDishEdit(Dish dish) {
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
//	public int getDishID() {
//		return dishID;
//	}
//
//	public void setDishID(int dishID) {
//		this.dishID = dishID;
//	}
//
//	public String getDishName() {
//		return dishName;
//	}
//
//	public void setDishName(String dishName) {
//		this.dishName = dishName;
//	}
//
//	public Dish getDish() {
//		return dish;
//	}
//
//	public void setDish(Dish dish) {
//		this.dish = dish;
//	}
//
//	public String getsType() {
//		return sType;
//	}
//
//	public void setsType(String sType) {
//		this.sType = sType;
//	}
//
//	public String getsContent() {
//		return sContent;
//	}
//
//	public void setsContent(String sContent) {
//		this.sContent = sContent;
//	}
//
//	public int getOffset() {
//		return offset;
//	}
//
//	public void setOffset(int offset) {
//		this.offset = offset;
//	}
//	

}
