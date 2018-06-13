package ch.bfh.bti7081.blue.PMS.view;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.server.ClassResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

import ch.bfh.bti7081.blue.PMS.model.LoginViewModel;
import ch.bfh.bti7081.blue.PMS.model.OrderStatus;

public class MainViewImp extends CustomComponent implements View {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	
	public MainViewImp() {

		HeaderFooter root = new HeaderFooter("Hello" + " " + UI.getCurrent().getSession().getAttribute("firstname").toString());
		

		setSizeFull();

		HorizontalLayout but = new HorizontalLayout();
		but.setSpacing(true);
		
		Button butBest = new Button("", e -> getUI().getNavigator().navigateTo("OrderView"));
		butBest.setIcon(new ClassResource("/icons/shopping-bag.png"));
		Button butChat = new Button("", e -> getUI().getNavigator().navigateTo("ChatRoom"));
		butChat.setIcon(new ClassResource("/icons/chat.png"));
		Button butKalender = new Button("");
		butKalender.setIcon(new ClassResource("/icons/calendar.png"));
		
		
		butBest.addStyleName(ValoTheme.BUTTON_LARGE);
		butBest.setWidth("300");
		butBest.setHeight("200");
		butChat.addStyleName(ValoTheme.BUTTON_LARGE);
		butChat.setWidth("300");
		butChat.setHeight("200");
		butKalender.addStyleName(ValoTheme.BUTTON_LARGE);
		butKalender.setWidth("300");
		butKalender.setHeight("200");

		
		but.addComponent(butBest);
		but.addComponent(butChat);
		but.addComponent(butKalender);

		but.setComponentAlignment(butBest, Alignment.MIDDLE_CENTER);
		but.setComponentAlignment(butChat, Alignment.MIDDLE_CENTER);
		but.setComponentAlignment(butKalender, Alignment.MIDDLE_CENTER);

		root.getlayout().addComponent(but, 1);
		root.getlayout().setComponentAlignment(but, Alignment.MIDDLE_CENTER);

		setCompositionRoot(root);
	}

}
