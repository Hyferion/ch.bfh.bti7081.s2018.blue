package ch.bfh.bti7081.blue.PMS.presenter;

import com.vaadin.navigator.View;
import com.vaadin.ui.CustomComponent;

import ch.bfh.bti7081.blue.PMS.model.OrderStatus;
import ch.bfh.bti7081.blue.PMS.view.OrderStatusViewImp;

public class OrderStatusViewPresenter extends CustomComponent implements View {
	private static final long serialVersionUID = 1L;
	private OrderStatus orderStatus;
	private OrderStatusViewImp orderStatusViewImp;

	public OrderStatusViewPresenter(OrderStatus model, OrderStatusViewImp view) {
		this.orderStatus = model;
		this.orderStatusViewImp = view;

	}
}
