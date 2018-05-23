package ch.bfh.bti7081.blue.PMS;

import java.util.ArrayList;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.CheckBox;

public interface SimonOrderView extends View {
	public void setDisplay(double value);

	interface OrderViewListener {
		void buttonClick(String operationr, Navigator navigator, ArrayList<CheckBox> checkBoxList);
	}

	public void addListener(OrderViewListener listener);

	void setDisplay(ViewChangeListener event);
	
}