package is2.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class Role implements BaseEntity<Long>{
	@Id
	@SequenceGenerator(name = "ROLE_ID_GENERATOR", sequenceName = "ROEL_STUDY_ID_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ROLE_ID_GENERATOR")
	private Long id;
	
	private String role;
	
	@OneToMany(mappedBy="role")
	private List<Alumno> alumnos;
	
	@OneToMany(mappedBy="role")
	private List<Docente> docentes;
	
	@OneToMany(mappedBy="role")
	private List<Admin> admins;
	
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
