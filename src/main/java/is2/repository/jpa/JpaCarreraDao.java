package is2.repository.jpa;

import is2.domain.Carrera;
import is2.repository.CarreraDao;

public class JpaCarreraDao extends JpaGenericDao<Carrera, Long> implements CarreraDao{

	@Override
	protected Class<Carrera> getClase() {
		return Carrera.class;
	}

}
