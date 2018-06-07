package ch.bfh.bti7081.blue.PMS.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "orderstatussimon")
public class OrderStatus {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private long id;
	
	private String date;
	private String name;
	private String LOGINACCOUNT_USERNAME;
	private String status;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@PrimaryKeyJoinColumn(name = "LOGINACCOUNT_USERNAME")
	private LoginAccount loginAccount;

	public OrderStatus() {
	}

	public String getLOGINACCOUNT_USERNAME() {
		return LOGINACCOUNT_USERNAME;
	}

	public void setLOGINACCOUNT_USERNAME(String lOGINACCOUNT_USERNAME) {
		LOGINACCOUNT_USERNAME = lOGINACCOUNT_USERNAME;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
 
	public Long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String string) {
		this.date = string;
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