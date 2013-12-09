package is2.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import is2.domain.Alumno;
import is2.domain.Matricula;
import is2.repository.MatriculaDao;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

@Service
public class MatriculaService {

	@Inject
	MatriculaDao matriculaDao;
	
	public Matricula find(Long id){
		return matriculaDao.find(id);		
	}
	
	public List<Alumno> getAlumnos(List<Matricula> matriculas){
		List<Alumno> alumnos = new ArrayList<Alumno>();
		Iterator<Matricula> it = matriculas.listIterator();
		while(it.hasNext()){
			Matricula matricula = it.next();
			alumnos.add(matricula.getAlumno());
		}
		return alumnos;
	}
}
