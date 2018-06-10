package ch.bfh.bti7081.blue.PMS.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "tasks")
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int taskId;
	private String subject;
	private String description;
	private String dueDate;
	private boolean status;
	
	@OneToMany(mappedBy = "taskId")
	private List<File> files;
	
	public Task() {
		
	}
	
	public Task(LocalDate date) {
		this.dueDate = date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
	}
	
	public void setTaskId(int id) {
		this.taskId = id;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void setContent(String content) {
		this.description = content;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public void setFile(File file) {
		if (files == null) {
			files = new ArrayList<File>();
		} 
		this.files.add(file);
	}

	public int getTaskId() {
		return taskId;
	}

	public String getSubject() {
		return subject;
	}

	public String getContent() {
		return description;
	}

	public String getDueDate() {
		return dueDate;
	}

	public boolean isStatus() {
		return status;
	}

	public List<File> getFiles() {
		return files;
	}


	
	
}
