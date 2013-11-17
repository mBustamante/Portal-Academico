package is2.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Bloque implements BaseEntity<Long>{
	
	@Id
	private Long id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Horario horario;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Aula aula;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private CursoDictado cursoDictado;
	
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}
}
