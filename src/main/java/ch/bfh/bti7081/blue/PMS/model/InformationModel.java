package ch.bfh.bti7081.blue.PMS.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class InformationModel {

	@Id
	private String name;

	private String krankheitTitle;
	private String beschreibungKrankheit;


	public InformationModel() {
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