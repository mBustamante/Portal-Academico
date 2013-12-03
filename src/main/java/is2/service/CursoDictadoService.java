package is2.service;
import is2.domain.CursoDictado;
import is2.repository.CursoDictadoDao;
import javax.inject.Inject;

import org.springframework.stereotype.Service;

@Service
public class CursoDictadoService {
	@Inject
	CursoDictadoDao cursoDictadoDao;
	
	public CursoDictado find(Long id)
	{
		return cursoDictadoDao.find(id);
	}

}
