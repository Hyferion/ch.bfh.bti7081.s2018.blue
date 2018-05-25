package ch.bfh.bti7081.blue.PMS.view;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.navigator.Navigator;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

import ch.bfh.bti7081.blue.PMS.view.interfaces.SimonOrderViewInterface;

public class SimonOrderedView extends CustomComponent implements SimonOrderViewInterface, ClickListener {

	private static final long serialVersionUID = 3958839843793423943L;
	private Navigator navigator;

	public SimonOrderedView(Navigator navigator)  {
		this.navigator = navigator;
		VerticalLayout orderedLayout = new VerticalLayout(); // mainLayout

		Label text = new Label("Danke für Ihre Bestellung."); // caption
		text.addStyleName(ValoTheme.LABEL_H1);
		orderedLayout.addComponent(text);
		

		Label textOrderHistory = new Label("Um Ihre Besttelungen anzusehen drücken Sie auf \"Order history\""); // caption
		textOrderHistory.addStyleName(ValoTheme.LABEL_H2);
		orderedLayout.addComponent(textOrderHistory);
		

		Button ButtonHistory = new Button("Order history", this);	
		orderedLayout.addComponent(ButtonHistory);
		orderedLayout.setComponentAlignment(ButtonHistory, Alignment.BOTTOM_LEFT);
		

		Label textOrderAgain = new Label("Um eine neue Bestellung aufzugeben drücken Sie auf \"Order again\"");
		textOrderAgain.addStyleName(ValoTheme.LABEL_H2);
		
		orderedLayout.addComponent(textOrderAgain);
		
		Button OrderAgain = new Button("Order again", this);
		orderedLayout.addComponent(OrderAgain);
		orderedLayout.setComponentAlignment(OrderAgain, Alignment.BOTTOM_LEFT);
		
		setCompositionRoot(orderedLayout);

	}

	List<OrderViewListener> listeners = new ArrayList<OrderViewListener>();

	public void addListener(OrderViewListener listener) {
		listeners.add(listener);

	}
	
	

	@Override
	public void buttonClick(ClickEvent event) {
		
	}

}