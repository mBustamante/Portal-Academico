package is2.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class CursoMalla implements BaseEntity<Long>{
	
	@Id
	private Long id;
	
	@ManyToOne
	private Curso curso;
	
	@ManyToOne
	private Malla malla;
	
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}
}
