package ch.bfh.bti7081.blue.PMS.view;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.FileDownloader;
import com.vaadin.server.FileResource;
import com.vaadin.server.Resource;
import com.vaadin.shared.data.sort.SortDirection;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Grid;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

import ch.bfh.bti7081.blue.PMS.model.OrderStatus;

public class OrderStatusViewImp extends CustomComponent implements View{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("relativeHelper");
	private EntityManager em = emFactory.createEntityManager();
	List<OrderStatus> orderStatus = new ArrayList<OrderStatus>();
	VerticalLayout mainLayout = new VerticalLayout();
	Grid<OrderStatus> grid = new Grid<>();
	

	public OrderStatusViewImp() {

		// Set root Layout with title
		HeaderFooter root = new HeaderFooter("Bestellstatus");

		// MainLayout for this view
		mainLayout.setSizeFull(); // mainLayout
		
		Button order = new Button("Neue Bestellung", a -> getUI().getNavigator().navigateTo("OrderView"));
		mainLayout.addComponent(order);

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
	
	public void enter(ViewChangeListener.ViewChangeEvent event) {
		System.out.println("hallo");

		Query q = em.createQuery("Select t FROM OrderStatus t where t.LOGINACCOUNT_USERNAME = "
				+ UI.getCurrent().getSession().getAttribute("user").toString());
		orderStatus = q.getResultList();
		
		grid.removeAllColumns();
		grid.setSizeFull();
		grid.setItems(orderStatus);
		grid.addColumn(OrderStatus::getId).setId("1").setCaption("Bestellung").setResizable(false);
		grid.addColumn(OrderStatus::getName).setId("2").setCaption("Name").setResizable(false);
		grid.addColumn(OrderStatus::getDate).setId("3").setCaption("Datum").setResizable(false);
		grid.addColumn(OrderStatus::getStatus).setId("4").setCaption("Status").setResizable(false);
		grid.addComponentColumn(this::printButton);
		grid.sort("2", SortDirection.DESCENDING);
		mainLayout.addComponent(grid);
	}
}