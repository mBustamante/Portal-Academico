package is2.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table (name="admin")
@NamedQuery(name = Admin.FIND_BY_USER, query = "SELECT s FROM Admin s WHERE s.usuario = :usuario")
public class Admin extends Persona implements BaseEntity<Long>{
	
	public static final String FIND_BY_USER = "Admin.findByUsername";
	
	@Id
	@SequenceGenerator(name = "ADMIN_ID_GENERATOR", sequenceName = "ADMIN_STUDY_ID_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ADMIN_ID_GENERATOR")
	private Long id;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}
		
}
