package is2;

import java.util.Collections;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.TypedQuery;

@Entity
public class Curso {

	private Long id;
	
	private Integer creditos;
	
	private Integer maxAlumnos;
	
	private List<Curso> prerrequisitos;
	

}
