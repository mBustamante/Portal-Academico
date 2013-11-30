package is2.repository;

import is2.domain.Docente;

public interface DocenteDao extends GenericDao<Docente, Long> {
	Docente findByUsername(String username);
    boolean existsDocente(String username, String password);
    
    public boolean existsByUsername(String username);
}
