package repository.jpa;

import java.util.Collections;
import java.util.List;
import javax.persistence.TypedQuery;
import repository.NotaDao;
import is2.Nota;

public class JpaNotaDao extends JpaGenericDao<Nota, Long> implements NotaDao{

	public JpaNotaDao(Class<Nota> classtype) {
		super(classtype);
	}
	
	@Override
	public List<Nota> findAll()
	{
		try {
		      entityManager.getTransaction().begin();
		      TypedQuery<Nota> query = entityManager.createQuery(
		          "SELECT p FROM nota p", Nota.class);
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
