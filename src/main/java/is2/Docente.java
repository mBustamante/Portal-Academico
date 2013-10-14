package is2;

import java.util.Collections;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;



@Entity
public class Docente extends Persona{


	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="docentes_por_cursos",
		joinColumns=@JoinColumn(name="docente_id", referencedColumnName="id"),
		inverseJoinColumns=@JoinColumn(name="curso_id", referencedColumnName="id"))
	private List<Curso> cursos;

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

}
