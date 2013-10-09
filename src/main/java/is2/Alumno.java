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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TypedQuery;

@Entity
@Table(name = "alumno")
public class Alumno {

	@Id
	@SequenceGenerator(name = "alumno_ID_GENERATOR", sequenceName = "alumno_id_alumno_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "alumno_ID_GENERATOR")
	private Integer id;

	private String apellido;

	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="alumno_por_grupo",
			joinColumns=@JoinColumn(name="alumno_id", referencedColumnName="id"),
	        inverseJoinColumns=@JoinColumn(name="grupo_id", referencedColumnName="id"))
	private List<Grupo> grupos;

	public Alumno() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public static EntityManager entityManager() {
		return (UnitPersistence.getInstance()).get();
	}

	public static List<Alumno> findAll() {
		Alumno c = null;
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

	public static Alumno find(Integer id) {
		Alumno c = null;
		EntityManager em = entityManager();
		try {
			em.getTransaction().begin();
			c = em.find(Alumno.class, id);// select * from alumno where id=?
		} catch (Exception e) {
			System.out.println("Error");
			e.printStackTrace();
		} finally {
			em.close();
		}
		return c;
	}

	public List<Grupo> getGrupos() {
		return grupos;
	}

	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}

}