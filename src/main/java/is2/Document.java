package is2;
//package pe.edu.ucsp.is2;
//
//import java.util.Collections;
//import java.util.List;
//
//import javax.persistence.Entity;
//import javax.persistence.EntityManager;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.SequenceGenerator;
//import javax.persistence.Table;
//import javax.persistence.TypedQuery;
//
//@Entity
//@Table(name = "document")
//public class Document {
//
//	@Id
//	@SequenceGenerator(name = "document_ID_GENERATOR", sequenceName = "document_id_document_seq", allocationSize = 1)
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "document_ID_GENERATOR")
//	private Integer id;
//
//	private String number;
//
//	@ManyToOne
//	@JoinColumn(name = "id_institution")
//	private Alumno instituion;
//
//	public Document() {
//	}
//
//	public Integer getId() {
//		return this.id;
//	}
//
//	public void setId(Integer id) {
//		this.id = id;
//	}
//
//	public String getApellido() {
//		return this.number;
//	}
//
//	public void setApellido(String apellido) {
//		this.number = apellido;
//	}
//
//	public static EntityManager entityManager() {
//		return (new UnitPersistence()).get();
//	}
//
//	public static List<Document> findAll() {
//		Document c = null;
//		EntityManager em = entityManager();
//		try {
//			em.getTransaction().begin();
//			TypedQuery<Document> query = em.createQuery("SELECT p FROM Prueba p", Document.class);
//			return query.getResultList();
//		} catch (Exception e) {
//			System.out.println("Error");
//			e.printStackTrace();
//		} finally {
//			em.close();
//		}
//		return Collections.emptyList();
//	}
//
//	public static Document findPrueba(Integer id) {
//		Document c = null;
//		EntityManager em = entityManager();
//		try {
//			em.getTransaction().begin();
//			c = em.find(Document.class, id);
//		} catch (Exception e) {
//			System.out.println("Error");
//			e.printStackTrace();
//		} finally {
//			em.close();
//		}
//		return c;
//	}
//
//	public Integer getVersion() {
//		return 0;
//	}
//
//	public void setVersion(Integer version) {
//
//	}
//
//}