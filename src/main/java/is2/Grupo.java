package is2;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name="grupo")
public class Grupo {
	@Id
	private Integer id;

	private String nombre;

	@ManyToMany(mappedBy="grupo")
	private List<Alumno> alumnos;
	
	@ManyToOne 
	@JoinColumn(name="id_carrera") 
	private Carrera carrera;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
