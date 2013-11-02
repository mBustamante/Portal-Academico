package repository.jpa;

import java.util.Collections;
import java.util.List;

import javax.persistence.TypedQuery;

import repository.AdminDao;
import is2.Admin;
import is2.Alumno;

public class JpaAdminDao extends JpaGenericDao<Admin,Long> implements AdminDao {

	public JpaAdminDao(Class<Admin> classtype) {
		super(classtype);
	}
	
	public List<Admin> findAll()
	{
		try {
		      entityManager.getTransaction().begin();
		      TypedQuery<Admin> query = entityManager.createQuery(
		          "SELECT p FROM admin p", Admin.class);
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
