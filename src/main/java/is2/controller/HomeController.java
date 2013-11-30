package is2.controller;

import is2.repository.AdminDao;
import is2.repository.AlumnoDao;
import is2.repository.DocenteDao;

import java.io.IOException;
import java.security.Principal;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	@Inject
	AlumnoDao alumnoDao;
	@Inject
	AdminDao admiDao;
	@Inject
	DocenteDao docenteDao;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public void index(Principal principal, HttpServletResponse response) throws IOException {
		
		if (principal==null){
			response.sendRedirect("home.html");
		}
		else{
			String username = principal.getName();
			if(alumnoDao.findByUsername(username) != null){
				response.sendRedirect("alumno/home.html");
			}
			else{
				if(docenteDao.findByUsername(username) != null){
					response.sendRedirect("docente/home.html");
				}
				else  response.sendRedirect("admin/home.html");
			}
		}
	}
	@RequestMapping("/home.html")
	public ModelAndView home(HttpServletResponse response) throws IOException {
		return new ModelAndView("home"); 
	}
	
	@RequestMapping("/alumno/home.html")
	public ModelAndView homeAlumno(HttpServletResponse response) throws IOException {
		return new ModelAndView("alumno/home"); 
	}
	
	@RequestMapping("/docente/home.html")
	public ModelAndView homeDocente(HttpServletResponse response) throws IOException {
		return new ModelAndView("docente/home"); 
	}
	
	@RequestMapping("/admin/home.html")
	public ModelAndView homeAdministrator(HttpServletResponse response) throws IOException {
		return new ModelAndView("admin/home"); 
	}
}
