package ch.bfh.bti7081.blue.PMS.fabio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Query;

import com.vaadin.ui.UI;

import ch.bfh.bti7081.blue.PMS.DB.DBConnector;
import ch.bfh.bti7081.blue.PMS.model.File;
import ch.bfh.bti7081.blue.PMS.model.Task;

public class TaskDBHandler {

	private DBConnector dbConnector;
	private List<Task> taskList = new ArrayList<Task>();
	private List<File> fileList = new ArrayList<File>();

	
	public TaskDBHandler(DBConnector dbConnector) {
		this.dbConnector = dbConnector;
	}
	
	public List<Task> getTaskList() {
		return taskList;
	}
	
	public List<File> getFileList() {
		return fileList;
	}
	
	private Query userTasksQuery() {
		Query query = dbConnector.getEntityManager().createQuery("SELECT t FROM Task t "
															   + "WHERE t.USERNAME = :name");
		query.setParameter("name", UI.getCurrent().getSession().getAttribute("user").toString());
		return query;
	}
	
//	private Query userFilesQuery() {
//		Query query = dbConnector.getEntityManager().createQuery("SELECT f FROM File f "
//															   + "WHERE f.TASK_ID = :taskId");
//		query.setParameter("taskId", UI.getCurrent().getSession().getAttribute("task").toString());
//		return query;
//	}
	
	public void filterTasks(String filter) {
		LocalDate dateToday = LocalDate.now();
		List<Task> taskList = userTasksQuery().getResultList();
		List<File> fileList = null; //userFilesQuery().getResultList();
		
		switch(filter) {
		
		case "Last 30 Days": pastDateFilter(taskList, fileList, dateToday, 30);
							 break;
		case "Last 7 Days":  pastDateFilter(taskList, fileList, dateToday, 7);
		 					 break;
		case "Today":		 presentDateFilter(taskList, fileList, dateToday);
		 					 break;
		case "Next 7 Days":  futureDateFilter(taskList, fileList, dateToday, 7);
		 					 break;
		case "Next 30 Days": futureDateFilter(taskList, fileList, dateToday, 30);
		 					 break;
		case "Show All":	 allDatesFilter(taskList, fileList);
		 					 break;
		default:			 allDatesFilter(taskList, fileList);
		
		}
	}
	
	private void pastDateFilter(List<Task> taskList, List<File> fileList, LocalDate dateToday, int minusDays) {
		this.taskList = taskList.stream()
				 				.filter(t -> t.getDueDate()
				 				.isAfter(dateToday.minusDays(minusDays)) && t.getDueDate()
				 				.isBefore(dateToday))
				 				.sorted(new DateComparator())
				 				.collect(Collectors.toList());
		this.fileList = fileList;
	}
	
	private void futureDateFilter(List<Task> taskList, List<File> fileList, LocalDate dateToday, int plusDays) {
		this.taskList = taskList.stream()
				 				.filter(t -> t.getDueDate()
				 				.isAfter(dateToday) && t.getDueDate()
				 				.isBefore(dateToday.plusDays(plusDays)))
				 				.sorted(new DateComparator())
				 				.collect(Collectors.toList());
		this.fileList = fileList;
	}
	
	private void presentDateFilter(List<Task> taskList, List<File> fileList, LocalDate dateToday) {
		this.taskList = taskList.stream()
								.filter(t -> t.getDueDate().isEqual(dateToday))
								.sorted(new DateComparator())
								.collect(Collectors.toList());
		this.fileList = fileList;
	}
	
	private void allDatesFilter(List<Task> taskList, List<File> fileList) {
		this.taskList = taskList.stream()
								.sorted(new DateComparator())
								.collect(Collectors.toList());
		this.fileList = fileList;
	}
	
}
