package is2;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TypedQuery;
import javax.xml.crypto.Data;

@Entity
@Table (name = "malla")
public class Malla {
	
	@Id
	@SequenceGenerator(name = "malla_id_gen", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "malla_id_gen")
	private Long id;
	
	private String fecha;
	
	private String descripcion;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Carrera carrera;
	
	@ManyToMany(mappedBy="mallas")
	private List<Curso> cursos;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getFecha() {
		return fecha;
	}
	
	public void setFecha(String fecha) {
		this.fecha = fecha;
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
