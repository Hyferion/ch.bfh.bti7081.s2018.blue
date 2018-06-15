package ch.bfh.bti7081.blue.PMS.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import ch.bfh.bti7081.blue.PMS.DB.DBConnector;

/**
 * 
 * @author Sinthujah Kaneshan
 *
 */
public class InformationModelController {
	private Set<Information> Information;

	private static DBConnector dbConnector = null;
	private EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("relativeHelper");
	private EntityManager em = emFactory.createEntityManager();
	private List<Information> informations;

	public InformationModelController() {
		Information = new HashSet<>();
		DBConnector dbConnector = DBConnector.getDBConnector();
		LoginAccount loginAccount = dbConnector.getLoginAccount();

		Query q = em.createQuery("Select i From Information i");

		informations = q.getResultList();

		for (Information information : informations) {
			System.out.println(information.getName());
			System.out.println(information.getText());

		}

	}

	public Set<Information> getInformation() {
		return this.Information;
	}

	public List<Information> getInformations() {
		return informations;
	}

}