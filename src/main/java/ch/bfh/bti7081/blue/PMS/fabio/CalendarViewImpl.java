package ch.bfh.bti7081.blue.PMS.fabio;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.vaadin.data.HasValue;
import com.vaadin.data.HasValue.ValueChangeEvent;
import com.vaadin.navigator.View;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.VerticalLayout;

import ch.bfh.bti7081.blue.PMS.model.Task;
import ch.bfh.bti7081.blue.PMS.view.HeaderFooter;


public class CalendarViewImpl extends CustomComponent implements CalendarView, ClickListener, HasValue.ValueChangeListener<String>, View {

	List<CalendarButtonListener> buttonListener = new ArrayList<CalendarButtonListener>();
	List<CalendarNativeSelectListener> nativeSelectListener = new ArrayList<CalendarNativeSelectListener>();
	Grid<Task> grid;
	NativeSelect<String> nsFilter;
	
	public CalendarViewImpl() {
		
		// Create header and footer for the calendar view
		HeaderFooter root = new HeaderFooter("Calendar ");
		
		Label filterLabel = new Label("Filter Period: ");
		
		// Create filter nativeSelect
		nsFilter = new NativeSelect<String>();
		nsFilter.setItems("Today", "This Week", "This Month", "This Year", "Show All");
		nsFilter.setEmptySelectionAllowed(false);
		nsFilter.setSelectedItem("Today");
		
		// Create task button
		Button newTaskButton = new Button("New Task");
		
		// Create task grid
		grid = new Grid<>(Task.class);
		grid.setSizeFull();
		
		// Create horizontal layout for the nativeSelect filter & task button
		HorizontalLayout hLayoutTasks = new HorizontalLayout();
		hLayoutTasks.setSizeFull();
		hLayoutTasks.addComponents(nsFilter, newTaskButton);
		
		// Create vertical layout for the horizontal layout and task grid
		VerticalLayout vLayoutCalendar = new VerticalLayout();
		vLayoutCalendar.addComponents(hLayoutTasks, grid);
    	
		// Set root layout for the calendar view
		root.getlayout().addComponent(vLayoutCalendar, 1);
		root.getlayout().setComponentAlignment(vLayoutCalendar, Alignment.MIDDLE_CENTER);
		setCompositionRoot(root);
    	
	}

	@Override
	public void buttonClick(ClickEvent event) {
		for (CalendarButtonListener listener : buttonListener) {
			listener.buttonClick();
		}
		
	}
	
	@Override
	public void addTasksToGrid(List<Task> tasks) {
		this.grid.setItems(tasks);
		
	}

	@Override
	public void valueChange(ValueChangeEvent<String> event) {
		for (CalendarNativeSelectListener listener : nativeSelectListener) {
			listener.nativeSelectChange(nsFilter.getValue());
		}
	}

	@Override
	public void addButtonListener(CalendarButtonListener listener) {
		buttonListener.add(listener);
	}

	@Override
	public void addNativeSelectListener(CalendarNativeSelectListener listener) {
		nativeSelectListener.add(listener);
		
	}

}
