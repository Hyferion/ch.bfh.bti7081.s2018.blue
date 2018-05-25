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

	private Navigator navigator;
	ArrayList<CheckBox> checkBoxList = new ArrayList<CheckBox>();
	List<OrderViewListener> listeners = new ArrayList<OrderViewListener>();

	public SimonOrderView() {
		this.navigator = navigator;
		VerticalLayout mainLayout = new VerticalLayout(); // mainLayout

		Label text = new Label("Prescription Order"); // caption
		text.addStyleName(ValoTheme.LABEL_H1);
		mainLayout.addComponent(text);

		GridLayout GridLayout = new GridLayout(3, 5); // gridLayout for all
														// medicine
		mainLayout.addComponent(GridLayout);
		GridLayout.setSpacing(true);
		GridLayout.setSizeFull();

		Label captionFirstColumn = new Label("Medicine");
		captionFirstColumn.addStyleName(ValoTheme.LABEL_H2);
		GridLayout.addComponent(captionFirstColumn); 

		Label captionSecondColumn = new Label("Description");
		captionSecondColumn.addStyleName(ValoTheme.LABEL_H2);
		GridLayout.addComponent(captionSecondColumn);

		Label captionThirdColumn = new Label("Select");
		captionThirdColumn.addStyleName(ValoTheme.LABEL_H2);
		GridLayout.addComponent(captionThirdColumn);

		for (int i = 0; i < 5; i++) {
			GridLayout.addComponent(new Label("jajajaja"));
			GridLayout.addComponent(new Label("adasf"));
			checkBoxList.add(new CheckBox("", false));
			GridLayout.addComponent(checkBoxList.get(i));
		}

		HorizontalLayout horizontalLayout = new HorizontalLayout();
		horizontalLayout.setWidth("1500");
		horizontalLayout.setHeight("300");

		Button ButtonHistory = new Button("Order history", this);
		ButtonHistory.setHeight("80");
		ButtonHistory.setWidth("150");
		horizontalLayout.addComponent(ButtonHistory);
		horizontalLayout.setComponentAlignment(ButtonHistory, Alignment.BOTTOM_LEFT);

		Button ButtonSend = new Button("Send Order", this);
		ButtonSend.setHeight("150");
		ButtonSend.setWidth("150");
		horizontalLayout.addComponent(ButtonSend);
		horizontalLayout.setComponentAlignment(ButtonSend, Alignment.BOTTOM_RIGHT);

		mainLayout.addComponent(horizontalLayout);

		setCompositionRoot(mainLayout);

	}


	public void addListener(OrderViewListener listener) {
		listeners.add(listener);

	}

	@Override
	public void buttonClick(ClickEvent event) {
		for (OrderViewListener listener : listeners)
			listener.buttonClick(event.getButton().getCaption(), navigator, checkBoxList);
	}

}