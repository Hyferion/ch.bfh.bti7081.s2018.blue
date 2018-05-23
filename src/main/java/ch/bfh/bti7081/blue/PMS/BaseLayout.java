package ch.bfh.bti7081.blue.PMS;

import com.vaadin.ui.Component;
import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;

public class BaseLayout extends HorizontalLayout{
	CssLayout contentArea = new CssLayout();
	
	CssLayout menuArea = new CssLayout();
	
	public BaseLayout() {
		setSizeFull();
		
		menuArea.setPrimaryStyleName("valo-menu");
		
		contentArea.setPrimaryStyleName("valo-content");
		contentArea.addStyleName("v-scrollable");
		contentArea.setSizeFull();
		
		addComponents(menuArea, contentArea);
		setExpandRatio(contentArea, 1);
	}
	
	public ComponentContainer getContentContainer() {
		return contentArea;
	}
	
	public void addMenu(Component menu) {
		menu.addStyleName("valo-menu-part");
		menuArea.addComponent(menu);
	}
	
	public void showMenu() {
		menuArea.setVisible(true);
	}
	
	public void hideMenu() {
		menuArea.setVisible(false);
	}

}
