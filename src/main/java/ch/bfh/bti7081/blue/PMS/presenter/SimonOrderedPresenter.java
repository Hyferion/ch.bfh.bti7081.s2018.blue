package ch.bfh.bti7081.blue.PMS.presenter;

import java.util.List;

import javax.persistence.EntityManager;

import com.vaadin.server.Resource;
import com.vaadin.ui.CustomComponent;

import ch.bfh.bti7081.blue.PMS.model.OrderModel;
import ch.bfh.bti7081.blue.PMS.model.OrderStatus;
import ch.bfh.bti7081.blue.PMS.view.OrderView;
import ch.bfh.bti7081.blue.PMS.view.OrderedView;

public class SimonOrderedPresenter extends CustomComponent implements OrderView.OrderViewListener {

	private OrderModel model;
	private OrderedView view;

	public SimonOrderedPresenter(OrderModel model, OrderedView view) {
		this.model = model;
		this.view = view;
		view.addListener(this);
	}

	public void buttonClick(String operation) {
		if (operation.equals("Order again")) {
			System.out.println("safddsfdsf");
			view.getUI().getNavigator().navigateTo("OrderView");

		}

		if (operation.equals("Order history")) {

			view.getUI().getNavigator().navigateTo("Order");
		}
	}

	@Override
	public EntityManager getQuery() {
		return null;
	}

	@Override
	public List<OrderModel> getResultList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderStatus> getResultListStatus() {
		// TODO Auto-generated method stub
		return null;
	}

}
