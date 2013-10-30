package is2;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Nota {

	@Id
	@SequenceGenerator(name = "nota_id_gen", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "nota_id_gen")
	private Long id;
	
	private Double nota;
	
	private Double peso;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Matricula matricula;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private CategoriaNota categoria;

	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}
	
}
