package repository.jpa;

import repository.CarreraDao;
import is2.Carrera;

public class JpaCarreraDao extends JpaGenericDao<Carrera, Long> implements CarreraDao{

	@Override
	protected Class<Carrera> getClase() {
		return Carrera.class;
	}

}
