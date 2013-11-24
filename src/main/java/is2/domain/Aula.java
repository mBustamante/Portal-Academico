package is2.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name ="aula")
@NamedQuery(name = Aula.FIND_ALL , query = "SELECT s FROM Aula s")
public class Aula implements BaseEntity<Long>{
	
	public static final String FIND_ALL = "Aula.findAll";
	
	@Id
	@SequenceGenerator(name = "AULA_ID_GENERATOR" , sequenceName = "AULA_STUDY_ID_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AULA_ID_GENERATOR")
	private Long id;
	
	private String nombre;
	
	private Integer maxAlumnos;
	
	@OneToMany(mappedBy="aula")
	private List<Bloque> horarios;

	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getMaxAlumnos() {
		return maxAlumnos;
	}

	public void setMaxAlumnos(Integer maxAlumnos) {
		this.maxAlumnos = maxAlumnos;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}
	
	public static EntityManager entityManager(){
		return (UnitPersistence.getInstance()).get();
	}
	
}
