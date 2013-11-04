package repository.jpa;

import repository.MallaDao;
import is2.Malla;

public class JpaMallaDao extends JpaGenericDao<Malla, Long> implements MallaDao{

	@Override
	protected Class<Malla> getClase() {
		return Malla.class;
	}

}
