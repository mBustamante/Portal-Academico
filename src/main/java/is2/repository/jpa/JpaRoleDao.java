package is2.repository.jpa;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import is2.domain.Role;
import is2.repository.RoleDao;

@Repository
public class JpaRoleDao extends JpaGenericDao<Role, Long> implements RoleDao{

	@Override
	public Role findByRole(String role) {
		TypedQuery<Role> query = entityManager.createQuery("SELECT r FROM Role r WHERE r.role = :role", Role.class);
		query.setParameter("role", role);
		return query.getSingleResult();
	}

	@Override
	protected Class<Role> getClase() {
		return Role.class;
	}

}
