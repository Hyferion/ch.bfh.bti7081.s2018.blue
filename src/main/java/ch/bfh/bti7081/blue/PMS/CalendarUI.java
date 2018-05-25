package ch.bfh.bti7081.blue.PMS;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import javafx.concurrent.Task;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of an HTML page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class CalendarUI extends UI {
	
	private VerticalLayout vLayoutCalendar = new VerticalLayout();
	private VerticalLayout vLayoutTasks = new VerticalLayout();
	private HorizontalLayout hLayoutTasks = new HorizontalLayout();
	private NativeSelect<String> nsFilter = new NativeSelect<>();
	private Button newTaskButton = new Button("+ New Task");
	private Label label = new Label("Calendar");
	private Grid<Task> grid = new Grid<>(Task.class);
	private TaskDBManager tdm = new TaskDBManager();
	
    @Override
    protected void init(VaadinRequest vaadinRequest) {
//    	CalendarViewImpl view = new CalendarViewImpl();
    	
    	nsFilter.setItems("Today", "Next 7 Days", "Next 14 Days", "Next 30 Days", "Show All");
    	nsFilter.setEmptySelectionAllowed(false);
//    	nsFilter.addValueChangeListener(e -> grid.setItems(tdm.queryTasks(nsFilter.getValue())));
    	
    	
    	
    	hLayoutTasks.addComponents(nsFilter, newTaskButton);
    	vLayoutTasks.addComponents(hLayoutTasks, grid);
    	vLayoutCalendar.addComponents(label, vLayoutTasks);
    	setContent(vLayoutCalendar);
//    	setContent(ExampleUI.start());
    	
    }

    
    
    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = CalendarUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
    
    
}
