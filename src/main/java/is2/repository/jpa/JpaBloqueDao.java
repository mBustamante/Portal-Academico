package is2.repository.jpa;

import is2.domain.Bloque;
import is2.repository.BloqueDao;

public class JpaBloqueDao extends JpaGenericDao<Bloque, Long> implements BloqueDao{

	@Override
	protected Class<Bloque> getClase() {
		return Bloque.class;
	}

}
