package is2.repository;

import is2.domain.Alumno;

public interface AlumnoDao extends GenericDao<Alumno,Long>{
    Alumno findByUsername(String username);

    boolean existsUser(String username, String password);
    
    public boolean existsByUsername(String username);
}
