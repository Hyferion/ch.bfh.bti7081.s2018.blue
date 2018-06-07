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
		
		for (OrderStatus orderstatus : loginAccount.getOrderStatus()) {
			OrderStatus.add(orderstatus);
		}
	}

	public Set<OrderStatus> getOrder() {
		return this.OrderStatus;
	}
}
