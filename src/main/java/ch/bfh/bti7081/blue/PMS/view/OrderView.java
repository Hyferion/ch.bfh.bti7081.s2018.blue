package ch.bfh.bti7081.blue.PMS.view;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;

import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.themes.ValoTheme;

import ch.bfh.bti7081.blue.PMS.model.OrderModel;
import ch.bfh.bti7081.blue.PMS.model.OrderStatus;
import ch.bfh.bti7081.blue.PMS.view.interfaces.OrderViewInterface;

public class OrderView extends CustomComponent implements OrderViewInterface, ClickListener {

	private static final long serialVersionUID = 3958839843793423943L;
	// ArrayList for all the checkboxes that the user can order certain
	// prescritpion
	ArrayList<CheckBox> checkBoxList = new ArrayList<CheckBox>();

	List<OrderViewListener> listeners = new ArrayList<OrderViewListener>();

	// new rootLayout that all views has the same head and footer.
	HeaderFooter root = new HeaderFooter("Order prescription");

	// The mainLayout of this view
	VerticalLayout mainLayout = new VerticalLayout();

	// SubWindows is used to ensure that the user really wants to order
	Window subWindow = new Window("Order");

	// In this GridLayout all the avaliable prescription will be displayed. 3
	// Columns. The First is for the name of the medicine. the second for a
	// description of the meidicin and the last one is for the checkbox
	GridLayout gridLayout = new GridLayout(3, 1);

	public OrderView() {

		// Add the girdLayout to the mainLayout. The grid layout is still empty
		// and will be filled when the user enters the view
		mainLayout.addComponent(gridLayout);
		mainLayout.setSizeFull();

		gridLayout.setSpacing(true);
		gridLayout.setSizeFull();

		// HorizontalLayout for the Buttons "Order history" and "Send order"
		HorizontalLayout horizontalLayout = new HorizontalLayout();
		horizontalLayout.setSizeFull();

		// create new Button Order history
		Button ButtonHistory = new Button("Order history", this);
		ButtonHistory.setHeight("80");
		ButtonHistory.setWidth("150");
		horizontalLayout.addComponent(ButtonHistory);
		horizontalLayout.setComponentAlignment(ButtonHistory, Alignment.TOP_LEFT);

		// create new Button SendOrder
		Button ButtonSend = new Button("Send Order", this);
		ButtonSend.setHeight("120");
		ButtonSend.setWidth("150");
		horizontalLayout.addComponent(ButtonSend);
		horizontalLayout.setComponentAlignment(ButtonSend, Alignment.TOP_RIGHT);

		// Add horziontalLayout to the mainLayout
		mainLayout.addComponent(horizontalLayout);

		// Add mainLayout to the root View
		root.getlayout().addComponent(mainLayout, 1);

		setCompositionRoot(root);
	}

	public void addListener(OrderViewListener listener) {
		listeners.add(listener);

	}

	// this method is used to write all the orders in the db. each prescirption
	// order gets a new line in the orderstatus db.
	public void writeInDb(EntityManager em) {

		List<OrderModel> orderModel = new ArrayList<OrderModel>();
		for (OrderViewListener listener : listeners) {
			orderModel = listener.getResultList();

			int i = 0;
			for (CheckBox checkbox : checkBoxList) {
				if (checkbox.getValue() == true) {
					OrderStatus orderModelWrite = new OrderStatus();
					em.getTransaction().begin();
					orderModelWrite
							.setLOGINACCOUNT_USERNAME(UI.getCurrent().getSession().getAttribute("user").toString());
					orderModelWrite.setName(orderModel.get(i).getName());
					orderModelWrite.setDate(new Date().toLocaleString());
					String[] status = {"Verfügbar", "Verfügbar", "In Bearbeitung", "Abgelehnt", "Verfügbar"};
			         Random random = new Random();
			         int select = random.nextInt(status.length); 
					orderModelWrite.setStatus(status[select]);
					em.persist(orderModelWrite);
					em.getTransaction().commit();
					em.refresh(orderModelWrite);
					i++;
				}
				checkbox.setValue(false);
			}
		}

	}

	public void ask() {

		VerticalLayout verticalLayout = new VerticalLayout();
		HorizontalLayout horizontalLayout = new HorizontalLayout();
		verticalLayout.setSizeFull();
		horizontalLayout.setSizeFull();

		Button cancel = new Button("Cancel", this);
		Button order = new Button("Order", this);
		order.setSizeFull();
		Label ensure = new Label("Are you sure you want to order?");

		horizontalLayout.addComponents(cancel, order);
		verticalLayout.addComponents(ensure, horizontalLayout);
		verticalLayout.setComponentAlignment(ensure, Alignment.TOP_CENTER);
		horizontalLayout.setComponentAlignment(cancel, Alignment.BOTTOM_LEFT);

		subWindow.setResizable(false);
		subWindow.center();
		subWindow.setWidth("500");
		subWindow.setHeight("200");
		subWindow.setContent(verticalLayout);

		UI.getCurrent().addWindow(subWindow);

	}

	public void closeSub() {
		subWindow.close();

	}

	@Override
	public void enter(ViewChangeEvent event) {
		gridLayout.removeAllComponents();
		List<OrderModel> orderModel = new ArrayList<OrderModel>();
		for (OrderViewListener listener : listeners) {
			orderModel = listener.getResultList();
		}

		// Captions for the table
		Label captionFirstColumn = new Label("Medicine");
		captionFirstColumn.addStyleName(ValoTheme.LABEL_H2);
		gridLayout.addComponent(captionFirstColumn);

		Label captionSecondColumn = new Label("Description");
		captionSecondColumn.addStyleName(ValoTheme.LABEL_H2);
		gridLayout.addComponent(captionSecondColumn);

		Label captionThirdColumn = new Label("Select");
		captionThirdColumn.addStyleName(ValoTheme.LABEL_H2);
		gridLayout.addComponent(captionThirdColumn);

		int i = 0;
		for (OrderModel mod : orderModel) {
			gridLayout.addComponent(new Label(mod.getName()));
			gridLayout.addComponent(new Label(mod.getDescription()));
			checkBoxList.add(new CheckBox("", false));
			gridLayout.addComponent(checkBoxList.get(i++));
		}
	}

	@Override
	public void buttonClick(ClickEvent event) {

		for (OrderViewListener listener : listeners) {
			listener.buttonClick(event.getButton().getCaption());
		}
	}
}