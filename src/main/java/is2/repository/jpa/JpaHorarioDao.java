package is2.repository.jpa;

import is2.domain.Horario;
import is2.repository.HorarioDao;

public class JpaHorarioDao extends JpaGenericDao<Horario, Long> implements HorarioDao{

	@Override
	protected Class<Horario> getClase() {
		return Horario.class;
	}

}
