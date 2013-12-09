package is2.service;

import java.util.List;

import is2.domain.Periodo;
import is2.repository.PeriodoDao;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

@Service
public class PeriodoService {
	@Inject
	PeriodoDao periodoDao; 
	
	public List<Periodo> findAll(){
		return periodoDao.findAll();
	}
}
