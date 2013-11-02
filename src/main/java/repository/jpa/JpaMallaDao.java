package repository.jpa;

import java.util.Collections;
import java.util.List;

import javax.persistence.TypedQuery;

import repository.MallaDao;
import is2.Malla;

public class JpaMallaDao extends JpaGenericDao<Malla, Long> implements MallaDao{

	public JpaMallaDao(Class<Malla> classtype) {
		super(classtype);
	}
	
	@Override
	public List<Malla> findAll()
	{
		try {
		      entityManager.getTransaction().begin();
		      TypedQuery<Malla> query = entityManager.createQuery(
		          "SELECT p FROM malla p", Malla.class);
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
