package ch.bfh.bti7081.blue.PMS.fabio;

import java.time.LocalTime;

import com.vaadin.ui.UI;
import ch.bfh.bti7081.blue.PMS.steve.TaskWindowImpl;
import ch.bfh.bti7081.blue.PMS.DB.DBConnector;
import ch.bfh.bti7081.blue.PMS.fabio.CalendarView.CalendarButtonListener;
import ch.bfh.bti7081.blue.PMS.fabio.CalendarView.CalendarNativeSelectListener;
import ch.bfh.bti7081.blue.PMS.model.Task;

public class CalendarPresenter implements CalendarNativeSelectListener, CalendarButtonListener {

	private CalendarView view;
	private Task model;
	DBConnector db = DBConnector.getDBConnector();
	
	public CalendarPresenter(Task model, CalendarView view) {
		this.model = model;
		this.view = view;
		view.addButtonListener(this);
		view.addNativeSelectListener(this);
		
		
	}

	@Override
	public void buttonClick() {
		System.out.println("New Task Button: " + LocalTime.now());
    	TaskWindowImpl taskWindow = new TaskWindowImpl();
		UI.getCurrent().addWindow(taskWindow);
		
	}

	@Override
	public void nativeSelectChange(String filter) {
		System.out.println("NativeSelect: " + LocalTime.now());
//		switch (filter) {
//		case "Today":
//			filterList = list.stream().filter(t -> t.getDate().now() == LocalDate.now()).collect(Collectors.toList());
//			break;
//
//		case "This Week":
//			break;
//		case "This Month":
//			filterList = list.stream().filter(t -> t.getDate().getMonthValue() == LocalDate.now().getMonthValue())
//					.collect(Collectors.toList());
//			break;
//		case "This Year":
//			filterList = list.stream().filter(t -> t.getDate().getYear() == LocalDate.now().getYear())
//					.collect(Collectors.toList());
//		case "Show All":
//			filterList = list;
//			break;
//		default:
//			System.out.println("Didn't work!");
//		}
//		
//		view.addTasksToGrid(tasks);
		
		System.out.println("Selected: " + filter);
		
	}
	


}