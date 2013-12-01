package is2.service;


import java.util.List;

import ch.qos.logback.core.pattern.color.BlackCompositeConverter;
import is2.domain.Alumno;
import is2.domain.Bloque;
import is2.domain.CursoDictado;
import is2.domain.Matricula;
import is2.repository.AlumnoDao;




public class HorarioAlumno {
	
	private Alumno alumno;
	private List<Matricula> matriculas;
	private List<CursoDictado> cursoDictados; 
	private List<Bloque> bloques;	

	public HorarioAlumno() {		
	
	}
	
	public void cargar_datos(Long alumno_id, AlumnoDao alumnoDao){
		alumno = alumnoDao.find(alumno_id);
		matriculas = alumno.getMatriculas();
		for(int i = 0 ; i < matriculas.size() ;i++){
			cursoDictados.add(matriculas.get(i).getCursoDictado());
		}
		
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

	public List<CursoDictado> getCursoDictados() {
		return cursoDictados;
	}
	
	
	
}
