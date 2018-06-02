package ch.bfh.bti7081.blue.PMS.view;

import com.vaadin.navigator.View;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.themes.ValoTheme;

public class MainViewImp extends CustomComponent implements View {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MainViewImp() {

		HeaderFooter root = new HeaderFooter("Hello ");

		setSizeFull();

		HorizontalLayout but = new HorizontalLayout();
		but.setSpacing(true);
		
		Button butBest = new Button("Bestellungen", e -> getUI().getNavigator().navigateTo("OrderView"));
		Button butChat = new Button("Chat", e -> getUI().getNavigator().navigateTo("Chat"));
		Button butInfo = new Button("Suchtkrankheiten", e -> getUI().getNavigator().navigateTo("InformationView"));
		Button butKalender = new Button("Kalender");
		
		
		butBest.addStyleName(ValoTheme.BUTTON_LARGE);
		butBest.setWidth("300");
		butBest.setHeight("200");
		butChat.addStyleName(ValoTheme.BUTTON_LARGE);
		butChat.setWidth("300");
		butChat.setHeight("200");
		butInfo.addStyleName(ValoTheme.BUTTON_LARGE);
		butInfo.setWidth("300");
		butInfo.setHeight("200");
		butKalender.addStyleName(ValoTheme.BUTTON_LARGE);
		butKalender.setWidth("300");
		butKalender.setHeight("200");

		
		but.addComponent(butBest);
		but.addComponent(butChat);
		but.addComponent(butInfo);
		but.addComponent(butKalender);

		but.setComponentAlignment(butBest, Alignment.MIDDLE_CENTER);
		but.setComponentAlignment(butChat, Alignment.MIDDLE_CENTER);
		but.setComponentAlignment(butInfo, Alignment.MIDDLE_CENTER);
		but.setComponentAlignment(butKalender, Alignment.MIDDLE_CENTER);

		root.getlayout().addComponent(but, 1);
		root.getlayout().setComponentAlignment(but, Alignment.MIDDLE_CENTER);

		setCompositionRoot(root);
	}

}
