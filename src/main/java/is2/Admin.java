/*package is2;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "admin")
public class Admin extends Persona{
	
	@Id
	@SequenceGenerator(name = "admin_ID_GENERATOR", sequenceName = "admin_id_admin_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "admin_ID_GENERATOR")
	private Integer id;
	
	private String usuario;

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	public static EntityManager entityManager() {
		return (UnitPersistence.getInstance()).get();
	}
	
	public static Admin find(Integer id) {
		Admin c = null;
		EntityManager em = entityManager();
		try {
			em.getTransaction().begin();
			c = em.find(Admin.class, id);
		} catch (Exception e) {
			System.out.println("Error");
			e.printStackTrace();
		} finally {
			em.close();
		}
		return c;
	}
	
}*/
