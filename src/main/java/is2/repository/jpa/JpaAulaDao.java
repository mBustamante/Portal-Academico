package is2.repository.jpa;

import is2.domain.Aula;
import is2.repository.AulaDao;
import org.springframework.stereotype.Repository;

@Repository
public class JpaAulaDao extends JpaGenericDao<Aula, Long> implements AulaDao {

	

	@Override
	public Class<Aula> getClase() {
		return Aula.class;
	}
	
	public String getNombre()
	{
		return Aula.class.getName();
	}

}
