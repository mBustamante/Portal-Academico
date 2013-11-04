package repository.jpa;

import repository.AulaDao;
import is2.Aula;

public class JpaAulaDao extends JpaGenericDao<Aula, Long> implements AulaDao {

	

	@Override
	protected Class<Aula> getClase() {
		return Aula.class;
	}

}
