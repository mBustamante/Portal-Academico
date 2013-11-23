package is2.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import is2.repository.AlumnoDao;
import is2.repository.AdminDao;

public class AuthenticationInterceptor implements HandlerInterceptor {

	@Inject
	AlumnoDao userDao;
	@Inject
	AdminDao admiDao;
	
	@Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {
	  return true;
  }

	@Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
      ModelAndView modelAndView) throws Exception {
		String username = (String)request.getSession().getAttribute("username");
		System.out.println(username);
		if (username == null) {
			System.out.println("No hay sesion");
			if (!request.getRequestURL().toString().endsWith("signin")){
				response.sendRedirect(request.getContextPath() + "/signin.html");
			}
		}
		
		else{
			if(userDao.existsByUsername(username)){
				System.out.println("es un usuario!");
				if(!request.getRequestURL().toString().endsWith("signin")&&
				   request.getRequestURL().toString().contains("Docente")){
					System.out.println("no puedes!");
					response.sendRedirect(request.getContextPath() + "/");
				}
			}
			else{
				if(admiDao.existsByUsername(username)){
					System.out.println("es un administrador");
					if(!request.getRequestURL().toString().endsWith("signin")&&
							   request.getRequestURL().toString().contains("Alumno")){
								System.out.println("no puedes!");
								response.sendRedirect(request.getContextPath() + "/");
					}
				}
			}
		}
  }

	@Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
      Object handler, Exception ex) throws Exception {
  }

}
