package ch.bfh.bti7081.blue.PMS.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	private String status;
	private String USERNAME;
	
	
	public Task() {}
	
	public void setTaskId(int id) {
		this.taskId = id;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void setDescription(String content) {
		this.description = content;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public void setUsername(String USERNAME) {
		this.USERNAME = USERNAME;
	}
	

	public int getTaskId() {
		return taskId;
	}

	public String getSubject() {
		return subject;
	}

	public String getDescription() {
		return description;
	}

	public LocalDate getDueDate() {
		return LocalDate.parse(dueDate);
	}

	public String getStatus() {
		return status;
	}
	
	
	public String getUSERNAME() {
		return USERNAME;
	}



	
	
}
