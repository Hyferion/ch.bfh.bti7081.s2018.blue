package ch.bfh.bti7081.blue.PMS;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "tasks")
public class Task {

	private int id;
	private String subject;
	private String content;
	private String dueDate;
	private boolean status;
	
	
	public Task(LocalDateTime date) {
		this.dueDate = date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy, HH:MI"));
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public String getSubject() {
		return subject;
	}

	public String getContent() {
		return content;
	}

	public String getDueDate() {
		return dueDate;
	}

	public boolean isStatus() {
		return status;
	}



	
	
}
