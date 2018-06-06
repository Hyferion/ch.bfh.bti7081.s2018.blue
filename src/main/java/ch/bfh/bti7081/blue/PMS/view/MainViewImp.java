package ch.bfh.bti7081.blue.PMS.view;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.UI;
import com.vaadin.ui.themes.ValoTheme;

public class MainViewImp extends CustomComponent implements View {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	
	public MainViewImp() {

		HeaderFooter root = new HeaderFooter("Hello" + " " + UI.getCurrent().getSession().getAttribute("firstname").toString());
		

		setSizeFull();

		HorizontalLayout horizontalLayout = new HorizontalLayout();
		horizontalLayout.setWidth("1400");
		
		Button butBest = new Button("Bestellungen", e -> getUI().getNavigator().navigateTo("OrderView"));
		Button butChat = new Button("Chat", e -> getUI().getNavigator().navigateTo("Chat"));
		Button butKalender = new Button("Kalender");
		
		butBest.setIcon(VaadinIcons.FILE_TEXT);
		butBest.addStyleName(ValoTheme.BUTTON_HUGE);
		butBest.setWidth("300");
		butBest.setHeight("200");
		butChat.setIcon(VaadinIcons.CHAT);
		butChat.addStyleName(ValoTheme.BUTTON_HUGE);
		butChat.setWidth("300");
		butChat.setHeight("200");
		butKalender.setIcon(VaadinIcons.CALENDAR);
		butKalender.addStyleName(ValoTheme.BUTTON_HUGE);
		butKalender.setWidth("300");
		butKalender.setHeight("200");

		
		horizontalLayout.addComponent(butBest);
		horizontalLayout.addComponent(butChat);
		horizontalLayout.addComponent(butKalender);
		
		horizontalLayout.setComponentAlignment(butBest, Alignment.MIDDLE_CENTER);
		horizontalLayout.setComponentAlignment(butChat, Alignment.MIDDLE_CENTER);
		horizontalLayout.setComponentAlignment(butKalender, Alignment.MIDDLE_CENTER);

		root.getlayout().addComponent(horizontalLayout, 1);
		root.getlayout().setComponentAlignment(horizontalLayout, Alignment.MIDDLE_CENTER);

		setCompositionRoot(root);
	}

}
