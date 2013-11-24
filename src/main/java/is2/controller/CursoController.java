package is2.controller;

import is2.repository.CursoDao;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/curso")
public class CursoController {

	@Inject
	CursoDao cursoDao;
	
	// validator
	
	@RequestMapping("/list.html")
	public ModelAndView list(){
		return new ModelAndView("curso/list" , "cursos" , cursoDao.findAll());
	}
}
