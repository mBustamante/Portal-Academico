package is2.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import is2.domain.CategoriaNota;
import is2.repository.CategoriaNotaDao;

@Service
public class CategoriaNotaService {

	@Inject
	CategoriaNotaDao categoriaNotaDao;
	
	public List<CategoriaNota> findAll(){
		return categoriaNotaDao.findAll();
	}
}
