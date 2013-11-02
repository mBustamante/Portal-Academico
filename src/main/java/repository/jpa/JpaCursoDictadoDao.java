package repository.jpa;

import java.util.Collections;
import java.util.List;

import javax.persistence.TypedQuery;

import repository.CursoDictadoDao;
import is2.Alumno;
import is2.CursoDictado;

public class JpaCursoDictadoDao extends JpaGenericDao<CursoDictado, Long> implements CursoDictadoDao{

	public JpaCursoDictadoDao(Class<CursoDictado> classtype) {
		super(classtype);
	}
	
	@Override
	public List<CursoDictado> findAll()
	{
		try {
		      entityManager.getTransaction().begin();
		      TypedQuery<CursoDictado> query = entityManager.createQuery(
		          "SELECT p FROM cursodictado p", CursoDictado.class);
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
