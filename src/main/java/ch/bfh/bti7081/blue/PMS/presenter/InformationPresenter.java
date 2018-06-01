package ch.bfh.bti7081.blue.PMS.presenter;

import com.vaadin.ui.CustomComponent;

import ch.bfh.bti7081.blue.PMS.model.InformationModel;
import ch.bfh.bti7081.blue.PMS.view.InformationView;

public class InformationPresenter extends CustomComponent {

	private static final long serialVersionUID = 3432756237761980839L;
	private InformationModel model;
	private InformationView view;

	public InformationPresenter(InformationModel model, InformationView view) {
		this.model = model;
		this.view = view; 
	}

} 
