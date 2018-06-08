package ch.bfh.bti7081.blue.PMS.presenter;

import com.vaadin.navigator.View;
import com.vaadin.ui.CustomComponent;

import ch.bfh.bti7081.blue.PMS.DB.DBConnector;
import ch.bfh.bti7081.blue.PMS.model.InformationModel;
import ch.bfh.bti7081.blue.PMS.view.InformationViewImp;

public class InformationPresenter implements View {

	private static final long serialVersionUID = 3432756237761980839L;
	private InformationModel informationModel;
	private InformationViewImp informationViewImp;

	public InformationPresenter(InformationModel model, InformationViewImp view) {
		this.informationModel = model;
		this.informationViewImp = view; 
	}
	
//	@SuppressWarnings("unchecked")
	//public void initializeInformations() {
//		informationViewImp.getGrid().setItems(DBConnector.getDBConnector().getLoginAccount().getInformation());
	//}

} 

