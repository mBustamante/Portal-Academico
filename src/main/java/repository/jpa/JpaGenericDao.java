package repository.jpa;

import repository.GenericDao;
import is2.UnitPersistence;

import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

public abstract class JpaGenericDao<T,PK extends Number>  implements GenericDao<T, PK> {
	 protected abstract Class<T> getClase();

	 
	 @Override
	 public T findById(PK id) {
		 EntityManager entityManager =(UnitPersistence.getInstance()).get();
		  return entityManager.find(getClase(), id);
	 }
 
	 @Override
	 public List<T> findAll() {
		 EntityManager entityManager = (UnitPersistence.getInstance()).get();
	        try {
	                entityManager.getTransaction().begin();
	                String q = "SELECT p FROM " + getClase().getSimpleName() +" p";
	                TypedQuery<T> query = entityManager.createQuery(q, getClase());
	                return query.getResultList();
	        } catch (Exception e) {
	                System.out.println("Error");
	                e.printStackTrace();
	        } finally {
	                entityManager.close();
	        }
	        return Collections.emptyList();
	 }
	 
	 @Override
	 public void save(T entity)
	 {
		 EntityManager entityManager =(UnitPersistence.getInstance()).get();
			try {
				entityManager.getTransaction().begin();
				entityManager.persist(entity);
			} catch (Exception e) {
				System.out.println("Error");
				e.printStackTrace();
			} finally {
				entityManager.close();
			}		 
	 }
	 
	 @Override
	 public void update(T entity)
	 {
		 EntityManager entityManager =(UnitPersistence.getInstance()).get();
		 try {
				entityManager.getTransaction().begin();
				entityManager.merge(entity);
			} catch (Exception e) {
				System.out.println("Error");
				e.printStackTrace();
			} finally {
				entityManager.close();
			}
	 }
	 
	 @Override
	 public long count()
	 {
		 EntityManager entityManager =(UnitPersistence.getInstance()).get();
		 CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		 
		  CriteriaQuery<Long> cq = cb.createQuery(Long.class);
		  cq.select(cb.count(cq.from(getClase())));
		  return entityManager.createQuery(cq).getSingleResult().intValue();
	 }
	 
	 @Override
	 public void remove(T entity)
	 {
		 EntityManager entityManager =(UnitPersistence.getInstance()).get();
		 try {
				entityManager.getTransaction().begin();
				entityManager.remove(entity);
			} catch (Exception e) {
				System.out.println("Error");
				e.printStackTrace();
			} finally {
				entityManager.close();
			}
		 
	 }
	 
	 @Override
	 public boolean exists(PK id)
	 {
		 T temp= findById(id);
		 if (temp == null)	return false;
		 else return true;
	 }
 
	 
}
