package ch.bfh.bti7081.blue.PMS;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.event.MouseEvents.ClickEvent;
import com.vaadin.event.MouseEvents.ClickListener;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.VerticalLayout;

public class CalendarViewImpl extends CustomComponent implements CalendarView, ClickListener {

	private Label title = new Label("Calendar");
	private List<Label> taskList = new ArrayList<>();
	private NativeSelect<String> nsComponent = new NativeSelect<>();
	private CreateTaskListener listener;
		
	
	public CalendarViewImpl() {
		VerticalLayout vLayout = new VerticalLayout();
		HorizontalLayout hLayout = new HorizontalLayout();
		hLayout.addComponents(nsComponent, new Button("Create new Task", this::click));
		nsComponent.setItems("Today", "This Week", "This Month", "This Year", "Show All");
		nsComponent.setEmptySelectionAllowed(false);
		vLayout.addComponents(title, hLayout);
	}

	@Override
	public void showFilteredTasks(List tasks) {
		nsComponent.addValueChangeListener(e -> nsComponent.getValue());
		
	}

	@Override
	public void click(ClickEvent event) {
		listener.buttonClick();
	}
	
	@Override
	public void addCTListener(CreateTaskListener listener) {
		this.listener = listener;
	}
	

	

	
	
}
