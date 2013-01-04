package irestads.beans;


import irestads.model.Dish;


import irestads.service.DishServiceUtil;



import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;


@SessionScoped
public class DishBeans {
	private List<Dish> dishs;
	private Dish dishSelected;

	public DishBeans() {
		this.dishs = new ArrayList<Dish>();
		this.getDishsFromDB();
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
			FacesMessage msg = new FacesMessage(message, dish.getDishId()+ " : "+
				dish.getDishName());
			FacesContext.getCurrentInstance().addMessage(null, msg);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	
	public List<Dish> getDishs() {
	//	System.out.println("vo get dish "+ this.dishs.get(0).getDishName()+" ++ "+this.dishs.get(1).getDishName());
		//this.getDishsFromDB();
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


	public List<Dish> getDishsFromDB(){
		this.dishs= DishServiceUtil.getAllDishs();
		//System.out.println("get dishs ------------------"+dishs.size());
		return this.dishs;
		
	}
	public void deleteDish(){
		
		Dish dish=DishServiceUtil.deleteDish(dishSelected);
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
        FacesMessage msg = new FacesMessage("Car Cancelled", ((Dish) event.getObject()).getDishName());  
  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    }  




}
