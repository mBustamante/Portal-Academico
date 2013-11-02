package repository.jpa;

import java.util.Collections;
import java.util.List;

import javax.persistence.TypedQuery;

import is2.Alumno;
import repository.AlumnoDao;

public class JpaAlumnoDao extends JpaGenericDao<Alumno, Long> implements AlumnoDao {

	public JpaAlumnoDao(Class<Alumno> classtype) {
		super(classtype);
	}
	
	@Override
	public List<Alumno> findAll()
	{
		try {
		      entityManager.getTransaction().begin();
		      TypedQuery<Alumno> query = entityManager.createQuery(
		          "SELECT p FROM alumno p", Alumno.class);
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
