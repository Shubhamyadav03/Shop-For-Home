package com.shopforhome.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopforhome.models.Admin;
import com.shopforhome.repos.AdminRepository;

@Service
public class AdminService {
	
	@Autowired AdminRepository adminrepository;
//admin login is perform by this
	public Admin validate(String userid, String pwd) {
		Optional<Admin> admin=adminrepository.findById(userid);
		if(admin.isPresent() && admin.get().getPwd().equals(pwd)) {
			return admin.get();
		}
		return null;
	}
	


	public void updateAdmin(Admin admin) {
		if(admin.getPwd().equals("") || admin.getPwd()==null) {
			admin.setPwd(adminrepository.findById(admin.getUserid()).get().getPwd());
		}
		adminrepository.save(admin);		
	}
	
	public long count() {
		return adminrepository.count();
	}
}
