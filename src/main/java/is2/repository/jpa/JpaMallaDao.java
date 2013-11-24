package is2.repository.jpa;

import org.springframework.stereotype.Repository;

import is2.domain.Malla;
import is2.repository.MallaDao;

@Repository
public class JpaMallaDao extends JpaGenericDao<Malla, Long> implements MallaDao{

	@Override
	protected Class<Malla> getClase() {
		return Malla.class;
	}
	
	public String getNombre(){
		return Malla.class.getName();
	}

}
