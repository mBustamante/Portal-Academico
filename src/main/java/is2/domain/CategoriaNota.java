package is2.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="categoria_nota")
public class CategoriaNota implements BaseEntity<Long>{
        
        @Id
        @SequenceGenerator(name = "categoria_nota_id_gen", allocationSize = 1)
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categoria_nota_id_gen")
        private Long id;
        
        private String nombre;
        
        private Double peso;
        
        @OneToMany(mappedBy="categoria")
        private List<Nota> notas;

        public String getNombre() {
                return nombre;
        }

        public void setNombre(String nombre) {
                this.nombre = nombre;
        }
        
    	@Override
    	public Long getId() {
    		return id;
    	}

    	@Override
    	public void setId(Long id) {
    		this.id = id;
    	}

		public Double getPeso() {
			return peso;
		}

		public void setPeso(Double peso) {
			this.peso = peso;
		}
        
}