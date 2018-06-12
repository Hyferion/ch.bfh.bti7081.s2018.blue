package ch.bfh.bti7081.blue.PMS.presenter;

import java.util.List;

import com.vaadin.navigator.View;
import com.vaadin.ui.CustomComponent;

import ch.bfh.bti7081.blue.PMS.DB.DBConnector;
import ch.bfh.bti7081.blue.PMS.model.Information;
import ch.bfh.bti7081.blue.PMS.model.InformationModelController;
import ch.bfh.bti7081.blue.PMS.view.InformationView;

/**
 * 
 * @author Sinthujah Kaneshan
 *
 */
public class InformationControllerView implements View {

	private static final long serialVersionUID = 3432756237761980839L;
	private InformationModelController informationModelController;
	private InformationView informationView;

	public InformationControllerView(InformationModelController model, InformationView view) {
		this.informationModelController = model;
		this.informationView = view;
	}

	public List<Information> getInfo() {
		return new InformationModelController().getInformations();
	}

}
