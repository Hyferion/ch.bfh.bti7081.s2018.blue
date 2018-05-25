package ch.bfh.bti7081.blue.PMS.view;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

public class MainViewImp extends CustomComponent implements View {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MainViewImp() {

		setSizeFull();

		// Set the root layout for the UI
		VerticalLayout root = new VerticalLayout();
		root.setSizeFull();
		setCompositionRoot(root);

		// Header
		HorizontalLayout titleBar = new HorizontalLayout();
		titleBar.setSizeFull();
		root.addComponent(titleBar);

		Button home = new Button("Home", e -> getUI().getNavigator().navigateTo("Home"));
		home.setIcon(VaadinIcons.HOME);
		titleBar.addComponent(home);
		titleBar.setComponentAlignment(home, Alignment.TOP_LEFT);

		Label title = new Label("Relative Helper");
		title.addStyleName(ValoTheme.LABEL_H1);
		title.setSizeUndefined();
		titleBar.addComponent(title);
		titleBar.setComponentAlignment(title, Alignment.TOP_LEFT);

		// Main
		
		HorizontalLayout but = new HorizontalLayout();
		
		Button butBest = new Button("Bestellungen",  e -> getUI().getNavigator().navigateTo("Order"));
		Button butChat = new Button("Chat");
		Button butKalender = new Button("Kander");
		Button logout = new Button("Logout_Bye", e -> logOutButtonClick());

		
		but.addComponent(butBest);
		but.addComponent(butChat);
		but.addComponent(butKalender);
		but.addComponent(logout);
		root.addComponent(but);
		

		// Footer
		HorizontalLayout footerBar = new HorizontalLayout();
		footerBar.setSizeFull();
		footerBar.setDefaultComponentAlignment(Alignment.TOP_CENTER);
		root.addComponent(footerBar);

		Label footer = new Label("Platzhalter Footer");
		footer.addStyleName(ValoTheme.LABEL_H1);
		footerBar.addComponent(footer);

		root.setExpandRatio(titleBar, 0.05f);
		root.setExpandRatio(but, 0.8f);
		root.setExpandRatio(footerBar, 0.15f);

	}

	public void logOutButtonClick() {
		getUI().getSession().setAttribute("user", null);
		getUI().getNavigator().navigateTo("LoginView");

	}

}
