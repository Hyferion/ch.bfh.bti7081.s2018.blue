package ch.bfh.bti7081.blue.PMS.view;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.navigator.Navigator;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

import ch.bfh.bti7081.blue.PMS.view.interfaces.SimonOrderViewInterface;

public class SimonOrderView extends CustomComponent implements SimonOrderViewInterface, ClickListener {

	private static final long serialVersionUID = 3958839843793423943L;

	ArrayList<CheckBox> checkBoxList = new ArrayList<CheckBox>();
	List<OrderViewListener> listeners = new ArrayList<OrderViewListener>();

	public SimonOrderView() {

		//Set root Layout with title
		HeaderFooter root = new HeaderFooter("Order prescription"); 

		//MainLayout for this view
		VerticalLayout mainLayout = new VerticalLayout();
		mainLayout.setSizeFull(); // mainLayout
		
		//GridLayout to dispaly all the medicine with a Checkbox to select a certain medicine
		GridLayout GridLayout = new GridLayout(3, 5); 
		mainLayout.addComponent(GridLayout);
		GridLayout.setSpacing(true);
		GridLayout.setSizeFull();
		
		//Captions for the table
		Label captionFirstColumn = new Label("Medicine");
		captionFirstColumn.addStyleName(ValoTheme.LABEL_H2);
		GridLayout.addComponent(captionFirstColumn);

		Label captionSecondColumn = new Label("Description");
		captionSecondColumn.addStyleName(ValoTheme.LABEL_H2);
		GridLayout.addComponent(captionSecondColumn);

		Label captionThirdColumn = new Label("Select");
		captionThirdColumn.addStyleName(ValoTheme.LABEL_H2);
		GridLayout.addComponent(captionThirdColumn);

		//Fill the table with informations from the database
		for (int i = 0; i < 5; i++) {
			GridLayout.addComponent(new Label("jajajaja"));
			GridLayout.addComponent(new Label("adasf"));
			checkBoxList.add(new CheckBox("", false));
			GridLayout.addComponent(checkBoxList.get(i));
		}
		
		
		//HorizontalLayout for the Buttons "Order history" and "Send order"
		HorizontalLayout horizontalLayout = new HorizontalLayout();
		horizontalLayout.setSizeFull();

		Button ButtonHistory = new Button("Order history", this);
		ButtonHistory.setHeight("80");
		ButtonHistory.setWidth("150");
		horizontalLayout.addComponent(ButtonHistory);
		horizontalLayout.setComponentAlignment(ButtonHistory, Alignment.TOP_LEFT);

		Button ButtonSend = new Button("Send Order", this);
		ButtonSend.setHeight("120");
		ButtonSend.setWidth("150");
		horizontalLayout.addComponent(ButtonSend);
		horizontalLayout.setComponentAlignment(ButtonSend, Alignment.TOP_RIGHT);

		//Add horziontalLayout to the mainLayout
		mainLayout.addComponent(horizontalLayout);
		
		//Add mainLayout to the root View
		root.getlayout().addComponent(mainLayout, 1);

		setCompositionRoot(root);
	}

	public void addListener(OrderViewListener listener) {
		listeners.add(listener);

	}

	@Override
	public void buttonClick(ClickEvent event) {
		for (OrderViewListener listener : listeners)
			listener.buttonClick(event.getButton().getCaption());
	}
}