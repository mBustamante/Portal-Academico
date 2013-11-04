package repository.jpa;

import is2.Alumno;
import repository.AlumnoDao;

public class JpaAlumnoDao extends JpaGenericDao<Alumno, Long> implements AlumnoDao {
	


	@Override
	protected Class<Alumno> getClase() {
		return Alumno.class;
	}

	
}
