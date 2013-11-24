package is2.controller;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import is2.domain.Alumno;
import is2.repository.AlumnoDao;
import is2.service.AvanceCurricularService;

@Controller
@RequestMapping("/alumno")
public class AlumnoController {

	@Inject
	AlumnoDao alumnoDao;

	@Inject
	Validator validator;

	@RequestMapping("/list.html")
	public ModelAndView list() {
		return new ModelAndView("alumno/list", "alumnos", alumnoDao.findAll());
	}

	@RequestMapping("/{id}/details.html")
	public ModelAndView details(@PathVariable Long id) {
		ModelAndView view = new ModelAndView();
		view.addObject("alumno", alumnoDao.find(id));
		view.setViewName("alumno/details");
		return view;
	}

	@RequestMapping("/{id}/edit.html")
	public ModelAndView edit(@PathVariable Long id) {
		ModelAndView view = new ModelAndView();
		view.addObject("alumno", alumnoDao.find(id));
		view.setViewName("alumno/edit");
		return view;
	}
	
	@RequestMapping("/{id}/notas.html")
	public ModelAndView notas(@PathVariable Long id)
	{
		ModelAndView view = new ModelAndView();
		view.addObject("alumno", alumnoDao.find(id));
		view.setViewName("alumno/notas");
		return view;
	}
	
	@RequestMapping("/{id}/avance_curricular.html")
	public ModelAndView avance_curricular(@PathVariable Long id)
	{
		ModelAndView view = new ModelAndView();
		AvanceCurricularService service = new AvanceCurricularService();
		service.cargar_datos(id, alumnoDao);
		view.addObject("service", service);
		view.setViewName("alumno/avance_curricular");
		return view;
	}

	@RequestMapping("/add.html")
	public ModelAndView add() {
		ModelAndView view = new ModelAndView();
		view.addObject("alumno", new Alumno());
		view.setViewName("alumno/edit");
		return view;
	}

	@RequestMapping(value = "/save.html", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("alumno") @Valid Alumno Alumno, BindingResult result, SessionStatus status) {
		if (Alumno.getId() == null) {
			alumnoDao.persist(Alumno);
			status.setComplete();
		}
		else {
			alumnoDao.merge(Alumno);
			status.setComplete();
		}
		return new ModelAndView(result.getErrorCount() > 0 ? "alumno/edit" : "redirect:list.html");
//		return new ModelAndView("Alumno/save");
	}
}
