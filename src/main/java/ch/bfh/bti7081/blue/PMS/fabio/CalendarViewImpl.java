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
import com.vaadin.ui.Grid.ItemClick;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.components.grid.ItemClickListener;

import ch.bfh.bti7081.blue.PMS.model.File;
import ch.bfh.bti7081.blue.PMS.model.Task;
import ch.bfh.bti7081.blue.PMS.view.HeaderFooter;


public class CalendarViewImpl extends CustomComponent implements CalendarView, ItemClickListener<Task>, HasValue.ValueChangeListener<String>, View {

	List<GridItemListener> itemListener = new ArrayList<GridItemListener>();
	List<CalendarNativeSelectListener> nativeSelectListener = new ArrayList<CalendarNativeSelectListener>();
	Grid<Task> grid;
	NativeSelect<String> nsFilter;
	
	public CalendarViewImpl() {
		
		// Create header and footer for the calendar view
		HeaderFooter root = new HeaderFooter("Calendar ");
		
		// Create filter nativeSelect
		nsFilter = new NativeSelect<String>();
		nsFilter.addValueChangeListener(this::valueChange);
		nsFilter.setItems("Last 30 Days","Last 7 Days","Today","Next 7 Days", "Next 30 Days","Show All");
		nsFilter.setEmptySelectionAllowed(false);
		nsFilter.setSelectedItem("Today");
		nsFilter.setCaption("Filter");
		
		// Create task grid
		grid = new Grid<>(Task.class);
		grid.addItemClickListener(this::itemClick);
		grid.setColumns("dueDate", "subject", "status");
		grid.setWidth("750px");
		grid.getColumn("dueDate").setWidth(150).setResizable(false);
		grid.getColumn("subject").setWidth(450).setResizable(false);
		grid.getColumn("status").setWidth(150).setResizable(false);
		
		// Create horizontal layout for the nativeSelect filter & task button
		HorizontalLayout hLayoutTasks = new HorizontalLayout();
		hLayoutTasks.setSizeFull();
		hLayoutTasks.addComponents(nsFilter);
		
		// Create vertical layout for the horizontal layout and task grid
		VerticalLayout vLayoutCalendar = new VerticalLayout();
		vLayoutCalendar.addComponents(hLayoutTasks, grid);
    	
		// Set root layout for the calendar view
		root.getlayout().addComponent(vLayoutCalendar, 1);
		root.getlayout().setComponentAlignment(vLayoutCalendar, Alignment.MIDDLE_CENTER);
		setCompositionRoot(root);
    	
	}
	
	@Override
	public void addTasksToGrid(List<Task> tasks, int taskListSize) {
		grid.setItems(tasks);
		if (taskListSize != 0) {
			grid.setHeightByRows(taskListSize);
		}
		else {
			grid.setHeightByRows(1);
		}
		
		
	}

	@Override
	public void valueChange(ValueChangeEvent<String> event) {
		for (CalendarNativeSelectListener listener : nativeSelectListener) {
			listener.nativeSelectChange(nsFilter.getValue());
		}
	}

	@Override
	public void addNativeSelectListener(CalendarNativeSelectListener listener) {
		nativeSelectListener.add(listener);
		
	}

	@Override
	public void itemClick(ItemClick<Task> event) {
		for (GridItemListener listener : itemListener) {
			listener.itemClick(event.getItem());
		}
		
	}

	@Override
	public void addGridItemListener(GridItemListener listener) {
		itemListener.add(listener);
		
	}

}
