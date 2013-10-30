package is2;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class CursoMalla {
	
	@Id
	private Long id;
	
	@ManyToOne
	private Curso curso;
}
