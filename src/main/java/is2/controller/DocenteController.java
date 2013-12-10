package is2.controller;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import is2.domain.Docente;
import is2.domain.Nota;
import is2.service.CursoDictadoService;
import is2.service.DocenteService;
import is2.service.HorarioDocenteService;
import is2.service.MatriculaService;
import is2.service.NotaService;

@Controller
@RequestMapping("/docente")
public class DocenteController {

	
	@Inject 
	NotaService notaService;
	
	@Inject
	MatriculaService matriculaService;
	
	@Inject
	CursoDictadoService cursoDictadoService;
	
	@Inject
	DocenteService docenteService;	

	@Inject
	Validator validator;
	
	@Inject
	HorarioDocenteService horarioDocenteService;

	@RequestMapping("/details.html")
	public ModelAndView details() {
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Docente docente = docenteService.findByUsername(user.getUsername());
		ModelAndView view = new ModelAndView();
		view.addObject("docente", docente);
		view.setViewName("docente/details");
		return view;
	}
	
	@RequestMapping("/horario.html")
	public ModelAndView horario() {
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Docente docente = docenteService.findByUsername(user.getUsername());
		ModelAndView view = new ModelAndView();
        view.addObject("docente",docente);
        view.addObject("cursosDictados", horarioDocenteService.getCursosDictados(docente.getId()));
        view.setViewName("docente/horario");
        return view;
	}
	
	@RequestMapping("/cursos.html")
	public ModelAndView cursos() {
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Docente docente = docenteService.findByUsername(user.getUsername());
		ModelAndView view = new ModelAndView();
		view.addObject("docente", docente);
		view.addObject("cursosDictados", docenteService.getCursosDictados(docente.getId()));
		view.setViewName("docente/cursos");
		return view;
	}
	
	@RequestMapping("/{id}/alumnos.html")
	public ModelAndView alumnos(@PathVariable Long id) {
		ModelAndView view = new ModelAndView();
		view.addObject("curso", cursoDictadoService.find(id));
		view.setViewName("docente/alumnos");
		return view;
	}
	
	@RequestMapping("/{id_matricula}/notas.html")
	public ModelAndView notas(@PathVariable Long id_matricula) {
		ModelAndView view = new ModelAndView();
		view.addObject("matricula", matriculaService.find(id_matricula));
		view.setViewName("docente/notas");
		return view;
	}
	
	@RequestMapping("/{id_nota}/editar_nota.html")
	public ModelAndView editar_nota(@PathVariable Long id_nota) {
		ModelAndView view = new ModelAndView();
		view.addObject("nota", notaService.find(id_nota));
		view.setViewName("docente/editar_nota");
		return view;
	}

	@RequestMapping("/edit.html")
	public ModelAndView edit() {
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Docente docente = docenteService.findByUsername(user.getUsername());
		ModelAndView view = new ModelAndView();
		view.addObject("docente", docente);
		view.setViewName("docente/edit");
		return view;
	}

	@RequestMapping("/add.html")
	public ModelAndView add() {
		ModelAndView view = new ModelAndView();
		view.addObject("docente", new Docente());
		view.setViewName("docente/edit");
		return view;
	}
	
	@RequestMapping(value = "/save_nota.html", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("nota") @Valid Nota nota, BindingResult result, SessionStatus status) {
		if (nota.getId() == null) {
			notaService.persist(nota);
			status.setComplete();
		}
		else {
			nota = notaService.cambiar_nota(nota.getId(), nota.getNota());
			status.setComplete();
		}
		return new ModelAndView("redirect:"+nota.getMatricula().getId()+"/notas.html");
	}

	@RequestMapping(value = "/save.html", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("docente") @Valid Docente docente, BindingResult result, SessionStatus status) {
		if( docente.getPassword() != "" ){
			docenteService.encodePassword(docente);
			docenteService.merge(docente);
		}
		else
			docenteService.merge_sin_password(docente);
		status.setComplete();
		return new ModelAndView("redirect:details.html");
	}
}
