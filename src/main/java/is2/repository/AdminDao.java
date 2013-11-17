package is2.repository;

import is2.domain.Admin;

public interface AdminDao extends GenericDao<Admin,Long>{
    Admin findByUsername(String username);
    boolean existsAdministrator(String username, String password);
    
    public boolean existsByUsername(String username);
}
