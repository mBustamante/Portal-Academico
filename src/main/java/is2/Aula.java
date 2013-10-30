package is2;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Aula {
	
	@Id
	private Long id;
	
	private String nombre;
	
	private Integer maxAlumnos;
	
	@OneToMany(mappedBy="aula")
	private List<Bloque> horarios;

	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getMaxAlumnos() {
		return maxAlumnos;
	}

	public void setMaxAlumnos(Integer maxAlumnos) {
		this.maxAlumnos = maxAlumnos;
	}
	
}
