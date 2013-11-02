package repository.jpa;

import java.util.Collections;
import java.util.List;

import javax.persistence.TypedQuery;

import repository.CursoDao;
import is2.Alumno;
import is2.Curso;

public class JpaCursoDao extends JpaGenericDao<Curso, Long> implements CursoDao{

	public JpaCursoDao(Class<Curso> classtype) {
		super(classtype);
	}
	
	
	@Override
	public List<Curso> findAll()
	{
		try {
		      entityManager.getTransaction().begin();
		      TypedQuery<Curso> query = entityManager.createQuery(
		          "SELECT p FROM curso p", Curso.class);
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
