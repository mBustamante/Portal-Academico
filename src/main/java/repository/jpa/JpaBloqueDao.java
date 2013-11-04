package repository.jpa;

import repository.BloqueDao;
import is2.Bloque;

public class JpaBloqueDao extends JpaGenericDao<Bloque, Long> implements BloqueDao{

	@Override
	protected Class<Bloque> getClase() {
		return Bloque.class;
	}

}
