package is2.repository.jpa;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import is2.domain.Curso;
import is2.repository.CursoDao;

@Repository
public class JpaCursoDao extends JpaGenericDao<Curso, Long> implements CursoDao{

	@Override
	public  Class<Curso> getClase()
	{
		return Curso.class;
	}
	
	public String getNombre()
	{
		return Curso.class.getName();
	}
/*	
	@Override
	public List<Curso> findAll() {
		TypedQuery<Curso> query = entityManager.createNamedQuery(Curso.FIND_ALL, Curso.class);
		return query.getResultList();
}
*/
}
