package ch.bfh.bti7081.blue.PMS.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class OrderStatus {
	@Id
	@GeneratedValue
	private int id;

	private String date;
	private String status;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "LOGINACCOUNT_USERNAME")
	private LoginAccount loginAccount;

	public OrderStatus() {
	}

	public OrderStatus(int id, String date, String status) {
		super();
		this.id = id;
		this.date = date;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LoginAccount getLoginAccount() {
		return loginAccount;
	}

	public void setLoginAccount(LoginAccount loginAccount) {
		this.loginAccount = loginAccount;
	}

}
