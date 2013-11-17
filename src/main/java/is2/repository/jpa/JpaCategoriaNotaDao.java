package is2.repository.jpa;

import is2.domain.CategoriaNota;
import is2.repository.CategoriaNotaDao;

public class JpaCategoriaNotaDao extends JpaGenericDao<CategoriaNota,Long> implements CategoriaNotaDao{

	@Override
	protected Class<CategoriaNota> getClase() {
		return CategoriaNota.class;
	}

}
