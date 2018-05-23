package ch.bfh.bti7081.blue.PMS;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
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
@Theme("mytheme")
public class MyUI extends UI {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Navigator navigator;

	@Override
	protected void init(VaadinRequest vaadinRequest) {
		navigator = new Navigator(this, this);
		OrderModel model = new OrderModel();
		SImonOrderViewImpl2 view2 = new SImonOrderViewImpl2(navigator);
		SimonOrderViewImpl view = new SimonOrderViewImpl(navigator);
		LarsOrderViewImp larsView = new LarsOrderViewImp(navigator);

		navigator.addView("First", view);
		navigator.addView("Second", view2);
		navigator.addView("Lars View", larsView);
		navigator.navigateTo("First");
		
		new OrderPresenter(model, view);

		setContent(view);

	}

	@WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
	@VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
	public static class MyUIServlet extends VaadinServlet {

	}
}
