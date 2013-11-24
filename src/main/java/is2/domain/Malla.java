package is2.domain;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table (name = "malla")
@NamedQuery(name = Malla.FIND_ALL, query = "SELECT s FROM Malla s")
public class Malla implements BaseEntity<Long> {
	
	public static final String FIND_ALL = "Malla.findAll";
	@Id
	@SequenceGenerator(name = "malla_id_gen", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "malla_id_gen")
	private Long id;
	
	private Date fecha;
	
	private String descripcion;
	
	private Boolean vigencia;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Carrera carrera;
	
	@OneToMany(mappedBy="malla")
	private List<CursoMalla> cursos;
	
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}
	
	
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public Carrera getCarrera() {
		return carrera;
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}
	
	public static EntityManager entityManager() {
		return (UnitPersistence.getInstance()).get();
	}

	Malla find(Integer id){
		Malla c = null;
		EntityManager em = entityManager();
		try {
			em.getTransaction().begin();
			c = em.find(Malla.class, id);
		} catch (Exception e) {
			System.out.println("Error");
			e.printStackTrace();
		}finally{
			em.close();
		}
		return c;
	}

	public Boolean getVigencia() {
		return vigencia;
	}

	public void setVigencia(Boolean vigencia) {
		this.vigencia = vigencia;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	/*
	public static List<Malla> findAll(){
		EntityManager em = entityManager();
		try {
			em.getTransaction().begin();
			TypedQuery<Malla> query = em.createQuery(
					"SELECT p FROM Malla p" , Malla.class);
			return query.getResultList();
		} catch (Exception e) {
			System.out.println("Error");
			e.printStackTrace();
		} finally {
			em.close();
		}
		return Collections.emptyList();
	}
	*/
}
