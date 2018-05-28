package ch.bfh.bti7081.blue.PMS.view;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.navigator.Navigator;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

import ch.bfh.bti7081.blue.PMS.view.interfaces.SimonOrderViewInterface;
import ch.bfh.bti7081.blue.PMS.view.interfaces.SimonOrderViewInterface.OrderViewListener;

public class SimonOrderedView extends CustomComponent implements SimonOrderViewInterface, ClickListener {

	private static final long serialVersionUID = 3958839843793423943L;

	public SimonOrderedView() {
		
		//Set root Layout with title
		HeaderFooter root = new HeaderFooter("Danke für Ihre Bestellung");
		
		//Mainlayout for this View
		VerticalLayout orderedLayout = new VerticalLayout();
	
		//HorizontalLayout to set a text and a botton
		HorizontalLayout horizontalLayout = new HorizontalLayout();

		Label textOrderHistory = new Label("Um Ihre Bestellungen anzusehen drücken Sie auf \"Order history\""); 
		textOrderHistory.addStyleName(ValoTheme.LABEL_H3);
		horizontalLayout.addComponent(textOrderHistory);

		Button ButtonHistory = new Button("Order history", this);
		horizontalLayout.addComponent(ButtonHistory);
		horizontalLayout.setComponentAlignment(ButtonHistory, Alignment.MIDDLE_LEFT);
		
		orderedLayout.addComponent(horizontalLayout);
		
		
		//Another HorizontalLayout to set a text and a botton
		HorizontalLayout horizontalLayout1 = new HorizontalLayout();

		Label textOrderAgain = new Label("Um eine neue Bestellung aufzugeben drücken Sie auf \"Order again\"");
		textOrderAgain.addStyleName(ValoTheme.LABEL_H3);
		horizontalLayout1.addComponent(textOrderAgain);

		Button OrderAgain = new Button("Order again", this);
		horizontalLayout1.addComponent(OrderAgain);
		horizontalLayout1.setComponentAlignment(OrderAgain, Alignment.MIDDLE_LEFT);
		
		orderedLayout.addComponent(horizontalLayout1);
		
		root.getlayout().addComponent(orderedLayout,1);

		setCompositionRoot(root);
	}

	List<OrderViewListener> listeners = new ArrayList<OrderViewListener>();

	public void addListener(OrderViewListener listener) {
		listeners.add(listener);
	}

	@Override
	public void buttonClick(ClickEvent event) {
		System.out.println(listeners.toString());
		for (OrderViewListener listener : listeners)
			listener.buttonClick(event.getButton().getCaption());
	}
}