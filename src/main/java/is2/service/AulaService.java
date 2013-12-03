package is2.service;

import java.util.List;

import is2.domain.Aula;
import is2.repository.AulaDao;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

@Service
public class AulaService {
 @Inject
 AulaDao aulaDao;
 
	 public List<Aula> findAll()
	 {
		 return aulaDao.findAll();
	 }
	 public Aula find(Long id)
	 {
		 return aulaDao.find(id);
	 }
	 public Aula persist(Aula aula)
	 {
 		return aulaDao.persist(aula);
	 }
		
	public Aula merge(Aula aula)
	{
		return aulaDao.persist(aula);
	}
	 
}
