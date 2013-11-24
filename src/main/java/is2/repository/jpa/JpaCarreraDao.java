package is2.repository.jpa;

import org.springframework.stereotype.Repository;

import is2.domain.Carrera;
import is2.repository.CarreraDao;

@Repository
public class JpaCarreraDao extends JpaGenericDao<Carrera, Long> implements CarreraDao{

	@Override
	protected Class<Carrera> getClase() {
		return null;
	}

}
