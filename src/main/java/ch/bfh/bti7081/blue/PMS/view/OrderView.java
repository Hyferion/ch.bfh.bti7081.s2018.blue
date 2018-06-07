package ch.bfh.bti7081.blue.PMS.view;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.eclipse.persistence.internal.libraries.asm.commons.GeneratorAdapter;

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

	private EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("relativeHelper");
	private EntityManager em = emFactory.createEntityManager();
	List<OrderModel> orderModel = new ArrayList<OrderModel>();
	ArrayList<CheckBox> checkBoxList = new ArrayList<CheckBox>();
	List<OrderViewListener> listeners = new ArrayList<OrderViewListener>();
	HeaderFooter root = new HeaderFooter("Order prescription");
	VerticalLayout mainLayout = new VerticalLayout();
	Window subWindow = new Window("Order");
	OrderStatus orderstatus = new OrderStatus();

	public OrderView() {

		// Set root Layout with title

		// MainLayout for this view
		VerticalLayout mainLayout = new VerticalLayout();
		mainLayout.setSizeFull(); // mainLayout

		// GridLayout to dispaly all the medicine with a Checkbox to select a
		// certain medicine
		GridLayout GridLayout = new GridLayout(3, 5);
		mainLayout.addComponent(GridLayout);
		GridLayout.setSpacing(true);
		GridLayout.setSizeFull();

		Query q = em.createQuery("Select t FROM OrderModel t where t.LOGINACCOUNT_USERNAME = "
				+ UI.getCurrent().getSession().getAttribute("user").toString());
		orderModel = q.getResultList();

		// Captions for the table
		Label captionFirstColumn = new Label("Medicine");
		captionFirstColumn.addStyleName(ValoTheme.LABEL_H2);
		GridLayout.addComponent(captionFirstColumn);

		Label captionSecondColumn = new Label("Description");
		captionSecondColumn.addStyleName(ValoTheme.LABEL_H2);
		GridLayout.addComponent(captionSecondColumn);

		Label captionThirdColumn = new Label("Select");
		captionThirdColumn.addStyleName(ValoTheme.LABEL_H2);
		GridLayout.addComponent(captionThirdColumn);

		int i = 0;
		for (OrderModel mod : orderModel) {
			GridLayout.addComponent(new Label(mod.getName()));
			GridLayout.addComponent(new Label(mod.getDescription()));
			checkBoxList.add(new CheckBox("", false));
			GridLayout.addComponent(checkBoxList.get(i++));
		}

		// HorizontalLayout for the Buttons "Order history" and "Send order"
		HorizontalLayout horizontalLayout = new HorizontalLayout();
		horizontalLayout.setSizeFull();

		Button ButtonHistory = new Button("Order history", this);
		ButtonHistory.setHeight("80");
		ButtonHistory.setWidth("150");
		horizontalLayout.addComponent(ButtonHistory);
		horizontalLayout.setComponentAlignment(ButtonHistory, Alignment.TOP_LEFT);

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

	public void writeInDb() {

		for (CheckBox checkbox : checkBoxList) {
			if (checkbox.getValue() == true) {
				OrderStatus orderModelWrite = new OrderStatus();
				em.getTransaction().begin();
				orderModelWrite.setLOGINACCOUNT_USERNAME(UI.getCurrent().getSession().getAttribute("user").toString());
				orderModelWrite.setName(orderModel.get(checkbox.getTabIndex()).getName());
				orderModelWrite.setDate(new Date().toLocaleString());
				orderModelWrite.setStatus("Verfügbar");
				em.persist(orderModelWrite);
				em.getTransaction().commit();
				em.refresh(orderModelWrite);
			}
			checkbox.setValue(false);
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
	public void buttonClick(ClickEvent event) {

		for (OrderViewListener listener : listeners) {
			listener.buttonClick(event.getButton().getCaption());
		}
	}

}