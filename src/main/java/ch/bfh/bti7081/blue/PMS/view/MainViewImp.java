package ch.bfh.bti7081.blue.PMS.view;

import com.vaadin.navigator.View;
import com.vaadin.server.ClassResource;
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
		
		Button butInfo = new Button("Suchtkrankheiten", e -> getUI().getNavigator().navigateTo("InformationView"));
		Button butBest = new Button("", e -> getUI().getNavigator().navigateTo("OrderView"));
		butBest.setIcon(new ClassResource("/icons/shopping-bag.png"));
		Button butChat = new Button("", e -> getUI().getNavigator().navigateTo("ChatRoom"));
		butChat.setIcon(new ClassResource("/icons/chat.png"));
		Button butKalender = new Button("");
		butKalender.setIcon(new ClassResource("/icons/calendar.png"));
		
		butBest.setIcon(VaadinIcons.FILE_TEXT);
		butBest.addStyleName(ValoTheme.BUTTON_HUGE);
		butBest.setWidth("300");
		butBest.setHeight("200");
		butChat.setIcon(VaadinIcons.CHAT);
		butChat.addStyleName(ValoTheme.BUTTON_HUGE);
		butChat.setWidth("300");
		butChat.setHeight("200");
    
		butInfo.addStyleName(ValoTheme.BUTTON_LARGE);
		butInfo.setWidth("300");
		butInfo.setHeight("200");
		butKalender.addStyleName(ValoTheme.BUTTON_LARGE);

		butKalender.setIcon(VaadinIcons.CALENDAR);
		butKalender.setWidth("300");
		butKalender.setHeight("200");

		
		horizontalLayout.addComponent(butBest);
		horizontalLayout.addComponent(butChat);
		horizontalLayout.addComponent(butKalender);
    horizontalLayout.addComponent(butInfo);
    
		horizontalLayout.setComponentAlignment(butInfo, Alignment.MIDDLE_CENTER);
		horizontalLayout.setComponentAlignment(butBest, Alignment.MIDDLE_CENTER);
		horizontalLayout.setComponentAlignment(butChat, Alignment.MIDDLE_CENTER);
		horizontalLayout.setComponentAlignment(butKalender, Alignment.MIDDLE_CENTER);


		root.getlayout().addComponent(horizontalLayout, 1);
		root.getlayout().setComponentAlignment(horizontalLayout, Alignment.MIDDLE_CENTER);

		setCompositionRoot(root);
	}

}
