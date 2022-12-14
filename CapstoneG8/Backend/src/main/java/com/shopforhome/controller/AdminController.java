package com.shopforhome.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopforhome.dtos.LoginDTO;
import com.shopforhome.dtos.Response;
import com.shopforhome.models.Admin;
import com.shopforhome.services.AdminService;

@CrossOrigin
@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired AdminService adminService;
	
	@PostMapping("/validate")
	public ResponseEntity<?> validateUser(@RequestBody LoginDTO login) {
		System.out.println(login);
		Admin admin=adminService.validate(login.getUserid(),login.getPwd());
		if(admin!=null)
			return Response.success(admin);
		else
			return Response.status(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping
	public ResponseEntity<?> updateProfile(@RequestBody Admin admin) {
		adminService.updateAdmin(admin);
		return Response.status(HttpStatus.OK);
	}

}
