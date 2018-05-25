package ch.bfh.bti7081.blue.PMS.presenter;

import java.util.Set;

import com.vaadin.navigator.View;

import ch.bfh.bti7081.blue.PMS.DB.DBConnector;
import ch.bfh.bti7081.blue.PMS.model.OrderStatus;
import ch.bfh.bti7081.blue.PMS.model.OrderStatusModel;
import ch.bfh.bti7081.blue.PMS.view.OrderStatusViewImp;

public class OrderStatusViewPresenter implements View {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private OrderStatusModel orderStatusModel;
	private OrderStatusViewImp orderStatusViewImp;
	private Set<OrderStatus> orders;

	public OrderStatusViewPresenter(OrderStatusModel model, OrderStatusViewImp view) {
		this.orderStatusModel = model;
		this.orderStatusViewImp = view;
		initializeOrders();

	}

	public Set<OrderStatus> getOrders() {
		return this.orders;
	}
	
	
	@SuppressWarnings("unchecked")
	public void initializeOrders() {
		orderStatusViewImp.getGrid().setItems(DBConnector.getDBConnector().getLoginAccount().getOrderStatus());
	}
}
