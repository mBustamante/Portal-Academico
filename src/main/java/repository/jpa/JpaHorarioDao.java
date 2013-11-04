package repository.jpa;

import is2.Horario;

import repository.HorarioDao;

public class JpaHorarioDao extends JpaGenericDao<Horario, Long> implements HorarioDao{

	@Override
	protected Class<Horario> getClase() {
		return Horario.class;
	}

}
