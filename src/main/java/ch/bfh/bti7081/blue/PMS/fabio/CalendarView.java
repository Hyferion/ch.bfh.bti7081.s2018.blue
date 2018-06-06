package ch.bfh.bti7081.blue.PMS.fabio;

import java.util.List;
import ch.bfh.bti7081.blue.PMS.model.Task;

public interface CalendarView {
	
	interface CalendarButtonListener {
		void buttonClick();
		
	}
	
	interface CalendarNativeSelectListener {
		void nativeSelectChange(String filter);
	}
	
	public void addTasksToGrid(List<Task> tasks);
	
	public void addButtonListener(CalendarButtonListener listener);
	
	public void addNativeSelectListener(CalendarNativeSelectListener listener);

}
