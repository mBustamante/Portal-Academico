package is2.controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import is2.repository.AdminDao;
import is2.repository.AlumnoDao;

@Controller
public class SessionController {

	@Inject
	AlumnoDao userDao;
	@Inject
	AdminDao admiDao;

	@RequestMapping(value = "/auth.html", method = RequestMethod.POST)
	public void login(String username, String password, HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println(password);
		if(userDao.existsUser(username, password)){
			request.getSession().setAttribute("id_user", userDao.findByUsername(String.valueOf(username)).getId());
			request.getSession().setAttribute("username", String.valueOf(username));
			response.sendRedirect("homeAlumno.html");
		}
		else
		{
			System.out.println("No es alumno");
				if(admiDao.existsAdministrator(username, password)){
					request.getSession().setAttribute("id_admi", admiDao.findByUsername(String.valueOf(username)).getId());
					request.getSession().setAttribute("username", String.valueOf(username));
					response.sendRedirect("homeDocente.html");
				}
				else{
				System.out.println("No es nada");
				request.getSession().setAttribute("username", null);
				response.sendRedirect("signin");
				}
		}	
	}

	@RequestMapping("/logout.html")
	public void logout(HttpServletResponse response, HttpServletRequest request) throws IOException {
		request.getSession().setAttribute("id_admi", null);
		request.getSession().setAttribute("username", null);
		response.sendRedirect("home.html");
	}

	@RequestMapping("/homeAlumno.html")
	public ModelAndView home(HttpServletResponse response) throws IOException {
		return new ModelAndView("homeAlumno"); 
	}
	
	@RequestMapping("/homeDocente.html")
	public ModelAndView homeAdministrator(HttpServletResponse response) throws IOException {
		return new ModelAndView("homeDocente"); 
	}
}
