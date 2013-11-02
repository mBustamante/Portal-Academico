package repository.jpa;

import java.util.Collections;
import java.util.List;

import javax.persistence.TypedQuery;

import is2.Alumno;
import is2.Matricula;
import repository.MatriculaDao;

public class JpaMatriculaDao extends JpaGenericDao<Matricula, Long> implements MatriculaDao{

	public JpaMatriculaDao(Class<Matricula> classtype) {
		super(classtype);
		
	}
	
	@Override
	public List<Matricula> findAll()
	{
		try {
		      entityManager.getTransaction().begin();
		      TypedQuery<Matricula> query = entityManager.createQuery(
		          "SELECT p FROM matricula p", Matricula.class);
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
