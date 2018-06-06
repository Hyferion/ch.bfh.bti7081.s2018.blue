package ch.bfh.bti7081.blue.PMS.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="medicine")
public class OrderStatusModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
	private String LOGINACCOUNT_USERNAME;
	private String date;
	private String state;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLOGINACCOUNT_USERNAME() {
		return LOGINACCOUNT_USERNAME;
	}
	public void setLOGINACCOUNT_USERNAME(String lOGINACCOUNT_USERNAME) {
		LOGINACCOUNT_USERNAME = lOGINACCOUNT_USERNAME;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
    

}