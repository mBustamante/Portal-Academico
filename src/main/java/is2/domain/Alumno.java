package is2.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "alumno")
@NamedQuery(name = Alumno.FIND_BY_USER, query = "SELECT s FROM Alumno s WHERE s.usuario = :usuario")
public class Alumno extends Persona implements BaseEntity<Long>{
	
	public static final String FIND_BY_USER = "Alumno.findByUsername";

	@Id
	@SequenceGenerator(name = "STUDENT_ID_GENERATOR", sequenceName = "STUDENT_STUDY_ID_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STUDENT_ID_GENERATOR")
	private Long id;
	
	private String colegio;
	
	private String apoderado;
	
	@OneToMany(mappedBy="alumno")
	private List<Matricula> matriculas;
	
	@ManyToOne
	private Carrera carrera;

	public Alumno() {
	}

	public String getColegio() {
		return colegio;
	}

	public void setColegio(String colegio) {
		this.colegio = colegio;
	}


	public String getApoderado() {
		return apoderado;
	}

	public void setApoderado(String apoderado) {
		this.apoderado = apoderado;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "{id: " + getId() + ", Nombre: " + getNombre() + ", Apellido: " + getApellido()
		    + ", Usuario: " + getUsuario() + "}";
	}

}
