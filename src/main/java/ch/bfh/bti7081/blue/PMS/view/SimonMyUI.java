/*package ch.bfh.bti7081.blue.PMS.view;

import ch.bfh.bti7081.blue.PMS.model.SimonOrderModel;
import ch.bfh.bti7081.blue.PMS.presenter.SimonOrderPresenter;
import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;

/**
 * This UI is the application entry point. A UI may either represent a browser
 * window (or tab) or some part of an HTML page where a Vaadin application is
 * embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is
 * intended to be overridden to add component to the user interface and
 * initialize non-component functionality.
 */
/*
@Theme("mytheme")
public class SimonMyUI extends UI {
	/**
	 * 
	 */
/*
	private static final long serialVersionUID = 1L;
	Navigator navigator;

	@Override
	protected void init(VaadinRequest vaadinRequest) {
		navigator = new Navigator(this, this);
		SimonOrderModel model = new SimonOrderModel();
		SimonOrderView orderView = new SimonOrderView(navigator);
		SimonOrderedView orderedView = new SimonOrderedView(navigator);
		//LarsOrderViewImp larsView = new LarsOrderViewImp(navigator);

		navigator.addView("orderView", orderView);
		navigator.addView("orderedView", orderedView);
		//navigator.addView("Lars View", larsView);
		navigator.navigateTo("orderView");
		
		new SimonOrderPresenter(model, orderView);
	
		setContent(orderView);

	}
}*/
