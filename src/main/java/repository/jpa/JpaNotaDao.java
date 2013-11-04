package repository.jpa;

import repository.NotaDao;
import is2.Nota;

public class JpaNotaDao extends JpaGenericDao<Nota, Long> implements NotaDao{

	@Override
	protected Class<Nota> getClase() {
		return Nota.class;
	}

}
