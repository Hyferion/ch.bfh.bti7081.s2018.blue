package ch.bfh.bti7081.blue.PMS.model;

import ch.bfh.bti7081.blue.PMS.DB.DBConnector;


public class LoginViewModel {

	public LoginViewModel(){
	}

	public LoginAccount getLoginAccount() {
		return DBConnector.getDBConnector().getLoginAccount();
	}
	
	
	public void setLoginAccountUsername(String accountUsername) {
		DBConnector.getDBConnector().setAccountUsername(accountUsername);
	}
	
}
