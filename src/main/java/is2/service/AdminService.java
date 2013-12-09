package is2.service;

import java.util.List;

import is2.domain.Admin;
import is2.repository.AdminDao;

import javax.inject.Inject;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

	@Inject
	AdminDao adminDao;
	
	@Inject 
	PasswordEncoder encoder;
	
	public Admin find(Long id){
		return adminDao.find(id);
	}
	
	public Admin findByUsername(String username){
		return adminDao.findByUsername(username);
	}
	public List<Admin> findAll()
	{
		return adminDao.findAll();
	}
	
	public Admin persist(Admin admin)
	{
		return adminDao.persist(admin);
	}
	
	public Admin merge(Admin admin)
	{
		return adminDao.persist(admin);
	}
	
	public Admin encodePassword(Admin admin){
		admin.setPassword(encoder.encode(admin.getPassword()));
		return admin;
	}
	
}
