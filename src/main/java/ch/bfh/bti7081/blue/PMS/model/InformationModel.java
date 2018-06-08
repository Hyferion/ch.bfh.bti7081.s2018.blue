package ch.bfh.bti7081.blue.PMS.model;

import java.util.HashSet;
import java.util.Set;

import ch.bfh.bti7081.blue.PMS.DB.DBConnector;

public class InformationModel {
private Set<Information> Information;
	
	public InformationModel(){
		Information = new HashSet<>();
		DBConnector dbConnector = DBConnector.getDBConnector();
		LoginAccount loginAccount = dbConnector.getLoginAccount();
		
		//for (Information contact : loginAccount.getInformation()) {
		//	Information.add(contact);
		//}
		
		
	}

	public Set<Information> getInformation() {
		return this.Information;
	}
}