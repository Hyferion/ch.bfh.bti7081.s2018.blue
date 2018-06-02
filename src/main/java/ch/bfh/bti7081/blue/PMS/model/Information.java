package ch.bfh.bti7081.blue.PMS.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Information {
	
	@Id
	private String name;

	private String text;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
}
