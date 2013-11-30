package is2.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import is2.domain.Nota;
import is2.repository.NotaDao;

@Service
public class NotaService {

	@Inject 
	NotaDao notaDao;
	
	public Nota find(Long id){
		return notaDao.find(id);
	}
	
	public Nota persist(Nota nota){
		return notaDao.persist(nota);
	}
	
	public void cambiar_nota(Long id, Double nueva_nota){
		Nota nota = notaDao.find(id);
		nota.setNota(nueva_nota);
		notaDao.merge(nota);
	}
	
}
