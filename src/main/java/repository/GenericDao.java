package repository;
import java.util.List;

public interface GenericDao<T ,PK extends Number> {
	
	
	public void save(T entity);

    public void update(T entity);

    public void remove(T entity);

    public T findById(PK id);

    public long count();
    
    public boolean exists(PK id);

    public List<T> findAll();
}
