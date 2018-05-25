package ch.bfh.bti7081.blue.PMS;

import java.util.ArrayList;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.ui.CheckBox;

public class SimonOrderPresenter implements SimonOrderView.OrderViewListener {

	private SimonOrderModel model;
	private SimonOrderView view;

	public SimonOrderPresenter(SimonOrderModel model, SimonOrderView view) {
		this.model = model;
		this.view = view;
		view.addListener(this);
	}

	public void buttonClick(String operation, Navigator navigator, ArrayList<CheckBox> checkBoxList) {
			if (operation.equals("Send Order")) {
			navigator.navigateTo("orderedView");
			for (CheckBox test : checkBoxList) 
			System.out.println("State: "+test.getValue());
		}
		
			if (operation.equals("Order history")) {
			navigator.navigateTo("Lars View");
		}		
	}
	
	
}
