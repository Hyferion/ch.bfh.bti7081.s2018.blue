package ch.bfh.bti7081.blue.PMS.view;

import java.io.File;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.server.FileDownloader;
import com.vaadin.server.FileResource;
import com.vaadin.server.Resource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

import ch.bfh.bti7081.blue.PMS.model.OrderStatus;

public class InformationViewImp extends CustomComponent implements View {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Grid<OrderStatus> grid;

	public InformationViewImp() {

		setSizeFull();

		// Set the root layout for the UI
		VerticalLayout root = new VerticalLayout();
		root.setSizeFull();
		setCompositionRoot(root);

		// Header
		HorizontalLayout titleBar = new HorizontalLayout();
		titleBar.setSizeFull();
		root.addComponent(titleBar);

		Button home = new Button("Home", e -> getUI().getNavigator().navigateTo("HomeView"));
		home.setIcon(VaadinIcons.HOME);
		titleBar.addComponent(home);
		titleBar.setComponentAlignment(home, Alignment.TOP_LEFT);

		titleBar.addComponent(home);
		titleBar.setComponentAlignment(home, Alignment.TOP_LEFT);

		Label title = new Label("Informationen über Suchtkrankheit");
		title.addStyleName(ValoTheme.LABEL_H1);
		title.setSizeUndefined();
		titleBar.addComponent(title);
		titleBar.setComponentAlignment(title, Alignment.TOP_LEFT);

		Label order = new Label("Suchtkrankheit");
		order.addStyleName(ValoTheme.LABEL_H1);
		root.addComponent(order);
		root.setComponentAlignment(order, Alignment.TOP_LEFT);

		// Main

		grid = new Grid<>();
		grid.setSizeFull();
		grid.addColumn(OrderStatus::getId).setCaption("Krankheit").setResizable(false);
		grid.addComponentColumn(this::printButton);
		root.addComponent(grid);

		// Footer
		HorizontalLayout footerBar = new HorizontalLayout();
		footerBar.setSizeFull();
		footerBar.setDefaultComponentAlignment(Alignment.TOP_CENTER);
		root.addComponent(footerBar);

		Button logout = new Button("Logout");
		logout.setIcon(VaadinIcons.HAND);

		logout.addClickListener(e -> logOutButtonClick());

		Label footer = new Label("Platzhalter Footer");
		footer.addStyleName(ValoTheme.LABEL_H1);
		footerBar.addComponent(footer);

		footerBar.addComponent(logout);

		root.setExpandRatio(titleBar, 0.05f);
		root.setExpandRatio(order, 0.2f);
		root.setExpandRatio(grid, 0.6f);
		root.setExpandRatio(footerBar, 0.15f);

	}

	private Button printButton(OrderStatus p) {
		System.out.println(p.getStatus());
		if ((p.getStatus().equals("Verfügbar"))) {
			Button button = new Button(VaadinIcons.PRINT);
			button.addStyleName(ValoTheme.BUTTON_SMALL);
			Resource res = new FileResource(new File("C:\\Workspaces\\workspace_SEAD\\myapplication\\file.pdf"));
			FileDownloader fd = new FileDownloader(res);
			fd.extend(button);
			return button;
		}
		return null;

	}

	public Grid getGrid() {
		return this.grid;
	}

	public void logOutButtonClick() {
		getUI().getSession().setAttribute("user", null);
		getUI().getNavigator().navigateTo("LoginView");

	}

}
