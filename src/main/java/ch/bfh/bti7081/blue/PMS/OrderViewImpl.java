package ch.bfh.bti7081.blue.PMS;

import java.awt.Checkbox;
import java.util.ArrayList;
import java.util.List;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

public class OrderViewImpl extends CustomComponent implements OrderView, ClickListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3958839843793423943L;
	private Label display = new Label("0.0");

	public OrderViewImpl() {
		VerticalLayout mainLayout = new VerticalLayout();

		
		

		GridLayout layout = new GridLayout(3,5);
		mainLayout.addComponent(new Label(" "));
		
		Label text = new Label("Prescription Order");
		text.addStyleName(ValoTheme.LABEL_H1);
	
		mainLayout.addComponent(text);
		mainLayout.addComponent(layout);
		
		
		
		layout.setCaption("Medikament");
		layout.setWidth("700");
		layout.setSpacing(true);
		
		for(int i = 0; i < 6;i++) {
		layout.addComponent(new Label("jajajaja"));
		layout.addComponent(new Label("adasf"));
	   	CheckBox checkBox = new CheckBox();
	   	checkBox.setValue(false);
	   	layout.addComponent(checkBox);
		}

		Button send = new Button("Send Order");
		send.setHeight("100");
		
		mainLayout.addComponent(send);
	
		mainLayout.addComponent(new Button("Back"));
		

		setCompositionRoot(mainLayout);
		
	}

	public void setDisplay(double value) {
		display.setValue(Double.toString(value));
	}

	/* Only the presenter registers one listener... */
	List<CalculatorViewListener> listeners = new ArrayList<CalculatorViewListener>();

	public void addListener(CalculatorViewListener listener) {
		listeners.add(listener);
	}

	/**
	 * Relay button clicks to the presenter with an implementation-independent
	 * event
	 */
	@Override
	public void buttonClick(ClickEvent event) {
		for (CalculatorViewListener listener : listeners)
			listener.buttonClick(event.getButton().getCaption().charAt(0));
	}
}