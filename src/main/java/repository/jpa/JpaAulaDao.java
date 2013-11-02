package repository.jpa;

import java.util.Collections;
import java.util.List;

import javax.persistence.TypedQuery;

import repository.AulaDao;
import is2.Aula;

public class JpaAulaDao extends JpaGenericDao<Aula, Long> implements AulaDao {

	public JpaAulaDao(Class<Aula> classtype) {
		super(classtype);
	}
	
	
	@Override
	public List<Aula> findAll()
	{
		try {
		      entityManager.getTransaction().begin();
		      TypedQuery<Aula> query = entityManager.createQuery(
		          "SELECT p FROM aula p", Aula.class);
		      return query.getResultList();
		    } catch (Exception e) {
		      System.out.println("Error");
		      e.printStackTrace();
		    } finally {
		      entityManager.close();
		    }
		    return Collections.emptyList();
	}

}
