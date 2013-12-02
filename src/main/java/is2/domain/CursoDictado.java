package is2.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class CursoDictado implements BaseEntity<Long>{
	
	@Id
	private Long id;
	
	@ManyToMany(mappedBy="cursosDictados")
	private List<Docente> docentes;
	
	@OneToMany(mappedBy="cursoDictado")
	private List<Matricula> matriculas;
	
	@OneToMany(mappedBy="cursoDictado")
	private List<Bloque> bloques;
	
	@ManyToOne
	private Curso curso;
	
	@ManyToOne
	private Periodo periodo;
	
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public List<Matricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}

	public List<Docente> getDocentes() {
		return docentes;
	}

	public void setDocentes(List<Docente> docentes) {
		this.docentes = docentes;
	}

	public List<Bloque> getBloques() {
		return bloques;
	}

	public void setBloques(List<Bloque> bloques) {
		this.bloques = bloques;
	}
}
