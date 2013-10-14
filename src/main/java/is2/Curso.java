package is2;

import java.util.Collections;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.TypedQuery;

@Entity
public class Curso {

	@Id
	private String codigo;
	
	private String nombre;
	
	@Column(nullable=false, length=10)
	private Integer creditos;

	@ManyToOne
	@JoinColumn(name = "id_docente")
	private Docente docente;
	
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name= "cursos_por_malla",
	joinColumns=@JoinColumn(name="curso_id",referencedColumnName="id"),
	inverseJoinColumns=@JoinColumn(name="malla_id",	referencedColumnName="id")) 
	private List<Malla> mallas;
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Docente getDocente() {
		return docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}
	public static EntityManager entityManager() {
		return (UnitPersistence.getInstance()).get();
	}

	public static List<Curso> findAll() {
		EntityManager em = entityManager();
		try {
			em.getTransaction().begin();
			TypedQuery<Curso> query = em.createQuery("SELECT p FROM Curso p", Curso.class);
			return query.getResultList();
		} catch (Exception e) {
			System.out.println("Error");
			e.printStackTrace();
		} finally {
			em.close();
		}
		return Collections.emptyList();
	}


}
