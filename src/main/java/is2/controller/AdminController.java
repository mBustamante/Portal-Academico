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

import is2.domain.Admin;
import is2.repository.AdminDao;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Inject
	AdminDao adminDao;

	@Inject
	Validator validator;

	@RequestMapping("/list.html")
	public ModelAndView list() {
		return new ModelAndView("admin/list", "admins", adminDao.findAll());
	}

	@RequestMapping("/{id}/details.html")
	public ModelAndView details(@PathVariable Long id) {
		ModelAndView view = new ModelAndView();
		view.addObject("admin", adminDao.find(id));
		view.setViewName("admin/details");
		return view;
	}

	@RequestMapping("/{id}/edit.html")
	public ModelAndView edit(@PathVariable Long id) {
		ModelAndView view = new ModelAndView();
		view.addObject("admin", adminDao.find(id));
		view.setViewName("admin/edit");
		return view;
	}

	@RequestMapping("/add.html")
	public ModelAndView add() {
		ModelAndView view = new ModelAndView();
		view.addObject("admin", new Admin());
		view.setViewName("admin/edit");
		return view;
	}

	@RequestMapping(value = "/save.html", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("admin") @Valid Admin Admin, BindingResult result, SessionStatus status) {
		if (Admin.getId() == null) {
			adminDao.persist(Admin);
			status.setComplete();
		}
		else {
			adminDao.merge(Admin);
			status.setComplete();
		}
		return new ModelAndView(result.getErrorCount() > 0 ? "admin/edit" : "redirect:list.html");
//		return new ModelAndView("Admin/save");
	}
}
