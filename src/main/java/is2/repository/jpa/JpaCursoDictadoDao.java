package is2.repository.jpa;

import org.springframework.stereotype.Repository;

import is2.domain.CursoDictado;
import is2.repository.CursoDictadoDao;

@Repository
public class JpaCursoDictadoDao extends JpaGenericDao<CursoDictado, Long> implements CursoDictadoDao{

	@Override
	protected Class<CursoDictado> getClase() {
		return CursoDictado.class;
	}

}
