package is2;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Matricula {
	
	@Id
	private Long id;
	
	private Date fecha;
	
	private Integer estado;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Alumno alumno;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Curso curso;
	
	@OneToMany(mappedBy="matricula")
	private List<Nota> notas;
	
}
