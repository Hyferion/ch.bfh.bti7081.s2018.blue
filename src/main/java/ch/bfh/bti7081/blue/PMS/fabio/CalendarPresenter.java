package ch.bfh.bti7081.blue.PMS.fabio;

import java.util.List;

import com.vaadin.ui.UI;
import ch.bfh.bti7081.blue.PMS.steve.TaskWindowImpl;
import ch.bfh.bti7081.blue.PMS.DB.DBConnector;
import ch.bfh.bti7081.blue.PMS.fabio.CalendarView.GridItemListener;
import ch.bfh.bti7081.blue.PMS.fabio.CalendarView.CalendarNativeSelectListener;
import ch.bfh.bti7081.blue.PMS.model.File;
import ch.bfh.bti7081.blue.PMS.model.Task;

public class CalendarPresenter implements CalendarNativeSelectListener, GridItemListener {

	private CalendarView view;
	private DBConnector dbConnector = DBConnector.getDBConnector();
	private TaskDBHandler handler = new TaskDBHandler(dbConnector);
	private UI ui = UI.getCurrent();
	
	public CalendarPresenter(CalendarView view) {
		// Instantiate view and listeners
		this.view = view;
		view.addGridItemListener(this);
		view.addNativeSelectListener(this);
		
		// Initialize "Today" tasks to be shown in the grid
		handler.filterTasks("Today");
		List<Task> taskList = handler.getTaskList();
		this.view.addTasksToGrid(handler.getTaskList(), taskList.size());
		
		// Task_ID from File class for file list query
		ui.getSession().setAttribute("task", dbConnector.getDBConnector().getTaskId());
	
	}

	@Override
	public void nativeSelectChange(String filter) {
		handler.filterTasks(filter);
		List<Task> taskList = handler.getTaskList();
		view.addTasksToGrid(taskList, taskList.size());
	}

	@Override
	public void itemClick(Task task) {
		List<File> fileList = handler.getFileList();
    	TaskWindowImpl taskWindow = new TaskWindowImpl(task, fileList);
		ui.getCurrent().addWindow(taskWindow);
	}
	


}
