package is2.service;

import java.util.List;

import is2.domain.Docente;
import is2.domain.CursoDictado;
import is2.repository.DocenteDao;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

@Service
public class HorarioDocenteService {
	
	@Inject
	DocenteDao docenteDao;
	
	
	public Docente findDocente(Long id){
		return docenteDao.find(id);
	}
	
	public List<CursoDictado> getCursosDictados(Long idDocente)
	{
		Docente docente= findDocente(idDocente);
		List<CursoDictado> cursosDictados = docente.getCursosDictados();
		return cursosDictados;
	}
}
