package ch.bfh.bti7081.blue.PMS.presenter;

import java.util.ArrayList;

import ch.bfh.bti7081.blue.PMS.model.OrderModel;
import ch.bfh.bti7081.blue.PMS.view.SimonOrderView;
import com.vaadin.navigator.Navigator;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.CustomComponent;

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
