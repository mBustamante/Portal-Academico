package is2;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;

@MappedSuperclass
public abstract class Persona {
	
	@Id
	@SequenceGenerator(name = "admin_ID_GENERATOR", sequenceName = "admin_id_admin_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "admin_ID_GENERATOR")
	private Integer id;
	
	private String nombre;
	
	private String apellido;

	private String fecha_n;
	
	private String telefono;

	private String password;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public String getFecha_n() {
		return fecha_n;
	}
	public void setFecha_n(String fecha_n) {
		this.fecha_n = fecha_n;
	}
	
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
