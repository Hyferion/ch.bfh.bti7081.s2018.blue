package ch.bfh.bti7081.blue.PMS.presenter;

import com.vaadin.ui.CustomComponent;

import ch.bfh.bti7081.blue.PMS.model.OrderModel;
import ch.bfh.bti7081.blue.PMS.view.SimonOrderView;

public class SimonOrderPresenter extends CustomComponent implements SimonOrderView.OrderViewListener {

	private OrderModel model;
	private SimonOrderView view;

	public SimonOrderPresenter(OrderModel model, SimonOrderView view) {
		this.model = model;
		this.view = view;
		view.addListener(this); 
	}

	public void buttonClick(String operation) {
		if (operation.equals("Send Order")) {
			view.getUI().getNavigator().navigateTo("OrderedView");
			/*for (CheckBox test : checkBoxList)
				System.out.println("State: " + test.getValue());*/ 
		}

		if (operation.equals("Order history")) {
			view.getUI().getNavigator().navigateTo("Order");
		}
	}
} 
