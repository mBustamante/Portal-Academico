package repository.jpa;

import java.util.Collections;
import java.util.List;

import javax.persistence.TypedQuery;

import repository.CursoMallaDao;
import is2.Alumno;
import is2.CursoMalla;

public class JpaCursoMallaDao extends JpaGenericDao<CursoMalla, Long> implements CursoMallaDao{

	public JpaCursoMallaDao(Class<CursoMalla> classtype) {
		super(classtype);
	}
	
	@Override
	public List<CursoMalla> findAll()
	{
		try {
		      entityManager.getTransaction().begin();
		      TypedQuery<CursoMalla> query = entityManager.createQuery(
		          "SELECT p FROM cursomalla p", CursoMalla.class);
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
