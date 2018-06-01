package ch.bfh.bti7081.blue.PMS.view;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.themes.ValoTheme;

import ch.bfh.bti7081.blue.PMS.model.OrderStatus;
import ch.bfh.bti7081.blue.PMS.view.interfaces.SimonOrderViewInterface;

public class HeaderFooter extends CustomComponent implements View {
	
	VerticalLayout root = new VerticalLayout();
	String titleName;

	public HeaderFooter(String titleName) {
		this.titleName = titleName;

		setSizeFull();

		root.setSizeFull();
		setCompositionRoot(root);

		// Header
		HorizontalLayout titleBar = new HorizontalLayout();
		titleBar.setSizeFull();
		root.addComponent(titleBar);
		titleBar.setHeight("100");
		

		Button home = new Button("Home", e -> getUI().getNavigator().navigateTo("HomeView"));
		home.setIcon(VaadinIcons.HOME);
		titleBar.addComponent(home);
		titleBar.setComponentAlignment(home, Alignment.TOP_LEFT);

		
		Label title = new Label(titleName);
		title.addStyleName(ValoTheme.LABEL_H1);
		title.setSizeUndefined();
		titleBar.addComponent(title);
		titleBar.setComponentAlignment(title, Alignment.TOP_CENTER);
		
		Button logout = new Button("Logout");
		logout.setIcon(VaadinIcons.HAND);		
		titleBar.addComponent(logout);
		titleBar.setComponentAlignment(logout, Alignment.TOP_RIGHT);

		logout.addClickListener(e -> logOutButtonClick()); 

		// Footer
		HorizontalLayout footerBar = new HorizontalLayout();
		footerBar.setSizeFull();
		footerBar.setDefaultComponentAlignment(Alignment.TOP_CENTER);
		root.addComponent(footerBar);



		/*Label footer = new Label("Platzhalter Footer");
		footer.addStyleName(ValoTheme.LABEL_H1);
		footerBar.addComponent(footer);
*/
	

		root.setExpandRatio(titleBar, 0.05f);
		root.setExpandRatio(footerBar, 0.15f);

	}

	public void logOutButtonClick() {
		getUI().getSession().setAttribute("user", null);
		getUI().getNavigator().navigateTo("LoginView");

	}

	public VerticalLayout getlayout(){
		return root;
	}
	
	
	public VerticalLayout SetTitle(){
		return root;
	}
	
	

}