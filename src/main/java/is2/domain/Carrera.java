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
@Table(name = "carrera")
@NamedQuery(name = Carrera.FIND_ALL , query = "SELECT s FROM Carrera s")
public class Carrera implements BaseEntity<Long>{

	public static final String FIND_ALL = "Carrera.findAll";
	@Id
	@SequenceGenerator(name = "carrera_id_gen", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "carrera_id_gen")
	private Long id;
	
	private String nombre;
	
	
	@OneToMany(mappedBy = "carrera")
	private List<Malla> mallas;
	
	@OneToMany(mappedBy="carrera")
	private List<Alumno> alumnos;

	
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}
	
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public static EntityManager entityManager(){
		return (UnitPersistence.getInstance()).get();
	}
	
	Carrera find(Integer id){
		Carrera c = null;
		EntityManager em = entityManager();
		try {
			em.getTransaction().begin();
			c = em.find(Carrera.class, id);
		} catch (Exception e) {
			System.out.println("Error");
			e.printStackTrace();
		}finally{
			em.close();
		}
		return c;
	}

	public List<Malla> getMallas() {
		return mallas;
	}

	public void setMallas(List<Malla> mallas) {
		this.mallas = mallas;
	}
	
	/*
	public static List<Carrera> findAll(){
		EntityManager em = entityManager();
		try {
			em.getTransaction().begin();
			TypedQuery<Carrera> query = em.createQuery(
					"SELECT p FROM Carrera p" , Carrera.class);
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
