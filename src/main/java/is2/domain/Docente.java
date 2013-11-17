package is2.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "docente")
@NamedQuery(name = Docente.FIND_BY_USER, query = "SELECT s FROM Docente s WHERE s.usuario = :usuario")
public class Docente extends Persona implements BaseEntity<Long>{

	public static final String FIND_BY_USER = "Docente.findIdByUsername";
	
	@Id
	@SequenceGenerator(name = "DOCENTE_ID_GENERATOR", sequenceName = "DOCENTE_STUDY_ID_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DOCENTE_ID_GENERATOR")
	private Long id;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="docente_por_curso_dictado",
		joinColumns=@JoinColumn(name="docente_id", referencedColumnName="id"),
		inverseJoinColumns=@JoinColumn(name="curso_dictado_id", referencedColumnName="id"))
	private List<CursoDictado> cursosDictados;
	
	public Docente () {
	}
	
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

}
