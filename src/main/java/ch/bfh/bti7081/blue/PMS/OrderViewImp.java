package ch.bfh.bti7081.blue.PMS;

import java.util.Arrays;
import java.util.List;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

public class OrderViewImp  extends CustomComponent implements View{
	
	public OrderViewImp() {
		
		
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
		
		Label order = new Label("Bestellungen");
		order.addStyleName(ValoTheme.LABEL_H1);
		root.addComponent(order);
		root.setComponentAlignment(order, Alignment.TOP_LEFT);
		
		//Main
		// Have some data
		List<Order> orders = Arrays.asList(
		    new Order(1, "02.05.2018", "in Bearbeitung", ""),
		    new Order(2, "05.08.2017", "Verfügbar", "Drucken"),
		    new Order(3, "08.12.2015", "Verfügabr", "Drucken"),
		    new Order(4, "25.05.2012", "Verfügbar", "Drucken")	
			);

		
		Grid<Order> main = new Grid<>();
		main.setItems(orders);
		main.setSizeFull();
		main.addColumn(Order::getId).setCaption("Bestellung").setResizable(false);
		main.addColumn(Order::getDate).setCaption("Datum").setResizable(false);
		main.addColumn(Order::getStatus).setCaption("Status").setResizable(false);
		main.addColumn(Order::getStatus).setCaption("Drucken").setResizable(false);
		
		
		root.addComponent(main);
		
		// Footer
		HorizontalLayout footerBar = new HorizontalLayout();
		footerBar.setSizeFull();
		footerBar.setDefaultComponentAlignment(Alignment.TOP_CENTER);
		root.addComponent(footerBar);
		
		Label footer = new Label("Platzhalter Footer");
		footer.addStyleName(ValoTheme.LABEL_H1);
		footerBar.addComponent(footer);
		
		root.setExpandRatio(titleBar, 0.05f);
		root.setExpandRatio(order, 0.2f);
		root.setExpandRatio(main, 0.6f);
		root.setExpandRatio(footerBar, 0.15f);


	}

}
