package ch.bfh.bti7081.blue.PMS.presenter;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.UI;

import ch.bfh.bti7081.blue.PMS.model.OrderStatus;
import ch.bfh.bti7081.blue.PMS.view.OrderStatusViewImp;

public class OrderStatusViewPresenter extends CustomComponent implements OrderStatusViewImp.OrderStatusListener {

	private OrderStatus model;
	private OrderStatusViewImp view;
	private EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("relativeHelper");
	final EntityManager em = emFactory.createEntityManager();

	public OrderStatusViewPresenter(OrderStatus model, OrderStatusViewImp view) {
		this.model = model;
		this.view = view;
		view.addListener(this);

	}

	//navigates to the right view
	@Override
	public void buttonClick(String operation) {
		if (operation.equals("Neue Bestellung")) {
			view.getUI().getNavigator().navigateTo("OrderView");
		}
	}

	//gets data from DB
	@Override
	public List<OrderStatus> getResultListStatus() {
		List<OrderStatus> orderStatus = new ArrayList<OrderStatus>();
		Query q = em.createQuery("Select t FROM OrderStatus t where t.LOGINACCOUNT_USERNAME = "
				+ UI.getCurrent().getSession().getAttribute("user").toString());
		orderStatus = q.getResultList();
		return orderStatus;
	}
}
