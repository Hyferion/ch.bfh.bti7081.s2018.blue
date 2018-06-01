package ch.bfh.bti7081.blue.PMS.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import ch.bfh.bti7081.blue.PMS.DB.DBConnector;

@Entity
public class InformationModel {

	@Id
	private String name;

	private String krankheitTitle;
	private String beschreibungKrankheit;


	public InformationModel() {
	}
	
	public List<Information> getAllInformations() {
		Information i = new Information();
		i.setBeschreibungKrankheit("eine Beschreibung");
		i.setName("Krankheit");
		i.setKrankheitTitle("krankheitTitle");
		List<Information> informationen = new ArrayList<>();
		informationen.add(i);
		return informationen;
		
		//return (List<Information>) DBConnector.getDBConnector().getAllInformations();
	}

	public InformationModel(String krankheitTitle, String beschreibungKrankheit) {
		super();
		this.krankheitTitle = krankheitTitle;
		this.beschreibungKrankheit = beschreibungKrankheit;
	}

	public String getKrankheitTitle() {
		return krankheitTitle;
	}

	public void setKrankheitTitle(String krankheitTitle) {
		this.krankheitTitle = krankheitTitle;
	}

	public String getbeschreibungKrankheit() {
		return beschreibungKrankheit;
	}

	public void setBeschreibungKrankheit(String beschreibungKrankheit) {
		this.beschreibungKrankheit = beschreibungKrankheit;
	}
}