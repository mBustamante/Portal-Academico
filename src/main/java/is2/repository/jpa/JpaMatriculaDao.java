package is2.repository.jpa;

import is2.domain.Matricula;
import is2.repository.MatriculaDao;

public class JpaMatriculaDao extends JpaGenericDao<Matricula, Long> implements MatriculaDao{

	@Override
	protected Class<Matricula> getClase() {
		return Matricula.class;
	}
	
}
