package is2.repository.jpa;

import is2.domain.CursoMalla;
import is2.repository.CursoMallaDao;

public class JpaCursoMallaDao extends JpaGenericDao<CursoMalla, Long> implements CursoMallaDao{


	@Override
	protected Class<CursoMalla> getClase() {
		return CursoMalla.class;
	}

}
