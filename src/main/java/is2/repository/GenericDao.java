package is2.repository;
import is2.domain.BaseEntity;

import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

public interface GenericDao<T extends BaseEntity<PK>, PK extends Serializable> {
	
	@Transactional
	T persist(T entity);

	void remove(T entity);

	void removeById(PK id);

	int removeAll(boolean isConfirmed);

	void flush();
	
	void clear();

	@Transactional
	T merge(T entity);

	long count();

	List<T> findAll();

	T find(PK id);

	T find(Class<? extends T> clazz, PK id);

	List<T> findEntries(int firstResult, int maxResults);

	Class<PK> getPrimaryKeyClass();

	Class<T> getEntityClass();
}
