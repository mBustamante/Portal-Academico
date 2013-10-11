package is2;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Nota {

	@Id
	private Long id;
	
	private String nombre;
	
	private Double nota;
	
	private Double peso;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Matricula matricula;
	
}
