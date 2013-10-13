package is2;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Periodo {
	@Id
	private Long id;
	private String nombre;
	private String fecha_inicio;
	private String fecha_fin;
	
	@OneToMany(mappedBy = "periodo")
	private List<Curso> cursos;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getFecha_inicio() {
		return fecha_inicio;
	}
	
	public void setFecha_inicio(String fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}
	
	public String getFecha_fin() {
		return fecha_fin;
	}
	
	public void setFecha_fin(String fecha_fin) {
		this.fecha_fin = fecha_fin;
	}
	

}
