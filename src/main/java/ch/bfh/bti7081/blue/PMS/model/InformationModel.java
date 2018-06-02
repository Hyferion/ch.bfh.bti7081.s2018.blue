package ch.bfh.bti7081.blue.PMS.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

//import ch.bfh.bti7081.blue.PMS.DB.DBConnector;

@Entity
public class InformationModel {

	@Id
	private String name;
	private String text;

	public InformationModel() {
	}
	
	//public List<Information> getAllInformations() {
	//	return (List<Information>) DBConnector.getDBConnector().getAllInformations();
	//}

	public InformationModel(String name, String text) {
		super();
		this.name = name;
		this.text = text;
	}

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