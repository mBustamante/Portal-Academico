package is2.repository.jpa;

import org.springframework.stereotype.Repository;

import is2.domain.Docente;
import is2.repository.DocenteDao;

@Repository
public class JpaDocenteDao extends JpaGenericDao<Docente, Long> implements DocenteDao{

	@Override
	protected Class<Docente> getClase() {
		return Docente.class;
	}

}
