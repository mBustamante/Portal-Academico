package is2.controller;

import is2.domain.Curso;
import is2.service.CursoService;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/curso")
public class CursoController {

	@Inject
	CursoService cursoService;
	
	@RequestMapping("/list.html")
	public ModelAndView list(){
		return new ModelAndView("curso/list" , "cursos" , cursoService.findAll());
	}
	
	@RequestMapping("/{id}/details.html")
	public ModelAndView details(@PathVariable Long id) {
		ModelAndView view = new ModelAndView();
		view.addObject("curso", cursoService.find(id));
		view.setViewName("curso/details");
		return view;
	}

	@RequestMapping("/{id}/edit.html")
	public ModelAndView edit(@PathVariable Long id) {
		ModelAndView view = new ModelAndView();
		view.addObject("curso", cursoService.find(id));
		view.setViewName("curso/edit");
		return view;
	}
	
	@RequestMapping("/add.html")
	public ModelAndView add() {
		ModelAndView view = new ModelAndView();
		view.addObject("curso", new Curso());
		view.setViewName("curso/edit");
		return view;
	}
	
	@RequestMapping(value = "/save.html", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("curso") @Valid Curso curso, BindingResult result, SessionStatus status) {
		if (curso.getId() == null) {
			cursoService.persist(curso);
			status.setComplete();
		}
		else {
			cursoService.merge(curso);
			status.setComplete();
		}
		return new ModelAndView(result.getErrorCount() > 0 ? "student/edit" : "redirect:list.html");
//		return new ModelAndView("Student/save");
	}

}
