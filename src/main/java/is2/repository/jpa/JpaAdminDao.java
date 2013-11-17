package is2.repository.jpa;

import org.springframework.stereotype.Repository;

import is2.domain.Admin;
import is2.repository.AdminDao;

@Repository
public class JpaAdminDao extends JpaGenericDao<Admin,Long> implements AdminDao {
	
	@Override
	protected Class<Admin> getClase() {
		return Admin.class;
	}

	@Override
	public Admin findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsAdministrator(String username, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean existsByUsername(String username) {
		// TODO Auto-generated method stub
		return false;
	}

}
