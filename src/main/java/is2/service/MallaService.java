package is2.service;

import java.util.List;

import is2.domain.Malla;
import is2.repository.MallaDao;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

@Service
public class MallaService {
	@Inject
	MallaDao mallaDao;
	
	public List<Malla> findAll()
	{
		return mallaDao.findAll();
	}
	
	public Malla find(Long id)
	{
		return mallaDao.find(id);
	}
	
	public Malla persist(Malla malla)
	{
		return mallaDao.persist(malla);
	}
	
	public Malla merge(Malla malla)
	{
		return mallaDao.merge(malla);
	}

}
