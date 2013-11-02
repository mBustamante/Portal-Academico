package repository.jpa;

import java.util.Collections;
import java.util.List;

import javax.persistence.TypedQuery;

import repository.BloqueDao;
import is2.Bloque;

public class JpaBloqueDao extends JpaGenericDao<Bloque, Long> implements BloqueDao{

	public JpaBloqueDao(Class<Bloque> classtype) {
		super(classtype);
		
	}
	
	@Override
	public List<Bloque> findAll()
	{
		try {
		      entityManager.getTransaction().begin();
		      TypedQuery<Bloque> query = entityManager.createQuery(
		          "SELECT p FROM bloque p", Bloque.class);
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
