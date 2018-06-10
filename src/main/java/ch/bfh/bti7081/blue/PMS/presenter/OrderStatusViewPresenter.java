package ch.bfh.bti7081.blue.PMS.presenter;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.vaadin.server.FileDownloader;
import com.vaadin.server.FileResource;
import com.vaadin.server.Resource;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.UI;

import ch.bfh.bti7081.blue.PMS.model.File;
import ch.bfh.bti7081.blue.PMS.model.OrderModel;
import ch.bfh.bti7081.blue.PMS.model.OrderStatus;
import ch.bfh.bti7081.blue.PMS.view.OrderStatusViewImp;

public class OrderStatusViewPresenter extends CustomComponent implements OrderStatusViewImp.OrderViewListener {

	private OrderStatus model;
	private OrderStatusViewImp view;
	private EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("relativeHelper");
	final EntityManager em = emFactory.createEntityManager();

	public OrderStatusViewPresenter(OrderStatus model, OrderStatusViewImp view) {
		this.model = model;
		this.view = view;
		view.addListener(this);

	}

	@Override
	public void buttonClick(String operation) {
		if (operation.equals("Neue Bestellung")) {
			view.getUI().getNavigator().navigateTo("OrderView");
		}

		/*if (operation.equals("Print")) {
			Resource res = new FileResource(new File("C:\\Users\\Lars_Gertsch\\git\\ch.bfh.bti7081.s2018.blue\\file.pdf"));
			FileDownloader fd = new FileDownloader(res);
			//fd.extend(button);
		}*/

	}

	@Override
	public EntityManager getQuery() {
		return em;
	}

	@Override
	public List<OrderModel> getResultList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderStatus> getResultListStatus() {
		List<OrderStatus> orderStatus = new ArrayList<OrderStatus>();
		Query q = em.createQuery("Select t FROM OrderStatus t where t.LOGINACCOUNT_USERNAME = "
				+ UI.getCurrent().getSession().getAttribute("user").toString());
		orderStatus = q.getResultList();
		return orderStatus;
	}

}
