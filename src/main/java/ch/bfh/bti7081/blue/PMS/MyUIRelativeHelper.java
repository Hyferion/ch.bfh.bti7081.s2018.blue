package ch.bfh.bti7081.blue.PMS;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;

import ch.bfh.bti7081.blue.PMS.model.LoginViewModel;
import ch.bfh.bti7081.blue.PMS.presenter.LoginViewPresenter;
import ch.bfh.bti7081.blue.PMS.view.LoginViewImpl;

/**
 * This UI is the application entry point. A UI may either represent a browser
 * window (or tab) or some part of a html page where a Vaadin application is
 * embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is
 * intended to be overridden to add component to the user interface and
 * initialize non-component functionality.
 */

@Theme("mytheme")
public class MyUIRelativeHelper extends UI {

	private static final long serialVersionUID = 8756061847229359826L;
	private static boolean startup = true;
	private Navigator navigator;

	@Override
	protected void init(VaadinRequest vaadinRequest) {
		this.navigator = new Navigator(this, this);

		// Login View
		LoginViewModel loginViewModel = new LoginViewModel();
		LoginViewImpl loginViewImpl = new LoginViewImpl();
		LoginViewPresenter loginViewPresenter = new LoginViewPresenter(loginViewModel, loginViewImpl, navigator);
		navigator.addView("LoginView", loginViewImpl);
		navigator.addView("", loginViewImpl);

		boolean isLoggedIn = getSession().getAttribute("user") != null;

		if (startup) {
			getNavigator().navigateTo("LoginView");
			startup = false;
		} else if (isLoggedIn) {
			loginViewPresenter.initializeViewsAfterLogin();
			getNavigator().navigateTo("HomeView");
		}

		getNavigator().addViewChangeListener(new ViewChangeListener() {
			@Override
			public boolean beforeViewChange(ViewChangeEvent event) {

				boolean isLoggedIn = getSession().getAttribute("user") != null;
				boolean isLoginView = event.getNewView() instanceof LoginViewImpl;

				System.out.println("logged: " + isLoggedIn + " loginView: " + isLoginView);

				if (!isLoggedIn && !isLoginView) {
					getNavigator().navigateTo("LoginView");
					return false;
				} else if (isLoggedIn && isLoginView) {
					return false;
				}
				return true;
			}

			@Override
			public void afterViewChange(ViewChangeEvent event) {
			}
		});
	}

	@WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
	@VaadinServletConfiguration(ui = MyUIRelativeHelper.class, productionMode = false)
	public static class MyUIServlet extends VaadinServlet {
		private static final long serialVersionUID = 7729956322024855965L;
	}
}
