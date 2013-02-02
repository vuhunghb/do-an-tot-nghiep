package irestads.beans.order;

import irestads.model.DishTable;
import irestads.model.Orders;
import irestads.service.DishTableLocalServiceUtil;
import irestads.service.OrdersServiceUtil;

import java.util.List;

public class OrderBeans {
	private List<DishTable> dishTables;
	private DishTable dishTableSelected;
	private Orders currentOrders;
	public OrderBeans() {
		// TODO Auto-generated constructor stub
		this.getAllDishTable();
	}
	public Orders getCurrentOrder(boolean isPayMent, String dishTableId){
		Orders o =OrdersServiceUtil.findCurrentOrder(isPayMent, dishTableId);
		if(o!=null){
			this.currentOrders=o;
		}
		return o;
		
	}

	public List<DishTable> getDishTables() {
		return dishTables;
	}
	public void getAllDishTable(){
		this.dishTables=DishTableLocalServiceUtil.getAllDishTables();
	}

	public void setDishTables(List<DishTable> dishTables) {
		this.dishTables = dishTables;
	}

	public DishTable getDishTableSelected() {
		System.out.println("t selected ");
		return dishTableSelected;
	}

	public void setDishTableSelected(DishTable dishTableSelected) {
		System.out.println("t selected seter");
		this.dishTableSelected = dishTableSelected;
	}

	public Orders getCurrentOrders() {
		return currentOrders;
	}

	public void setCurrentOrders(Orders currentOrders) {
		this.currentOrders = currentOrders;
	}

	
}
