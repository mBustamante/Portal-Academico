package is2.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import is2.domain.Docente;
import is2.repository.DocenteDao;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

	@Inject
	DocenteDao dao;

	@RequestMapping("/list.html")
	public ModelAndView list() {
		return new ModelAndView("teacher/list", "teachers", dao.findAll());
	}

	@RequestMapping("/{id}/details.html")
	public ModelAndView details(@PathVariable Long id) {
		ModelAndView view = new ModelAndView();
		view.addObject("teacher", dao.find(id));
		view.setViewName("teacher/details");
		return view;
	}

	@RequestMapping("/{id}/edit.html")
	public ModelAndView edit(@PathVariable Long id) {
		ModelAndView view = new ModelAndView();
		view.addObject("teacher", dao.find(id));
		view.setViewName("teacher/edit");
		return view;
	}

	@RequestMapping("/add.html")
	public ModelAndView add() {
		ModelAndView view = new ModelAndView();
		view.addObject("teacher", new Docente());
		view.setViewName("teacher/edit");
		return view;
	}

	@RequestMapping(value = "/save.html", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("producto") Docente producto, BindingResult result,
	    SessionStatus status) {
		if (producto.getId() == null) {
			dao.persist(producto);
			status.setComplete();
		} else {
			dao.merge(producto);
			status.setComplete();
		}
		return list();
	}
}
