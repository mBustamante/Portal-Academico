package is2.repository.jpa;

import is2.domain.Aula;
import is2.repository.AulaDao;

public class JpaAulaDao extends JpaGenericDao<Aula, Long> implements AulaDao {

	

	@Override
	protected Class<Aula> getClase() {
		return Aula.class;
	}

}
