/*package ch.bfh.bti7081.blue.PMS;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class TaskDBManager {

	private EntityManagerFactory factory;
	private EntityManager entityManager;

	public TaskDBManager() {
		initializeEntityManager();

	}

	private void initializeEntityManager() {
		factory = Persistence.createEntityManagerFactory("Tasks");
		entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
	}

	public Collection<javafx.concurrent.Task> queryTasks(String filter) {

		String sqlCMD = null;
		LocalDateTime now = LocalDateTime.now();

		switch (filter) {
		case "Today":
			sqlCMD = "SELECT * FROM tasks" + "WHERE dueDate = " + dateTime(now, 0);
			break;
		case "Next 7 Days":
			sqlCMD = "SELECT * FROM tasks" + "WHERE dueDate " + "BETWEEN #" + dateTime(now, 0) + "# AND #"
					+ dateTime(now, 7);
			break;
		case "Next 14 Days":
			sqlCMD = "SELECT * FROM tasks" + "WHERE dueDate " + "BETWEEN #" + dateTime(now, 0) + "# AND #"
					+ dateTime(now, 14);
			break;
		case "Next 30 Days":
			sqlCMD = "SELECT * FROM tasks" + "WHERE dueDate " + "BETWEEN #" + dateTime(now, 0) + "# AND #"
					+ dateTime(now, 30);
			break;
		case "Show All": 
		default: sqlCMD = "SELECT * FROM tasks";
			break;
		}

		Query query = entityManager.createQuery(sqlCMD);
		return query.getResultList();
	}

	private String dateTime(LocalDateTime now, int days) {
		return LocalDateTime.now().plusDays(days).format(DateTimeFormatter.ofPattern("dd.MM.yyyy, HH:MI"));
	}
}*/
