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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TypedQuery;

@Entity
@Table(name = "alumno")
public class Alumno extends Persona{

	private String colegio;
	private String codigo;
	private String apoderado;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name= "alumno_por_grupo",
	joinColumns=@JoinColumn(name="alumno_id",referencedColumnName="id"),
	inverseJoinColumns=@JoinColumn(name="grupo_id",	referencedColumnName="id")) 
	private List<Grupo> grupo;
	
	@ManyToOne
	private Matricula matricula;

	public Alumno() {
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