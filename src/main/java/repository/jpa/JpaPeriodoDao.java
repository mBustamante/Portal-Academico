package repository.jpa;

import repository.PeriodoDao;
import is2.Periodo;

public class JpaPeriodoDao extends JpaGenericDao<Periodo, Long> implements PeriodoDao{


	@Override
	protected Class<Periodo> getClase() {
		return Periodo.class;
	}

}
