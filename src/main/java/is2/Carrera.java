package is2;

import java.util.List;
import java.util.Collection;
import java.util.Collections;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TypedQuery;

@Entity
@Table (name="carrera")
public class Carrera {

	@Id
	@SequenceGenerator(name = "carrera_id_gen", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "carrera_id_gen")
	private Long id;
	
	private String nombre;
	
	private String director;
	
	@OneToMany(mappedBy = "carrera")
	private List<Malla> mallas;
	
	@OneToMany(mappedBy = "carrera")
	private List<Grupo> grupos;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getDirector() {
		return director;
	}
	
	public void setDirector(String director) {
		this.director = director;
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
