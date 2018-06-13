package ch.bfh.bti7081.blue.PMS.model;

import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class LoginAccount {

	@Id
	private String username;
	private String firstName;
	private String lastName;
	private String street;
	private String zipCode;
	private String city;
	private String password;

	public LoginAccount() {
	}

	public LoginAccount(String firstName, String lastName, String street, String zipCode, String city, String email,
			String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.street = street;
		this.zipCode = zipCode;
		this.city = city;
		this.username = email;
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
