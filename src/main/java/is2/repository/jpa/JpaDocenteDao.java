package is2.repository.jpa;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import is2.domain.Docente;
import is2.repository.DocenteDao;

@Repository
public class JpaDocenteDao extends JpaGenericDao<Docente, Long> implements DocenteDao{

	@Override
	protected Class<Docente> getClase() {
		return Docente.class;
	}

	@Override
	public Docente findByUsername(String usuario) {
		TypedQuery<Docente> query = entityManager.createNamedQuery(Docente.FIND_BY_USER, Docente.class);
		query.setParameter("usuario", usuario);
		return getFirstResult(query);
	}

	@Override
	public boolean existsDocente(String username, String password) {
		Docente test = findByUsername(username);
		if (test!=null && test.getPassword().equals(password)) return true;
		else return false;
	}

	@Override
	public boolean existsByUsername(String username) {
		Docente test = findByUsername(username);
		if (test != null)return true;
		else return false;
	}


}
