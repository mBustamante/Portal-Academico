package is2.service;

import is2.repository.AdminDao;
import is2.repository.AlumnoDao;
import is2.repository.DocenteDao;
import is2.domain.Admin;
import is2.domain.Alumno;
import is2.domain.Docente;

import java.util.Collections;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;



public class UserService implements UserDetailsService {
	
	@Autowired
	AdminDao adminDao;
	
	@Autowired
	AlumnoDao alumnoDao;
	
	@Autowired
	DocenteDao docenteDao;
	
	@PostConstruct	
	protected void initialize() {
		/*Account user = accountDao.findByEmail("user");
		if(user == null)
			accountDao.persist(new Account("user", "demo", "ROLE_USER"));
		Account admin = accountDao.findByEmail("user");
		if(admin == null)
			accountDao.persist(new Account("admin", "admin", "ROLE_ADMIN"));
		*/
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Admin admin= adminDao.findByUsername(username);
		Docente docente= docenteDao.findByUsername(username);
		Alumno alumno= alumnoDao.findByUsername(username);
		if (alumno!=null){
			return createUser(alumno);
		}
		else{
			if (docente!=null){
				return createUser(docente);
			}
			else{
				if (admin!=null){
					return createUser(admin);
				}
				else throw new UsernameNotFoundException("Usuario no encontrado");
			}
		}
	}
	
	public void signin(Admin account) {
		SecurityContextHolder.getContext().setAuthentication(authenticate(account));
	}
	
	public void signin(Docente account) {
		SecurityContextHolder.getContext().setAuthentication(authenticate(account));
	}
	
	public void signin(Alumno account) {
		SecurityContextHolder.getContext().setAuthentication(authenticate(account));
	}
	
	private Authentication authenticate(Admin account) {
		return new UsernamePasswordAuthenticationToken(createUser(account), null, Collections.singleton(createAuthority(account)));		
	}
	
	private Authentication authenticate(Docente account) {
		return new UsernamePasswordAuthenticationToken(createUser(account), null, Collections.singleton(createAuthority(account)));		
	}
	
	private Authentication authenticate(Alumno account) {
		return new UsernamePasswordAuthenticationToken(createUser(account), null, Collections.singleton(createAuthority(account)));		
	}
	
	private User createUser(Admin account) {
		return new User(account.getUsuario(), account.getPassword(), Collections.singleton(createAuthority(account)));
	}
	
	private User createUser(Docente account) {
		return new User(account.getUsuario(), account.getPassword(), Collections.singleton(createAuthority(account)));
	}
	
	private User createUser(Alumno account) {
		return new User(account.getUsuario(), account.getPassword(), Collections.singleton(createAuthority(account)));
	}

	private GrantedAuthority createAuthority(Admin account) {
		return new SimpleGrantedAuthority(account.getRole());
	}
	
	private GrantedAuthority createAuthority(Docente account) {
		return new SimpleGrantedAuthority(account.getRole());
	}
	
	private GrantedAuthority createAuthority(Alumno account) {
		return new SimpleGrantedAuthority(account.getRole());
	}

}
