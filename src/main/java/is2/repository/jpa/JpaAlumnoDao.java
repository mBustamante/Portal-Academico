package is2.repository.jpa;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import is2.domain.Alumno;
import is2.domain.Curso;
import is2.repository.AlumnoDao;

@Repository
public class JpaAlumnoDao extends JpaGenericDao<Alumno, Long> implements AlumnoDao {
	
	@Override
	public Alumno findByUsername(String usuario) {
		TypedQuery<Alumno> query = entityManager.createNamedQuery(Alumno.FIND_BY_USER, Alumno.class);
		query.setParameter("usuario", usuario);
		return getFirstResult(query);
	}

	@Override
	public boolean existsUser(String username, String password) {
		Alumno test = findByUsername(username);
		if (test!=null && test.getPassword().equals(password)) {
			return true;}
		else return false;
	}

	@Override
	public boolean existsByUsername(String username) {
		Alumno test = findByUsername(username);
		if (test != null)return true;
		else return false;
	}

	@Override
	protected Class<Alumno> getClase() {
		return Alumno.class;
	}

	@Override
	public List<Curso> findCursosDisponibles(Long id) {
		TypedQuery<Curso> query = entityManager.createNamedQuery(Alumno.FIND_CURSOS, Curso.class);
		List<Curso> results = query.getResultList();
		return results;
	}
}
