package is2.repository.jpa;
import is2.domain.BaseEntity;
import is2.repository.GenericDao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

public abstract class JpaGenericDao<T extends BaseEntity<PK>, PK extends Number> 
	implements GenericDao<T, PK> {
	
	 	protected abstract Class<T> getClase();

		Logger logger = LoggerFactory.getLogger(getClass());

		@PersistenceContext
		transient EntityManager entityManager;

		protected Class<T> entityClass = getEntityClass();

		protected Class<PK> primaryKeyClass = getPrimaryKeyClass();

		@SuppressWarnings("unchecked")
		@Override
		public Class<T> getEntityClass() {
			if (entityClass == null) {
				ParameterizedType thisType = (ParameterizedType) getClass().getGenericSuperclass();
				entityClass = (Class<T>) thisType.getActualTypeArguments()[0];
			}
			return entityClass;
		}

		@SuppressWarnings("unchecked")
		@Override
		public Class<PK> getPrimaryKeyClass() {
			if (primaryKeyClass == null) {
				ParameterizedType thisType = (ParameterizedType) getClass().getGenericSuperclass();
				primaryKeyClass = (Class<PK>) thisType.getActualTypeArguments()[1];
			}
			return primaryKeyClass;
		}

		@Override
		@Transactional
		public T persist(T entity) {
			if (logger.isDebugEnabled()) {
				logger.debug("Persisting: " + entity);
			}
			this.entityManager.persist(entity);
			return entity;
		}

		@Override
		@Transactional
		public void remove(T entity) {
			this.entityManager.createQuery("DELETE FROM " + entityClass.getSimpleName() + " e WHERE e.id = :id")
			.setParameter("id", entity.getId()).executeUpdate();
		}

		@Override
		@Transactional
		public void removeById(PK id) {
			this.entityManager.createQuery("DELETE FROM " + entityClass.getSimpleName() + " e WHERE e.id = :id")
			.setParameter("id", id).executeUpdate();
		}

		@Override
		public int removeAll(boolean isConfirmed) {
			EntityTransaction tx = entityManager.getTransaction();
			tx.begin();
			int countDeleted = entityManager.createQuery("DELETE " + entityClass.getSimpleName())
			    .executeUpdate();
			if (isConfirmed) {
				tx.commit();
			}
			else {
				tx.rollback();
			}
			return countDeleted;
		}

		@Override
		public void flush() {
			this.entityManager.flush();
		}

		@Override
		public void clear() {
			this.entityManager.clear();
		}

		@Override
		@Transactional
		public T merge(T entity) {
			if (logger.isDebugEnabled()) {
				logger.debug("Merging: " + entity);
			}
			return this.entityManager.merge(entity);
		}

		@Override
		public long count() {
			return entityManager.createQuery("SELECT COUNT(o) FROM " + entityClass.getSimpleName() + " o",
			    Long.class).getSingleResult();
		}

		@Override
		public List<T> findAll() {
			return entityManager.createQuery("SELECT o FROM " + entityClass.getSimpleName() + " o",
			    entityClass).getResultList();
		}

		@Override
		public T find(PK id) {
			if (id == null)
				return null;
			return entityManager.find(entityClass, id);
		}

		@Override
		public T find(Class<? extends T> clazz, PK id) {
			return entityManager.find(clazz, id);
		};

		@Override
		public List<T> findEntries(int firstResult, int maxResults) {
			return entityManager
			    .createQuery("SELECT o FROM " + entityClass.getSimpleName() + " o", entityClass)
			    .setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
		}

		/**
		 * Return first result if exists else null.
		 * 
		 * @param query
		 * @return
		 */
		protected T getFirstResult(TypedQuery<T> query) {
			List<T> results = query.getResultList();
			return results.isEmpty() ? null : results.get(0);
		}
 
	 
}
