package is2.service;

import java.util.List;

import is2.domain.Alumno;
import is2.repository.AlumnoDao;
import is2.repository.RoleDao;

import javax.inject.Inject;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AlumnoService {
	
	@Inject
	PasswordEncoder encoder;

	@Inject
	AlumnoDao alumnoDao;
	
	@Inject
	RoleDao roleDao;
	
	public Alumno find(Long id){
		return alumnoDao.find(id);
	}
	
	public List<Alumno>  findAll()
	{
		return alumnoDao.findAll();
	}
	
	public Alumno findByUsername(String username)
	{
		return alumnoDao.findByUsername(username);
	}
	public Alumno persist(Alumno alumno)
	{
		alumno.setRole(roleDao.findByRole("ROLE_ALUMNO"));
		return alumnoDao.persist(alumno);
	}
	
	public Alumno merge(Alumno alumno)
	{
		return alumnoDao.merge(alumno);
	}
	
	public Alumno encodePassword(Alumno alumno){
		System.out.println("ed6296326e7e82dab1a737d129ee74e314911403ac305a2e1ed18826d4165dec644f58cd3aea272a");
		System.out.println(encoder.matches("pass", "ed6296326e7e82dab1a737d129ee74e314911403ac305a2e1ed18826d4165dec644f58cd3aea272a"));
		alumno.setPassword(encoder.encode(alumno.getPassword()));
		System.out.println(alumno.getPassword());
		System.out.println(encoder.matches("pass", alumno.getPassword()));
		return alumno;
	}
	
	public Alumno merge_sin_password(Alumno alumno){
		Alumno original = find(alumno.getId());
		alumno.setPassword(original.getPassword());
		return merge(alumno);
	}
	
}
