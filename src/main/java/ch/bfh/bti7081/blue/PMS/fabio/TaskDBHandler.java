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
		case "Last 30 Days": sqlQuery = pastDateFilter(dateToday, 30);
							 break;
		case "Last 7 Days":  sqlQuery = pastDateFilter(dateToday, 7);
		 					 break;
		case "Today":		 sqlQuery = presentDateFilter(dateToday, 0);
		 					 break;
		case "Next 7 Days":  sqlQuery = futureDateFilter(dateToday, 7);
		 					 break;
		case "Next 30 Days": sqlQuery = futureDateFilter(dateToday, 30);
		 					 break;
		case "Show All":	 sqlQuery = allDateFilter(dateToday, 0);
		 					 break;
		}
		
		Query query = dbConnector.getEntityManager().createQuery(sqlQuery);
		taskList = query.getResultList();
		for (Task task : taskList) {
			System.out.println(task.getDueDate() + " " + task.getSubject());
		}
	}
	
	private String pastDateFilter(LocalDate dateToday, int days) {
		return "SELECT t, f.fileId, f.name, f.path FROM LoginAccount l, Task t, File f " 
		+ "WHERE l.username = t.username "
		+ "AND t.taskId = f.taskId "
		+ "AND t.dueDate BETWEEN " + dateToday.minusDays(days) + " AND " + dateToday;
		
	}
	
	private String futureDateFilter(LocalDate dateToday, int days) {
		return "SELECT t, f.file_id, f.name, f.path FROM loginaccount l, tasks t, files f " 
		+ "WHERE l.username = t.username "
		+ "AND t.task_id = f.task_id "
		+ "AND t.date BETWEEN " + dateToday + " AND " + dateToday.plusDays(days);
		
	}
	
	private String presentDateFilter(LocalDate dateToday, int days) {
		return "SELECT t, f.file_id, f.name, f.path FROM loginaccount l, tasks t, files f " 
		+ "WHERE l.username = t.username "
		+ "AND t.task_id = f.task_id "
		+ "AND t.date = " + dateToday;
		
	}
	
	private String allDateFilter(LocalDate dateToday, int days) {
		return "SELECT t.*, f.file_id, f.name, f.path FROM loginaccount l, tasks t, files f " 
		+ "WHERE l.username = t.username "
		+ "AND t.task_id = f.task_id";
	}
	
}
