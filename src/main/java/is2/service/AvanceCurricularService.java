package is2.service;


import java.util.List;

import is2.domain.Alumno;
import is2.domain.Matricula;
import is2.repository.AlumnoDao;




public class AvanceCurricularService {
	
	private Alumno alumno;
	private List<Matricula> matriculas;
	
	public AvanceCurricularService() {		
	
	}
	
	public void cargar_datos(Long alumno_id, AlumnoDao alumnoDao){
		alumno = alumnoDao.find(alumno_id);
		matriculas = alumno.getMatriculas();		
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public List<Matricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}


	
	
	
}
