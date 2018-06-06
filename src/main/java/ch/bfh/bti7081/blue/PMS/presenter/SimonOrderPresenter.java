package ch.bfh.bti7081.blue.PMS.presenter;

import com.vaadin.ui.CustomComponent;

import ch.bfh.bti7081.blue.PMS.model.OrderModel;
import ch.bfh.bti7081.blue.PMS.view.OrderView;

public class SimonOrderPresenter extends CustomComponent implements OrderView.OrderViewListener {

	private OrderModel model;
	private OrderView view;

	public SimonOrderPresenter(OrderModel model, OrderView view) {
		this.model = model;
		this.view = view;
		view.addListener(this);
	}

	public void buttonClick(String operation) {

		if (operation.equals("Send Order")) {
			view.ask();
		}
		if (operation.equals("Order")) {
			view.getUI().getNavigator().navigateTo("OrderedView");
			view.writeInDb();
			view.closeSub();
		}
		if (operation.equals("Cancel")) {
			view.closeSub();
		}
		if (operation.equals("Order history")) {
			view.getUI().getNavigator().navigateTo("Order");
		}
	}
}
