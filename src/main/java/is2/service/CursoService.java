package is2.service;
import java.util.List;

import is2.domain.Curso;
import is2.repository.CursoDao;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

@Service
public class CursoService {
	@Inject
	CursoDao cursoDao;
	
	public List<Curso> findAll()
	{
		return cursoDao.findAll();
	}
	
	public Curso find(Long id)
	{
		return cursoDao.find(id);
	}
	
	public Curso persist(Curso curso)
	{
		return cursoDao.persist(curso);
	}
	
	public Curso merge(Curso curso)
	{
		return cursoDao.merge(curso);
	}

}
