package repository.jpa;

import java.util.Collections;
import java.util.List;

import javax.persistence.TypedQuery;

import repository.CarreraDao;
import is2.Carrera;

public class JpaCarreraDao extends JpaGenericDao<Carrera, Long> implements CarreraDao{

	public JpaCarreraDao(Class<Carrera> classtype) {
		super(classtype);
	}
	
	@Override
	public List<Carrera> findAll()
	{
		try {
		      entityManager.getTransaction().begin();
		      TypedQuery<Carrera> query = entityManager.createQuery(
		          "SELECT p FROM carrera p", Carrera.class);
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
