package is2.repository.jpa;

import org.springframework.stereotype.Repository;

import is2.domain.Matricula;
import is2.repository.MatriculaDao;

@Repository
public class JpaMatriculaDao extends JpaGenericDao<Matricula, Long> implements MatriculaDao{

	@Override
	protected Class<Matricula> getClase() {
		return Matricula.class;
	}
	
}
