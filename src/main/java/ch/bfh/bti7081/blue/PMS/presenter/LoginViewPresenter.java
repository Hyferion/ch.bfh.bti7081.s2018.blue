package ch.bfh.bti7081.blue.PMS.presenter;

import ch.bfh.bti7081.blue.PMS.model.*;
import ch.bfh.bti7081.blue.PMS.view.*;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;

import ch.bfh.bti7081.blue.PMS.Util;
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
			ui.getSession().setAttribute("user", username);
			ui.getSession().setAttribute("firstname", firstname);
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

		//OrderStatus View
		OrderStatusViewImp OrderStatusImpl = new OrderStatusViewImp();
		OrderStatusModel OrderStatusModel = new OrderStatusModel();
		new OrderStatusViewPresenter(OrderStatusModel, OrderStatusImpl);
		navigator.addView("Order", OrderStatusImpl);
				
		//OrderView		
		SimonOrderView orderView = new SimonOrderView();
		OrderModel model = new OrderModel();
		new SimonOrderPresenter(model, orderView);
		navigator.addView("OrderView", orderView);
		
		//OrderedView
		SimonOrderedView orderedView = new SimonOrderedView();
		new SimonOrderedPresenter(model, orderedView);
		navigator.addView("OrderedView", orderedView);

		//ChatView
		ChatBox chatBox = new ChatBox();
		navigator.addView("Chat",chatBox);

		//ChatRoomView
		ChatRoomImpl chatRoom = new ChatRoomImpl();
		navigator.addView("ChatRoom",chatRoom);

	
		
		

	}

}
