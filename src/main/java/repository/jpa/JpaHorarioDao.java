package repository.jpa;

import is2.Horario;

import java.util.Collections;
import java.util.List;

import javax.persistence.TypedQuery;

import repository.HorarioDao;

public class JpaHorarioDao extends JpaGenericDao<Horario, Long> implements HorarioDao{

	public JpaHorarioDao(Class<Horario> classtype) {
		super(classtype);
	}
	
	@Override
	public List<Horario> findAll()
	{
		try {
		      entityManager.getTransaction().begin();
		      TypedQuery<Horario> query = entityManager.createQuery(
		          "SELECT p FROM horario p", Horario.class);
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
