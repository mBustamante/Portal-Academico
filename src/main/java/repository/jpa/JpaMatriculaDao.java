package repository.jpa;

import is2.Matricula;
import repository.MatriculaDao;

public class JpaMatriculaDao extends JpaGenericDao<Matricula, Long> implements MatriculaDao{

	@Override
	protected Class<Matricula> getClase() {
		return Matricula.class;
	}
	
}
