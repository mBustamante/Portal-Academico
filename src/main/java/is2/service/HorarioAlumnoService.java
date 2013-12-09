package is2.service;

import java.util.List;

import is2.domain.Alumno;
import is2.domain.Matricula;
import is2.repository.AlumnoDao;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

@Service
public class HorarioAlumnoService {
	
	@Inject
	AlumnoDao alumnoDao;
	
	
	public Alumno findAlumno(Long id){
		return alumnoDao.find(id);
	}
	
	public List<Matricula> getMatriculas(Long idAlumno)
	{
		Alumno alumno = findAlumno(idAlumno);
		List<Matricula> matriculas = alumno.getMatriculas();
		return matriculas;
	}
}
