package ch.bfh.bti7081.blue.PMS;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;

public class TaskModelTest {

	private String subject;
	private String content;
	private LocalDate date;
	private boolean status;
	private static List<TaskModelTest> list;
	
	public TaskModelTest(LocalDate date) {
		this.date = date;
	}
	
	public LocalDate getDate() {
		return date;
	}


	public static List<TaskModelTest> getRandomTasks(int amount) {
		
		list = new ArrayList<TaskModelTest>();
    	
    	int i=0;
    	while (i<amount) {
    		int day = 1 + (int) (Math.random()*30);
    		int month = 5 + (int) (Math.random()*7);
    		int year = 2018;
    		list.add(new TaskModelTest(LocalDate.of(year, month, day)));
    		i++;
    	}
    	
    	return list;
	}
	
}
