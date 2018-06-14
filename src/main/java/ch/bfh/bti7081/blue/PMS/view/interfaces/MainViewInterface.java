package ch.bfh.bti7081.blue.PMS.view.interfaces;

import com.vaadin.navigator.View;
import com.vaadin.ui.Button.ClickEvent;

public interface MainViewInterface extends View {

	interface MainViewListener {

		void buttonClick(String string);

	}

	void buttonClick(ClickEvent event);

}