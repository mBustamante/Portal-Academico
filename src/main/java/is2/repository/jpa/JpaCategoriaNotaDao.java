package is2.repository.jpa;

import org.springframework.stereotype.Repository;

import is2.domain.CategoriaNota;
import is2.repository.CategoriaNotaDao;

@Repository
public class JpaCategoriaNotaDao extends JpaGenericDao<CategoriaNota,Long> implements CategoriaNotaDao{

	@Override
	protected Class<CategoriaNota> getClase() {
		return CategoriaNota.class;
	}

}
