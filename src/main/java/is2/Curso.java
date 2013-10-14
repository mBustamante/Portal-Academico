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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.TypedQuery;


@Entity
public class Curso {

	@Id
	private Long id;
	
	private Long idEquivalencia;
	
	private String nombre;
	
	private Integer creditos;
	
	private Integer maxAlumnos;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name= "prerequisitos",
		joinColumns=@JoinColumn(name="curso_id", referencedColumnName="id"),
		inverseJoinColumns=@JoinColumn(name="prerequisito_id", referencedColumnName="id"))
	private List<Curso> prerequisitos;
	
	
	@ManyToOne
	@JoinColumn(name="id_periodo")
	private Periodo periodo;
	
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name= "cursos_por_grupo",
			joinColumns=@JoinColumn(name="curso_id", referencedColumnName="id"),
	        inverseJoinColumns=@JoinColumn(name="grupo_id", referencedColumnName="id"))
	private List<Grupo> grupos;


	
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name= "cursos_por_malla",
			joinColumns=@JoinColumn(name="curso_id", referencedColumnName="id"),
	        inverseJoinColumns=@JoinColumn(name="malla_id", referencedColumnName="id"))
	private List<Malla> mallas;
	
	@ManyToMany(mappedBy="cursos")
	private List<Docente> docentes;
	
	@OneToMany(mappedBy="curso")
	private List<BloqueHorario> horarios;

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

	public Integer getMaxAlumnos() {
		return maxAlumnos;
	}

	public void setMaxAlumnos(Integer maxAlumnos) {
		this.maxAlumnos = maxAlumnos;
	}

	/*public List<Curso> getPrerrequisitos() {
		return prerequisitos;
	}

	public void setPrerrequisitos(List<Curso> prerrequisitos) {
		this.prerequisitos = prerrequisitos;
	}*/

	public Periodo getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
	}

	public List<Grupo> getGrupos() {
		return grupos;
	}

	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}

	public List<Malla> getMallas() {
		return mallas;
	}

	public void setMallas(List<Malla> mallas) {
		this.mallas = mallas;
	}

	public List<Docente> getDocentes() {
		return docentes;
	}

	public void setDocentes(List<Docente> docentes) {
		this.docentes = docentes;
	}

	public List<BloqueHorario> getHorarios() {
		return horarios;
	}

	public void setHorarios(List<BloqueHorario> horarios) {
		this.horarios = horarios;
	}

	public Long getIdEquivalencia() {
		return idEquivalencia;
	}

	public void setIdEquivalencia(Long idEquivalencia) {
		this.idEquivalencia = idEquivalencia;
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



}
