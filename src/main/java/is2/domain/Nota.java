package is2.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Nota implements BaseEntity<Long>{

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
	
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public CategoriaNota getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaNota categoria) {
		this.categoria = categoria;
	}

	public Matricula getMatricula() {
		return matricula;
	}

	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}
	
}
