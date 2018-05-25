package ch.bfh.bti7081.blue.PMS;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "files")
public class File {

	private int id;
	private String name;
	private String path;
	private String author;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
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
	
	
}
