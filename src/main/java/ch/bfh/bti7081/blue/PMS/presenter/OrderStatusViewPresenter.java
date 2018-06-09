package ch.bfh.bti7081.blue.PMS.presenter;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.UI;

import ch.bfh.bti7081.blue.PMS.model.OrderModel;
import ch.bfh.bti7081.blue.PMS.model.OrderStatus;
import ch.bfh.bti7081.blue.PMS.view.OrderStatusViewImp;
import ch.bfh.bti7081.blue.PMS.view.OrderView;

public class OrderStatusViewPresenter extends CustomComponent implements OrderView.OrderViewListener {
	private OrderStatus orderStatus;
	private OrderStatusViewImp orderStatusViewImp;
	private EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("relativeHelper");
	final EntityManager em = emFactory.createEntityManager();

	public OrderStatusViewPresenter(OrderStatus model, OrderStatusViewImp view) {
		this.orderStatus = model;
		this.orderStatusViewImp = view;

	}

	@Override
	public void buttonClick(String operation) {
		System.out.println("test2");
		if (operation.equals("test")) {
			orderStatusViewImp.getUI().getNavigator().navigateTo("OrderView");
		}
		
	}

	@Override
	public EntityManager getQuery() {
		return em;
	}

	@Override
	public List<OrderStatus> getResultListStatus() {
		List<OrderStatus> orderStatus = new ArrayList<OrderStatus>();
		Query q = em.createQuery("Select t FROM OrderStatus t where t.LOGINACCOUNT_USERNAME = "
				+ UI.getCurrent().getSession().getAttribute("user").toString());
		orderStatus = q.getResultList();
		return orderStatus;
	}

	@Override
	public List<OrderModel> getResultList() {
		// TODO Auto-generated method stub
		return null;
	}
}
