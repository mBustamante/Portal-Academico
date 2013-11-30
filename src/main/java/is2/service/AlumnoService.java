package is2.service;

import is2.domain.Alumno;
import is2.repository.AlumnoDao;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

@Service
public class AlumnoService {

	@Inject
	AlumnoDao alumnoDao;
	
	public Alumno find(Long id){
		return alumnoDao.find(id);
	}
}
