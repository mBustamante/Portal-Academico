package is2.service;

import java.util.List;

import is2.domain.Alumno;
import is2.domain.Curso;
import is2.repository.AlumnoDao;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

@Service
public class MatriculaAlumnoService {
	
	@Inject
	AlumnoDao alumnoDao;
	
	
	public Alumno findAlumno(Long id)
	{
		return alumnoDao.find(id);
	}
	
	public List<Curso> findCursosDisponibles(Long id)
	{
		return alumnoDao.findCursosDisponibles(id);
	}
	
	public List<Curso> getCursosDisponibles(Long idAlumno)
	{
		List<Curso> cursos = findCursosDisponibles(idAlumno);
		return cursos;
	}
}