package is2.domain;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Persona {
	
	private String nombre;
	
	private String apellido;

	private String fecha_n;
	
	private String telefono;

	private String usuario;
	
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
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
}
