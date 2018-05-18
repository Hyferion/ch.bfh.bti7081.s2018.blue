package ch.bfh.bti7081.blue.PMS;

import java.util.List;

public interface CalendarView {
	
	interface CreateTaskListener {
		void buttonClick();
	}
	
	public void showFilteredTasks(List tasks);
	
	public void addCTListener(CreateTaskListener listener);

}
