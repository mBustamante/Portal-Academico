package is2.repository.jpa;

import is2.domain.Malla;
import is2.repository.MallaDao;

public class JpaMallaDao extends JpaGenericDao<Malla, Long> implements MallaDao{

	@Override
	protected Class<Malla> getClase() {
		return Malla.class;
	}

}
