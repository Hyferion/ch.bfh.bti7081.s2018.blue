package ch.bfh.bti7081.blue.PMS.fabio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import ch.bfh.bti7081.blue.PMS.DB.DBConnector;
import ch.bfh.bti7081.blue.PMS.model.Task;

public class TaskDBHandler {

	DBConnector dbConnector;
	List<Task> taskList = new ArrayList<Task>();
	
	
	public TaskDBHandler(DBConnector dbConnector, String filter) {
		this.dbConnector = dbConnector;
		filterTasks(filter);
	}
	
	public List<Task> getTaskList() {
		return taskList;
	}
	
	private void filterTasks(String filter) {
		
		LocalDate dateToday = LocalDate.now();
		String sqlQuery = "";
		
		switch(filter) {
		case "Last 30 Days": 
		case "Last 7 Days":
		case "Today":
		case "Next 7 Days":
		case "Next 30 Days":
		case "Show All":
		}
		
		Query query = dbConnector.getEntityManager().createQuery(sqlQuery);
		taskList = query.getResultList();
	}
	
	private String dateFilter(LocalDate dateToday, int days) {
		return dateToday.plusDays(days).toString();
	}
}
