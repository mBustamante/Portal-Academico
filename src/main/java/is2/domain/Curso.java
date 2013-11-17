package is2.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table (name="curso")
@NamedQuery(name = Curso.FIND_ALL, query = "SELECT s FROM Curso s")
public class Curso implements BaseEntity<Long>{
	
	public static final String FIND_ALL = "Curso.findAll";
	
	@Id
	@SequenceGenerator(name = "CURSO_ID_GENERATOR", sequenceName = "CURSO_STUDY_ID_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CURSO_ID_GENERATOR")
	private Long id;
	
	private String nombre;
	
	private Integer idEquivalencia;
	
	private Integer creditos;
	
	@OneToMany(mappedBy="curso")
	private List<CursoDictado> cursosDictados;
	
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name= "prerequisitos",
		joinColumns=@JoinColumn(name="curso_id", referencedColumnName="id"),
		inverseJoinColumns=@JoinColumn(name="prerequisito_id", referencedColumnName="id"))
	private List<Curso> prerequisitos;
	
	
	@OneToMany(mappedBy="curso")
	private List<CursoMalla> mallas;
	
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public Integer getCreditos() {
		return creditos;
	}

	public void setCreditos(Integer creditos) {
		this.creditos = creditos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public static EntityManager entityManager() {
		return (UnitPersistence.getInstance()).get();
	}

	public Integer getIdEquivalencia() {
		return idEquivalencia;
	}

	public void setIdEquivalencia(Integer idEquivalencia) {
		this.idEquivalencia = idEquivalencia;
	}



}
