package is2.service;

import is2.domain.Admin;
import is2.repository.AdminDao;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

@Service
public class AdminService {

	@Inject
	AdminDao adminDao;
	
	public Admin find(Long id){
		return adminDao.find(id);
	}
	
	public Admin findByUsername(String username){
		return adminDao.findByUsername(username);
	}
}
