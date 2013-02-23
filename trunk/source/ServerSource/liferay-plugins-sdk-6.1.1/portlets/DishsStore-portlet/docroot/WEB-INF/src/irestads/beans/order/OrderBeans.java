package irestads.beans.order;

import irestads.defination.BooleanToShow;
import irestads.model.Dish;
import irestads.model.DishTable;
import irestads.model.MenuLine;
import irestads.model.OrderLine;
import irestads.model.Orders;
import irestads.service.DishServiceUtil;
import irestads.service.DishTableLocalServiceUtil;
import irestads.service.DishTableServiceUtil;
import irestads.service.MenuLineServiceUtil;
import irestads.service.OrderLineLocalServiceUtil;
import irestads.service.OrderLineService;
import irestads.service.OrderLineServiceUtil;
import irestads.service.OrdersServiceUtil;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

public class OrderBeans {
	private List<DishTable> dishTables;
	private DishTable dishTableSelected;
	private Orders currentOrders;
	private List<OrderLine> orderLinesCurrent;
	private int count = 0;
	private boolean editLable = false;
	private boolean viewPayMentLable = false;
	private int sumChargeOL=0;
	private boolean bntPMent=false;

	public boolean isViewPayMentLable() {
		return viewPayMentLable;
	}

	public void setViewPayMentLable(boolean viewPayMentLable) {
		this.viewPayMentLable = viewPayMentLable;
	}

	public int getCount() {
		return count;
	}

	public String loadImg(boolean isAvailable) {
		if (isAvailable == true) {
			return "/img/binrieng.PNG";
		} else {
			return "/img/1.jpg";
		}
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<OrderLine> getOrderLinesCurrent() {
		return orderLinesCurrent;
	}

	public void setOrderLinesCurrent(List<OrderLine> orderLinesCurrent) {
		this.orderLinesCurrent = orderLinesCurrent;
	}

	public OrderBeans() {
		// TODO Auto-generated constructor stub
		this.getAllDishTable();
	}

	// public Orders getCurrentOrder(boolean isPayMent, String dishTableId) {
	// Orders o = OrdersServiceUtil.findCurrentOrder(isPayMent, dishTableId);
	// if (o != null) {
	// this.currentOrders = o;
	// }
	// return o;
	//
	// }

	public String toStringTableAvailable(boolean value) {
		return BooleanToShow.booleanToShow(value, "Đã có khách",
				"Chưa có khách");
	}

	public List<DishTable> getDishTables() {
		return dishTables;
	}

	public void getAllDishTable() {
		this.dishTables = DishTableLocalServiceUtil.getAllDishTables();
		for (int i = 0; i < dishTables.size(); i++) {
			System.out.println("is available "+dishTables.get(i).getIsAvalable());
		}
	}

	public void setDishTables(List<DishTable> dishTables) {
		this.dishTables = dishTables;
	}

	public DishTable getDishTableSelected() {
		//
		return dishTableSelected;
	}

	public void setDishTableSelected(DishTable dishTableSelected) {
		this.dishTableSelected = dishTableSelected;

	}

	public Orders getCurrentOrders() {
		return currentOrders;
	}

	public void setCurrentOrders(Orders currentOrders) {
		this.currentOrders = currentOrders;
	}

	public void loadCurrentOrderLine(long id) {
		this.orderLinesCurrent = OrderLineServiceUtil.getOrderLineByOrder(id);
	}

	public String getDishNameById(long dishId) {
		Dish d = DishServiceUtil.findDishsById(dishId);
		if (d != null)
			return d.getDishName();
		return "";
	}

	public void onEdit(RowEditEvent event) {
		try {
			FacesMessage msg = null;
			OrderLine orderLine = (OrderLine) event.getObject();
			String message = "Không thể thực hiện thay đổi thông tin món ăn";
			if (orderLine.getNumOfFinishDish() <= orderLine.getNumOfDish()) {
				orderLine = OrderLineServiceUtil.updateOrderLine(
						orderLine.getOrderLineId(),
						orderLine.getNumOfFinishDish(),
						orderLine.getStatusDish());

				if (orderLine != null) {
					message = "Đã thay đổi thông tin món ăn thành công";
					OrderLineServiceUtil.synchStatusOrderLine(orderLine);
					msg = new FacesMessage(message, " Trạng thái : "
							+ orderLine.getStatusDish() + " Số hoàn thành : "
							+ orderLine.getNumOfFinishDish());
				}
			} else {
				message = "Sai số khi nhập liệu số lượng món ăn đã hoàn thành";
				msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, message,
						" Số hoàn thành : " + orderLine.getNumOfFinishDish());
			}
			this.loadCurrentOrderLine(orderLine.getOrderId());

			FacesContext.getCurrentInstance().addMessage(null, msg);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public String toStringStatus(int value) {

		if (value == 0) {
			return "Hóa đơn Mơi";
		} else if (value == 1) {
			return "Đang thực hiện";
		} else if (value == 2) {
			return "Đã hoàn tất";
		}
		return "";
	}

	public String toStrIsPaymentOrder(int value) {
		if (value == 0) {
			return "Chưa Thanh Toán";
		} else if (value == 1) {
			return "Đợi Thanh Toán";
		} else if (value == 2) {
			return "Đã Thanh Toán";
		}
		return "";
	}

	public String editStatusOrdAct() {
		editLable = true;
		return null;
	}

	public void updateOrders() {
		OrdersServiceUtil.updateOrder(dishTableSelected.getCurentOrder());
		editLable = false;
	}

	public boolean isEditLable() {
		return editLable;
	}

	public void setEditLable(boolean editLable) {
		this.editLable = editLable;
	}
// payment cho cai order
	public void payment() {
		OrdersServiceUtil.payment(dishTableSelected.getCurrentOrderId());
		dishTableSelected.setIsAvalable(false);
		DishTableServiceUtil.updateDishTable(dishTableSelected);
	}

	public void viewPayment() {
		this.viewPayMentLable=true;
		this.bntPMent=true;
		System.out.println("view pm "+this.viewPayMentLable);
		this.sumChargeOLineCurrent();
	}
public int orderLineCharge(OrderLine ol){
	return OrderLineServiceUtil.getCharge(ol);
}
	
public int sumChargeOLineCurrent(){
	int charge=0;
	for (int i = 0; i < this.orderLinesCurrent.size(); i++) {
		charge+=orderLineCharge(this.orderLinesCurrent.get(i));
	}
	this.sumChargeOL=charge;
	return charge;
}

	public void increate() {
		count++;
	}

	public int getSumChargeOL() {
		return sumChargeOL;
	}

	public void setSumChargeOL(int sumChargeOL) {
		this.sumChargeOL = sumChargeOL;
	}

	public boolean isBntPMent() {
		return bntPMent;
	}

	public void setBntPMent(boolean bntPMent) {
		this.bntPMent = bntPMent;
	}
	
}
