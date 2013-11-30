package is2.service;

import is2.domain.Matricula;
import is2.repository.MatriculaDao;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

@Service
public class MatriculaService {

	@Inject
	MatriculaDao matriculaDao;
	
	public Matricula find(Long id){
		return matriculaDao.find(id);		
	}
}
