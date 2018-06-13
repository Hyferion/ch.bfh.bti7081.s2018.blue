package ch.bfh.bti7081.blue.PMS.fabio;

import java.util.Comparator;
import ch.bfh.bti7081.blue.PMS.model.Task;

public class DateComparator implements Comparator<Task> {

	@Override
	public int compare(Task t1, Task t2) {
		if (t1.getDueDate().isBefore(t2.getDueDate())) {
			return 1;
		}
		else {
			return -1;
		}
	}

}
