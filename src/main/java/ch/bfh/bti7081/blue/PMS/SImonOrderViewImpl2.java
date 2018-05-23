package ch.bfh.bti7081.blue.PMS;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

public class SImonOrderViewImpl2 extends CustomComponent implements SimonOrderView, ClickListener {

	private static final long serialVersionUID = 3958839843793423943L;
	private Navigator navigator;

	public SImonOrderViewImpl2(Navigator navigator)  {
		this.navigator = navigator;
		VerticalLayout mainLayout = new VerticalLayout(); // mainLayout

		Label text = new Label("Danke für Ihre Bestellung. Sie werden gleich weitergeleitet."); // caption
		text.addStyleName(ValoTheme.LABEL_H1);
		mainLayout.addComponent(text);
		
		

		setCompositionRoot(mainLayout);

	}

	List<OrderViewListener> listeners = new ArrayList<OrderViewListener>();

	public void addListener(OrderViewListener listener) {
		listeners.add(listener);

	}

	@Override
	public void buttonClick(ClickEvent event) {
		
	}

	@Override
	public void setDisplay(ViewChangeListener event) {
		
		navigator.addViewChangeListener(event);
			
	}

	@Override
	public void setDisplay(double value) {
		// TODO Auto-generated method stub
		
	}
}