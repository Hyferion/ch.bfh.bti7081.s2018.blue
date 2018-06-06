package ch.bfh.bti7081.blue.PMS.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "files")
public class File {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int fileId;
	private String name;
	private String path;
	private String author;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="TASK_ID")
	private Task taskId;
	
	public File() {
		
	}
	public void setFileId(int id) {
		this.fileId = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getFileId() {
		return fileId;
	}
	
	public String getName() {
		return name;
	}
	
	public String getPath() {
		return path;
	}
	
	
	public String getAuthor() {
		return author;
	}
	
	public int getTaskIdentification() {
		return taskId.getTaskId();
	}
	public void setTaskIdentification(Task taskIdentification) {
		this.taskId = taskIdentification;
	}
	
	
}
