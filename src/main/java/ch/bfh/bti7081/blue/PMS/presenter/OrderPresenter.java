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
import ch.bfh.bti7081.blue.PMS.view.OrderView;

public class OrderPresenter extends CustomComponent implements OrderView.OrderViewListener {

	private OrderModel model;
	private OrderView view;
	private EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("relativeHelper");
	final EntityManager em = emFactory.createEntityManager();
	

	public OrderPresenter(OrderModel model, OrderView view) {
		this.model = model;
		this.view = view;
		view.addListener(this);
	}

	public void buttonClick(String operation) {
		if (operation.equals("Send Order")) {
			view.ask();
		}
		if (operation.equals("Order")) {
			view.getUI().getNavigator().navigateTo("OrderedView");
			view.writeInDb(em);
			view.closeSub();
		}
		if (operation.equals("Cancel")) {
			view.closeSub();
		}
		if (operation.equals("Return")) {
			view.closeSub();
		}
		if (operation.equals("Order history")) {
			view.getUI().getNavigator().navigateTo("Order");
		}
	}

	public EntityManager getQuery() {
		return em;
	}
	
	public List<OrderModel> getResultList(){
		List<OrderModel> orderModel = new ArrayList<OrderModel>();
		Query q = em.createQuery("Select t FROM OrderModel t where t.LOGINACCOUNT_USERNAME =:name");
		q.setParameter("name", UI.getCurrent().getSession().getAttribute("user").toString()); 
		orderModel = q.getResultList();
		return orderModel;
	}

	@Override
	public List<OrderStatus> getResultListStatus() {
		// TODO Auto-generated method stub
		return null;
	}

}
