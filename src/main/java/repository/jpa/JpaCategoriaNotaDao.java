package repository.jpa;

import java.util.Collections;
import java.util.List;

import javax.persistence.TypedQuery;

import repository.CategoriaNotaDao;
import is2.CategoriaNota;

public class JpaCategoriaNotaDao extends JpaGenericDao<CategoriaNota,Long> implements CategoriaNotaDao{

	public JpaCategoriaNotaDao(Class<CategoriaNota> classtype) {
		super(classtype);
	}
	
	@Override
	public List<CategoriaNota> findAll()
	{
		try {
		      entityManager.getTransaction().begin();
		      TypedQuery<CategoriaNota> query = entityManager.createQuery(
		          "SELECT p FROM categoria_nota p", CategoriaNota.class);
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
