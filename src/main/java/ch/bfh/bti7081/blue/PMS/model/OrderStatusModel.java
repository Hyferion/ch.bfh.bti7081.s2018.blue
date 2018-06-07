package ch.bfh.bti7081.blue.PMS.model;

import java.util.HashSet;
import java.util.Set;

import ch.bfh.bti7081.blue.PMS.DB.DBConnector;

public class OrderStatusModel {
private Set<OrderStatus> OrderStatus;
	
	public OrderStatusModel(){
		OrderStatus = new HashSet<>();
		DBConnector dbConnector = DBConnector.getDBConnector();
		LoginAccount loginAccount = dbConnector.getLoginAccount();
		
		for (OrderStatus contact : loginAccount.getOrderStatus()) {
			OrderStatus.add(contact);
		}
	}

	public Set<OrderStatus> getOrder() {
		return this.OrderStatus;
	}
}
