package is2.repository;

import is2.domain.Role;

public interface RoleDao extends GenericDao<Role, Long>{
	Role findByRole(String role);
}
