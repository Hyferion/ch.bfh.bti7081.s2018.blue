package ch.bfh.bti7081.blue.PMS.view;

import java.io.File;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.server.FileDownloader;
import com.vaadin.server.FileResource;
import com.vaadin.server.Resource;
import com.vaadin.shared.data.sort.SortDirection;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Grid;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

import ch.bfh.bti7081.blue.PMS.DB.DBConnector;
import ch.bfh.bti7081.blue.PMS.model.OrderStatus;
import ch.bfh.bti7081.blue.PMS.model.OrderStatusModel;

public class OrderStatusViewImp extends CustomComponent implements View{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Grid<OrderStatus> grid;
	private OrderStatusViewImp orderStatusViewImp;

	public OrderStatusViewImp() {

		// Set root Layout with title
		HeaderFooter root = new HeaderFooter("Bestellstatus");

		// MainLayout for this view
		VerticalLayout mainLayout = new VerticalLayout();
		mainLayout.setSizeFull(); // mainLayout
		
		Button refresh = new Button("Refresh", a ->System.out.println(DBConnector.getDBConnector().getLoginAccount().getOrderStatus().toString()));
		mainLayout.addComponent(refresh);

		grid = new Grid<>();
		grid.setSizeFull();
		grid.addColumn(OrderStatus::getId).setId("1").setCaption("Bestellung").setResizable(false);
		grid.addColumn(OrderStatus::getDate).setId("2").setCaption("Datum").setResizable(false);
		grid.addColumn(OrderStatus::getStatus).setId("3").setCaption("Status").setResizable(false);
		grid.addComponentColumn(this::printButton);
		grid.sort("2", SortDirection.DESCENDING);
		mainLayout.addComponent(grid);

		// Add mainLayout to the root View
		root.getlayout().addComponent(mainLayout, 1);

		setCompositionRoot(root);

	}

	private Button printButton(OrderStatus p) {
		if ((p.getStatus().equals("Verfügbar"))) {
			Button button = new Button(VaadinIcons.PRINT);
			button.addStyleName(ValoTheme.BUTTON_SMALL);
			Resource res = new FileResource(new File("C:\\Users\\Lars Gertsch\\git\\ch.bfh.bti7081.s2018.blue\\file.pdf"));
			FileDownloader fd = new FileDownloader(res);
			fd.extend(button);
			return button;
		}
		return null;

	}

	public Grid<OrderStatus> getGrid() {
		return this.grid;
	}


}