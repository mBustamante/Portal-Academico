package repository.jpa;

import repository.CursoMallaDao;
import is2.CursoMalla;

public class JpaCursoMallaDao extends JpaGenericDao<CursoMalla, Long> implements CursoMallaDao{


	@Override
	protected Class<CursoMalla> getClase() {
		return CursoMalla.class;
	}

}
