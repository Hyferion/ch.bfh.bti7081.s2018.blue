package ch.bfh.bti7081.blue.PMS.view;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.itextpdf.text.DocumentException;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.FileDownloader;
import com.vaadin.server.FileResource;
import com.vaadin.server.Resource;
import com.vaadin.shared.data.sort.SortDirection;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Grid;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

import ch.bfh.bti7081.blue.PMS.model.GeneratePDF;
import ch.bfh.bti7081.blue.PMS.model.OrderStatus;
import ch.bfh.bti7081.blue.PMS.view.interfaces.OrderStatusInterface;

public class OrderStatusViewImp extends CustomComponent implements OrderStatusInterface, ClickListener {

	private static final long serialVersionUID = 5138985064356953846L;
	VerticalLayout mainLayout = new VerticalLayout();
	Grid<OrderStatus> grid = new Grid<>();

	public OrderStatusViewImp() {

		// Set root Layout with title
		HeaderFooter root = new HeaderFooter("Bestellstatus");

		// MainLayout for this view
		mainLayout.setSizeFull(); // mainLayout

		Button order = new Button("Neue Bestellung", this);
		mainLayout.addComponent(order);

		// Add mainLayout to the root View
		root.getlayout().addComponent(mainLayout, 1);

		setCompositionRoot(root);

	}

	List<OrderStatusListener> listeners = new ArrayList<OrderStatusListener>();
	public void addListener(OrderStatusListener listener) {
		listeners.add(listener);
	}

	//crates a Button to every status that is "Verfübgar" and
	//creates a PDF for every prescription
	private Button printButton(OrderStatus p) {
		if ((p.getStatus().equals("Verfügbar"))) {
			Button button = new Button("Print", this);
			button.setIcon(VaadinIcons.PRINT);
			button.addStyleName(ValoTheme.BUTTON_SMALL);
			try {
				GeneratePDF.pfdGenerator(p.getId(), UI.getCurrent().getSession().getAttribute("firstname").toString() + " " + UI.getCurrent().getSession().getAttribute("lastname").toString(), p.getDate(), p.getName());
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Resource res = new FileResource(new File("C:\\Users\\Lars Gertsch\\git\\ch.bfh.bti7081.s2018.blue\\"+ p.getId().toString() + ".pdf"));
			
			FileDownloader fd = new FileDownloader(res);
			fd.extend(button);
			return button;
		}
		return null;

	}

	// creates every time a new grid when entered the view
	public void enter(ViewChangeListener.ViewChangeEvent event) {
		List<OrderStatus> orderStatus = new ArrayList<OrderStatus>();
		for (OrderStatusListener listener : listeners) {
			orderStatus = listener.getResultListStatus();
		}
		grid.removeAllColumns();
		grid.setSizeFull();
		grid.setItems(orderStatus);
		grid.addColumn(OrderStatus::getId).setId("1").setCaption("Bestellung").setResizable(false);
		grid.addColumn(OrderStatus::getName).setId("2").setCaption("Name").setResizable(false);
		grid.addColumn(OrderStatus::getDate).setId("3").setCaption("Datum").setResizable(false);
		grid.addColumn(OrderStatus::getStatus).setId("4").setCaption("Status").setResizable(false);
		grid.addComponentColumn(this::printButton).setCaption("Drucken").setResizable(false);
		grid.sort("3", SortDirection.DESCENDING);
		mainLayout.addComponent(grid);
	}

	@Override
	public void buttonClick(ClickEvent event) {
		for (OrderStatusListener listener : listeners) {
			listener.buttonClick(event.getButton().getCaption());
		}

	}
}