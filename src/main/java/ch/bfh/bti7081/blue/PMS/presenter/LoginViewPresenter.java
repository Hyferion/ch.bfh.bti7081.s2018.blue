package ch.bfh.bti7081.blue.PMS.presenter;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;

import ch.bfh.bti7081.blue.PMS.Util;
import ch.bfh.bti7081.blue.PMS.model.LoginAccount;
import ch.bfh.bti7081.blue.PMS.model.LoginViewModel;
import ch.bfh.bti7081.blue.PMS.model.OrderStatusModel;
import ch.bfh.bti7081.blue.PMS.model.SimonOrderModel;
import ch.bfh.bti7081.blue.PMS.presenter.interfaces.LoginViewButtonClickListener;
import ch.bfh.bti7081.blue.PMS.view.LoginViewImpl;
import ch.bfh.bti7081.blue.PMS.view.MainViewImp;
import ch.bfh.bti7081.blue.PMS.view.OrderStatusViewImp;
import ch.bfh.bti7081.blue.PMS.view.SimonOrderView;

public class LoginViewPresenter extends CustomComponent implements LoginViewButtonClickListener, View {

	private static final long serialVersionUID = 1082791095382801193L;

	private LoginViewModel loginViewModel;
	private LoginViewImpl loginViewImpl;
	private Navigator navigator;
	private boolean passwordMatched;
	private boolean userMatched;
	private String username;
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
			ui.getSession().setAttribute("user", username);
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
	public void enter(ViewChangeEvent event) {
	}

	public void initializeViewsAfterLogin() {

		MainViewImp view = new MainViewImp();

		// OrderStatus View
		OrderStatusViewImp OrderStatusImpl = new OrderStatusViewImp();
		OrderStatusModel OrderStatusModel = new OrderStatusModel();
		new OrderStatusViewPresenter(OrderStatusModel, OrderStatusImpl);
		
		
		//OrderView		
		SimonOrderView orderView = new SimonOrderView();
		SimonOrderModel model = new SimonOrderModel();
		new SimonOrderPresenter(model, orderView);

		navigator.addView("HomeView", view);
		navigator.addView("Order", OrderStatusImpl);
		
		navigator.addView("OrderView", orderView);
		//navigator.addView("OrderedView",);
		

		//SimonOrderedView orderedView = new SimonOrderedView();
		
		
		

	}

}
