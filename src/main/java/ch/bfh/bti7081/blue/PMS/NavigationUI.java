package ch.bfh.bti7081.blue.PMS;

import com.vaadin.navigator.Navigator;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import java.util.*;

public class NavigationUI extends VerticalLayout {
	protected LinkedHashMap<String, String> navigationEntries;
	protected Navigator navigator;
	
	public NavigationUI(Navigator navigator, LinkedHashMap<String, String> navigationEntries) {
		this.navigator = navigator;
		this.navigationEntries = navigationEntries;
		
		final HorizontalLayout top = new HorizontalLayout();
		top.setWidth("100%");
		top.setDefaultComponentAlignment(Alignment.MIDDLE_LEFT);
		top.addStyleName("valo-menu-title");
		
		final Label title = new Label("<h3><stron>Softwarename</stron></h3>", ContentMode.HTML);
		title.setSizeUndefined();
		top.addComponent(title);
		top.setExpandRatio(title, 1);
		
		addComponent(top);
		
		Iterator it = navigationEntries.entrySet().iterator();
		while(it.hasNext()) {
			Map.Entry<String, String> item = (Map.Entry)it.next();
			final Button b = new Button(item.getValue(), new Button.ClickListener() {
				@Override
				public void buttonClick(final Button.ClickEvent event) {
					navigator.navigateTo(item.getKey());
				}
			});
			b.setPrimaryStyleName("valo-menu-item");
			addComponent(b);
		}
		
		setWidth("100%");
		setStyleName(ValoTheme.MENU_ROOT);
	}

}
