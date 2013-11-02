package repository.jpa;

import repository.GenericDao;
import is2.UnitPersistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

public abstract class JpaGenericDao<T,PK extends Number>  implements GenericDao<T, PK> {
	
	 private Class<T> classtype;
	 private EntityManager entityManager;
	 
	 public static EntityManager entityManager() {
			return (UnitPersistence.getInstance()).get();
		}

	 public JpaGenericDao(Class<T> classtype) {
		  this.classtype = classtype;
		  this.entityManager = UnitPersistence.getInstance().get();
	 }
	 
	 @Override
	 public T findById(PK id) {
		  return entityManager.find(classtype, id);
	 }
 
	 @Override
	 public List<T> findAll() {
		 
		 return null;
	 }
	 
	 @Override
	 public void save(T entity)
	 {
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
		 CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		 
		  CriteriaQuery<Long> cq = cb.createQuery(Long.class);
		  cq.select(cb.count(cq.from(classtype)));
		  return entityManager.createQuery(cq).getSingleResult().intValue();
	 }
	 
	 @Override
	 public void remove(T entity)
	 {
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
