package ch.bfh.bti7081.blue.PMS.model;


import javax.persistence.*;

@Entity
@Table(name="medicine")
public class OrderModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
	private String description;
	private String LOGINACCOUNT_USERNAME;
    
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String decription) {
		this.description = description;
	}




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}