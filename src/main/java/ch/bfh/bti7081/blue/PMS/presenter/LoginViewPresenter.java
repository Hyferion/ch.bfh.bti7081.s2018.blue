package ch.bfh.bti7081.blue.PMS.presenter;

import ch.bfh.bti7081.blue.PMS.view.*;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;

import ch.bfh.bti7081.blue.PMS.Util;
import ch.bfh.bti7081.blue.PMS.model.InformationModelController;
import ch.bfh.bti7081.blue.PMS.model.LoginAccount;
import ch.bfh.bti7081.blue.PMS.model.LoginViewModel;
import ch.bfh.bti7081.blue.PMS.model.OrderModel;
import ch.bfh.bti7081.blue.PMS.model.OrderStatus;
import ch.bfh.bti7081.blue.PMS.presenter.interfaces.LoginViewButtonClickListener;

import java.util.logging.Level;

public class LoginViewPresenter extends CustomComponent implements LoginViewButtonClickListener, View {

	private static final long serialVersionUID = 1082791095382801193L;

	private LoginViewModel loginViewModel;
	private LoginViewImpl loginViewImpl;
	private Navigator navigator;
	private boolean passwordMatched;
	private boolean userMatched;
	private String username;
	private String firstname;
	private String lastname;
	private UI ui = UI.getCurrent();
	
	public LoginViewPresenter(LoginViewModel loginViewModel, LoginViewImpl loginViewImpl, Navigator navigator) {
		this.loginViewModel = loginViewModel;
		this.loginViewImpl = loginViewImpl;
		this.navigator = navigator;
		loginViewImpl.addListener(this);
	}

	public void loginButtonClick() {
		if (validateLogin()) {
			username = loginViewModel.getLoginAccount().getUsername();
			firstname = loginViewModel.getLoginAccount().getFirstName();
			lastname = loginViewModel.getLoginAccount().getLastName();
			ui.getSession().setAttribute("user", username);
			ui.getSession().setAttribute("firstname", firstname);
			ui.getSession().setAttribute("lastname", lastname);
			initializeViewsAfterLogin();
			navigator.navigateTo("HomeView");
		}
	}

	@Override
	public boolean validateLogin() {
		try {
			loginViewModel.setLoginAccountUsername(loginViewImpl.getLoginName());
			LoginAccount loginAccount = loginViewModel.getLoginAccount();

			passwordMatched = Util.validatePassword(loginAccount, loginViewImpl.getLoginPassword());

			System.out.println(passwordMatched);

			userMatched = Util.validateUsername(loginAccount, loginViewImpl.getLoginName());
			if (userMatched && passwordMatched) {
				return true;
			}
		} catch (NullPointerException e) {
			Notification.show("Username or password wrong", "try again", Notification.Type.WARNING_MESSAGE);
		}
		return false;
	}

	@Override
	public void enter(ViewChangeListener.ViewChangeEvent event) {

	}

	public void initializeViewsAfterLogin() {
		
		
		//HomeView
		MainViewImp view = new MainViewImp();
		navigator.addView("HomeView", view);
		
		//Information View
		InformationView InformationImp = new InformationView();
		InformationModelController InformationModel = new InformationModelController();
		new InformationControllerView(InformationModel, InformationImp);
		navigator.addView("InformationView", InformationImp);

		OrderStatusViewImp orderStatusImpl = new OrderStatusViewImp();
		OrderStatus orderStatus = new OrderStatus();
		new OrderStatusViewPresenter(orderStatus, orderStatusImpl);
		navigator.addView("Order", orderStatusImpl);

		//OrderView		
		OrderView orderView = new OrderView();
		OrderModel model = new OrderModel();
		new OrderPresenter(model, orderView);
		navigator.addView("OrderView", orderView);
		
		//OrderedView
		OrderedView orderedView = new OrderedView();
		new OrderedPresenter(model, orderedView);
		navigator.addView("OrderedView", orderedView);

		//ChatView
		ChatBox chatBox = new ChatBox();
		navigator.addView("Chat",chatBox);

		//ChatRoomView
		ChatRoomImpl chatRoom = new ChatRoomImpl();
		navigator.addView("ChatRoom",chatRoom);

		//CalendarView
		CalendarViewImpl calendarView = new CalendarViewImpl();
		new CalendarPresenter(calendarView);
		navigator.addView("CalendarView", calendarView);
		
		

	}

}