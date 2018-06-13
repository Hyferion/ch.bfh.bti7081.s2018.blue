package ch.bfh.bti7081.blue.PMS.DB;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import ch.bfh.bti7081.blue.PMS.model.LoginAccount;
import ch.bfh.bti7081.blue.PMS.model.Task;

public class DBConnector {

	private String accountUsername;
	private int taskIde;
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
	
	public Task getTaskId() {
		return em.find(Task.class, taskIde);
	}

	public void writeDataToDB() {
		em.getTransaction().begin();
		em.persist(this.getLoginAccount());
		em.getTransaction().commit();
		em.clear();
	}
	
	public EntityManager getEntityManager() {
		return this.em;
	}
	
	public String getAccountUsername() {
		return accountUsername;
	}

	public void setAccountUsername(String accountUsername) {
		this.accountUsername = accountUsername;
	}
	

}
