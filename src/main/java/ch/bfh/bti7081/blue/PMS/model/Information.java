package ch.bfh.bti7081.blue.PMS.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Information {
	
	@Id
	private String name;

	private String krankheitTitle;
	private String beschreibungKrankheit;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getKrankheitTitle() {
		return krankheitTitle;
	}
	public void setKrankheitTitle(String krankheitTitle) {
		this.krankheitTitle = krankheitTitle;
	}
	public String getBeschreibungKrankheit() {
		return beschreibungKrankheit;
	}
	public void setBeschreibungKrankheit(String beschreibungKrankheit) {
		this.beschreibungKrankheit = beschreibungKrankheit;
	}

	
}
