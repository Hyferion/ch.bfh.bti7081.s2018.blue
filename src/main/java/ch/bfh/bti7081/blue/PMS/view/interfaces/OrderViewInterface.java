package ch.bfh.bti7081.blue.PMS.view.interfaces;

import java.util.ArrayList;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CheckBox;

public interface OrderViewInterface extends View {

	interface OrderViewListener {

		void buttonClick(String string);

	}

	void buttonClick(ClickEvent event);

}