package ch.bfh.bti7081.blue.PMS.presenter;

import java.util.ArrayList;

import ch.bfh.bti7081.blue.PMS.model.OrderModel;
import ch.bfh.bti7081.blue.PMS.view.OrderView;
import ch.bfh.bti7081.blue.PMS.view.OrderedView;

import com.vaadin.navigator.Navigator;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.CustomComponent;

public class SimonOrderedPresenter extends CustomComponent implements OrderView.OrderViewListener {

	private OrderModel model;
	private OrderedView view;

	public SimonOrderedPresenter(OrderModel model, OrderedView view) {
		this.model = model;
		this.view = view;
		view.addListener(this);
	}

	public void buttonClick(String operation) {
		if (operation.equals("Order again")) {
			System.out.println("safddsfdsf");
			view.getUI().getNavigator().navigateTo("OrderView");

		}

		if (operation.equals("Order history")) {
			System.out.println("bbbbbbbbbbbbbb");
			view.getUI().getNavigator().navigateTo("Order");
		}
	}

}
