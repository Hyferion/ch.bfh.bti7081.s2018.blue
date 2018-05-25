package ch.bfh.bti7081.blue.PMS.view;

import com.vaadin.navigator.Navigator;
import com.vaadin.server.Responsive;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.UI;
import com.vaadin.ui.themes.ValoTheme;

import java.util.LinkedHashMap;

/**
 * 
 * @author Sinthujah
 * Diese UI ist die Homeseite. Von dieser Seite aus
 * können die anderen Seiten geöffnet werden
 *
 */
public class TheUI extends UI {
	
	Navigator navigator;
	NavigationUI navigation;
	
	BaseLayout root = new BaseLayout();
    ComponentContainer viewDisplay = root.getContentContainer();

    //Set Strings for views
    protected static final String MAIN_VIEW = "main";
    protected static final String CALENDER_VIEW = "calender";
    protected static final String CHAT_VIEW = "chat";

    @Override
    protected void init(VaadinRequest request) {
        getPage().setTitle("Team Blue");
        
        navigator = new Navigator(UI.getCurrent(), viewDisplay);

        setContent(root);
        root.setWidth("100%");

        navigation = new NavigationUI(navigator, getNavigationEntries());
     
        
            
        root.addMenu(navigation);
        Responsive.makeResponsive(root);

            addStyleName(ValoTheme.UI_WITH_MENU);
            
            // create and register the views
           // navigator.addView(MAIN_VIEW, new MainView());
            //navigator.addView(CALENDER_VIEW, new CalenderView()); //muss noch erstellt werden
            //navigator.addView(CHAT_VIEW, new ChatView()); // muss noch erstellt werden
    }
    
    protected LinkedHashMap<String, String> getNavigationEntries() {
        LinkedHashMap<String, String> entires = new LinkedHashMap<>();
        entires.put("main", "Home");
        entires.put("calender", "Calender");
        entires.put("chat", "Chat");
        
        return  entires;
    }
}
