package is2.controller;

import is2.domain.Malla;
import is2.service.MallaService;

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
@RequestMapping("/malla")
public class MallaController {

	@Inject
	MallaService mallaService;
	
	@RequestMapping("/list.html")
	public ModelAndView list(){
		return new ModelAndView("malla/list" , "mallas" , mallaService.findAll());
	}
	
	@RequestMapping("/{id}/details.html")
	public ModelAndView details(@PathVariable Long id) {
		ModelAndView view = new ModelAndView();
		view.addObject("malla", mallaService.find(id));
		view.setViewName("malla/details");
		return view;
	}

	@RequestMapping("/{id}/edit.html")
	public ModelAndView edit(@PathVariable Long id) {
		ModelAndView view = new ModelAndView();
		view.addObject("malla", mallaService.find(id));
		view.setViewName("malla/edit");
		return view;
	}
	
	@RequestMapping("/add.html")
	public ModelAndView add() {
		ModelAndView view = new ModelAndView();
		view.addObject("malla", new Malla());
		view.setViewName("malla/edit");
		return view;
	}
	
	@RequestMapping(value = "/save.html", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("malla") @Valid Malla malla, BindingResult result, SessionStatus status) {
		if (malla.getId() == null) {
			mallaService.persist(malla);
			status.setComplete();
		}
		else {
			mallaService.merge(malla);
			status.setComplete();
		}
		return new ModelAndView(result.getErrorCount() > 0 ? "student/edit" : "redirect:list.html");
	}

}
