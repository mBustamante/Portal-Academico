package is2.controller;

import is2.domain.Curso;
import is2.service.AulaService;
import is2.domain.Aula;

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
@RequestMapping("/aula")
public class AulaController {

	
	@Inject
	AulaService aulaService;
	
	@RequestMapping("/list.html")
	public ModelAndView list(){
		return new ModelAndView("aula/list" , "aulas" , aulaService.findAll());
	}
	

	@RequestMapping("/{id}/details.html")
	public ModelAndView details(@PathVariable Long id) {
		ModelAndView view = new ModelAndView();
		view.addObject("aula", aulaService.find(id));
		view.setViewName("aula/details");
		return view;
	}

	@RequestMapping("/{id}/edit.html")
	public ModelAndView edit(@PathVariable Long id) {
		ModelAndView view = new ModelAndView();
		view.addObject("aula", aulaService.find(id));
		view.setViewName("aula/edit");
		return view;
	}
	
	@RequestMapping("/add.html")
	public ModelAndView add() {
		ModelAndView view = new ModelAndView();
		view.addObject("aula", new Curso());
		view.setViewName("aula/edit");
		return view;
	}
	
	@RequestMapping(value = "/save.html", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("aula") @Valid Aula aula, BindingResult result, SessionStatus status) {
		if (aula.getId() == null) {
			aulaService.persist(aula);
			status.setComplete();
		}
		else {
			aulaService.merge(aula);
			status.setComplete();
		}
		return new ModelAndView(result.getErrorCount() > 0 ? "student/edit" : "redirect:list.html");
//		return new ModelAndView("Student/save");
	}

}
