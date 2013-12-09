package is2.repository;

import java.util.List;

import is2.domain.Alumno;
import is2.domain.Curso;

public interface AlumnoDao extends GenericDao<Alumno,Long>{
    Alumno findByUsername(String username);

    boolean existsUser(String username, String password);
    
    public boolean existsByUsername(String username);

	List<Curso> findCursosDisponibles(Long id);
}
