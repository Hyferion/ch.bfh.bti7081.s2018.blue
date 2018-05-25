<<<<<<< HEAD
package ch.bfh.bti7081.blue.PMS.view.interfaces;
=======
package ch.bfh.bti7081.blue.PMS.view;
>>>>>>> branch 'testing' of https://github.com/Hyferion/ch.bfh.bti7081.s2018.blue.git

import java.util.ArrayList;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.ui.CheckBox;

public interface SimonOrderViewInterface extends View {

	interface OrderViewListener {
		void buttonClick(String operationr, Navigator navigator, ArrayList<CheckBox> checkBoxList);
	}

	public void addListener(OrderViewListener listener);
	
}