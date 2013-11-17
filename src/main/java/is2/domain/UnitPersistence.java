package is2.domain;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UnitPersistence {
	private String up;
	protected EntityManagerFactory factory;
	protected EntityManager em;
	private static UnitPersistence instance;

	private UnitPersistence() {
		up = "app1";
		factory = Persistence.createEntityManagerFactory(up, System.getProperties());
	}
	
	public static UnitPersistence getInstance() {
		if (instance == null) {
			instance = new UnitPersistence();
		}
		return instance;
	}
	
	public EntityManager get(){
		em = factory.createEntityManager();
		return em;
	}
}
