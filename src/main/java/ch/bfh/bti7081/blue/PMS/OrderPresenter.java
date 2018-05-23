package ch.bfh.bti7081.blue.PMS;

import java.util.ArrayList;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.ui.CheckBox;

public class OrderPresenter implements SimonOrderView.OrderViewListener {

	private OrderModel model;
	private SimonOrderView view;

	public OrderPresenter(OrderModel model, SimonOrderView view) {
		this.model = model;
		this.view = view;
		view.setDisplay(6.0);
		view.addListener(this);
	}

	public void buttonClick(String operation, Navigator navigator, ArrayList<CheckBox> checkBoxList) {
			if (operation.equals("Send Order")) {
			navigator.navigateTo("Second");
			for (CheckBox test : checkBoxList) 
			System.out.println("State: "+test.getValue());
			try {
				navigator.wait(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("dasffffffffffffffffffffffff");
			}
			navigator.navigateTo("first");
		}
		
		if (operation.equals("Order history")) {
			navigator.navigateTo("Lars View");
		}
		
	}
	
	
}
