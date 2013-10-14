package is2;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class BloqueHorario {
	@Id
	private Long id;
	private String dia;
	private int hora_inicio;
	private int hora_fin;
	private String aula;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Curso curso;
}