package is2;

import java.util.Collections;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.TypedQuery;

@Entity
public class Docente {

	@Id
	@SequenceGenerator(name = "docente_ID_GENERATOR", sequenceName = "docente_id_alumno_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "docente_ID_GENERATOR")
	private Integer id;

	private String nombres;

	@OneToMany(mappedBy="docente")
	private List<Curso> cursos;

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public Docente() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public static EntityManager entityManager() {
		return (UnitPersistence.getInstance()).get();
	}

	public static List<Docente> findAll() {
		Docente c = null;
		EntityManager em = entityManager();
		try {
			em.getTransaction().begin();
			TypedQuery<Docente> query = em.createQuery(
					"SELECT p FROM Docente p", Docente.class);
			return query.getResultList();
		} catch (Exception e) {
			System.out.println("Error");
			e.printStackTrace();
		} finally {
			em.close();
		}
		return Collections.emptyList();
	}

	public static Docente find(Integer id) {
		Docente c = null;
		EntityManager em = entityManager();
		try {
			em.getTransaction().begin();
			c = em.find(Docente.class, id);// select * from alumno where id=?
		} catch (Exception e) {
			System.out.println("Error");
			e.printStackTrace();
		} finally {
			em.close();
		}
		return c;
	}

}