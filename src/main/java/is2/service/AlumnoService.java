package is2.service;

import java.util.List;

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
	
	public List<Alumno>  findAll()
	{
		return alumnoDao.findAll();
	}
	
	public Alumno findByUsername(String username)
	{
		return alumnoDao.findByUsername(username);
	}
	public Alumno persist(Alumno alumno)
	{
		return alumnoDao.persist(alumno);
	}
	
	public Alumno merge(Alumno alumno)
	{
		return alumnoDao.merge(alumno);
	}
	
}
