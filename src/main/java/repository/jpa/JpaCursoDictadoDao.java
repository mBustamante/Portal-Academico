package repository.jpa;

import repository.CursoDictadoDao;
import is2.CursoDictado;

public class JpaCursoDictadoDao extends JpaGenericDao<CursoDictado, Long> implements CursoDictadoDao{

	@Override
	protected Class<CursoDictado> getClase() {
		return CursoDictado.class;
	}

}
