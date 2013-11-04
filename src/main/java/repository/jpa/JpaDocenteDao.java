package repository.jpa;

import repository.DocenteDao;
import is2.Docente;

public class JpaDocenteDao extends JpaGenericDao<Docente, Long> implements DocenteDao{

	@Override
	protected Class<Docente> getClase() {
		return Docente.class;
	}

}
