package ch.bfh.bti7081.blue.PMS;

import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.Label;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;

import Blue.Startsite.NavigationUI;

public class MainView extends VerticalLayout implements View {
	
	public static final String NAME = "main";
	
	private NavigationUI navigation;
	
	public MainView() {
		setMargin(true);
		
		Label welcom = new Label("<h1>Willkommen auf XXX</h1>");
		welcom.setContentMode(ContentMode.HTML);
		
		Label welcomText = new Label("Bitte wählen Sie XXX aus.");
		welcomText.setContentMode(ContentMode.HTML);
		
		Label chat = new Label("Chat");
		chat.setContentMode(ContentMode.HTML);
		
		Label calender = new Label("Terminkalender");
		calender.setContentMode(ContentMode.HTML);
		
		addComponent(welcom);
		addComponent(welcomText);
		addComponent(chat);
		addComponent(calender);
		
		@Override
		public void enter(ViewChangeListener.ViewChangeEvent event) {
			
		}
	}

}
