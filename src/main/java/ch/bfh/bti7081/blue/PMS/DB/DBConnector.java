package ch.bfh.bti7081.blue.PMS.DB;

import java.awt.List;
import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import ch.bfh.bti7081.blue.PMS.model.LoginAccount;
import ch.bfh.bti7081.blue.PMS.model.Information;

public class DBConnector {

	private String accountUsername;
	private static DBConnector dbConnector = null;
	private EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("relativeHelper");
	private EntityManager em = emFactory.createEntityManager();

	private DBConnector() {
	}

	public static DBConnector getDBConnector() {
		if (dbConnector == null) {
			return dbConnector = new DBConnector();
		}
		return dbConnector;
	}
	
	public LoginAccount getLoginAccount() {
		LoginAccount loginAccount = em.find(LoginAccount.class, accountUsername);
		return loginAccount;
	}
	
	
	public void writeDataToDB() {
		em.getTransaction().begin();
		em.persist(this.getLoginAccount());
		em.getTransaction().commit();
		em.clear();
	}
	
	public String getAccountUsername() {
		return accountUsername;
	}

	public void setAccountUsername(String accountUsername) {
		this.accountUsername = accountUsername;
	}
	
	public Collection<Information> getAllInformations() {
		Query query= em.createQuery("SELECT i FROM Information i");
		return (Collection<Information>) query.getResultList();
	}
	

}
