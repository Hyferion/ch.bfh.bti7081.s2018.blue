package ch.bfh.bti7081.blue.PMS.presenter;

import com.vaadin.ui.CustomComponent;

import ch.bfh.bti7081.blue.PMS.view.MainViewImp;


public class MainViewPresenter extends CustomComponent implements MainViewImp.MainViewListener {

	private MainViewImp view;

	public MainViewPresenter(MainViewImp view) {
		this.view = view;
		view.addListener(this);

	}


	//navigates to the right view
	@Override
	public void buttonClick(String operation) {
		if (operation.equals("Addictions")) {
			view.getUI().getNavigator().navigateTo("InformationView");
		}
		if (operation.equals("Order")) {
			view.getUI().getNavigator().navigateTo("OrderView");
		}
		if (operation.equals("Chat Room")) {
			view.getUI().getNavigator().navigateTo("ChatRoom");
		}
		if (operation.equals("Calendar")) {
			view.getUI().getNavigator().navigateTo("CalendarView");
		}
	}
}
