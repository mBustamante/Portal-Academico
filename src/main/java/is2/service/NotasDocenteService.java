package is2.service;

import java.util.List;


import is2.domain.Alumno;
import is2.domain.Matricula;
import is2.domain.Nota;
import is2.repository.MatriculaDao;

public class NotasDocenteService {
	private Matricula matricula;
	private Alumno alumno;
	private List<Nota> notas;
	
	
	public void cargar_datos(Long matricula_id, MatriculaDao matriculaDao){
		matricula = matriculaDao.find(matricula_id);
		alumno = matricula.getAlumno();
		notas = matricula.getNotas();
	}

	public Matricula getMatricula() {
		return matricula;
	}

	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public List<Nota> getNotas() {
		return notas;
	}

	public void setNotas(List<Nota> notas) {
		this.notas = notas;
	}
	
	
}
