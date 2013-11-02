package repository.jpa;

import java.util.Collections;
import java.util.List;

import javax.persistence.TypedQuery;

import repository.DocenteDao;
import is2.Docente;

public class JpaDocenteDao extends JpaGenericDao<Docente, Long> implements DocenteDao{

	public JpaDocenteDao(Class<Docente> classtype) {
		super(classtype);
	}
	
	@Override
	public List<Docente> findAll()
	{
		try {
		      entityManager.getTransaction().begin();
		      TypedQuery<Docente> query = entityManager.createQuery(
		          "SELECT p FROM docente p", Docente.class);
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
