package ch.bfh.bti7081.blue.PMS.view;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.ClassResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.UI;
import com.vaadin.ui.themes.ValoTheme;

import ch.bfh.bti7081.blue.PMS.view.interfaces.MainViewInterface;
import ch.bfh.bti7081.blue.PMS.view.interfaces.OrderViewInterface.OrderViewListener;

public class MainViewImp extends CustomComponent implements MainViewInterface, ClickListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MainViewImp() {

		HeaderFooter root = new HeaderFooter(
				"Hello " + UI.getCurrent().getSession().getAttribute("firstname").toString());

		setSizeFull();

		HorizontalLayout horizontalLayout = new HorizontalLayout();
		horizontalLayout.setWidth("1400");

		Button butInfo = new Button("Addictions", this);
		butInfo.addStyleName(ValoTheme.BUTTON_HUGE);
		butInfo.setIcon(VaadinIcons.INFO_CIRCLE_O);
		butInfo.setWidth("300");
		butInfo.setHeight("200");

		Button butBest = new Button("Order", this);
		butBest.setIcon(VaadinIcons.FILE_TEXT);
		butBest.addStyleName(ValoTheme.BUTTON_HUGE);
		butBest.setWidth("300");
		butBest.setHeight("200");

		Button butChat = new Button("Chat Room", this);
		butChat.setIcon(VaadinIcons.CHAT);
		butChat.addStyleName(ValoTheme.BUTTON_HUGE);
		butChat.setWidth("300");
		butChat.setHeight("200");

		Button butKalender = new Button("Calendar", this);
		butKalender.addStyleName(ValoTheme.BUTTON_HUGE);
		butKalender.setIcon(VaadinIcons.CALENDAR);
		butKalender.setWidth("300");
		butKalender.setHeight("200");

		horizontalLayout.addComponent(butBest);
		horizontalLayout.addComponent(butChat);
		horizontalLayout.addComponent(butKalender);
		horizontalLayout.addComponent(butInfo);

		horizontalLayout.setComponentAlignment(butInfo, Alignment.MIDDLE_CENTER);
		horizontalLayout.setComponentAlignment(butBest, Alignment.MIDDLE_CENTER);
		horizontalLayout.setComponentAlignment(butChat, Alignment.MIDDLE_CENTER);
		horizontalLayout.setComponentAlignment(butKalender, Alignment.MIDDLE_CENTER);

		root.getlayout().addComponent(horizontalLayout, 1);
		root.getlayout().setComponentAlignment(horizontalLayout, Alignment.MIDDLE_CENTER);

		setCompositionRoot(root);
	}

	List<MainViewListener> listeners = new ArrayList<MainViewListener>();

	public void addListener(MainViewListener listener) {
		listeners.add(listener);
	}

	@Override
	public void buttonClick(ClickEvent event) {
		System.out.println(listeners.toString());
		for (MainViewListener listener : listeners) {
			listener.buttonClick(event.getButton().getCaption());
		}

	}
}
