package is2.repository.jpa;

import is2.domain.Nota;
import is2.repository.NotaDao;

public class JpaNotaDao extends JpaGenericDao<Nota, Long> implements NotaDao{

	@Override
	protected Class<Nota> getClase() {
		return Nota.class;
	}

}
