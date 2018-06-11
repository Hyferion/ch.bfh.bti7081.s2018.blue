package ch.bfh.bti7081.blue.PMS.fabio;

import java.time.LocalTime;
import java.util.List;

import com.vaadin.ui.UI;
import ch.bfh.bti7081.blue.PMS.steve.TaskWindowImpl;
import ch.bfh.bti7081.blue.PMS.DB.DBConnector;
import ch.bfh.bti7081.blue.PMS.fabio.CalendarView.CalendarButtonListener;
import ch.bfh.bti7081.blue.PMS.fabio.CalendarView.CalendarNativeSelectListener;
import ch.bfh.bti7081.blue.PMS.model.Task;

public class CalendarPresenter implements CalendarNativeSelectListener, CalendarButtonListener {

	private CalendarView view;
	DBConnector dbConnector = DBConnector.getDBConnector();
	
	public CalendarPresenter(CalendarView view) {
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
		TaskDBHandler handler = new TaskDBHandler(dbConnector, filter);
		List<Task> taskList = handler.getTaskList();
		view.addTasksToGrid(taskList);
		
	}
	


}
