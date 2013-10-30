package is2;

import java.util.Collections;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TypedQuery;

@Entity
@Table(name = "alumno")
public class Alumno extends Persona{

	private String colegio;
	
	private String apoderado;

	
	@ManyToOne
	private Matricula matricula;
	
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

	public static EntityManager entityManager() {
		return (UnitPersistence.getInstance()).get();
	}


	
	public static List<Alumno> findAll() {
		    EntityManager em = entityManager();
		    try {
		      em.getTransaction().begin();
		      TypedQuery<Alumno> query = em.createQuery(
		          "SELECT p FROM Alumno p", Alumno.class);
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