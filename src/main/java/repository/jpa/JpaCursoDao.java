package repository.jpa;

import repository.CursoDao;
import is2.Curso;

public class JpaCursoDao extends JpaGenericDao<Curso, Long> implements CursoDao{

	@Override
	public  Class<Curso> getClase()
	{
		return Curso.class;
	}
	
	public String getNombre()
	{
		return Curso.class.getName();
	}

}
