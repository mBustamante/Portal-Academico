package is2;

import java.util.Collections;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TypedQuery;

@Entity
@Table(name = "alumno")
public class Alumno extends Persona{

	@Id
	@SequenceGenerator(name = "alumno_ID_GENERATOR", sequenceName = "alumno_id_alumno_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "alumno_ID_GENERATOR")
	private Integer id;

	private String colegio;
	private String codigo;
	private String apoderado;

<<<<<<< HEAD
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="alumno_por_grupo",
			joinColumns=@JoinColumn(name="alumno_id", referencedColumnName="id"),
	        inverseJoinColumns=@JoinColumn(name="grupo_id", referencedColumnName="id"))
	
	private List<Grupo> grupos;
=======
	@ManyToOne
	private Matricula matricula;
>>>>>>> 8d5b68fcf9bc07a14591ebe0987bb410036e73f6

	public Alumno() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getColegio() {
		return colegio;
	}

	public void setColegio(String colegio) {
		this.colegio = colegio;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getApoderado() {
		return apoderado;
	}

	public void setApoderado(String apoderado) {
		this.apoderado = apoderado;
	}

	public static EntityManager entityManager() {
		return (UnitPersistence.getInstance()).get();
	}

	public Matricula getMatricula() {
		return matricula;
	}

	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}


}