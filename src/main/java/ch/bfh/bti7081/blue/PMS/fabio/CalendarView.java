package ch.bfh.bti7081.blue.PMS.fabio;

import java.util.List;
import ch.bfh.bti7081.blue.PMS.model.Task;

public interface CalendarView {
	
	interface GridItemListener {
		void itemClick(Task task);
		
	}
	
	interface CalendarNativeSelectListener {
		void nativeSelectChange(String filter);
	}
	
	public void addTasksToGrid(List<Task> tasks, int taskListSize);
	
	public void addGridItemListener(GridItemListener listener);
	
	public void addNativeSelectListener(CalendarNativeSelectListener listener);

}
