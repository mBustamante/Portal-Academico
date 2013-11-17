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

@Controller
@RequestMapping("/student")
public class StudentController {

	@Inject
	AlumnoDao studentDao;

	@Inject
	Validator validator;

	@RequestMapping("/list.html")
	public ModelAndView list() {
		return new ModelAndView("student/list", "students", studentDao.findAll());
	}

	@RequestMapping("/{id}/details.html")
	public ModelAndView details(@PathVariable Long id) {
		ModelAndView view = new ModelAndView();
		view.addObject("student", studentDao.find(id));
		view.setViewName("student/details");
		return view;
	}

	@RequestMapping("/{id}/edit.html")
	public ModelAndView edit(@PathVariable Long id) {
		ModelAndView view = new ModelAndView();
		view.addObject("student", studentDao.find(id));
		view.setViewName("student/edit");
		return view;
	}

	@RequestMapping("/add.html")
	public ModelAndView add() {
		ModelAndView view = new ModelAndView();
		view.addObject("student", new Alumno());
		view.setViewName("student/edit");
		return view;
	}

	@RequestMapping(value = "/save.html", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("student") @Valid Alumno Student, BindingResult result, SessionStatus status) {
		if (Student.getId() == null) {
			studentDao.persist(Student);
			status.setComplete();
		}
		else {
			studentDao.merge(Student);
			status.setComplete();
		}
		return new ModelAndView(result.getErrorCount() > 0 ? "student/edit" : "redirect:list.html");
//		return new ModelAndView("Student/save");
	}
}
