package is2.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Horario implements BaseEntity<Long>{
	
	@Id
	private Long id;
	
	private String dia;
	
	private Integer hora_inicio;
	
	private Integer hora_fin;
	
	@OneToMany(mappedBy="horario")
	private List<Bloque> aulas;

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public Integer getHora_inicio() {
		return hora_inicio;
	}

	public void setHora_inicio(Integer hora_inicio) {
		this.hora_inicio = hora_inicio;
	}

	public Integer getHora_fin() {
		return hora_fin;
	}

	public void setHora_fin(Integer hora_fin) {
		this.hora_fin = hora_fin;
	}
	
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

}

