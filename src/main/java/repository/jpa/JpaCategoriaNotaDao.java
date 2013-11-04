package repository.jpa;

import repository.CategoriaNotaDao;
import is2.CategoriaNota;

public class JpaCategoriaNotaDao extends JpaGenericDao<CategoriaNota,Long> implements CategoriaNotaDao{

	@Override
	protected Class<CategoriaNota> getClase() {
		return CategoriaNota.class;
	}

}
