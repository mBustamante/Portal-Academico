package repository.jpa;

import java.util.Collections;
import java.util.List;

import javax.persistence.TypedQuery;

import repository.PeriodoDao;
import is2.Periodo;

public class JpaPeriodoDao extends JpaGenericDao<Periodo, Long> implements PeriodoDao{

	public JpaPeriodoDao(Class<Periodo> classtype) {
		super(classtype);
	}
	
	@Override
	public List<Periodo> findAll()
	{
		try {
		      entityManager.getTransaction().begin();
		      TypedQuery<Periodo> query = entityManager.createQuery(
		          "SELECT p FROM periodo p", Periodo.class);
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
