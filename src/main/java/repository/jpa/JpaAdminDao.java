package repository.jpa;

import repository.AdminDao;
import is2.Admin;

public class JpaAdminDao extends JpaGenericDao<Admin,Long> implements AdminDao {
	


	@Override
	protected Class<Admin> getClase() {
		return Admin.class;
	}

}
