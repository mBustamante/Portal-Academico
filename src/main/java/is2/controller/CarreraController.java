package is2.controller;

import is2.domain.Carrera;
import is2.repository.CarreraDao;

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
@RequestMapping("/carrera")
public class CarreraController {

	@Inject
	CarreraDao carreraDao;
	
	// validator

	@RequestMapping("/list.html")
	public ModelAndView list(){
		return new ModelAndView("carrera/list" , "carreras" , carreraDao.findAll());
	}
	
	@RequestMapping("/{id}/details.html")
	public ModelAndView details(@PathVariable Long id) {
		ModelAndView view = new ModelAndView();
		view.addObject("carrera", carreraDao.find(id));
		view.setViewName("carrera/details");
		return view;
	}

	@RequestMapping("/{id}/edit.html")
	public ModelAndView edit(@PathVariable Long id) {
		ModelAndView view = new ModelAndView();
		view.addObject("carrera", carreraDao.find(id));
		view.setViewName("carrera/edit");
		return view;
	}
	
	@RequestMapping("/add.html")
	public ModelAndView add() {
		ModelAndView view = new ModelAndView();
		view.addObject("carrera", new Carrera());
		view.setViewName("carrera/edit");
		return view;
	}
	
	@RequestMapping(value = "/save.html", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("carrera") @Valid Carrera carrera, BindingResult result, SessionStatus status) {
		if (carrera.getId() == null) {
			carreraDao.persist(carrera);
			status.setComplete();
		}
		else {
			carreraDao.merge(carrera);
			status.setComplete();
		}
		return new ModelAndView(result.getErrorCount() > 0 ? "carrera/edit" : "redirect:list.html");
//		return new ModelAndView("Student/save");
	}

}
