package is2.repository.jpa;

import org.springframework.stereotype.Repository;

import is2.domain.Periodo;
import is2.repository.PeriodoDao;

@Repository
public class JpaPeriodoDao extends JpaGenericDao<Periodo, Long> implements PeriodoDao{


	@Override
	protected Class<Periodo> getClase() {
		return Periodo.class;
	}

}
