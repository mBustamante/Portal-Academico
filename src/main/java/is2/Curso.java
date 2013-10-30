package is2;

import java.util.Collections;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.TypedQuery;


@Entity
public class Curso {

	@Id
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
	

	
	
	

	public Long getId() {
		return id;
	}
	

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


	public Integer getIdEquivalencia() {
		return idEquivalencia;
	}

	public void setIdEquivalencia(Integer idEquivalencia) {
		this.idEquivalencia = idEquivalencia;
	}



}
