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

	@Id
	@SequenceGenerator(name = "docente_ID_GENERATOR", sequenceName = "docente_id_alumno_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "docente_ID_GENERATOR")
	private Integer id;

	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="docentes_por_cursos",
		joinColumns=@JoinColumn(name="curso_id", referencedColumnName="id"))
	private List<Curso> cursos;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

}
